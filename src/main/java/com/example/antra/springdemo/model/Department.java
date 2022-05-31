package com.example.antra.springdemo.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private long id;
    @Column(name = "name")
    private String name;

    @OneToMany (
            mappedBy = "dept",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Employee> employees ;

    //Constructors
    public Department() {
    }
    public Department(String deptName, List<Employee> employees) {
        this.name = deptName;
        this.employees = employees;
    }

    //Getters And Setters
    @JsonManagedReference
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String deptName) {
        this.name = deptName;
    }

    /*//ToString
    @Override
    public String toString() {
        return "Department [id=" + id + ", departmentName=" + name + "]";

    }*/
}
