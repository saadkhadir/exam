package com.example.exam;

public class PlatPrincipal {
    private int id_plat;
    private String nom;
    private float prix;

    public PlatPrincipal(int id_plat, String nom, float prix) {
        this.id_plat = id_plat;
        this.nom = nom;
        this.prix = prix;
    }
    public PlatPrincipal(String pasta, float v) {}
    public int getId_plat() {
        return id_plat;
    }
    public void setId_plat(int id_plat) {this.id_plat=id_plat;}
    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom=nom;}
    public float getPrix() {return prix;}
    public void setPrix(float prix) {this.prix=prix;}

    public double calculerPrix() {return prix;}

    @Override
    public String toString() {
        return "PlatPrincipal{" +
                "id_plat=" + id_plat +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}

