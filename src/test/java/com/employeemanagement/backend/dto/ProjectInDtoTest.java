package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProjectInDtoTest {

    @Test
    void testprojectDto() {
        ProjectInDto project1 = new ProjectInDto();

        assertNull(project1.getDescription());
        assertNull(project1.getManagerId());
        assertNull(project1.getProjectName());
        assertNull(project1.getStartDate());

        project1.setManagerId(2L);
        project1.setProjectName("EMS");
        project1.setStartDate("25-04-2023");
        project1.setDescription("Employee Management System");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        project1.setSkills(skills);
        assertEquals("Employee Management System", project1.getDescription());
        assertEquals(2L, project1.getManagerId());
        assertEquals("EMS", project1.getProjectName());
        assertEquals(skills, project1.getSkills());
        assertEquals("25-04-2023", project1.getStartDate());
    }

    @Test
    void testHashCodeAndEquals() {
        ProjectInDto p1 = new ProjectInDto();
        p1.setManagerId(2L);
        p1.setProjectName("EMS");
        p1.setStartDate("25-04-2023");
        p1.setDescription("Employee Management System");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        p1.setSkills(skills);

        ProjectInDto p2 = new ProjectInDto();
        p2.setManagerId(2L);
        p2.setProjectName("EMS");
        p2.setStartDate("25-04-2023");
        p2.setDescription("Employee Management System");
        p2.setSkills(skills);

        assertEquals(p1.hashCode(), p2.hashCode());
        assertTrue(p1.equals(p2));

        p2.setManagerId(3L);
        assertNotEquals(p1.hashCode(), p2.hashCode());
        assertFalse(p1.equals(p2));

        p2.setManagerId(2L);
        p2.setProjectName("EMS2");
        assertNotEquals(p1.hashCode(), p2.hashCode());
        assertFalse(p1.equals(p2));

        p2.setProjectName("EMS");
        p2.setStartDate("25-04-2022");
        assertNotEquals(p1.hashCode(), p2.hashCode());
        assertFalse(p1.equals(p2));

        p2.setStartDate("25-04-2023");
        p1.setDescription("Employee Management System second");
        assertNotEquals(p1.hashCode(), p2.hashCode());
        assertFalse(p1.equals(p2));

        p1.setDescription("Employee Management System");
        skills.add("HTML");
        p1.setSkills(skills);
        assertNotEquals(p1.hashCode(), p2.hashCode());
        assertFalse(p1.equals(p2));

        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(null));
        assertFalse(p1.equals("String"));
    }

    @Test
    void testToString() {
        ProjectInDto p1 = new ProjectInDto();
        p1.setManagerId(2L);
        p1.setProjectName("EMS");
        p1.setStartDate("25-04-2023");
        p1.setDescription("Employee Management System");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        p1.setSkills(skills);
        String expected = "ProjectInDto [projectName=EMS, managerId=2, startDate=25-04-2023, skills=[Java], description=Employee Management System]";
        assertEquals(expected, p1.toString());
    }

}
