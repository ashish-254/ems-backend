package com.employeemanagement.backend.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception when at the time of login, password not match.
 */
@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedAccessException extends Exception {

    /**
     * Constructor of the exception with a message.
     *
     * @param message Takes a message.
     */
    public UnauthorizedAccessException(final String message) {
        super(message);
    }

}
