package com.employeemanagement.backend.inputcheck;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.employeemanagement.backend.customexception.DataAlreadyExistException;
import com.employeemanagement.backend.customexception.DataNotFoundException;
import com.employeemanagement.backend.customexception.InvalidInputException;
import com.employeemanagement.backend.entity.Project;
import com.employeemanagement.backend.repository.ProjectRepository;
import com.employeemanagement.backend.constantsmessages.ErrorConstant;

@ExtendWith(MockitoExtension.class)
class ProjectInputCheckTest {

    @InjectMocks
    ProjectInputCheck projectInputCheck;
    @Mock
    private ProjectRepository projectRepo;

    @Test
    void testCheckName() {
        assertDoesNotThrow(() -> projectInputCheck
                .checkName("Employee Management System"));
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> projectInputCheck.checkName(""));
        assertEquals(ErrorConstant.EMPTY_NAME, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> projectInputCheck.checkName("Project 4"));
        assertEquals(ErrorConstant.INVALID_NAME, exception.getMessage());
    }

    @Test
    void testCheckStartDate() {
        assertDoesNotThrow(() -> projectInputCheck.checkStartDate("25-04-2023"));
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> projectInputCheck.checkStartDate(""));
        assertEquals(ErrorConstant.EMPTY_STARTDATE, exception.getMessage());
        
        exception = assertThrows(InvalidInputException.class,
                () -> projectInputCheck.checkStartDate("25/04/2023"));
        assertEquals(ErrorConstant.INVALID_STARTDATE, exception.getMessage());
        
        
    }

    @Test
    void testCheckSkills() {
        List<String> skills = new ArrayList<>();
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> projectInputCheck.checkSkills(skills));
        assertEquals(ErrorConstant.EMPTY_SKILLS, exception.getMessage());
        
        skills.add("Java");
        skills.add("Python");
        assertDoesNotThrow(() -> projectInputCheck
                .checkSkills(skills));
    }

    @Test
    void testCheckDescription() {
        assertDoesNotThrow(() -> projectInputCheck
                .checkDescription("Employee Management System"));
        InvalidInputException exception = assertThrows(InvalidInputException.class,
                () -> projectInputCheck.checkDescription(""));
        String s = "Description should not be empty.";
        assertEquals(s, exception.getMessage());

        exception = assertThrows(InvalidInputException.class,
                () -> projectInputCheck.checkDescription(null));
        assertEquals(s, exception.getMessage());

    }
    
    @Test
    void testCheckProjectNameExistance() {
        Project project = new Project();
        project.setProjectName("EMS");
        when(projectRepo.findByProjectName("EMS")).thenReturn(project);
        
        assertThrows(DataAlreadyExistException.class,
                ()-> projectInputCheck.checkProjectNameExistance("EMS"));
        assertDoesNotThrow(()-> projectInputCheck.checkProjectNameExistance("Employee Management System"));
    }

    @Test
    void testCheckProjectExistanceById() {
        Project project = new Project();
        project.setId(1L);
        project.setProjectName("EMS");
        when(projectRepo.findById(1L)).thenReturn(Optional.of(project));
        
        assertDoesNotThrow(()->projectInputCheck.checkProjectExistanceById(1L));
        assertThrows(DataNotFoundException.class,
                ()-> projectInputCheck.checkProjectExistanceById(6L));
    }

}
