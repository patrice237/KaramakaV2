package Projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe représentant le Pouvoir2 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir2 permet au joueur de voir la main de son adversaire et de jouer une carte supplémentaire.
 */
public class Pouvoir2 implements Strategie, Serializable {

    /**
     * Méthode pour jouer la carte Pouvoir2.
     * Permet au joueur d'inspecter la main de son adversaire et de jouer une autre carte de sa main.
     *
     * @param j Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir2 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        System.out.println("La carte vous permet de voir la main de votre adversaire`\n");
        
        // Identification de l'adversaire et affichage de sa main
        int i = Partie.listJ.indexOf(j);
        i = (i + 1) % Partie.listJ.size();
        Joueur j2 = Partie.listJ.get(i);
        System.out.println(Joueur.affichageArrayList(j2.getMain()));
        
        // Retire la carte jouée de la main et l'ajoute à la fosse
        Carte carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);
        
        System.out.println("Elle vous permet également de jouer une fois de plus \n\n");
        
        // Logique pour jouer une autre carte
        int t, choix;
        Scanner scanner = new Scanner(System.in);
        System.out.println(j);
        
        // Choix de la carte à jouer
        if (j.type == TypeJoueur.Réel) {
            t = Partie.lireNombreDansMenu("Choisir la carte vous voulez jouer : \n", j, scanner);
        } else {
            Random random = new Random();
            int min = 1, max = j.getMain().size();
            t = max > min ? random.nextInt((max - min) + 1) + min : 1;
            System.out.println("Le joueur virtuel a déjà joué");
        }
        choix = t - 1;
        
        ArrayList<String> menu1 = new ArrayList<>();
        menu1.add("Jouer Pour le POUVOIR");
        menu1.add("Jouer Pour la VIE FUTURE");
        menu1.add("Jouer Pour les POINTS");
        menu1.add("Annuler");
        System.out.println(j.getMain().get(choix).caracteristique());
        
        // Choix de l'action à effectuer avec la carte sélectionnée
        if (j.type == TypeJoueur.Réel) {
            choix = Partie.lireNombreDansMenu("Que voulez-vous faire : \n", menu1, 1, 4, scanner);
        } else {
            Random random = new Random();
            int min = 1, max = 3;
            choix = random.nextInt((max - min) + 1) + min;
            System.out.println("Le joueur virtuel a déjà joué");
        }
        
        // Exécution de l'action choisie
        switch (choix) {
            case 1:
                Carte cart = j.getMain().get(t);
                Strategie s = Partie.creerPouvoir(cart);
                j.setStrategie(s);
                j.getStrategie().jouerCarte(j, t);
                break;
            case 2:
                Strategie p = new StrategieVieFuture();
                j.setStrategie(p);
                j.getStrategie().jouerCarte(j, t);
                break;
            case 3:
                cart = j.getMain().get(t);
                s = new StrategiePoint();
                j.setStrategie(s);
                StrategiePoint.incrementerNombreCouleur(j, cart);
                j.getStrategie().jouerCarte(j, t);
                break;
        }
    }
}
