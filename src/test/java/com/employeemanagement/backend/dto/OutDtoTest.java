package com.employeemanagement.backend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class OutDtoTest {

    @Test
    void test() {
        OutDto outDto = new OutDto();
        assertNull(outDto.getMessage());
        outDto.setMessage("message");
        assertEquals("message", outDto.getMessage());
        outDto = new OutDto();
        outDto.setMessage("second message");
        assertEquals("second message", outDto.getMessage());
    }

    @Test
    void testHashCodeAndEquals() {
        OutDto outDto = new OutDto();
        outDto.setMessage("message");

        OutDto responseDto2 = new OutDto();
        responseDto2.setMessage("message");

        assertEquals(outDto.hashCode(), responseDto2.hashCode());
        assertTrue(outDto.equals(outDto));
        assertTrue(outDto.equals(responseDto2));
        assertFalse(outDto.equals(null));
        assertFalse(outDto.equals("String"));

        outDto.setMessage("Another message");
        assertNotEquals(outDto.hashCode(), responseDto2.hashCode());
        assertFalse(outDto.equals(responseDto2));

    }

    @Test
    void testToString() {
        OutDto outDto = new OutDto();
        outDto.setMessage("message");
        String expected = "OutDto [message=message]";
        assertEquals(expected, outDto.toString());
    }

}
