package Projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe représentant le Pouvoir10 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir10 permet au joueur de choisir une carte parmi les trois dernières de la fosse pour l'ajouter à sa main.
 */
public class Pouvoir10 implements Strategie, Serializable {

    /**
     * Joue la carte Pouvoir10.
     * Permet au joueur de choisir et d'ajouter une carte parmi les trois dernières de la fosse à sa main.
     * La fosse est une pile où les cartes jouées sont placées après utilisation.
     *
     * @param j     Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir10 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        Carte carte;
        int i = Partie.fosse.size();

        // Vérifier si la fosse contient au moins 3 cartes
        if (i < 3) {
            System.out.println("Il n'y a pas assez de carte dans la fosse.\n");
        } else {
            // Sélection des 3 dernières cartes de la fosse
            ArrayList<Carte> list = new ArrayList<>();
            list.add(Partie.fosse.get(i - 1));
            list.add(Partie.fosse.get(i - 2));
            list.add(Partie.fosse.get(i - 3));

            System.out.println("Voici les 3 dernières cartes de la fosse, choisissez 1 carte.\n");
            System.out.println(Joueur.affichageArrayList(list));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choisissez une carte.\n");
            int l = 1;
            if (j.type == TypeJoueur.Réel) {
                l = Integer.parseInt(scanner.nextLine());
            } else {
                // Choix aléatoire pour un joueur virtuel
            	try {
                Random random = new Random();
                int min = 1;
                int max = list.size();
                l = random.nextInt((max - min) + 1) + min;
                Thread.sleep(2000);
            	}catch(Exception e) {
            		System.out.println(e.getMessage());
            	}finally {
            		System.out.println("Le joueur virtuel a déjà joué");
            	}
                
            }
            // Ajouter la carte choisie à la main du joueur
            j.setMain(list.get(l - 1));
            Partie.fosse.remove(i - l);
        }
        // Retirer la carte Pouvoir10 de la main du joueur et l'ajouter à la fosse
        carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);
    }
}

