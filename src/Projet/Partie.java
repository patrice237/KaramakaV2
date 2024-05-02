package Projet;

import java.io.*;
import java.util.*;

/**
 * Représente la partie de notre jeu de Cartes avec divers attributs et capacités.
 * C'est la classe principale de notre jeu de cartes
 * Cette classe fait partie du package Projet et implémente l'interface Serializable qui nous permet de sauvegarder l'etat de la partie à un instant t.
 */


public class Partie  implements Serializable {
	

	// attributs d'une Partie
	

	private static final long serialVersionUID =1L;
	private static Partie instance;
	public static LinkedList<Carte> fosse= new LinkedList<Carte>();
	public static ArrayList<Joueur> listJ;
	public static LinkedList<Carte> tasCartes;
	private boolean estTerminer;

	//private int Jeton=24;
	
    /**
     * Constructeur pour créer une partie avec des attributs spécifiés.
     * Ce constructeur est privé parceque nous avons à faire à un singleton, la partie est unique
     * La partie commence par creer les joueurs ensuite toutes les cartes de notre jeu et ajoute toutes ces cartes dans notre tas de cartes qui represente notre source
     * 
     */
	private Partie() {
		listJ=new ArrayList<Joueur>();
		this.estTerminer=false;		
		tasCartes = new LinkedList<Carte>();
		
		Carte c1=new Carte(TypeC.voyage,Valeur.trois,Couleur.vert,Pouvoir.Pouvoir13,"Puisez 3 cartes à la Source Vous pouvez ensuite jouer une autre carte.");
		Carte c2=new Carte(TypeC.panique,Valeur.un,Couleur.rouge,Pouvoir.Pouvoir15,"Défaussez la première carte de la Pile d'un joueur Vous pouvez ensuite jouer une autre carte.");
		Carte c3=new Carte(TypeC.Transmigration,Valeur.un,Couleur.bleu,Pouvoir.Pouvoir1,"Placez dans votre Main n’importequelle carte de votre Vie Future.");
		Carte c4=new Carte(TypeC.Rêves_Brisés,Valeur.deux,Couleur.bleu,Pouvoir.Pouvoir4,"Placez la première carte de la Vie Future d'un rival sur la vôtre");
		Carte c5=new Carte(TypeC.Vol,Valeur.trois,Couleur.bleu,Pouvoir.Pouvoir7,"Placez dans votre Main l’Oeuvre Exposée d'un rival.");
		Carte c6=new Carte(TypeC.Sauvetage,Valeur.deux,Couleur.vert,Pouvoir.Pouvoir10,"Ajoutez à votre Main une des3 dernières cartes de la Fosse");
		Carte c7=new Carte(TypeC.Coup_Oeil,Valeur.un,Couleur.bleu,Pouvoir.Pouvoir2,"Regardez la Main d’un rival.Vous pouvez ensuite jouer une autre carte.");
		Carte c8=new Carte(TypeC.Déni,Valeur.deux,Couleur.bleu,Pouvoir.Pouvoir5,"Défaussez une carte de votre Main.Copiez le pouvoir de cette carte.");
		Carte c9=new Carte(TypeC.Lendemain,Valeur.un,Couleur.bleu,Pouvoir.Pouvoir8,"Puisez une carte à la Source.Vous pouvez ensuite jouer une autre carte.");
		Carte c10=new Carte(TypeC.Longévité,Valeur.deux,Couleur.vert,Pouvoir.Pouvoir11,"Placez 2 cartes puisées à la Source sur la Pile d'un joueur.");
		Carte c11=new Carte(TypeC.Destinée,Valeur.deux,Couleur.bleu,Pouvoir.Pouvoir3,"Regardez les 3 premières cartes de la Source; ajoutez-en jusqu’à 2 à votre Vie Future. Replacez le reste dans l'ordre souhaité.");
		Carte c12=new Carte(TypeC.Duperie,Valeur.trois,Couleur.bleu,Pouvoir.Pouvoir6,"Regardez 3 cartes de la Main d’un rival ; ajoutez-en une à votre Main.");
		Carte c13=new Carte(TypeC.Recyclage,Valeur.un,Couleur.vert,Pouvoir.Pouvoir9,"Ajoutez à votre Vie Future une des 3 dernières cartes de la Fosse.");
		Carte c14=new Carte(TypeC.Semis,Valeur.deux,Couleur.vert,Pouvoir.Pouvoir12,"Puisez 2 cartes à la Source, puis placez sur votre Vie Future 2 cartes de votre Main.");
		Carte c15=new Carte(TypeC.jubilé,Valeur.trois,Couleur.vert,Pouvoir.Pouvoir14,"Placez jusqu’à 2 cartes de votre Main sur vos Oeuvres.");
		Carte c16=new Carte(TypeC.DernierSouffle,Valeur.un,Couleur.rouge,Pouvoir.Pouvoir16,"Le joueur de votre choix défausse une carte de sa Main.");
		Carte c17=new Carte(TypeC.Crise,Valeur.deux,Couleur.rouge,Pouvoir.Pouvoir17,"Le rival de votre choix défausse une de ses Oeuvres.");
		Carte c18=new Carte(TypeC.Roulette,Valeur.deux,Couleur.rouge,Pouvoir.Pouvoir18,"Défaussez jusqu’à 2 cartes de votre Main. Vous pouvez ensuite puiser à la Source autant de carte(s) + 1.");
		Carte c19=new Carte(TypeC.Fournaise,Valeur.deux,Couleur.rouge,Pouvoir.Pouvoir19,"Défaussez les 2 premières cartes de la Vie Future d'un rival");
		Carte c20=new Carte(TypeC.Vengeance,Valeur.trois,Couleur.rouge,Pouvoir.Pouvoir20,"Défaussez l’Oeuvre Exposée d’un rival.");
		Carte c21=new Carte(TypeC.Bassesse,Valeur.trois,Couleur.rouge,Pouvoir.Pouvoir21,"Défaussez au hasard 2 cartes de la Main d’un rival.");
		Carte c22=new Carte(TypeC.Incarnation,Valeur.un,Couleur.multi_color,Pouvoir.Pouvoir22,"Choisissez une de vos Oeuvres.Copiez son pouvoir");
		Carte c23=new Carte(TypeC.Mimétisme,Valeur.un,Couleur.multi_color,Pouvoir.Pouvoir23,"Choisissez un Rival.Copiez le pouvoir de son Oeuvre Exposée");
		
		
		
		tasCartes.add(c1);tasCartes.add(c1);tasCartes.add(c1);
		tasCartes.add(c2);tasCartes.add(c2);tasCartes.add(c2);
		tasCartes.add(c3);tasCartes.add(c3);tasCartes.add(c3);
		tasCartes.add(c4);tasCartes.add(c4);tasCartes.add(c4);
		tasCartes.add(c5);tasCartes.add(c5);
		tasCartes.add(c6);tasCartes.add(c6);tasCartes.add(c6);
		tasCartes.add(c7);tasCartes.add(c7);tasCartes.add(c7);
		tasCartes.add(c8);tasCartes.add(c8);tasCartes.add(c8);
		tasCartes.add(c9);tasCartes.add(c9);tasCartes.add(c9);
		tasCartes.add(c10);tasCartes.add(c10);tasCartes.add(c10);
		tasCartes.add(c11);tasCartes.add(c11);tasCartes.add(c11);
		tasCartes.add(c12);tasCartes.add(c12);
		tasCartes.add(c13);tasCartes.add(c13);tasCartes.add(c13);
		tasCartes.add(c14);tasCartes.add(c14);tasCartes.add(c14);
		tasCartes.add(c15);tasCartes.add(c15);
		tasCartes.add(c16);tasCartes.add(c16);tasCartes.add(c16);
		tasCartes.add(c17);tasCartes.add(c17);tasCartes.add(c17);
		tasCartes.add(c18);tasCartes.add(c18);tasCartes.add(c18);
		tasCartes.add(c19);tasCartes.add(c19);tasCartes.add(c19);
		tasCartes.add(c20);tasCartes.add(c20);
		tasCartes.add(c21);tasCartes.add(c21);
		tasCartes.add(c22);tasCartes.add(c22);tasCartes.add(c22);tasCartes.add(c22);tasCartes.add(c22);
		tasCartes.add(c23);tasCartes.add(c23);

		

	} 
	
