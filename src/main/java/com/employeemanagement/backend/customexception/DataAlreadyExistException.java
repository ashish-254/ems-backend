package com.employeemanagement.backend.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * exception when data already exist.
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.CONFLICT)
public class DataAlreadyExistException extends Exception {
 /**
 * Constructor to call constructor of Exception class.
 * @param message accept a message.
 */
  public DataAlreadyExistException(final String message) {
    super(message);
  }
}
