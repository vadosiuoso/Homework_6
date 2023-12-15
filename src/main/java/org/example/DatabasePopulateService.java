package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance();
            Statement statement = connection.createStatement();
            String query = ReadSQL.readSqlFile("sql/populate_db.sql");
            int num = statement.executeUpdate(query);
            System.out.println(num);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

