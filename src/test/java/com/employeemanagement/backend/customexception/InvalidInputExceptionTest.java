package com.employeemanagement.backend.customexception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InvalidInputExceptionTest {

    @Test
    void testWrongInputException() {
        String message = "wrong input";
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> {
                    throw new InvalidInputException(message);
                });
        assertEquals(message, exception.getMessage());
    }

}
