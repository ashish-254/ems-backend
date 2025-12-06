package com.employeemanagement.backend.dto;

import java.util.Objects;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;

import jakarta.validation.constraints.NotNull;


/**
 * Dto to assign project to employee.
 */
public class AssignProjectToEmployeeInDto {
    /**
     * Project Id.
     */
    @NotNull(message = ErrorConstant.EMPTY_PROJECTID)
    private Long projectId;
    /**
     * Manager id for project.
     */
    @NotNull(message = ErrorConstant.EMPTY_PROJECTMANAGERID)
    private Long projectManagerId;
    /**
     * @return the projectId
     */
    public Long getProjectId() {
        return projectId;
    }
    /**
     * @param projectsId the projectId to set
     */
    public void setProjectId(final Long projectsId) {
        this.projectId = projectsId;
    }
    /**
     * @return the projectManagerId
     */
    public Long getProjectManagerId() {
        return projectManagerId;
    }
    /**
     * @param projectsManagerId the projectManagerId to set
     */
    public void setProjectManagerId(final Long projectsManagerId) {
        this.projectManagerId = projectsManagerId;
    }
    /**
     * Used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(projectId, projectManagerId);
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
        AssignProjectToEmployeeInDto other = (AssignProjectToEmployeeInDto) obj;
        return Objects.equals(projectId, other.projectId)
                && Objects.equals(projectManagerId, other.projectManagerId);
    }
    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "AssignProjectToEmployeeInDto [projectId=" + projectId
                + ", projectManagerId=" + projectManagerId + "]";
    }
}
