package Projet;

import java.io.Serializable;

/**
 * Classe représentant le Pouvoir11 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir11 permet au joueur d'ajouter deux cartes à la pile de son adversaire.
 */
public class Pouvoir11 implements Strategie, Serializable {

    /**
     * Joue la carte Pouvoir11.
     * Permet au joueur d'ajouter deux cartes du tas de cartes à la pile de son adversaire direct.
     * Les cartes ajoutées proviennent du tas principal de cartes du jeu.
     *
     * @param j     Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir11 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        // Trouver l'adversaire direct du joueur
        int i = Partie.listJ.indexOf(j);
        i = (i + 1) % Partie.listJ.size();
        Joueur j2 = Partie.listJ.get(i);

        // Ajouter deux cartes du tas principal à la pile de l'adversaire
        j2.getPile().add(Partie.tasCartes.poll());
        j2.getPile().add(Partie.tasCartes.poll());
        System.out.println("Deux cartes ont été ajoutées dans la pile de votre adversaire.");

        // Retirer la carte Pouvoir11 de la main du joueur et l'ajouter à la fosse
        Carte carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);
        try {
        	Thread.sleep(2000);
        }catch(Exception e) {
        	System.out.println(e.getMessage());
        }
        
    }
}
