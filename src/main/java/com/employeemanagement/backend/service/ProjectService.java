package com.employeemanagement.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.backend.constantsmessages.SuccessConstant;
import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.dto.ProjectInDto;
import com.employeemanagement.backend.dto.ProjectOutDtoForManagerTab;
import com.employeemanagement.backend.dto.ProjectOutDtoWithOnlyProjectId;
import com.employeemanagement.backend.dto.ProjectOutDtoWithTeam;
import com.employeemanagement.backend.dto.ProjectOutDtoWithIdAndName;
import com.employeemanagement.backend.entity.Employee;
import com.employeemanagement.backend.entity.Project;
import com.employeemanagement.backend.repository.EmployeeRepository;
import com.employeemanagement.backend.repository.ProjectRepository;

/**
 * service class for projects.
 */
@Service
public class ProjectService {

    /**
     * creating object of project repository.
     */
    @Autowired
    private ProjectRepository projectRepo;
    /**
     * creating a object of EmployeeRepo.
     */
    @Autowired
    private EmployeeRepository employeeRepo;
    /**
     * Employee service object.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * used to add project.
     *
     * @param projectInDto accept project dto.
     * @return return responseDto with a message.
     * @throws InvalidInputException
     * @throws DataAlreadyExistException
     */
    public ProjectOutDtoWithOnlyProjectId addProject(final ProjectInDto
            projectInDto)
            throws InvalidInputException, DataAlreadyExistException {

        Project project = new Project();
        project.setManagerId(projectInDto.getManagerId());
        project.setProjectName(projectInDto.getProjectName());
        project.setStartDate(projectInDto.getStartDate());
        project.setSkills(projectInDto.getSkills());
        project.setDescription(projectInDto.getDescription());
        projectRepo.save(project);

        project = projectRepo.findByProjectName(projectInDto.getProjectName());
        ProjectOutDtoWithOnlyProjectId projectOutDto =
                new ProjectOutDtoWithOnlyProjectId();
        projectOutDto.setId(project.getId());
        projectOutDto.setMessage(SuccessConstant.ADDED_SUCCESSFULLY);
        return projectOutDto;
    }

    /**
     * used to get all project list.
     *
     * @return list of project.
     */
    public List<ProjectOutDtoWithTeam> getAllProjects() {
        // TODO Auto-generated method stub
        List<Project> allProject = projectRepo.findAll();
        List<ProjectOutDtoWithTeam> projectResponseDto = new ArrayList<>();
        for (Project project : allProject) {
            ProjectOutDtoWithTeam projectDto = new ProjectOutDtoWithTeam();
            projectDto.setId(project.getId());
            projectDto.setManagerId(project.getManagerId());
            projectDto.setProjectName(project.getProjectName());
            projectDto.setDescription(project.getDescription());
            projectDto.setSkills(project.getSkills());
            projectDto.setStartDate(project.getStartDate());
            projectDto.setTeam(getTeam(project.getId()));
            projectDto.setManagerName(
                    employeeService.getManagerById(project.getManagerId()));
            projectResponseDto.add(projectDto);
        }
        return projectResponseDto;
    }

    /**
     * used to get project details by manager id.
     *
     * @param managerId accept manager id.
     * @return return lsit of project.
     */
    public List<ProjectOutDtoForManagerTab> getProjectByManagerId(
            final Long managerId) {
        // TODO Auto-generated method stub
        List<Project> projectList = projectRepo.findAllByManagerId(managerId);
        List<ProjectOutDtoForManagerTab> projectResponseList =
                new ArrayList<>();
        for (Project project : projectList) {
            ProjectOutDtoForManagerTab projectResponse =
                    new ProjectOutDtoForManagerTab();
            projectResponse.setId(project.getId());
            projectResponse.setProjectName(project.getProjectName());
            projectResponse.setSkills(project.getSkills());
            projectResponse.setTeam(getTeam(project.getId()));
            projectResponseList.add(projectResponse);
        }
        return projectResponseList;
    }

    /**
     * Retrieves a project's details by its unique ID.
     *
     * @param id The unique ID of the project to retrieve.
     * @return A object containing the project's details if found, or null if
     *         not found.
     */
    public ProjectOutDtoWithIdAndName getProjectById(final Long id) {
        // TODO Auto-generated method stub
        Optional<Project> optionalProject = projectRepo.findById(id);
        Project project = optionalProject.orElse(null);
        ProjectOutDtoWithIdAndName projectOutDto =
                new ProjectOutDtoWithIdAndName();
        projectOutDto.setId(project.getId());
        projectOutDto.setProjectName(project.getProjectName());

        return projectOutDto;
    }

    /**
     * Function to get team working on same project.
     *
     * @param projectId Takes project id.
     * @return Return list of team according to project id.
     */
    public List<String> getTeam(final Long projectId) {
        List<Employee> allEmployees = employeeRepo.findAllByEmpRole("Employee");
        List<String> team = new ArrayList<>();
        for (Employee employee : allEmployees) {
            if (employee.getEmpProjectId().contains(projectId)) {
                team.add(employee.getEmpName());
            }
        }
        return team;
    }

    /**
     * Used to get List of project by manager email id.
     *
     * @param managerEmail Takes manager email id.
     * @return Return list of all project for manager.
     */
    public List<ProjectOutDtoWithIdAndName> getAllProjectsByManagerEmail(
            final String managerEmail) {
        // TODO Auto-generated method stub
        Employee manager = employeeRepo.findByEmpEmail(managerEmail);
        Long managerId = manager.getEmId();
        List<Project> allProjects = projectRepo.findAllByManagerId(managerId);
        List<ProjectOutDtoWithIdAndName> allProjectDto =
                new ArrayList<ProjectOutDtoWithIdAndName>();
        for (Project project : allProjects) {
            ProjectOutDtoWithIdAndName projectOutDto =
                    new ProjectOutDtoWithIdAndName();
            projectOutDto.setId(project.getId());
            projectOutDto.setProjectName(project.getProjectName());
            allProjectDto.add(projectOutDto);
        }
        return allProjectDto;
    }
}
