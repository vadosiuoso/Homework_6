package org.example.dao;

import org.example.db.Database;
import org.example.model.Worker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WorkerDao {
    private final Connection connection;
    public WorkerDao(Connection connection){
        this.connection = connection;
    }
    public void insertWorker(Worker worker) {
        String sql = "INSERT INTO worker (name, birthday, level, salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, worker.getName());
                preparedStatement.setString(2, worker.getDate());
                preparedStatement.setString(3, worker.getLevel());
                preparedStatement.setInt(4, worker.getSalary());
                preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
