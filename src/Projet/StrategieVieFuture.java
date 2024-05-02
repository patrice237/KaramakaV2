package Projet;

import java.io.Serializable;

/**
 * La classe {@code StrategieVieFuture} représente une stratégie où le joueur dépose une carte dans sa vie future.
 * Elle implémente l'interface {@code Strategie} et est sérialisable.
 */
public class StrategieVieFuture implements Strategie, Serializable {

    /**
     * Joue la carte du joueur en la déposant dans sa vie future.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        Carte c = j.getMain().get(index);
        j.DeposerCarteViefuture(c);
        j.getMain().remove(index);
    }
}
