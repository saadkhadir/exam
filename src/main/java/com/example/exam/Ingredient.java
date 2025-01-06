package com.example.exam;

public class Ingredient {
    private int id_ingredient;
    private String nom;
    private double prixUnitaire;
    private double quantite;

    public Ingredient(int id_ingredient, String nom, double prixUnitaire,double quantite) {
        this.id_ingredient = id_ingredient;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;

    }

    public int getId() {
        return id_ingredient;
    }

    public void setId(int id) {
        this.id_ingredient = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    public double getQuantite() {return quantite;}
    public void setQuantite(double quantite) {this.quantite = quantite; }
}