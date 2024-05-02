package Projet;

import java.io.*;

/**
 * Classe utilitaire pour charger des parties sauvegardées.
 * Fournit des méthodes pour lire des objets PartieSave depuis des fichiers.
 */
public class Chargement {

    /**
     * Charge une partie sauvegardée à partir d'un fichier.
     * 
     * @param nomFichier Le nom du fichier contenant les données de la partie sauvegardée.
     * @return L'objet PartieSave lu depuis le fichier, ou null en cas d'erreur.
     */
    public static PartieSave chargerPartie(String nomFichier) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomFichier))) {
            PartieSave p = (PartieSave) ois.readObject();
            System.out.println("Partie chargée avec succès !");
            return p;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Point d'entrée principal pour tester le chargement d'une partie.
     * 
     * @param agrs Arguments passés au programme (non utilisés).
     */
    public static void main(String[] agrs) {
        Partie p = Partie.getInstance();
        PartieSave partiesave = Chargement.chargerPartie("save.dat");
        p.setEstTerminer(false);
        p.setListJ(partiesave.getListJ());
        p.setTasCartes(partiesave.getTasCartes());
        p.setFosse(partiesave.getFosse());

        System.out.print(p.listJ.get(0).toString());
        System.out.print(p.listJ.get(1).toString());
    }
}
