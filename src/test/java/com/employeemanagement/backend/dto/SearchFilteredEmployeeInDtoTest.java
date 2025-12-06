package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SearchFilteredEmployeeInDtoTest {

    @Test
    void testSetterGetter() {
        SearchFilteredEmployeeInDto inDto = new SearchFilteredEmployeeInDto();

        inDto.setShowOnlyUnassigned(false);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        inDto.setSelectedSkills(skills);

        assertFalse(inDto.isShowOnlyUnassigned());
        assertEquals(skills, inDto.getSelectedSkills());
    }

    @Test
    void testHashCode() {
        SearchFilteredEmployeeInDto inDto1 = new SearchFilteredEmployeeInDto();
        inDto1.setShowOnlyUnassigned(false);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        inDto1.setSelectedSkills(skills);

        SearchFilteredEmployeeInDto inDto2 = new SearchFilteredEmployeeInDto();
        inDto2.setShowOnlyUnassigned(false);
        inDto2.setSelectedSkills(skills);

        assertEquals(inDto1.hashCode(), inDto2.hashCode());
        assertTrue(inDto1.equals(inDto2));

        assertTrue(inDto1.equals(inDto1));
        assertFalse(inDto1.equals(null));
        assertFalse(inDto1.equals("String"));

        inDto2.setShowOnlyUnassigned(true);
        assertNotEquals(inDto1.hashCode(), inDto2.hashCode());
        assertFalse(inDto1.equals(inDto2));

        inDto2.setShowOnlyUnassigned(false);
        skills.add("Python");
        inDto2.setSelectedSkills(skills);
        assertNotEquals(inDto1.hashCode(), inDto2.hashCode());
        assertFalse(inDto1.equals(inDto2));

    }

    @Test
    void testToString() {
        SearchFilteredEmployeeInDto inDto1 = new SearchFilteredEmployeeInDto();
        inDto1.setShowOnlyUnassigned(false);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        inDto1.setSelectedSkills(skills);

        String expected = "SearchFilteredEmployeeInDto [selectedSkills=[Java], showOnlyUnassigned=false]";
        assertEquals(expected, inDto1.toString());
    }

}
