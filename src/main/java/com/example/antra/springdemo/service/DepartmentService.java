package com.example.antra.springdemo.service;

import com.example.antra.springdemo.exception.ResourceNotFoundException;
import com.example.antra.springdemo.model.Department;
import com.example.antra.springdemo.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {
    ResponseEntity<Department> getDepartmentById(Long id) throws ResourceNotFoundException;
    List<Department> getAllDepartments();
    Department createDepartment(Department department);
    ResponseEntity<Department> updateDepartment(Long id, Department department) throws ResourceNotFoundException;
    Map<String, Boolean> deleteDepartment(Long id) throws ResourceNotFoundException;
}
