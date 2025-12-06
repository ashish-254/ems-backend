package com.employeemanagement.backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
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

import com.employeemanagement.backend.dto.ReqResouceForEmployeeCheckInDto;
import com.employeemanagement.backend.dto.RequestAcceptInDto;
import com.employeemanagement.backend.dto.RequestResourceInDto;
import com.employeemanagement.backend.constantsmessages.SuccessConstant;
import com.employeemanagement.backend.dto.AllRequestOutDto;
import com.employeemanagement.backend.dto.OutDto;
import com.employeemanagement.backend.entity.Employee;
import com.employeemanagement.backend.entity.Project;
import com.employeemanagement.backend.entity.RequestResource;
import com.employeemanagement.backend.enumlists.Designation;
import com.employeemanagement.backend.enumlists.Location;
import com.employeemanagement.backend.repository.EmployeeRepository;
import com.employeemanagement.backend.repository.ProjectRepository;
import com.employeemanagement.backend.repository.RequestResourseRepository;

@ExtendWith(MockitoExtension.class)
class RequestResourceServiceTest {

    @InjectMocks
    RequestResourceService requestService;

    @Mock
    private RequestResourseRepository requestRepo;

    @Mock
    private EmployeeRepository employeeRepo;

    @Mock
    private ProjectRepository projectRepo;

    @Test
    void testAddRequestService() {
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

        Employee employee = new Employee();
        employee.setEmId(2L);
        employee.setEmpName("Abhay");
        employee.setEmpProjectId(projects);
        employee.setEmpSkills(skills);
        employee.setEmpDesignation(Designation.ARCHITECT);
        employee.setEmpLocation(Location.Bangalore);
        employee.setEmpId("N0002");
        employee.setEmpRole("Employee");
        employee.setEmpEmail("abhay@nucleusteq.com");

        RequestResourceInDto requestDto = new RequestResourceInDto();
        requestDto.setComment("Comment");
        requestDto.setEmpId("N0002");
        requestDto.setManagerEmail("ashish@nucleusteq.com");
        requestDto.setProjectId(1L);

        RequestResource request = new RequestResource();
        request.setComment(requestDto.getComment());
        request.setEmployeeId(employee.getEmId());
        request.setManagerId(manager.getEmId());
        request.setProjectId(1L);

        when(employeeRepo.findByEmpEmail("ashish@nucleusteq.com"))
                .thenReturn(manager);
        when(employeeRepo.findByEmpId("N0002")).thenReturn(employee);
        when(requestRepo.save(any(RequestResource.class))).thenReturn(request);

        OutDto expectedResult = new OutDto();
        expectedResult.setMessage(SuccessConstant.ADDED_SUCCESSFULLY);

        OutDto result = requestService.addRequestService(requestDto);
        assertEquals(result.getMessage(), expectedResult.getMessage());
        
        verify(employeeRepo, times(1)).findByEmpEmail("ashish@nucleusteq.com");
        verify(employeeRepo, times(1)).findByEmpId("N0002");
        verify(requestRepo, times(1)).save(any(RequestResource.class));
    }

    @Test
    void testCheckRequestResourseForEmployee() {
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

        Employee employee = new Employee();
        employee.setEmId(2L);
        employee.setEmpName("Abhay");
        employee.setEmpProjectId(projects);
        employee.setEmpSkills(skills);
        employee.setEmpDesignation(Designation.ARCHITECT);
        employee.setEmpLocation(Location.Bangalore);
        employee.setEmpId("N0002");
        employee.setEmpRole("Employee");
        employee.setEmpEmail("abhay@nucleusteq.com");

        List<RequestResource> requestsByManagerId = new ArrayList<>();
        RequestResource request = new RequestResource();
        request.setComment("Comment");
        request.setEmployeeId(employee.getEmId());
        request.setManagerId(manager.getEmId());
        request.setProjectId(1L);
        requestsByManagerId.add(request);

        ReqResouceForEmployeeCheckInDto reqResourceInDto = new ReqResouceForEmployeeCheckInDto();
        reqResourceInDto.setEmpId("N0002");
        reqResourceInDto.setManagerEmail("ashish@nucleusteq.com");

        when(employeeRepo.findByEmpEmail("ashish@nucleusteq.com"))
                .thenReturn(manager);
        when(employeeRepo.findByEmpId("N0002")).thenReturn(employee);
        when(requestRepo.findAllByManagerId(1L))
                .thenReturn(requestsByManagerId);

        OutDto result = requestService
                .checkRequestResourceForEmployee(reqResourceInDto);

        assertEquals(result.getMessage(), "True");

        verify(employeeRepo, times(1)).findByEmpEmail("ashish@nucleusteq.com");
        verify(employeeRepo, times(1)).findByEmpId("N0002");
        verify(requestRepo, times(1)).findAllByManagerId(1L);

    }

