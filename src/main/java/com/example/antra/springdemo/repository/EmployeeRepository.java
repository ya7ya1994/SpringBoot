package com.example.antra.springdemo.repository;

import com.example.antra.springdemo.exception.ResourceNotFoundException;
import com.example.antra.springdemo.model.AgeGroupingResult;
import com.example.antra.springdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("FROM Employee WHERE empAge >= ?1")
    List<Employee> findByEmpAge(int empAge) throws ResourceNotFoundException;

    @Query("Select NEW com.example.antra.springdemo.model.AgeGroupingResult (e.empAge,COUNT(e)) FROM Employee e GROUP BY e.empAge")
    List<AgeGroupingResult> groupByAge() throws ResourceNotFoundException;
}
