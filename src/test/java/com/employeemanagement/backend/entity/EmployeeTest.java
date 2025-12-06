package com.employeemanagement.backend.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.employeemanagement.backend.enumlists.Designation;
import com.employeemanagement.backend.enumlists.Location;

class EmployeeTest {

    @Test
    void testSettersAndNoArgsConstructor() {
        Employee employee = new Employee();

        assertNull(employee.getEmId());
        assertNull(employee.getEmpContactNo());
        assertNull(employee.getEmpDesignation());
        assertNull(employee.getEmpDob());
        assertNull(employee.getEmpDoj());
        assertNull(employee.getEmpEmail());
        assertNull(employee.getEmpId());
        assertNull(employee.getEmpLocation());
        assertNull(employee.getEmpManagerId());
        assertNull(employee.getEmpName());
        assertNull(employee.getEmpPassword());

        employee.setEmId((long) 1);
        employee.setEmpId("N0000");
        employee.setEmpName("Ankita Sharma");
        employee.setEmpEmail("ankita.sharma@nucleusteq.com");
        employee.setEmpDob("25-04-1995");
        employee.setEmpDoj("25-04-2020");
        employee.setEmpLocation(Location.valueOf("Bangalore"));
        employee.setEmpDesignation(Designation.RECRUITER);
        employee.setEmpContactNo("1234567890");
        employee.setEmpPassword("12345678");
        employee.setEmpRole("Employee");
        List<String> skills = new ArrayList<>();
        employee.setEmpSkills(skills);
        List<Long> project = new ArrayList<>();
        project.add(5L);
        employee.setEmpProjectId(project);
        employee.setEmpManagerId(9L);

        assertEquals((long) 1, employee.getEmId());
        assertEquals("N0000", employee.getEmpId());
        assertEquals("Ankita Sharma", employee.getEmpName());
        assertEquals("ankita.sharma@nucleusteq.com", employee.getEmpEmail());
        assertEquals("25-04-1995", employee.getEmpDob());
        assertEquals("25-04-2020", employee.getEmpDoj());
        assertEquals(Location.valueOf("Bangalore"), employee.getEmpLocation());
        assertEquals(Designation.valueOf("RECRUITER"),
                employee.getEmpDesignation());
        assertEquals("1234567890", employee.getEmpContactNo());
        assertEquals("12345678", employee.getEmpPassword());
        assertEquals("Employee", employee.getEmpRole());
        assertEquals(skills, employee.getEmpSkills());
        assertEquals(project, employee.getEmpProjectId());
        assertEquals(9L, employee.getEmpManagerId());
    }

    @Test
    void testHashCode() {
        Employee employee1 = new Employee();
        employee1.setEmId(1L);
        employee1.setEmpId("N0001");
        employee1.setEmpName("Ashish");
        employee1.setEmpEmail("ashish@nucleusteq.com");
        employee1.setEmpDob("25-04-2002");
        employee1.setEmpDoj("25-04-2023");
        employee1.setEmpLocation(Location.Raipur);
        employee1.setEmpDesignation(Designation.ENGINEER);
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

        Employee employee2 = new Employee();
        employee2.setEmId(1L);
        employee2.setEmpId("N0001");
        employee2.setEmpName("Ashish");
        employee2.setEmpEmail("ashish@nucleusteq.com");
        employee2.setEmpDob("25-04-2002");
        employee2.setEmpDoj("25-04-2023");
        employee2.setEmpLocation(Location.Raipur);
        employee2.setEmpDesignation(Designation.ENGINEER);
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
        employee2.setEmpLocation(Location.Canada);
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpLocation(Location.Raipur);
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

        employee2.setEmpRole("Manager");
        employee2.setEmId(2L);
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmId(1L);
        employee2.setEmpManagerId(10L);
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpManagerId(9L);
        employee2.setEmpDesignation(Designation.ARCHITECT);
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        employee2.setEmpDesignation(Designation.ENGINEER);
        projectId.add(8L);
        employee2.setEmpProjectId(projectId);
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        projectId.remove(1);
        employee2.setEmpProjectId(projectId);
        skills.add("Spring");
        employee2.setEmpSkills(skills);
        assertNotEquals(employee1.hashCode(), employee2.hashCode());
        assertFalse(employee1.equals(employee2));

        assertTrue(employee1.equals(employee1));
        assertFalse(employee1.equals(null));
        assertFalse(employee1.equals("String"));
    }

    @Test
    void testToString() {
        Employee employee = new Employee();
        employee.setEmId((long) 1);
        employee.setEmpId("N0000");
        employee.setEmpName("Ankita Sharma");
        employee.setEmpEmail("ankita.sharma@nucleusteq.com");
        employee.setEmpDob("25-04-1995");
        employee.setEmpDoj("25-04-2020");
        employee.setEmpLocation(Location.valueOf("Bangalore"));
        employee.setEmpDesignation(Designation.RECRUITER);
        employee.setEmpContactNo("1234567890");
        employee.setEmpPassword("12345678");
        employee.setEmpRole("Employee");
        List<String> skills = new ArrayList<>();
        employee.setEmpSkills(skills);
        List<Long> project = new ArrayList<>();
        project.add(5L);
        employee.setEmpProjectId(project);
        employee.setEmpManagerId(9L);

        String expected = "Employee [emId=1, empId=N0000, empName=Ankita Sharma, empEmail=ankita.sharma@nucleusteq.com, empDob=25-04-1995, empDoj=25-04-2020, empLocation=Bangalore, empDesignation=RECRUITER, empContactNo=1234567890, empPassword=12345678, empRole=Employee, empSkills=[], empProject=[5], empManager=9]";
        assertEquals(expected, employee.toString());
    }
}
