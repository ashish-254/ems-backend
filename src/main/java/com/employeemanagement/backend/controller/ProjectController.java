package com.employeemanagement.backend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.backend.constantsmessages.LoggerConstant;
import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.dto.ProjectInDto;
import com.employeemanagement.backend.dto.ProjectOutDtoForManagerTab;
import com.employeemanagement.backend.dto.ProjectOutDtoWithOnlyProjectId;
import com.employeemanagement.backend.dto.ProjectOutDtoWithTeam;
import com.employeemanagement.backend.dto.ProjectOutDtoWithIdAndName;
import com.employeemanagement.backend.service.ProjectService;
import com.employeemanagement.backend.validator.ProjectValidator;

import jakarta.validation.Valid;

/**
 * controller for Project.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/project")
public class ProjectController {

    /**
     * Object of project service class.
     */
    @Autowired
    private ProjectService projectService;
    /**
     * Validator for fields and dto.
     */
    @Autowired
    private ProjectValidator projectValidator;
    /**
     * Logger object.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProjectController.class);

    /**
     * To add project.
     *
     * @param projectInDto accept project details.
     * @return return a message in response dto.
     * @throws InvalidInputException      throw exception.
     * @throws DataAlreadyExistException.
     */
    @PostMapping("/addProject")
    public final ProjectOutDtoWithOnlyProjectId addProject(
            @Valid @RequestBody final ProjectInDto projectInDto)
            throws InvalidInputException, DataAlreadyExistException {
        LOGGER.info(
                LoggerConstant.ADDPROJECT_INMESSAGE
        + projectInDto.toString());
        projectValidator.addProjectValidator(projectInDto);
        ProjectOutDtoWithOnlyProjectId response =
                projectService.addProject(projectInDto);
        LOGGER.info(LoggerConstant.ADDPROJECT_OUTMESSAGE);
        return response;
    }

    /**
     * To fetch list of all the projects.
     *
     * @return list of projects.
     */
    @GetMapping("/getAllProject")
    public final List<ProjectOutDtoWithTeam> getProject() {
        LOGGER.info(LoggerConstant.GETPROJECT_INMESSAGE);
        List<ProjectOutDtoWithTeam> response = projectService.getAllProjects();
        LOGGER.info(LoggerConstant.GETPROJECT_OUTMESSAGE);
        return response;
    }

    /**
     * To fetch list of project assigned to a manger.
     *
     * @param managerId accept manager id(primary key).
     * @return return list of projects.
     * @throws InvalidInputException Throw if not a manager.
     */
    @GetMapping("/getProjectByManagerId/{managerId}")
    public final List<ProjectOutDtoForManagerTab> getProjectByManagerId(
            @PathVariable final Long managerId) throws InvalidInputException {
        LOGGER.info(LoggerConstant.GETPROJECTBYMANAGERID_INMESSAGE);
        projectValidator.getProjectByManagerId(managerId);
        List<ProjectOutDtoForManagerTab> response = projectService
                .getProjectByManagerId(managerId);
        LOGGER.info(LoggerConstant.GETPROJECTBYMANAGERID_OUTMESSAGE);
        return response;
    }

    /**
     * Used to get project by id.
     *
     * @param id Takes id of project.
     * @return Return details of project.
     */
    @GetMapping("/getProjectById/{id}")
    public final ProjectOutDtoWithIdAndName getProjectById(@PathVariable
            final Long id) {
        LOGGER.info(LoggerConstant.GETPROJECTBYID_INMESSAGE);
        projectValidator.getProjectByIdValidator(id);
        ProjectOutDtoWithIdAndName response = projectService.getProjectById(id);
        LOGGER.info(LoggerConstant.GETPROJECTBYID_OUTMESSAGE);
        return response;
    }

    /**
     * Used to get list of project by manager email.
     *
     * @param managerEmail Takes manager Email id.
     * @return Return LIst of project.
     * @throws InvalidInputException Throw if not a manager.
     */
    @GetMapping("/getAllProjectByManagerEmail/{managerEmail}")
    public final List<ProjectOutDtoWithIdAndName>
    getAllProjectByManagerEmail(
            @PathVariable final String managerEmail)
                    throws InvalidInputException {
        LOGGER.info(
                LoggerConstant.GETALLPROJECTBYMANAGEREMAILID_INMESSAGE
                        + managerEmail);
        projectValidator.validatorForGetProjectByManagerEmail(managerEmail);
        List<ProjectOutDtoWithIdAndName> response = projectService
                .getAllProjectsByManagerEmail(managerEmail);
        LOGGER.info(LoggerConstant.GETALLPROJECTBYMANAGEREMAILID_OUTMESSAGE);
        return response;
    }

}
