package com.example.exam;

public class Client {
   private int id_client;
   private String nom;
   private String prenom;
   private String email;
   private String telephone;

   public Client(int id_client, String nom, String prenom, String email, String telephone) {
       this.id_client = id_client;
       this.nom = nom;
       this.prenom = prenom;
       this.email = email;
       this.telephone = telephone;
   }
   public Client() {}
   public int getId_client() {return id_client;}
    public String getNom() {return nom;}
    public String getPrenom() {return prenom;}
    public String getEmail() {return email;}
    public String getTelephone() {return telephone;}

    public void setId_client(int id_client) {this.id_client = id_client;}
    public void setNom(String nom) {this.nom = nom;}
    public void setPrenom(String prenom) {this.prenom = prenom;}
    public void setEmail(String email) {this.email = email;}
    public void setTelephone(String telephone) {this.telephone = telephone;}
}
