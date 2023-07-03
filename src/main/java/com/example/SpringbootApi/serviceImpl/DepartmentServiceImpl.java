package com.example.SpringbootApi.serviceImpl;

import com.example.SpringbootApi.entity.Department;
import com.example.SpringbootApi.entity.Product;
import com.example.SpringbootApi.dto.DepartmentDTO;
import com.example.SpringbootApi.repository.DepartmentRepository;
import com.example.SpringbootApi.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    public DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department saveDepartmentDetails(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(String name) {
        return departmentRepository.findByDeptName(name);
    }

    @Override
    public Department findByDeptName(String departmentName) {
        return departmentRepository.findByDeptName(departmentName);
    }

    @Override
    public List<DepartmentDTO> getDepartments() {
        List<DepartmentDTO> temp = departmentRepository.findAll()
                .stream()
                .map(d->{
                    List<Product> tempProduct = d.getProducts()
                            .stream()
                            .filter(p->p.getDeletevalue() ==1)
                            .collect(Collectors.toList());
                    d.setProducts(tempProduct);
                    return d;
                })
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
        return temp;
    }

    @Override
    public DepartmentDTO getDepartment(Integer deptId) {
        return this.convertEntityToDTO(departmentRepository.findByDeptId(deptId));
    }
    private DepartmentDTO convertEntityToDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        if(department != null){
            departmentDTO.setDeptName(department.getDeptName());
            departmentDTO.setProducts(department.getProducts());
        }
        return departmentDTO;
    }
}
