package com.employeemanagement.backend.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.DataNotFoundException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.dto.ProjectInDto;
import com.employeemanagement.backend.entity.Project;
import com.employeemanagement.backend.inputcheck.InputFieldChecks;
import com.employeemanagement.backend.inputcheck.ProjectInputCheck;
import com.employeemanagement.backend.repository.ProjectRepository;

@Component
public class ProjectValidator {
    /**
     * Creating object of ProjectInputCheck to check input fields.
     */
    @Autowired
    private ProjectInputCheck projectInputCheck;
    /**
     * Creating object of InputFieldChecks to check input.
     */
    @Autowired
    private InputFieldChecks inputFieldChecks;
    /**
     * Creating object of ProjectRepository.
     */
    @Autowired
    private ProjectRepository projectRepo;

    /**
     * Validates and performs checks on the input data for adding a new project.
     *
     * @param projectDto The ProjectInDto containing project details.
     * @throws InvalidInputException     If the input data is invalid.
     * @throws DataAlreadyExistException If the project name already exists.
     */
    public void addProjectValidator(final ProjectInDto projectDto)
            throws InvalidInputException, DataAlreadyExistException {
        projectInputCheck.checkName(projectDto.getProjectName());
        projectInputCheck.checkStartDate(projectDto.getStartDate());
        projectInputCheck.checkSkills(projectDto.getSkills());
        projectInputCheck.checkDescription(projectDto.getDescription());
        inputFieldChecks.checkEmpSkills(projectDto.getSkills());
        projectInputCheck.checkProjectNameExistance(
                projectDto.getProjectName());
        inputFieldChecks.checkEmIdNotExistance(projectDto.getManagerId());
        inputFieldChecks.checkIsManagerByemId(projectDto.getManagerId());
    }

    /**
     * Validates and checks if projects exist for a manager based on the
     * manager's ID.
     *
     * @param managerId The ID of the manager.
     * @throws InvalidInputException Throw if not a manager.
     * @throws DataNotFoundException If no projects are found for the manager.
     */
    public void getProjectByManagerId(final Long managerId)
            throws InvalidInputException {
        inputFieldChecks.checkEmIdNotExistance(managerId);
        inputFieldChecks.checkIsManagerByemId(managerId);
        List<Project> projectList = projectRepo.findAllByManagerId(managerId);
        if (projectList.size() == 0) {
            String s = "manager not have any project assigned.";
            throw new DataNotFoundException(s);
        }
    }

    /**
     * Validates and checks if a project with a given ID exists.
     *
     * @param id The ID of the project to be checked.
     */
    public void getProjectByIdValidator(final Long id) {
        projectInputCheck.checkProjectExistanceById(id);
    }

    /**
     * Validator for GetProjectByManagerEmail controller function..
     *
     * @param managerEmail Takes manager email.
     * @throws InvalidInputException Throw if email not exist or not a manager.
     */
    public void validatorForGetProjectByManagerEmail(final String managerEmail)
            throws InvalidInputException {
        // TODO Auto-generated method stub
        inputFieldChecks.checkEmailNotExistance(managerEmail);
        inputFieldChecks.checkIsManagerByEmailId(managerEmail);
    }

}
