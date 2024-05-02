package Projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe représentant le Pouvoir6 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir6 permet au joueur de regarder la main d'un rival et d'ajouter une de ses cartes à sa propre main.
 */
public class Pouvoir6 implements Strategie, Serializable {

    /**
     * Méthode pour jouer la carte Pouvoir6.
     * Permet au joueur d'observer les cartes dans la main du rival et d'en choisir une à ajouter à sa propre main.
     *
     * @param j Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir6 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        // Identification du rival
        int i = Partie.listJ.indexOf(j);
        i = (i + 1) % Partie.listJ.size();
        Joueur rival = Partie.listJ.get(i);
        
        ArrayList<Carte> list = new ArrayList<>();
        int tailleMainRival = rival.getMain().size();

        // Gestion des différents cas selon le nombre de cartes dans la main du rival
        switch (tailleMainRival) {
            case 0:
                System.out.println("Votre adversaire n'a aucune carte dans sa main, dommage.\n");
                break;
            case 1:
                transfererCarte(j, rival, tailleMainRival - 1);
                break;
            default:
                // Présentation des cartes disponibles et choix du joueur
                for (int k = Math.max(0, tailleMainRival - 3); k < tailleMainRival; k++) {
                    list.add(rival.getMain().get(k));
                }
                System.out.println("Voici les cartes disponibles chez votre rival, choisissez-en une:\n");
                System.out.println(Joueur.affichageArrayList(list));
                int choix = obtenirChoixCarte(j, list.size());
                transfererCarte(j, rival, choix - 1);
                break;
        }

        // Retirer la carte Pouvoir6 jouée de la main du joueur et l'ajouter à la fosse
        Carte carteJouee = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carteJouee);
    }

    /**
     * Méthode privée pour transférer une carte de la main du rival à celle du joueur.
     *
     * @param joueur Le joueur qui reçoit la carte.
     * @param rival  Le joueur rival dont la carte est transférée.
     * @param index  L'index de la carte à transférer.
     */
    private void transfererCarte(Joueur joueur, Joueur rival, int index) {
        Carte carte = rival.getMain().get(index);
        rival.getMain().remove(index);
        joueur.setMain(carte);
    }

    /**
     * Méthode privée pour obtenir le choix de la carte du joueur.
     * Gère les choix des joueurs réels et virtuels.
     *
     * @param j    Le joueur qui fait le choix.
     * @param size La taille de la liste des cartes à choisir.
     * @return L'index de la carte choisie.
     */
    private int obtenirChoixCarte(Joueur j, int size) {
        int choix = 1;
        if (j.type == TypeJoueur.Réel) {
            Scanner scanner = new Scanner(System.in);
            choix = Integer.parseInt(scanner.nextLine());
        } else {
        	try {
            Random random = new Random();
            int min = 1, max = size;
            choix = random.nextInt((max - min) + 1) + min;
            Thread.sleep(2000);
        	}catch(Exception e) {
        		System.out.println(e.getMessage());
        	}finally {
        		System.out.println("Le joueur virtuel a déjà joué");
        	}
        	
        }
        return choix;
    }
}
