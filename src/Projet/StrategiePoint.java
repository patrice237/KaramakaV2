package Projet;

import java.io.Serializable;

/**
 * La classe {@code StrategiePoint} représente une stratégie basée sur des points associés aux couleurs des cartes.
 * Elle implémente l'interface {@code Strategie} et est sérialisable.
 */
public class StrategiePoint implements Strategie, Serializable {

    private static Couleur multi_color;

    /**
     * Cette méthode permet au joueur d'appliquer la stratégie en jouant une carte.
     * Elle dépose la carte dans l'oeuvre du joueur, puis appelle la méthode {@code incrementerNombreCouleur}.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        Carte c = j.getMain().get(index);
        j.DeposerCarteOeuvre(c);
        j.getMain().remove(index);

        try {
        	Thread.sleep(2000);
        }catch(Exception e) {
        	
        }
    }

    /**
     * Incrémente le nombre associé à la couleur de la carte dans la map des points du joueur.
     * Si la couleur de la carte est multi_color, elle incrémente le nombre associé à chaque couleur.
     *
     * @param j     Le joueur dont les points sont mis à jour.
     * @param carte La carte jouée.
     */
    public static void incrementerNombreCouleur(Joueur j, Carte carte) {
        if (carte != null && carte.getCouleur() != null) {
            Couleur couleurCarte = carte.getCouleur();

            // Vérifier si la couleur existe déjà dans la map
            if (couleurCarte == Couleur.multi_color) {
                j.getPoint().put(Couleur.bleu, j.getPoint().get(Couleur.bleu) + 1);
                j.getPoint().put(Couleur.vert, j.getPoint().get(Couleur.vert) + 1);
                j.getPoint().put(Couleur.rouge, j.getPoint().get(Couleur.rouge) + 1);
            }

            if (j.getPoint().containsKey(couleurCarte)) {
                int i = j.getPoint().get(couleurCarte);
                // Si la couleur existe, incrémenter le nombre associé
                j.getPoint().put(couleurCarte, i + carte.getValeur().ordinal() + 1);

                System.out.println("OK pour l'incrémentation");
            }
        }
    }

    /**
     * Décrémente le nombre associé à la couleur de la carte dans la map des points du joueur.
     *
     * @param j     Le joueur dont les points sont mis à jour.
     * @param carte La carte jouée.
     */
    public static void decrementerNombreCouleur(Joueur j, Carte carte) {
        if (carte != null && carte.getCouleur() != null) {
            Couleur couleurCarte = carte.getCouleur();
            int i = j.getPoint().get(couleurCarte);

            // Vérifier si la couleur existe déjà dans la map
            if (j.getPoint().containsKey(couleurCarte)) {
                // Si la couleur existe, décrémenter le nombre associé
                j.getPoint().put(couleurCarte, i - carte.getValeur().ordinal());
                System.out.println("OK pour la décrémentation");
            }
        }
    }
}
