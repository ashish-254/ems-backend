package com.employeemanagement.backend.dto;

import java.util.Objects;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;

import jakarta.validation.constraints.NotNull;

public class RequestAcceptInDto {

    /**
     * Project id.
     */
    @NotNull(message = ErrorConstant.EMPTY_PROJECTID)
    private Long projectId;
    /**
     * Manager id.
     */
    @NotNull(message = ErrorConstant.EMPTY_MANAGER_ID)
    private Long managerId;
    /**
     * employee id.
     */
    @NotNull(message = ErrorConstant.EMPTY_EMP_ID)
    private Long employeeId;

    /**
     * Used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(employeeId, managerId, projectId);
    }

    /**
     * Used to equeate object.
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
        RequestAcceptInDto other = (RequestAcceptInDto) obj;
        return Objects.equals(employeeId, other.employeeId)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(projectId, other.projectId);
    }

    /**
     * Used to get values of object.
     */
    @Override
    public String toString() {
        return "RequestAcceptInDto [projectId=" + projectId + ", managerId="
                + managerId + ", employeeId=" + employeeId + "]";
    }

    /**
     * @return the projectId.
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * @param requestProjectId the projectId to set.
     */
    public void setProjectId(final Long requestProjectId) {
        this.projectId = requestProjectId;
    }

    /**
     * @return the managerId.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * @param requestManagerId the managerId to set.
     */
    public void setManagerId(final Long requestManagerId) {
        this.managerId = requestManagerId;
    }

    /**
     * @return the employeeId.
     */
    public Long getEmployeeId() {
        return employeeId;
    }

    /**
     * @param requestEmployeeId the employeeId to set.
     */
    public void setEmployeeId(final Long requestEmployeeId) {
        this.employeeId = requestEmployeeId;
    }

}
