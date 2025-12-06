package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssignProjectInDtoTest {

    @Test
    void testHashCode() {
        AssignProjectInDto assignProjectInDto1 = new AssignProjectInDto();
        assignProjectInDto1.setEmpProjectId(9L);
        AssignProjectInDto assignProjectInDto2 = new AssignProjectInDto();
        assignProjectInDto2.setEmpProjectId(9L);

        assertEquals(assignProjectInDto1.hashCode(), assignProjectInDto2.hashCode());

        assignProjectInDto2.setEmpProjectId(10L);
        assertNotEquals(assignProjectInDto1.hashCode(), assignProjectInDto2.hashCode());
    }

    @Test
    void testEqualsObject() {
        AssignProjectInDto assignProjectInDto1 = new AssignProjectInDto();
        assignProjectInDto1.setEmpProjectId(9L);
        AssignProjectInDto assignProjectInDto2 = new AssignProjectInDto();
        assignProjectInDto2.setEmpProjectId(9L);

        assertTrue(assignProjectInDto1.equals(assignProjectInDto2));

        assignProjectInDto2.setEmpProjectId(8L);
        assertFalse(assignProjectInDto1.equals(assignProjectInDto2));

        assertFalse(assignProjectInDto1.equals(null));

        assertFalse(assignProjectInDto1.equals("String"));

        assertTrue(assignProjectInDto1.equals(assignProjectInDto1));
    }

    @Test
    void testToString() {
        AssignProjectInDto assignProjectInDto1 = new AssignProjectInDto();
        assignProjectInDto1.setEmpProjectId(9L);
        String expected = "AssignProjectInDto [empProjectId=9]";
        assertEquals(expected, assignProjectInDto1.toString());
    }

    @Test
    void testAssignProjectDto() {
        AssignProjectInDto assignProjectInDto = new AssignProjectInDto();
        assertNull(assignProjectInDto.getEmpProjectId());

        assignProjectInDto.setEmpProjectId(9L);
        assertEquals(9L, assignProjectInDto.getEmpProjectId());
        assertNotEquals(8L, assignProjectInDto.getEmpProjectId());
    }

}
