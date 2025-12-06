package com.employeemanagement.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


/**
 * Dto to update skills.
 */
public class UpdateSkillsInDto {
    /**
     * Skills.
     */
    @NotNull(message = ErrorConstant.NULL_SKILLS)
    @NotEmpty(message = ErrorConstant.EMPTY_SKILLS)
    private List<String> skills;

    /**
     * @return the skills
     */
    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }

    /**
     * @param newSkills the skills to set
     */
    public void setSkills(final List<String> newSkills) {
        this.skills = new ArrayList<>(newSkills);
    }

    /**
     * Used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(skills);
    }

    /**
     * used to equate objects.
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
        UpdateSkillsInDto other = (UpdateSkillsInDto) obj;
        return Objects.equals(skills, other.skills);
    }

    /**
     * Get value of object.
     */
    @Override
    public String toString() {
        return "UpdateSkillsInDto [skills=" + skills + "]";
    }

}
