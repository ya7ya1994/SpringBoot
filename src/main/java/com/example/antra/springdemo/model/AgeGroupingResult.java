package com.example.antra.springdemo.model;

public class AgeGroupingResult {
    private int empAge;
    private Long count;


    //Constructor

    public AgeGroupingResult(int empAge, Long count) {
        this.empAge = empAge;
        this.count = count;
    }


    //Getters and Setters


    public long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }
}
