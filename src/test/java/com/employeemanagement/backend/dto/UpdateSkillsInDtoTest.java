package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UpdateSkillsInDtoTest {

    @Test
    void testUpdateSkillsDto() {
        UpdateSkillsInDto updateSkillsInDto1 = new UpdateSkillsInDto();
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("springboot");
        updateSkillsInDto1.setSkills(skills);
        assertEquals(skills, updateSkillsInDto1.getSkills());
    }
    @Test
    void testHashCodeAndEquals() {
        UpdateSkillsInDto updateSkillsInDto1 = new UpdateSkillsInDto();
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("springboot");
        updateSkillsInDto1.setSkills(skills)
        ;
        UpdateSkillsInDto updateSkillsInDto2 = new UpdateSkillsInDto();
        updateSkillsInDto2.setSkills(skills);
        
        assertEquals(updateSkillsInDto1.hashCode(), updateSkillsInDto2.hashCode());
        assertEquals(updateSkillsInDto1.hashCode(), updateSkillsInDto2.hashCode());
        assertTrue(updateSkillsInDto1.equals(updateSkillsInDto2));
        assertTrue(updateSkillsInDto1.equals(updateSkillsInDto1));
        assertFalse(updateSkillsInDto1.equals(null));
        assertFalse(updateSkillsInDto1.equals("String"));
        
        skills.remove(1);
        updateSkillsInDto2.setSkills(skills);
        assertNotEquals(updateSkillsInDto1.hashCode(), updateSkillsInDto2.hashCode());
        assertFalse(updateSkillsInDto1.equals(updateSkillsInDto2));
    }

    @Test
    void testToString() {
        UpdateSkillsInDto updateSkillsInDto1 = new UpdateSkillsInDto();
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("springboot");
        updateSkillsInDto1.setSkills(skills);
        String expected = "UpdateSkillsInDto [skills=[java, springboot]]";
        assertEquals(expected, updateSkillsInDto1.toString());
    }

}