	/**
	 * Obtient l'instance unique de la classe Partie.
	 * Suivant le modèle Singleton, cette méthode s'assure qu'il existe une seule instance de Partie.
	 * Si l'instance n'existe pas encore, elle est créée et retournée. Si elle existe déjà, l'instance existante est retournée.
	 * 
	 * @return L'instance unique de la classe Partie.
	 */
	
	public static Partie getInstance() {
        if (instance == null) {
            instance = new Partie();
        }
        return instance;
    }
	
	
	/**
	 * Accède à la liste des cartes dans la fosse.
	 * La fosse est une collection de cartes qui ont été jouées ou écartées durant la partie.
	 * Cette méthode permet d'obtenir la liste actuelle des cartes dans la fosse.
	 *
	 *elle est static parceque on a besoin d'acceder à la fosse partout dans le code
	 *
	 * @return La liste des cartes actuellement dans la fosse.
	 */
	
	public static LinkedList<Carte> getFosse() {
		return fosse;
	}
	
	
	/**
	 * Définit la liste des cartes dans la fosse.
	 * La fosse est une collection de cartes qui ont été jouées ou écartées durant la partie.
	 * Cette méthode permet de définir ou de mettre à jour la liste des cartes dans la fosse.
	 *
	 * @param fosse La liste des cartes à définir comme étant dans la fosse.
	 */
	
