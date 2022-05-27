package com.example.antra.springdemo.controller;

import com.example.antra.springdemo.exception.ResourceNotFoundException;
import com.example.antra.springdemo.model.Department;
import com.example.antra.springdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) throws ResourceNotFoundException {
        return departmentService.getDepartmentById(id);
    }
    @PostMapping("/departments")
    public Department createDepartment(@Valid @RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Long departmentId,
                                                   @Valid @RequestBody Department departmentDetails) throws ResourceNotFoundException {
        return departmentService.updateDepartment(departmentId, departmentDetails);
    }

    @DeleteMapping("/departments/{id}")
    public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id") Long departmentId)
            throws ResourceNotFoundException {
        return departmentService.deleteDepartment(departmentId);
    }


}