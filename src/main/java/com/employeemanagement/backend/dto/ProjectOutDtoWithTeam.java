package com.employeemanagement.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProjectOutDtoWithTeam {

    /**
     * store project id.
     */
    private Long id;
    /**
     * store project name.
     */
    private String projectName;
    /**
     * store manager id(primary key).
     */
    private Long managerId;
    /**
     * store start date of project.
     */
    private String startDate;
    /**
     * stores list of skills.
     */
    private List<String> skills;
    /**
     * stores descrioption of project.
     */
    private String description;
    /**
     * Manager Name.
     */
    private String managerName;

    /**
     * Stores name on people working on same project.
     */
    private List<String> team;

    /**
     * Used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, id, managerId, projectName, skills,
                startDate, team, managerName);
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
        ProjectOutDtoWithTeam other = (ProjectOutDtoWithTeam) obj;
        return Objects.equals(description, other.description)
                && Objects.equals(id, other.id)
                && Objects.equals(managerId, other.managerId)
                && Objects.equals(projectName, other.projectName)
                && Objects.equals(skills, other.skills)
                && Objects.equals(startDate, other.startDate)
                && Objects.equals(team, other.team)
                && Objects.equals(managerName, other.managerName);
    }

    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "ProjectOutDtoWithTeam [id=" + id + ", projectName="
                + projectName + ", managerId=" + managerId + ", startDate="
                + startDate + ", skills=" + skills + ", description="
                + description + ", managerName=" + managerName + ", team="
                + team + "]";
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
     * Get the unique identifier for the project.
     *
     * @return The project's unique ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier for the project.
     *
     * @param projectId The new unique ID for the project.
     */
    public void setId(final Long projectId) {
        this.id = projectId;
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

    /**
     * Getter for team.
     *
     * @return the team.
     */
    public List<String> getTeam() {
        return new ArrayList<>(team);
    }

    /**
     * Setter for team.
     *
     * @param projectTeam the team to set.
     */
    public void setTeam(final List<String> projectTeam) {
        this.team = new ArrayList<>(projectTeam);
    }

    /**
     * @return the managerName
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * @param projectManagerName the managerName to set
     */
    public void setManagerName(final String projectManagerName) {
        this.managerName = projectManagerName;
    }

}
