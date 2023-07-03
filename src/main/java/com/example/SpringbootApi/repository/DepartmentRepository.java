package com.example.SpringbootApi.repository;

import com.example.SpringbootApi.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {

    Department findByDeptName(String departmentName);

    Department findByDeptId(Integer deptId);


}
