package com.example.employee.service.impl;

import com.example.employee.entity.Department;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }
}
