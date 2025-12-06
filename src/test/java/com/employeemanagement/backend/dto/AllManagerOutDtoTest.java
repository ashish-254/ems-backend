package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

class AllManagerOutDtoTest {

    @Test
    void testResponseAllManagerDto() {
        AllManagerOutDto manager1 = new AllManagerOutDto();
        
        assertNull(manager1.getEmpContactNo());
        assertNull(manager1.getEmpDesignation());
        assertNull(manager1.getEmpDoj());
        assertNull(manager1.getEmpEmail());
        assertNull(manager1.getEmpId());
        assertNull(manager1.getEmpLocation());
        assertNull(manager1.getEmpName());
        
        manager1.setEmId(1L);
        manager1.setEmpId("N0001");
        manager1.setEmpName("Ashish");
        manager1.setEmpEmail("ashish@nucleusteq.com");
        manager1.setEmpDoj("25-04-2023");
        manager1.setEmpLocation("Raipur");
        manager1.setEmpDesignation("Engineer");
        manager1.setEmpContactNo("1234567890");
        List<String> skills = new ArrayList<>();
        skills.add("java");
        manager1.setEmpSkills(skills);
        List<Long> project = new ArrayList<>();
        project.add(5L);
        manager1.setEmpProjectId(project);

        assertEquals(1L, manager1.getEmId());
        assertEquals("N0001", manager1.getEmpId());
        assertEquals("Ashish", manager1.getEmpName());
        assertEquals("ashish@nucleusteq.com", manager1.getEmpEmail());
        assertEquals("25-04-2023", manager1.getEmpDoj());
        assertEquals("Raipur", manager1.getEmpLocation());
        assertEquals("Engineer", manager1.getEmpDesignation());
        assertEquals("1234567890", manager1.getEmpContactNo());
        Objects.equals(skills, manager1.getEmpSkills());
        assertEquals(project, manager1.getEmpProjectId());
    }

    @Test
    void testHashCodeAndEquals() {
        AllManagerOutDto manager1 = new AllManagerOutDto();
        manager1.setEmId(1L);
        manager1.setEmpId("N0001");
        manager1.setEmpName("Ashish");
        manager1.setEmpEmail("ashish@nucleusteq.com");
        manager1.setEmpDoj("25-04-2023");
        manager1.setEmpLocation("Raipur");
        manager1.setEmpDesignation("Engineer");
        manager1.setEmpContactNo("1234567890");
        List<String> skills = new ArrayList<>();
        skills.add("java");
        manager1.setEmpSkills(skills);
        List<Long> project = new ArrayList<>();
        project.add(5L);
        manager1.setEmpProjectId(project);

        AllManagerOutDto manager2 = new AllManagerOutDto();
        manager2.setEmId(1L);
        manager2.setEmpId("N0001");
        manager2.setEmpName("Ashish");
        manager2.setEmpEmail("ashish@nucleusteq.com");
        manager2.setEmpDoj("25-04-2023");
        manager2.setEmpLocation("Raipur");
        manager2.setEmpDesignation("Engineer");
        manager2.setEmpContactNo("1234567890");
        manager2.setEmpSkills(skills);
        manager2.setEmpProjectId(project);

        assertEquals(manager1.hashCode(), manager2.hashCode());
        assertTrue(manager1.equals(manager2));
        assertTrue(manager1.equals(manager1));
        assertFalse(manager1.equals(null));
        assertFalse(manager1.equals("String"));

        manager2.setEmId(2L);
        assertNotEquals(manager1.hashCode(), manager2.hashCode());
        assertFalse(manager1.equals(manager2));

        manager2.setEmId(1L);
        manager2.setEmpId("N0003");
        assertNotEquals(manager1.hashCode(), manager2.hashCode());
        assertFalse(manager1.equals(manager2));

        manager2.setEmpId("N0002");
        manager2.setEmpName("Ashish Kumar");
        assertNotEquals(manager1.hashCode(), manager2.hashCode());
        assertFalse(manager1.equals(manager2));

        manager2.setEmpName("Ashish");
        manager2.setEmpEmail("ashishkumar@nucleusteq.com");
        assertNotEquals(manager1.hashCode(), manager2.hashCode());
        assertFalse(manager1.equals(manager2));

        manager2.setEmpEmail("ashish@nucleusteq.com");
        manager2.setEmpDoj("25-04-2022");
        assertNotEquals(manager1.hashCode(), manager2.hashCode());
        assertFalse(manager1.equals(manager2));

        manager2.setEmpDoj("25-04-2023");
        manager2.setEmpLocation("Indore");
        assertNotEquals(manager1.hashCode(), manager2.hashCode());
        assertFalse(manager1.equals(manager2));

        manager2.setEmpLocation("Raipur");
        manager2.setEmpDesignation("Senior Engineer");
        assertNotEquals(manager1.hashCode(), manager2.hashCode());
        assertFalse(manager1.equals(manager2));

        manager2.setEmpDesignation("Engineer");
        manager2.setEmpContactNo("1234567899");
        assertNotEquals(manager1.hashCode(), manager2.hashCode());
        assertFalse(manager1.equals(manager2));

        manager2.setEmpContactNo("1234567890");
        project.remove(0);
        manager2.setEmpProjectId(project);
        assertNotEquals(manager1.hashCode(), manager2.hashCode());
        assertFalse(manager1.equals(manager2));
    }

    @Test
    void testToString() {
        AllManagerOutDto manager1 = new AllManagerOutDto();
        manager1.setEmId(1L);
        manager1.setEmpId("N0001");
        manager1.setEmpName("Ashish");
        manager1.setEmpEmail("ashish@nucleusteq.com");
        manager1.setEmpDoj("25-04-2023");
        manager1.setEmpLocation("Raipur");
        manager1.setEmpDesignation("Engineer");
        manager1.setEmpContactNo("1234567890");
        List<String> skills = new ArrayList<>();
        skills.add("java");
        manager1.setEmpSkills(skills);
        List<Long> project = new ArrayList<>();
        project.add(5L);
        manager1.setEmpProjectId(project);
        String expected = "AllManagerOutDto [emId=1, empId=N0001, empName=Ashish, empEmail=ashish@nucleusteq.com, empDoj=25-04-2023, empDesignation=Engineer, empLocation=Raipur, empContactNo=1234567890, empProject=[5], empSkills=[java]]";
        assertEquals(expected, manager1.toString());
    }

}
