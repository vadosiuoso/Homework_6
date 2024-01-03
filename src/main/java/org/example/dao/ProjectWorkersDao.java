package org.example.dao;

import org.example.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectWorkersDao {
    private final Connection connection;

    public ProjectWorkersDao(Connection connection){
        this.connection = connection;
    }
    public void insertProjectWorker(int projectId, int workerId) {
        String sql = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, projectId);
                preparedStatement.setInt(2, workerId);
                preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
