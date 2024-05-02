package Projet;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Pouvoir14 implémente l'interface Strategie et représente une stratégie
 * spécifique pour le jeu de cartes Karmaka. Cette stratégie permet au joueur de
 * choisir deux cartes de sa main et de les déposer dans son œuvre.
 */
public class Pouvoir14 implements Strategie, Serializable {

    /**
     * La méthode jouerCarte permet au joueur d'utiliser la stratégie associée à cette classe.
     * Elle permet au joueur de choisir deux cartes de sa main et de les déposer dans son œuvre.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {

        // Retirer la carte jouée de la main du joueur et l'ajouter à la fosse
        Carte carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);

        System.out.println("Voici les cartes qui se trouvent dans votre main, choisissez 2 cartes à déposer dans l'œuvre \n");
        System.out.println(Joueur.affichageArrayList(j.main));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez la première carte \n");
        int i = 1;

        // Gérer le choix de la première carte en fonction du type de joueur (Réel ou Virtuel)
        if (j.type == TypeJoueur.Réel) {
            i = Integer.parseInt(scanner.nextLine());
        } else {
            // Génération d'un nombre aléatoire pour le joueur virtuel
        	try {
            Random random = new Random();
            int min = 1;
            int max = j.getMain().size();
            i = random.nextInt((max - min) + 1) + min;
        	}catch(Exception e) {
        		System.out.println(e.getMessage());
        	}finally {
        		System.out.println("Le joueur virtuel a déjà joué");
        	}
        }

        // Mettre à jour l'œuvre du joueur avec la première carte choisie
        j.setOeuvre(j.getMain().get(i - 1));
        j.getMain().remove(i - 1);
        System.out.println(Joueur.affichageArrayList(j.main));
        System.out.println("Choisissez la seconde carte \n");

        // Gérer le choix de la seconde carte en fonction du type de joueur (Réel ou Virtuel)
        if (j.type == TypeJoueur.Réel) {
            i = Integer.parseInt(scanner.nextLine());
        } else {
            // Génération d'un nombre aléatoire pour le joueur virtuel
            Random random = new Random();
            int min = 1;
            int max = j.getMain().size();

            if (max > 0) {
                i = random.nextInt((max - min) + 1) + min;
            } else {
                System.out.println("La liste est vide, impossible de générer un nombre aléatoire.");
            }
            System.out.println("Le joueur virtuel a déjà joué.");
        }

        // Mettre à jour l'œuvre du joueur avec la seconde carte choisie si la main n'est pas vide
        if (!j.getMain().isEmpty()) {
            j.setOeuvre(j.getMain().get(i - 1));
            j.getMain().remove(i - 1);
        }
    }
}

