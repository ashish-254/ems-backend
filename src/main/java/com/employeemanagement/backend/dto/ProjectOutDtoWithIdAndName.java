package com.employeemanagement.backend.dto;

import java.util.Objects;

public class ProjectOutDtoWithIdAndName {
    /**
     * store project id.
     */
    private Long id;
    /**
     * store project name.
     */
    private String projectName;

    /**
     * Used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, projectName);
    }

    /**
     * Used to chech for equality.
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
        ProjectOutDtoWithIdAndName
        other = (ProjectOutDtoWithIdAndName) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(projectName, other.projectName);
    }

    /**
     * Used to know data of object.
     */
    @Override
    public String toString() {
        return "ProjectForRequestResourseOutDto [id=" + id
                + ", projectName=" + projectName + "]";
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param projectId the id to set
     */
    public void setId(final Long projectId) {
        this.id = projectId;
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectsName the projectName to set
     */
    public void setProjectName(final String projectsName) {
        this.projectName = projectsName;
    }
}
