package Projet;

/**
 * L'interface Strategie définit la méthode jouerCarte, qui représente la stratégie pour jouer une carte.
 */
public interface Strategie {

    /**
     * La méthode jouerCarte est implémentée par les classes qui veulent définir une stratégie pour jouer une carte.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    void jouerCarte(Joueur j, int index);
}