	public static void setFosse(LinkedList<Carte> fosse) {
		Partie.fosse = fosse;
	}

	/**
	 * Définit le tas de cartes pour la partie.
	 * Le tas de cartes représente l'ensemble des cartes disponibles pour être jouées durant la partie.
	 * Cette méthode permet de définir ou de mettre à jour le tas de cartes.
	 *
	 * @param tasCartes La liste des cartes à définir pour le tas de cartes.
	 */
	
	public static void setTasCartes(LinkedList<Carte> tasCartes) {
		Partie.tasCartes = tasCartes;
	}
	
	/**
	 * Vérifie si la partie est terminée.
	 * Cette méthode renvoie l'état actuel de la partie, indiquant si elle est terminée ou non.
	 * 
	 * @return true si la partie est terminée, false sinon.
	 */


	public boolean isEstTerminer() {
		return estTerminer;
	}
	
	/**
	 * Crée une stratégie correspondant au pouvoir spécifié d'une carte.
	 * Cette méthode utilise un switch sur l'énumération des différents pouvoirs de carte pour instancier
	 * la stratégie appropriée.
	 *
	 * @param c La carte dont le pouvoir est utilisé pour déterminer la stratégie à créer.
	 * @return Une instance de la classe Strategie correspondant au pouvoir de la carte.
	 *         Retourne une instance de Pouvoir1 par défaut si le pouvoir n'est pas reconnu.
	 */
	
	public static Strategie creerPouvoir(Carte c) {
		
		switch (c.getPouvoir()) {
		
		case Pouvoir1:
			return new Pouvoir1();
		case Pouvoir2:
			return new Pouvoir2();
		case Pouvoir3:
			return new Pouvoir3();
		case Pouvoir4:
			return new Pouvoir4();
		case Pouvoir5:
			return new Pouvoir5();
		case Pouvoir6:
			return new Pouvoir6();
		case Pouvoir7:
			return new Pouvoir7();
		case Pouvoir8:
			return new Pouvoir8();
		case Pouvoir9:
			return new Pouvoir9();
		case Pouvoir10:
			return new Pouvoir10();
		case Pouvoir11:
			return new Pouvoir11();
		case Pouvoir12:
			return new Pouvoir12();
		case Pouvoir13:
			return new Pouvoir13();
		case Pouvoir14:
			return new Pouvoir14();
		case Pouvoir15:
			return new Pouvoir15();
		case Pouvoir16:
			return new Pouvoir16();
		case Pouvoir17:
			return new Pouvoir17();
		case Pouvoir18:
			return new Pouvoir18();
		case Pouvoir19:
			return new Pouvoir19();
		case Pouvoir20:
			return new Pouvoir20();
		case Pouvoir21:
			return new Pouvoir21();
		case Pouvoir22:
			return new Pouvoir22();
		case Pouvoir23:
			return new Pouvoir23();
		default:
			return new Pouvoir1();
		
		}
		
	}
	
