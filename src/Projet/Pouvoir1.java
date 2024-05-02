package Projet;
import java.io.Serializable;
import java.util.*;

/**
 * Classe représentant le Pouvoir1 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et Serializable,
 * définissant l'action spécifique du Pouvoir1 lorsqu'il est joué par un joueur.
 */
public class Pouvoir1 implements Strategie, Serializable {
    /**
     * Méthode pour jouer la carte Pouvoir1.
     * Permet au joueur de choisir une carte de sa Vie Future et de l'ajouter à sa main.
     *
     * @param j Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir1 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        Scanner scanner = new Scanner(System.in);
        Carte carte;
        int nombre = 1;
        
        // Vérifie si le joueur a des cartes dans sa Vie Future
        if (j.getViefuture().isEmpty()) {
            System.out.println("\n\n Vous n'avez aucune carte dans votre vie future, dommage \n\n");
        } else {
            // Permet au joueur de choisir une carte de sa Vie Future
            System.out.println("\n\n Choisissez une carte dans votre vie future : \n\n");
            System.out.println(Joueur.affichageArrayList(j.getViefuture()));
            
            // Choix de la carte pour les joueurs réels et virtuels
            if (j.type == TypeJoueur.Réel) {
                nombre = Integer.parseInt(scanner.nextLine());
            } else {
            	try {
                Random random = new Random();
                int min = 1;
                int max = j.getViefuture().size();
                nombre = random.nextInt((max - min) + 1) + min;
            	}catch(Exception e) {
            		System.out.print(e.getMessage());
            	}finally {
                System.out.println("Le joueur virtuel a déjà joué");
            	}
            }
            
            // Ajoute la carte choisie à la main du joueur
            carte = j.getViefuture().get(nombre - 1);
            j.getViefuture().remove(nombre - 1);
            j.setMain(carte);
            System.out.println("\n La carte a été ajoutée \n");
        }
        
        // Ajoute la carte jouée à la fosse et la retire de la main du joueur
        Partie.fosse.add(j.getMain().get(index));
        j.getMain().remove(index);  
    }
}
