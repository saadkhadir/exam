package com.example.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplementDAO {
    private Connection connection;

    // Constructeur pour initialiser la connexion
    public SupplementDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un supplément dans la base de données
    public void ajouterSupplement(Supplement supplement) throws SQLException {
        String query = "INSERT INTO supplement (id_supplement, nom, prix) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, supplement.getId());
            preparedStatement.setString(2, supplement.getNom());
            preparedStatement.setDouble(3, supplement.getPrix());
            preparedStatement.executeUpdate();
        }
    }

    // Récupérer un supplément par son ID
    public Supplement getSupplementById(int id) throws SQLException {
        String query = "SELECT * FROM supplement WHERE id_supplement = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Supplement(
                            resultSet.getInt("id_supplement"),
                            resultSet.getString("nom"),
                            resultSet.getDouble("prix")
                    );
                }
            }
        }
        return null;
    }

    // Récupérer tous les suppléments
    public List<Supplement> getAllSupplements() throws SQLException {
        List<Supplement> supplements = new ArrayList<>();
        String query = "SELECT * FROM supplement";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                supplements.add(new Supplement(
                        resultSet.getInt("id_supplement"),
                        resultSet.getString("nom"),
                        resultSet.getDouble("prix")
                ));
            }
        }
        return supplements;
    }

    // Mettre à jour un supplément
    public void updateSupplement(Supplement supplement) throws SQLException {
        String query = "UPDATE supplement SET nom = ?, prix = ? WHERE id_supplement = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, supplement.getNom());
            preparedStatement.setDouble(2, supplement.getPrix());
            preparedStatement.setInt(3, supplement.getId());
            preparedStatement.executeUpdate();
        }
    }

    // Supprimer un supplément par son ID
    public void deleteSupplement(int id) throws SQLException {
        String query = "DELETE FROM supplement WHERE id_supplement = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
