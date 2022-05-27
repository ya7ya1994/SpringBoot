package com.example.antra.springdemo.repository;

import com.example.antra.springdemo.exception.ResourceNotFoundException;
import com.example.antra.springdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("FROM Employee WHERE empAge >= ?1")
    List<Employee> findByEmpAge(int empAge) throws ResourceNotFoundException;

    @Query("Select e.empAge, e.empId,e.empName, e.empSalary FROM Employee e GROUP BY e.empAge, e.empId, e.empName, e.empSalary")
    List<Employee> groupByAge() throws ResourceNotFoundException;
}
