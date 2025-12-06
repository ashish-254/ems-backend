package com.employeemanagement.backend.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.dto.ReqResouceForEmployeeCheckInDto;
import com.employeemanagement.backend.dto.RequestAcceptInDto;
import com.employeemanagement.backend.dto.RequestResourceInDto;
import com.employeemanagement.backend.inputcheck.InputFieldChecks;
import com.employeemanagement.backend.inputcheck.ProjectInputCheck;
import com.employeemanagement.backend.inputcheck.RequestResourceInputCheck;

import jakarta.validation.Valid;

/**
 * Class used to validate request resourse controller function's arguments.
 */
@Component
public class RequestResourceValidator {

    /**
     * Object for checking fields.
     */
    @Autowired
    private RequestResourceInputCheck requestResourceInputCheck;
    /**
     * Object of inputFieldChecks for the validation for employee.
     */
    @Autowired
    private InputFieldChecks inputFieldCheck;
    /**
     * Object of ProjectInputCheck for the validation for project.
     */
    @Autowired
    private ProjectInputCheck projectInputCheck;

    /**
     * Used to validate New resourse request.
     *
     * @param requestResponseInput Takes new reqest dto.
     * @throws DataAlreadyExistException Throw exception if manager or employee
     *                                   already have project.
     * @throws InvalidInputException     Throw exception if manager or employee
     *                                   already have project.
     */
    public void addReqestResourceValidator(
            final RequestResourceInDto requestResponseInput)
            throws DataAlreadyExistException, InvalidInputException {
        requestResourceInputCheck
                .checkManagerByEmail(requestResponseInput.getManagerEmail());
        projectInputCheck.checkProjectExistanceById(
                requestResponseInput.getProjectId());
        inputFieldCheck.checkRoleEmployeeByEmpId(
                requestResponseInput.getEmpId());
        requestResourceInputCheck.checkAlreadyAssignedProjectToEmployee(
                requestResponseInput.getEmpId());
    }

    /**
     * Used to check for requested id is existing in request resourse table or
     * not.
     *
     * @param requestId Takes request id.
     */
    public void checkRequestId(final Long requestId) {
        requestResourceInputCheck.checkRequestId(requestId);
    }

    /**
     * Used to validate accepted request dto.
     *
     * @param requestAcceptInDto Takes dto.
     * @throws DataAlreadyExistException Throw exception if employee already
     *                                   have a project.
     */
    public void checkAcceptRequest(final RequestAcceptInDto requestAcceptInDto)
            throws DataAlreadyExistException {
        // TODO Auto-generated method stub
        requestResourceInputCheck
                .checkManagerId(requestAcceptInDto.getManagerId());
        requestResourceInputCheck
                .checkEmployeeId(requestAcceptInDto.getEmployeeId());
        requestResourceInputCheck
                .checkProjectId(requestAcceptInDto.getProjectId());
        requestResourceInputCheck
                .checkEmployeeNotAssigned(requestAcceptInDto.getEmployeeId());
    }

    /**
     * Checking for employee if he have request.
     *
     * @param reqResouceForEmployeeCheckInDto Takes Dto theck for request.
     * @throws InvalidInputException     Throw exception if manager email or
     *                                   employee id is not valid.
     * @throws DataAlreadyExistException Throw exception if manager email or
     *                                   employee id is not valid.
     */
    public void checkRequestResourceForEmployee(
            @Valid final ReqResouceForEmployeeCheckInDto
            reqResouceForEmployeeCheckInDto)
            throws InvalidInputException, DataAlreadyExistException {
        // TODO Auto-generated method stub
        inputFieldCheck.checkEmpIdNotExistance(
                reqResouceForEmployeeCheckInDto.getEmpId());
        inputFieldCheck.checkEmailNotExistance(
                reqResouceForEmployeeCheckInDto.getManagerEmail());
        inputFieldCheck.checkRoleEmployeeByEmpId(
                reqResouceForEmployeeCheckInDto.getEmpId());
        inputFieldCheck.checkIsManagerByEmailId(
                reqResouceForEmployeeCheckInDto.getManagerEmail());
    }
}