	/**
	 * Définit l'état de la partie, indiquant si elle est terminée.
	 * Cette méthode permet de changer l'état de la partie pour indiquer si elle est arrivée à son terme.
	 *
	 * @param estTerminer L'état à définir pour la partie. True si la partie est terminée, false sinon.
	 */

	public void setEstTerminer(boolean estTerminer) {
		this.estTerminer = estTerminer;
	} 
	
	/**
	 * Obtient la liste des joueurs participant à la partie.
	 * Cette méthode permet d'accéder à la liste actuelle des joueurs inscrits dans la partie,
	 * offrant un moyen de parcourir, de consulter ou d'interagir avec les joueurs.
	 *
	 * @return La liste des joueurs dans la partie.
	 */
	
	public ArrayList<Joueur> getListJ() {
		return listJ;
	}

	/**
	 * Définit ou met à jour la liste des joueurs de la partie.
	 * Cette méthode permet de changer la liste des joueurs qui participent à la partie.
	 * Elle peut être utilisée pour initialiser la liste des joueurs au début de la partie
	 * ou pour la mettre à jour en cours de jeu.
	 *
	 * @param listJ La nouvelle liste des joueurs à définir pour la partie.
	 */
	
	public void setListJ(ArrayList<Joueur> listJ) {
	    this.listJ = listJ;
	}
	
	/**
	 * Distribue la carte du haut du tas de cartes.
	 * Cette méthode retire et renvoie la carte située en haut du tas de cartes.
	 * Elle est typiquement utilisée pour donner une carte à un joueur au début du jeu
	 * ou à chaque tour de jeu.
	 *
	 * @return La carte située en haut du tas de cartes, ou null si le tas est vide.
	 */

	public Carte distribuerUneCarte(){
		return tasCartes.poll();
	}
	
	/**
	 * Sélectionne aléatoirement un joueur parmi la liste des 2 joueurs.
	 * Cette méthode génère un index aléatoire correspondant à l'un des joueurs dans la liste,
	 * permettant de sélectionner un joueur de manière aléatoire.
	 *
	 * @return L'index du joueur sélectionné aléatoirement dans la liste des joueurs.
	 */
	
	public int randomJoueur() {
		Random random=new Random();
		int index= random.nextInt(listJ.size());
		return index;
	} 

	/**
	 * Mélange le tas de cartes de la partie.
	 * Cette méthode utilise la fonction shuffle de la classe Collections pour mélanger aléatoirement
	 * les cartes dans le tas de cartes. Elle est essentielle pour assurer l'équité et l'élément aléatoire
	 * dans la distribution des cartes.
	 */
	
	public void melanger(){
		Collections.shuffle(tasCartes);
	}
	
	/**
	 * Vérifie si le tas de cartes est vide.
	 * Cette méthode est utile pour déterminer si le tas de cartes a été entièrement distribué
	 * ou s'il reste encore des cartes à jouer.
	 *
	 * @return true si le tas de cartes est vide, false s'il contient encore des cartes.
	 */
	
	public boolean estVide() {
		return tasCartes.isEmpty();
	}
	
	/**
	 * Fournit une représentation textuelle du tas de cartes.
	 * Cette méthode est utile pour afficher l'état actuel du tas de cartes sous forme de chaîne de caractères,
	 * ce qui peut aider au débogage ou simplement pour afficher les cartes restantes dans le tas.
	 *
	 * @return La représentation textuelle du tas de cartes.
	 */
	
	public String toString(){
		return tasCartes.toString();
	}
	
	/**
	 * Obtient le tas de cartes de la partie.
	 * Cette méthode permet d'accéder au tas de cartes actuel, qui contient toutes les cartes
	 * pas encore distribuées ou jouées dans la partie.
	 *
	 * @return Le tas de cartes actuel de la partie.
	 */
		
