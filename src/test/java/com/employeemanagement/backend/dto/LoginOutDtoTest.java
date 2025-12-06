package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginOutDtoTest {

    @Test
    void testResponseLoginDto() {
        LoginOutDto loginOutDto1 = new LoginOutDto();

        assertNull(loginOutDto1.getEmpName());
        assertNull(loginOutDto1.getMessage());
        assertNull(loginOutDto1.getRole());

        loginOutDto1.setMessage("message");
        loginOutDto1.setRole("Manager");
        loginOutDto1.setEmpName("Ashish");

        assertEquals("message", loginOutDto1.getMessage());
        assertEquals("Manager", loginOutDto1.getRole());
        assertEquals("Ashish", loginOutDto1.getEmpName());
    }

    @Test
    void testHashCode() {
        LoginOutDto loginOutDto1 = new LoginOutDto();
        loginOutDto1.setMessage("message");
        loginOutDto1.setRole("Manager");
        loginOutDto1.setEmpName("Ashish");

        LoginOutDto loginOutDto2 = new LoginOutDto();
        loginOutDto2.setMessage("message");
        loginOutDto2.setRole("Manager");
        loginOutDto2.setEmpName("Ashish");

        assertEquals(loginOutDto1.hashCode(), loginOutDto2.hashCode());
        assertTrue(loginOutDto1.equals(loginOutDto2));
        assertTrue(loginOutDto1.equals(loginOutDto1));
        assertFalse(loginOutDto1.equals(null));
        assertFalse(loginOutDto1.equals("String"));

        loginOutDto2.setMessage("second message");
        assertNotEquals(loginOutDto1.hashCode(), loginOutDto2.hashCode());
        assertFalse(loginOutDto1.equals(loginOutDto2));

        loginOutDto2.setMessage("message");
        loginOutDto2.setRole("Employee");
        assertNotEquals(loginOutDto1.hashCode(), loginOutDto2.hashCode());
        assertFalse(loginOutDto1.equals(loginOutDto2));

        loginOutDto2.setRole("Manager");
        loginOutDto2.setEmpName("Ashish Kumar");
        assertNotEquals(loginOutDto1.hashCode(), loginOutDto2.hashCode());
        assertFalse(loginOutDto1.equals(loginOutDto2));

        loginOutDto2.setEmpName("Ashish");
        assertEquals(loginOutDto1.hashCode(), loginOutDto2.hashCode());
        assertTrue(loginOutDto1.equals(loginOutDto2));
    }

    @Test
    void testToString() {
        LoginOutDto loginOutDto1 = new LoginOutDto();
        loginOutDto1.setMessage("message");
        loginOutDto1.setRole("Manager");
        loginOutDto1.setEmpName("Ashish");
        String expected = "LoginOutDto [message=message, role=Manager, empName=Ashish]";
        assertEquals(expected, loginOutDto1.toString());
    }

}
