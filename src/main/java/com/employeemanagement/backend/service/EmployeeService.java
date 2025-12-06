package com.employeemanagement.backend.service;

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
import com.employeemanagement.backend.constantsmessages.SuccessConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service interface for the services of Employee table performed by API call.
 */

@Service
public class EmployeeService {

    /**
     * creating a object of EmployeeRepo.
     */
    @Autowired
    private EmployeeRepository employeeRepo;
    /**
     * creating object of PasswordEncoder.
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * creating object of InputFieldChecks to check input.
     */
    @Autowired
    private InputFieldChecks inputFieldChecks;

    /**
     * add admin.
     *
     * @param employeeInDto accept dto.
     * @return dto.
     * @throws InvalidInputException     throw exception.
     * @throws DataAlreadyExistException throw exception.
     */
    public final OutDto addAdmin(final EmployeeInDto employeeInDto)
            throws InvalidInputException, DataAlreadyExistException {
        String password = "";
        if (inputFieldChecks.isPossiblyHashed(employeeInDto.getEmpPassword())) {
            password = employeeInDto.getEmpPassword();
        } else {
            password = passwordEncoder.encode(employeeInDto.getEmpPassword());
        }

        List<String> skills = new ArrayList<>();
        List<Long> projects = new ArrayList<>();
        Employee employee = new Employee();
        employee.setEmpId(employeeInDto.getEmpId());
        employee.setEmpName(employeeInDto.getEmpName());
        employee.setEmpDob(employeeInDto.getEmpDob());
        employee.setEmpDoj(employeeInDto.getEmpDoj());
        employee.setEmpEmail(employeeInDto.getEmpEmail());
        employee.setEmpLocation(
                Location.valueOf(employeeInDto.getEmpLocation()));
        employee.setEmpDesignation(
                Designation.valueOf(employeeInDto.getEmpDesignation()));
        employee.setEmpContactNo(employeeInDto.getEmpContactNo());
        employee.setEmpPassword(password);
        employee.setEmpRole(employeeInDto.getEmpRole());
        employee.setEmpSkills(skills);
        employee.setEmpProjectId(projects);
        employee.setEmpManagerId(0L);

        employeeRepo.save(employee);
        OutDto response = new OutDto();
        response.setMessage(SuccessConstant.ADDED_SUCCESSFULLY);

        return response;

    }

    /**
     * used to login.
     *
     * @param employeeLoginDto accept login dto.
     * @return return responseLoginDto.
     * @throws InvalidInputException throw exception if input field are
     *                               incorrect.
     */
    public final LoginOutDto loginEmployee(
            final EmployeeLoginDto employeeLoginDto)
            throws InvalidInputException {
        Employee employee = employeeRepo
                .findByEmpEmail(employeeLoginDto.getEmpEmail());
        LoginOutDto loginOutDto = new LoginOutDto();
        loginOutDto.setMessage(SuccessConstant.SUCCESS);
        loginOutDto.setRole(employee.getEmpRole());
        loginOutDto.setEmpName(employee.getEmpName());
        return loginOutDto;

    }

    /**
     * used to get all employee.
     *
     * @return return list of employees.
     */
    public List<AllEmployeeOutDto> getAllEmployee() {
        // TODO Auto-generated method stub
        List<Employee> allEmployee = employeeRepo.findAllByEmpRole("Employee");
        List<AllEmployeeOutDto> allEmployeeDto = new ArrayList<>();
        for (Employee employee : allEmployee) {
            AllEmployeeOutDto employeeOutDto = new AllEmployeeOutDto();
            employeeOutDto.setEmpId(employee.getEmpId());
            employeeOutDto.setEmpName(employee.getEmpName());
            employeeOutDto.setEmpEmail(employee.getEmpEmail());
            employeeOutDto.setEmpDob(employee.getEmpDob());
            employeeOutDto.setEmpDoj(employee.getEmpDoj());
            employeeOutDto.setEmpLocation(employee.getEmpLocation().toString());
            employeeOutDto.setEmpDesignation(
                    employee.getEmpDesignation().toString());
            employeeOutDto.setEmpContactNo(employee.getEmpContactNo());
            employeeOutDto.setEmpManagerId(employee.getEmpManagerId());
            employeeOutDto.setEmpProjectId(employee.getEmpProjectId());
            employeeOutDto.setEmpSkills(employee.getEmpSkills());
            Employee manager = employeeRepo.findByEmId(
                    employee.getEmpManagerId());
            employeeOutDto.setManagerName(manager.getEmpName());
            allEmployeeDto.add(employeeOutDto);
        }
        return allEmployeeDto;
    }

