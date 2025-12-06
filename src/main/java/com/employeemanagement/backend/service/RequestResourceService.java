package com.employeemanagement.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.employeemanagement.backend.dto.ReqResouceForEmployeeCheckInDto;
import com.employeemanagement.backend.dto.RequestAcceptInDto;
import com.employeemanagement.backend.dto.RequestResourceInDto;
import com.employeemanagement.backend.constantsmessages.SuccessConstant;
import com.employeemanagement.backend.dto.AllRequestOutDto;
import com.employeemanagement.backend.dto.OutDto;
import com.employeemanagement.backend.entity.Employee;
import com.employeemanagement.backend.entity.Project;
import com.employeemanagement.backend.entity.RequestResource;
import com.employeemanagement.backend.repository.EmployeeRepository;
import com.employeemanagement.backend.repository.ProjectRepository;
import com.employeemanagement.backend.repository.RequestResourseRepository;

import jakarta.transaction.Transactional;

/**
 * Services for the request resourse controller.
 */
@Service
@Component
public class RequestResourceService {

    /**
     * Object of RequestResourseRepository.
     */
    @Autowired
    private RequestResourseRepository requestResourseRepository;
    /**
     * Object of employeeRepository.
     */
    @Autowired
    private EmployeeRepository employeeRepo;
    /**
     * Object of projectRepository.
     */
    @Autowired
    private ProjectRepository projectRepo;

    /**
     * Used to add a new request to the table.
     *
     * @param requestResponseInput Takes inputs for the table.
     * @return Return a message.
     */
    public OutDto addRequestService(
            final RequestResourceInDto requestResponseInput) {
        Employee manager = employeeRepo
                .findByEmpEmail(requestResponseInput.getManagerEmail());
        Employee employee = employeeRepo
                .findByEmpId(requestResponseInput.getEmpId());
        RequestResource requestResourse = new RequestResource();
        requestResourse.setComment(requestResponseInput.getComment());
        requestResourse.setEmployeeId(employee.getEmId());
        requestResourse.setManagerId(manager.getEmId());
        requestResourse.setProjectId(requestResponseInput.getProjectId());

        requestResourseRepository.save(requestResourse);

        OutDto response = new OutDto();
        response.setMessage(SuccessConstant.ADDED_SUCCESSFULLY);
        return response;
    }

    /**
     * Used to check if employee is already requested by the manager.
     *
     * @param reqResouceForEmployeeCheckInDto Takes manager id and project id.
     * @return Return a message.
     */
    public OutDto checkRequestResourceForEmployee(
            final ReqResouceForEmployeeCheckInDto
            reqResouceForEmployeeCheckInDto) {
        Employee manager = employeeRepo.findByEmpEmail(
                reqResouceForEmployeeCheckInDto.getManagerEmail());
        Employee employee = employeeRepo
                .findByEmpId(reqResouceForEmployeeCheckInDto.getEmpId());
        List<RequestResource> allEmployeeForManager = requestResourseRepository
                .findAllByManagerId(manager.getEmId());

        OutDto response = new OutDto();
        response.setMessage(SuccessConstant.FALSE);

        for (RequestResource reqResourse : allEmployeeForManager) {
            if (reqResourse.getEmployeeId().equals(employee.getEmId())) {
                response.setMessage(SuccessConstant.TRUE);
            }
        }
        return response;
    }

    /**
     * Used to get all request present in the table.
     *
     * @return Return list of reqeuests.
     */
    public List<AllRequestOutDto> getAllRequests() {
        // TODO Auto-generated method stub
        List<RequestResource> allRequests = requestResourseRepository.findAll();
        List<AllRequestOutDto> responseRequest = new ArrayList<>();
        for (RequestResource request : allRequests) {
            AllRequestOutDto response = new AllRequestOutDto();

            Employee employee = employeeRepo
                    .findByEmId(request.getEmployeeId());
            Employee manager = employeeRepo.findByEmId(request.getManagerId());
            Optional<Project> optionalProject = projectRepo
                    .findById(request.getProjectId());
            Project project = optionalProject.orElse(new Project());

            response.setComment(request.getComment());
            response.setEmployeeId(request.getEmployeeId());
            response.setId(request.getId());
            response.setManagerId(request.getManagerId());
            response.setProjectId(request.getProjectId());
            response.setEmpName(employee.getEmpName());
            response.setManagerName(manager.getEmpName());
            response.setProjectName(project.getProjectName());

            responseRequest.add(response);
        }
        return responseRequest;
    }

    /**
     * Used to relete request by request id.
     *
     * @param requestId Takes request id.
     * @return Return a message.
     */
    public OutDto deleteRequest(final Long requestId) {
        // TODO Auto-generated method stub
        requestResourseRepository.deleteById(requestId);
        OutDto response = new OutDto();
        response.setMessage(SuccessConstant.DELETED_SUCCESSFULLY);
        return response;
    }

    /**
     * Used to accept request.
     *
     * @param requestAcceptInDto Takes required field to accept request.
     * @return Return a message.
     */
    @Transactional
    public OutDto acceptRequest(final RequestAcceptInDto requestAcceptInDto) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepo
                .findByEmId(requestAcceptInDto.getEmployeeId());

        List<Long> projectList = employee.getEmpProjectId();
        projectList.add(requestAcceptInDto.getProjectId());
        employee.setEmpProjectId(projectList);
        employee.setEmpManagerId(requestAcceptInDto.getManagerId());
        employeeRepo.save(employee);

        requestResourseRepository
                .deleteByEmployeeId(requestAcceptInDto.getEmployeeId());

        OutDto response = new OutDto();
        response.setMessage(SuccessConstant.ACCEPTED_SUCCESSFULLY);
        return response;
    }

}
