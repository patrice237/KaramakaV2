package Projet;

import java.io.Serializable;

/**
 * Classe représentant le Pouvoir4 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir4 permet au joueur de prendre la première carte de la Vie Future de son adversaire et de la placer dans sa propre Vie Future.
 */
public class Pouvoir4 implements Strategie, Serializable {

    /**
     * Méthode pour jouer la carte Pouvoir4.
     * Permet au joueur de transférer la première carte de la Vie Future de son adversaire direct dans sa propre Vie Future.
     * Si l'adversaire n'a pas de carte dans sa Vie Future, une notification est affichée.
     *
     * @param j Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir4 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        // Identification de l'adversaire
        int i = Partie.listJ.indexOf(j);
        i = (i + 1) % Partie.listJ.size();
        Joueur j2 = Partie.listJ.get(i);
        
        // Vérification de la présence de cartes dans la Vie Future de l'adversaire
        int b = j2.getViefuture().size();
        if (b == 0) {
            System.out.println("Votre adversaire n'a aucune carte dans sa vie future, dommage`\n");
        } else {
            // Transfert de la première carte de la Vie Future de l'adversaire
            Carte carte = j2.getViefuture().get(b - 1);
            j2.getViefuture().remove(b - 1);
            j.DeposerCarteViefuture(carte);
            System.out.println("La première carte de la vie future de votre adversaire est ajoutée à la vôtre`\n");
        }
        
        // Retrait de la carte jouée de la main et ajout à la fosse
        Carte carteJouee = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carteJouee);
    }
}
