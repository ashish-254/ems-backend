package com.employeemanagement.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * Dto to search employee by filter.
 */
public class SearchFilteredEmployeeInDto {
    /**
     * List of selected skills.
     */
    private List<String> selectedSkills;
    /**
     * Bolean value to check, for only unassigned employee.
     */
    private boolean showOnlyUnassigned;

    /**
     * Used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(selectedSkills, showOnlyUnassigned);
    }

    /**
     * Used to check for equation for objects.
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
        SearchFilteredEmployeeInDto other = (SearchFilteredEmployeeInDto) obj;
        return Objects.equals(selectedSkills, other.selectedSkills)
                && showOnlyUnassigned == other.showOnlyUnassigned;
    }

    /**
     * Used to get values of object.
     */
    @Override
    public String toString() {
        return "SearchFilteredEmployeeInDto [selectedSkills=" + selectedSkills
                + ", showOnlyUnassigned=" + showOnlyUnassigned + "]";
    }

    /**
     * @return the selectedSkills
     */
    public List<String> getSelectedSkills() {
        return new ArrayList<String>(selectedSkills);
    }

    /**
     * @param filteredEmployeeSelectedSkills the selectedSkills to set
     */
    public void setSelectedSkills(
            final List<String> filteredEmployeeSelectedSkills) {
        this.selectedSkills = new ArrayList<String>(
                filteredEmployeeSelectedSkills);
    }

    /**
     * @return the showOnlyUnassigned
     */
    public boolean isShowOnlyUnassigned() {
        return showOnlyUnassigned;
    }

    /**
     * @param filteredEmployeeShowOnlyUnassigned the showOnlyUnassigned to set
     */
    public void setShowOnlyUnassigned(
            final boolean filteredEmployeeShowOnlyUnassigned) {
        this.showOnlyUnassigned = filteredEmployeeShowOnlyUnassigned;
    }

}
