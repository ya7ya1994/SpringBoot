package com.example.antra.springdemo.controller;

import java.util.List;
import java.util.Map;
import com.example.antra.springdemo.exception.ResourceNotFoundException;
import com.example.antra.springdemo.model.AgeGroupingResult;
import com.example.antra.springdemo.model.Employee;
import com.example.antra.springdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees/age/{age}")
    public List<Employee> getEmployeesByAge(@PathVariable(value = "age") int age) throws ResourceNotFoundException {
        return employeeService.getEmployeesByAge(age);
    }

    @GetMapping("/employeesGrouped")
    public List<AgeGroupingResult> getEmployeesGroupedByAge() throws ResourceNotFoundException {
        return employeeService.getEmployeesGroupedByAge();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        return employeeService.updateEmployee(employeeId, employeeDetails);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        return employeeService.deleteEmployee(employeeId);
    }


}