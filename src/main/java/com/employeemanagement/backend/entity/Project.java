package com.employeemanagement.backend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

/**
 * Used to create table for Project.
 */
@Entity
public class Project {

    /**
     * primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * project name.
     */
    @Column(nullable = false, unique = true)
    private String projectName;
    /**
     * manager id.
     */
    @Column(nullable = false)
    private Long managerId;
    /**
     * starting date.
     */
    @Column(nullable = false)
    private String startDate;
    /**
     * list of skills.
     */
    @Column(nullable = false)
    private List<String> skills;
    /**
     * descrioption(can store long descrioption).
     */
    @Lob
    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String description;

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, id, managerId, projectName, skills,
                startDate);
    }

    /**
     * used to compare object.
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

        Project other = (Project) obj;
        return Objects.equals(description, other.description)
                && Objects.equals(id, other.id)
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
        return "Project [id=" + id + ", projectName=" + projectName
                + ", managerId=" + managerId + ", startDate=" + startDate
                + ", skills=" + skills + ", description=" + description + "]";
    }

    /**
     * Getting immutable project skills.
     *
     * @return return copy of skills
     */
    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    /**
     * setting immutable project skills.
     *
     * @param newSkills accept copy of skills.
     */
    public void setSkills(final List<String> newSkills) {
        this.skills = new ArrayList<>(newSkills);
    }

    /**
     * Get the unique identifier (ID) of the project.
     *
     * @return The project's unique identifier (ID).
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier (ID) of the project.
     *
     * @param projectId The new unique identifier (ID) for the project.
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
     * Get the manager's unique identifier for the project.
     *
     * @return The manager's unique identifier.
     */
    public Long getManagerId() {
        return managerId;
    }

    /**
     * Set the manager's unique identifier for the project.
     *
     * @param projectManagerId The new manager's unique identifier
     *  for the project.
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
