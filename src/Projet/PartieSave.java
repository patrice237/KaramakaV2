package Projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Classe représentant l'état sauvegardé d'une partie du jeu Karmaka.
 * Cette classe permet la sauvegarde et la reprise de l'état actuel du jeu.
 * Elle implémente Serializable pour faciliter la sauvegarde et le chargement.
 */
public class PartieSave implements Serializable {
    private static final long serialVersionUID = 1L;

    private LinkedList<Carte> fosse;
    private ArrayList<Joueur> listJ;
    private LinkedList<Carte> tasCartes;
    private int indexjoueurcourant;
    private int tour;

    /**
     * Constructeur par défaut de la classe PartieSave.
     * Initialise les attributs avec des valeurs par défaut ou nulles.
     */
    public PartieSave() {
        this.fosse = new LinkedList<>();
        this.listJ = new ArrayList<>();
        this.tasCartes = new LinkedList<>();
        this.indexjoueurcourant = 0;
        this.tour = 1;
    }

    /**
     * Retourne la fosse, une collection de cartes défaussées.
     * @return La fosse sous forme de LinkedList<Carte>.
     */
    public LinkedList<Carte> getFosse() {
        return fosse;
    }

    /**
     * Définit la fosse, la collection de cartes défaussées.
     * @param fosse La nouvelle fosse à définir.
     */
    public void setFosse(LinkedList<Carte> fosse) {
        this.fosse = fosse;
    }

    /**
     * Retourne la liste des joueurs participant à la partie.
     * @return La liste des joueurs.
     */
    public ArrayList<Joueur> getListJ() {
        return listJ;
    }

    /**
     * Définit la liste des joueurs participant à la partie.
     * @param listJ La nouvelle liste de joueurs.
     */
    public void setListJ(ArrayList<Joueur> listJ) {
        this.listJ = listJ;
    }

    /**
     * Retourne le tas de cartes, la pile principale de cartes dans le jeu.
     * @return Le tas de cartes.
     */
    public LinkedList<Carte> getTasCartes() {
        return tasCartes;
    }

    /**
     * Définit le tas de cartes, la pile principale de cartes dans le jeu.
     * @param tasCartes Le nouveau tas de cartes.
     */
    public void setTasCartes(LinkedList<Carte> tasCartes) {
        this.tasCartes = tasCartes;
    }

    /**
     * Retourne l'index du joueur actuellement en train de jouer.
     * @return L'index du joueur courant.
     */
    public int getIndexjoueurcourant() {
        return indexjoueurcourant;
    }

    /**
     * Définit l'index du joueur actuellement en train de jouer.
     * @param indexjoueurcourant Le nouvel index du joueur courant.
     */
    public void setIndexjoueurcourant(int indexjoueurcourant) {
        this.indexjoueurcourant = indexjoueurcourant;
    }

    /**
     * Retourne le numéro du tour actuel dans la partie.
     * @return Le numéro du tour.
     */
    public int getTour() {
        return tour;
    }

    /**
     * Définit le numéro du tour actuel dans la partie.
     * @param tour Le nouveau numéro du tour.
     */
    public void setTour(int tour) {
        this.tour = tour;
    }
}
