package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProjectOutDtoWithTeamTest {

    @Test
    void testProjectOutDto() {
        ProjectOutDtoWithTeam projectOutDto1 = new ProjectOutDtoWithTeam();

        assertNull(projectOutDto1.getDescription());
        assertNull(projectOutDto1.getId());
        assertNull(projectOutDto1.getManagerId());
        assertNull(projectOutDto1.getProjectName());
        assertNull(projectOutDto1.getStartDate());

        projectOutDto1.setId(1L);
        projectOutDto1.setManagerId(2L);
        projectOutDto1.setProjectName("EMS");
        projectOutDto1.setStartDate("25-04-2023");
        projectOutDto1.setDescription("Employee Management System");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        projectOutDto1.setSkills(skills);
        List<String> team = new ArrayList<>();
        team.add("Ashish");
        projectOutDto1.setTeam(team);
        projectOutDto1.setManagerName("Prerna");

        assertEquals("Employee Management System",
                projectOutDto1.getDescription());
        assertEquals(1L, projectOutDto1.getId());
        assertEquals(2L, projectOutDto1.getManagerId());
        assertEquals("EMS", projectOutDto1.getProjectName());
        assertEquals(skills, projectOutDto1.getSkills());
        assertEquals("25-04-2023", projectOutDto1.getStartDate());
        assertEquals(team, projectOutDto1.getTeam());
        assertEquals("Prerna", projectOutDto1.getManagerName());

    }

    @Test
    void testHashCode() {
        ProjectOutDtoWithTeam projectOutDto1 = new ProjectOutDtoWithTeam();
        projectOutDto1.setId(1L);
        projectOutDto1.setManagerId(2L);
        projectOutDto1.setProjectName("EMS");
        projectOutDto1.setStartDate("25-04-2023");
        projectOutDto1.setDescription("Employee Management System");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        projectOutDto1.setSkills(skills);
        List<String> team = new ArrayList<>();
        team.add("Ashish");
        projectOutDto1.setTeam(team);
        projectOutDto1.setManagerName("Prerna");

        ProjectOutDtoWithTeam projectOutDto2 = new ProjectOutDtoWithTeam();
        projectOutDto2.setId(1L);
        projectOutDto2.setManagerId(2L);
        projectOutDto2.setProjectName("EMS");
        projectOutDto2.setStartDate("25-04-2023");
        projectOutDto2.setDescription("Employee Management System");
        projectOutDto2.setSkills(skills);
        projectOutDto2.setTeam(team);
        projectOutDto2.setManagerName("Prerna");

        assertEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertTrue(projectOutDto1.equals(projectOutDto2));

        assertTrue(projectOutDto1.equals(projectOutDto1));
        assertFalse(projectOutDto1.equals(null));
        assertFalse(projectOutDto1.equals("String"));

        projectOutDto2.setId(2L);
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        projectOutDto2.setId(1L);
        projectOutDto2.setManagerId(3L);
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        projectOutDto2.setManagerId(2L);
        projectOutDto2.setProjectName("EMS2");
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        projectOutDto2.setProjectName("EMS");
        projectOutDto2.setStartDate("26-04-2023");
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        projectOutDto2.setStartDate("25-04-2023");
        projectOutDto2.setDescription("Employee Management System second");
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        projectOutDto2.setDescription("Employee Management System");
        skills.add("SQL");
        projectOutDto2.setSkills(skills);
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        skills.remove(1);
        projectOutDto2.setSkills(skills);
        team.add("Abhay");
        projectOutDto2.setTeam(team);
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        team.remove(1);
        projectOutDto2.setTeam(team);
        projectOutDto2.setManagerName("Kavita");
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

    }

    @Test
    void testToString() {
        ProjectOutDtoWithTeam projectOutDto1 = new ProjectOutDtoWithTeam();
        projectOutDto1.setId(1L);
        projectOutDto1.setManagerId(2L);
        projectOutDto1.setProjectName("EMS");
        projectOutDto1.setStartDate("25-04-2023");
        projectOutDto1.setDescription("Employee Management System");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        projectOutDto1.setSkills(skills);
        List<String> team = new ArrayList<>();
        team.add("Ashish");
        projectOutDto1.setTeam(team);
        String expected = "ProjectOutDtoWithTeam [id=1, projectName=EMS, managerId=2, startDate=25-04-2023, skills=[Java], description=Employee Management System, managerName=null, team=[Ashish]]";
        assertEquals(expected, projectOutDto1.toString());
    }

}
