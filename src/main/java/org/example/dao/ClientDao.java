package org.example.dao;

import org.example.model.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDao {
    private final Connection connection;
    public ClientDao(Connection connection) {
        this.connection = connection;
    }

    public void insertClients(Client client)  {
        String sql = "INSERT INTO client (name) VALUES (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
