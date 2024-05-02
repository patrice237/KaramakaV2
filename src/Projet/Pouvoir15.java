package Projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Pouvoir15 implémente l'interface Strategie et représente une stratégie
 * spécifique pour le jeu de cartes Karmaka. Cette stratégie permet au joueur de
 * déposer une carte de son adversaire dans la fosse et de jouer une seconde fois.
 */
public class Pouvoir15 implements Strategie, Serializable {

    /**
     * La méthode jouerCarte permet au joueur d'utiliser la stratégie associée à cette classe.
     * Elle permet au joueur de déposer une carte de son adversaire dans la fosse et de jouer une seconde fois.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {

        // Retirer la carte jouée de la main du joueur et l'ajouter à la fosse
        Carte carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);

        // Déterminer l'adversaire suivant dans la liste des joueurs
        int i = Partie.listJ.indexOf(j);
        i = (i + 1) % Partie.listJ.size();
        Joueur j2 = Partie.listJ.get(i);

        // Récupérer la taille de la pile de l'adversaire
        int k = j2.getPile().size();

        // Vérifier s'il y a suffisamment de cartes dans la pile de l'adversaire
        if (k == 0) {
            System.out.println("Il n'y a pas assez de cartes dans la pile de votre adversaire.\n");
        } else {
            // Ajouter la dernière carte de la pile de l'adversaire à la fosse
            Partie.fosse.add(j2.getPile().get(k - 1));
            j2.getPile().remove(k - 1);
            System.out.println("Une carte a été ajoutée dans la main de votre adversaire.\n");
            System.out.println("Vous pouvez également jouer une seconde fois.\n");

            int t = 0;
            int choix = 1;
            Scanner scanner = new Scanner(System.in);
            System.out.println(j);

            // Gérer le choix de la carte à jouer pour la deuxième fois
            if (j.type == TypeJoueur.Réel) {
                t = Partie.lireNombreDansMenu("Choisir la carte que vous voulez jouer : \n", j, scanner);
            } else {
                // Génération d'un nombre aléatoire pour le joueur virtuel
                Random random = new Random();
                int min = 1;
                int max = j.getMain().size();

                if (max > 0) {
                    t = random.nextInt((max - min) + 1) + min;
                } else {
                    t = 1;
                    System.out.println("La liste est vide, impossible de générer un nombre aléatoire.");
                }
                System.out.println("Le joueur virtuel a déjà joué.");
            }

            choix = t;
            t = t - 1;

            ArrayList<String> menu1 = new ArrayList<String>();
            menu1.add("Jouer Pour le POUVOIR");
            menu1.add("Jouer Pour la VIE FUTURE ");
            menu1.add("Jouer Pour les POINTS");
            menu1.add("Annuler");
            System.out.println(j.getMain().get(t).caracteristique());

            // Gérer le choix de l'action à effectuer pour la deuxième fois
            if (j.type == TypeJoueur.Réel) {
                choix = Partie.lireNombreDansMenu("Que voulez-vous faire : \n", menu1, 1, 4, scanner);
            } else {
                
            	// Génération d'un nombre aléatoire pour le joueur virtuel
            	try {
                Random random = new Random();
                int min = 1;
                int max = 3;
                choix = random.nextInt((max - min) + 1) + min;
                Thread.sleep(2000);
            	}catch(Exception e) {
            		
            	}finally {
            		System.out.println("Le joueur virtuel a déjà joué.");
            	}
            }

            // Appliquer l'action en fonction du choix effectué pour la deuxième fois
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
}
