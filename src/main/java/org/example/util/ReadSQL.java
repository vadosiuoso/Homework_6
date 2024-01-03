package org.example.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadSQL {
    public static String readSqlFile(String filePath){
        StringBuilder query = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = br.readLine()) != null) {
                query.append(line).append("\n");
            }
        }catch (IOException e){
            System.out.println("SQL file not found");
        }
        return query.toString();
    }
}