    /**
     * used to add employee.
     *
     * @param employeeInDto
     * @return return responseDto with message.
     * @throws InvalidInputException
     * @throws DataAlreadyExistException
     */
    public OutDto addEmployee(final EmployeeInDto employeeInDto)
            throws InvalidInputException, DataAlreadyExistException {
        String password = inputFieldChecks.checkAddEmployeePassword(
                employeeInDto.getEmpPassword(), employeeInDto.getEmpId(),
                employeeInDto.getEmpDob());
        if (!inputFieldChecks.isPossiblyHashed(password)) {
            password = passwordEncoder.encode(password);
        }

        Employee employee = new Employee();
        employee.setEmpId(employeeInDto.getEmpId());
        employee.setEmpName(employeeInDto.getEmpName());
        employee.setEmpDob(employeeInDto.getEmpDob());
        employee.setEmpDoj(employeeInDto.getEmpDoj());
        employee.setEmpEmail(employeeInDto.getEmpEmail());
        employee.setEmpLocation(Location.valueOf(
                employeeInDto.getEmpLocation()));
        employee.setEmpDesignation(
                Designation.valueOf(employeeInDto.getEmpDesignation()));
        employee.setEmpContactNo(employeeInDto.getEmpContactNo());
        employee.setEmpPassword(password);
        employee.setEmpRole(employeeInDto.getEmpRole());
        employee.setEmpSkills(employeeInDto.getEmpSkills());
        employee.setEmpProjectId(new ArrayList<Long>());
        List<Employee> admin = employeeRepo.findAllByEmpRole("Admin");

        employee.setEmpManagerId(admin.get(0).getEmId());

        employeeRepo.save(employee);
        OutDto outDto = new OutDto();
        outDto.setMessage(SuccessConstant.ADDED_SUCCESSFULLY);
        return outDto;
    }

    /**
     * used to get all the manager list.
     *
     * @return return list of manager.
     */
    public List<AllManagerOutDto> getAllManager() {
        // TODO Auto-generated method stub
        List<Employee> allManager = employeeRepo.findAllByEmpRole("Manager");
        List<AllManagerOutDto> allManagerDto = new ArrayList<>();
        for (Employee manager : allManager) {
            AllManagerOutDto managerDto = new AllManagerOutDto();
            managerDto.setEmpId(manager.getEmpId());
            managerDto.setEmId(manager.getEmId());
            managerDto.setEmpName(manager.getEmpName());
            managerDto.setEmpEmail(manager.getEmpEmail());
            managerDto.setEmpDoj(manager.getEmpDoj());
            managerDto.setEmpLocation(manager.getEmpLocation().toString());
            managerDto.setEmpDesignation(
                    manager.getEmpDesignation().toString());
            managerDto.setEmpContactNo(manager.getEmpContactNo());
            managerDto.setEmpSkills(manager.getEmpSkills());
            managerDto.setEmpProjectId(manager.getEmpProjectId());
            allManagerDto.add(managerDto);
        }
        return allManagerDto;
    }

    /**
     * used to get list of managers for project.
     *
     * @return return list of managers.
     */
    public List<AllManagerForProjectOutDto> getAllManagerForProject() {
        // TODO Auto-generated method stub
        List<Employee> allManager = employeeRepo.findAllByEmpRole("Manager");
        List<AllManagerForProjectOutDto> allManagerDto = new ArrayList<>();
        for (Employee employee : allManager) {
            AllManagerForProjectOutDto managerDto =
                    new AllManagerForProjectOutDto();
            managerDto.setEmId(employee.getEmId());
            managerDto.setEmpId(employee.getEmpId());
            managerDto.setEmpName(employee.getEmpName());
            allManagerDto.add(managerDto);
        }
        return allManagerDto;
    }

    /**
     * used to get manager details by id.
     *
     * @param emId accept id.
     * @return Return name of manager.
     */
    public String getManagerById(final Long emId) {
        // TODO Auto-generated method stub
        Employee manager = employeeRepo.findByEmId(emId);
        String managerName = manager.getEmpName();
        return managerName;
    }

