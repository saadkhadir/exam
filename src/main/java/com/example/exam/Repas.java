package com.example.exam;
// Classe Repas
import java.util.List;

public class Repas {
    private int id;
    private PlatPrincipal platPrincipal;
    private List<Ingredient> ingredientsAdditionnels;
    private List<Supplement> supplements;

    public Repas(int id, PlatPrincipal platPrincipal, List<Ingredient> ingredientsAdditionnels, List<Supplement> supplements) {
        this.id = id;
        this.platPrincipal = platPrincipal;
        this.ingredientsAdditionnels = ingredientsAdditionnels;
        this.supplements = supplements;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlatPrincipal getPlatPrincipal() {
        return platPrincipal;
    }

    public void setPlatPrincipal(PlatPrincipal platPrincipal) {
        this.platPrincipal = platPrincipal;
    }

    public List<Ingredient> getIngredientsAdditionnels() {
        return ingredientsAdditionnels;
    }

    public void setIngredientsAdditionnels(List<Ingredient> ingredientsAdditionnels) {
        this.ingredientsAdditionnels = ingredientsAdditionnels;
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }

    public double calculerTotal() {
        double total = platPrincipal.calculerPrix();
        for (Ingredient ingredient : ingredientsAdditionnels) {
            total += ingredient.getPrixUnitaire();
        }
        for (Supplement supplement : supplements) {
            total += supplement.getPrix();
        }
        return total;
    }
}

