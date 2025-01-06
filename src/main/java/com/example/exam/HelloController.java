
package com.example.exam;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;

public class HelloController {

    @FXML
    private ComboBox<Repas> repasComboBox;
    @FXML
    private ListView<Ingredient> ingredientsListView;
    @FXML
    private ListView<Supplement> supplementsListView;
    @FXML
    private TextField totalTextField;
    @FXML
    private Button ajouterIngredientButton;
    @FXML
    private Button supprimerIngredientButton;
    @FXML
    private Button ajouterSupplementButton;
    @FXML
    private Button supprimerSupplementButton;
    @FXML
    private Button finaliserCommandeButton;

    private Repas repasSelectionne;
    private List<Ingredient> ingredientsSelectionnes;
    private List<Supplement> supplementsSelectionnes;
    private Repas repaseSelectionne;

    public HelloController() {
        this.ingredientsSelectionnes = new ArrayList<>();
        this.supplementsSelectionnes = new ArrayList<>();
    }

    @FXML
    private void initialize() {
        // Initialiser la ComboBox avec des repas (par exemple, à partir d'une base de données ou d'une liste prédéfinie)
        repasComboBox.getItems().addAll(obtenirRepasDisponibles());

        repasComboBox.setOnAction(event -> updateMealSelection());
        ajouterIngredientButton.setOnAction(this::ajouterIngredient);
        supprimerIngredientButton.setOnAction(this::supprimerIngredient);
        ajouterSupplementButton.setOnAction(this::ajouterSupplement);
        supprimerSupplementButton.setOnAction(this::supprimerSupplement);
        finaliserCommandeButton.setOnAction(this::finaliserCommande);
    }

    private List<Repas> obtenirRepasDisponibles() {
        // Retourner une liste de repas disponibles (cela peut venir de votre logique métier)
        // Exemple de repas
        PlatPrincipal plat1 = new PlatPrincipal("Pasta", (float) 12.99);
        Repas repas1 = new Repas(1, "Repas 1", plat1, new ArrayList<>(), new ArrayList<>());

        PlatPrincipal plat2 = new PlatPrincipal("Burger", (float)8.00);
        Repas repas2 = new Repas(2, "Repas 2", plat2, new ArrayList<>(), new ArrayList<>());

        return List.of(repas1, repas2);
    }

    private void updateMealSelection() {
        repasSelectionne = repasComboBox.getSelectionModel().getSelectedItem();
        if (repasSelectionne != null) {
            ingredientsListView.getItems().clear();
            ingredientsListView.getItems().addAll(repaseSelectionne.getIngredients());

            supplementsListView.getItems().clear();
            supplementsListView.getItems().addAll(repaseSelectionne.getSupplements());

            recalculerTotal();
        }
    }

    private void ajouterIngredient(ActionEvent event) {
        Ingredient ingredientSelectionne = ingredientsListView.getSelectionModel().getSelectedItem();
        if (ingredientSelectionne != null && !ingredientsSelectionnes.contains(ingredientSelectionne)) {
            ingredientsSelectionnes.add(ingredientSelectionne);
            recalculerTotal();
        }
    }

    private void supprimerIngredient(ActionEvent event) {
        Ingredient ingredientSelectionne = ingredientsListView.getSelectionModel().getSelectedItem();
        if (ingredientSelectionne != null && ingredientsSelectionnes.contains(ingredientSelectionne)) {
            ingredientsSelectionnes.remove(ingredientSelectionne);
            recalculerTotal();
        }
    }

    private void ajouterSupplement(ActionEvent event) {
        Supplement supplementSelectionne = supplementsListView.getSelectionModel().getSelectedItem();
        if (supplementSelectionne != null && !supplementsSelectionnes.contains(supplementSelectionne)) {
            supplementsSelectionnes.add(supplementSelectionne);
            recalculerTotal();
        }
    }

    private void supprimerSupplement(ActionEvent event) {
        Supplement supplementSelectionne = supplementsListView.getSelectionModel().getSelectedItem();
        if (supplementSelectionne != null && supplementsSelectionnes.contains(supplementSelectionne)) {
            supplementsSelectionnes.remove(supplementSelectionne);
            recalculerTotal();
        }
    }

    private void recalculerTotal() {
        if (repasSelectionne != null) {
            double total = repasSelectionne.calculerTotal();
            totalTextField.setText("Total: " + total + " €");
        }
    }

    private void finaliserCommande(ActionEvent event) {
        if (repasSelectionne != null) {
            // Afficher un ticket avec les détails de la commande (cela peut être une fenêtre séparée)
            String ticket = repasSelectionne.toString();
            Alert ticketAlert = new Alert(Alert.AlertType.INFORMATION);
            ticketAlert.setTitle("Ticket de Commande");
            ticketAlert.setHeaderText("Votre commande");
            ticketAlert.setContentText(ticket);
            ticketAlert.showAndWait();
        }
    }
    @FXML
    public void onHelloButtonClick() {
        System.out.println("Button clicked!");
    }
}
