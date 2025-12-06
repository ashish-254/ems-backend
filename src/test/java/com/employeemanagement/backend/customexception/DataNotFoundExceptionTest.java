package com.employeemanagement.backend.customexception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DataNotFoundExceptionTest {

    @Test
    void testDataNotFoundException() {
        String message = "data not found";

        DataNotFoundException exception = assertThrows(
                DataNotFoundException.class, () -> {
                    throw new DataNotFoundException(message);
                });
        assertEquals("data not found", exception.getMessage());
    }

}