	public LinkedList<Carte> getTasCartes(){
		return tasCartes;
	}
	
	/**
	 * Ajoute un joueur à la partie.
	 * Cette méthode permet d'inscrire un nouveau joueur dans la partie en l'ajoutant à la liste des joueurs.
	 * Elle est typiquement utilisée lors de l'initialisation de la partie pour ajouter tous les joueurs avant de commencer.
	 *
	 * @param joueur Le joueur à ajouter à la partie.
	 */
	
	public void ajouterUnJoueur(Joueur joueur){
		listJ.add(joueur);
	}
	
	/**
	 * Lit un nombre entier entré par l'utilisateur qui doit être dans un intervalle spécifié.
	 * Cette méthode affiche un message et une liste d'options, puis demande à l'utilisateur d'entrer un nombre.
	 * Elle vérifie que le nombre entré est dans l'intervalle spécifié entre valeurMin et valeurMax.
	 * Si le nombre n'est pas valide, elle demande à l'utilisateur de réessayer.
	 *
	 * @param message Le message à afficher à l'utilisateur.
	 * @param liste La liste des options parmi lesquelles l'utilisateur doit choisir.
	 * @param valeurMin La valeur minimale acceptable pour le nombre entré.
	 * @param valeurMax La valeur maximale acceptable pour le nombre entré.
	 * @param scanner L'objet Scanner utilisé pour lire l'entrée de l'utilisateur.
	 * @return Le nombre entier validé entré par l'utilisateur.
	 */
	
	
	// Methode pour lire un nombre dans un interval
	
	public static int lireNombreDansMenu(String message, ArrayList<?> liste, int valeurMin, int valeurMax, Scanner scanner) {
		int nombre;
		
		while(true) {
			
			try {
			
			System.out.println(message);
			System.out.println(Joueur.affichageArrayList(liste));
			nombre=Integer.parseInt(scanner.nextLine());
			
			if(nombre<valeurMin || nombre>valeurMax) {
				
			throw new IllegalArgumentException("Entrez un nombre parmi les choix possibles");
				
			}
			// Sort une fois que le nombre est valide 
			break;
			}catch(IllegalArgumentException e) {
				
				System.out.println("Erreur : " + "Enterz un entier parmi les choix possibles");
			}
			
		}
		
		return nombre;	
		
	}
	
	/**
	 * Lit un nombre entier entré par l'utilisateur correspondant à une sélection de carte dans la main d'un joueur.
	 * Cette méthode affiche un message personnalisé, puis demande à l'utilisateur d'entrer un nombre.
	 * Elle vérifie que le nombre entré est valide et se situe entre 1 et le nombre de cartes dans la main du joueur.
	 * Si le nombre n'est pas valide, elle demande à l'utilisateur de réessayer.
	 *
	 * @param message Le message à afficher à l'utilisateur.
	 * @param j Le joueur dont la main est utilisée pour déterminer les choix valides.
	 * @param scanner L'objet Scanner utilisé pour lire l'entrée de l'utilisateur.
	 * @return Le nombre entier validé entré par l'utilisateur, correspondant à un choix de carte.
	 */
	
