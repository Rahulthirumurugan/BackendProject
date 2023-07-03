package com.example.SpringbootApi.service;

import com.example.SpringbootApi.dto.DepartmentDTO;
import com.example.SpringbootApi.entity.Department;

import java.util.List;

public interface DepartmentService{
    Department saveDepartmentDetails(Department department);

    public Department getDepartment(String name);

    Department findByDeptName(String departmentName);

    List<DepartmentDTO> getDepartments();
    public DepartmentDTO getDepartment(Integer deptId);
}
