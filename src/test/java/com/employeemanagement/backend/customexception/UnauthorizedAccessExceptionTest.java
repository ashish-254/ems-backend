package com.employeemanagement.backend.customexception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnauthorizedAccessExceptionTest {

    @Test
    void testUnauthorizedAccessException() {
        String message = "Unauthorized access";
        UnauthorizedAccessException exception = assertThrows(UnauthorizedAccessException.class, ()->{
            throw new UnauthorizedAccessException(message);
        });
        assertEquals(message, exception.getMessage());
    }

}
