package com.employeemanagement.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * This is DTO for the Employee entity.
 */

public class EmployeeInDto {

    /**
     * employee id given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_EMP_ID)
    @Pattern(regexp = "^N(?!0000)[0-9]{4}$",
    message = ErrorConstant.INVALID_EMP_ID)
    private String empId;
    /**
     * employee name given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_NAME)
    @Pattern(regexp = "^[A-Za-z\\s]+$", message = ErrorConstant.INVALID_NAME)
    private String empName;
    /**
     * employee email given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_EMAIL)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$",
    message = ErrorConstant.INVALID_EMAIL)
    private String empEmail;
    /**
     * employee DOB given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_DOB)
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-"
            + "(19|20)\\d\\d$", message = ErrorConstant.INVALID_DOB)
    private String empDob;
    /**
     * employee DOJ given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_DOJ)
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-"
            + "(19|20)\\d\\d$", message = ErrorConstant.INVALID_DOJ)
    private String empDoj;
    /**
     * employee location given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_LOCATION)
    private String empLocation;
    /**
     * employee designation given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_DESIGNATION)
    private String empDesignation;
    /**
     * employee contact number given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_CONTACT)
    @Pattern(regexp = "^\\d{10}$", message = ErrorConstant.INVALID_CONTACT)
    private String empContactNo;
    /**
     * employee password given by user.
     */
    private String empPassword;

    /**
     * stores employee role.
     */
    @NotBlank(message = ErrorConstant.EMPTY_ROLE)
    private String empRole;

    /**
     * stores skills of employee.
     */
    private List<String> empSkills = new ArrayList<>();

    /**
     * stores employee project.
     */
    private List<Long> empProjectId;

