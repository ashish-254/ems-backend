package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

class EmployeeInDtoTest {

    @Test
    void testAllSettersAndGetters() {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        EmployeeInDto employee = new EmployeeInDto();

        assertNull(employee.getEmpId());
        assertNull(employee.getEmpContactNo());
        assertNull(employee.getEmpDesignation());
        assertNull(employee.getEmpDob());
        assertNull(employee.getEmpDoj());
        assertNull(employee.getEmpEmail());
        assertNull(employee.getEmpLocation());
        assertNull(employee.getEmpManagerId());
        assertNull(employee.getEmpName());
        assertNull(employee.getEmpPassword());

        employee.setEmpId("N0001");
        employee.setEmpName("Ashish");
        employee.setEmpEmail("ashish@nucleusteq.com");
        employee.setEmpDob("25-04-2002");
        employee.setEmpDoj("25-04-2023");
        employee.setEmpLocation("Raipur");
        employee.setEmpDesignation("Manager");
        employee.setEmpContactNo("1234567890");
        employee.setEmpPassword("12345678");
        employee.setEmpRole("Manager");
        employee.setEmpSkills(skills);
        List<Long> projectId = new ArrayList<>();
        projectId.add(5L);
        employee.setEmpProjectId(projectId);

        employee.setEmpManagerId(9L);

        assertEquals("N0001", employee.getEmpId());
        assertEquals("Ashish", employee.getEmpName());
        assertEquals("ashish@nucleusteq.com", employee.getEmpEmail());
        assertEquals("25-04-2002", employee.getEmpDob());
        assertEquals("25-04-2023", employee.getEmpDoj());
        assertEquals("Raipur", employee.getEmpLocation());
        assertEquals("Manager", employee.getEmpDesignation());
        assertEquals("1234567890", employee.getEmpContactNo());
        assertEquals("12345678", employee.getEmpPassword());
        assertEquals("Manager", employee.getEmpRole());
        Objects.equals(skills, employee.getEmpSkills());
        assertEquals(projectId, employee.getEmpProjectId());
        assertEquals(9L, employee.getEmpManagerId());
    }

    @Test
    public void testHashCodeAndEquals() {
        EmployeeInDto employee1 = new EmployeeInDto();
        employee1.setEmpId("N0001");
        employee1.setEmpName("Ashish");
        employee1.setEmpEmail("ashish@nucleusteq.com");
        employee1.setEmpDob("25-04-2002");
        employee1.setEmpDoj("25-04-2023");
        employee1.setEmpLocation("Raipur");
        employee1.setEmpDesignation("Engineer");
        employee1.setEmpContactNo("1234567890");
        employee1.setEmpPassword("12345678");
        employee1.setEmpRole("Manager");
        List<String> skills = new ArrayList<>();
        skills.add("java");
        employee1.setEmpSkills(skills);
        List<Long> projectId = new ArrayList<>();
        projectId.add(5L);
        employee1.setEmpProjectId(projectId);
        employee1.setEmpManagerId(9L);

        EmployeeInDto employee2 = new EmployeeInDto();
        employee2.setEmpId("N0001");
        employee2.setEmpName("Ashish");
        employee2.setEmpEmail("ashish@nucleusteq.com");
        employee2.setEmpDob("25-04-2002");
        employee2.setEmpDoj("25-04-2023");
        employee2.setEmpLocation("Raipur");
        employee2.setEmpDesignation("Engineer");
        employee2.setEmpContactNo("1234567890");
        employee2.setEmpPassword("12345678");
        employee2.setEmpRole("Manager");
        employee2.setEmpSkills(skills);
        employee2.setEmpProjectId(projectId);
        employee2.setEmpManagerId(9L);

        assertEquals(employee1.hashCode(), employee2.hashCode());
        assertTrue(employee1.equals(employee2));

        employee2.setEmpContactNo("345454545");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpContactNo("1234567890");
        employee2.setEmpDob("09-09-1990");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpDob("25-04-2002");
        employee2.setEmpDoj("25-04-2002");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpDoj("25-04-2023");
        employee2.setEmpEmail("ashishkumar@nucleusteq.com");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpEmail("ashish@nucleusteq.com");
        employee2.setEmpId("N0045");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpId("N0001");
        employee2.setEmpLocation("USA");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpLocation("Raipur");
        employee2.setEmpName("Ashish Kumar");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpName("Ashish");
        employee2.setEmpPassword("123456789");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpPassword("12345678");
        employee2.setEmpRole("Managers");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        assertTrue(employee1.equals(employee1));
        assertFalse(employee1.equals(null));
        assertFalse(employee1.equals("String"));

    }

    @Test
    public void testToString() {
        EmployeeInDto employee1 = new EmployeeInDto();
        employee1.setEmpId("N0001");
        employee1.setEmpName("Ashish");
        employee1.setEmpEmail("ashish@nucleusteq.com");
        employee1.setEmpDob("25-04-2002");
        employee1.setEmpDoj("25-04-2023");
        employee1.setEmpLocation("Raipur");
        employee1.setEmpDesignation("Engineer");
        employee1.setEmpContactNo("1234567890");
        employee1.setEmpPassword("12345678");
        employee1.setEmpRole("Manager");
        List<String> skills = new ArrayList<>();
        skills.add("java");
        employee1.setEmpSkills(skills);
        List<Long> projectId = new ArrayList<>();
        projectId.add(5L);
        employee1.setEmpProjectId(projectId);
        employee1.setEmpManagerId(9L);
        String expected = "EmployeeInDto [empId=N0001, empName=Ashish, empEmail=ashish@nucleusteq.com, empDob=25-04-2002, empDoj=25-04-2023, empLocation=Raipur, empDesignation=Engineer, empContactNo=1234567890, empPassword=12345678, empRole=Manager, empSkills=[java], empProject=[5], empManager=9]";
        assertEquals(expected, employee1.toString());
    }
}
