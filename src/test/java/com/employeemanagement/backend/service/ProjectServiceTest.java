package com.employeemanagement.backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

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
import com.employeemanagement.backend.enumlists.Designation;
import com.employeemanagement.backend.enumlists.Location;
import com.employeemanagement.backend.repository.EmployeeRepository;
import com.employeemanagement.backend.repository.ProjectRepository;
import com.employeemanagement.backend.validator.ProjectValidator;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

    @InjectMocks
    private ProjectService projectService;

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ProjectValidator projectValidator;

    @Mock
    private EmployeeRepository employeeRepository;
    
    @Mock
    private EmployeeService employeeService;

    @Test
    void testAddProject()
            throws InvalidInputException, DataAlreadyExistException {
        ProjectInDto input = new ProjectInDto();

        input.setProjectName("EMS");
        input.setManagerId(5L);
        input.setDescription("Employee Management System project");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        input.setSkills(skills);

        Project project = new Project();
        project.setManagerId(input.getManagerId());
        project.setProjectName(input.getProjectName());
        project.setStartDate(input.getStartDate());
        project.setDescription(input.getDescription());
        project.setSkills(input.getSkills());

        when(projectRepository.save(any(Project.class))).thenReturn(project);

        when(projectRepository.findByProjectName(project.getProjectName()))
                .thenReturn(project);

        ProjectOutDtoWithOnlyProjectId response = projectService
                .addProject(input);

        verify(projectRepository, times(1)).save(any(Project.class));

        assertEquals(SuccessConstant.ADDED_SUCCESSFULLY, response.getMessage());
    }

    @Test
    void testGetAllProjects() {
        Project project1 = new Project();
        project1.setId(1L);
        project1.setProjectName("EMS");
        project1.setManagerId(5L);
        project1.setStartDate("25-04-2023");
        project1.setDescription("Employee Management System project");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        project1.setSkills(skills);

        List<Project> projectList = new ArrayList<>();
        projectList.add(project1);

        when(projectRepository.findAll()).thenReturn(projectList);

        List<ProjectOutDtoWithTeam> output = projectService.getAllProjects();

        verify(projectRepository, times(1)).findAll();

        List<ProjectInDto> expectedOutput = new ArrayList<>();
        ProjectInDto pd1 = new ProjectInDto();
        pd1.setProjectName("EMS");
        pd1.setManagerId(5L);
        pd1.setStartDate("25-04-2023");
        pd1.setDescription("Employee Management System project");
        pd1.setSkills(skills);
        expectedOutput.add(pd1);

        assertEquals(expectedOutput.get(0).getProjectName(),
                output.get(0).getProjectName());
        assertEquals(expectedOutput.get(0).getManagerId(),
                output.get(0).getManagerId());
        assertEquals(expectedOutput.get(0).getStartDate(),
                output.get(0).getStartDate());
        assertEquals(expectedOutput.get(0).getDescription(),
                output.get(0).getDescription());
        assertEquals(expectedOutput.get(0).getSkills(),
                output.get(0).getSkills());
    }

    @Test
    void testGetProjectByManagerId() {
        Project project1 = new Project();
        project1.setId(1L);
        project1.setProjectName("EMS");
        project1.setManagerId(5L);
        project1.setStartDate("25-04-2023");
        project1.setDescription("Employee Management System project");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        project1.setSkills(skills);
        List<Project> projects = new ArrayList<>();
        projects.add(project1);
        when(projectRepository.findAllByManagerId(5L)).thenReturn(projects);

        List<ProjectOutDtoForManagerTab> projectList = projectService
                .getProjectByManagerId(5L);

        List<ProjectOutDtoForManagerTab> expectedOutput = new ArrayList<>();
        ProjectOutDtoForManagerTab projectOutDto1 = new ProjectOutDtoForManagerTab();
        projectOutDto1.setProjectName("EMS");
        projectOutDto1.setSkills(skills);
        projectOutDto1.setId(1L);
        expectedOutput.add(projectOutDto1);

        assertEquals(expectedOutput.get(0).getProjectName(),
                projectList.get(0).getProjectName());
        assertEquals(expectedOutput.get(0).getId(), projectList.get(0).getId());
        assertEquals(expectedOutput.get(0).getSkills(),
                projectList.get(0).getSkills());

    }

    @Test
    public void testGetProjectById() {
        Project project = new Project();
        project.setId(1L);
        project.setProjectName("EMS");
        project.setManagerId(5L);
        project.setStartDate("25-04-2023");
        project.setDescription("Employee Management System project");
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        project.setSkills(skills);

        Optional<Project> optionalProject = Optional.of(project);

        when(projectRepository.findById(1L)).thenReturn(optionalProject);

        ProjectOutDtoWithIdAndName projectOutDto1 = new ProjectOutDtoWithIdAndName();

        projectOutDto1.setProjectName("EMS");
        projectOutDto1.setId(1L);

        ProjectOutDtoWithIdAndName result = projectService.getProjectById(1L);

        assertEquals(projectOutDto1.getProjectName(), result.getProjectName());
        assertEquals(projectOutDto1.getId(), result.getId());
    }

    @Test
    public void testGetTeam() {
        Employee employee = new Employee();
        employee.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        employee.setEmpProjectId(projects);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        employee.setEmpSkills(skills);
        employee.setEmpDesignation(Designation.ARCHITECT);
        employee.setEmpLocation(Location.Bangalore);
        employee.setEmpId("N0001");
        employee.setEmpRole("Employee");

        List<Employee> allEmployee = new ArrayList<>();
        allEmployee.add(employee);

        when(employeeRepository.findAllByEmpRole("Employee"))
                .thenReturn(allEmployee);

        List<String> result = projectService.getTeam(5L);

        assertEquals("Ashish", result.get(0));
    }

    @Test
    public void testGetAllProjectsByManagerEmail() {
        Employee manager = new Employee();
        manager.setEmId(1L);
        manager.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        manager.setEmpProjectId(projects);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        manager.setEmpSkills(skills);
        manager.setEmpDesignation(Designation.ARCHITECT);
        manager.setEmpLocation(Location.Bangalore);
        manager.setEmpId("N0001");
        manager.setEmpRole("Manager");
        manager.setEmpEmail("ashish@nucleusteq.com");

        when(employeeRepository.findByEmpEmail("ashish@nucleusteq.com"))
                .thenReturn(manager);

        Project project = new Project();
        project.setId(5L);
        project.setProjectName("EMS");
        project.setManagerId(1L);
        project.setStartDate("25-04-2023");
        project.setDescription("Employee Management System project");
        project.setSkills(skills);

        List<Project> allProjects = new ArrayList<>();
        allProjects.add(project);

        when(projectRepository.findAllByManagerId(1L)).thenReturn(allProjects);

        List<ProjectOutDtoWithIdAndName> allProjectDto = projectService
                .getAllProjectsByManagerEmail("ashish@nucleusteq.com");

        assertEquals(5L, allProjectDto.get(0).getId());
        assertEquals("EMS", allProjectDto.get(0).getProjectName());
    }

}
