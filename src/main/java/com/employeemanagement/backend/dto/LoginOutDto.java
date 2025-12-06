package com.employeemanagement.backend.dto;

import java.util.Objects;

/**
 * Respose for login.
 */
public class LoginOutDto {
    /**
     * have message.
     */
    private String message;
    /**
     * have role of employee.
     */
    private String role;
    /**
     * have role of employee.
     */
    private String empName;

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(message, role, empName);
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
        LoginOutDto other = (LoginOutDto) obj;
        return Objects.equals(message, other.message)
                && Objects.equals(role, other.role)
                && Objects.equals(empName, other.empName);
    }

    /**
     * Get values of object's data.
     */
    @Override
    public String toString() {
        return "LoginOutDto [message=" + message + ", role=" + role
                + ", empName=" + empName + "]";
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
     * Get the role associated with the message.
     *
     * @return The role string.
     */
    public String getRole() {
        return role;
    }

    /**
     * Set a new role string associated with the message.
     *
     * @param employeeRole The new role to be set.
     */
    public void setRole(final String employeeRole) {
        this.role = employeeRole;
    }

    /**
     * @return the empName.
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param employeeName the empName to set.
     */
    public void setEmpName(final String employeeName) {
        this.empName = employeeName;
    }

}
