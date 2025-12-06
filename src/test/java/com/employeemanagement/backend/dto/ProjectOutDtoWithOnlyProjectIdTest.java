package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProjectOutDtoWithOnlyProjectIdTest {

    @Test
    void testResponseDtoForProject() {
        ProjectOutDtoWithOnlyProjectId responseForProject1 = new ProjectOutDtoWithOnlyProjectId();

        assertNull(responseForProject1.getId());
        assertNull(responseForProject1.getMessage());

        responseForProject1.setId(2L);
        responseForProject1.setMessage("Success");
        assertEquals(2L, responseForProject1.getId());
        assertEquals("Success", responseForProject1.getMessage());
    }

    @Test
    void testHashCodeAndEquals() {
        ProjectOutDtoWithOnlyProjectId responseForProject1 = new ProjectOutDtoWithOnlyProjectId();
        responseForProject1.setId(2L);
        responseForProject1.setMessage("Success");

        ProjectOutDtoWithOnlyProjectId responseForProject2 = new ProjectOutDtoWithOnlyProjectId();
        responseForProject2.setId(2L);
        responseForProject2.setMessage("Success");

        assertEquals(responseForProject1.hashCode(),
                responseForProject2.hashCode());
        assertTrue(responseForProject1.equals(responseForProject1));
        assertTrue(responseForProject1.equals(responseForProject2));
        assertFalse(responseForProject1.equals(null));
        assertFalse(responseForProject1.equals("String"));

        responseForProject2.setId(3L);
        assertNotEquals(responseForProject1.hashCode(),
                responseForProject2.hashCode());
        assertFalse(responseForProject1.equals(responseForProject2));

        responseForProject2.setId(2L);
        responseForProject2.setMessage("Not Success");
        assertNotEquals(responseForProject1.hashCode(),
                responseForProject2.hashCode());
        assertFalse(responseForProject1.equals(responseForProject2));
    }

    @Test
    void testToString() {
        ProjectOutDtoWithOnlyProjectId responseForProject1 = new ProjectOutDtoWithOnlyProjectId();
        responseForProject1.setId(2L);
        responseForProject1.setMessage("Success");
        String expected = "ProjectOutDtoWithOnlyProjectId [message=Success, id=2]";
        assertEquals(expected, responseForProject1.toString());
    }

}
