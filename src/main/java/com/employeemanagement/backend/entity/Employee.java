package com.employeemanagement.backend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.employeemanagement.backend.enumlists.Designation;
import com.employeemanagement.backend.enumlists.Location;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * this is the entity class which actually create table in database.
 */
@Entity
public class Employee {
    /**
     * primary key emId.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emId;
    /**
     * empId given by user. And it should be unique.
     */
    @Column(nullable = false, unique = true)
    private String empId;
    /**
     * empName given by user.
     */
    @Column(nullable = false)
    private String empName;
    /**
     * unique employee email given by user.
     */
    @Column(nullable = false, unique = true)
    private String empEmail;
    /**
     * employee DOB given by user.
     */
    @Column(nullable = false)
    private String empDob;
    /**
     * employee DOJ given by user.
     */
    @Column(nullable = false)
    private String empDoj;
    /**
     * employee location given by user.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Location empLocation;
    /**
     * employee designation given by user.
     */
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Designation empDesignation;
    /**
     * employee contact number given by user.
     */
    @Column(nullable = false, unique = true)
    private String empContactNo;
    /**
     * employee password given by user.
     */
    @Column(nullable = false)
    private String empPassword;

    /**
     * employee role.
     */
    @Column(nullable = false)
    private String empRole;

    /**
     * employee skills list.
     */
    @Column(nullable = false)
    private List<String> empSkills;

    /**
     * employee project.
     */
    @Column(nullable = false)
    private List<Long> empProjectId;
    /**
     * employee manager.
     */
    @Column(nullable = false)
    private Long empManagerId;

    /**
     * used to get hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(emId, empContactNo, empDesignation, empDob, empDoj,
                empEmail, empId, empLocation, empManagerId, empName,
                empPassword, empProjectId, empRole, empSkills);
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
        Employee other = (Employee) obj;
        return Objects.equals(emId, other.emId)
                && Objects.equals(empContactNo, other.empContactNo)
                && empDesignation == other.empDesignation
                && Objects.equals(empDob, other.empDob)
                && Objects.equals(empDoj, other.empDoj)
                && Objects.equals(empEmail, other.empEmail)
                && Objects.equals(empId, other.empId)
                && empLocation == other.empLocation
                && Objects.equals(empManagerId, other.empManagerId)
                && Objects.equals(empName, other.empName)
                && Objects.equals(empPassword, other.empPassword)
                && Objects.equals(empProjectId, other.empProjectId)
                && Objects.equals(empRole, other.empRole)
                && Objects.equals(empSkills, other.empSkills);
    }

    /**
     * used to get values of object.
     */
    @Override
    public String toString() {
        return "Employee [emId=" + emId + ", empId=" + empId + ", empName="
                + empName + ", empEmail=" + empEmail + ", empDob=" + empDob
                + ", empDoj=" + empDoj + ", empLocation=" + empLocation
                + ", empDesignation=" + empDesignation + ", empContactNo="
                + empContactNo + ", empPassword=" + empPassword + ", empRole="
                + empRole + ", empSkills=" + empSkills + ", empProject="
                + empProjectId + ", empManager=" + empManagerId + "]";
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
     * Get the location of the employee.
     *
     * @return The employee's location.
     */
    public Location getEmpLocation() {
        return empLocation;
    }

    /**
     * Set the location of the employee.
     *
     * @param employeeLocation The new location for the employee.
     */
    public void setEmpLocation(final Location employeeLocation) {
        this.empLocation = employeeLocation;
    }

    /**
     * Get the designation of the employee.
     *
     * @return The employee's designation.
     */
    public Designation getEmpDesignation() {
        return empDesignation;
    }

    /**
     * Set the designation of the employee.
     *
     * @param employeeDesignation The new designation for the employee.
     */
    public void setEmpDesignation(final Designation employeeDesignation) {
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
     * Get the password for employee authentication.
     *
     * @return The employee's password.
     */
    public String getEmpPassword() {
        return empPassword;
    }

    /**
     * Set the password for employee authentication.
     *
     * @param employeePassword The new password for the employee.
     */
    public void setEmpPassword(final String employeePassword) {
        this.empPassword = employeePassword;
    }

    /**
     * Get the role or position of the employee.
     *
     * @return The employee's role.
     */
    public String getEmpRole() {
        return empRole;
    }

    /**
     * Set the role or position of the employee.
     *
     * @param employeeRole The new role for the employee.
     */
    public void setEmpRole(final String employeeRole) {
        this.empRole = employeeRole;
    }

    /**
     * Get the current project or assignment of the employee.
     *
     * @return The employee's project.
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

}
