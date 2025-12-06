package com.employeemanagement.backend.inputcheck;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employeemanagement.backend.constantsmessages.ErrorConstant;
import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.DataNotFoundException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.entity.Project;
import com.employeemanagement.backend.repository.ProjectRepository;

@Component
public class ProjectInputCheck {

    /**
     * Object of projectRepository.
     */
    @Autowired
    private ProjectRepository projectRepo;
    /**
     * used to check name of project.
     *
     * @param name project name.
     * @throws InvalidInputException throw exception.
     */
    public final void checkName(final String name)
            throws InvalidInputException {
        String namePattern = "^[A-Za-z\\s]+$";
        if (name.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_NAME);
        }
        if (!Pattern.matches(namePattern, name)) {
            throw new InvalidInputException(ErrorConstant.INVALID_NAME);
        }
    }

    /**
     * check for start date.
     *
     * @param date takes date.
     * @throws InvalidInputException throw exception.
     */
    public final void checkStartDate(final String date)
            throws InvalidInputException {
        String datePattern = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-"
                + "(19|20)\\d\\d$";
        if (date.equals("")) {
            throw new InvalidInputException(
                    ErrorConstant.EMPTY_STARTDATE);
        }
        if (!Pattern.matches(datePattern, date)) {
            throw new InvalidInputException(ErrorConstant.INVALID_STARTDATE);
        }
    }

    /**
     * used to check skills.
     *
     * @param skills get skills list.
     * @throws InvalidInputException throw exception.
     */
    public final void checkSkills(final List<String> skills)
            throws InvalidInputException {
        if (skills.size() == 0) {
            throw new InvalidInputException(ErrorConstant.EMPTY_SKILLS);
        }
    }

    /**
     * check for description.
     *
     * @param description accept description.
     * @throws InvalidInputException throw exception.
     */
    public final void checkDescription(final String description)
            throws InvalidInputException {
        if (description == null || description.equals("")) {
            throw new InvalidInputException(ErrorConstant.EMPTY_DESCRIPTION);
        }
    }

    /**
     * check for existing project name.
     *
     * @param projectName takes project name.
     * @throws DataAlreadyExistException throw exception if exist.
     */
    public final void checkProjectNameExistance(final String projectName)
            throws DataAlreadyExistException {
        Project project = projectRepo.findByProjectName(projectName);
        if (project != null) {
            throw new DataAlreadyExistException(
                    ErrorConstant.PROJECT_NAME_ALREADY_EXIST);
        }
    }

    /**
     * Checks the existence of a project with a given ID.
     *
     * @param id The unique ID of the project to check.
     * @throws DataNotFoundException If no project with
     *  the specified ID is found.
     */
    public final void checkProjectExistanceById(final Long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        Project project = optionalProject.orElse(null);
        if (project == null) {
            throw new DataNotFoundException(ErrorConstant.PROJECT_NOT_EXIST);
        }
    }

}
