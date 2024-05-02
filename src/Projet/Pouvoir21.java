package Projet;

import java.io.Serializable;

/**
 * La classe Pouvoir21 implémente l'interface Strategie et représente une stratégie
 * spécifique pour le jeu de cartes Karmaka. Cette stratégie permet au joueur de
 * défausser deux cartes de la main de son adversaire.
 */
public class Pouvoir21 implements Strategie, Serializable {

    /**
     * La méthode jouerCarte permet au joueur d'utiliser la stratégie associée à cette classe.
     * Elle permet au joueur de défausser deux cartes de la main de son adversaire.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {

        // Obtenir l'index du joueur suivant dans la liste des joueurs
        int i = Partie.listJ.indexOf(j);
        i = (i + 1) % Partie.listJ.size();
        Joueur j2 = Partie.listJ.get(i);
        Carte carte;

        // Obtenir le nombre de cartes dans la main de l'adversaire
        int k = j2.getMain().size();

        // Vérifier s'il y a au moins deux cartes dans la main de l'adversaire
        if (k >= 2) {

            // Défausser les deux dernières cartes de la main de l'adversaire
            Partie.fosse.add(j2.getMain().get(k - 1));
            j2.getMain().remove(k - 1);
            Partie.fosse.add(j2.getMain().get(k - 2));
            j2.getMain().remove(k - 2);
            System.out.println(" 2 cartes ont été défaussées dans la main de votre adversaire`\n");

        } else {

            System.out.println(" Il n'y a pas assez de cartes dans la main de votre adversaire`\n");
        }

        // Défausser la carte jouée de la main du joueur
        carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);
    }
}
