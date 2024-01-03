package org.example.dao;

import org.example.db.Database;
import org.example.model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDao {
    private final Connection connection;

    public ProjectDao(Connection connection){
        this.connection = connection;
    }
    public void insertProjects(Project project) {
        String sql = "INSERT INTO project (client_id, start_date, finish_date) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1,project.getClientId());
                preparedStatement.setString(2,project.getStartDate());
                preparedStatement.setString(3, project.getFinishDate());
                preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
