package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RequestResourceInDtoTest {

    @Test
    void testRequestResourseDto() {
        RequestResourceInDto requestResourceInDto1 = new RequestResourceInDto();

        assertNull(requestResourceInDto1.getComment());
        assertNull(requestResourceInDto1.getEmpId());
        assertNull(requestResourceInDto1.getManagerEmail());
        assertNull(requestResourceInDto1.getProjectId());

        requestResourceInDto1.setComment("Comment");
        requestResourceInDto1.setEmpId("N0001");
        requestResourceInDto1.setManagerEmail("ashish@nucleusteq.com");
        requestResourceInDto1.setProjectId(3L);

        assertEquals("Comment", requestResourceInDto1.getComment());
        assertEquals("N0001", requestResourceInDto1.getEmpId());
        assertEquals("ashish@nucleusteq.com", requestResourceInDto1.getManagerEmail());
        assertEquals(3L, requestResourceInDto1.getProjectId());

    }

    @Test
    void testHashCode() {
        RequestResourceInDto requestResourceInDto1 = new RequestResourceInDto();
        requestResourceInDto1.setComment("Comment");
        requestResourceInDto1.setEmpId("N0001");
        requestResourceInDto1.setManagerEmail("ashish@nucleusteq.com");
        requestResourceInDto1.setProjectId(3L);

        RequestResourceInDto requestResourceInDto2 = new RequestResourceInDto();
        requestResourceInDto2.setComment("Comment");
        requestResourceInDto2.setEmpId("N0001");
        requestResourceInDto2.setManagerEmail("ashish@nucleusteq.com");
        requestResourceInDto2.setProjectId(3L);

        assertTrue(requestResourceInDto1.equals(requestResourceInDto2));
        assertEquals(requestResourceInDto1.hashCode(), requestResourceInDto2.hashCode());
        assertTrue(requestResourceInDto1.equals(requestResourceInDto1));
        assertFalse(requestResourceInDto1.equals(null));
        assertFalse(requestResourceInDto1.equals("String"));

        requestResourceInDto2.setComment("Another comment");
        assertNotEquals(requestResourceInDto1.hashCode(), requestResourceInDto2.hashCode());
        assertFalse(requestResourceInDto1.equals(requestResourceInDto2));

        requestResourceInDto2.setComment("Comment");
        requestResourceInDto2.setEmpId("N0002");
        assertNotEquals(requestResourceInDto1.hashCode(), requestResourceInDto2.hashCode());
        assertFalse(requestResourceInDto1.equals(requestResourceInDto2));

        requestResourceInDto2.setEmpId("N0001");
        requestResourceInDto2.setManagerEmail("ashishkumar@nucleusteq.com");
        assertNotEquals(requestResourceInDto1.hashCode(), requestResourceInDto2.hashCode());
        assertFalse(requestResourceInDto1.equals(requestResourceInDto2));

        requestResourceInDto2.setManagerEmail("ashish@nucleusteq.com");
        requestResourceInDto2.setProjectId(4L);
        assertNotEquals(requestResourceInDto1.hashCode(), requestResourceInDto2.hashCode());
        assertFalse(requestResourceInDto1.equals(requestResourceInDto2));

    }

    @Test
    void testToString() {
        RequestResourceInDto requestResourceInDto1 = new RequestResourceInDto();
        requestResourceInDto1.setComment("Comment");
        requestResourceInDto1.setEmpId("N0001");
        requestResourceInDto1.setManagerEmail("ashish@nucleusteq.com");
        requestResourceInDto1.setProjectId(3L);

        String expected = "RequestResourceInDto [managerEmail=ashish@nucleusteq.com, empId=N0001, projectId=3, comment=Comment]";
        assertEquals(expected, requestResourceInDto1.toString());
    }

}
