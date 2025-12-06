package com.employeemanagement.backend.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * exception when input is wrong.
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends Exception {
    /**
     * Constructor to call constructor of Exception class.
     * @param message accept a message.
     */
    public InvalidInputException(final String message) {
        super(message);
    }

}
