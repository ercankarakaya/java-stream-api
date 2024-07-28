package com.ercan.model;

import java.util.List;

public class Deparment {
    String name;
    List<String> employees;

    public Deparment(String name, List<String> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<String> getEmployees() {
        return employees;
    }
}
