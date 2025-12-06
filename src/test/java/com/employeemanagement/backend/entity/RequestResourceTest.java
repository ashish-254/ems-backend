package com.employeemanagement.backend.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class RequestResourceTest {
    @Test
    void testRequestResourse() {
        RequestResource requestResource1 = new RequestResource();
        requestResource1.setId(1L);
        requestResource1.setComment("Comment");
        requestResource1.setEmployeeId(2L);
        requestResource1.setManagerId(1L);
        requestResource1.setProjectId(3L);

        assertEquals(1L, requestResource1.getId());
        assertEquals("Comment", requestResource1.getComment());
        assertEquals(2L, requestResource1.getEmployeeId());
        assertEquals(1L, requestResource1.getManagerId());
        assertEquals(3L, requestResource1.getProjectId());

    }

    @Test
    void testHashCodeAndEquals() {
        RequestResource requestResource1 = new RequestResource();
        requestResource1.setId(1L);
        requestResource1.setComment("Comment");
        requestResource1.setEmployeeId(2L);
        requestResource1.setManagerId(1L);
        requestResource1.setProjectId(3L);

        RequestResource requestResource2 = new RequestResource();
        requestResource2.setId(1L);
        requestResource2.setComment("Comment");
        requestResource2.setEmployeeId(2L);
        requestResource2.setManagerId(1L);
        requestResource2.setProjectId(3L);

        assertTrue(requestResource1.equals(requestResource2));
        assertEquals(requestResource1.hashCode(), requestResource2.hashCode());
        assertTrue(requestResource1.equals(requestResource1));
        assertFalse(requestResource1.equals(null));
        assertFalse(requestResource1.equals("String"));

        requestResource2.setComment("Another comment");
        assertNotEquals(requestResource1.hashCode(), requestResource2.hashCode());
        assertFalse(requestResource1.equals(requestResource2));

        requestResource2.setComment("Comment");
        requestResource2.setId(2L);
        assertNotEquals(requestResource1.hashCode(), requestResource2.hashCode());
        assertFalse(requestResource1.equals(requestResource2));

        requestResource2.setId(1L);
        requestResource2.setEmployeeId(3L);
        assertNotEquals(requestResource1.hashCode(), requestResource2.hashCode());
        assertFalse(requestResource1.equals(requestResource2));

        requestResource2.setEmployeeId(2L);
        requestResource2.setManagerId(2L);
        assertNotEquals(requestResource1.hashCode(), requestResource2.hashCode());
        assertFalse(requestResource1.equals(requestResource2));

        requestResource2.setManagerId(1L);
        requestResource2.setProjectId(4L);
        assertNotEquals(requestResource1.hashCode(), requestResource2.hashCode());
        assertFalse(requestResource1.equals(requestResource2));

    }

    @Test
    void testToString() {
        RequestResource requestResource1 = new RequestResource();
        requestResource1.setId(1L);
        requestResource1.setComment("Comment");
        requestResource1.setEmployeeId(2L);
        requestResource1.setManagerId(1L);
        requestResource1.setProjectId(3L);

        String expected = "RequestResource [id=1, managerId=1, employeeId=2, comment=Comment, projectId=3]";
        assertEquals(expected, requestResource1.toString());
    }

}
