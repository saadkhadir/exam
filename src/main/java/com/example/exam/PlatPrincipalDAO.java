package com.example.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlatPrincipalDAO {
    private Connection connection;

    public PlatPrincipalDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un plat principal
    public void ajouterPlatPrincipal(PlatPrincipal plat) throws SQLException {
        String query = "INSERT INTO PlatPrincipal (nom, prix) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, plat.getNom());
            statement.setFloat(2, plat.getPrix());
            statement.executeUpdate();
        }
    }

    // Récupérer un plat principal par ID
    public PlatPrincipal obtenirPlatPrincipalParId(int id) throws SQLException {
        String query = "SELECT * FROM PlatPrincipal WHERE id_plat = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new PlatPrincipal(
                            resultSet.getInt("id_plat"),
                            resultSet.getString("nom"),
                            resultSet.getFloat("prix")
                    );
                }
            }
        }
        return null;
    }

    // Récupérer tous les plats principaux
    public List<PlatPrincipal> obtenirTousLesPlatsPrincipaux() throws SQLException {
        List<PlatPrincipal> plats = new ArrayList<>();
        String query = "SELECT * FROM PlatPrincipal";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                plats.add(new PlatPrincipal(
                        resultSet.getInt("id_plat"),
                        resultSet.getString("nom"),
                        resultSet.getFloat("prix")
                ));
            }
        }
        return plats;
    }

    // Mettre à jour un plat principal
    public void mettreAJourPlatPrincipal(PlatPrincipal plat) throws SQLException {
        String query = "UPDATE PlatPrincipal SET nom = ?, prix = ? WHERE id_plat = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, plat.getNom());
            statement.setFloat(2, plat.getPrix());
            statement.setInt(3, plat.getId_plat());
            statement.executeUpdate();
        }
    }

    // Supprimer un plat principal
    public void supprimerPlatPrincipal(int id) throws SQLException {
        String query = "DELETE FROM PlatPrincipal WHERE id_plat = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
