package Projet;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Pouvoir17 implémente l'interface Strategie et représente une stratégie
 * spécifique pour le jeu de cartes Karmaka. Cette stratégie permet au joueur de
 * forcer son adversaire à défausser une carte de son œuvre.
 */
public class Pouvoir17 implements Strategie, Serializable {

    /**
     * La méthode jouerCarte permet au joueur d'utiliser la stratégie associée à cette classe.
     * Elle permet au joueur de forcer son adversaire à défausser une carte de son œuvre.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {

        // Déterminer l'adversaire suivant dans la liste des joueurs
        int i = Partie.listJ.indexOf(j);
        i = (i + 1) % Partie.listJ.size();
        Joueur j2 = Partie.listJ.get(i);
        Carte carte;

        // Récupérer la taille de l'œuvre de l'adversaire
        int k = j2.getOeuvre().size();

        if (k == 0) {
            System.out.println("Il n'y a pas assez de cartes dans l'œuvre de votre adversaire.\n");
        } else {

            System.out.println("Ce pouvoir donne la possibilité à votre adversaire de défausser une carte de son œuvre \n");
            System.out.println(j2.getNom() + " veuillez choisir une carte à défausser \n");
            System.out.println(Joueur.affichageArrayList(j2.getOeuvre()));

            Scanner scanner = new Scanner(System.in);
            System.out.println("Choisissez une carte \n");
            int t = 1;

            // Gérer le choix de la carte à défausser en fonction du type de joueur (Réel ou Virtuel)
            if (j.type == TypeJoueur.Réel) {
                t = Integer.parseInt(scanner.nextLine());
            } else {
                // Génération d'un nombre aléatoire pour le joueur virtuel
            	try {
                Random random = new Random();
                int min = 1;
                int max = j2.getOeuvre().size();
                t = random.nextInt((max - min) + 1) + min;
                Thread.sleep(2000);
            	}catch(Exception e) {}finally {
                System.out.println("Le joueur virtuel a déjà joué.");
            	}
            }

            // Ajouter la carte défaussée de l'œuvre de l'adversaire à la fosse
            Partie.fosse.add(j2.getOeuvre().get(t - 1));
            j2.getOeuvre().remove(t - 1);
        }

        // Retirer la carte jouée de la main du joueur et l'ajouter à la fosse
        carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);
    }
}
