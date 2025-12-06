package com.employeemanagement.backend.repository;

import com.employeemanagement.backend.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository to store data in Employee Table.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * used to find the employee detail by email.
     *
     * @param email getting email from front-end.
     * @return employee object.
     */
    Employee findByEmpEmail(String email);

    /**
     * used to find employee by contact number.
     *
     * @param contact takes contact number.
     * @return return employee data.
     */
    Employee findByEmpContactNo(String contact);

    /**
     * used to find employee by employee id.
     *
     * @param empId takes employee id as input.
     * @return return employee details if exist.
     */
    Employee findByEmpId(String empId);

    /**
     * used to find list of employee who have same role.
     *
     * @param empRole takes role.
     * @return return list of employee.
     */
    List<Employee> findAllByEmpRole(String empRole);

    /**
     * used to find employee by emId.
     *
     * @param emId accept emId.
     * @return return employee if exist.
     */
    Employee findByEmId(Long emId);
}
