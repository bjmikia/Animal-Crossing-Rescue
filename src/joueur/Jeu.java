package joueur;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

import plateauLogistique.*;


@SuppressWarnings("serial")
public class Jeu implements Serializable{
    private Joueur joueur ;
    /**
     * Le champs plateau sert de modèle général. Lorsqu'un niveau
     * est sélectionné sa valeur est attribuée à plateau pour ne pas 
     * avoir quatre fois les même méthodes. 
     */
    private Plateau plateau;
    
    //Les niveaux ici sont les differents modèles du jeu 
    private Niveau1 niv1;
    private Niveau2 niv2;
    private Niveau3 niv3;
    private Niveau4 niv4;
    private Affichage affichage;

    //Constructeur pour le terminal
    public Jeu(Joueur j , Plateau p) {
        joueur = j;
        plateau = p;
    }

    //Constructeur pour l'IG
    public Jeu(Affichage aff) {
    	niv1 =(Niveau1) deserialiserNiveau("niveau1.ser");
    	affichage = aff;
    	joueur = affichage.getJoueur();

    }

    //On récupère chaque niveau

    public Niveau1 getNiveau1() {
    	return niv1;
    }

    public Niveau2 getNiveau2() {
    	return niv2;
    }

    public Niveau3 getNiveau3() {
    	return niv3;
    }

    public Niveau4 getNiveau4() {
    	return niv4;
    }


    //Sérialisation du jeu en cours

