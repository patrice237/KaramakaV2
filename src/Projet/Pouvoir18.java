package Projet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * La classe Pouvoir18 implémente l'interface Strategie et représente une stratégie
 * spécifique pour le jeu de cartes Karmaka. Cette stratégie permet au joueur de
 * choisir de défausser des cartes de sa main et d'ajouter des cartes à sa main.
 */
public class Pouvoir18 implements Strategie, Serializable {

    // Scanner utilisé pour la saisie utilisateur
    Scanner scanner = new Scanner(System.in);

    // Variables pour le choix et le compteur
    int i, k, compteur = 0;

    /**
     * La méthode jouerCarte permet au joueur d'utiliser la stratégie associée à cette classe.
     * Elle permet au joueur de choisir de défausser des cartes de sa main et d'ajouter des cartes à sa main.
     *
     * @param j     Le joueur qui applique la stratégie.
     * @param index L'index de la carte à jouer dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {

        // Retirer la carte jouée de la main du joueur et l'ajouter à la fosse
        Carte carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);

        // Menu pour le choix de défausser une carte ou non
        ArrayList<String> menu1 = new ArrayList<String>();
        menu1.add("OUI");
        menu1.add("NON");

        // Boucle pour la première phase de défausse
        while (true) {

            // Gérer le choix de défausser une carte en fonction du type de joueur (Réel ou Virtuel)
            if (j.type == TypeJoueur.Réel) {
                i = Partie.lireNombreDansMenu("\n Voulez-vous défausser une carte ?  : \n", menu1, 1, 2, scanner);
            } else {
                // Génération d'un nombre aléatoire pour le joueur virtuel
                Random random = new Random();
                int min = 1;
                int max = 2;
                i = random.nextInt((max - min) + 1) + min;
                System.out.println("Le joueur virtuel a déjà joué.");
            }

            // Sortir de la boucle si le joueur choisit de ne pas défausser ou atteint la limite de défausse
            if (compteur == 2 || i == 2) {
                break;
            } else {
                // Incrémenter le compteur et demander au joueur de choisir la carte à défausser
                compteur++;
                System.out.println(j.getNom() + "  veuillez choisir la " + compteur + " carte que vous voulez défausser\n");
                System.out.println(Joueur.affichageArrayList(j.main));

                System.out.println("Choisissez une carte \n");
                int t;

                // Gérer le choix de la carte à défausser en fonction du type de joueur (Réel ou Virtuel)
                if (j.type == TypeJoueur.Réel) {
                    t = Integer.parseInt(scanner.nextLine());
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

                // Ajouter la carte défaussée de la main du joueur à la fosse
                if (!j.getMain().isEmpty()) {
                    Partie.fosse.add(j.getMain().get(t - 1));
                    j.getMain().remove(t - 1);
                }
            }
        }

        // Réinitialiser le compteur
        k = 0;
        compteur++;

        // Boucle pour la deuxième phase d'ajout de cartes à la main
        while (k < compteur) {

            // Gérer le choix d'ajouter une carte à la main en fonction du type de joueur (Réel ou Virtuel)
            if (j.type == TypeJoueur.Réel) {
                i = Partie.lireNombreDansMenu("\n Voulez-vous ajouter une carte à votre main ?  : \n", menu1, 1, 2, scanner);
            } else {
                // Génération d'un nombre aléatoire pour le joueur virtuel
                Random random = new Random();
                int min = 1;
                int max = 2;
                i = random.nextInt((max - min) + 1) + min;
                System.out.println("Le joueur virtuel a déjà joué.");
            }

            // Sortir de la boucle si le joueur choisit de ne pas ajouter de carte à sa main
            if (i == 2) {
                break;
            }

            // Ajouter une carte du tas de cartes à la main du joueur et afficher un message
            j.setMain(Partie.tasCartes.poll());
            System.out.print("La carte a été ajoutée \n");
            k++;
        }
    }
}
