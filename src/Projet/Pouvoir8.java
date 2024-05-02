package Projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe représentant le Pouvoir8 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir8 offre au joueur la possibilité de puiser une carte supplémentaire de la source après avoir joué la carte actuelle.
 */
public class Pouvoir8 implements Strategie, Serializable {

    /**
     * Méthode pour jouer la carte Pouvoir8.
     * Permet au joueur de puiser une carte supplémentaire de la source après avoir joué cette carte.
     * Offre également la possibilité de choisir une action supplémentaire avec la carte nouvellement piochée.
     *
     * @param j     Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir8 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        // Vérification si la main du joueur n'est pas vide avant de jouer
        if (!j.getMain().isEmpty()) {
            Carte carte = j.getMain().get(index);
            j.getMain().remove(index);
            Partie.fosse.add(carte);
        }

        System.out.println("Elle vous permet également de jouer une fois de plus.\n\n");

        // Piocher une nouvelle carte de la source et l'ajouter à la main du joueur
        j.setMain(Partie.tasCartes.poll());
        int t = 1;
        int choix;
        Scanner scanner = new Scanner(System.in);
        System.out.println(j);

        // Permettre au joueur de choisir une carte à jouer
        if (j.type == TypeJoueur.Réel) {
            t = Partie.lireNombreDansMenu("Choisir la carte que vous voulez jouer : \n", j, scanner);
        } else {
            // Choix aléatoire pour un joueur virtuel
        	try {
            Random random = new Random();
            int min = 1;
            int max = j.getMain().size();
            t = random.nextInt((max - min) + 1) + min;
            Thread.sleep(2000);
        	}catch(Exception e) {
        		System.out.println(e.getMessage());
        	}finally {
        		System.out.println("Le joueur virtuel a déjà joué");
        	}
        }
        choix = t - 1;

        // Présenter les options de jeu pour la carte choisie
        ArrayList<String> menu1 = new ArrayList<>();
        menu1.add("Jouer Pour le POUVOIR");
        menu1.add("Jouer Pour la VIE FUTURE ");
        menu1.add("Jouer Pour les POINTS");
        menu1.add("Annuler");
        System.out.println(j.getMain().get(choix).caracteristique());

        // Traitement du choix du joueur
        choix = Partie.lireNombreDansMenu("Que voulez-vous faire : \n", menu1, 1, 4, scanner);
        switch (choix) {
            case 1:
                Carte cart = j.getMain().get(choix);
                Strategie s = Partie.creerPouvoir(cart);
                j.setStrategie(s);
                j.getStrategie().jouerCarte(j, choix);
                break;
            case 2:
                Strategie p = new StrategieVieFuture();
                j.setStrategie(p);
                j.getStrategie().jouerCarte(j, choix);
                break;
            case 3:
                cart = j.getMain().get(choix);
                s = new StrategiePoint();
                j.setStrategie(s);
                StrategiePoint.incrementerNombreCouleur(j, cart);
                j.getStrategie().jouerCarte(j, choix);
                break;
        }
    }
}
