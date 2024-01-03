package org.example.db;


import org.example.util.ReadSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String query = ReadSQL.readSqlFile("sql/init_db.sql");
            int num = statement.executeUpdate(query);
            System.out.println(num);
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
