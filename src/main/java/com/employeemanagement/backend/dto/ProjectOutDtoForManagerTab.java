package com.employeemanagement.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ProjectOutDtoForManagerTab {
    /**
     * store project id.
     */
    private Long id;
    /**
     * store project name.
     */
    private String projectName;
    /**
     * stores list of skills.
     */
    private List<String> skills;
    /**
     * Stores name on people working on same project.
     */
    private List<String> team;

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
     * Used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, skills, team);
    }

    /**
     * Used to check for equality between objects.
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
        ProjectOutDtoForManagerTab other = (ProjectOutDtoForManagerTab) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(projectName, other.projectName)
                && Objects.equals(skills, other.skills)
                && Objects.equals(team, other.team);
    }

    /**
     * Used to know value of object.
     */
    @Override
    public String toString() {
        return "ProjectOutDtoForManagerTab [id=" + id + ", projectName="
                + projectName + ", skills=" + skills + ", team=" + team + "]";
    }
}
