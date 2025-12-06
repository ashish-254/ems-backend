package com.employeemanagement.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.backend.entity.Project;

/**
 * Repository for Project table.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    /**
     * used to find list of project by manager id.
     *
     * @param managerId takes manage id.
     * @return return list of projects.
     */
    List<Project> findAllByManagerId(Long managerId);
    /**
     * used to find project by project name.
     *
     * @param projectName accept project name.
     * @return return project data.
     */
    Project findByProjectName(String projectName);
}
