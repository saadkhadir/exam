package com.example.exam;

public class Supplement {
    private int id_supplement;
    private String nom;
    private double prix;

    public Supplement(int id, String nom, double prix) {
        this.id_supplement = id;
        this.nom = nom;
        this.prix = prix;
    }

    public int getId() {
        return id_supplement;
    }

    public void setId(int id) {
        this.id_supplement = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
