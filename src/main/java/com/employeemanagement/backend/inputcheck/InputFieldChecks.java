
package com.employeemanagement.backend.inputcheck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.DataNotFoundException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.customexception.UnauthorizedAccessException;
import com.employeemanagement.backend.entity.Employee;
import com.employeemanagement.backend.enumlists.Designation;
import com.employeemanagement.backend.enumlists.Location;
import com.employeemanagement.backend.repository.EmployeeRepository;
import com.employeemanagement.backend.constantsmessages.ErrorConstant;

/**
 * Class to check if all the input fields fulfill the input requirement or not.
 */
@Component
public class InputFieldChecks {

    /**
     * minimum length of password.
     */
    private static final int MIN_PASSWORD_LENGTH = 7;

    /**
     * hashed password length.
     */
    private static final int HASHCODE_PWD_LENGTH = 20;
    /**
     * Valid age.
     */
    private static final int VALID_AGE = 18;

    /**
     * object of employee repository.
     */
    @Autowired
    private EmployeeRepository employeeRepo;

    /**
     * object of password encoder class to match password.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * check for employee id entered by user.
     *
     * @param empId getting employee id to check.
     * @throws InvalidInputException throw an exception.
     */
    public final void checkEmpId(final String empId)
            throws InvalidInputException {
        String empIdPattern = "^N\\d{4}$";
        if (empId.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_EMP_ID);
        }
        if (!Pattern.matches(empIdPattern, empId)) {
            throw new InvalidInputException(ErrorConstant.INVALID_EMP_ID);
        }
        if (empId.equals("N0000")) {
            throw new InvalidInputException(ErrorConstant.INVALID_EMP_ID_N0000);
        }
    }

    /**
     * check for date format.
     *
     * @param date get date.
     * @throws InvalidInputException throw exception if not a valid DOB.
     */
    public final void checkDob(final String date) throws InvalidInputException {
        String datePattern = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-"
                + "(19|20)\\d\\d$";
        if (date.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_DOB);
        }
        if (!Pattern.matches(datePattern, date)) {
            throw new InvalidInputException(ErrorConstant.INVALID_DOB);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date dobDate = null;
        try {
            dobDate = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new InvalidInputException(ErrorConstant.INVALID_DOB);
        }

        Date currentDate = new Date();

        if (dobDate.after(currentDate)) {
            throw new InvalidInputException(
                    ErrorConstant.INVALID_DOB_FUTURE_DATE);
        }
    }

    /**
     * check for valid DOJ.
     *
     * @param date accept a date.
     * @throws InvalidInputException throw exception if date is not in valid
     *                               format.
     */
    public final void checkDoj(final String date) throws InvalidInputException {
        String datePattern = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-"
                + "(19|20)\\d\\d$";
        if (date.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_DOJ);
        }
        if (!Pattern.matches(datePattern, date)) {
            throw new InvalidInputException(ErrorConstant.INVALID_DOJ);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date dojDate = null;
        try {
            dojDate = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new InvalidInputException(ErrorConstant.INVALID_DOJ);
        }

        Date currentDate = new Date();

        if (dojDate.after(currentDate)) {
            throw new InvalidInputException(
                    ErrorConstant.INVALID_DOJ_FUTURE_DATE);
        }
    }

    /**
     * check if DOJ is 18 year older than DOB.
     *
     * @param dob accept DOB.
     * @param doj accept DOJ.
     * @throws InvalidInputException throw an exception.
     */
    public final void checkDatesDifference(final String dob, final String doj)
            throws InvalidInputException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse(dob, formatter);
        LocalDate date2 = LocalDate.parse(doj, formatter);

        Period period = Period.between(date1, date2);

        int yearsDiff = period.getYears();
        int monthsDiff = period.getMonths();
        int daysDiff = period.getDays();

        if (yearsDiff < VALID_AGE || yearsDiff == VALID_AGE
                && (monthsDiff < 0 || monthsDiff == 0 && daysDiff < 0)) {
            throw new InvalidInputException(
                    ErrorConstant.INVALID_DATE_DIFFERENCE);
        }
    }

    /**
     * check for employee email format.
     *
     * @param empEmail getting email.
     * @throws InvalidInputException throw exception for wrong email.
     */
    public final void checkEmpEmail(final String empEmail)
            throws InvalidInputException {
        String empEmailPattern = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$";
        if (empEmail.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_EMAIL);
        }
        if (!Pattern.matches(empEmailPattern, empEmail)) {
            throw new InvalidInputException(ErrorConstant.INVALID_EMAIL);
        }
    }

    /**
     * checking for valid admin email.
     *
     * @param empEmail accept an email.
     * @throws DataAlreadyExistException throw exception if id exist or not have
     *                                   correct admin email.
     */
    public final void checkValidAdminEmail(final String empEmail)
            throws DataAlreadyExistException {
        String validEmail = "ankita.sharma@nucleusteq.com";
        if (!empEmail.equals(validEmail)) {
            String s = "admin should have email id as " + validEmail;
            throw new DataAlreadyExistException(s);
        }
    }

    /**
     * check for employee contact number.
     *
     * @param empContactNo getting employee contact.
     * @throws InvalidInputException throw exception if contact pattern not
     *                               match.
     */
    public final void checkEmpContactNo(final String empContactNo)
            throws InvalidInputException {
        String empContactNoPattern = "^\\d{10}$";
        if (empContactNo.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_CONTACT);
        }
        if (!Pattern.matches(empContactNoPattern, empContactNo)) {
            throw new InvalidInputException(ErrorConstant.INVALID_CONTACT);
        }
    }

    /**
     * check for password length.
     *
     * @param empPassword taking password to check.
     * @throws InvalidInputException throw exception if not a valid password.
     */
    public final void checkEmpPassword(final String empPassword)
            throws InvalidInputException {
        if (empPassword.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_PASSWORD);
        }
        if (empPassword.length() <= MIN_PASSWORD_LENGTH) {
            throw new InvalidInputException(ErrorConstant.INVALID_PASSWORD);
        }
    }

    /**
     * check for valid name.
     *
     * @param name getting name from user.
     * @throws InvalidInputException throw exception for wrong name.
     */
    public final void checkEmpName(final String name)
            throws InvalidInputException {
        String namePattern = "^[A-Za-z\\s]+$";
        if (name.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_NAME);
        }
        if (!Pattern.matches(namePattern, name)) {
            throw new InvalidInputException(ErrorConstant.INVALID_NAME);
        }
    }

    /**
     * check for valid location from enum list.
     *
     * @param empLocation take location.
     * @throws InvalidInputException throw exception if not an enum location.
     */
    public final void checkEmpLocation(final String empLocation)
            throws InvalidInputException {
        if (empLocation.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_LOCATION);
        }
        int flag = 0;
        for (Location designation : Location.values()) {
            if (designation.name().equals(empLocation)) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            throw new InvalidInputException(ErrorConstant.INVALID_LOCATION);
        }
    }

    /**
     * used to check for valid designation.
     *
     * @param empDesignation accept designation.
     * @throws InvalidInputException throw exception if not a valid designation.
     */
    public final void checkEmpDesignation(final String empDesignation)
            throws InvalidInputException {
        if (empDesignation.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_DESIGNATION);
        }
        int flag = 0;
        for (Designation designation : Designation.values()) {
            if (designation.name().equals(empDesignation)) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            throw new InvalidInputException(ErrorConstant.INVALID_DESIGNATION);
        }
    }

    /**
     * Check for role of employee.
     *
     * @param role Takes role.
     * @throws InvalidInputException throw exception if role is not a valid
     *                               role.
     */
    public void checkEmployeeRole(final String role)
            throws InvalidInputException {
        if (!(role.equals("Employee") || role.equals("Admin")
                || role.equals("Manager"))) {
            throw new InvalidInputException(ErrorConstant.INVALID_ROLE);
        }
    }

    /**
     * Used to check for skills.
     *
     * @param skills Takes skills.
     * @throws InvalidInputException Throw if skills are not valid.
     */
    public void checkEmpSkills(final List<String> skills)
            throws InvalidInputException {
        if (skills.size() == 0) {
            throw new InvalidInputException(ErrorConstant.EMPTY_SKILLS);
        }
        List<String> skillsList = Arrays.asList("JavaScript", "React",
                "Node.js", "Python", "Java", "HTML", "CSS", "SQL",
                "Machine Learning", "Data Analysis", "Spark", "Big data",
                "SpringBoot", "Postgres", "Snowflake", "Airflow");

        for (String skill : skills) {
            if (!skillsList.contains(skill)) {
                throw new InvalidInputException(
                        skill + ErrorConstant.INVALID_SKILLS);
            }
        }
    }

    /**
     * checks if email id is already registered or not.
     *
     * @param email takes an email id.
     * @throws DataAlreadyExistException throw an exception if email already
     *                                   registered.
     */
    public final void checkEmailExistance(final String email)
            throws DataAlreadyExistException {
        Employee employee = employeeRepo.findByEmpEmail(email);
        if (employee != null) {
            throw new DataAlreadyExistException(
                    ErrorConstant.EMAIL_ALREADY_EXIST);
        }
    }

    /**
     * checks if employee id is already registered or not.
     *
     * @param empId accepts employee Id.
     * @throws DataAlreadyExistException throw exception if id already exist.
     */
    public final void checkEmpIdExistance(final String empId)
            throws DataAlreadyExistException {
        Employee employee = employeeRepo.findByEmpId(empId);
        if (employee != null) {
            throw new DataAlreadyExistException(
                    ErrorConstant.EMPID_ALREADY_EXIST);
        }
    }

    /**
     * checks if contact number is already registered or not.
     *
     * @param empContact accept a contact number.
     * @throws DataAlreadyExistException throw exception if id already exist.
     */
    public final void checkEmpContactExistance(final String empContact)
            throws DataAlreadyExistException {
        Employee employee = employeeRepo.findByEmpContactNo(empContact);
        if (employee != null) {
            throw new DataAlreadyExistException(
                    ErrorConstant.EMPCONTACT_ALREADY_EXIST);
        }
    }

    /**
     * checks if email id not exist.
     *
     * @param email takes an email id.
     * @throws DataNotFoundException throw an exception if email not registered.
     */
    public final void checkEmailNotExistance(final String email)
            throws DataNotFoundException {
        Employee employee = employeeRepo.findByEmpEmail(email);
        if (employee == null) {
            throw new DataNotFoundException(ErrorConstant.EMAIL_NOT_EXIST);
        }
    }

    /**
     * checks for employee id not exist.
     *
     * @param empId accepts employee Id.
     * @throws DataNotFoundException throw exception if id not registered.
     */
    public final void checkEmpIdNotExistance(final String empId)
            throws DataNotFoundException {
        Employee employee = employeeRepo.findByEmpId(empId);
        if (employee == null) {
            throw new DataNotFoundException(ErrorConstant.EMPID_NOT_EXIST);
        }
    }

    /**
     * checks for employee id(primary key) not exist.
     *
     * @param emId accepts employee Id.
     * @throws DataNotFoundException throw exception if id not registered.
     */
    public final void checkEmIdNotExistance(final Long emId)
            throws DataNotFoundException {
        Employee employee = employeeRepo.findByEmId(emId);
        if (employee == null) {
            throw new DataNotFoundException(ErrorConstant.EMID_NOT_EXIST);
        }
    }

    /**
     * checks if contact number is already registered or not.
     *
     * @param empContact accept a contact number.
     * @throws DataNotFoundException throw exception if contact not registered.
     */
    public final void checkEmpContactNotExistance(final String empContact)
            throws DataNotFoundException {
        Employee employee = employeeRepo.findByEmpContactNo(empContact);
        if (employee == null) {
            throw new DataNotFoundException(ErrorConstant.EMPCONTACT_NOT_EXIST);
        }
    }

    /**
     * used to check password is hashed or not.
     *
     * @param password accept password.
     * @return return boolean value after check.
     */
    public final boolean isPossiblyHashed(final String password) {
        return password.length() > HASHCODE_PWD_LENGTH
                && !password.matches("[a-zA-Z0-9]+");
    }

    /**
     * Login validation.
     *
     * @param empEmail email for login.
     * @param password password for login.
     * @throws InvalidInputException       throw exception if not match.
     * @throws UnauthorizedAccessException Throw exception.
     */
    public final void loginValidation(final String empEmail,
            final String password)
            throws InvalidInputException, UnauthorizedAccessException {
        Employee employee = employeeRepo.findByEmpEmail(empEmail);

        InputFieldChecks inputFieldChecks = new InputFieldChecks();
        inputFieldChecks.checkEmpEmail(empEmail);

        if (employee == null) {
            throw new DataNotFoundException(ErrorConstant.EMAIL_NOT_EXIST);
        }

        byte[] decodedBytes = null;
        String decodedPassword = null;
        try {
            decodedBytes = Base64.getDecoder().decode(password);
            decodedPassword = new String(decodedBytes,
                    java.nio.charset.StandardCharsets.UTF_8);
        } catch (Exception exception) {
            throw new UnauthorizedAccessException(
                    ErrorConstant.INVALID_PASSWORD);
        }
        if (!passwordEncoder.matches(decodedPassword,
                employee.getEmpPassword())) {
            throw new UnauthorizedAccessException(
                    ErrorConstant.INCORRECT_PASSWORD);
        }
    }

    /**
     * checking and creating password when we add employee.
     *
     * @param password takes password field.
     * @param empId    takes imployee id to generate password.
     * @param dob      takes dob to generate password.
     * @return correct password.
     */
    public final String checkAddEmployeePassword(final String password,
            final String empId, final String dob) {
        if (password == null || password.equals("")) {
            String[] splitDob = dob.split("-");
            return empId + "@" + splitDob[0] + splitDob[1] + splitDob[2];
        } else {
            return password;
        }
    }

    /**
     * Used to check for manager by id.
     *
     * @param managerId Takes manager id.
     * @throws InvalidInputException Throw exception if not exist.
     */
    public void checkIsManagerByemId(final Long managerId)
            throws InvalidInputException {
        Employee employee = employeeRepo.findByEmId(managerId);
        if (!employee.getEmpRole().equals("Manager")) {
            throw new InvalidInputException(ErrorConstant.NOT_A_MANAGER);
        }
    }

    /**
     * Used to check/validate Role of employee by its empId.
     *
     * @param employeeId Takes employeeId(empId).
     * @throws InvalidInputException Throw exception if its role is not
     *                               Employee.
     */
    public void checkRoleEmployeeByEmpId(final String employeeId)
            throws InvalidInputException {
        // TODO Auto-generated method stub
        Employee employee = employeeRepo.findByEmpId(employeeId);
        if (!employee.getEmpRole().equals("Employee")) {
            throw new InvalidInputException(ErrorConstant.NOT_AN_EMPLOYEE);
        }
    }

    /**
     * Used to check if employee not have any projects.
     *
     * @param employeeId Takes employee id.
     */
    public void checkHaveProjectByEmpId(final String employeeId) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepo.findByEmpId(employeeId);
        if (employee.getEmpProjectId().size() == 0) {
            throw new DataNotFoundException(
                    ErrorConstant.EMPLOYEE_NOT_HAVE_PROJECT);
        }
    }

    /**
     * Used to check if employee not having any project assigned.
     *
     * @param empId Takes employee id.
     * @throws DataAlreadyExistException Throw exception if employee already
     *                                   have projects.
     */
    public void checkEmployeeHaveProject(final String empId)
            throws DataAlreadyExistException {
        // TODO Auto-generated method stub
        Employee employee = employeeRepo.findByEmpId(empId);
        if (employee.getEmpProjectId().size() > 0) {
            throw new DataAlreadyExistException(
                    ErrorConstant.EMPLOYEE_HAVE_PROJECT);
        }
    }

    /**
     * Check for manager by email id.
     *
     * @param managerEmail Takes manager email id.
     * @throws InvalidInputException Throw if role is not manager.
     */
    public void checkIsManagerByEmailId(final String managerEmail)
            throws InvalidInputException {
        // TODO Auto-generated method stub
        Employee manager = employeeRepo.findByEmpEmail(managerEmail);
        if (!manager.getEmpRole().equals("Manager")) {
            throw new InvalidInputException(ErrorConstant.NOT_A_MANAGER);
        }
    }
}
