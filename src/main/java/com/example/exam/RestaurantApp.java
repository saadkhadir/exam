package com.example.exam;

import java.util.ArrayList;
import java.util.List;

public class RestaurantApp {
    public static void main(String[] args) {

        Client client = new Client(1, "SAAD", "Restau", "saadresto@example.com", "0123456789");


        List<Repas> repasList = new ArrayList<>();
        Repas repas1 = new Repas("Pastille de poules et olives");
        repas1.ajouterIngredient(new Ingredient(1,"Pastille", 250, 0));
        repas1.ajouterIngredient(new Ingredient(2,"olives", 1, 0));
        repas1.ajouterSupplement(new Supplement(1, "Frites", 11.0));
        repas1.ajouterSupplement(new Supplement(2, "Boisson", 12.0));

        Repas repas2 = new Repas("Tajine de poulet & légumes");
        repas2.ajouterIngredient(new Ingredient(3,"Poisson", 250, 0));
        repas2.ajouterIngredient(new Ingredient(4,"Carotte", 1, 0));
        repas2.ajouterIngredient(new Ingredient(5,"Pomme de terre", 1, 0));
        repas2.ajouterIngredient(new Ingredient(6   ,"Olive", 1, 0));
        repas2.ajouterSupplement(new Supplement(3, "Jus d'orange", 13.0));
        repas2.ajouterSupplement(new Supplement(4, "Salade marocaine", 14.0));

        repasList.add(repas1);
        repasList.add(repas2);


        afficherTicket(client, repasList);
    }

    private static void afficherTicket(Client client, List<Repas> repasList) {
        System.out.println("--------TICKET--------");
        System.out.println("Bienvenue Espace Saad");
        System.out.println("----------------------");
        System.out.println("Nom: " + client.getNom() + " " + client.getPrenom());
        System.out.println();

        System.out.println("Nombre de repas: " + repasList.size());
        double totalPrix = 0;

        for (int i = 0; i < repasList.size(); i++) {
            Repas repas = repasList.get(i);
            System.out.println("Repas N°" + (i + 1) + ": " + repas.getNom());
            System.out.println("Ingrédients:");
            for (Ingredient ingredient : repas.getIngredients()) {
                System.out.println(ingredient.getNom() + ": " + ingredient.getQuantite() + " gramme(s)");
            }
            System.out.println("Suppléments:");
            for (Supplement supplement : repas.getSupplements()) {
                System.out.println(supplement.getNom() + ": " + supplement.getPrix());
                totalPrix += supplement.getPrix();
            }
            System.out.println("********");
        }

        System.out.printf("--------Total: %.2f--------\n", totalPrix);
    }
}

