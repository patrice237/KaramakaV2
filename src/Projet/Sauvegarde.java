package Projet;

import java.io.*;

/**
 * La classe Sauvegarde fournit une méthode pour sauvegarder une partie en utilisant la sérialisation d'objets.
 */
public class Sauvegarde {

    /**
     * Sauvegarde une instance de la classe PartieSave dans un fichier spécifié.
     *
     * @param p           L'instance de PartieSave à sauvegarder qui va stoker tous les attributs de la partie.
     * @param nomFichier  Le nom du fichier dans lequel sauvegarder la partie.
     */
    public static void sauvegarderPartie(PartieSave p, String nomFichier) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomFichier))) {
            oos.writeObject(p);
            System.out.println("Partie sauvegardée avec succès !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
