package com.example.antra.springdemo.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private long empId;
    @Column(name = "employee_name", nullable = false)
    private String empName;
    @Column(name = "employee_salary", nullable = false)
    private long empSalary;
    @Column(name = "employee_age", nullable = false)
    private int empAge;
    @Column(name = "profile_image", nullable = false)
    private String prflImg;

    @ManyToOne
    @JoinColumn(name="dept_id", nullable=false)
    private Department dept;

    //Constructors
    public Employee() {

    }

    public Employee(String empName, long empSalary, int empAge, String prflImg, Department dept) {
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
        this.prflImg = prflImg;
        this.dept = dept;
    }

    //Getters And Setters


    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public long getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(long empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getPrflImg() {
        return prflImg;
    }

    public void setPrflImg(String prflImg) {
        this.prflImg = prflImg;
    }
    @JsonBackReference
    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    //ToString
    @Override
    public String toString() {
        return "Employee [id=" + empId
                + ", employeeName=" + empName
                + ", employeeSalary=" + empSalary
                + ", employeeAge=" + empAge
                + ", profileImage=" + prflImg
                + ", deptId=" + dept.getId() + "]";

    }

}