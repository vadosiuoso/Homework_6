package org.example.model;

import lombok.Data;

@Data
public class Client {
    private String name;

    public Client(String name){
        this.name = name;
    }

}
