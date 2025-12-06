package com.employeemanagement.backend.dto;

import java.util.Objects;


/**
 * this is the DTO for the response which always given to the front-end.
 */
public class OutDto {
    /**
     * used to save messages.
     */
    private String message;

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    /**
     * used to compare objects.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OutDto other = (OutDto) obj;
        return Objects.equals(message, other.message);
    }

    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "OutDto [message=" + message + "]";
    }

    /**
     * Get the message string.
     *
     * @return The message string.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set a new message string.
     *
     * @param employeeMessage The new message to be set.
     */
    public void setMessage(final String employeeMessage) {
        this.message = employeeMessage;
    }

}
