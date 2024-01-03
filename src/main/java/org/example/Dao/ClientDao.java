package org.example.Dao;

import org.example.db.Database;
import org.example.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDao {
    public void insertClients(Client client)  {
        String sql = "INSERT INTO client (name) VALUES (?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, client.getName());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
