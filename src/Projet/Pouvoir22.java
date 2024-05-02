package Projet;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Pouvoir22 implémente l'interface Strategie et représente une stratégie
 * spécifique pour le jeu de cartes Karmaka. Cette stratégie permet au joueur de
 * copier le pouvoir d'une carte de son oeuvre et de l'activer.
 */
public class Pouvoir22 implements Strategie, Serializable {

    // Ajout d'une variable de contrôle
    private boolean dejaJoue = false;

    /**
     * La méthode jouerCarte permet au joueur d'utiliser la stratégie associée à cette classe.
     * Elle permet au joueur de copier le pouvoir d'une carte de son oeuvre et de l'activer.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        Carte carte;

        // Retirer la carte jouée de la main du joueur et l'ajouter à la fosse
        if (!j.getMain().isEmpty()) {
            carte = j.getMain().get(index);
            j.getMain().remove(index);
            Partie.fosse.add(carte);
        }

        int k = j.getOeuvre().size();

        if (k == 1) {
            System.out.println("Vous avez joué le pouvoir de la carte " + j.getOeuvre().get(k - 1) + " \n");
            System.out.println("Son pouvoir est de : " + j.getOeuvre().get(k - 1).geteffet() + " \n");

            // Copier le pouvoir de la carte et l'activer
            carte = j.getOeuvre().get(k - 1);
            Strategie s = Partie.creerPouvoir(carte);
            j.setStrategie(s);

            // Ajout de la condition de sortie
            if (!dejaJoue) {
                dejaJoue = true;
                j.getStrategie().jouerCarte(j, k - 1);
            }

        } else if (k > 1) {
            System.out.println("Choisissez la carte de votre oeuvre dont vous souhaitez copier le pouvoir \n\n");
            Joueur.affichageArrayList(j.getOeuvre());
            Scanner scanner = new Scanner(System.in);

            int i;

            // Gérer le choix de la carte à copier en fonction du type de joueur (Réel ou Virtuel)
            if (j.type == TypeJoueur.Réel) {
                i = Integer.parseInt(scanner.nextLine());
            } else {
                // Génération d'un nombre aléatoire pour le joueur virtuel
                Random random = new Random();
                int min = 1;
                int max = j.getOeuvre().size();
                i = random.nextInt((max - min) + 1) + min;
                System.out.println("Le joueur virtuel a déjà joué");
            }

            // Copier le pouvoir de la carte choisie et l'activer
            carte = j.getOeuvre().get(i - 1);
            Strategie s = Partie.creerPouvoir(carte);
            j.setStrategie(s);

            // Ajout de la condition de sortie
            if (!dejaJoue) {
                dejaJoue = true;
                j.getStrategie().jouerCarte(j, i - 1);
            }

        } else {
            System.out.println("Il n'y a pas de carte dans votre oeuvre`\n");
        }
        
        try {
            // Met le thread actuel en pause pendant 2 secondes
            Thread.sleep(2000);
        } catch (Exception e) {
            // En cas d'interruption, affiche le message d'erreur
            System.out.println(e.getMessage());
        }
    }
}