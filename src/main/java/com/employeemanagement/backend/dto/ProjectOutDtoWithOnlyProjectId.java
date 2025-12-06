package com.employeemanagement.backend.dto;

import java.util.Objects;

public class ProjectOutDtoWithOnlyProjectId {
    /**
     * used to save messages.
     */
    private String message;
    /**
     * project id.
     */
    private Long id;

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, message);
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
        ProjectOutDtoWithOnlyProjectId other =
                (ProjectOutDtoWithOnlyProjectId) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(message, other.message);
    }

    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "ProjectOutDtoWithOnlyProjectId [message=" + message + ", id="
                + id + "]";
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

    /**
     * getter for id.
     *
     * @return project id.
     */
    public Long getId() {
        return id;
    }

    /**
     * set a project id.
     *
     * @param projectId takes id to store.
     */
    public void setId(final Long projectId) {
        this.id = projectId;
    }

}
