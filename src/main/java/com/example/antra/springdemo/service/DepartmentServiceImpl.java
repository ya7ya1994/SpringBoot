package com.example.antra.springdemo.service;

import com.example.antra.springdemo.exception.ResourceNotFoundException;
import com.example.antra.springdemo.model.Department;
import com.example.antra.springdemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentRepository departmentRepository;




    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Long departmentId)
            throws ResourceNotFoundException {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));
        return ResponseEntity.ok().body(department);
    }

    @PostMapping("/departments")
    public Department createDepartment(@Valid @RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Long departmentId,
                                                   @Valid @RequestBody Department departmentDetails) throws ResourceNotFoundException {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));

        department.setname(departmentDetails.getname());
        final Department updateDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(updateDepartment);
    }

    @DeleteMapping("/departments/{id}")
    public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id") Long departmentId)
            throws ResourceNotFoundException {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found for this id :: " + departmentId));

        departmentRepository.delete(department);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


