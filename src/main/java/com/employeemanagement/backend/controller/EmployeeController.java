package com.employeemanagement.backend.controller;

import com.employeemanagement.backend.constantsmessages.LoggerConstant;
import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.customexception.UnauthorizedAccessException;
import com.employeemanagement.backend.dto.AssignProjectInDto;
import com.employeemanagement.backend.dto.AssignProjectToEmployeeInDto;
import com.employeemanagement.backend.dto.EmployeeInDto;
import com.employeemanagement.backend.dto.EmployeeLoginDto;
import com.employeemanagement.backend.dto.AllEmployeeOutDto;
import com.employeemanagement.backend.dto.AllManagerOutDto;
import com.employeemanagement.backend.dto.AllManagerForProjectOutDto;
import com.employeemanagement.backend.dto.OutDto;
import com.employeemanagement.backend.dto.LoginOutDto;
import com.employeemanagement.backend.dto.SearchFilteredEmployeeInDto;
import com.employeemanagement.backend.dto.UpdateSkillsInDto;
import com.employeemanagement.backend.service.EmployeeService;
import com.employeemanagement.backend.validator.EmployeeValidator;

import jakarta.validation.Valid;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this CrossOrigin("*") - used to run on different localhosts.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    /**
     * it creates a instance and variable of EmployeeService class.
     */
    @Autowired
    private EmployeeService employeeService;
    /**
     * Create instance of EmployeeValidator to validate employee details.
     */
    @Autowired
    private EmployeeValidator employeeValidator;

    /**
     * Logger object.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeeController.class);

    /**
     * This function is adding an employee.
     *
     * @param employeeInDto get employee details from back-end.
     * @return employeeDto responseDto.
     * @throws DataAlreadyExistException
     * @throws InvalidInputException
     */
    @PostMapping("/addAdmin")
    public final OutDto addAdmin(
            @RequestBody @Valid final EmployeeInDto employeeInDto)
            throws InvalidInputException, DataAlreadyExistException {
        LOGGER.info("Request received to add admin with data "
                + employeeInDto.toString());
        employeeValidator.addAdminValidator(employeeInDto);
        OutDto response = employeeService.addAdmin(employeeInDto);
        LOGGER.info("Admin added successfully");
        return response;
    }

    /**
     * It is used to login the user.
     *
     * @param employeeLoginDto takes as input(email and password)
     * @return ResponseDto to front-end.
     * @throws InvalidInputException       throw exception while wrong
     *                                     credential.
     * @throws UnauthorizedAccessException Throws when password not match.s
     */
    @PostMapping("/login")
    public final LoginOutDto loginEmployee(
            @Valid @RequestBody final EmployeeLoginDto employeeLoginDto)
            throws InvalidInputException, UnauthorizedAccessException {
        LOGGER.info(LoggerConstant.ADDADMIN_INMESSAGE
                + employeeLoginDto.toString());
        employeeValidator.loginEmployeeValidator(employeeLoginDto);
        LoginOutDto response = employeeService
                .loginEmployee(employeeLoginDto);
        LOGGER.info(LoggerConstant.ADDADMIN_OUTMESSAGE);
        return response;
    }

    /**
     * To fetch all employee details.
     *
     * @return return list of all employees.
     */
    @GetMapping("/all")
    public final List<AllEmployeeOutDto> getAllEmployee() {
        LOGGER.info(LoggerConstant.GETALLEMPLOYEE_INMESSAGE);
        List<AllEmployeeOutDto> response = employeeService
                .getAllEmployee();
        LOGGER.info(LoggerConstant.GETALLEMPLOYEE_OUTMESSAGE);
        return response;
    }

    /**
     * To fetch all employee details for organization tab.
     *
     * @return return list of all employees.
     */
    @GetMapping("/allOrganizationEmployee")
    public final List<AllEmployeeOutDto> getAllEmployeeForOrganization() {
        LOGGER.info(LoggerConstant.GETALLEMPLOYEEFORORGANIZATION_INMESSAGE);
        List<AllEmployeeOutDto> response = employeeService
                .getAllEmployeeForOrganization();
        LOGGER.info(LoggerConstant.GETALLEMPLOYEEFORORGANIZATION_OUTMESSAGE);
        return response;
    }

    /**
     * To add an employee.
     *
     * @param employeeInDto accept Dto.
     * @return return Dto to the frontend.
     * @throws DataAlreadyExistException throw if employee already exist.
     * @throws InvalidInputException     throw if inputs are wrong.
     */
    @PostMapping("/addEmployee")
    public final OutDto addEmployee(
            @RequestBody @Valid final EmployeeInDto employeeInDto)
            throws DataAlreadyExistException, InvalidInputException {
        LOGGER.info(LoggerConstant.ADDEMPLOYEE_INMESSAGE
                + employeeInDto.toString());
        employeeValidator.addEmployeeValidator(employeeInDto);
        OutDto response = employeeService.addEmployee(employeeInDto);
        LOGGER.info(LoggerConstant.ADDEMPLOYEE_OUTMESSAGE);
        return response;
    }

    /**
     * To fetch list of managers.
     *
     * @return list of managers in dto.
     */
    @GetMapping("/allManager")
    public final List<AllManagerOutDto> getAllManager() {
        LOGGER.info(LoggerConstant.GETALLMANAGER_INMESSAGE);
        List<AllManagerOutDto> response = employeeService.getAllManager();
        LOGGER.info(LoggerConstant.GETALLMANAGER_OUTMESSAGE);
        return response;
    }

    /**
     * To fetch manager details for the project tab.
     *
     * @return list of managers.
     */
    @GetMapping("/allManagerForProject")
    public final List<AllManagerForProjectOutDto>
    getAllManagerForProject() {
        LOGGER.info(LoggerConstant.GETALLMANAGERFORPROJECT_INMESSAGE);
        List<AllManagerForProjectOutDto> response = employeeService
                .getAllManagerForProject();
        LOGGER.info(LoggerConstant.GETALLMANAGERFORPROJECT_OUTMESSAGE);
        return response;
    }


    /**
     * To assign project to manager.
     *
     * @param emId    get emId(primary key).
     * @param project takes project id to save on Employee table.
     * @return return a message in responseDto.
     */
    @PutMapping("/assignProjectToManager/{emId}")
    public final OutDto assignProjectToManager(
            @PathVariable final Long emId,
            @RequestBody @Valid final AssignProjectInDto project) {
        LOGGER.info(LoggerConstant.ASSIGNPROJECTTOMANAGER_INMESSAGE
                + project);
        employeeValidator.assignProjectToManagerValidator(emId, project);
        OutDto response = employeeService.assignProjectToManager(emId,
                project);
        LOGGER.info(LoggerConstant.ASSIGNPROJECTTOMANAGER_OUTMESSAGE);
        return response;
    }

    /**
     * Used to get employee by email id.
     *
     * @param empEmail Takes email id.
     * @return Return employee details.
     */
    @GetMapping("/getEmployeeByEmail/{empEmail}")
    public final AllEmployeeOutDto getEmployeeByEmailId(
            @PathVariable final String empEmail) {
        LOGGER.info(LoggerConstant.GETEMPLOYEEBYEMAILID_INMESSAGE
                + empEmail);
        employeeValidator.getEmployeeByEmailIdValidator(empEmail);
        AllEmployeeOutDto response = employeeService
                .getEmployeeByEmail(empEmail);
        LOGGER.info(LoggerConstant.GETEMPLOYEEBYEMAILID_OUTMESSAGE);
        return response;
    }

    /**
     * Used to assign project to employee.
     *
     * @param empId                      Takes employee id.
     * @param assignProjectToEmployeeInDto Takes Dto to assign project.
     * @return return ResponseDto with project.
     * @throws DataAlreadyExistException Throw if employee already have
     *                                   projects.
     * @throws InvalidInputException Throws if not having a valid manager id.
     */
    @PutMapping("/assignProjectToEmployee/{empId}")
    public final OutDto assignProjectToEmployee(
            @PathVariable final String empId,
            @RequestBody @Valid final AssignProjectToEmployeeInDto
            assignProjectToEmployeeInDto)
            throws DataAlreadyExistException, InvalidInputException {
        LOGGER.info(LoggerConstant.ASSIGNPROJECTTOEMPLOYEE_INMESSAGE
                + assignProjectToEmployeeInDto.toString());
        employeeValidator.assignProjectToEmployeeValidator(empId,
                assignProjectToEmployeeInDto);
        OutDto response = employeeService.assignProjectToEmployee(empId,
                assignProjectToEmployeeInDto);
        LOGGER.info(LoggerConstant.ASSIGNPROJECTTOEMPLOYEE_OUTMESSAGE);
        return response;
    }

    /**
     * Used to update employee skills.
     *
     * @param empEmail      Takes employee email.
     * @param updatedSkills Takes updated skills.
     * @return return responseDto with message.
     * @throws InvalidInputException Throw if skills are not valid.
     */
    @PutMapping("/updateSkills/{empEmail}")
    public final OutDto updateEmployeeSkills(
            @PathVariable final String empEmail,
            @RequestBody @Valid final UpdateSkillsInDto updatedSkills)
                    throws InvalidInputException {
        LOGGER.info(LoggerConstant.UPDATEEMPLOYEESKILLS_INMESSAGE
                + empEmail);
        employeeValidator.updateEmployeeSkillsValidator(empEmail,
                updatedSkills);
        OutDto response = employeeService.updateEmployeeSkills(empEmail,
                updatedSkills);
        LOGGER.info(LoggerConstant.UPDATEEMPLOYEESKILLS_OUTMESSAGE);
        return response;
    }

    /**
     * Used to get filtered list based on skill and project.
     *
     * @param filterDto Takes required skills and signal for unassigned.
     * @return Return list of employees.
     * @throws InvalidInputException Throw if skills are not valid.
     */
    @PostMapping("/filteredEmployee")
    public final List<AllEmployeeOutDto> filteredEmployee(
            @RequestBody @Valid final SearchFilteredEmployeeInDto filterDto)
                    throws InvalidInputException {
        LOGGER.info(LoggerConstant.FILTEREDEMPLOYEE_INMESSAGE
                + filterDto.toString());
        employeeValidator.filteredEmployeeValidator(filterDto);
        List<AllEmployeeOutDto> response = employeeService
                .filteredEmployee(filterDto);
        LOGGER.info(LoggerConstant.FILTEREDEMPLOYEE_OUTMESSAGE);
        return response;
    }

    /**
     * Used to unassign project to employee.
     *
     * @param employeeId Takes employeeId.
     * @return Return message.
     * @throws InvalidInputException Throw exception.
     */
    @PutMapping("/unAssignProjectToEmployee/{employeeId}")
    public final OutDto unAssignProjectToEmployee(
            @PathVariable final String employeeId)
            throws InvalidInputException {
        LOGGER.info(
                LoggerConstant.UNASSIGNEDPROJECTTOEMPLOYEE_INMESSAGE
                        + employeeId);
        employeeValidator.unAssignProjectToEmployeeValidator(employeeId);
        OutDto response = employeeService
                .unAssignProjectToEmployee(employeeId);
        LOGGER.info(LoggerConstant.UNASSIGNEDPROJECTTOEMPLOYEE_OUTMESSAGE);
        return response;
    }
}
