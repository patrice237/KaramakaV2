package Projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Pouvoir13 implémente l'interface Strategie et représente une stratégie
 * spécifique pour le jeu de cartes Karmaka. Cette stratégie permet au joueur de
 * tirer trois cartes supplémentaires dans sa main et de choisir comment jouer l'une d'entre elles.
 */
public class Pouvoir13 implements Strategie, Serializable {

    /**
     * La méthode jouerCarte permet au joueur d'utiliser la stratégie associée à cette classe.
     * Elle permet au joueur de tirer trois cartes supplémentaires dans sa main et de choisir comment jouer l'une d'entre elles.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        
        // Ajouter trois cartes à la main du joueur depuis le tas de cartes
        j.setMain(Partie.tasCartes.poll());
        j.setMain(Partie.tasCartes.poll());
        j.setMain(Partie.tasCartes.poll());

        System.out.println("3 cartes ont été ajoutées à votre main.\n\n");

        int t = 0;
        int choix = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println(j);

        // Gérer le choix de la carte à jouer en fonction du type de joueur (Réel ou Virtuel)
        if (j.type == TypeJoueur.Réel) {
            t = Partie.lireNombreDansMenu("Choisir la carte que vous voulez jouer : \n", j, scanner);
        } else {
            // Génération d'un nombre aléatoire pour le joueur virtuel
            Random random = new Random();
            int min = 1;
            int max = j.getMain().size();
            t = random.nextInt((max - min) + 1) + min;
            System.out.println("Le joueur virtuel a déjà joué.");
        }

        // Mettre à jour le choix
        choix = t;
        t = t - 1;

        // Afficher les options disponibles pour jouer la carte sélectionnée
        ArrayList<String> menu1 = new ArrayList<String>();
        menu1.add("Jouer Pour le POUVOIR");
        menu1.add("Jouer Pour la VIE FUTURE ");
        menu1.add("Jouer Pour les POINTS");
        menu1.add("Annuler");
        System.out.println(j.getMain().get(t).caracteristique());

        // Gérer le choix de l'action à effectuer en fonction du type de joueur (Réel ou Virtuel)
        if (j.type == TypeJoueur.Réel) {
            choix = Partie.lireNombreDansMenu("Que voulez-vous faire : \n", menu1, 1, 4, scanner);
        } else {
        	try {
            // Génération d'un nombre aléatoire pour le joueur virtuel
            Random random = new Random();
            int min = 1;
            int max = 3;
            choix = random.nextInt((max - min) + 1) + min;
        	}catch(Exception e) {
        		System.out.println(e.getMessage());
        	}finally {
        		System.out.println("Le joueur virtuel a déjà joué");
        	}
        }

        // Appliquer l'action en fonction du choix effectué
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

        // Retirer la carte jouée de la main du joueur et l'ajouter à la fosse
        Carte carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);
    }
}