    @Test
    void testGetAllRequests() {

        RequestResource request = new RequestResource();
        request.setComment("Comment");
        request.setEmployeeId(2L);
        request.setManagerId(1L);
        request.setProjectId(1L);

        Employee employee = new Employee();
        employee.setEmpName("Abhay");

        Employee manager = new Employee();
        manager.setEmpName("Ashish");

        Project project = new Project();
        project.setProjectName("EMS");

        List<RequestResource> allRequests = new ArrayList<>();
        allRequests.add(request);
        when(requestRepo.findAll()).thenReturn(allRequests);

        when(employeeRepo.findByEmId(request.getEmployeeId()))
                .thenReturn(employee);
        when(employeeRepo.findByEmId(request.getManagerId()))
                .thenReturn(manager);

        Optional<Project> optionalProject = Optional.of(project);
        when(projectRepo.findById(request.getProjectId()))
                .thenReturn(optionalProject);

        List<AllRequestOutDto> result = requestService.getAllRequests();

        assertEquals(1, result.size());
        AllRequestOutDto response = result.get(0);
        assertEquals("Comment", response.getComment());
        assertEquals(2L, response.getEmployeeId());
        assertEquals(1L, response.getManagerId());
        assertEquals(1L, response.getProjectId());
        assertEquals("Abhay", response.getEmpName());
        assertEquals("Ashish", response.getManagerName());
        assertEquals("EMS", response.getProjectName());

        verify(requestRepo, times(1)).findAll();
        verify(employeeRepo, times(1)).findByEmId(request.getEmployeeId());
        verify(employeeRepo, times(1)).findByEmId(request.getManagerId());
        verify(projectRepo, times(1)).findById(request.getProjectId());

    }

    @Test
    void testDeleteRequest() {
        doNothing().when(requestRepo).deleteById(anyLong());
        OutDto response = requestService.deleteRequest(1L);
        assertEquals(SuccessConstant.DELETED_SUCCESSFULLY, response.getMessage());
        verify(requestRepo, times(1)).deleteById(1L);
    }

    @Test
    void testAcceptRequest() {
        Employee employee = new Employee();
        List<Long> projects = new ArrayList<>();
        projects.add(5L);
        employee.setEmpProjectId(projects);
        employee.setEmId(2L);

        when(employeeRepo.findByEmId(2L)).thenReturn(employee);
        when(employeeRepo.save(any(Employee.class))).thenReturn(employee);
        doNothing().when(requestRepo).deleteByEmployeeId(anyLong());

        RequestAcceptInDto requestAcceptDto = new RequestAcceptInDto();
        requestAcceptDto.setEmployeeId(2L);
        requestAcceptDto.setManagerId(1L);
        requestAcceptDto.setProjectId(5L);

        OutDto response = requestService.acceptRequest(requestAcceptDto);
        assertEquals(SuccessConstant.ACCEPTED_SUCCESSFULLY, response.getMessage());

        verify(employeeRepo, times(1)).findByEmId(2L);
        verify(employeeRepo, times(1)).save(any(Employee.class));
        verify(requestRepo, times(1)).deleteByEmployeeId(anyLong());
    }

}
