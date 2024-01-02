package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance().getConnection();
            insertWorkers(connection);
            insertClients(connection);
            insertProjects(connection);
            insertProjectWorkers(connection);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    private static void insertWorkers(Connection connection) throws SQLException {
        String sql = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            Object[][] workerData = {
                    {"Adam", "1987-12-05", "Senior", 6000},
                    {"Anton", "1999-10-08", "Trainee", 800},
                    {"John", "1987-12-05", "Middle", 3500},
                    {"Thomas", "1980-02-18", "Senior", 5000},
                    {"Taras", "1992-01-10", "Junior", 1900},
                    {"Alex", "2000-04-19", "Junior", 1700},
                    {"James", "1984-09-24", "Middle", 3900},
                    {"Igor", "1989-07-11", "Trainee", 1200},
                    {"Max", "1977-04-29", "Senior", 5600},
                    {"Hans", "1995-12-01", "Junior", 2200}
            };

            for (Object[] data : workerData) {
                preparedStatement.setString(1, (String) data[0]);
                preparedStatement.setString(2, (String) data[1]);
                preparedStatement.setString(3, (String) data[2]);
                preparedStatement.setInt(4, (int) data[3]);
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        }
    }

    private static void insertClients(Connection connection) throws SQLException {
        String sql = "INSERT INTO client (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            String[] clientData = {"Lisa", "Arseniy", "Konstantin", "Sergii", "Anne"};

            for (String name : clientData) {
                preparedStatement.setString(1, name);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
    }

    private static void insertProjects(Connection connection) throws SQLException {
        String sql = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            Object[][] projectData = {
                    {1, "2021-10-01", "2022-12-01"},
                    {1, "2020-01-01", "2022-01-01"},
                    {1, "2019-09-01", "2022-10-01"},
                    {2, "2018-04-01", "2022-12-01"},
                    {3, "2019-10-01", "2022-08-01"},
                    {3, "2019-05-01", "2022-05-01"},
                    {4, "2021-02-01", "2022-07-01"},
                    {4, "2020-05-01", "2022-12-01"},
                    {5, "2020-04-01", "2022-11-01"},
                    {5, "2021-07-01", "2022-11-01"}
            };

            for (Object[] data : projectData) {
                preparedStatement.setInt(1, (int) data[0]);
                preparedStatement.setString(2, (String) data[1]);
                preparedStatement.setString(3, (String) data[2]);
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        }
    }

    private static void insertProjectWorkers(Connection connection) throws SQLException {
        String sql = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            int[][] projectWorkerData = {
                    {1, 1}, {2, 1}, {3, 3}, {3, 4},
                    {4, 3}, {5, 4}, {5, 5}, {6, 5},
                    {6, 6}, {7, 7}, {8, 8}, {9, 9},
                    {10, 10}
            };

            for (int[] data : projectWorkerData) {
                preparedStatement.setInt(1, data[0]);
                preparedStatement.setInt(2, data[1]);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        }
    }
}

