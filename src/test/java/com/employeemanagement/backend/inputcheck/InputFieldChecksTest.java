package com.employeemanagement.backend.inputcheck;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.DataNotFoundException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.entity.Employee;
import com.employeemanagement.backend.enumlists.Designation;
import com.employeemanagement.backend.enumlists.Location;
import com.employeemanagement.backend.repository.EmployeeRepository;
import com.employeemanagement.backend.constantsmessages.ErrorConstant;

@ExtendWith(MockitoExtension.class)
class InputFieldChecksTest {

    @InjectMocks
    private InputFieldChecks inputFieldChecks;
    @Mock
    private EmployeeRepository employeeRepo;

    @Test
    void testCheckEmpId() {
        assertDoesNotThrow(() -> inputFieldChecks.checkEmpId("N0001"));
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkEmpId("N000"));
        assertEquals(ErrorConstant.INVALID_EMP_ID, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkEmpId(""));
        assertEquals(ErrorConstant.EMPTY_EMP_ID, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkEmpId("N0000"));
        assertEquals(ErrorConstant.INVALID_EMP_ID_N0000,
                exception.getMessage());

    }

    @Test
    void testCheckDob() {
        assertDoesNotThrow(() -> inputFieldChecks.checkDob("25-04-2002"));
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkDob(""));
        assertEquals(ErrorConstant.EMPTY_DOB, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkDob("25-04-02"));
        assertEquals(ErrorConstant.INVALID_DOB, exception.getMessage());
    }

    @Test
    void testCheckDoj() {
        assertDoesNotThrow(() -> inputFieldChecks.checkDoj("25-04-2002"));
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkDoj(""));
        assertEquals(ErrorConstant.EMPTY_DOJ, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkDoj("25-04-02"));
        assertEquals(ErrorConstant.INVALID_DOJ, exception.getMessage());
    }

    @Test
    void testCheckDatesDifference() {
        String dob = "01-01-1990";
        String doj = "01-01-2020";
        assertDoesNotThrow(
                () -> inputFieldChecks.checkDatesDifference(dob, doj));

        String dob2 = "01-01-2015";
        Exception exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkDatesDifference(dob2, doj));
        String message = "DOB should be atleast 18 year older than DOJ.";
        assertEquals(message, exception.getMessage());

    }

    @Test
    void testCheckEmpEmail() {
        assertDoesNotThrow(
                () -> inputFieldChecks.checkEmpEmail("ashish@nucleusteq.com"));
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkEmpEmail(""));
        assertEquals(ErrorConstant.EMPTY_EMAIL, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkEmpEmail("ashish"));
        assertEquals(ErrorConstant.INVALID_EMAIL, exception.getMessage());
    }

    @Test
    void testCheckValidAdminEmail() {
        assertDoesNotThrow(() -> inputFieldChecks
                .checkEmpEmail("ankita.sharma@nucleusteq.com"));
        DataAlreadyExistException exception = assertThrows(
                DataAlreadyExistException.class,
                () -> inputFieldChecks.checkValidAdminEmail(
                        "ashish@nucleusteq.com"));
        String s = "admin should have email id as "
                + "ankita.sharma@nucleusteq.com";
        assertEquals(s, exception.getMessage());

    }

    @Test
    void testCheckEmpContactNo() {
        assertDoesNotThrow(
                () -> inputFieldChecks.checkEmpContactNo("1111111111"));
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkEmpContactNo(""));
        assertEquals(ErrorConstant.EMPTY_CONTACT, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkEmpContactNo("1111a"));
        assertEquals(ErrorConstant.INVALID_CONTACT, exception.getMessage());
    }

    @Test
    void testCheckEmpPassword() {
        assertDoesNotThrow(() -> inputFieldChecks.checkEmpPassword("12345678"));
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkEmpPassword(""));
        assertEquals(ErrorConstant.EMPTY_PASSWORD, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkEmpPassword("1111a"));
        assertEquals(ErrorConstant.INVALID_PASSWORD, exception.getMessage());
    }

    @Test
    void testCheckEmpName() {
        assertDoesNotThrow(() -> inputFieldChecks.checkEmpName("Ashish"));
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkEmpName(""));
        assertEquals(ErrorConstant.EMPTY_NAME, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkEmpName("1111a"));
        assertEquals(ErrorConstant.INVALID_NAME, exception.getMessage());
    }

    @Test
    void testCheckEmpLocation() {
        assertDoesNotThrow(() -> inputFieldChecks.checkEmpLocation("Raipur"));
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkEmpLocation(""));
        String s = "Location should not be empty.";
        assertEquals(s, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkEmpLocation("Delli"));
        s = "Not a valid location.";
        assertEquals(s, exception.getMessage());
    }

    @Test
    void testCheckEmpDesignation() {
        assertDoesNotThrow(
                () -> inputFieldChecks.checkEmpDesignation("ENGINEER"));
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkEmpDesignation(""));
        String s = "Designation should not be empty.";
        assertEquals(s, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkEmpDesignation("Manager"));
        s = "Not a valid designation.";
        assertEquals(s, exception.getMessage());
    }

    @Test
    void testCheckEmpSkills() {
        List<String> skills = new ArrayList<>();
        InvalidInputException exception = assertThrows(
                InvalidInputException.class,
                () -> inputFieldChecks.checkEmpSkills(skills));
        assertEquals(ErrorConstant.EMPTY_SKILLS, exception.getMessage());

        skills.add("Java");
        skills.add("Python");
        assertDoesNotThrow(() -> inputFieldChecks.checkEmpSkills(skills));
        skills.add("sql");
        exception = assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkEmpSkills(skills));
        assertEquals(skills.get(2) + ErrorConstant.INVALID_SKILLS,
                exception.getMessage());
    }
    
    @Test
    void testCheckEmployeeRole() {
        assertDoesNotThrow(()->inputFieldChecks.checkEmployeeRole("Admin"));
        assertDoesNotThrow(()->inputFieldChecks.checkEmployeeRole("Employee"));
        assertDoesNotThrow(()->inputFieldChecks.checkEmployeeRole("Manager"));
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                ()->inputFieldChecks.checkEmployeeRole("Adminn"));
        assertEquals(ErrorConstant.INVALID_ROLE, exception.getMessage());
    }

    @Test
    void testCheckEmailExistance() {

        String existing = "ashish@nucleusteq.com";

        Employee output = new Employee();
        output.setEmpId("N0001");
        output.setEmpName("Ashish");
        output.setEmpEmail("ashish@nucleusteq.com");
        output.setEmpDob("25-04-2002");
        output.setEmpDoj("25-04-2023");
        output.setEmpLocation(Location.Raipur);
        output.setEmpDesignation(Designation.ENGINEER);
        output.setEmpContactNo("1111111111");
        output.setEmpPassword("12345678");
        output.setEmpRole("Admin");
        List<Long> project = new ArrayList<>();
        project.add(5L);
        output.setEmpProjectId(project);
        output.setEmpManagerId(9L);
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        output.setEmpSkills(skills);

        when(employeeRepo.findByEmpEmail(existing)).thenReturn(output);

        assertThrows(DataAlreadyExistException.class,
                () -> inputFieldChecks.checkEmailExistance(output.getEmpEmail()));
        assertDoesNotThrow(
                () -> inputFieldChecks
                .checkEmailExistance("prerna@nucleusteq.com"));

    }

    @Test
    void testCheckEmpIdExistance() {
        String existing = "N0001";
        Employee output = new Employee();
        output.setEmpId("N0001");
        output.setEmpName("Ashish");
        output.setEmpEmail("ashish@nucleusteq.com");
        output.setEmpDob("25-04-2002");
        output.setEmpDoj("25-04-2023");
        output.setEmpLocation(Location.Raipur);
        output.setEmpDesignation(Designation.ENGINEER);
        output.setEmpContactNo("1111111111");
        output.setEmpPassword("12345678");
        output.setEmpRole("Admin");
        List<Long> project = new ArrayList<>();
        project.add(5L);
        output.setEmpProjectId(project);
        output.setEmpManagerId(9L);
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        output.setEmpSkills(skills);

        when(employeeRepo.findByEmpId(existing)).thenReturn(output);

        assertThrows(DataAlreadyExistException.class,
                () -> inputFieldChecks.checkEmpIdExistance(existing));

    }

    @Test
    void testCheckEmpContactExistance() {
        String existing = "1111111111";
        Employee output = new Employee();
        output.setEmpId("N0001");
        output.setEmpName("Ashish");
        output.setEmpEmail("ashish@nucleusteq.com");
        output.setEmpDob("25-04-2002");
        output.setEmpDoj("25-04-2023");
        output.setEmpLocation(Location.Raipur);
        output.setEmpDesignation(Designation.ENGINEER);
        output.setEmpContactNo("1111111111");
        output.setEmpPassword("12345678");
        output.setEmpRole("Admin");
        List<Long> project = new ArrayList<>();
        project.add(5L);
        output.setEmpProjectId(project);
        output.setEmpManagerId(9L);
        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        output.setEmpSkills(skills);

        when(employeeRepo.findByEmpContactNo(existing)).thenReturn(output);

        assertThrows(DataAlreadyExistException.class,
                () -> inputFieldChecks.checkEmpContactExistance(existing));
    }

    @Test
    void testIsPossiblyHashed() {
        assertFalse(inputFieldChecks.isPossiblyHashed("12345678"));
        String hashed = "1345fdafd@#@$gfgfg7686435rSFDFGDGSF#%%46576875465";
        assertTrue(inputFieldChecks.isPossiblyHashed(hashed));
    }

    @Test
    void testCheckAddEmployeePassword() {
        String password = inputFieldChecks.checkAddEmployeePassword(null,
                "N0001", "25-04-2002");
        assertEquals("N0001@25042002", password);
        password = inputFieldChecks.checkAddEmployeePassword("", "N0001",
                "25-04-2002");
        assertEquals("N0001@25042002", password);
        password = inputFieldChecks.checkAddEmployeePassword("12345678",
                "N0001", "25-04-2006");
        assertEquals("12345678", password);
    }

    @Test
    public void testCheckEmailNotExistance() {
        String email = "ashish@nucleusteq.com";
        when(employeeRepo.findByEmpEmail(email)).thenReturn(null);
        assertThrows(DataNotFoundException.class,
                () -> inputFieldChecks.checkEmailNotExistance(email));
    }

    @Test
    public void testCheckEmpIdNotExistance() {
        String empId = "N0002";
        when(employeeRepo.findByEmpId(empId)).thenReturn(null);
        assertThrows(DataNotFoundException.class,
                () -> inputFieldChecks.checkEmpIdNotExistance(empId));
    }

    @Test
    public void testCheckEmIdNotExistance() {
        Long emId = 1L;
        when(employeeRepo.findByEmId(emId)).thenReturn(null);
        assertThrows(DataNotFoundException.class,
                () -> inputFieldChecks.checkEmIdNotExistance(emId));
    }

    @Test
    public void testCheckEmpContactNotExistance() {
        String empContact = "1111111111";
        when(employeeRepo.findByEmpContactNo(empContact)).thenReturn(null);
        assertThrows(DataNotFoundException.class,
                () -> inputFieldChecks.checkEmpContactNotExistance(empContact));
    }

    @Test
    public void testCheckIsManagerByemId() throws InvalidInputException {
        Employee employee = new Employee();
        employee.setEmId(1L);
        employee.setEmpRole("Manager");
        employee.setEmpName("Ashish");

        when(employeeRepo.findByEmId(1L)).thenReturn(employee);
        inputFieldChecks.checkIsManagerByemId(1L);

        employee.setEmpRole("Employee");

        assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkIsManagerByemId(1L));
    }

    @Test
    public void testCheckRoleEmployeeByEmpId() throws InvalidInputException {
        Employee employee = new Employee();
        employee.setEmpId("N0001");
        employee.setEmpRole("Employee");
        employee.setEmpName("Ashish");

        when(employeeRepo.findByEmpId("N0001")).thenReturn(employee);
        inputFieldChecks.checkRoleEmployeeByEmpId("N0001");

        employee.setEmpRole("Manager");

        assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkRoleEmployeeByEmpId("N0001"));
    }

    @Test
    public void testCheckHaveProjectByEmpId() {
        Employee employee = new Employee();
        employee.setEmpId("N0001");
        employee.setEmpRole("Employee");
        employee.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        employee.setEmpProjectId(projects);
        when(employeeRepo.findByEmpId("N0001")).thenReturn(employee);
        assertThrows(DataNotFoundException.class,
                () -> inputFieldChecks.checkHaveProjectByEmpId("N0001"));

        projects.add(5L);
        employee.setEmpProjectId(projects);
        when(employeeRepo.findByEmpId("N0001")).thenReturn(employee);
        when(employeeRepo.findByEmpId("N0001")).thenReturn(employee);
        assertDoesNotThrow(
                () -> inputFieldChecks.checkHaveProjectByEmpId("N0001"));

    }

    @Test
    void testcheckEmployeeHaveProject() {
        Employee employee = new Employee();
        employee.setEmpId("N0001");
        employee.setEmpRole("Employee");
        employee.setEmpName("Ashish");
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        employee.setEmpProjectId(projects);
        when(employeeRepo.findByEmpId("N0001")).thenReturn(employee);
        assertThrows(DataAlreadyExistException.class,
                () -> inputFieldChecks.checkEmployeeHaveProject("N0001"));

        projects.remove(0);
        employee.setEmpProjectId(projects);
        when(employeeRepo.findByEmpId("N0001")).thenReturn(employee);
        assertDoesNotThrow(
                () -> inputFieldChecks.checkEmployeeHaveProject("N0001"));

    }

    @Test
    public void testCheckIsManagerByEmailId() throws InvalidInputException {
        Employee employee = new Employee();
        employee.setEmpId("N0001");
        employee.setEmpRole("Manager");
        employee.setEmpName("Ashish");
        employee.setEmpEmail("ashish@nucleusteq.com");

        when(employeeRepo.findByEmpEmail("ashish@nucleusteq.com"))
                .thenReturn(employee);
        inputFieldChecks.checkIsManagerByEmailId("ashish@nucleusteq.com");

        employee.setEmpRole("Employee");

        assertThrows(InvalidInputException.class,
                () -> inputFieldChecks.checkIsManagerByEmailId("ashish@nucleusteq.com"));
    }

}
