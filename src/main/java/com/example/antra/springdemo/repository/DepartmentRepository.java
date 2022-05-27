package com.example.antra.springdemo.repository;

import com.example.antra.springdemo.model.Department;
import com.example.antra.springdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
