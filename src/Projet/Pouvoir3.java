package Projet;
import java.io.Serializable;
import java.util.*;

/**
 * Classe représentant le Pouvoir3 dans le jeu Karmaka.
 * Cette classe implémente l'interface Strategie et est sérialisable.
 * Le Pouvoir3 permet au joueur de choisir deux cartes parmi les trois premières cartes de la source et de les placer dans sa Vie Future.
 */
public class Pouvoir3 implements Strategie, Serializable {
    
    /**
     * Méthode pour jouer la carte Pouvoir3.
     * Le joueur peut regarder les trois premières cartes de la source, choisir deux d'entre elles et les ajouter à sa Vie Future.
     * La troisième carte est remise dans la source.
     *
     * @param j Le joueur qui joue la carte.
     * @param index L'index de la carte Pouvoir3 dans la main du joueur.
     */
    public void jouerCarte(Joueur j, int index) {
        // Préparation de la liste des cartes à choisir
        ArrayList<Carte> list = new ArrayList<>();
        list.add(Partie.tasCartes.poll());
        list.add(Partie.tasCartes.poll());
        list.add(Partie.tasCartes.poll());
        
        // Affichage des cartes et choix des cartes à ajouter à la Vie Future
        System.out.println("Voici les 3 premières cartes dans la source, choisissez 2 cartes \n");
        System.out.println(Joueur.affichageArrayList(list));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez la première carte \n");
        int i = obtenirChoixCarte(j, list);
        j.DeposerCarteViefuture(list.get(i - 1));
        list.remove(i - 1);
        
        // Deuxième choix de carte
        System.out.println("Choisissez la seconde carte \n");
        System.out.println(Joueur.affichageArrayList(list));
        i = obtenirChoixCarte(j, list);
        j.DeposerCarteViefuture(list.get(i - 1));
        list.remove(i - 1);
        
        // Remettre la carte restante dans la source
        Partie.tasCartes.add(list.get(0));
        
        // Retirer la carte jouée de la main du joueur et l'ajouter à la fosse
        Carte carte = j.getMain().get(index);
        j.getMain().remove(index);
        Partie.fosse.add(carte);
    }

    /**
     * Méthode privée pour obtenir le choix de la carte du joueur.
     * Gère les choix des joueurs réels et virtuels.
     *
     * @param j Le joueur qui fait le choix.
     * @param list La liste des cartes parmi lesquelles choisir.
     * @return L'index de la carte choisie.
     */
    private int obtenirChoixCarte(Joueur j, ArrayList<Carte> list) {
        int i = 1;
        if (j.type == TypeJoueur.Réel) {
            Scanner scanner = new Scanner(System.in);
            i = Integer.parseInt(scanner.nextLine());
        } else {
        	try {
            Random random = new Random();
            int min = 1, max = list.size();
            i = random.nextInt((max - min) + 1) + min;
        	}catch(Exception e) {
        		System.out.println(e.getMessage());
        	}finally {
        		System.out.println("Le joueur virtuel a déjà joué");
        	}
        }
        return i;
    }
}
