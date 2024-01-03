package org.example.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Worker {
    private String name;
    private String date;
    private String level;
    private int salary;

    public Worker(String name, String date, String level, int salary){
        this.name = name;
        this.date = date;
        this.level = level;
        this.salary = salary;
    }
}
