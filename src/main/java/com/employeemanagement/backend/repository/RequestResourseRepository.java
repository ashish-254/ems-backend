package com.employeemanagement.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.backend.entity.RequestResource;

/**
 * Repositry for RequestResourse table.
 */
@Repository
public interface RequestResourseRepository
        extends JpaRepository<RequestResource, Long> {
    /**
     * Used to find all request by manager id.
     *
     * @param managerId Takes manager id.
     * @return Return list of request.
     */
    List<RequestResource> findAllByManagerId(Long managerId);
    /**
     * Used to find all request by project id.
     *
     * @param projectId Takes project id.
     * @return Return list of requests.
     */
    List<RequestResource> findAllByProjectId(Long projectId);
    /**
     * Used to find all request by employee id.
     *
     * @param employeeId Takes employeeid.
     * @return Return list of requests.
     */
    List<RequestResource> findAllByEmployeeId(Long employeeId);
    /**
     * Used to delete request by employee id.
     *
     * @param employeeId Takes employee id.
     */
    void deleteByEmployeeId(Long employeeId);
}