    public void serialisationJeu(){
		try {
			FileOutputStream fos = new FileOutputStream("jeu.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
		} catch (IOException e) {
		}
    }

    //Déserialisation du jeu

    public void deserialiserJeu() {
    	Jeu j = null;
	    	try{
	    	FileInputStream fis = new FileInputStream("jeu.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
	    		j  =  (Jeu) ois.readObject();
	    		ois.close();
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
	    	joueur = j.joueur;
	    	plateau = j.plateau;
	    	niv1 = j.niv1;
	    	niv2 = j.niv2;
	    	niv3 = j.niv3;
	    	niv4 = j.niv4;

    }


    // Serialisation des niveaux
    public void serialisation(Plateau niv, String name) {

		try {
			FileOutputStream niveau1Debut = new FileOutputStream(name+".ser");
			ObjectOutputStream niveau1Fin = new ObjectOutputStream(niveau1Debut);
			niveau1Fin.writeObject(niv);
			niveau1Fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }



    // Déserialisation des niveaux

    public Plateau deserialiserNiveau(String chemin) {
    	Plateau p = null;
	    	try{
	    	FileInputStream niveau1D = new FileInputStream(chemin);
			ObjectInputStream niveau1F = new ObjectInputStream(niveau1D);
	    		p  =  (Plateau) niveau1F.readObject();
	    		niveau1F.close();
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
	    	return p;
    }

    	//////PARTIE TERMINAL //////
    
    /*
     * Cette fonction est le déroulé d'un niveau.
     * On effectue la succession des méthodes jusqu'a que les animaux soient tous sauvés.
     * Ensuite on affiche le score et les étoiles grâce aux nombres de points.
     * Enfin on enregistre les points obtenus dans le tableau du joueur, pour faire le total 
     * à la fin du jeu.
     */
    public void partie(){
        while(!(plateau.partieGagne())){
            plateau.affichePlateau();
            System.out.println();
            plateau.getPoint();
            char action = joueur.demanderAction();
            if (action == 's') {
            	 int x = joueur.selectionnerCaseX();
                 int y = joueur.selectionnerCaseY();
                 plateau.selectionCubeCouleur(x, y);

            } else if (action == 'd') {
                plateau.botMeilleurCoup();
            }

            plateau.comptePoints();
            plateau.supprimerCubeCouleur();
            plateau.abaisseContenu();
            plateau.deplaceGauche();
            while(plateau.animalSauve()){
                plateau.supprimerCubeCouleur();
                plateau.abaisseContenu();
                plateau.deplaceGauche();
            }

        }

        	 System.out.println("\t"+"***************************************************************");
     		 System.out.println("\t"+" 			Score :"+ plateau.getPoint()+"");
     		 System.out.println("\t"+"***************************************************************");
     		 System.out.println();
        System.out.println();

        plateau.donneEtoile(plateau.getPoint());
        plateau.afficheEtoile();

        joueur.setPointJoueur(plateau.getId(),plateau.getPoint());
    }



    ///PARTIE GRAPHIQUE ///

    /*
     * Le Contrôleur (Jeu) reçoit l'information de la Vue (Affichage).
     * Grâce à cette information il met à jour les élements du modèle puis
     * il renvoie à la Vue les informations nécéssaires pour afficher les modifications.
     */

    
    public void lancerNiveau1() {
    	niv1 =(Niveau1) deserialiserNiveau("niveau1.ser");
    	affichage.setPlateau(niv1);
    	affichage.miseAjour();
    	plateau = niv1;

    }


   public void lancerNiveau2() {
	   niv2 =(Niveau2) deserialiserNiveau("niveau2.ser");
    	affichage.setPlateau(niv2);
    	affichage.miseAjour();
    	plateau = niv2;

    }


    public void lancerNiveau3() {
    	niv3 =(Niveau3) deserialiserNiveau("niveau3.ser");
    	affichage.setPlateau(niv3);
    	affichage.miseAjour();
    	plateau = niv3;
    }

    public void lancerNiveau4() {
    	niv4 =(Niveau4) deserialiserNiveau("niveau4.ser");
    	affichage.setPlateau(niv4);
    	affichage.miseAjour();
    	plateau = niv4;
    }
    
    public void lancerNiveau5() {
    	Niveau5 niv5 = new Niveau5();
    	affichage.setPlateau(niv5);
    	affichage.miseAjour();
    	plateau = niv5;
    }
    
    
    /*
     * La sérialisation du jeu en cours s'effectue si le joueur a cliqué sur
     * les boutons quitter de l'accueil et des niveaux.
     */
    public void confirmationQuitter() {
    	serialisationJeu();
    	affichage.quitterJeu();
    }
    
    public void selectionNiveau() {
    	affichage.miseAjour(affichage.getSelectionNiveau());
    }

    public void continuerLaPartie() {
    	deserialiserJeu();
    	selectionNiveau();
    }

    /*
     * Cette fonction sélectionne le cube avec la meilleure configuration 
     * Si a l'issue du coup le niveau est gagné on fait appel à donneEtoile pour 
     * l'affichage des étoiles dans Affichage.
     */
    public void meilleurCoup() {
    	if(!(plateau.partieGagne())){
            plateau.getPoint();
            plateau.botMeilleurCoup();
            plateau.comptePoints();
            plateau.supprimerCubeCouleur();
            plateau.abaisseContenu();
            plateau.deplaceGauche();

            while(plateau.animalSauve()){
                plateau.supprimerCubeCouleur();
                plateau.abaisseContenu();
                plateau.deplaceGauche();
            }

        }
    	plateau.donneEtoile(plateau.getPoint());
    }


     /*
     * Permet d'effectuer un coup avec le cube sélectionné par le joueur
     * Si a l'issue du coup le niveau est gagné on fait appel à donneEtoile pour 
     * l'affichage des étoiles dans Affichage.
     * @param x
	 * @param y
	 */
    public void partie(int x , int y){
        if(!(plateau.partieGagne())){

            plateau.getPoint();
            plateau.selectionCubeCouleur(x, y);
            plateau.comptePoints();
            plateau.supprimerCubeCouleur();
            plateau.abaisseContenu();
            plateau.deplaceGauche();
            while(plateau.animalSauve()){
                plateau.supprimerCubeCouleur();
                plateau.abaisseContenu();
                plateau.deplaceGauche();
            }

        }
        plateau.donneEtoile(plateau.getPoint());

    }

    /* Génerateur de chiffre aléatoire compris entre 
     *  1 et les bords du plateau
     * @param borneInf
	 * @param borneSup
     */
    private int genererInt(int borneInf, int borneSup){
 	   Random random = new Random();
 	   int nb;
 	   nb = Math.abs(borneSup-borneInf);
 	   nb = borneInf+random.nextInt(nb);
 	   return nb;
 	}

 /*
  * Cette  fonction définit le robot. un nombre aléatoie est choisi, s'il est inferieur à
  * 5 le robot effectue un meilleur coup, sinon un coup aléatoire.
  * Si cette fonction est appelé le robot prend le contrôle du niveau jusqu'a la fin.
  */
  public void botPartie() {
 	 if(!(plateau.partieGagne())){
 		 plateau.getPoint();
 		 int rand = genererInt(0,10);
 		 if(rand<5) {
           plateau.botMeilleurCoup();
 		 }else {
			int x = genererInt(1,plateau.getLongueur());
			int y = genererInt(1,plateau.getLargeur());
			plateau.selectionCubeCouleur(x, y);
			}

           plateau.comptePoints();
           plateau.supprimerCubeCouleur();
           plateau.abaisseContenu();
           plateau.deplaceGauche();

           while(plateau.animalSauve()){
               plateau.supprimerCubeCouleur();
               plateau.abaisseContenu();
               plateau.deplaceGauche();

           }

       }
 	 plateau.donneEtoile(plateau.getPoint());
 }

}
