package com.employeemanagement.backend.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.customexception.UnauthorizedAccessException;
import com.employeemanagement.backend.dto.AssignProjectInDto;
import com.employeemanagement.backend.dto.AssignProjectToEmployeeInDto;
import com.employeemanagement.backend.dto.EmployeeInDto;
import com.employeemanagement.backend.dto.EmployeeLoginDto;
import com.employeemanagement.backend.dto.SearchFilteredEmployeeInDto;
import com.employeemanagement.backend.dto.UpdateSkillsInDto;
import com.employeemanagement.backend.inputcheck.InputFieldChecks;
import com.employeemanagement.backend.inputcheck.ProjectInputCheck;

import jakarta.validation.Valid;

/**
 * Class to validate employee data.
 */
@Component
public class EmployeeValidator {

    /**
     * creating object of InputFieldChecks to check input.
     */
    @Autowired
    private InputFieldChecks inputFieldChecks;
    /**
     * Object for project check.
     */
    @Autowired
    private ProjectInputCheck projectInputCheck;

    /**
     * Used to validate admin data.
     *
     * @param employeeInDto Takes employeeDto.
     * @throws InvalidInputException     Throw exception if input is invalid.
     * @throws DataAlreadyExistException Throw exception if data is already
     *                                   exist.
     */
    public void addAdminValidator(final EmployeeInDto employeeInDto)
            throws InvalidInputException, DataAlreadyExistException {
        inputFieldChecks.checkEmpId(employeeInDto.getEmpId());
        inputFieldChecks.checkEmpName(employeeInDto.getEmpName());
        inputFieldChecks.checkDob(employeeInDto.getEmpDob());
        inputFieldChecks.checkDoj(employeeInDto.getEmpDoj());
        inputFieldChecks.checkDatesDifference(employeeInDto.getEmpDob(),
                employeeInDto.getEmpDoj());
        inputFieldChecks.checkEmpEmail(employeeInDto.getEmpEmail());
        inputFieldChecks.checkEmpLocation(employeeInDto.getEmpLocation());
        inputFieldChecks.checkEmpDesignation(employeeInDto.getEmpDesignation());
        inputFieldChecks.checkEmpContactNo(employeeInDto.getEmpContactNo());
        inputFieldChecks.checkEmpPassword(employeeInDto.getEmpContactNo());
        inputFieldChecks.checkEmployeeRole(employeeInDto.getEmpRole());
        inputFieldChecks.checkEmailExistance(employeeInDto.getEmpEmail());
        inputFieldChecks.checkEmpIdExistance(employeeInDto.getEmpId());
        inputFieldChecks
                .checkEmpContactExistance(employeeInDto.getEmpContactNo());
        inputFieldChecks.checkValidAdminEmail(employeeInDto.getEmpEmail());
    }

    /**
     * Used to validate LoginEmployee details.
     *
     * @param employeeLoginDto Takes employeeLoginDto.
     * @throws InvalidInputException       Throw exception if input is invalid.
     * @throws UnauthorizedAccessException Throws when password not match.
     */
    public void loginEmployeeValidator(final EmployeeLoginDto employeeLoginDto)
            throws InvalidInputException, UnauthorizedAccessException {
        inputFieldChecks.loginValidation(employeeLoginDto.getEmpEmail(),
                employeeLoginDto.getEmpPassword());
    }

    /**
     * Used to validate add employee data.
     *
     * @param employeeInDto Takes employeeDto.
     * @throws InvalidInputException     Throw exception if input is invalid.
     * @throws DataAlreadyExistException Throw exception if data is already
     *                                   exist.
     */
    public void addEmployeeValidator(final EmployeeInDto employeeInDto)
            throws InvalidInputException, DataAlreadyExistException {
        inputFieldChecks.checkEmpId(employeeInDto.getEmpId());
        inputFieldChecks.checkEmpName(employeeInDto.getEmpName());
        inputFieldChecks.checkDob(employeeInDto.getEmpDob());
        inputFieldChecks.checkDoj(employeeInDto.getEmpDoj());
        inputFieldChecks.checkDatesDifference(employeeInDto.getEmpDob(),
                employeeInDto.getEmpDoj());
        inputFieldChecks.checkEmpEmail(employeeInDto.getEmpEmail());
        inputFieldChecks.checkEmpLocation(employeeInDto.getEmpLocation());
        inputFieldChecks.checkEmpDesignation(employeeInDto.getEmpDesignation());
        inputFieldChecks.checkEmployeeRole(employeeInDto.getEmpRole());
        inputFieldChecks.checkEmpSkills(employeeInDto.getEmpSkills());
        inputFieldChecks.checkEmpContactNo(employeeInDto.getEmpContactNo());
        inputFieldChecks.checkEmailExistance(employeeInDto.getEmpEmail());
        inputFieldChecks.checkEmpIdExistance(employeeInDto.getEmpId());
        inputFieldChecks
                .checkEmpContactExistance(employeeInDto.getEmpContactNo());
    }

