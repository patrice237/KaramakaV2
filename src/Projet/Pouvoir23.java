package Projet;

import java.io.Serializable;

/**
 * La classe Pouvoir23 implémente l'interface Strategie et représente une stratégie
 * spécifique pour le jeu de cartes Karmaka. Cette stratégie permet au joueur
 * d'utiliser le pouvoir de la dernière carte de l'oeuvre de son adversaire.
 */
public class Pouvoir23 implements Strategie, Serializable {

    /**
     * La méthode jouerCarte permet au joueur d'utiliser la stratégie associée à cette classe.
     * Elle permet au joueur de jouer le pouvoir de la dernière carte de l'oeuvre de son adversaire.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        int i = Partie.listJ.indexOf(j);
        i = (i + 1) % Partie.listJ.size();
        Joueur j2 = Partie.listJ.get(i);
        Carte carte;

        // Retirer la carte jouée de la main du joueur et l'ajouter à la fosse
        if (!j.getMain().isEmpty()) {
            carte = j.getMain().get(index);
            j.getMain().remove(index);
            Partie.fosse.add(carte);
        }

        int k = j2.getOeuvre().size();

        if (k > 0) {
            System.out.println("Vous avez joué le pouvoir de la carte " + j2.getOeuvre().get(k - 1) + "\n");
            System.out.println("Son pouvoir est de : " + j2.getOeuvre().get(k - 1).geteffet() + " \n");

            // Vérification si la liste n'est pas vide
            if (k - 1 < j2.getOeuvre().size()) {
                carte = j2.getOeuvre().get(k - 1);
                Strategie s = Partie.creerPouvoir(carte);
                j.setStrategie(s);
                j.getStrategie().jouerCarte(j, k - 1);
            } else {
                System.out.println("Il n'y a pas de carte dans l'oeuvre de l'adversaire\n");
            }
        } else {
            System.out.println("Il n'y a pas de carte dans l'oeuvre de l'adversaire\n");
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