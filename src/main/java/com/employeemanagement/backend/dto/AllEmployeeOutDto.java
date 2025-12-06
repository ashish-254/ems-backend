package com.employeemanagement.backend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Response All Employee Dto.
 */
public class AllEmployeeOutDto {

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
     * employee DOB given by user.
     */
    private String empDob;
    /**
     * employee DOJ given by user.
     */
    private String empDoj;
    /**
     * employee location given by user.
     */
    private String empLocation;
    /**
     * employee designation given by user.
     */
    private String empDesignation;
    /**
     * employee contact number given by user.
     */
    private String empContactNo;

    /**
     * employee project name.
     */
    private List<Long> empProjectId;

    /**
     * stores employees manager.
     */
    private Long empManagerId;

    /**
     * Employee Skills.
     */
    private List<String> empSkills;
    /**
     * Employee's manager name.
     */
    private String managerName;

    /**
     * used to generate hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(empContactNo, empDesignation, empDob, empDoj,
                empEmail, empId, empLocation, empManagerId, empName,
                empProjectId, empSkills, managerName);
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
        AllEmployeeOutDto other = (AllEmployeeOutDto) obj;
        return Objects.equals(empContactNo, other.empContactNo)
                && Objects.equals(empDesignation, other.empDesignation)
                && Objects.equals(empDob, other.empDob)
                && Objects.equals(empDoj, other.empDoj)
                && Objects.equals(empEmail, other.empEmail)
                && Objects.equals(empId, other.empId)
                && Objects.equals(empLocation, other.empLocation)
                && Objects.equals(empManagerId, other.empManagerId)
                && Objects.equals(empName, other.empName)
                && Objects.equals(empProjectId, other.empProjectId)
                && Objects.equals(empSkills, other.empSkills)
                && Objects.equals(managerName, other.managerName);
    }

    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "AllEmployeeOutDto [empId=" + empId + ", empName=" + empName
                + ", empEmail=" + empEmail + ", empDob=" + empDob + ", empDoj="
                + empDoj + ", empLocation=" + empLocation + ", empDesignation="
                + empDesignation + ", empContactNo=" + empContactNo
                + ", empProjectId=" + empProjectId + ", empManagerId="
                + empManagerId + ", empSkills=" + empSkills + ", managerName="
                + managerName + "]";
    }

    /**
     * Get the unique identifier for the employee.
     *
     * @return The employee's unique ID.
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * Set the unique identifier for the employee.
     *
     * @param employeeId The new unique ID for the employee.
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
     * Get the date of birth of the employee.
     *
     * @return The employee's date of birth.
     */
    public String getEmpDob() {
        return empDob;
    }

    /**
     * Set the date of birth of the employee.
     *
     * @param employeeDob The new date of birth for the employee.
     */
    public void setEmpDob(final String employeeDob) {
        this.empDob = employeeDob;
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
     * Get the list of projects of the employee.
     *
     * @return The employee's project list.
     */
    public List<Long> getEmpProjectId() {
        return new ArrayList<>(empProjectId);
    }

    /**
     * Set the current project or assignment of the employee.
     *
     * @param employeeProjectId The new project for the employee.
     */
    public void setEmpProjectId(final List<Long> employeeProjectId) {
        this.empProjectId = new ArrayList<>(employeeProjectId);
    }

    /**
     * Get the manager or supervisor of the employee.
     *
     * @return The employee's manager.
     */
    public Long getEmpManagerId() {
        return empManagerId;
    }

    /**
     * Set the manager or supervisor of the employee.
     *
     * @param employeeManagerId The new manager for the employee.
     */
    public void setEmpManagerId(final Long employeeManagerId) {
        this.empManagerId = employeeManagerId;
    }

    /**
     * Get the skills of employee.
     *
     * @return The employeee's skills.
     */
    public List<String> getEmpSkills() {
        return new ArrayList<>(empSkills);
    }

    /**
     * Set the skills of the employee.
     *
     * @param employeeSkills The new skills for employee.
     */
    public void setEmpSkills(final List<String> employeeSkills) {
        this.empSkills = new ArrayList<>(employeeSkills);
    }

    /**
     * @return the managerName.
     */
    public String getManagerName() {
        return managerName;
    }

    /**
     * @param employeeManagerName the managerName to set.
     */
    public void setManagerName(final String employeeManagerName) {
        this.managerName = employeeManagerName;
    }

}
