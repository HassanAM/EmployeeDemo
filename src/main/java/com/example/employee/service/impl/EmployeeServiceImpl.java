package com.example.employee.service.impl;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.employee.entity.Employee;
import com.example.employee.response.ErrorMessages;
import com.example.employee.service.EmployeeService;
import exception.EmployeeServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    String regexPattern = "\\d{11}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
    Pattern pattern = Pattern.compile(regexPattern);

    @Autowired
    private EmployeeRepository employeeRepository;

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Page<Employee> retrieveEmployees(Pageable pageable) {
        Page<Employee> employees = employeeRepository.findAll(pageable);
        return employees;
    }

    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        return optEmp.get();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void validateEmployee(Employee employee) {
        if (employee.getFirstName() == null || employee.getLastName() == null) {
            throw new EmployeeServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }

        if (employee.getFirstName().length() <=2  || employee.getLastName().length() <=2 ) {
            throw new EmployeeServiceException(ErrorMessages.MISSING_REQUIRED_FIELD_SIZE.getErrorMessage());
        }

        if (employee.getSalary() <= 0) {
                throw new EmployeeServiceException(ErrorMessages.AUTHENTICATION_FAILED.getErrorMessage());
        }
        Matcher m = pattern.matcher(employee.getPhone());

        if (!m.matches()) {
            throw new EmployeeServiceException(ErrorMessages.AUTHENTICATION_FAILED.getErrorMessage());
        }
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
