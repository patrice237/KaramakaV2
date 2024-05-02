package Projet;
import java.io.Serializable;
import java.util.*;

/**
 * Représente une carte avec divers attributs et capacités.
 * Cette classe fait partie du package Projet et implémente l'interface Serializable qui nous permet de sauvegarder les cartes du joueur.
 */
public class Carte implements Serializable{

    private Valeur valeur;
    private TypeC typeC;
    private String effet;
    private Couleur couleur;
    private Pouvoir pouvoir;

    /**
     * Constructeur pour créer une carte avec des attributs spécifiés.
     * 
     * @param typeC Le type de la carte exemple boursier, loup, serpent ......
     * @param valeur La valeur de la carte qui represente son nombre de points.
     * @param couleur La couleur de la carte.
     * @param pouvoir Le pouvoir de la carte ici chaque carte possede un pouvoir compris entre Pouvoir1 à Pouvoir23.
     * @param effet L'effet de la carte qui presente la description du pouvoir de la carte.
     */
    public Carte (TypeC typeC, Valeur valeur, Couleur couleur, Pouvoir pouvoir, String effet) {
        this.setValeur(valeur);
        this.settypeC(typeC);
        this.setCouleur(couleur);
        this.seteffet(effet);
        this.setPouvoir(pouvoir);
    }

    /**
     * le getter de la couleur de la carte
     * 
     * Récupère la couleur de la carte.
     * 
     * @return Couleur de la carte.
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Récupère le pouvoir de la carte.
     * 
     * @return Pouvoir de la carte.
     */
    public Pouvoir getPouvoir() {
        return pouvoir;
    }

    /**
     * Définit le pouvoir de la carte.
     * 
     * @param pouvoir Le pouvoir à définir pour la carte.
     */
    public void setPouvoir(Pouvoir pouvoir) {
        this.pouvoir = pouvoir;
    }

    /**
     * Définit la couleur de la carte.
     * 
     * @param couleur La couleur à définir pour la carte.
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Récupère le type de la carte.
     * 
     * @return Type de la carte.
     */
    public TypeC gettypeC() {
        return typeC;
    }

    /**
     * Définit le type de la carte.
     * 
     * @param typeC Le type à définir pour la carte.
     */
    public void settypeC(TypeC typeC) {
        this.typeC = typeC;
    }

    /**
     * Récupère l'effet de la carte.
     * 
     * @return Effet de la carte.
     */
    public String geteffet() {
        return effet;
    }

    /**
     * Définit l'effet de la carte.
     * 
     * @param effet L'effet à définir pour la carte.
     */
    public void seteffet(String effet) {
        this.effet = effet;
    }

    /**
     * Récupère la valeur de la carte.
     * 
     * @return Valeur de la carte.
     */
    public Valeur getValeur() {
        return valeur;
    }

    /**
     * Définit la valeur de la carte.
     * 
     * @param valeur La valeur à définir pour la carte.
     */
    public void setValeur(Valeur valeur) {
        this.valeur = valeur;
    }

    /**
     * Représentation sous forme de chaîne de caractères de la carte.
     * 
     * @return Chaîne de caractères décrivant la carte.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(this.typeC);
        sb.append(": ");
        sb.append(this.valeur);
        sb.append("\t ");
        sb.append("\n ");
        return sb.toString();
    }

    /**
     * Renvoie les caractéristiques de la carte sous forme de chaîne de caractères.
     * 
     * @return Chaîne de caractères détaillant les caractéristiques de la carte.
     */
    public String caracteristique() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n ******************************************* \n");
        sb.append("\n Vous voulez jouer la carte : " + this.typeC);
        sb.append("\n\t Nombre points : " + this.getValeur());
        sb.append("\n\t Couleur : " + this.getCouleur());
        sb.append("\n\t Son effet : " + this.geteffet());
        sb.append("\n ");
        return sb.toString();
    }
}
