package com.example.exam;

import java.time.LocalDateTime;
import java.util.List;

public class Commande {
    private int id_commande;
    private Client client;
    private List<Repas> repas;
    private LocalDateTime dateCommande;


    public Commande(int id_commande, Client client, List<Repas> repas, LocalDateTime dateCommande) {
        this.id_commande = id_commande;
        this.client = client;
        this.repas = repas;
        this.dateCommande = dateCommande;
    }


    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Repas> getRepas() {
        return repas;
    }

    public void setRepas(List<Repas> repas) {
        this.repas = repas;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }


    public double calculerTotalCommande() {
        double total = 0.0;
        for (Repas repasItem : repas) {
            total += repasItem.calculerTotal();
        }
        return total;
    }


    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        details.append("Commande ID: ").append(id_commande)
                .append("\nClient: ").append(client.getNom()).append(" ").append(client.getPrenom())
                .append("\nDate: ").append(dateCommande)
                .append("\nRepas:\n");

        for (Repas repasItem : repas) {
            details.append(" - ").append(repasItem.toString()).append("\n");
        }

        details.append("Total: ").append(calculerTotalCommande()).append("€");
        return details.toString();
    }
}
