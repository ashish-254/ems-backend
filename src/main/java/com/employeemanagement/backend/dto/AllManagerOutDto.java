package com.employeemanagement.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Response for all the managers only.
 */
public class AllManagerOutDto {

    /**
     * Default Constructor.
     */
    public AllManagerOutDto() {
    }

    /**
     * employee id(primary key).
     */
    private Long emId;
    /**
     * employee id given by user.
     */
    private String empId;
    /**
     * employee name given by user.
     */
    private String empName;
    /**
     * employee email given by user.
     */
    private String empEmail;
    /**
     * employee DOJ given by user.
     */
    private String empDoj;
    /**
     * employee designation given by user.
     */
    private String empDesignation;
    /**
     * employee location given by user.
     */
    private String empLocation;
    /**
     * employee conatct numeber.
     */
    private String empContactNo;

    /**
     * employee project.
     */
    private List<Long> empProjectId;
    /**
     * List of skills of manager.
     */
    private List<String> empSkills;

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(emId, empContactNo, empDesignation, empDoj,
                empEmail, empId, empLocation, empName, empProjectId, empSkills);
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
        AllManagerOutDto other = (AllManagerOutDto) obj;
        return Objects.equals(emId, other.emId)
                && Objects.equals(empContactNo, other.empContactNo)
                && Objects.equals(empDesignation, other.empDesignation)
                && Objects.equals(empDoj, other.empDoj)
                && Objects.equals(empEmail, other.empEmail)
                && Objects.equals(empId, other.empId)
                && Objects.equals(empLocation, other.empLocation)
                && Objects.equals(empName, other.empName)
                && Objects.equals(empProjectId, other.empProjectId)
                && Objects.equals(empSkills, other.empSkills);
    }

    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "AllManagerOutDto [emId=" + emId + ", empId=" + empId
                + ", empName=" + empName + ", empEmail=" + empEmail
                + ", empDoj=" + empDoj + ", empDesignation=" + empDesignation
                + ", empLocation=" + empLocation + ", empContactNo="
                + empContactNo + ", empProject=" + empProjectId + ", empSkills="
                + empSkills + "]";
    }

    /**
     * Getting immutable emloyee skills.
     *
     * @return return copy of skills
     */
    public List<String> getEmpSkills() {
        return new ArrayList<>(empSkills);
    }

    /**
     * setting immutable employee skills.
     *
     * @param skills accept copy of skills.
     */
    public void setEmpSkills(final List<String> skills) {
        this.empSkills = new ArrayList<>(skills);
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
     * @param employeeId The new unique identifier (emId) for the employee.
     */
    public void setEmId(final Long employeeId) {
        this.emId = employeeId;
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
     * @param employeeId The new unique identifier (empId) for the employee.
     */
    public void setEmpId(final String employeeId) {
        this.empId = employeeId;
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
     * @param employeeName The new name for the employee.
     */
    public void setEmpName(final String employeeName) {
        this.empName = employeeName;
    }

    /**
     * Get the email address of the employee.
     *
     * @return The employee's email address.
     */
    public String getEmpEmail() {
        return empEmail;
    }

    /**
     * Set the email address of the employee.
     *
     * @param employeeEmail The new email address for the employee.
     */
    public void setEmpEmail(final String employeeEmail) {
        this.empEmail = employeeEmail;
    }

    /**
     * Get the date of joining of the employee.
     *
     * @return The employee's date of joining.
     */
    public String getEmpDoj() {
        return empDoj;
    }

    /**
     * Set the date of joining of the employee.
     *
     * @param employeeDoj The new date of joining for the employee.
     */
    public void setEmpDoj(final String employeeDoj) {
        this.empDoj = employeeDoj;
    }

    /**
     * Get the job designation or title of the employee.
     *
     * @return The employee's job designation.
     */
    public String getEmpDesignation() {
        return empDesignation;
    }

    /**
     * Set the job designation or title of the employee.
     *
     * @param employeeDesignation The new job designation for the employee.
     */
    public void setEmpDesignation(final String employeeDesignation) {
        this.empDesignation = employeeDesignation;
    }

    /**
     * Get the location or office address of the employee.
     *
     * @return The employee's location.
     */
    public String getEmpLocation() {
        return empLocation;
    }

    /**
     * Set the location or office address of the employee.
     *
     * @param employeeLocation The new location for the employee.
     */
    public void setEmpLocation(final String employeeLocation) {
        this.empLocation = employeeLocation;
    }

    /**
     * Get the contact number of the employee.
     *
     * @return The employee's contact number.
     */
    public String getEmpContactNo() {
        return empContactNo;
    }

    /**
     * Set the contact number of the employee.
     *
     * @param employeeContactNo The new contact number for the employee.
     */
    public void setEmpContactNo(final String employeeContactNo) {
        this.empContactNo = employeeContactNo;
    }

    /**
     * Get the assigned project's ids.
     *
     * @return The employee's project ids.
     */
    public List<Long> getEmpProjectId() {
        return new ArrayList<>(empProjectId);
    }

    /**
     * Set the project id of the employee.
     *
     * @param employeeProjectId the new project ids of employee.
     */
    public void setEmpProjectId(final List<Long>
    employeeProjectId) {
        this.empProjectId = new ArrayList<>(employeeProjectId);
    }

}
