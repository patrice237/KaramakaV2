package Projet;

import java.io.Serializable;
import java.util.*;

/**
 * Représente un joueur dans le jeu de cartes Karmaka.
 * Gère les aspects variés d'un joueur, y compris sa main de cartes, sa pile de cartes, son œuvre, sa vie future,
 * ses jetons, son niveau karmique, sa stratégie de jeu, et ses points par couleur.
 */
public class Joueur implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nom;
    protected ArrayList<Carte> main;
    private ArrayList<Carte> pile;
    private ArrayList<Carte> oeuvre;
    private ArrayList<Carte> viefuture;
    private int Jeton;
    private NiveauKarmique niveau;
    private Strategie strategie;
    private HashMap<Couleur, Integer> Point;
    protected TypeJoueur type;

    /**
     * Constructeur pour créer un nouveau joueur.
     * Initialise les listes de cartes et d'autres attributs du joueur.
     * 
     * @param nom Le nom du joueur.
     * @param type Le type de joueur (humain ou IA).
     */
    public Joueur(String nom, TypeJoueur type) {
        this.nom = nom;
        this.type = type;
        main = new ArrayList<>();
        pile = new ArrayList<>();
        oeuvre = new ArrayList<>();
        viefuture = new ArrayList<>();
        this.strategie = new Pouvoir1();
        this.Jeton = 0;
        this.setNiveau(NiveauKarmique.Bousier_1);

        Point = new HashMap<>();
        Point.put(Couleur.bleu, 0);
        Point.put(Couleur.rouge, 0);
        Point.put(Couleur.vert, 0);
    }

    /**
     * Obtient les points du joueur classés par couleur.
     * 
     * @return Un HashMap des points du joueur par couleur.
     */
    public HashMap<Couleur, Integer> getPoint() {
        if (Point == null) {
            Point = new HashMap<>();
            Point.put(Couleur.bleu, 0);
            Point.put(Couleur.rouge, 0);
            Point.put(Couleur.vert, 0);
        }
        return Point;
    }

    /**
     * Définit les points du joueur par couleur.
     * 
     * @param point Un HashMap représentant les points à attribuer au joueur.
     */
    public void setPoint(HashMap<Couleur, Integer> point) {
        Point = point;
    }

    /**
     * Ajoute une carte à la main du joueur.
     * 
     * @param carte La carte à ajouter à la main.
     */
    public void ramasserCarteMain(Carte carte) {
        main.add(carte);
    }

    /**
     * Ajoute une carte à la pile du joueur.
     * 
     * @param carte La carte à ajouter à la pile.
     */
    public void ramasserCartePile(Carte carte) {
        pile.add(carte);
    }

    /**
     * Ajoute une carte à l'œuvre du joueur.
     * 
     * @param carte La carte à ajouter à l'œuvre.
     */
    public void DeposerCarteOeuvre(Carte carte) {
        oeuvre.add(carte);
    }

    /**
     * Ajoute une carte à la vie future du joueur.
     * 
     * @param carte La carte à ajouter à la vie future.
     */
    public void DeposerCarteViefuture(Carte carte) {
        viefuture.add(carte);
    }

    /**
     * Gère la réincarnation du joueur en réinitialisant certaines de ses propriétés.
     * Cette méthode est spécifique à la dynamique du jeu Karmaka.
     */
    public void seReincarner() {
        // Code de la méthode seReincarner
    }

    /**
     * Obtient le nom du joueur.
     * 
     * @return Le nom du joueur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Obtient la stratégie actuelle du joueur.
     * 
     * @return La stratégie du joueur.
     */
    public Strategie getStrategie() {
        return strategie;
    }

    /**
     * Définit la stratégie du joueur.
     * 
     * @param strategie La nouvelle stratégie à attribuer au joueur.
     */
    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    /**
     * Obtient la main actuelle du joueur.
     * 
     * @return La main de cartes du joueur.
     */
    public ArrayList<Carte> getMain() {
        return main;
    }

    /**
     * Ajoute une carte à la main du joueur.
     * 
     * @param c La carte à ajouter à la main.
     */
    public void setMain(Carte c) {
        this.main.add(c);
    }

    /**
     * Obtient la pile actuelle du joueur.
     * 
     * @return La pile de cartes du joueur.
     */
    public ArrayList<Carte> getPile() {
        return pile;
    }

    /**
     * Obtient l'œuvre actuelle du joueur.
     * 
     * @return L'œuvre de cartes du joueur.
     */
    public ArrayList<Carte> getOeuvre() {
        return oeuvre;
    }

    /**
     * Obtient la vie future actuelle du joueur.
     * 
     * @return La vie future de cartes du joueur.
     */
    public ArrayList<Carte> getViefuture() {
        return viefuture;
    }

    /**
     * Ajoute une carte à l'œuvre du joueur.
     * 
     * @param c La carte à ajouter à l'œuvre.
     */
    public void setOeuvre(Carte c) {
        this.oeuvre.add(c);
    }

    /**
     * Formate et affiche une liste de cartes ou d'autres éléments.
     * 
     * @param liste La liste à afficher.
     * @return Une représentation textuelle de la liste.
     */
    
    public static String affichageArrayList(ArrayList<?> liste) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < liste.size(); i++) {
            builder.append(i + 1).append("-").append(liste.get(i));
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Trouve la clé avec la valeur maximale dans une map.
     * 
     * @param map La map à parcourir.
     * @return La clé avec la valeur maximale.
     */
    private static Couleur findMaxValueKey(Map<Couleur, Integer> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Couleur maxKey = Couleur.bleu;
        int maxValue = 0;
        for (Map.Entry<Couleur, Integer> entry : map.entrySet()) {
            Couleur currentKey = entry.getKey();
            int currentValue = entry.getValue();
            if (currentValue > maxValue) {
                maxKey = currentKey;
                maxValue = currentValue;
            }
        }
        return maxKey;
    }

    /**
     * Renvoie une représentation textuelle de l'état actuel du joueur.
     * 
     * @return La chaîne de caractères représentant l'état du joueur.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n ******************************************* \n");
        sb.append(nom + " a " + main.size() + " cartes dans sa main et " + this.pile.size() + " dans sa pile" + "\t\t");
        sb.append("Niveau du Jeu: " + this.getNiveau() + "\t\t");
        sb.append("Nbre Jeton: " + this.Jeton + "\n");
        sb.append(affichageArrayList(main));
        sb.append("\nVous avez " + oeuvre.size() + " cartes dans votre oeuvre et Vous avez déjà " + this.getPoint().get(findMaxValueKey(this.Point)) + " Point(s) \n");
        sb.append(affichageArrayList(oeuvre));
        sb.append("\nVous avez " + viefuture.size() + " cartes dans votre viefuture \n");
        sb.append(affichageArrayList(viefuture));
        sb.append("\n ******************************************* \n");
        return sb.toString();
    }

    /**
     * Obtient le niveau karmique actuel du joueur.
     * 
     * @return Le niveau karmique du joueur.
     */
    public NiveauKarmique getNiveau() {
        return niveau;
    }

    /**
     * Définit le niveau karmique du joueur.
     * 
     * @param niveau Le niveau karmique à attribuer.
     * @return Le niveau karmique attribué.
     */
    public NiveauKarmique setNiveau(NiveauKarmique niveau) {
        this.niveau = niveau;
        return niveau;
    }

}
