package Projet;

import java.io.Serializable;

/**
 * Classe représentant le Pouvoir7 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir7 permet au joueur de prendre la dernière carte de l'œuvre exposée d'un rival et de la placer dans sa main.
 */
public class Pouvoir7 implements Strategie, Serializable {

    /**
     * Méthode pour jouer la carte Pouvoir7.
     * Permet au joueur de prendre la dernière carte de l'œuvre exposée d'un rival et de l'ajouter à sa main.
     *
     * @param j     Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir7 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        // Identification du rival
        int i = Partie.listJ.indexOf(j);
        i = (i + 1) % Partie.listJ.size();
        Joueur rival = Partie.listJ.get(i);
        Carte carte;

        // Vérification si l'œuvre du rival contient des cartes
        if (rival.getOeuvre().isEmpty()) {
            System.out.println("Votre adversaire n'a aucune carte dans son œuvre, dommage.\n");
        } else {
            // Transférer la dernière carte de l'œuvre du rival à la main du joueur
            int derniereCarteIndex = rival.getOeuvre().size() - 1;
            carte = rival.getOeuvre().get(derniereCarteIndex);
            rival.getOeuvre().remove(derniereCarteIndex);
            j.setMain(carte);
            System.out.println("La carte a été ajoutée à votre main.\n");
        }

        // Retirer la carte Pouvoir7 jouée de la main du joueur et l'ajouter à la fosse
        Carte carteJouee = j.getMain().get(index);
        j.getMain().remove(index);
        
        try {
            // Met le thread actuel en pause pendant 2 secondes
            Thread.sleep(2000);
        } catch (Exception e) {
            // En cas d'interruption, affiche le message d'erreur
            System.out.println(e.getMessage());
        }
        
        Partie.fosse.add(carteJouee);
    }
}