    /**
     * stores manger for employee.
     */
    private Long empManagerId;

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(empContactNo, empDesignation, empDob, empDoj,
                empEmail, empId, empLocation, empManagerId, empName,
                empPassword, empProjectId, empRole, empSkills);
    }

    /**
     * Used to get value of object.
     */
    @Override
    public String toString() {
        return "EmployeeInDto [empId=" + empId + ", empName=" + empName
                + ", empEmail=" + empEmail + ", empDob=" + empDob + ", empDoj="
                + empDoj + ", empLocation=" + empLocation + ", empDesignation="
                + empDesignation + ", empContactNo=" + empContactNo
                + ", empPassword=" + empPassword + ", empRole=" + empRole
                + ", empSkills=" + empSkills + ", empProject=" + empProjectId
                + ", empManager=" + empManagerId + "]";
    }

    /**
     * Used to compare objects.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EmployeeInDto other = (EmployeeInDto) obj;
        return Objects.equals(empContactNo, other.empContactNo)
                && Objects.equals(empDesignation, other.empDesignation)
                && Objects.equals(empDob, other.empDob)
                && Objects.equals(empDoj, other.empDoj)
                && Objects.equals(empEmail, other.empEmail)
                && Objects.equals(empId, other.empId)
                && Objects.equals(empLocation, other.empLocation)
                && Objects.equals(empManagerId, other.empManagerId)
                && Objects.equals(empName, other.empName)
                && Objects.equals(empPassword, other.empPassword)
                && Objects.equals(empProjectId, other.empProjectId)
                && Objects.equals(empRole, other.empRole)
                && Objects.equals(empSkills, other.empSkills);
    }

    /**
     * Get the list of skills associated with the employee.
     *
     * @return A list of skills possessed by the employee.
     */
    public List<String> getEmpSkills() {
        return new ArrayList<>(empSkills);
    }

    /**
     * Set the list of skills for the employee.
     *
     * @param skills The new list of skills for the employee.
     */
    public void setEmpSkills(final List<String> skills) {
        this.empSkills = new ArrayList<>(skills);
    }

    /**
     * Get the unique identifier (ID) of the employee.
     *
     * @return The employee's unique ID.
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * Set the unique identifier (ID) for the employee.
     *
     * @param employeeId The new ID for the employee.
     */
    public void setEmpId(final String employeeId) {
        this.empId = employeeId;
    }

    /**
     * Get the name of the employee.
     *
     * @return The employee's name.
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * Set the name of the employee.
     *
     * @param employeeName The new name for the employee.
     */
    public void setEmpName(final String employeeName) {
        this.empName = employeeName;
    }

    /**
     * Get the email address of the employee.
     *
     * @return The employee's email address.
     */
    public String getEmpEmail() {
        return empEmail;
    }

    /**
     * Set the email address of the employee.
     *
     * @param employeeEmail The new email address for the employee.
     */
    public void setEmpEmail(final String employeeEmail) {
        this.empEmail = employeeEmail;
    }

    /**
     * Get the date of birth of the employee.
     *
     * @return The employee's date of birth.
     */
    public String getEmpDob() {
        return empDob;
    }

    /**
     * Set the date of birth of the employee.
     *
     * @param employeeDob The new date of birth for the employee.
     */
    public void setEmpDob(final String employeeDob) {
        this.empDob = employeeDob;
    }

    /**
     * Get the date of joining of the employee.
     *
     * @return The employee's date of joining.
     */
    public String getEmpDoj() {
        return empDoj;
    }

    /**
     * Set the date of joining of the employee.
     *
     * @param employeeDoj The new date of joining for the employee.
     */
    public void setEmpDoj(final String employeeDoj) {
        this.empDoj = employeeDoj;
    }

    /**
     * Get the location or office address of the employee.
     *
     * @return The employee's location.
     */
    public String getEmpLocation() {
        return empLocation;
    }

    /**
     * Set the location or office address of the employee.
     *
     * @param employeeLocation The new location for the employee.
     */
    public void setEmpLocation(final String employeeLocation) {
        this.empLocation = employeeLocation;
    }

    /**
     * Get the job designation or title of the employee.
     *
     * @return The employee's job designation.
     */
    public String getEmpDesignation() {
        return empDesignation;
    }

    /**
     * Set the job designation or title of the employee.
     *
     * @param employeeDesignation The new job designation for the employee.
     */
    public void setEmpDesignation(final String employeeDesignation) {
        this.empDesignation = employeeDesignation;
    }

    /**
     * Get the contact number of the employee.
     *
     * @return The employee's contact number.
     */
    public String getEmpContactNo() {
        return empContactNo;
    }

    /**
     * Set the contact number of the employee.
     *
     * @param employeeContactNo The new contact number for the employee.
     */
    public void setEmpContactNo(final String employeeContactNo) {
        this.empContactNo = employeeContactNo;
    }

    /**
     * Get the login password of the employee.
     *
     * @return The employee's login password.
     */
    public String getEmpPassword() {
        return empPassword;
    }

    /**
     * Set the login password of the employee.
     *
     * @param employeePassword The new login password for the employee.
     */
    public void setEmpPassword(final String employeePassword) {
        this.empPassword = employeePassword;
    }

    /**
     * Get the role or position of the employee within the organization.
     *
     * @return The employee's role.
     */
    public String getEmpRole() {
        return empRole;
    }

    /**
     * Set the role or position of the employee within the organization.
     *
     * @param employeeRole The new role for the employee.
     */
    public void setEmpRole(final String employeeRole) {
        this.empRole = employeeRole;
    }

    /**
     * Set the current project or assignment of the employee.
     *
     * @return The employee's project.
     */
    public List<Long> getEmpProjectId() {
        return new ArrayList<>(empProjectId);
    }

    /**
     * Set the current project or assignment of the employee.
     *
     * @param employeeProjectId The new project for the employee.
     */
    public void setEmpProjectId(final List<Long> employeeProjectId) {
        this.empProjectId = new ArrayList<>(employeeProjectId);
    }

    /**
     * Get the manager or supervisor of the employee.
     *
     * @return The employee's manager.
     */
    public Long getEmpManagerId() {
        return empManagerId;
    }

    /**
     * Set the manager or supervisor of the employee.
     *
     * @param employeeManagerId The new manager for the employee.
     */
    public void setEmpManagerId(final Long employeeManagerId) {
        this.empManagerId = employeeManagerId;
    }

}
