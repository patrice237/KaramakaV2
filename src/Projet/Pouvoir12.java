package Projet;

import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe représentant le Pouvoir12 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir12 permet au joueur de tirer deux cartes de la source et de les placer dans sa Vie Future.
 */
public class Pouvoir12 implements Strategie, Serializable {

    /**
     * Joue la carte Pouvoir12.
     * Permet au joueur de tirer deux cartes de la source (tas de cartes principal), puis de choisir deux cartes
     * de sa main pour les placer dans sa Vie Future.
     *
     * @param j     Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir12 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        // Retirer la carte Pouvoir12 de la main du joueur et l'ajouter à la fosse
        if (!j.getMain().isEmpty()) {
            Carte carte = j.getMain().get(index);
            j.getMain().remove(index);
            Partie.fosse.add(carte);
        }

        // Tirer deux cartes de la source et les ajouter à la main du joueur
        j.setMain(Partie.tasCartes.poll());
        j.setMain(Partie.tasCartes.poll());

        // Demander au joueur de choisir deux cartes de sa main à placer dans sa Vie Future
        System.out.println("Voici les cartes qui se trouvent dans votre main, choisissez 2 cartes à placer dans votre Vie Future :");
        System.out.println(Joueur.affichageArrayList(j.main));
        Scanner scanner = new Scanner(System.in);
        int choix;
        for (int i = 0; i < 2; i++) {
            System.out.println("Choisissez la carte " + (i + 1) + " :");
            if (j.type == TypeJoueur.Réel) {
                choix = Integer.parseInt(scanner.nextLine());
            } else {
                // Choix aléatoire pour un joueur virtuel
                Random random = new Random();
                choix = random.nextInt(j.main.size()) + 1;
                System.out.println("Le joueur virtuel a choisi la carte " + choix);
            }
            j.DeposerCarteViefuture(j.getMain().get(choix - 1));
            j.getMain().remove(choix - 1);
            
            try {
            	Thread.sleep(2000);
            }catch(Exception e) {
            	System.out.println(e.getMessage());
            }
            
        }
    }
}
