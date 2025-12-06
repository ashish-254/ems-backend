package com.employeemanagement.backend.dto;

import java.util.Objects;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;

import jakarta.validation.constraints.NotBlank;

/**
 * Dto class used to check employee already requested by same manager or not.
 */
public class ReqResouceForEmployeeCheckInDto {
    /**
     * Manager email id.
     */
    @NotBlank(message = ErrorConstant.EMPTY_EMAIL)
    private String managerEmail;
    /**
     * Employee id.
     */
    @NotBlank(message = ErrorConstant.EMPTY_EMP_ID)
    private String empId;

    /**
     * Used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(empId, managerEmail);
    }

    /**
     * Used to compare two objects.
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
        ReqResouceForEmployeeCheckInDto other =
                (ReqResouceForEmployeeCheckInDto) obj;
        return Objects.equals(empId, other.empId)
                && Objects.equals(managerEmail, other.managerEmail);
    }

    /**
     * Used to get values of object.
     */
    @Override
    public String toString() {
        return "ReqResouceForEmployeeCheckInDto [managerEmail=" + managerEmail
                + ", empId=" + empId + "]";
    }

    /**
     * @return the managerEmail
     */
    public String getManagerEmail() {
        return managerEmail;
    }

    /**
     * @param requestsManagerEmail the managerEmail to set
     */
    public void setManagerEmail(final String requestsManagerEmail) {
        this.managerEmail = requestsManagerEmail;
    }

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param requestsEmpId the empId to set
     */
    public void setEmpId(final String requestsEmpId) {
        this.empId = requestsEmpId;
    }
}
