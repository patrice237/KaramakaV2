package Projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe représentant le Pouvoir5 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir5 permet au joueur de copier le pouvoir d'une carte de sa main.
 */
public class Pouvoir5 implements Strategie, Serializable {

    /**
     * Méthode pour jouer la carte Pouvoir5.
     * Le joueur choisit une carte de sa main et en copie le pouvoir pour l'appliquer immédiatement.
     *
     * @param j Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir5 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        // Retirer la carte jouée de la main et l'ajouter à la fosse
        Carte carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);
        
        // Demande au joueur de choisir une carte dont il souhaite copier le pouvoir
        System.out.println("Choisissez la carte dont vous souhaitez copier le pouvoir \n\n");
        Joueur.affichageArrayList(j.getMain());
        
        // Obtenir l'index de la carte choisie
        Scanner scanner = new Scanner(System.in);
        System.out.println(j);
        int i = obtenirChoixCarte(j);
        
        // Copier le pouvoir de la carte choisie et l'appliquer
        carte = j.getMain().get(i - 1);
        Strategie s = Partie.creerPouvoir(carte);
        j.setStrategie(s);
        j.getStrategie().jouerCarte(j, i - 1);
    }

    /**
     * Méthode privée pour obtenir le choix de la carte du joueur.
     * Gère les choix des joueurs réels et virtuels.
     *
     * @param j Le joueur qui fait le choix.
     * @return L'index de la carte choisie.
     */
    private int obtenirChoixCarte(Joueur j) {
        int i = 1;
        if (j.type == TypeJoueur.Réel) {
            Scanner scanner = new Scanner(System.in);
            i = Integer.parseInt(scanner.nextLine());
        } else {
        	try {
            Random random = new Random();
            int min = 1, max = j.getMain().size();
            i = random.nextInt((max - min) + 1) + min;
            Thread.sleep(2000);
        	}catch(Exception e) {
        		System.out.println(e.getMessage());
        	}finally {
        		System.out.println("Le joueur virtuel a déjà joué");
        	}
        }
        return i;
    }
}
