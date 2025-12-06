package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProjectOutDtoWithIdAndNameTest {

    @Test
    void testProjectForRequestResource() {
        ProjectOutDtoWithIdAndName outDto1 = new ProjectOutDtoWithIdAndName();

        assertNull(outDto1.getId());
        assertNull(outDto1.getProjectName());

        outDto1.setId(1L);
        outDto1.setProjectName("Employee Management System");

        assertEquals(1L, outDto1.getId());
        assertEquals("Employee Management System", outDto1.getProjectName());
    }

    @Test
    void testHashCode() {
        ProjectOutDtoWithIdAndName outDto1 = new ProjectOutDtoWithIdAndName();
        outDto1.setId(1L);
        outDto1.setProjectName("Employee Management System");
        
        ProjectOutDtoWithIdAndName outDto2 = new ProjectOutDtoWithIdAndName();
        outDto2.setId(1L);
        outDto2.setProjectName("Employee Management System");
        
        assertEquals(outDto1.hashCode(), outDto2.hashCode());
        assertTrue(outDto1.equals(outDto2));

        assertTrue(outDto1.equals(outDto1));
        assertFalse(outDto1.equals(null));
        assertFalse(outDto1.equals("String"));
        
        outDto2.setId(2L);
        assertNotEquals(outDto1.hashCode(), outDto2.hashCode());
        assertFalse(outDto1.equals(outDto2));
        
        outDto2.setId(1L);
        outDto2.setProjectName("Employee Management Portal");
        assertNotEquals(outDto1.hashCode(), outDto2.hashCode());
        assertFalse(outDto1.equals(outDto2));
        
    }

    @Test
    void testToString() {
        ProjectOutDtoWithIdAndName outDto1 = new ProjectOutDtoWithIdAndName();
        outDto1.setId(1L);
        outDto1.setProjectName("Employee Management System");
        
        String expected = "ProjectForRequestResourseOutDto [id=1, projectName=Employee Management System]";
        assertEquals(expected, outDto1.toString());
    }

}
