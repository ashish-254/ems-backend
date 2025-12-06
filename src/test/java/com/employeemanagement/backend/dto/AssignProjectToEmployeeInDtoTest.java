package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssignProjectToEmployeeInDtoTest {

    @Test
    void testSetterGetter() {
        AssignProjectToEmployeeInDto assignProjectToEmployeeInDto1 = new AssignProjectToEmployeeInDto();

        assertNull(assignProjectToEmployeeInDto1.getProjectId());
        assertNull(assignProjectToEmployeeInDto1.getProjectManagerId());

        assignProjectToEmployeeInDto1.setProjectId(9L);
        assignProjectToEmployeeInDto1.setProjectManagerId(8L);
        assertEquals(9L, assignProjectToEmployeeInDto1.getProjectId());
        assertEquals(8L, assignProjectToEmployeeInDto1.getProjectManagerId());
        assertNotEquals(8L, assignProjectToEmployeeInDto1.getProjectId());
        assertNotEquals(9L,
                assignProjectToEmployeeInDto1.getProjectManagerId());
    }

    @Test
    void testHashCode() {
        AssignProjectToEmployeeInDto assignProjectToEmployeeInDto1 = new AssignProjectToEmployeeInDto();
        assignProjectToEmployeeInDto1.setProjectId(9L);
        assignProjectToEmployeeInDto1.setProjectManagerId(8L);

        AssignProjectToEmployeeInDto assignProjectToEmployeeInDto2 = new AssignProjectToEmployeeInDto();
        assignProjectToEmployeeInDto2.setProjectId(9L);
        assignProjectToEmployeeInDto2.setProjectManagerId(8L);

        AssignProjectToEmployeeInDto assignProjectToEmployeeInDto3 = new AssignProjectToEmployeeInDto();
        assignProjectToEmployeeInDto3.setProjectId(8L);
        assignProjectToEmployeeInDto3.setProjectManagerId(9L);

        assertEquals(assignProjectToEmployeeInDto1.hashCode(),
                assignProjectToEmployeeInDto2.hashCode());
        assertNotEquals(assignProjectToEmployeeInDto1.hashCode(),
                assignProjectToEmployeeInDto3.hashCode());
    }

    @Test
    void testEqualsObject() {
        AssignProjectToEmployeeInDto assignProjectToEmployeeInDto = new AssignProjectToEmployeeInDto();
        assignProjectToEmployeeInDto.setProjectId(9L);
        assignProjectToEmployeeInDto.setProjectManagerId(8L);

        AssignProjectToEmployeeInDto assignProjectToEmployeeInDto2 = new AssignProjectToEmployeeInDto();
        assignProjectToEmployeeInDto2.setProjectId(9L);
        assignProjectToEmployeeInDto2.setProjectManagerId(8L);

        AssignProjectToEmployeeInDto assignProjectToEmployeeInDto3 = new AssignProjectToEmployeeInDto();
        assignProjectToEmployeeInDto3.setProjectId(8L);
        assignProjectToEmployeeInDto3.setProjectManagerId(9L);

        assertTrue(assignProjectToEmployeeInDto
                .equals(assignProjectToEmployeeInDto2));
        assertFalse(assignProjectToEmployeeInDto
                .equals(assignProjectToEmployeeInDto3));
        assertFalse(assignProjectToEmployeeInDto.equals(null));
        assertTrue(assignProjectToEmployeeInDto
                .equals(assignProjectToEmployeeInDto));
        assertFalse(assignProjectToEmployeeInDto.equals("String"));
    }

    @Test
    void testToString() {
        AssignProjectToEmployeeInDto assignProjectToEmployeeInDto = new AssignProjectToEmployeeInDto();
        assignProjectToEmployeeInDto.setProjectId(9L);
        assignProjectToEmployeeInDto.setProjectManagerId(8L);

        String s = "AssignProjectToEmployeeInDto [projectId=9, projectManagerId=8]";
        assertEquals(s, assignProjectToEmployeeInDto.toString());
    }

}
