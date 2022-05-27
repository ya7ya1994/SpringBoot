package com.example.antra.springdemo.service;

import com.example.antra.springdemo.exception.ResourceNotFoundException;
import com.example.antra.springdemo.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface EmployeeService {
    ResponseEntity<Employee> getEmployeeById(Long id) throws ResourceNotFoundException;
    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);
    ResponseEntity<Employee> updateEmployee(Long id, Employee employee) throws ResourceNotFoundException;
    Map<String, Boolean> deleteEmployee(Long id) throws ResourceNotFoundException;
    List<Employee> getEmployeesByAge(int age) throws ResourceNotFoundException;
    List<Employee> getEmployeesGroupedByAge() throws ResourceNotFoundException;
}
