package com.employeemanagement.backend.inputcheck;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;
import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.DataNotFoundException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.entity.Employee;
import com.employeemanagement.backend.entity.RequestResource;
import com.employeemanagement.backend.repository.EmployeeRepository;
import com.employeemanagement.backend.repository.RequestResourseRepository;

/**
 * Class used to check field of request resourse.
 */
@Component
public class RequestResourceInputCheck {
    /**
     * Object of employee Repository.
     */
    @Autowired
    private EmployeeRepository employeeRepo;
    /**
     * Object of request resourse repository.
     */
    @Autowired
    private RequestResourseRepository requestResourseRepo;

    /**
     * Used to check for if employee already have a project or not.
     *
     * @param employeeId Takes employeeId.
     * @throws DataAlreadyExistException Throw exception if data not found or
     *                                   employee already have project assigned.
     */
    public void checkAlreadyAssignedProjectToEmployee(final String employeeId)
            throws DataAlreadyExistException {
        Employee employeeData = employeeRepo.findByEmpId(employeeId);
        if (employeeData == null) {
            throw new DataNotFoundException(ErrorConstant.EMPLOYEE_NOT_EXIST);
        }
        if (employeeData.getEmpProjectId().size() > 0) {
            throw new DataAlreadyExistException(
                    ErrorConstant.EMPLOYEE_HAVE_PROJECT);
        }
    }

    /**
     * Used to check manager in employee table by email.
     *
     * @param managerEmail Takes manager email id.
     * @throws InvalidInputException Throw exception if manager not found.
     */
    public void checkManagerByEmail(final String managerEmail)
            throws InvalidInputException {
        Employee employeeData = employeeRepo.findByEmpEmail(managerEmail);
        if (employeeData == null) {
            throw new InvalidInputException(ErrorConstant.MANAGER_NOT_EXIST);
        }
        if (!employeeData.getEmpRole().equals("Manager")) {
            throw new InvalidInputException(ErrorConstant.NOT_A_MANAGER);
        }
    }

    /**
     * Used to check check request in request resourse table by id.
     *
     * @param requestId Takes request id.
     */
    public void checkRequestId(final Long requestId) {
        Optional<RequestResource> requsetResource = requestResourseRepo
                .findById(requestId);
        RequestResource request = requsetResource.orElse(null);
        if (request == null) {
            throw new DataNotFoundException(ErrorConstant.REQUEST_NOT_EXIST);
        }
    }

    /**
     * Used to check manager in request resourse table by manager id.
     *
     * @param managerId Takes manager id.
     */
    public void checkManagerId(final Long managerId) {
        // TODO Auto-generated method stub
        List<RequestResource> requestResource = requestResourseRepo
                .findAllByManagerId(managerId);
        if (requestResource == null || requestResource.size() == 0) {
            throw new DataNotFoundException(
                    ErrorConstant.MANAGER_NOT_EXIST_IN_REQ_RES_TABLE);
        }
    }

    /**
     * Used to check employee in request resourse table by employee id.
     *
     * @param employeeId Takes employee id.
     */
    public void checkEmployeeId(final Long employeeId) {
        // TODO Auto-generated method stub
        List<RequestResource> requestResource = requestResourseRepo
                .findAllByEmployeeId(employeeId);
        if (requestResource == null || requestResource.size() == 0) {
            throw new DataNotFoundException(
                    ErrorConstant.EMPLOYEE_NOT_EXIST_IN_REQ_RES_TABLE);
        }
    }

    /**
     * Used to check project by id in request resourse table.
     *
     * @param projectId Takes projectId.
     */
    public void checkProjectId(final Long projectId) {
        // TODO Auto-generated method stub
        List<RequestResource> requestResource = requestResourseRepo
                .findAllByProjectId(projectId);
        if (requestResource == null || requestResource.size() == 0) {
            throw new DataNotFoundException(
                    ErrorConstant.PROJECT_NOT_EXIST_IN_REQ_RES_TABLE);
        }
    }

    /**
     * Used to check for employee is exist in employee table of not. And have
     * any project or not.
     *
     * @param employeeId
     * @throws DataAlreadyExistException
     */
    public void checkEmployeeNotAssigned(final Long employeeId)
            throws DataAlreadyExistException {
        // TODO Auto-generated method stub
        Employee employee = employeeRepo.findByEmId(employeeId);
        if (employee == null) {
            throw new DataNotFoundException(ErrorConstant.EMPLOYEE_NOT_EXIST);
        }
        if (employee.getEmpProjectId().size() > 0) {
            throw new DataAlreadyExistException(
                    ErrorConstant.EMPLOYEE_HAVE_PROJECT);
        }
    }

}
