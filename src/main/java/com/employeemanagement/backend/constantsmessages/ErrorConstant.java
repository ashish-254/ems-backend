package com.employeemanagement.backend.constantsmessages;

/**
 * Constants for exceptions.
 */
public final class ErrorConstant {
    /**
     * Default constructor.
     */
    private ErrorConstant() {
    }
    /**
     * Constant for empty employee id.
     */
    public static final String EMPTY_EMP_ID = "Employee Id should not be"
            + " empty.";
    /**
     * Constant for invalid employee id.
     */
    public static final String INVALID_EMP_ID = "Not a valid employee id."
            + "Employee Id should be in the form " + "of NXXXX (X is number)"
                    + " and should not be N0000.";
    /**
     * Constant for invalid employee id for N0000.
     */
    public static final String INVALID_EMP_ID_N0000 = "Not a valid employee id."
            + "Employee Id should not be N0000.";

    /**
     * Constant for empty dob.
     */
    public static final String EMPTY_DOB = "Employee DOB should not be empty.";
    /**
     * Constant for invalid dob.
     */
    public static final String INVALID_DOB = "Not a valid DOB. "
            + "DOB should be in the form of dd-mm-yyyy.";
    /**
     * Constant for invalid dob for future date.
     */
    public static final String INVALID_DOB_FUTURE_DATE = "DOB cannot be a"
            + " future date.";

    /**
     * Constant for empty doj.
     */
    public static final String EMPTY_DOJ = "Employee DOJ should not be empty.";
    /**
     * Constant for invalid doj.
     */
    public static final String INVALID_DOJ = "Not a valid DOJ. "
            + "DOJ should be in the form of dd-mm-yyyy.";
    /**
     * Constant for empty doj.
     */
    public static final String EMPTY_ROLE = "Role"
            + " should not be empty.";
    /**
     * Constant for invalid doj for future date.
     */
    public static final String INVALID_DOJ_FUTURE_DATE = "DOJ cannot be a"
            + " future date.";

    /**
     * Constant for invalid date difference.
     */
    public static final String INVALID_DATE_DIFFERENCE = "DOB should be atleast"
            + " 18 year older than DOJ.";

    /**
     * Constant for empty email.
     */
    public static final String EMPTY_EMAIL = "Email should not"
            + " be empty.";
    /**
     * Constant for invalid email.
     */
    public static final String INVALID_EMAIL = "Encorrect email. "
            + "Email must have domain as @nucleusteq.com.";
    /**
     * Constant for invalid email for admin.
     */
    public static final String INVALID_ADMIN_EMAIL = "Admin should have email"
            + " id as ankita.sharma@nucleusteq.com.";

    /**
     * Constant for empty contact.
     */
    public static final String EMPTY_CONTACT = "Contact number should"
            + " not be empty.";
    /**
     * Constant for invalid contact.
     */
    public static final String INVALID_CONTACT = "Not a valid Valid"
            + " Contact Number. "
            + "Contact Number should have only 10 digits.";

    /**
     * Constant for invalid contact.
     */
    public static final String INVALID_SKILLS = " is not a valid skill.";

    /**
     * Constant for empty password.
     */
    public static final String EMPTY_PASSWORD = "Password should not be empty.";
    /**
     * Constant for invalid password.
     */
    public static final String INVALID_PASSWORD = "Invalid password. Password"
            + " should contain atleast "
            + "8 digit numbers or letters or both.";
    /**
     * Constant for incorrect password.
     */
    public static final String INCORRECT_PASSWORD = "Incorrect Password.";

    /**
     * Constant for empty name.
     */
    public static final String EMPTY_NAME = "Name should not be empty.";
    /**
     * Constant for invalid name.
     */
    public static final String INVALID_NAME = "Invalid name. "
            + "Name should not be empty "
            + "and should contains only characters not number.";

    /**
     * Constant for empty location.
     */
    public static final String EMPTY_LOCATION = "Location should not"
            + " be empty.";
    /**
     * Constant for invalid location.
     */
    public static final String INVALID_LOCATION = "Not a valid location.";

    /**
     * Constant for empty designation.
     */
    public static final String EMPTY_DESIGNATION = "Designation should"
            + " not be empty.";
    /**
     * Constant for invalid designation.
     */
    public static final String INVALID_DESIGNATION = "Not a valid"
            + " designation.";
    /**
     * Constant for empty manager id.
     */
    public static final String EMPTY_MANAGER_ID = "Manager id should"
            + " not be empty.";

