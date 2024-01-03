package org.example.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Project {
    private int clientId;
    private String startDate;
    private String finishDate;

    public Project(int clientId, String startDate, String finishDate){
        this.clientId = clientId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
