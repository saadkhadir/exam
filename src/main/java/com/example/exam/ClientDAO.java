package com.example.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    // Méthode pour ajouter un client
    public void ajouterClient(Client client) throws SQLException {
        String query = "INSERT INTO Client (nom, prenom, email, telephone) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrenom());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getTelephone());
            statement.executeUpdate();
        }
    }

    // Méthode pour récupérer un client par ID
    public Client obtenirClientParId(int id) throws SQLException {
        String query = "SELECT * FROM Client WHERE id_client = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Client(
                            resultSet.getInt("id_client"),
                            resultSet.getString("nom"),
                            resultSet.getString("prenom"),
                            resultSet.getString("email"),
                            resultSet.getString("telephone")
                    );
                }
            }
        }
        return null;
    }

    // Méthode pour récupérer tous les clients
    public List<Client> obtenirTousLesClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM Client";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                clients.add(new Client(
                        resultSet.getInt("id_client"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getString("telephone")
                ));
            }
        }
        return clients;
    }

    // Méthode pour mettre à jour un client
    public void mettreAJourClient(Client client) throws SQLException {
        String query = "UPDATE Client SET nom = ?, prenom = ?, email = ?, telephone = ? WHERE id_client = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrenom());
            statement.setString(3, client.getEmail());
            statement.setString(4, client.getTelephone());
            statement.setInt(5, client.getId_client());
            statement.executeUpdate();
        }
    }

    // Méthode pour supprimer un client
    public void supprimerClient(int id) throws SQLException {
        String query = "DELETE FROM Client WHERE id_client = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}

