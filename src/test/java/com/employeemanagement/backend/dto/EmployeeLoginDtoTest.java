package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeLoginDtoTest {

    @Test
    void testSettersAndNoArgsConstructor() {
        EmployeeLoginDto employeeLoginDto = new EmployeeLoginDto();
        assertNull(employeeLoginDto.getEmpEmail());
        assertNull(employeeLoginDto.getEmpPassword());

        employeeLoginDto.setEmpEmail("ashish@nucleusteq.com");
        employeeLoginDto.setEmpPassword("12345678");
        assertEquals("ashish@nucleusteq.com", employeeLoginDto.getEmpEmail());
        assertEquals("12345678", employeeLoginDto.getEmpPassword());
    }

    @Test
    void testHashCodeAndEquals() {
        EmployeeLoginDto employeeLoginDto = new EmployeeLoginDto();
        employeeLoginDto.setEmpEmail("ashish@nucleusteq.com");
        employeeLoginDto.setEmpPassword("12345678");

        EmployeeLoginDto employeeLoginDto2 = new EmployeeLoginDto();
        employeeLoginDto2.setEmpEmail("ashish@nucleusteq.com");
        employeeLoginDto2.setEmpPassword("12345678");

        assertEquals(employeeLoginDto.hashCode(), employeeLoginDto2.hashCode());
        assertTrue(employeeLoginDto.equals(employeeLoginDto2));

        employeeLoginDto2.setEmpEmail("ashishkumar@nucleusteq.com");
        assertNotEquals(employeeLoginDto.hashCode(), employeeLoginDto2.hashCode());
        assertFalse(employeeLoginDto.equals(employeeLoginDto2));

        employeeLoginDto2.setEmpEmail("ashish@nucleusteq.com");
        employeeLoginDto2.setEmpPassword("123456789");
        assertNotEquals(employeeLoginDto.hashCode(), employeeLoginDto2.hashCode());
        assertFalse(employeeLoginDto.equals(employeeLoginDto2));

        assertFalse(employeeLoginDto.equals(null));
        assertFalse(employeeLoginDto.equals("String"));
        assertTrue(employeeLoginDto.equals(employeeLoginDto));
    }

    @Test
    void testToString() {
        EmployeeLoginDto employeeLoginDto = new EmployeeLoginDto();
        employeeLoginDto.setEmpEmail("ashish@nucleusteq.com");
        employeeLoginDto.setEmpPassword("12345678");
        String expected = "EmployeeLoginDto [empEmail=ashish@nucleusteq.com, empPassword=12345678]";
        assertEquals(expected, employeeLoginDto.toString());
    }

}
