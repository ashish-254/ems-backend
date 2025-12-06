package com.employeemanagement.backend.dto;

import java.util.Objects;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * this is a DTO for the Login Form data.
 */

public class EmployeeLoginDto {

    /**
     * employee email given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_EMAIL)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$",
    message = ErrorConstant.INVALID_EMAIL)
    private String empEmail;
    /**
     * employee password given by user.
     */
    @NotBlank(message = ErrorConstant.EMPTY_PASSWORD)
    private String empPassword;

    /**
     * used to get hascode of object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(empEmail, empPassword);
    }

    /**
     * used to compare obejcts.
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
        EmployeeLoginDto other = (EmployeeLoginDto) obj;
        return Objects.equals(empEmail, other.empEmail)
                && Objects.equals(empPassword, other.empPassword);
    }

    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "EmployeeLoginDto [empEmail=" + empEmail + ", empPassword="
                + empPassword + "]";
    }

    /**
     * Get the email address of the employee.
     *
     * @return The employee's email address.
     */
    public String getEmpEmail() {
        return empEmail;
    }

    /**
     * Set the email address of the employee.
     *
     * @param employeeEmail The new email address for the employee.
     */
    public void setEmpEmail(final String employeeEmail) {
        this.empEmail = employeeEmail;
    }

    /**
     * Get the login password of the employee.
     *
     * @return The employee's login password.
     */
    public String getEmpPassword() {
        return empPassword;
    }

    /**
     * Set the login password of the employee.
     *
     * @param employeePassword The new login password for the employee.
     */
    public void setEmpPassword(final String employeePassword) {
        this.empPassword = employeePassword;
    }

}
