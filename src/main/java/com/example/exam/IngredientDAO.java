package com.example.exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO {
    private Connection connection;

    public IngredientDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un ingrédient
    public void ajouterIngredient(Ingredient ingredient) throws SQLException {
        String query = "INSERT INTO Ingredient (nom, prixUnitaire, quantite) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ingredient.getNom());
            statement.setDouble(2, ingredient.getPrixUnitaire());
            statement.setDouble(3, ingredient.getQuantite());
            statement.executeUpdate();
        }
    }

    // Récupérer un ingrédient par ID
    public Ingredient obtenirIngredientParId(int id) throws SQLException {
        String query = "SELECT * FROM Ingredient WHERE id_ingredient = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Ingredient(
                            resultSet.getInt("id_ingredient"),
                            resultSet.getString("nom"),
                            resultSet.getDouble("prixUnitaire"),
                            resultSet.getDouble("quantite")
                    );
                }
            }
        }
        return null;
    }

    // Récupérer tous les ingrédients
    public List<Ingredient> obtenirTousLesIngredients() throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        String query = "SELECT * FROM Ingredient";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                ingredients.add(new Ingredient(
                        resultSet.getInt("id_ingredient"),
                        resultSet.getString("nom"),
                        resultSet.getDouble("prixUnitaire"),
                        resultSet.getDouble("quantite")
                ));
            }
        }
        return ingredients;
    }

    // Mettre à jour un ingrédient
    public void mettreAJourIngredient(Ingredient ingredient) throws SQLException {
        String query = "UPDATE Ingredient SET nom = ?, prixUnitaire = ?, quantite = ? WHERE id_ingredient = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, ingredient.getNom());
            statement.setDouble(2, ingredient.getPrixUnitaire());
            statement.setDouble(3, ingredient.getQuantite());
            statement.setInt(4, ingredient.getId());
            statement.executeUpdate();
        }
    }

    // Supprimer un ingrédient
    public void supprimerIngredient(int id) throws SQLException {
        String query = "DELETE FROM Ingredient WHERE id_ingredient = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
