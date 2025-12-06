package com.employeemanagement.backend.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class EmployeeControllerTests {

    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @Mock
    EmployeeValidator employeeValidator;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testAddAdmin() throws Exception {

        OutDto outDto = new OutDto();
        outDto.setMessage("Admin added successfully!");
        when(employeeService.addAdmin(any(EmployeeInDto.class)))
                .thenReturn(outDto);

        // correct value
        String json = "{\r\n" + "    \"empId\": \"N0002\",\r\n"
                + "    \"empName\": \"Ashish\",\r\n"
                + "    \"empEmail\": \"ashish@nucleusteq.com\",\r\n"
                + "    \"empDob\": \"25-04-2000\",\r\n"
                + "    \"empDoj\": \"25-04-2020\",\r\n"
                + "    \"empLocation\": \"Raipur\",\r\n"
                + "    \"empDesignation\": \"Engineer\",\r\n"
                + "    \"empContactNo\": \"1111111111\",\r\n"
                + "    \"empPassword\": \"12345678\",\r\n"
                + "    \"empRole\": \"Admin\"\r\n" + "}";

        mockMvc.perform(post("/employee/addAdmin")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message")
                        .value("Admin added successfully!"));
        verify(employeeService, times(1)).addAdmin(any(EmployeeInDto.class));

    }

    @Test
    public void testAddAdminWithWrongName() throws Exception {
        // with wrong name.
        String json = "{\r\n" + "    \"empId\": \"N0001\",\r\n"
                + "    \"empName\": \"Ashish6\",\r\n"
                + "    \"empEmail\": \"ashish@nucleusteq.com\",\r\n"
                + "    \"empDob\": \"25-04-2000\",\r\n"
                + "    \"empDoj\": \"25-04-2020\",\r\n"
                + "    \"empLocation\": \"Raipur\",\r\n"
                + "    \"empDesignation\": \"Engineer\",\r\n"
                + "    \"empContactNo\": \"1111111111\",\r\n"
                + "    \"empPassword\": \"12345678\",\r\n"
                + "    \"empRole\": \"Admin\"\r\n" + "}";

        mockMvc.perform(post("/employee/addAdmin")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never()).addAdmin(any(EmployeeInDto.class));
    }

    @Test
    public void testAddAdminWithWrongEmail() throws Exception {
        // with wrong email fromat.
        String json = "{\r\n" + "    \"empId\": \"N0001\",\r\n"
                + "    \"empName\": \"Ashish\",\r\n"
                + "    \"empEmail\": \"ashish@gmail.com\",\r\n"
                + "    \"empDob\": \"25-04-2000\",\r\n"
                + "    \"empDoj\": \"25-04-2020\",\r\n"
                + "    \"empLocation\": \"Raipur\",\r\n"
                + "    \"empDesignation\": \"Engineer\",\r\n"
                + "    \"empContactNo\": \"1111111111\",\r\n"
                + "    \"empPassword\": \"12345678\",\r\n"
                + "    \"empRole\": \"Admin\"\r\n" + "}";

        mockMvc.perform(post("/employee/addAdmin")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never()).addAdmin(any(EmployeeInDto.class));
    }

    @Test
    public void testAddAdminWithWrongEmpId() throws Exception {
        // with wrong empId.
        String json = "{\r\n" + "    \"empId\": \"N0000\",\r\n"
                + "    \"empName\": \"Ashish\",\r\n"
                + "    \"empEmail\": \"ashish@nucleusteq.com\",\r\n"
                + "    \"empDob\": \"25-04-2000\",\r\n"
                + "    \"empDoj\": \"25-04-2020\",\r\n"
                + "    \"empLocation\": \"Raipur\",\r\n"
                + "    \"empDesignation\": \"Engineer\",\r\n"
                + "    \"empContactNo\": \"1111111111\",\r\n"
                + "    \"empPassword\": \"12345678\",\r\n"
                + "    \"empRole\": \"Admin\"\r\n" + "}";

        mockMvc.perform(post("/employee/addAdmin")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never()).addAdmin(any(EmployeeInDto.class));
    }

    @Test
    public void testGetAllEmployee() throws Exception {
        List<AllEmployeeOutDto> employeeList = new ArrayList<>();

        when(employeeService.getAllEmployee()).thenReturn(employeeList);

        mockMvc.perform(get("/employee/all")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(employeeList.size()));
    }

    @Test
    public void testLoginEmployee() throws Exception {
        LoginOutDto loginOutDto = new LoginOutDto();
        loginOutDto.setMessage("Success");
        loginOutDto.setRole("Admin");
        when(employeeService.loginEmployee(any(EmployeeLoginDto.class)))
                .thenReturn(loginOutDto);
        // valid inputs.
        String json = "{\r\n"
                + "    \"empEmail\": \"ankita.sharma@nucleusteq.com\",\r\n"
                + "    \"empPassword\": \"12345678\"\r\n" + "}";
        mockMvc.perform(post("/employee/login")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"));
        verify(employeeService, times(1))
                .loginEmployee(any(EmployeeLoginDto.class));

    }

    @Test
    public void testLoginEmployeeWithEmptyEmail() throws Exception {
        // empty email id.
        String json = "{\r\n" + "    \"empEmail\": \"\",\r\n"
                + "    \"empPassword\": \"12345678\"\r\n" + "}";
        mockMvc.perform(post("/employee/login")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never())
                .loginEmployee(any(EmployeeLoginDto.class));
    }

    @Test
    public void testLoginEmployeeWithEmptyPassword() throws Exception {
        // empty password
        String json = "{\r\n"
                + "    \"empEmail\": \"ankita.sharma@nucleusteq.com\",\r\n"
                + "    \"empPassword\": \"\"\r\n" + "}";
        mockMvc.perform(post("/employee/login")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never())
                .loginEmployee(any(EmployeeLoginDto.class));
    }

    @Test
    public void testAddEmployee() throws Exception {
        OutDto outDto = new OutDto();
        outDto.setMessage("Success");
        when(employeeService.addEmployee(any(EmployeeInDto.class)))
                .thenReturn(outDto);

        // valid data.
        String json = "{\r\n" + "    \"empId\": \"N0007\",\r\n"
                + "    \"empName\": \"Sagar\",\r\n"
                + "    \"empEmail\": \"sagar@nucleusteq.com\",\r\n"
                + "    \"empDob\": \"25-04-2004\",\r\n"
                + "    \"empDoj\": \"25-04-2023\",\r\n"
                + "    \"empLocation\": \"Raipur\",\r\n"
                + "    \"empDesignation\": \"Engineer\",\r\n"
                + "    \"empContactNo\": \"7777777777\",\r\n"
                + "    \"empSkills\":[\"Java\",\"springboot\"],\r\n"
                + "    \"empRole\": \"Manager\"\r\n" + "\r\n" + "}";
        mockMvc.perform(post("/employee/addEmployee")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Success"));
        verify(employeeService, times(1)).addEmployee(any(EmployeeInDto.class));
    }

    @Test
    public void testAddEmployeeWithInvaidEmpId() throws Exception {
        // invalid empId.
        String json = "{\r\n" + "    \"empId\": \"N0000\",\r\n"
                + "    \"empName\": \"Sagar\",\r\n"
                + "    \"empEmail\": \"sagar@nucleusteq.com\",\r\n"
                + "    \"empDob\": \"25-04-2004\",\r\n"
                + "    \"empDoj\": \"25-04-2023\",\r\n"
                + "    \"empLocation\": \"Raipur\",\r\n"
                + "    \"empDesignation\": \"Engineer\",\r\n"
                + "    \"empContactNo\": \"7777777777\",\r\n"
                + "    \"empSkills\":[\"Java\",\"springboot\"],\r\n"
                + "    \"empRole\": \"Manager\"\r\n" + "\r\n" + "}";
        mockMvc.perform(post("/employee/addEmployee")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never()).addEmployee(any(EmployeeInDto.class));
    }

    @Test
    public void testAddEmployeeForInvalidContact() throws Exception {
        // invalid contact number.
        String json = "{\r\n" + "    \"empId\": \"N0007\",\r\n"
                + "    \"empName\": \"Sagar\",\r\n"
                + "    \"empEmail\": \"sagar@nucleusteq.com\",\r\n"
                + "    \"empDob\": \"25-04-2004\",\r\n"
                + "    \"empDoj\": \"25-04-2023\",\r\n"
                + "    \"empLocation\": \"Raipur\",\r\n"
                + "    \"empDesignation\": \"Engineer\",\r\n"
                + "    \"empContactNo\": \"9878997\",\r\n"
                + "    \"empSkills\":[\"Java\",\"springboot\"],\r\n"
                + "    \"empRole\": \"Manager\"\r\n" + "\r\n" + "}";
        mockMvc.perform(post("/employee/addEmployee")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never()).addEmployee(any(EmployeeInDto.class));
    }

    @Test
    public void testAddEmployeeForInvalidDob() throws Exception {
        // invalid EmpDob
        String json = "{\r\n" + "    \"empId\": \"N0007\",\r\n"
                + "    \"empName\": \"Sagar\",\r\n"
                + "    \"empEmail\": \"sagar@nucleusteq.com\",\r\n"
                + "    \"empDob\": \"25-04-20\",\r\n"
                + "    \"empDoj\": \"25-04-2023\",\r\n"
                + "    \"empLocation\": \"Raipur\",\r\n"
                + "    \"empDesignation\": \"Engineer\",\r\n"
                + "    \"empContactNo\": \"7777777777\",\r\n"
                + "    \"empSkills\":[\"Java\",\"springboot\"],\r\n"
                + "    \"empRole\": \"Manager\"\r\n" + "\r\n" + "}";
        mockMvc.perform(post("/employee/addEmployee")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never()).addEmployee(any(EmployeeInDto.class));

    }

    @Test
    public void testAddEmployeeForWrongEmailFormat() throws Exception {
        // invalid email format.
        String json = "{\r\n" + "    \"empId\": \"N0007\",\r\n"
                + "    \"empName\": \"Sagar\",\r\n"
                + "    \"empEmail\": \"sagar@gmail.com\",\r\n"
                + "    \"empDob\": \"25-04-2004\",\r\n"
                + "    \"empDoj\": \"25-04-2023\",\r\n"
                + "    \"empLocation\": \"Raipur\",\r\n"
                + "    \"empDesignation\": \"Engineer\",\r\n"
                + "    \"empContactNo\": \"7777777777\",\r\n"
                + "    \"empSkills\":[\"Java\",\"springboot\"],\r\n"
                + "    \"empRole\": \"Manager\"\r\n" + "\r\n" + "}";
        mockMvc.perform(post("/employee/addEmployee")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never()).addEmployee(any(EmployeeInDto.class));

    }

    @Test
    public void testGetAllManager() throws Exception {
        List<AllManagerOutDto> response = new ArrayList<>();
        when(employeeService.getAllManager()).thenReturn(response);
        mockMvc.perform(get("/employee/allManager")).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(response.size()));
        verify(employeeService, times(1)).getAllManager();
    }

    @Test
    public void testGetAllManagerForProject() throws Exception {
        List<AllManagerForProjectOutDto> response = new ArrayList<>();
        when(employeeService.getAllManagerForProject()).thenReturn(response);
        mockMvc.perform(get("/employee/allManagerForProject"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(response.size()));
        verify(employeeService, times(1)).getAllManagerForProject();
    }

    @Test
    public void TestAssignProjectToManager() throws Exception {
        OutDto response = new OutDto();
        response.setMessage("Success");
        AssignProjectInDto project = new AssignProjectInDto();
        project.setEmpProjectId(5L);
        when(employeeService.assignProjectToManager(5L, project))
                .thenReturn(response);

        mockMvc.perform(put("/employee/assignProjectToManager/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"empProjectId\":5}")).andExpect(status().isOk());
        verify(employeeService, times(1)).assignProjectToManager(5L, project);
    }

    @Test
    public void testGetAllEmployeeForOrganization() throws Exception {
        List<AllEmployeeOutDto> employeeList = new ArrayList<>();
        AllEmployeeOutDto employee1 = new AllEmployeeOutDto();
        employee1.setEmpContactNo("1111111111");
        employee1.setEmpDesignation("Architect");
        employee1.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        List<String> skills = new ArrayList<>();
        skills.add("Python");
        employee1.setEmpProjectId(projects);
        employee1.setEmpSkills(skills);
        employeeList.add(employee1);

        when(employeeService.getAllEmployeeForOrganization())
                .thenReturn(employeeList);

        mockMvc.perform(get("/employee/allOrganizationEmployee"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(employeeList.size()));
        verify(employeeService, times(1)).getAllEmployeeForOrganization();
    }

    @Test
    public void testGetEmployeeByEmailId() throws Exception {
        AllEmployeeOutDto expectedEmployee = new AllEmployeeOutDto();
        expectedEmployee.setEmpContactNo("1111111111");
        expectedEmployee.setEmpDesignation("Architect");
        expectedEmployee.setEmpName("Ashish");
        expectedEmployee.setEmpEmail("ashish@nucleusteq.com");
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        List<String> skills = new ArrayList<>();
        skills.add("Python");
        expectedEmployee.setEmpProjectId(projects);
        expectedEmployee.setEmpSkills(skills);

        when(employeeService.getEmployeeByEmail("ashish@nucleusteq.com"))
                .thenReturn(expectedEmployee);

        mockMvc.perform(
                get("/employee/getEmployeeByEmail/ashish@nucleusteq.com")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.empContactNo").value("1111111111"))
                .andExpect(jsonPath("$.empName").value("Ashish"))
                .andExpect(jsonPath("$.empSkills").value(skills));
        verify(employeeService, times(1))
                .getEmployeeByEmail("ashish@nucleusteq.com");
    }

    @Test
    public void testAssignProjectToEmployee() throws Exception {
        OutDto expectedResult = new OutDto();
        expectedResult.setMessage("Project assigned successfully.");

        AssignProjectToEmployeeInDto input = new AssignProjectToEmployeeInDto();
        input.setProjectId(1L);
        input.setProjectManagerId(2L);

        when(employeeService.assignProjectToEmployee("N0003", input))
                .thenReturn(expectedResult);

        // valid inputs.
        String json = "{\r\n" + "    \"projectId\":1,\r\n"
                + "    \"projectManagerId\":2\r\n" + "}";
        mockMvc.perform(put("/employee/assignProjectToEmployee/N0003")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk()).andExpect(jsonPath("$.message")
                        .value(expectedResult.getMessage()));
        verify(employeeService, times(1)).assignProjectToEmployee("N0003",
                input);

    }

    @Test
    public void testAssignProjectToEmployeeForEmptyProjectId()
            throws Exception {

        AssignProjectToEmployeeInDto input = new AssignProjectToEmployeeInDto();
        input.setProjectId(1L);
        input.setProjectManagerId(2L);

        // empty project id.
        String json = "{\r\n" + "    \"projectId\":,\r\n"
                + "    \"projectManagerId\":2\r\n" + "}";
        mockMvc.perform(put("/employee/assignProjectToEmployee/N0003")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());

        verify(employeeService, never()).assignProjectToEmployee("N0003",
                input);
    }

    @Test
    public void testAssignProjectToEmployeeForEmptyManagerId()
            throws Exception {
        AssignProjectToEmployeeInDto input = new AssignProjectToEmployeeInDto();
        input.setProjectId(1L);
        input.setProjectManagerId(2L);
        // empty manager id.
        String json = "{\r\n" + "    \"projectId\":1,\r\n"
                + "    \"projectManagerId\":\r\n" + "}";
        mockMvc.perform(put("/employee/assignProjectToEmployee/N0003")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never()).assignProjectToEmployee("N0003",
                input);
    }

    @Test
    public void testUpdateEmployeeSkills() throws Exception {
        OutDto expectedResult = new OutDto();
        expectedResult.setMessage("Skills updated successfully.");

        UpdateSkillsInDto input = new UpdateSkillsInDto();
        List<String> skills = new ArrayList<>();
        skills.add("Python");
        input.setSkills(skills);

        when(employeeService.updateEmployeeSkills("ashish@nucleusteq.com",
                input)).thenReturn(expectedResult);

        String json = "{\r\n" + "    \"skills\": [\"Python\"]\r\n" + "}";

        mockMvc.perform(put("/employee/updateSkills/ashish@nucleusteq.com")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.message")
                        .value(expectedResult.getMessage()));
        verify(employeeService, times(1))
                .updateEmployeeSkills("ashish@nucleusteq.com", input);
    }

    @Test
    public void testFilteredEmployee() throws Exception {
        List<AllEmployeeOutDto> expectedResult = new ArrayList<>();
        AllEmployeeOutDto employee1 = new AllEmployeeOutDto();
        employee1.setEmpContactNo("1111111111");
        employee1.setEmpDesignation("Architect");
        employee1.setEmpName("Ashish");
        employee1.setEmpEmail("ashish@nucleusteq.com");
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        List<String> skills = new ArrayList<>();
        skills.add("Python");
        employee1.setEmpProjectId(projects);
        employee1.setEmpSkills(skills);

        expectedResult.add(employee1);

        when(employeeService
                .filteredEmployee((any(SearchFilteredEmployeeInDto.class))))
                .thenReturn(expectedResult);

        // valid data.
        String json = "{\r\n" + "    \"selectedSkills\":[\"JavaScript\"],\r\n"
                + "    \"showOnlyUnassigned\": true\r\n" + "}";
        mockMvc.perform(post("/employee/filteredEmployee")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(expectedResult.size()));
        verify(employeeService, times(1))
                .filteredEmployee((any(SearchFilteredEmployeeInDto.class)));

    }

    @Test
    public void testFilteredEmployeeWithoutSkills() throws Exception {
        // invalid input.
        String json = "{" + "    \"showOnlyUnassigned\": true\r\n" + "}";
        mockMvc.perform(post("/employee/filteredEmployee")
                .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest());
        verify(employeeService, never())
                .filteredEmployee((any(SearchFilteredEmployeeInDto.class)));
    }

    @Test
    public void testDeAssignProjectToEmployee() throws Exception {
        OutDto expectedResult = new OutDto();
        expectedResult.setMessage("De-assigned successfully");

        when(employeeService.unAssignProjectToEmployee("N0003"))
                .thenReturn(expectedResult);

        mockMvc.perform(put("/employee/unAssignProjectToEmployee/N0003"))
                .andExpect(status().isOk()).andExpect(jsonPath("$.message")
                        .value(expectedResult.getMessage()));
        verify(employeeService, times(1)).unAssignProjectToEmployee("N0003");
    }

}
