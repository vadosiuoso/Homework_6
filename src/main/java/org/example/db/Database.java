package org.example.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Database {

    private Connection connection;
    private static Database instance;
    private Database() {

    }


    public static Database getInstance() {
            if (instance == null) {
                try {
                    instance = new Database();
                    instance.connection = DriverManager.getConnection("jdbc:h2:./database","sa", "");
                } catch ( SQLException e) {
                    e.printStackTrace();

                }
            }
            return instance;
        }

    public Connection getConnection(){
        return connection;
    }
}


