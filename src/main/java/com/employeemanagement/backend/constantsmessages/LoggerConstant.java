package com.employeemanagement.backend.constantsmessages;

/**
 * Messages for loggers of each controller.
 */
public final class LoggerConstant {

    /**
     * No args constructor.
     */
    private LoggerConstant() {
    }
    /**
     * Message for addAdmin before calling service.
     */
    public static final String ADDADMIN_INMESSAGE = "Request received to login"
            + " employee with data: ";
    /**
     * Message for addAdmin after calling service.
     */
    public static final String ADDADMIN_OUTMESSAGE = "Employee login"
            + " successfully.";

    /**
     * Message for getAllEmployee before calling service.
     */
    public static final String GETALLEMPLOYEE_INMESSAGE = "Request received"
            + " to get All Employee employee with data: ";
    /**
     * Message for getAllEmployee after calling service.
     */
    public static final String GETALLEMPLOYEE_OUTMESSAGE = "Successfully"
            + " fetched the data of All Employee.";

    /**
     * Message for getAllEmployeeForOrganization before calling service.
     */
    public static final String GETALLEMPLOYEEFORORGANIZATION_INMESSAGE =
            "Request received to get All Employee For Organization.";
    /**
     * Message for getAllEmployeeForOrganization after calling service.
     */
    public static final String GETALLEMPLOYEEFORORGANIZATION_OUTMESSAGE =
            "Successfully fetched the data of All Employee For Organization.";

    /**
     * Message for addEmployee before calling service.
     */
    public static final String ADDEMPLOYEE_INMESSAGE =
            "Request received to add employee with data ";
    /**
     * Message for addEmployee after calling service.
     */
    public static final String ADDEMPLOYEE_OUTMESSAGE =
            "Employee added successfully.";

    /**
     * Message for getAllManager before calling service.
     */
    public static final String GETALLMANAGER_INMESSAGE =
            "Request received to get All Manager.";
    /**
     * Message for getAllManager after calling service.
     */
    public static final String GETALLMANAGER_OUTMESSAGE =
            "Successfully fetched the data of All Manager.";

    /**
     * Message for getAllManagerForProject before calling service.
     */
    public static final String GETALLMANAGERFORPROJECT_INMESSAGE =
            "Request received to get All Manager For Project.";
    /**
     * Message for getAllManagerForProject after calling service.
     */
    public static final String GETALLMANAGERFORPROJECT_OUTMESSAGE =
            "Successfully fetched the data of All Manager For Project.";

    /**
     * Message for assignProjectToManager before calling service.
     */
    public static final String ASSIGNPROJECTTOMANAGER_INMESSAGE =
            "Request received to assign project to manager with data ";
    /**
     * Message for assignProjectToManager after calling service.
     */
    public static final String ASSIGNPROJECTTOMANAGER_OUTMESSAGE =
            "Project assigned successfully to the manager.";

    /**
     * Message for getEmployeeByEmailId before calling service.
     */
    public static final String GETEMPLOYEEBYEMAILID_INMESSAGE =
            "Request received to get employee by email id with data ";
    /**
     * Message for getEmployeeByEmailId after calling service.
     */
    public static final String GETEMPLOYEEBYEMAILID_OUTMESSAGE =
            "Successfully fetched the data of employee by email id.";

    /**
     * Message for assignProjectToEmployee before calling service.
     */
    public static final String ASSIGNPROJECTTOEMPLOYEE_INMESSAGE =
            "Request received to assign project to employee with data ";
    /**
     * Message for assignProjectToEmployee after calling service.
     */
    public static final String ASSIGNPROJECTTOEMPLOYEE_OUTMESSAGE =
            "Project assigned successfully to employee.";

    /**
     * Message for updateEmployeeSkills before calling service.
     */
    public static final String UPDATEEMPLOYEESKILLS_INMESSAGE =
            "Request received to update employee skills with data ";
    /**
     * Message for updateEmployeeSkills after calling service.
     */
    public static final String UPDATEEMPLOYEESKILLS_OUTMESSAGE =
            "Employee skills updated successfully.";

