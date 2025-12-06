package com.employeemanagement.backend.inputcheck;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
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
import com.employeemanagement.backend.entity.Employee;
import com.employeemanagement.backend.entity.RequestResource;
import com.employeemanagement.backend.repository.EmployeeRepository;
import com.employeemanagement.backend.repository.RequestResourseRepository;

@ExtendWith(MockitoExtension.class)
class RequestResourceInputCheckTest {

    @InjectMocks
    RequestResourceInputCheck requestInputCheck;
    @Mock
    private EmployeeRepository employeeRepo;
    @Mock
    private RequestResourseRepository requestResourseRepo;

    @Test
    void testCheckAlreadyAssignedProjectToEmployee() {
        Employee employee = new Employee();
        employee.setEmpId("N0001");
        List<Long> projects = new ArrayList<>();
        employee.setEmpProjectId(projects);

        when(employeeRepo.findByEmpId("N0001")).thenReturn(employee);

        assertDoesNotThrow(() -> requestInputCheck
                .checkAlreadyAssignedProjectToEmployee("N0001"));

        assertThrows(DataNotFoundException.class, 
                () -> requestInputCheck.checkAlreadyAssignedProjectToEmployee("N0002"));
        
        projects.add(1L);
        employee.setEmpProjectId(projects);
        assertThrows(DataAlreadyExistException.class, 
                () -> requestInputCheck.checkAlreadyAssignedProjectToEmployee("N0001"));
    }

    @Test
    void testCheckManagerByEmail() {
        Employee employee = new Employee();
        employee.setEmpId("N0001");
        employee.setEmpEmail("abhay@nucleusteq.com");
        employee.setEmpRole("Manager");

        when(employeeRepo.findByEmpEmail("abhay@nucleusteq.com")).thenReturn(employee);

        assertDoesNotThrow(() -> requestInputCheck
                .checkManagerByEmail("abhay@nucleusteq.com"));

        assertThrows(InvalidInputException.class, 
                () -> requestInputCheck.checkManagerByEmail("abhaykumar@nucleusteq.com"));
        
        employee.setEmpRole("Employee");
        assertThrows(InvalidInputException.class, 
                () -> requestInputCheck.checkManagerByEmail("abhay@nucleusteq.com"));
    }

    @Test
    void testCheckRequestId() {
        RequestResource request = new RequestResource();
        request.setId(1L);
        when(requestResourseRepo.findById(1L)).thenReturn(Optional.of(request));
        
        assertDoesNotThrow(()->requestInputCheck.checkRequestId(1L));
        
        assertThrows(DataNotFoundException.class,
                ()->requestInputCheck.checkRequestId(2L));
    }

    @Test
    void testCheckManagerId() {
        when(requestResourseRepo.findAllByManagerId(anyLong())).thenReturn(new ArrayList<RequestResource>());
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkManagerId(anyLong()) );

        RequestResource request = new RequestResource();
        request.setId(1L);
        request.setManagerId(5L);
        List<RequestResource> allRequest = new ArrayList<>();
        allRequest.add(request);

        when(requestResourseRepo.findAllByManagerId(5L)).thenReturn(allRequest);
        assertDoesNotThrow(
                ()-> requestInputCheck.checkManagerId(5L) );
        
        allRequest.remove(0);
        when(requestResourseRepo.findAllByManagerId(5L)).thenReturn(allRequest);
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkManagerId(5L) );
        
        allRequest = null;
        when(requestResourseRepo.findAllByManagerId(5L)).thenReturn(allRequest);
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkManagerId(5L) );
        
    }

    @Test
    void testCheckEmployeeId() {
        when(requestResourseRepo.findAllByEmployeeId(anyLong())).thenReturn(new ArrayList<RequestResource>());
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkEmployeeId(anyLong()) );

        RequestResource request = new RequestResource();
        request.setId(1L);
        request.setEmployeeId(5L);
        List<RequestResource> allRequest = new ArrayList<>();
        allRequest.add(request);

        when(requestResourseRepo.findAllByEmployeeId(5L)).thenReturn(allRequest);
        assertDoesNotThrow(
                ()-> requestInputCheck.checkEmployeeId(5L) );
        
        allRequest.remove(0);
        when(requestResourseRepo.findAllByEmployeeId(5L)).thenReturn(allRequest);
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkEmployeeId(5L) );
        
        allRequest = null;
        when(requestResourseRepo.findAllByEmployeeId(5L)).thenReturn(allRequest);
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkEmployeeId(5L) );
    }

    @Test
    void testCheckProjectId() {
        when(requestResourseRepo.findAllByProjectId(anyLong())).thenReturn(new ArrayList<RequestResource>());
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkProjectId(anyLong()) );
        
        RequestResource request = new RequestResource();
        request.setId(1L);
        request.setProjectId(5L);
        List<RequestResource> allRequest = new ArrayList<>();
        allRequest.add(request);
        
        when(requestResourseRepo.findAllByProjectId(5L)).thenReturn(allRequest);
        assertDoesNotThrow(
                ()-> requestInputCheck.checkProjectId(5L) );
        
        allRequest.remove(0);
        when(requestResourseRepo.findAllByProjectId(5L)).thenReturn(allRequest);
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkProjectId(5L) );
        
        allRequest = null;
        when(requestResourseRepo.findAllByProjectId(5L)).thenReturn(allRequest);
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkProjectId(5L) );
    }

    @Test
    void testCheckEmployeeNotAssigned() {
        when(employeeRepo.findByEmId(1L)).thenReturn(null);
        assertThrows(DataNotFoundException.class,
                ()-> requestInputCheck.checkEmployeeNotAssigned(1L));
        
        Employee employee = new Employee();
        List<Long> project = new ArrayList<>();
        project.add(5L);
        employee.setEmpProjectId(project);
        employee.setEmId(1L);
        when(employeeRepo.findByEmId(1L)).thenReturn(employee);
        assertThrows(DataAlreadyExistException.class,
                ()-> requestInputCheck.checkEmployeeNotAssigned(1L));
        
        project.remove(0);
        employee.setEmpProjectId(project);
        assertDoesNotThrow(
                ()-> requestInputCheck.checkEmployeeNotAssigned(1L));
        
        
        
    }

}
