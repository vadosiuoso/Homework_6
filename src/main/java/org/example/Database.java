package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;
    private Database() {

    }


    public static Connection getInstance() {
            if (connection == null) {
                try {
                    connection = DriverManager.getConnection("jdbc:h2:./database","sa", "");
                } catch ( SQLException e) {
                    e.printStackTrace();

                }
            }
            return connection;
        }
    }