    /**
     * Constant for invalid role.
     */
    public static final String INVALID_ROLE = "Not a valid role.";

    /**
     * Constant for email already exist.
     */
    public static final String EMAIL_ALREADY_EXIST = "Email already exist.";
    /**
     * Constant for employee id already exist.
     */
    public static final String EMPID_ALREADY_EXIST = "Id already "
            + "exist.";
    /**
     * Constant for employee contact already exist.
     */
    public static final String EMPCONTACT_ALREADY_EXIST = "Contact already "
            + "exist.";

    /**
     * Constant for employee if email not exist.
     */
    public static final String EMAIL_NOT_EXIST = "Email does not exist.";
    /**
     * Constant for employee if id not exist.
     */
    public static final String EMPID_NOT_EXIST = "Id does not exist.";
    /**
     * Constant for employee if contact not exist.
     */
    public static final String EMPCONTACT_NOT_EXIST = "Contact number does not"
            + " exist.";
    /**
     * Constant for employee if employee not exist.
     */
    public static final String EMID_NOT_EXIST = "Employee not exist.";

    /**
     * Constant if not a manager.
     */
    public static final String NOT_A_MANAGER = "Not a manager.";
    /**
     * Constant if not a employee.
     */
    public static final String NOT_AN_EMPLOYEE = "Not an Employee.";

//Project
    /**
     * Constant for empty project id.
     */
    public static final String EMPTY_PROJECTID = "Project id should not"
            + " be empty.";
    /**
     * Constant for empty project manager.
     */
    public static final String EMPTY_PROJECTMANAGERID = "Manager id"
            + " should not be empty.";
    /**
     * Constant for empty project manager.
     */
    public static final String EMPTY_COMMENT = "Project comment"
            + " should not be empty.";

    /**
     * Constant if employee not having any project.
     */
    public static final String EMPLOYEE_NOT_HAVE_PROJECT = "Employee not having"
            + " any project assigned.";
    /**
     * Constant if employee having a project.
     */
    public static final String EMPLOYEE_HAVE_PROJECT = "Employee already have"
            + " project.";
    /**
     * Constant for empty start date.
     */
    public static final String EMPTY_STARTDATE = "Project start date should not"
            + " be empty.";
    /**
     * Constant for empty start date.
     */
    public static final String INVALID_STARTDATE = "Not a valid startd date. "
            + "Project start date should be in the " + "form of dd-mm-yyyy.";
    /**
     * Constant for empty skills.
     */
    public static final String NULL_SKILLS = "Skills should not be null.";
    /**
     * Constant for empty skills.
     */
    public static final String EMPTY_SKILLS = "Skills should not be empty.";
    /**
     * Constant for empty description.
     */
    public static final String EMPTY_DESCRIPTION = "Description should not be"
            + " empty.";
    /**
     * Constant if project name already exist.
     */
    public static final String PROJECT_NAME_ALREADY_EXIST = "Project name"
            + " already exist.";
    /**
     * Constant if project name already exist.
     */
    public static final String PROJECT_NOT_EXIST = "Project not exist.";

// Request resourse
    /**
     * Constant if employee not exist in employee table.
     */
    public static final String EMPLOYEE_NOT_EXIST = "Employee doesn't exists.";
    /**
     * Constant if manager not exist in employee table.
     */
    public static final String MANAGER_NOT_EXIST = "Manager doesn't exists.";
    /**
     * Constant if request not exist in request resource table.
     */
    public static final String REQUEST_NOT_EXIST = "Request doesn't exists.";
    /**
     * Constant if manager not exist in request resource table.
     */
    public static final String MANAGER_NOT_EXIST_IN_REQ_RES_TABLE = "Manager"
            + " doesn't exist in Request Resourse table.";
    /**
     * Constant if employee not exist in request resource table.
     */
    public static final String EMPLOYEE_NOT_EXIST_IN_REQ_RES_TABLE = "Employee"
            + " doesn't exist in Request Resourse table.";
    /**
     * Constant if project not exist in request resource table.
     */
    public static final String PROJECT_NOT_EXIST_IN_REQ_RES_TABLE = "Project"
         + " doesn't exist in Request Resourse table.";

    /**
     * Constant for null field.
     */
    public static final String NOT_NULL = "Field should not be null.";
    /**
     * Constant for empty field.
     */
    public static final String NOT_EMPTY = "Field shoud not be empty.";
}
