package com.example.exam;

import java.util.ArrayList;
import java.util.List;

public class Repas {
    private int id;
    private String nom;
    private PlatPrincipal platPrincipal;
    private List<Ingredient> ingredients;
    private List<Supplement> supplements;


    public Repas(String s) {
        this.nom = s;
        this.id=0;
        this.ingredients = new ArrayList<>(); // Initialisation des listes
        this.supplements = new ArrayList<>();
    }

    public Repas(int i, String s, PlatPrincipal plat2, ArrayList<Object> objects, ArrayList<Object> objects1) {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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


    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }
    public double calculerTotal() {
        double total = platPrincipal.calculerPrix();

        for (Ingredient ingredient : ingredients) {
            total += ingredient.getPrixUnitaire() * ingredient.getQuantite();
        }

        for (Supplement supplement : supplements) {
            total += supplement.getPrix();
        }

        return total;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Repas ID: ").append(id).append(", Nom: ").append(nom).append("\n")
                .append("Plat Principal: ").append(platPrincipal.getNom()).append(" - Prix: ").append(platPrincipal.getPrix()).append("€\n")
                .append("Ingrédients Additionnels:\n");
        for (Ingredient ingredient : ingredients) {
            sb.append("  - ").append(ingredient.getNom())
                    .append(" (").append(ingredient.getQuantite()).append(" unités à ")
                    .append(ingredient.getPrixUnitaire()).append("€ chacune)\n");
        }
        sb.append("Suppléments:\n");
        for (Supplement supplement : supplements) {
            sb.append("  - ").append(supplement.getNom()).append(" - Prix: ").append(supplement.getPrix()).append("€\n");
        }
        sb.append("Prix Total du Repas: ").append(calculerTotal()).append("€\n");
        return sb.toString();
    }
    public void ajouterIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }


    public void ajouterSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

}

