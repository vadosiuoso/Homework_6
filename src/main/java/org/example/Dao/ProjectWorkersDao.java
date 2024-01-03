package org.example.Dao;

import org.example.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectWorkersDao {
    public void insertProjectWorker(int projectId, int workerId) {
        String sql = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, projectId);
                preparedStatement.setInt(2, workerId);
                preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
