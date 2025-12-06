package com.employeemanagement.backend.dto;

import java.util.Objects;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * Dto for Request resourse.
 */
public class RequestResourceInDto {
    /**
     * Manager id.
     */
    @NotEmpty(message = ErrorConstant.EMPTY_EMAIL)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@nucleusteq\\.com$",
    message = ErrorConstant.INVALID_EMAIL)
    private String managerEmail;
    /**
     * Employee id.
     */
    @NotBlank(message = ErrorConstant.EMPTY_EMP_ID)
    @Pattern(regexp = "^N(?!0000)[0-9]{4}$",
    message = ErrorConstant.INVALID_EMP_ID)
    private String empId;
    /**
     * Project id for whome request is generated.
     */
    @NotNull(message = ErrorConstant.EMPTY_PROJECTID)
    private Long projectId;
    /**
     * Comment for reqest.
     */
    @NotBlank(message = ErrorConstant.EMPTY_COMMENT)
    private String comment;

    /**
     * Used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(comment, empId, managerEmail, projectId);
    }

    /**
     * Used to compare objects.
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
        RequestResourceInDto other = (RequestResourceInDto) obj;
        return Objects.equals(comment, other.comment)
                && Objects.equals(empId, other.empId)
                && Objects.equals(managerEmail, other.managerEmail)
                && Objects.equals(projectId, other.projectId);
    }

    /**
     * To string method.
     */
    @Override
    public String toString() {
        return "RequestResourceInDto [managerEmail=" + managerEmail + ", empId="
                + empId + ", projectId=" + projectId + ", comment=" + comment
                + "]";
    }

    /**
     * @return the managerEmail.
     */
    public String getManagerEmail() {
        return managerEmail;
    }

    /**
     * @param requestsManagerEmail the managerEmail to set.
     */
    public void setManagerEmail(final String requestsManagerEmail) {
        this.managerEmail = requestsManagerEmail;
    }

    /**
     * @return the empId.
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param requestsEmpId the empId to set.
     */
    public void setEmpId(final String requestsEmpId) {
        this.empId = requestsEmpId;
    }

    /**
     * @return the projectId.
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * @param requestsProjectId the projectId to set.
     */
    public void setProjectId(final Long requestsProjectId) {
        this.projectId = requestsProjectId;
    }

    /**
     * @return the comment.
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param requestsComment the comment to set.
     */
    public void setComment(final String requestsComment) {
        this.comment = requestsComment;
    }

}
