package com.employeemanagement.backend.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * is used to ignore any warnings.
 */
@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException {
  /**
  * this is the custom exception which contains a message string.
  *
  * @param message takes a message for exception.
  */
  public DataNotFoundException(final String message) {
    super(message);
  }
}
