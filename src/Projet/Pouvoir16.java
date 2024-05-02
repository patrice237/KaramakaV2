package Projet;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Pouvoir16 implémente l'interface Strategie et représente une stratégie
 * spécifique pour le jeu de cartes Karmaka. Cette stratégie permet au joueur de
 * forcer son adversaire à défausser une carte de sa main.
 */
public class Pouvoir16 implements Strategie, Serializable {

    /**
     * La méthode jouerCarte permet au joueur d'utiliser la stratégie associée à cette classe.
     * Elle permet au joueur de forcer son adversaire à défausser une carte de sa main.
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

        // Retirer la carte jouée de la main du joueur et l'ajouter à la fosse
        carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);

        System.out.println("Ce pouvoir donne la possibilité à votre adversaire de défausser une carte de sa main \n");
        System.out.println(j2.getNom() + " veuillez choisir une carte à défausser \n");
        System.out.println(Joueur.affichageArrayList(j2.main));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez une carte \n");
        int t = 1;

        // Gérer le choix de la carte à défausser en fonction du type de joueur (Réel ou Virtuel)
        if (j2.type == TypeJoueur.Réel) {
            t = Integer.parseInt(scanner.nextLine());
        } else {
            // Génération d'un nombre aléatoire pour le joueur virtuel
        	try {
            Random random = new Random();
            int min = 1;
            int max = j2.getMain().size();
            t = 1;
                t = random.nextInt((max - min) + 1) + min;
                Thread.sleep(2000);
        	}catch(Exception e) {}finally {
        		System.out.println("Le joueur virtuel a déjà joué.");
        	}
            
        }

        // Ajouter la carte défaussée de la main de l'adversaire à la fosse
        if (!j.getMain().isEmpty()) {
            Partie.fosse.add(j2.getMain().get(t - 1));
            j2.getMain().remove(t - 1);
        }
    }
}
