package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class AllEmployeeOutDtoTest {

    @Test
    void responseAllEmployeeDto() {
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        AllEmployeeOutDto employee = new AllEmployeeOutDto();

        assertNull(employee.getEmpContactNo());
        assertNull(employee.getEmpDesignation());
        assertNull(employee.getEmpDob());
        assertNull(employee.getEmpDoj());
        assertNull(employee.getEmpEmail());
        assertNull(employee.getEmpId());
        assertNull(employee.getEmpLocation());
        assertNull(employee.getEmpManagerId());
        assertNull(employee.getEmpName());

        employee.setEmpId("N0001");
        employee.setEmpName("Ashish");
        employee.setEmpEmail("ashish@nucleusteq.com");
        employee.setEmpDob("25-04-2002");
        employee.setEmpDoj("25-04-2023");
        employee.setEmpLocation("Raipur");
        employee.setEmpDesignation("Manager");
        employee.setEmpContactNo("1234567890");
        List<Long> list = new ArrayList<>();
        list.add(4L);
        list.add(5L);
        employee.setEmpProjectId(list);
        employee.setEmpManagerId(9L);

        assertEquals("N0001", employee.getEmpId());
        assertEquals("Ashish", employee.getEmpName());
        assertEquals("ashish@nucleusteq.com", employee.getEmpEmail());
        assertEquals("25-04-2002", employee.getEmpDob());
        assertEquals("25-04-2023", employee.getEmpDoj());
        assertEquals("Raipur", employee.getEmpLocation());
        assertEquals("Manager", employee.getEmpDesignation());
        assertEquals("1234567890", employee.getEmpContactNo());
        assertEquals(list, employee.getEmpProjectId());
        assertEquals(9L, employee.getEmpManagerId());
    }

    @Test
    void testHashCodeAndEquals() {
        AllEmployeeOutDto employee1 = new AllEmployeeOutDto();
        employee1.setEmpId("N0001");
        employee1.setEmpName("Ashish");
        employee1.setEmpEmail("ashish@nucleusteq.com");
        employee1.setEmpDob("25-04-2002");
        employee1.setEmpDoj("25-04-2023");
        employee1.setEmpLocation("Raipur");
        employee1.setEmpDesignation("Engineer");
        employee1.setEmpContactNo("1234567890");
        List<Long> list = new ArrayList<>();
        list.add(4L);
        list.add(5L);
        employee1.setEmpProjectId(list);
        employee1.setEmpManagerId(9L);
        employee1.setManagerName("Prerna");

        AllEmployeeOutDto employee2 = new AllEmployeeOutDto();
        employee2.setEmpId("N0001");
        employee2.setEmpName("Ashish");
        employee2.setEmpEmail("ashish@nucleusteq.com");
        employee2.setEmpDob("25-04-2002");
        employee2.setEmpDoj("25-04-2023");
        employee2.setEmpLocation("Raipur");
        employee2.setEmpDesignation("Engineer");
        employee2.setEmpContactNo("1234567890");
        employee2.setEmpProjectId(list);
        employee2.setEmpManagerId(9L);
        employee2.setManagerName("Prerna");

        assertEquals(employee1.hashCode(), employee2.hashCode());
        assertTrue(employee1.equals(employee2));
        assertTrue(employee1.equals(employee1));
        assertFalse(employee1.equals(null));
        assertFalse(employee1.equals("String"));

        employee2.setEmpId("N0003");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpId("N0002");
        employee2.setEmpName("Ashish Kumar");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpName("Ashish");
        employee2.setEmpEmail("ashishkumar@nucleusteq.com");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpEmail("ashish@nucleusteq.com");
        employee2.setEmpDob("25-04-2003");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpDob("25-04-2002");
        employee2.setEmpDoj("25-04-2022");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpDoj("25-04-2023");
        employee2.setEmpLocation("Indore");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpLocation("Raipur");
        employee2.setEmpDesignation("Senior Engineer");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpDesignation("Engineer");
        employee2.setEmpContactNo("1234567899");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpContactNo("1234567890");
        list.remove(1);
        employee2.setEmpProjectId(list);
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        list.add(5L);
        employee2.setEmpProjectId(list);
        employee2.setEmpManagerId(10L);
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpManagerId(9L);
        employee2.setManagerName("Kavita");
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

    }

    @Test
    void testToString() {
        AllEmployeeOutDto employee1 = new AllEmployeeOutDto();
        employee1.setEmpId("N0001");
        employee1.setEmpName("Ashish");
        employee1.setEmpEmail("ashish@nucleusteq.com");
        employee1.setEmpDob("25-04-2002");
        employee1.setEmpDoj("25-04-2023");
        employee1.setEmpLocation("Raipur");
        employee1.setEmpDesignation("Engineer");
        employee1.setEmpContactNo("1234567890");
        List<Long> list = new ArrayList<>();
        list.add(4L);
        list.add(5L);
        employee1.setEmpProjectId(list);
        employee1.setEmpManagerId(9L);
        employee1.setManagerName("Prerna");
        String expected = "AllEmployeeOutDto [empId=N0001, empName=Ashish, empEmail=ashish@nucleusteq.com, empDob=25-04-2002, empDoj=25-04-2023, empLocation=Raipur, empDesignation=Engineer, empContactNo=1234567890, empProjectId=[4, 5], empManagerId=9, empSkills=null, managerName=Prerna]";
        assertEquals(expected, employee1.toString());
    }

}