    /**
     * Message for filteredEmployee before calling service.
     */
    public static final String FILTEREDEMPLOYEE_INMESSAGE =
            "Request received to get filtered employee with data ";
    /**
     * Message for filteredEmployee after calling service.
     */
    public static final String FILTEREDEMPLOYEE_OUTMESSAGE =
            "Successfully fetched the data of filtered employee.";

    /**
     * Message for unassignedProjectToEmployee before calling service.
     */
    public static final String UNASSIGNEDPROJECTTOEMPLOYEE_INMESSAGE =
            "Request received to Un Assigned project to employee with data ";
    /**
     * Message for unassignedProjectToEmployee after calling service.
     */
    public static final String UNASSIGNEDPROJECTTOEMPLOYEE_OUTMESSAGE =
            "Successfully unassigned project to employee.";
//PRJOECT
    /**
     * Message for addProject before calling service.
     */
    public static final String ADDPROJECT_INMESSAGE =
            "Request received to add project with data ";
    /**
     * Message for addProject after calling service.
     */
    public static final String ADDPROJECT_OUTMESSAGE =
            "Project added successfully.";

    /**
     * Message for getProject before calling service.
     */
    public static final String GETPROJECT_INMESSAGE =
            "Request received get projects.";
    /**
     * Message for getProject after calling service.
     */
    public static final String GETPROJECT_OUTMESSAGE =
            "Successfully fetched the data of projects.";

    /**
     * Message for getProjectByManagerId before calling service.
     */
    public static final String GETPROJECTBYMANAGERID_INMESSAGE =
            "Request received to get project by manager id.";
    /**
     * Message for getProjectByManagerId after calling service.
     */
    public static final String GETPROJECTBYMANAGERID_OUTMESSAGE =
            "Successfully fetched the data of project by manager id.";

    /**
     * Message for getProjectById before calling service.
     */
    public static final String GETPROJECTBYID_INMESSAGE =
            "Request received to get project by project id.";
    /**
     * Message for getProjectById after calling service.
     */
    public static final String GETPROJECTBYID_OUTMESSAGE =
            "Successfully fetched the data of project by project id.";

    /**
     * Message for getProjectByManagerEmailId before calling service.
     */
    public static final String GETALLPROJECTBYMANAGEREMAILID_INMESSAGE =
            "Request received to get all projects"
            + " by manager email id with data ";
    /**
     * Message for getProjectByManagerEmailId after calling service.
     */
    public static final String GETALLPROJECTBYMANAGEREMAILID_OUTMESSAGE =
            "Successfully fetched the data of all "
            + "projects by manager email id.";
//REQUEST RESOURCE
    /**
     * Message for addRequest before calling service.
     */
    public static final String ADDREQUEST_INMESSAGE =
            "Request received to add request Resource with data ";
    /**
     * Message for addRequest after calling service.
     */
    public static final String ADDREQUEST_OUTMESSAGE =
            "Request resource added successfully.";

    /**
     * Message for checkRequestForEmployee before calling service.
     */
    public static final String CHECKREQUESTFOREMPLOYEE_INMESSAGE =
            "Request received to check request Resource for employee function"
            + " with data ";
    /**
     * Message for checkRequestForEmployee after calling service.
     */
    public static final String CHECKREQUESTFOREMPLOYEE_OUTMESSAGE =
            "Request ended to check request Resource for employee.";

    /**
     * Message for getAllRequest before calling service.
     */
    public static final String GETALLREQUEST_INMESSAGE =
            "Request received to get all requests.";
    /**
     * Message for getAllRequest after calling service.
     */
    public static final String GETALLREQUEST_OUTMESSAGE =
            "Successfully fetched the data of all requests.";

    /**
     * Message for deleteRequest before calling service.
     */
    public static final String DELETEREQUEST_INMESSAGE =
            "Request received to delete request by request id ";
    /**
     * Message for deleteRequest after calling service.
     */
    public static final String DELETEREQUEST_OUTMESSAGE =
            "Request deleted successfully by request id.";

    /**
     * Message for acceptRequest before calling service.
     */
    public static final String ACCEPTREQUEST_INMESSAGE =
            "Request received to accept request with data ";
    /**
     * Message for acceptRequest after calling service.
     */
    public static final String ACCEPTREQUEST_OUTMESSAGE =
            "Request accepted successfully.";

}
