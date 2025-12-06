package com.employeemanagement.backend.globalexceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.DataNotFoundException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.dto.OutDto;
import com.employeemanagement.backend.customexception.UnauthorizedAccessException;

/**
 * Global exception handler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * handler for exception DataNotFoundException.
     *
     * @param ex takes object of exception.
     * @return a message to frontend.
     */
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public OutDto dataNotFoundExceptionHandler(
            final DataNotFoundException ex) {
        OutDto response = new OutDto();
        response.setMessage(ex.getMessage());
        return response;
    }

    /**
     * handler for exception DataAlreadyExistException.
     *
     * @param ex takes object of exception.
     * @return return a message to frontend.
     */
    @ExceptionHandler(DataAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public OutDto dataAlreadyExistExceptionHandler(
            final DataAlreadyExistException ex) {
        OutDto response = new OutDto();
        response.setMessage(ex.getMessage());
        return response;
    }

    /**
     * handler for exception WrongInputException.
     *
     * @param ex takes object of exception.
     * @return return a message to frontend.
     */
    @ExceptionHandler(InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public OutDto wrongInputExceptionHandler(
            final InvalidInputException ex) {
        OutDto response = new OutDto();
        response.setMessage(ex.getMessage());
        return response;
    }

    /**
     * handler for exception WrongInputException.
     *
     * @param ex takes object of exception.
     * @return return a message to frontend.
     */
    @ExceptionHandler(UnauthorizedAccessException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public OutDto unauthorizedAccessException(
            final UnauthorizedAccessException ex) {
        OutDto response = new OutDto();
        response.setMessage(ex.getMessage());
        return response;
    }

    /**
     * @param ex object for method argument not valid class
     * @return api response
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public final Map<String, String> handleEmptyDataValidation(
            final MethodArgumentNotValidException ex) {
        Map<String, String> resp = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            resp.put(fieldName, message);
        });
        return resp;
    }

    /**
     * handler for any other exception.
     *
     * @param ex takes object of exception.
     * @return return a message to frontend.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public OutDto exceptionHandler(final Exception ex) {
        OutDto response = new OutDto();
        response.setMessage(ex.getMessage());
        return response;
    }
}
