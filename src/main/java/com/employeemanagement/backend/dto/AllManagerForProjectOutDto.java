package com.employeemanagement.backend.dto;

import java.util.Objects;


/**
 * Response dto for the project.
 */
public class AllManagerForProjectOutDto {


    /**
     * employee id(primary key).
     */
    private Long emId;
    /**
     * employee name.
     */
    private String empName;
    /**
     * employee id.
     */
    private String empId;

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(emId, empId, empName);
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
        AllManagerForProjectOutDto other =
                (AllManagerForProjectOutDto) obj;
        return Objects.equals(emId, other.emId)
                && Objects.equals(empId, other.empId)
                && Objects.equals(empName, other.empName);
    }

    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "AllManagerForProjectOutDto [emId=" + emId + ", empName="
                + empName + ", empId=" + empId + "]";
    }

    /**
     * Get the unique identifier (emId) for the employee.
     *
     * @return The employee's unique identifier (emId).
     */
    public Long getEmId() {
        return emId;
    }

    /**
     * Set the unique identifier (emId) for the employee.
     *
     * @param managerId The new unique identifier (emId) for the employee.
     */
    public void setEmId(final Long managerId) {
        this.emId = managerId;
    }

    /**
     * Get the name of the employee.
     *
     * @return The employee's name.
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * Set the name of the employee.
     *
     * @param managerName The new name for the employee.
     */
    public void setEmpName(final String managerName) {
        this.empName = managerName;
    }

    /**
     * Get the unique identifier (empId) for the employee.
     *
     * @return The employee's unique identifier (empId).
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * Set the unique identifier (empId) for the employee.
     *
     * @param managerId The new unique identifier (empId) for the employee.
     */
    public void setEmpId(final String managerId) {
        this.empId = managerId;
    }

}
