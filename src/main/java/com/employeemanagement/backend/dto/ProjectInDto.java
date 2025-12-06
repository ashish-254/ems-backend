package com.employeemanagement.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


/**
 * used to store project on project table.
 */
public class ProjectInDto {

    /**
     * store project name.
     */
    @NotBlank(message = ErrorConstant.EMPTY_NAME)
    private String projectName;
    /**
     * store manager id(primary key).
     */
    @NotNull(message = ErrorConstant.EMPTY_MANAGER_ID)
    private Long managerId;
    /**
     * store start date of project.
     */
    @NotEmpty(message = ErrorConstant.EMPTY_STARTDATE)
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-"
            + "(19|20)\\d\\d$", message = ErrorConstant.INVALID_STARTDATE)
    private String startDate;
    /**
     * stores list of skills.
     */
    @NotNull(message = ErrorConstant.NULL_SKILLS)
    @NotEmpty(message = ErrorConstant.EMPTY_SKILLS)
    private List<String> skills;
    /**
     * stores descrioption of project.
     */
    @NotBlank(message = ErrorConstant.EMPTY_DESCRIPTION)
    private String description;

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, managerId, projectName, skills,
                startDate);
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
        ProjectInDto other = (ProjectInDto) obj;
        return Objects.equals(description, other.description)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(projectName, other.projectName)
                && Objects.equals(skills, other.skills)
                && Objects.equals(startDate, other.startDate);
    }

    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "ProjectInDto [projectName=" + projectName
                + ", managerId=" + managerId + ", startDate=" + startDate
                + ", skills=" + skills + ", description=" + description + "]";
    }

    /**
     * Getting immutable emloyee skills.
     *
     * @return return copy of skills
     */
    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    /**
     * setting immutable project skills.
     *
     * @param projectSkills accept copy of skills.
     */
    public void setSkills(final List<String> projectSkills) {
        this.skills = new ArrayList<>(projectSkills);
    }


    /**
     * Get the name of the project.
     *
     * @return The project's name.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Set the name of the project.
     *
     * @param projectsName The new name for the project.
     */
    public void setProjectName(final String projectsName) {
        this.projectName = projectsName;
    }

    /**
     * Get the unique identifier for the project manager.
     *
     * @return The project manager's unique ID.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * Set the unique identifier for the project manager.
     *
     * @param projectManagerId The new unique ID for the project manager.
     */
    public void setManagerId(final Long projectManagerId) {
        this.managerId = projectManagerId;
    }

    /**
     * Get the start date of the project.
     *
     * @return The project's start date.
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Set the start date of the project.
     *
     * @param projectStartDate The new start date for the project.
     */
    public void setStartDate(final String projectStartDate) {
        this.startDate = projectStartDate;
    }

    /**
     * Get the description of the project.
     *
     * @return The project's description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the project.
     *
     * @param projectDescription The new description for the project.
     */
    public void setDescription(final String projectDescription) {
        this.description = projectDescription;
    }

}