	public static int lireNombreDansMenu(String message, Joueur j, Scanner scanner) {
		int nombre;
		
		while(true) {
			
			try {
				
			
			//System.out.println(j);
			System.out.println(message);
			System.out.println("\n");
			nombre=Integer.parseInt(scanner.nextLine());
			
			if(nombre<1 || nombre>j.getMain().size()) {
				
			throw new IllegalArgumentException("Entrez un nombre parmi les choix possibles");
				
			}
			// Sort une fois que le nombre est valide 
			break;
			}catch(IllegalArgumentException e) {
				
				System.out.println("Erreur : " + "Enterz un entier parmi les choix possibles");
			}
			
		}
		
		return nombre;
		
		
	}

	
	/**
	 * Distribue les cartes aux joueurs au début de la partie.
	 * Cette méthode mélange d'abord le tas de cartes, puis distribue les cartes aux 2  joueurs.
	 * Chaque joueur reçoit un nombre spécifique de cartes dans sa main et dans sa pile.
	 * La distribution se fait jusqu'à ce que le nombre requis de cartes soit distribué ou que le tas soit vide.
	 *
	 */
	
	
	public void distribuerCartes(){
		melanger();
		int i=0;
		while (estVide() == false){
			Iterator<Joueur> it =listJ.iterator();
						
			while(it.hasNext()){
					if(i<=3){
					Carte carte1 = distribuerUneCarte();
					if(carte1 == null) {
					break;
					}
					it.next().ramasserCarteMain(carte1);
				}
				if(i>3){
					Carte carte2 = distribuerUneCarte();
					if(carte2 == null) {
					break;
					}
					it.next().ramasserCartePile(carte2);
				}
				
			}
			i=i+1;
			 if(i==6) {
				 break;
			 }
			
			}
		}
	
	/**
	 * Point d'entrée principal pour le jeu de cartes Karmaka.
	 * Cette méthode initialise la partie, gère les interactions avec les joueurs, et contrôle le déroulement du jeu.
	 * 
	 * Le déroulement est le suivant :
	 * 1. Initialisation : Crée une nouvelle partie ou charge une partie existante.
	 * 2. Préparation : Ajoute des joueurs (réels ou virtuels) et distribue les cartes.
	 * 3. Boucle de jeu : Gère les tours des joueurs jusqu'à ce que la partie se termine.
	 * 
	 * La boucle de jeu fonctionne comme suit :
	 * a. Vérifie si la partie est terminée. Si non, le jeu continue.
	 * b. Pour chaque tour, le joueur courant est déterminé et a la possibilité de jouer.
	 * c. Les choix des joueurs sont gérés via des menus interactifs.
	 * d. Le jeu vérifie les conditions de victoire après chaque tour.
	 * 
	 * La méthode utilise plusieurs boucles while :
	 * - La première boucle while (!bataille.estTerminer) continue tant que la partie n'est pas terminée.
	 *   Elle permet de passer d'un tour à l'autre, en vérifiant à chaque fois si la partie doit se terminer.
	 * - Les boucles while internes gèrent les interactions spécifiques, comme la sélection des cartes à jouer.
	 *   Elles continuent jusqu'à ce qu'une entrée valide soit obtenue de la part du joueur.
	 * 
	 * @param args Arguments du programme (non utilisés).
	 * @throws InterruptedException Si une interruption se produit durant les pauses (si implémentées).
	 */
	
