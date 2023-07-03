package com.example.SpringbootApi.controller;

import com.example.SpringbootApi.dto.DepartmentDTO;
import com.example.SpringbootApi.entity.Department;
import com.example.SpringbootApi.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {
    public DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Department> saveDepartmentDetails(@RequestBody Department department){
        return new ResponseEntity<Department>(departmentService.saveDepartmentDetails(department), HttpStatus.CREATED);
    }

    @GetMapping("/listdepartments")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<DepartmentDTO> findAllDepartment( ){
        System.out.println(departmentService.getDepartments().toString());
        return departmentService.getDepartments();
    }

}
