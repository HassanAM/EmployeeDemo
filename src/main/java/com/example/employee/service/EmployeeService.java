package com.example.employee.service;

import com.example.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface EmployeeService {
    public Page<Employee> retrieveEmployees(Pageable pageable);

    public Employee getEmployee(Long employeeId);

    public void saveEmployee(Employee employee);

    public void validateEmployee(Employee employee);

    public void deleteEmployee(Long employeeId);

    public void updateEmployee(Employee employee);
}
