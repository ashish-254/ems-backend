package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RequestAcceptInDtoTest {

    @Test
    void testRequestAcceptDto() {
        RequestAcceptInDto requestAcceptInDto1 = new RequestAcceptInDto();

        assertNull(requestAcceptInDto1.getEmployeeId());
        assertNull(requestAcceptInDto1.getManagerId());
        assertNull(requestAcceptInDto1.getProjectId());

        requestAcceptInDto1.setEmployeeId(2L);
        requestAcceptInDto1.setManagerId(1L);
        requestAcceptInDto1.setProjectId(3L);

        assertEquals(1L, requestAcceptInDto1.getManagerId());
        assertEquals(2L, requestAcceptInDto1.getEmployeeId());
        assertEquals(3L, requestAcceptInDto1.getProjectId());
    }

    @Test
    void testHashCode() {
        RequestAcceptInDto requestAcceptInDto1 = new RequestAcceptInDto();
        requestAcceptInDto1.setEmployeeId(2L);
        requestAcceptInDto1.setManagerId(1L);
        requestAcceptInDto1.setProjectId(3L);

        RequestAcceptInDto requestAcceptInDto2 = new RequestAcceptInDto();
        requestAcceptInDto2.setEmployeeId(2L);
        requestAcceptInDto2.setManagerId(1L);
        requestAcceptInDto2.setProjectId(3L);

        assertEquals(requestAcceptInDto1.hashCode(), requestAcceptInDto2.hashCode());
        assertTrue(requestAcceptInDto1.equals(requestAcceptInDto2));
        assertTrue(requestAcceptInDto1.equals(requestAcceptInDto1));
        assertFalse(requestAcceptInDto1.equals(null));
        assertFalse(requestAcceptInDto1.equals("String"));

        requestAcceptInDto2.setEmployeeId(5L);
        assertFalse(requestAcceptInDto1.equals(requestAcceptInDto2));
        assertNotEquals(requestAcceptInDto1.hashCode(), requestAcceptInDto2.hashCode());

        requestAcceptInDto2.setEmployeeId(2L);
        requestAcceptInDto2.setManagerId(4L);
        assertFalse(requestAcceptInDto1.equals(requestAcceptInDto2));
        assertNotEquals(requestAcceptInDto1.hashCode(), requestAcceptInDto2.hashCode());

        requestAcceptInDto2.setManagerId(1L);
        requestAcceptInDto2.setProjectId(6L);
        assertFalse(requestAcceptInDto1.equals(requestAcceptInDto2));
        assertNotEquals(requestAcceptInDto1.hashCode(), requestAcceptInDto2.hashCode());

    }

    @Test
    void testToString() {
        RequestAcceptInDto requestAcceptInDto1 = new RequestAcceptInDto();
        requestAcceptInDto1.setEmployeeId(2L);
        requestAcceptInDto1.setManagerId(1L);
        requestAcceptInDto1.setProjectId(3L);

        String expectedOutput = "RequestAcceptInDto [projectId=3, managerId=1, employeeId=2]";
        assertEquals(expectedOutput, requestAcceptInDto1.toString());
    }

}
