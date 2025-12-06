package com.employeemanagement.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.backend.constantsmessages.LoggerConstant;
import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.dto.ReqResouceForEmployeeCheckInDto;
import com.employeemanagement.backend.dto.RequestAcceptInDto;
import com.employeemanagement.backend.dto.RequestResourceInDto;
import com.employeemanagement.backend.dto.AllRequestOutDto;
import com.employeemanagement.backend.dto.OutDto;
import com.employeemanagement.backend.service.RequestResourceService;
import com.employeemanagement.backend.validator.RequestResourceValidator;

import jakarta.validation.Valid;

/**
 * Request Rosourse Controller.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/requestResource")
public class RequestResourceController {

    /**
     * Object for RequestResourceService to use service.
     */
    @Autowired
    private RequestResourceService requestResourceService;
    /**
     * Object for RequestResourceValidator to validate data.
     */
    @Autowired
    private RequestResourceValidator requestResourceValidator;

    /**
     * Logger object.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeeController.class);

    /**
     * Used to add a new request.
     *
     * @param requestResponseInput Takes a dto with all details for new request.
     * @return Return a message.
     * @throws DataAlreadyExistException Throw exception.
     * @throws InvalidInputException     Throw exception.
     */
    @PostMapping("/addRequest")
    public OutDto addReqestResource(
            @RequestBody @Valid final RequestResourceInDto requestResponseInput)
            throws DataAlreadyExistException, InvalidInputException {
        LOGGER.info(LoggerConstant.ADDREQUEST_INMESSAGE
                + requestResponseInput.toString());
        requestResourceValidator
                .addReqestResourceValidator(requestResponseInput);
        OutDto response = requestResourceService
                .addRequestService(requestResponseInput);
        LOGGER.info(LoggerConstant.ADDREQUEST_OUTMESSAGE);
        return response;
    }

    /**
     * Checking for request for employee if he already have request by same
     * maanger.
     *
     * @param reqResouceForEmployeeCheckInDto Takes Dto.
     * @return Return a message in ResponseDto.
     * @throws DataAlreadyExistException Throw exception if any exception occur.
     * @throws InvalidInputException Throw exception if any exception occur.
     */
    @PostMapping("/checkRequestResource")
    public OutDto checkRequestResourceForEmployee(
            @RequestBody @Valid final ReqResouceForEmployeeCheckInDto
            reqResouceForEmployeeCheckInDto)
                    throws InvalidInputException, DataAlreadyExistException {
        LOGGER.info(LoggerConstant.CHECKREQUESTFOREMPLOYEE_INMESSAGE
                + reqResouceForEmployeeCheckInDto.toString());
        requestResourceValidator.checkRequestResourceForEmployee(
                reqResouceForEmployeeCheckInDto);
        OutDto response = requestResourceService
                .checkRequestResourceForEmployee(
                        reqResouceForEmployeeCheckInDto);
        LOGGER.info(LoggerConstant.CHECKREQUESTFOREMPLOYEE_OUTMESSAGE);
        return response;
    }

    /**
     * Used to get all request tables data.
     *
     * @return Return list of data stored in table.
     */
    @GetMapping("/getAllRequestResource")
    public List<AllRequestOutDto> getAllRequests() {
        LOGGER.info(LoggerConstant.GETALLREQUEST_INMESSAGE);
        List<AllRequestOutDto> response = requestResourceService
                .getAllRequests();
        LOGGER.info(LoggerConstant.GETALLREQUEST_OUTMESSAGE);
        return response;
    }

    /**
     * Used to delete request by id.
     *
     * @param requestId Takes requestId.
     * @return Return a message in ResponseDto.
     */
    @DeleteMapping("/deleteRequest/{requestId}")
    public OutDto deleteRequest(@PathVariable final Long requestId) {
        LOGGER.info(LoggerConstant.DELETEREQUEST_INMESSAGE
                + requestId);
        requestResourceValidator.checkRequestId(requestId);
        OutDto response = requestResourceService.deleteRequest(requestId);
        LOGGER.info(LoggerConstant.DELETEREQUEST_OUTMESSAGE);
        return response;
    }

    /**
     * Used to accept request and perform changes.
     *
     * @param requestAcceptInDto Takes Dto to accept request.
     * @return Return a message in ResponseDto.
     * @throws DataAlreadyExistException Throw exception if data already exist.
     */
    @PostMapping("/acceptRequest")
    public OutDto acceptRequest(
            @RequestBody @Valid final RequestAcceptInDto requestAcceptInDto)
            throws DataAlreadyExistException {
        LOGGER.info(LoggerConstant.ACCEPTREQUEST_INMESSAGE
                + requestAcceptInDto.toString());
        requestResourceValidator.checkAcceptRequest(requestAcceptInDto);
        OutDto response = requestResourceService
                .acceptRequest(requestAcceptInDto);
        LOGGER.info(LoggerConstant.ACCEPTREQUEST_OUTMESSAGE);
        return response;
    }
}
