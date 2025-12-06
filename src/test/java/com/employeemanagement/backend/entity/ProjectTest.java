package com.employeemanagement.backend.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProjectTest {

    @Test
    void testProject() {
        Project project1 = new Project();
        project1.setId(1L);
        project1.setManagerId(2L);
        project1.setProjectName("EMS");
        project1.setStartDate("25-04-2023");
        project1.setDescription("Employee Management System");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        project1.setSkills(skills);
        assertEquals("Employee Management System", project1.getDescription());
        assertEquals(1L, project1.getId());
        assertEquals(2L, project1.getManagerId());
        assertEquals("EMS", project1.getProjectName());
        assertEquals(skills, project1.getSkills());
        assertEquals("25-04-2023", project1.getStartDate());
    }

    @Test
    void testHashCode() {
        Project project1 = new Project();
        project1.setId(1L);
        project1.setManagerId(2L);
        project1.setProjectName("EMS");
        project1.setStartDate("25-04-2023");
        project1.setDescription("Employee Management System");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        project1.setSkills(skills);

        Project project2 = new Project();
        project2.setId(1L);
        project2.setManagerId(2L);
        project2.setProjectName("EMS");
        project2.setStartDate("25-04-2023");
        project2.setDescription("Employee Management System");
        project2.setSkills(skills);

        assertEquals(project1.hashCode(), project2.hashCode());
        assertTrue(project1.equals(project2));

        project2.setManagerId(3L);
        assertNotEquals(project1.hashCode(), project2.hashCode());
        assertFalse(project1.equals(project2));

        project2.setManagerId(2L);
        project2.setProjectName("EMS2");
        assertNotEquals(project1.hashCode(), project2.hashCode());
        assertFalse(project1.equals(project2));

        project2.setProjectName("EMS");
        project2.setStartDate("25-04-2022");
        assertNotEquals(project1.hashCode(), project2.hashCode());
        assertFalse(project1.equals(project2));

        project2.setStartDate("25-04-2023");
        project1.setDescription("Employee Management System second");
        assertNotEquals(project1.hashCode(), project2.hashCode());
        assertFalse(project1.equals(project2));

        project1.setDescription("Employee Management System");
        skills.add("HTML");
        project1.setSkills(skills);
        assertNotEquals(project1.hashCode(), project2.hashCode());
        assertFalse(project1.equals(project2));

        skills.remove(1);
        project1.setSkills(skills);
        project1.setId(6L);
        assertNotEquals(project1.hashCode(), project2.hashCode());
        assertFalse(project1.equals(project2));

        assertTrue(project1.equals(project1));
        assertFalse(project1.equals(null));
        assertFalse(project1.equals("String"));

    }

    @Test
    void testToString() {
        Project project1 = new Project();
        project1.setId(1L);
        project1.setManagerId(2L);
        project1.setProjectName("EMS");
        project1.setStartDate("25-04-2023");
        project1.setDescription("Employee Management System");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        project1.setSkills(skills);
        String expected = "Project [id=1, projectName=EMS, managerId=2, startDate=25-04-2023, skills=[Java], description=Employee Management System]";
        assertEquals(expected, project1.toString());
    }

}
