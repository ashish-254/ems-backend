package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProjectOutDtoForManagerTabTest {

    @Test
    void testSetterGetter() {
        ProjectOutDtoForManagerTab projectOutDto = new ProjectOutDtoForManagerTab();
        assertNull(projectOutDto.getId());
        assertNull(projectOutDto.getProjectName());

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        List<String> team = new ArrayList<>();
        team.add("Abhay");

        projectOutDto.setId(1L);
        projectOutDto.setProjectName("EMS");
        projectOutDto.setSkills(skills);
        projectOutDto.setTeam(team);

        assertEquals(1L, projectOutDto.getId());
        assertEquals("EMS", projectOutDto.getProjectName());
        assertEquals(skills, projectOutDto.getSkills());
        assertEquals(team, projectOutDto.getTeam());

    }

    @Test
    void testHashCodeAndEquals() {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        List<String> team = new ArrayList<>();
        team.add("Abhay");

        ProjectOutDtoForManagerTab projectOutDto1 = new ProjectOutDtoForManagerTab();
        projectOutDto1.setId(1L);
        projectOutDto1.setProjectName("EMS");
        projectOutDto1.setSkills(skills);
        projectOutDto1.setTeam(team);

        ProjectOutDtoForManagerTab projectOutDto2 = new ProjectOutDtoForManagerTab();
        projectOutDto2.setId(1L);
        projectOutDto2.setProjectName("EMS");
        projectOutDto2.setSkills(skills);
        projectOutDto2.setTeam(team);

        assertEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertTrue(projectOutDto1.equals(projectOutDto2));
        assertTrue(projectOutDto1.equals(projectOutDto1));
        assertFalse(projectOutDto1.equals(null));
        assertFalse(projectOutDto1.equals("String"));

        projectOutDto2.setId(2L);
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        projectOutDto2.setId(1L);
        projectOutDto2.setProjectName("EMS Second");
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        projectOutDto2.setProjectName("EMS");
        skills.add("Python");
        projectOutDto2.setSkills(skills);
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

        skills.remove(1);
        projectOutDto2.setSkills(skills);
        team.add("Ashish");
        projectOutDto2.setTeam(team);
        assertNotEquals(projectOutDto1.hashCode(), projectOutDto2.hashCode());
        assertFalse(projectOutDto1.equals(projectOutDto2));

    }

    @Test
    void testToString() {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        List<String> team = new ArrayList<>();
        team.add("Abhay");

        ProjectOutDtoForManagerTab projectOutDto1 = new ProjectOutDtoForManagerTab();
        projectOutDto1.setId(1L);
        projectOutDto1.setProjectName("EMS");
        projectOutDto1.setSkills(skills);
        projectOutDto1.setTeam(team);
        
        String expected = "ProjectOutDtoForManagerTab [id=1, projectName=EMS, skills=[Java], team=[Abhay]]";
        assertEquals(expected, projectOutDto1.toString());
    }

}
