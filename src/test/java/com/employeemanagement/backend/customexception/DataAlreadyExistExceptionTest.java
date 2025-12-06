package com.employeemanagement.backend.customexception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataAlreadyExistExceptionTest {

    @Test
    void testDataAlreadyExistException() {
        String message = "Data already exist.";
        DataAlreadyExistException exception = assertThrows(
                DataAlreadyExistException.class, () -> {
                    throw new DataAlreadyExistException(message);
                });

        assertEquals(message, exception.getMessage());
    }

}
