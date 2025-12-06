package com.employeemanagement.backend.dto;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import com.employeemanagement.backend.constantsmessages.ErrorConstant;

/**
 * DTO used to assign project.
 */
public class AssignProjectInDto {

    /**
     * Have a variable which store the project id.
     */
    @NotNull(message = ErrorConstant.EMPTY_PROJECTID)
    private Long empProjectId;

    /**
     * getter for project id.
     *
     * @return project name.
     */
    public Long getEmpProjectId() {
        return empProjectId;
    }

    /**
     * setter for project id.
     *
     * @param employeeProjectId accept proejct Id.
     */
    public void setEmpProjectId(final Long employeeProjectId) {
        this.empProjectId = employeeProjectId;
    }

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(empProjectId);
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
        AssignProjectInDto other = (AssignProjectInDto) obj;
        return Objects.equals(empProjectId, other.empProjectId);
    }


    /**
     * used to get content of object.
     */
    @Override
    public String toString() {
        return "AssignProjectInDto [empProjectId=" + empProjectId + "]";
    }

}