    /**
     * Used to validate manager emId(primary key).
     *
     * @param emId Takes emId of manager.
     */
    public void getManagerByIdValidator(final Long emId) {
        inputFieldChecks.checkEmIdNotExistance(emId);
    }

    /**
     * Used to validate emId(primary key) of manager.
     *
     * @param emId Takes emId of manager.
     * @param project Takes project id.
     */
    public void assignProjectToManagerValidator(final Long emId,
            final AssignProjectInDto project) {
        inputFieldChecks.checkEmIdNotExistance(emId);
        projectInputCheck.checkProjectExistanceById(project.getEmpProjectId());
    }

    /**
     * Used to validate email id of employee.
     *
     * @param empEmail Takes email id to validate.
     */
    public void getEmployeeByEmailIdValidator(final String empEmail) {
        inputFieldChecks.checkEmailNotExistance(empEmail);
    }

    /**
     * Used to validate employee id of employee to assign project.
     *
     * @param empId Takes employee id.
     * @param assignProjectToEmployeeInDto It have project id and manager id.
     * @throws DataAlreadyExistException Throw exception if employee not exist
     *                                   or already have a project.
     * @throws InvalidInputException     Throws when not a valid manager.
     */
    public void assignProjectToEmployeeValidator(final String empId,
            final AssignProjectToEmployeeInDto assignProjectToEmployeeInDto)
            throws DataAlreadyExistException, InvalidInputException {
        inputFieldChecks.checkEmpIdNotExistance(empId);
        inputFieldChecks.checkEmployeeHaveProject(empId);
        inputFieldChecks.checkEmIdNotExistance(
                assignProjectToEmployeeInDto.getProjectManagerId());
        projectInputCheck.checkProjectExistanceById(
                assignProjectToEmployeeInDto.getProjectId());
        inputFieldChecks.checkIsManagerByemId(
                assignProjectToEmployeeInDto.getProjectManagerId());
    }

    /**
     * Used to validate email of employee.
     *
     * @param empEmail Takes email id of employee.
     * @param updatedSkills Takes skills.
     * @throws InvalidInputException Throw if skills not match.
     */
    public void updateEmployeeSkillsValidator(final String empEmail,
            final UpdateSkillsInDto updatedSkills)
                    throws InvalidInputException {
        inputFieldChecks.checkEmailNotExistance(empEmail);
        inputFieldChecks.checkEmpSkills(updatedSkills.getSkills());
    }

    /**
     * Used to check dto of unassignproejct function of controller.
     *
     * @param employeeId Takes employeeId.
     * @throws InvalidInputException Throw exception if employeeId not exist or
     *                               itr role is not Employee.
     */
    public void unAssignProjectToEmployeeValidator(final String employeeId)
            throws InvalidInputException {
        // TODO Auto-generated method stub
        inputFieldChecks.checkEmpIdNotExistance(employeeId);
        inputFieldChecks.checkRoleEmployeeByEmpId(employeeId);
        inputFieldChecks.checkHaveProjectByEmpId(employeeId);
    }

    /**
     * Used to check dto of filteredEmployee function of controller.
     *
     * @param filterDto Takes skills for filter.
     * @throws InvalidInputException Throw if skills are not valid.
     */
    public void filteredEmployeeValidator(
            @Valid final SearchFilteredEmployeeInDto filterDto)
                    throws InvalidInputException {
        if(filterDto.getSelectedSkills().size() > 0) {
            inputFieldChecks.checkEmpSkills(filterDto.getSelectedSkills());
        }
    }
}
