package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReqResouceForEmployeeCheckInDtoTest {

    @Test
    void testReqResouseForEmployeeCheckDto() {
        ReqResouceForEmployeeCheckInDto reqResourceInDto1 = new ReqResouceForEmployeeCheckInDto();

        assertNull(reqResourceInDto1.getEmpId());
        assertNull(reqResourceInDto1.getManagerEmail());

        reqResourceInDto1.setEmpId("N0001");
        reqResourceInDto1.setManagerEmail("ashish@nucleusteq.com");

        assertEquals("N0001", reqResourceInDto1.getEmpId());
        assertEquals("ashish@nucleusteq.com", reqResourceInDto1.getManagerEmail());

    }

    @Test
    void testHashCode() {
        ReqResouceForEmployeeCheckInDto reqResourceInDto1 = new ReqResouceForEmployeeCheckInDto();
        reqResourceInDto1.setEmpId("N0001");
        reqResourceInDto1.setManagerEmail("ashish@nucleusteq.com");

        ReqResouceForEmployeeCheckInDto reqResourceInDto2 = new ReqResouceForEmployeeCheckInDto();
        reqResourceInDto2.setEmpId("N0001");
        reqResourceInDto2.setManagerEmail("ashish@nucleusteq.com");

        assertEquals(reqResourceInDto1.hashCode(), reqResourceInDto2.hashCode());
        assertTrue(reqResourceInDto1.equals(reqResourceInDto2));
        assertTrue(reqResourceInDto1.equals(reqResourceInDto1));
        assertFalse(reqResourceInDto1.equals(null));
        assertFalse(reqResourceInDto1.equals("String"));

        reqResourceInDto2.setEmpId("N0002");
        assertNotEquals(reqResourceInDto1.hashCode(), reqResourceInDto2.hashCode());
        assertFalse(reqResourceInDto1.equals(reqResourceInDto2));

        reqResourceInDto2.setEmpId("N0001");
        reqResourceInDto2.setManagerEmail("ashishkumar@nucleusteq.com");
        assertNotEquals(reqResourceInDto1.hashCode(), reqResourceInDto2.hashCode());
        assertFalse(reqResourceInDto1.equals(reqResourceInDto2));
    }

    @Test
    void testToString() {
        ReqResouceForEmployeeCheckInDto reqResourceInDto1 = new ReqResouceForEmployeeCheckInDto();
        reqResourceInDto1.setEmpId("N0001");
        reqResourceInDto1.setManagerEmail("ashish@nucleusteq.com");

        String expectedOutput = "ReqResouceForEmployeeCheckInDto [managerEmail=ashish@nucleusteq.com, empId=N0001]";
        assertEquals(expectedOutput, reqResourceInDto1.toString());
    }

}
