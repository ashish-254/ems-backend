package com.employeemanagement.backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.employeemanagement.backend.constantsmessages.SuccessConstant;
import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.InvalidInputException;
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
import com.employeemanagement.backend.entity.Employee;
import com.employeemanagement.backend.enumlists.Designation;
import com.employeemanagement.backend.enumlists.Location;
import com.employeemanagement.backend.inputcheck.InputFieldChecks;
import com.employeemanagement.backend.repository.EmployeeRepository;
import com.employeemanagement.backend.validator.EmployeeValidator;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private InputFieldChecks inputFieldChecks;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private EmployeeValidator employeeValidator;

    @Test
    void testAddAdmin()
            throws InvalidInputException, DataAlreadyExistException {
        EmployeeInDto input = new EmployeeInDto();
        input.setEmpId("N0001");
        input.setEmpName("Ashish");
        input.setEmpEmail("ashish@nucleusteq.com");
        input.setEmpDob("25-04-2002");
        input.setEmpDoj("25-04-2023");
        input.setEmpLocation("Raipur");
        input.setEmpDesignation("ENGINEER");
        input.setEmpContactNo("1111111111");
        input.setEmpPassword("12345678");
        input.setEmpRole("Admin");

        OutDto expected = new OutDto();
        expected.setMessage(SuccessConstant.ADDED_SUCCESSFULLY);

        when(inputFieldChecks.isPossiblyHashed(input.getEmpPassword()))
                .thenReturn(false);

        when(passwordEncoder.encode(input.getEmpPassword()))
                .thenReturn("encodedpassword");
        OutDto output = employeeService.addAdmin(input);
        verify(employeeRepository, times(1)).save(any(Employee.class));

        assertEquals(expected.getMessage(), output.getMessage());
    }

    @Test
    public void testAddAdminWithPossiblyHashed()
            throws InvalidInputException, DataAlreadyExistException {
        EmployeeInDto input = new EmployeeInDto();
        input.setEmpId("N0001");
        input.setEmpName("Ashish");
        input.setEmpEmail("ashish@nucleusteq.com");
        input.setEmpDob("25-04-2002");
        input.setEmpDoj("25-04-2023");
        input.setEmpLocation("Raipur");
        input.setEmpDesignation("ENGINEER");
        input.setEmpContactNo("1111111111");
        input.setEmpPassword("12345678");
        input.setEmpRole("Admin");

        OutDto expected = new OutDto();
        expected.setMessage(SuccessConstant.ADDED_SUCCESSFULLY);

        when(inputFieldChecks.isPossiblyHashed(input.getEmpPassword()))
                .thenReturn(true);

        OutDto output = employeeService.addAdmin(input);
        verify(employeeRepository, times(1)).save(any(Employee.class));

        assertEquals(expected.getMessage(), output.getMessage());
    }

    @Test
    void testLoginEmployee() throws InvalidInputException {
        EmployeeLoginDto input = new EmployeeLoginDto();
        input.setEmpEmail("ashish@nucleusteq.com");
        input.setEmpPassword("12345678");
        Employee employee = new Employee();
        employee.setEmpId("N0001");
        employee.setEmpName("Ashish");
        employee.setEmpEmail("ashish@nucleusteq.com");
        employee.setEmpDob("25-04-2002");
        employee.setEmpDoj("25-04-2023");
        employee.setEmpLocation(Location.Raipur);
        employee.setEmpDesignation(Designation.ENGINEER);
        employee.setEmpContactNo("1111111111");
        employee.setEmpPassword("12345678");
        employee.setEmpRole("Admin");

        when(employeeRepository.findByEmpEmail(input.getEmpEmail()))
                .thenReturn(employee);
        LoginOutDto output = employeeService.loginEmployee(input);
        verify(employeeRepository, times(1))
                .findByEmpEmail(input.getEmpEmail());

        LoginOutDto expectedOutput = new LoginOutDto();
        expectedOutput.setMessage(SuccessConstant.SUCCESS);
        expectedOutput.setRole(employee.getEmpRole());
        expectedOutput.setEmpName("Ashish");

        Objects.equals(output, expectedOutput);
        assertEquals(expectedOutput.getEmpName(), output.getEmpName());
        assertEquals(expectedOutput.getMessage(), output.getMessage());
        assertEquals(expectedOutput.getRole(), output.getRole());

    }

    @Test
    void testGetAllEmployee() {
        Employee employee1 = new Employee();
        employee1.setEmpId("N0001");
        employee1.setEmpName("Ashish");
        employee1.setEmpEmail("ashish@nucleusteq.com");
        employee1.setEmpDob("25-04-2002");
        employee1.setEmpDoj("25-04-2023");
        employee1.setEmpLocation(Location.Indore);
        employee1.setEmpDesignation(Designation.ENGINEER);
        employee1.setEmpContactNo("1111111111");
        employee1.setEmpPassword("12345678");
        employee1.setEmpRole("Admin");
        employee1.setEmpManagerId(9L);
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        employee1.setEmpProjectId(projects);
        List<String> skills = new ArrayList<>();
        skills.add("java");
        employee1.setEmpSkills(skills);
        List<Employee> allEmployee = new ArrayList<>();
        allEmployee.add(employee1);

        Employee manager = new Employee();
        manager.setEmId(9L);
        manager.setEmpName("Prerna");

        when(employeeRepository.findAllByEmpRole("Employee"))
                .thenReturn(allEmployee);
        when(employeeRepository.findByEmId(9L)).thenReturn(manager);

        List<AllEmployeeOutDto> responseList = employeeService.getAllEmployee();

        verify(employeeRepository, times(1)).findAllByEmpRole("Employee");

        assertEquals(1, responseList.size());
        assertEquals("N0001", responseList.get(0).getEmpId());
        assertEquals("1111111111", responseList.get(0).getEmpContactNo());
        assertEquals("Ashish", responseList.get(0).getEmpName());
        assertEquals("ashish@nucleusteq.com",
                responseList.get(0).getEmpEmail());
        assertEquals("25-04-2002", responseList.get(0).getEmpDob());
        assertEquals("25-04-2023", responseList.get(0).getEmpDoj());
        assertEquals("Indore", responseList.get(0).getEmpLocation());
        assertEquals("ENGINEER", responseList.get(0).getEmpDesignation());
    }

    @Test
    void testAddEmployee()
            throws InvalidInputException, DataAlreadyExistException {
        EmployeeInDto input = new EmployeeInDto();
        input.setEmpId("N0001");
        input.setEmpName("Ashish");
        input.setEmpEmail("ashish@nucleusteq.com");
        input.setEmpDob("25-04-2002");
        input.setEmpDoj("25-04-2023");
        input.setEmpLocation("Raipur");
        input.setEmpDesignation("ENGINEER");
        input.setEmpContactNo("1111111111");
        input.setEmpPassword("12345678");
        input.setEmpRole("Admin");
        input.setEmpManagerId(9L);
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        input.setEmpProjectId(projects);
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        input.setEmpSkills(skills);
        input.setEmpPassword("11112222");

        List<Employee> adminList = new ArrayList<>();
        Employee adminEmployee = new Employee();
        adminEmployee.setEmId(9L); // Set the manager's ID here
        adminList.add(adminEmployee);

        when(employeeRepository.findAllByEmpRole("Admin"))
                .thenReturn(adminList);

        when(inputFieldChecks.checkAddEmployeePassword(anyString(), anyString(),
                anyString())).thenReturn("hashedPassword");

        when(inputFieldChecks.isPossiblyHashed("hashedPassword")).thenReturn(false);

        OutDto expectedResult = new OutDto();
        expectedResult.setMessage(SuccessConstant.ADDED_SUCCESSFULLY);

        OutDto response = employeeService.addEmployee(input);
        verify(employeeRepository, times(1)).save(any(Employee.class));

        assertEquals(expectedResult.getMessage(), response.getMessage());
    }

    @Test
    void testGetAllManager() {
        Employee manager1 = new Employee();
        manager1.setEmId(1L);
        manager1.setEmpId("N0001");
        manager1.setEmpName("Ashish");
        manager1.setEmpEmail("ashish@nucleusteq.com");
        manager1.setEmpDob("25-04-2002");
        manager1.setEmpDoj("25-04-2023");
        manager1.setEmpLocation(Location.Bangalore);
        manager1.setEmpDesignation(Designation.OPERATION_ANALYST);
        manager1.setEmpContactNo("1111111111");
        manager1.setEmpPassword("12345678");
        manager1.setEmpRole("Admin");
        manager1.setEmpManagerId(9L);
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        manager1.setEmpProjectId(projects);
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        manager1.setEmpSkills(skills);

        List<Employee> managerList = new ArrayList<>();
        managerList.add(manager1);

        when(employeeRepository.findAllByEmpRole("Manager"))
                .thenReturn(managerList);

        List<AllManagerOutDto> responseList = employeeService.getAllManager();

        verify(employeeRepository, times(1)).findAllByEmpRole("Manager");

        assertEquals(1, responseList.size());

        AllManagerOutDto allManagerOutDto1 = new AllManagerOutDto();
        allManagerOutDto1.setEmId(1L);
        allManagerOutDto1.setEmpId("N0001");
        allManagerOutDto1.setEmpName("Ashish");
        allManagerOutDto1.setEmpEmail("ashish@nucleusteq.com");
        allManagerOutDto1.setEmpDoj("25-04-2023");
        allManagerOutDto1.setEmpLocation("Bangalore");
        allManagerOutDto1.setEmpDesignation("OPERATION_ANALYST");
        allManagerOutDto1.setEmpContactNo("1111111111");
        allManagerOutDto1.setEmpProjectId(projects);
        allManagerOutDto1.setEmpSkills(skills);

        assertEquals(allManagerOutDto1.getEmId(), responseList.get(0).getEmId());
        assertEquals(allManagerOutDto1.getEmpId(), responseList.get(0).getEmpId());
        assertEquals(allManagerOutDto1.getEmpName(), responseList.get(0).getEmpName());
        assertEquals(allManagerOutDto1.getEmpEmail(), responseList.get(0).getEmpEmail());
        assertEquals(allManagerOutDto1.getEmpDoj(), responseList.get(0).getEmpDoj());
        assertEquals(allManagerOutDto1.getEmpLocation(), responseList.get(0).getEmpLocation());
        assertEquals(allManagerOutDto1.getEmpDesignation(),
                responseList.get(0).getEmpDesignation());
        assertEquals(allManagerOutDto1.getEmpContactNo(),
                responseList.get(0).getEmpContactNo());
        assertEquals(allManagerOutDto1.getEmpProjectId(),
                responseList.get(0).getEmpProjectId());
        assertEquals(allManagerOutDto1.getEmpSkills(), responseList.get(0).getEmpSkills());

    }

    @Test
    void testGetAllManagerForProject() {
        List<Employee> allManagers = new ArrayList<>();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setEmId(1L);
        employee1.setEmpName("Ashish");
        employee1.setEmpId("N0001");
        employee2.setEmId(2L);
        employee2.setEmpName("Abhay");
        employee2.setEmpId("N0002");
        allManagers.add(employee1);
        allManagers.add(employee2);

        when(employeeRepository.findAllByEmpRole("Manager"))
                .thenReturn(allManagers);

        List<AllManagerForProjectOutDto> result = employeeService
                .getAllManagerForProject();
        verify(employeeRepository, times(1)).findAllByEmpRole("Manager");

        assertEquals(1L, result.get(0).getEmId());
        assertEquals("Ashish", result.get(0).getEmpName());
        assertEquals("N0001", result.get(0).getEmpId());
        assertEquals(2L, result.get(1).getEmId());
        assertEquals("Abhay", result.get(1).getEmpName());
        assertEquals("N0002", result.get(1).getEmpId());
    }

    @Test
    void testGetManagerById() {
        Employee manager = new Employee();
        manager.setEmId(1L);
        manager.setEmpName("Ashish");
        manager.setEmpId("N0001");
        when(employeeRepository.findByEmId(1L)).thenReturn(manager);

        String response = employeeService.getManagerById(1L);
        verify(employeeRepository, times(1)).findByEmId(1L);

        assertEquals("Ashish", response);
    }

    @Test
    void testAssignProjectToManager() {
        AssignProjectInDto input = new AssignProjectInDto();
        input.setEmpProjectId(5L);

        Employee employee = new Employee();
        employee.setEmId(1L);
        employee.setEmpId("N0001");
        employee.setEmpName("Ashish");
        employee.setEmpEmail("ashish@nucleusteq.com");
        employee.setEmpDob("25-04-2002");
        employee.setEmpDoj("25-04-2023");
        employee.setEmpLocation(Location.Bangalore);
        employee.setEmpDesignation(Designation.OPERATION_ANALYST);
        employee.setEmpContactNo("1111111111");
        employee.setEmpPassword("12345678");
        employee.setEmpRole("Admin");
        employee.setEmpManagerId(9L);
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        employee.setEmpProjectId(projects);
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        employee.setEmpSkills(skills);
        when(employeeRepository.findByEmId(1L)).thenReturn(employee);

        OutDto response = employeeService.assignProjectToManager(1L, input);
        verify(employeeRepository, times(1)).save(any(Employee.class));

        assertEquals(SuccessConstant.ASSIGNED_SUCCESSFULLY, response.getMessage());
    }

    @Test
    public void testGetEmployeeByEmail() {
        String sampleEmail = "ashish@nucleusteq.com";

        Employee employee = new Employee();
        employee.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        employee.setEmpProjectId(projects);
        employee.setEmpManagerId(3L);
        employee.setEmpSkills(skills);
        employee.setEmpDesignation(Designation.ARCHITECT);
        employee.setEmpLocation(Location.Bangalore);

        Employee manager = new Employee();
        manager.setEmId(3L);
        manager.setEmpName("Prerna");

        when(employeeRepository.findByEmpEmail(sampleEmail))
                .thenReturn(employee);
        when(employeeRepository.findByEmId(3L)).thenReturn(manager);

        AllEmployeeOutDto result = employeeService
                .getEmployeeByEmail(sampleEmail);

        verify(employeeRepository, times(1)).findByEmpEmail(sampleEmail);

        assertEquals(employee.getEmpName(), result.getEmpName());
    }

    @Test
    public void testAssignProjectToEmployee() {
        String sampleEmpId = "N0001";

        AssignProjectToEmployeeInDto sampleDto = new AssignProjectToEmployeeInDto();
        sampleDto.setProjectId(1L);
        sampleDto.setProjectManagerId(2L);

        Employee employee = new Employee();
        employee.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        employee.setEmpProjectId(projects);
        employee.setEmpSkills(skills);
        employee.setEmpDesignation(Designation.ARCHITECT);
        employee.setEmpLocation(Location.Bangalore);

        when(employeeRepository.findByEmpId(sampleEmpId)).thenReturn(employee);

        OutDto result = employeeService.assignProjectToEmployee(sampleEmpId,
                sampleDto);

        assertEquals(SuccessConstant.ASSIGNED_SUCCESSFULLY, result.getMessage());
    }

    @Test
    public void testUpdateEmployeeSkills() {
        String inputEmpEmail = "ashish@nucleusteq.com";
        UpdateSkillsInDto inputSkillDto = new UpdateSkillsInDto();
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        inputSkillDto.setSkills(skills);

        Employee employee = new Employee();
        employee.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        employee.setEmpProjectId(projects);
        employee.setEmpSkills(skills);
        employee.setEmpDesignation(Designation.ARCHITECT);
        employee.setEmpLocation(Location.Bangalore);

        when(employeeRepository.findByEmpEmail(inputEmpEmail))
                .thenReturn(employee);

        OutDto result = employeeService.updateEmployeeSkills(inputEmpEmail,
                inputSkillDto);

        assertEquals(SuccessConstant.UPDATED_SUCCESSFULLY, result.getMessage());
    }

    @Test
    public void testGetAllEmployeeForOrganization() {
        List<Employee> expectedEmployees = new ArrayList<>();
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
        employee.setEmpEmail("ashish@nucleusteq.com");
        employee.setEmpManagerId(9L);

        expectedEmployees.add(employee);

        Employee manager = new Employee();
        manager.setEmId(9L);
        manager.setEmpName("Prerna");

        when(employeeRepository.findAll()).thenReturn(expectedEmployees);
        when(employeeRepository.findByEmId(9L)).thenReturn(manager);

        List<AllEmployeeOutDto> result = employeeService
                .getAllEmployeeForOrganization();

        assertEquals(1, result.size());
        assertEquals(skills, result.get(0).getEmpSkills());
        assertEquals("Ashish", result.get(0).getEmpName());
        
        employee.setEmpEmail("ankita.sharma@nucleusteq.com");
        result = employeeService
                .getAllEmployeeForOrganization();

        employee.setEmpEmail("ashish@nucleusteq.com");
        expectedEmployees.add(null);
        result = employeeService
                .getAllEmployeeForOrganization();
    }

    @Test
    public void testFilteredEmployee() {
        List<Employee> expectedEmployees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        employee.setEmpProjectId(projects);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        employee.setEmpSkills(skills);
        employee.setEmpDesignation(Designation.ARCHITECT);
        employee.setEmpLocation(Location.Bangalore);
        employee.setEmpManagerId(4L);
        expectedEmployees.add(employee);
        
        Employee manager = new Employee();
        manager.setEmpName("Prerna");
        manager.setEmId(4L);

        when(employeeRepository.findAllByEmpRole("Employee"))
                .thenReturn(expectedEmployees);
        when(employeeRepository.findByEmId(4L)).thenReturn(manager);

        SearchFilteredEmployeeInDto filterDto = new SearchFilteredEmployeeInDto();
        filterDto.setSelectedSkills(Arrays.asList("Java"));
        filterDto.setShowOnlyUnassigned(true);

        List<AllEmployeeOutDto> result = employeeService
                .filteredEmployee(filterDto);

        assertEquals(1, result.size());
        assertEquals(skills, result.get(0).getEmpSkills());
        
        filterDto.setSelectedSkills(new ArrayList<>());
        filterDto.setShowOnlyUnassigned(false);
        result = employeeService
                .filteredEmployee(filterDto);
        
        expectedEmployees.add(null);
        result = employeeService
                .filteredEmployee(filterDto);
        
    }

    @Test
    public void testDeAssignProjectToEmployee() {
        String sampleEmpId = "N0001";
        Employee employee = new Employee();
        employee.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        employee.setEmpProjectId(projects);
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        employee.setEmpSkills(skills);
        employee.setEmpDesignation(Designation.ARCHITECT);
        employee.setEmpLocation(Location.Bangalore);
        employee.setEmpId(sampleEmpId);

        List<Employee> adminList = new ArrayList<>();
        Employee admin = new Employee();
        admin.setEmpName("Ankita");
        admin.setEmpProjectId(projects);
        admin.setEmpSkills(skills);
        admin.setEmpDesignation(Designation.ARCHITECT);
        admin.setEmpLocation(Location.Bangalore);
        admin.setEmpId("N0002");

        adminList.add(admin);

        when(employeeRepository.findByEmpId(sampleEmpId)).thenReturn(employee);
        when(employeeRepository.findAllByEmpRole("Admin"))
                .thenReturn(adminList);

        OutDto result = employeeService.unAssignProjectToEmployee(sampleEmpId);

        assertEquals(SuccessConstant.UNASSIGNED_SUCCESSFULLY, result.getMessage());
    }
}
