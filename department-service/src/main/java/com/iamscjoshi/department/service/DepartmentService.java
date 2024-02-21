package com.iamscjoshi.department.service;

import com.iamscjoshi.department.entity.Department;
import com.iamscjoshi.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of Department Service");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of Department Service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