    /**
     * used to assign project to manager.
     *
     * @param emId       accept employee id.
     * @param projectDto accept projectDto.
     * @return return ResponseDto with message and role.
     */
    public OutDto assignProjectToManager(final Long emId,
            final AssignProjectInDto projectDto) {
        // TODO Auto-generated method stub
        Employee manager = employeeRepo.findByEmId(emId);
        List<Long> existingProject = manager.getEmpProjectId();
        existingProject.add(projectDto.getEmpProjectId());
        manager.setEmpProjectId(existingProject);
        employeeRepo.save(manager);

        OutDto outDto = new OutDto();
        outDto.setMessage(SuccessConstant.ASSIGNED_SUCCESSFULLY);
        return outDto;
    }

    /**
     * Used to get employee details from email id.
     *
     * @param empEmail Accept email id.
     * @return return details of employee.
     */
    public AllEmployeeOutDto getEmployeeByEmail(final String empEmail) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepo.findByEmpEmail(empEmail);
        AllEmployeeOutDto allEmployeeOutDto = new AllEmployeeOutDto();
        allEmployeeOutDto.setEmpContactNo(employee.getEmpContactNo());
        allEmployeeOutDto.setEmpDesignation(
                employee.getEmpDesignation().toString());
        allEmployeeOutDto.setEmpDob(employee.getEmpDob());
        allEmployeeOutDto.setEmpDoj(employee.getEmpDoj());
        allEmployeeOutDto.setEmpEmail(employee.getEmpEmail());
        allEmployeeOutDto.setEmpId(employee.getEmpId());
        allEmployeeOutDto.setEmpLocation(employee.getEmpLocation().toString());
        allEmployeeOutDto.setEmpManagerId(employee.getEmpManagerId());
        allEmployeeOutDto.setEmpName(employee.getEmpName());
        allEmployeeOutDto.setEmpProjectId(employee.getEmpProjectId());
        allEmployeeOutDto.setEmpSkills(employee.getEmpSkills());
        Employee manager = employeeRepo.findByEmId(employee.getEmpManagerId());
        allEmployeeOutDto.setManagerName(manager.getEmpName());
        return allEmployeeOutDto;
    }

    /**
     * Used to assign project to employee.
     *
     * @param empId                      Takes employee id.
     * @param assignProjectToEmployeeInDto Takes dto of project.
     * @return Return success messeage.
     */
    public OutDto assignProjectToEmployee(final String empId,
            final AssignProjectToEmployeeInDto assignProjectToEmployeeInDto) {
        Employee employee = this.employeeRepo.findByEmpId(empId);
        List<Long> projectList = employee.getEmpProjectId();

        projectList.add(assignProjectToEmployeeInDto.getProjectId());
        employee.setEmpProjectId(projectList);
        employee.setEmpManagerId(
                assignProjectToEmployeeInDto.getProjectManagerId());

        employeeRepo.save(employee);

        OutDto response = new OutDto();
        response.setMessage(SuccessConstant.ASSIGNED_SUCCESSFULLY);
        return response;
    }


    /**
     * Used to update skills of employee.
     *
     * @param empEmail      Takes email of employee.
     * @param updatedSkills Takes updated skills dto.
     * @return Return message.
     */
    public OutDto updateEmployeeSkills(final String empEmail,
            final UpdateSkillsInDto updatedSkills) {
        Employee employee = employeeRepo.findByEmpEmail(empEmail);
        employee.setEmpSkills(updatedSkills.getSkills());
        employeeRepo.save(employee);
        OutDto response = new OutDto();
        response.setMessage(SuccessConstant.UPDATED_SUCCESSFULLY);
        return response;
    }

    /**
     * Used to get list of all the employees, managers of organization.
     *
     * @return All employees, managers details.
     */
    public List<AllEmployeeOutDto> getAllEmployeeForOrganization() {
        // TODO Auto-generated method stub
        List<Employee> allEmployee = employeeRepo.findAll();
        List<AllEmployeeOutDto> allEmployeeDto = new ArrayList<>();
        for (Employee employee : allEmployee) {
            if (employee != null
                    && !employee.getEmpEmail().equals("ankita.sharma"
                            + "@nucleusteq.com")) {
                AllEmployeeOutDto employeeOutDto = new AllEmployeeOutDto();
                employeeOutDto.setEmpId(employee.getEmpId());
                employeeOutDto.setEmpName(employee.getEmpName());
                employeeOutDto.setEmpEmail(employee.getEmpEmail());
                employeeOutDto.setEmpDob(employee.getEmpDob());
                employeeOutDto.setEmpDoj(employee.getEmpDoj());
                employeeOutDto.setEmpLocation(
                        employee.getEmpLocation().toString());
                employeeOutDto.setEmpDesignation(
                        employee.getEmpDesignation().toString());
                employeeOutDto.setEmpContactNo(employee.getEmpContactNo());
                employeeOutDto.setEmpManagerId(employee.getEmpManagerId());
                employeeOutDto.setEmpProjectId(employee.getEmpProjectId());
                employeeOutDto.setEmpSkills(employee.getEmpSkills());
                Employee manager = employeeRepo.findByEmId(
                        employee.getEmpManagerId());
                employeeOutDto.setManagerName(manager.getEmpName());
                allEmployeeDto.add(employeeOutDto);
            }
        }
        return allEmployeeDto;
    }

    /**
     * Used to get filtered list based on skill and project.
     *
     * @param filterDto Takes required skills and signal for unassigned.
     * @return Return list of employees.
     */
    public List<AllEmployeeOutDto> filteredEmployee(
            final SearchFilteredEmployeeInDto filterDto) {

        List<Employee> allEmployee = employeeRepo.findAllByEmpRole("Employee");
        List<Employee> returnedList = new ArrayList<>(allEmployee);

        if (filterDto.getSelectedSkills().size() != 0) {
            returnedList = allEmployee.stream()
                    .filter(employee -> employee.getEmpSkills().stream()
                            .anyMatch(filterDto.getSelectedSkills()::contains))
                    .collect(Collectors.toList());
        }

        if (filterDto.isShowOnlyUnassigned()) {
            List<Employee> unAssignedEmployee = returnedList.stream()
                    .filter(employee -> employee.getEmpProjectId().size() == 0)
                    .collect(Collectors.toList());
            returnedList = new ArrayList<>(unAssignedEmployee);
        }

        List<AllEmployeeOutDto> allEmployeeDto = new ArrayList<>();
        for (Employee employee : returnedList) {
            if (employee != null) {
                AllEmployeeOutDto employeeOutDto = new AllEmployeeOutDto();
                employeeOutDto.setEmpId(employee.getEmpId());
                employeeOutDto.setEmpName(employee.getEmpName());
                employeeOutDto.setEmpEmail(employee.getEmpEmail());
                employeeOutDto.setEmpDob(employee.getEmpDob());
                employeeOutDto.setEmpDoj(employee.getEmpDoj());
                employeeOutDto.setEmpLocation(
                        employee.getEmpLocation().toString());
                employeeOutDto.setEmpDesignation(
                        employee.getEmpDesignation().toString());
                employeeOutDto.setEmpContactNo(employee.getEmpContactNo());
                employeeOutDto.setEmpManagerId(employee.getEmpManagerId());
                employeeOutDto.setEmpProjectId(employee.getEmpProjectId());
                employeeOutDto.setEmpSkills(employee.getEmpSkills());
                Employee manager = employeeRepo.findByEmId(
                        employee.getEmpManagerId());
                employeeOutDto.setManagerName(manager.getEmpName());
                allEmployeeDto.add(employeeOutDto);
            }
        }

        return allEmployeeDto;
    }

    /**
     * Used to unassign project to employee.
     *
     * @param employeeId Takes employee id.
     * @return Return response with message.
     */
    public OutDto unAssignProjectToEmployee(final String employeeId) {
        // TODO Auto-generated method stub
        Employee employee = employeeRepo.findByEmpId(employeeId);

        List<Employee> admin = employeeRepo.findAllByEmpRole("Admin");

        List<Long> newProject = new ArrayList<>();
        employee.setEmpProjectId(newProject);
        employee.setEmpManagerId(admin.get(0).getEmId());
        employeeRepo.save(employee);

        OutDto response = new OutDto();
        response.setMessage(SuccessConstant.UNASSIGNED_SUCCESSFULLY);
        return response;
    }
}
