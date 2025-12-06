package com.employeemanagement.backend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.employeemanagement.backend.dto.ProjectInDto;
import com.employeemanagement.backend.dto.ProjectOutDtoForManagerTab;
import com.employeemanagement.backend.dto.ProjectOutDtoWithOnlyProjectId;
import com.employeemanagement.backend.dto.ProjectOutDtoWithTeam;
import com.employeemanagement.backend.dto.ProjectOutDtoWithIdAndName;
import com.employeemanagement.backend.service.ProjectService;
import com.employeemanagement.backend.validator.ProjectValidator;

class ProjectControllerTest {

    private MockMvc mockMvc;

    @Mock
    ProjectService projectService;

    @Mock
    ProjectValidator projectValidator;

    @InjectMocks
    ProjectController projectController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
    }

    @Test
    void testAddProject() throws Exception {
        ProjectOutDtoWithOnlyProjectId output = new ProjectOutDtoWithOnlyProjectId();
        output.setMessage("Success");
        output.setId(1L);

        when(projectService.addProject(any(ProjectInDto.class)))
                .thenReturn(output);

        // valid input.
        String json = "{\r\n" + "    \"projectName\": \"EMS\",\r\n"
                + "    \"managerId\":5,\r\n"
                + "    \"startDate\":\"25-08-2023\",\r\n"
                + "    \"skills\":[\"java\",\"python\"],\r\n"
                + "    \"description\":\"Employee Management System\"\r\n"
                + "}";
        mockMvc.perform(post("/project/addProject")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"));
        verify(projectService, times(1)).addProject(any(ProjectInDto.class));

    }

    @Test
    void testAddProjectForInvalidProjectName() throws Exception {
        // invalid project name.
        String json = "{\r\n" + "    \"projectName\": \"\",\r\n"
                + "    \"managerId\":5,\r\n"
                + "    \"startDate\":\"25-08-2023\",\r\n"
                + "    \"skills\":[\"java\",\"python\"],\r\n"
                + "    \"description\":\"Employee Management System\"\r\n"
                + "}";
        mockMvc.perform(post("/project/addProject")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(projectService, never()).addProject(any(ProjectInDto.class));
    }

    @Test
    void testAddProjectForInvalidManagerId() throws Exception {
        // invalid manager id.
        String json = "{\r\n" + "    \"projectName\": \"EMS\",\r\n"
                + "    \"managerId\":,\r\n"
                + "    \"startDate\":\"25-08-2023\",\r\n"
                + "    \"skills\":[\"java\",\"python\"],\r\n"
                + "    \"description\":\"Employee Management System\"\r\n"
                + "}";
        mockMvc.perform(post("/project/addProject")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(projectService, never()).addProject(any(ProjectInDto.class));
    }

    @Test
    void testAddProjectForInvalidStartDate() throws Exception {
        // invalid start date.
        String json = "{\r\n" + "    \"projectName\": \"EMS\",\r\n"
                + "    \"managerId\":5,\r\n"
                + "    \"startDate\":\"25-08-20\",\r\n"
                + "    \"skills\":[\"java\",\"python\"],\r\n"
                + "    \"description\":\"Employee Management System\"\r\n"
                + "}";
        mockMvc.perform(post("/project/addProject")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(projectService, never()).addProject(any(ProjectInDto.class));
    }

    @Test
    void testAddProjectForEmptySkills() throws Exception {
        // invalid skills.
        String json = "{\r\n" + "    \"projectName\": \"EMS\",\r\n"
                + "    \"managerId\":5,\r\n"
                + "    \"startDate\":\"25-08-20\",\r\n"
                + "    \"skills\":[],\r\n"
                + "    \"description\":\"Employee Management System\"\r\n"
                + "}";
        mockMvc.perform(post("/project/addProject")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(projectService, never()).addProject(any(ProjectInDto.class));
    }

    @Test
    void testAddProjectForEmptyDescription() throws Exception {
        // Empty description.
        String json = "{\r\n" + "    \"projectName\": \"EMS\",\r\n"
                + "    \"managerId\":5,\r\n"
                + "    \"startDate\":\"25-08-2023\",\r\n"
                + "    \"skills\":[\"java\",\"python\"],\r\n"
                + "    \"description\":\"" + "}";
        mockMvc.perform(post("/project/addProject")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(projectService, never()).addProject(any(ProjectInDto.class));
    }

    @Test
    void testGetProject() throws Exception {
        List<ProjectOutDtoWithTeam> output = new ArrayList<>();
        when(projectService.getAllProjects()).thenReturn(output);
        mockMvc.perform(get("/project/getAllProject")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(output.size()));
    }

    @Test
    void testGetProjectByManagerId() throws Exception {
        List<ProjectOutDtoForManagerTab> output = new ArrayList<>();
        when(projectService.getProjectByManagerId(5L)).thenReturn(output);

        mockMvc.perform(get("/project/getProjectByManagerId/5")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(output.size()));
    }

    @Test
    void testGetProjectById() throws Exception {
        ProjectOutDtoWithIdAndName expectedResult = new ProjectOutDtoWithIdAndName();
        expectedResult.setId(1L);
        expectedResult.setProjectName("EMS");
        when(projectService.getProjectById(1L)).thenReturn(expectedResult);

        mockMvc.perform(get("/project/getProjectById/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.projectName")
                        .value(expectedResult.getProjectName()));
    }

    @Test
    void testGetAllProjectByManagerEmail() throws Exception {
        List<ProjectOutDtoWithIdAndName> expectedResult = new ArrayList<>();
        ProjectOutDtoWithIdAndName dto1 = new ProjectOutDtoWithIdAndName();
        dto1.setId(1L);
        dto1.setProjectName("EMS");
        expectedResult.add(dto1);

        when(projectService
                .getAllProjectsByManagerEmail("ashish@nucleusteq.com"))
                .thenReturn(expectedResult);

        mockMvc.perform(get(
                "/project/getAllProjectByManagerEmail/ashish@nucleusteq.com"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(expectedResult.size()));
    }

}
