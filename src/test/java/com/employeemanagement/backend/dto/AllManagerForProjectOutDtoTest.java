package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AllManagerForProjectOutDtoTest {

    @Test
    void testResponseAllManagerForProjectDto() {
        AllManagerForProjectOutDto manager1 = new AllManagerForProjectOutDto();

        assertNull(manager1.getEmId());
        assertNull(manager1.getEmpId());
        assertNull(manager1.getEmpName());

        manager1.setEmId(1L);
        manager1.setEmpId("N0001");
        manager1.setEmpName("Ashish");

        assertEquals(1L, manager1.getEmId());
        assertEquals("N0001", manager1.getEmpId());
        assertEquals("Ashish", manager1.getEmpName());
    }

    @Test
    void testHashCode() {
        AllManagerForProjectOutDto manager1 = new AllManagerForProjectOutDto();
        manager1.setEmId(1L);
        manager1.setEmpId("N0001");
        manager1.setEmpName("Ashish");

        AllManagerForProjectOutDto manager2 = new AllManagerForProjectOutDto();
        manager2.setEmId(1L);
        manager2.setEmpId("N0001");
        manager2.setEmpName("Ashish");

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
    }

    @Test
    void testToString() {
        AllManagerForProjectOutDto manager1 = new AllManagerForProjectOutDto();
        manager1.setEmId(1L);
        manager1.setEmpId("N0001");
        manager1.setEmpName("Ashish");
        String expected = "AllManagerForProjectOutDto [emId=1, empName=Ashish, empId=N0001]";
        assertEquals(expected, manager1.toString());
    }

}