	public static void main(String[] args) throws InterruptedException {
	    // Initialisation de la partie
	    Partie bataille = getInstance();
	    PartieSave partiesave = new PartieSave();
	    int indexPremierJ;
	    int tour = 1;
	    int compteurPouvoir = 0;
	    Scanner srv = new Scanner(System.in);
	    
	    // Menu principal pour démarrer une nouvelle partie ou charger une partie sauvegardée
	    ArrayList<String> menu0 = new ArrayList<>();
	    menu0.add("NOUVEAU JEU");
	    menu0.add("RECHARGER ANCIENNE PARTIE");
	    System.out.println("\t\t BIENVENUE AU JEU DE CARTE KARMAKA \n\n\n");
	    int vr = lireNombreDansMenu("\n Que voulez-vous faire ?  : \n", menu0, 1, 2, srv);
	    
	    // Chargement d'une partie sauvegardée
	    if (vr == 2) {
	        partiesave = Chargement.chargerPartie("save.dat");
	        bataille.setEstTerminer(false);
	        bataille.setListJ(partiesave.getListJ());
	        bataille.setTasCartes(partiesave.getTasCartes());
	        bataille.setFosse(partiesave.getFosse());
	        indexPremierJ = partiesave.getIndexjoueurcourant();
	        tour = partiesave.getTour();
	    } else {
	        // Création de nouveaux joueurs pour une nouvelle partie
	        menu0.clear();
	        menu0.add("Reel");
	        menu0.add("Virtuel");
	        System.out.println("Donner votre nom  :   ");
	        String nom1 = srv.nextLine();
	        Joueur Karadoc = new Joueur(nom1, TypeJoueur.Réel);
	        Joueur Perceval;
	        String nom2;
	        vr = lireNombreDansMenu("\n Voulez-vous jouer avec un joueur Reel ou Virtuel ?  : \n", menu0, 1, 2, srv);
	        
	        if (vr == 1) {
	            System.out.println("\n\n Donner le nom du joueur 2  :   ");
	            srv = new Scanner(System.in);
	            nom2 = srv.nextLine();
	            Perceval = new Joueur(nom2, TypeJoueur.Réel);
	        } else {
	            nom2 = "BOT";
	            Perceval = new Joueur(nom2, TypeJoueur.Virtuel);
	        }
	        
	        // Ajout des joueurs à la partie et distribution des cartes
	        bataille.ajouterUnJoueur(Karadoc);
	        bataille.ajouterUnJoueur(Perceval);
	        bataille.distribuerCartes();
	        indexPremierJ = bataille.randomJoueur();
	    }
	    
	    // Début de la partie
	    boolean renaitre = false;
	    System.out.println("\t\t\t\t\t La partie a commencé ");
	    
	    // Boucle principale du jeu
	    while (!bataille.estTerminer) {
	        // Logique du tour de jeu
	        renaitre = false;
	        System.out.println("\t\t\t\t\t Tour " + tour);
	        Joueur joueurCourant = bataille.getListJ().get(indexPremierJ);
	        Scanner scanner = new Scanner(System.in);
	        
	        // Interaction avec le joueur courant et gestion de ses actions
		
				
		//Si le joueur precedent à joueur pour le pouvoir demande au joueur courant si il veut la carte
		if(compteurPouvoir!=0 ) {
			
			int j=0;
			ArrayList<String> menu1=new ArrayList<String>();
			menu1.add("OUI");
			menu1.add("NON");
			System.out.println(joueurCourant.getNom());
				if(joueurCourant.type==TypeJoueur.Réel) {
				j= lireNombreDansMenu("\n Voulez vous la carte du joueur precedent ?  : \n", menu1, 1, 2, scanner);
				}else {		
					
					try {
						//debut random
						Random random = new Random();
				        // Génération d'un nombre aléatoire dans l'intervalle [min, max]
				        int min = 1;
				        int max = 2;
				         j = random.nextInt((max - min) + 1) + min;
				         //fin random
				         System.out.println("Le joueur virtuel a deja jouer");
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
			
	       switch(j) {
			
			case 1:
				joueurCourant.DeposerCarteViefuture(Partie.fosse.poll());
				compteurPouvoir=0;
				break;
			case 2:
				compteurPouvoir=0;
				break;
			
			}
			
		}
		
		if(joueurCourant.main.isEmpty() && joueurCourant.getPile().isEmpty()) {
			
			joueurCourant.seReincarner();
			renaitre=true;	
		
		}
		
		if(renaitre==false) {
			
		System.out.println(bataille.listJ.get(indexPremierJ));
		
	
		
		//Les Variables qui permettents de sauvegarder les choix du Joueur
		int t=0;
		int choix=1;
		
		
		
		if(joueurCourant.getPile().isEmpty()==false) {
			
			ArrayList<String> menu=new ArrayList<String>();
			menu.add("Jouer");
			menu.add("Passer");
			menu.add("Sauvegarder");
			if(joueurCourant.type==TypeJoueur.Réel) {
				choix= lireNombreDansMenu("Que voulez vous faire : \n", menu, 1, 3, scanner);
						
			}else {		
						//debut random
						Random random = new Random();
				        // Génération d'un nombre aléatoire dans l'intervalle [min, max]
				        int min = 1;
				        int max = 2;
				         choix = random.nextInt((max - min) + 1) + min;
				         //fin random
				         System.out.println("Le joueur virtuel a deja jouer");
				}
			
			
			if(choix==1) {
				int j=joueurCourant.getPile().size()-1;
				joueurCourant.setMain(joueurCourant.getPile().get(j));
				joueurCourant.getPile().remove(j);
			}
			
		}else if(joueurCourant.type==TypeJoueur.Réel) {
			 ArrayList<String> menu=new ArrayList<String>();
			 menu.add("Jouer");
			 menu.add("Sauvegarde");
			 choix= lireNombreDansMenu("Que voulez vous faire : \n", menu, 1, 2, scanner);
			 if(choix==2) { 

				 partiesave.setListJ(listJ);
				 partiesave.setTasCartes(tasCartes);
				 partiesave.setIndexjoueurcourant(indexPremierJ);
				 partiesave.setTour(tour);
				 Sauvegarde.sauvegarderPartie(partiesave, "save.dat");break;}
		}
		
		
		
		if(choix==3) {
			 partiesave.setListJ(listJ);
			 partiesave.setTasCartes(tasCartes);
			 partiesave.setIndexjoueurcourant(indexPremierJ);
			 partiesave.setTour(tour);
			 Sauvegarde.sauvegarderPartie(partiesave, "save.dat");break;
			
		}
		if(choix==1) {

		while(true) {
			System.out.println(joueurCourant);
			
			if(joueurCourant.type==TypeJoueur.Réel) {
				t= lireNombreDansMenu("Choisir la carte vous voulez jouer : \n", joueurCourant, scanner);
						
			}else {		
						//debut random
						Random random = new Random();
				        // Génération d'un nombre aléatoire dans l'intervalle [min, max]
				        int min = 1;
				        int max = joueurCourant.getMain().size();
				         t = random.nextInt((max - min) + 1) + min;
				         //fin random
				         System.out.println("Le joueur virtuel a deja jouer");
				}			
			choix=t;
			t=t-1;
			
			
			
			ArrayList<String> menu1=new ArrayList<String>();
			menu1.add("Jouer Pour le POUVOIR");
			menu1.add("Jouer Pour la VIE FUTURE ");
			menu1.add("Jouer Pour les POINTS");
			menu1.add("Annuler");
			System.out.println(joueurCourant.getMain().get(choix-1).caracteristique());
			
			if(joueurCourant.type==TypeJoueur.Réel) {
				choix= lireNombreDansMenu("Que voulez vous faire : \n", menu1, 1, 4, scanner);
						
			}else {		
						//debut random
						Random random = new Random();
				        // Génération d'un nombre aléatoire dans l'intervalle [min, max]
				        int min = 1;
				        int max = 3;
				         choix = random.nextInt((max - min) + 1) + min;
				         //fin random
		         System.out.println("Le joueur virtuel a deja jouer");
				}
			
			if(choix!=4) 
				break;	
		}
		switch (choix) {
		
		case 1:
			Carte cart= joueurCourant.getMain().get(t);
			Strategie s= creerPouvoir(cart);
			joueurCourant.setStrategie(s);
			joueurCourant.getStrategie().jouerCarte(joueurCourant, t);
			compteurPouvoir++;
			//Thread.sleep(50000);
			
			break;
		case 2:
			Strategie p= new StrategieVieFuture();
			joueurCourant.setStrategie(p);
			joueurCourant.getStrategie().jouerCarte(joueurCourant, t);
			
			
			break;
		case 3:
			cart= joueurCourant.getMain().get(t);
			s= new StrategiePoint();
			joueurCourant.setStrategie(s);
			StrategiePoint.incrementerNombreCouleur(joueurCourant, cart);
			joueurCourant.getStrategie().jouerCarte(joueurCourant, t);
			
			break;
		
		
		}
		}
		}
		
		if(joueurCourant.getNiveau()==NiveauKarmique.Transcendance_5) {
			
			
			System.out.print(joueurCourant.getNom()+ " Vous avez atteint le niveau " + joueurCourant.getNiveau() + " \n FELICITATION VOUS AVEZ GAGNEZ LA PARTIE");
			
			bataille.estTerminer=true;
		}
		
		  // Passage au joueur suivant et incrément du numéro du tour
        indexPremierJ = (indexPremierJ + 1) % bataille.getListJ().size();
        tour++;
    }

    // Fin de la partie
    System.out.print("\n\n LA PARTIE EST TERMINEE \n\n");
}

}
		
 