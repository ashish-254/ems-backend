package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AllRequestOutDtoTest {

    @Test
    void testResponseAllRequestDto() {
        AllRequestOutDto request1 = new AllRequestOutDto();

        assertNull(request1.getComment());
        assertNull(request1.getEmployeeId());
        assertNull(request1.getEmpName());
        assertNull(request1.getId());
        assertNull(request1.getManagerId());
        assertNull(request1.getManagerName());
        assertNull(request1.getProjectId());
        assertNull(request1.getProjectName());

        request1.setComment("Comment");
        request1.setEmployeeId(2L);
        request1.setEmpName("Abhay");
        request1.setId(10L);
        request1.setManagerId(1L);
        request1.setManagerName("Ashish");
        request1.setProjectId(3L);
        request1.setProjectName("EMS");

        assertEquals("Comment", request1.getComment());
        assertEquals(2L, request1.getEmployeeId());
        assertEquals("Abhay", request1.getEmpName());
        assertEquals(10L, request1.getId());
        assertEquals(1L, request1.getManagerId());
        assertEquals("Ashish", request1.getManagerName());
        assertEquals(3L, request1.getProjectId());
        assertEquals("EMS", request1.getProjectName());
    }

    @Test
    void testHashCodeAndEquals() {
        AllRequestOutDto request1 = new AllRequestOutDto();
        request1.setComment("Comment");
        request1.setEmployeeId(2L);
        request1.setEmpName("Abhay");
        request1.setId(10L);
        request1.setManagerId(1L);
        request1.setManagerName("Ashish");
        request1.setProjectId(3L);
        request1.setProjectName("EMS");

        AllRequestOutDto request2 = new AllRequestOutDto();
        request2.setComment("Comment");
        request2.setEmployeeId(2L);
        request2.setEmpName("Abhay");
        request2.setId(10L);
        request2.setManagerId(1L);
        request2.setManagerName("Ashish");
        request2.setProjectId(3L);
        request2.setProjectName("EMS");

        assertTrue(request1.equals(request2));
        assertTrue(request1.equals(request1));
        assertEquals(request1.hashCode(), request2.hashCode());
        assertFalse(request1.equals(null));
        assertFalse(request1.equals("String"));

        request2.setComment("new Comment");
        assertNotEquals(request1.hashCode(), request2.hashCode());
        assertFalse(request1.equals(request2));

        request2.setComment("Comment");
        request2.setEmployeeId(3L);
        assertNotEquals(request1.hashCode(), request2.hashCode());
        assertFalse(request1.equals(request2));

        request2.setEmployeeId(2L);
        request2.setEmpName("Abhay kumar");
        assertNotEquals(request1.hashCode(), request2.hashCode());
        assertFalse(request1.equals(request2));

        request2.setEmpName("Abhay");
        request2.setId(11L);
        assertNotEquals(request1.hashCode(), request2.hashCode());
        assertFalse(request1.equals(request2));

        request2.setId(10L);
        request2.setManagerId(2L);
        assertNotEquals(request1.hashCode(), request2.hashCode());
        assertFalse(request1.equals(request2));

        request2.setManagerId(1L);
        request2.setManagerName("Ashish kumar");
        assertNotEquals(request1.hashCode(), request2.hashCode());
        assertFalse(request1.equals(request2));

        request2.setManagerName("Ashish");
        request2.setProjectId(4L);
        assertNotEquals(request1.hashCode(), request2.hashCode());
        assertFalse(request1.equals(request2));

        request2.setProjectId(3L);
        request2.setProjectName("EMS second");
        assertNotEquals(request1.hashCode(), request2.hashCode());
        assertFalse(request1.equals(request2));

    }

    @Test
    void testToString() {
        AllRequestOutDto dto1 = new AllRequestOutDto();
        dto1.setComment("Comment");
        dto1.setEmployeeId(2L);
        dto1.setEmpName("Abhay");
        dto1.setId(10L);
        dto1.setManagerId(1L);
        dto1.setManagerName("Ashish");
        dto1.setProjectId(3L);
        dto1.setProjectName("EMS");

        String expected = "AllRequestOutDto [id=10, managerId=1, employeeId=2, comment=Comment, projectId=3, empName=Abhay, managerName=Ashish, projectName=EMS]";

        assertEquals(expected, dto1.toString());
    }

}
