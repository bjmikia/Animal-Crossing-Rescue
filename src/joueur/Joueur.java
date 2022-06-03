package joueur;

import java.io.Serializable;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Joueur implements Serializable{
	
	private String nom;
	transient private Scanner scanReponse;
	private int [] pointJoueur = new int [5];
	


	public Joueur() {
		this.nom = "Anonyme";
		scanReponse = new Scanner(System.in);
	}



	public void setPointJoueur(int i , int j ){
		pointJoueur[i] = j;
	}

	//Termine le programme à la fin du jeu dans la version terminal
	public void finish() {
		scanReponse.close();
		System.exit(0);
	}

	public String demanderNom() {
        return demanderStr("Vous êtes plutôt fort :) ! Quel est votre nom ?");
	}

	public void setNom(String str){
		nom = str;
	}

	public void dialogue(){
		System.out.println("Très bien "+this.nom+" continuons la partie ");
	}

	public void dialogue2() {
		int score = pointJoueur[1]+pointJoueur[2]+pointJoueur[3]+pointJoueur[4];
		System.out.println("Bravo "+this.nom+" vous avez fini tous les niveaux !");
		System.out.println("votre score total  est de "+score);
	}

	public boolean veutJouer() {
        return demanderStr("Voulez-vous jouer (oui/non) ?").equals("oui");
    }
	
	
	 public char demanderAction() {
	        return demanderStr("Voulez-vous selectionner une case (s) demander de l'aide (d) ?").charAt(0);
	    }

	 private String demanderStr(String q) {
	        System.out.print(q + " ");
	        return scanReponse.next();
	 }


	 /**
	  *Les deux fonctions permettent au joueur de choisir la case qu'il veut jouer 
	  *dans le jeu terminal 
	  * 
	  */
	 public int selectionnerCaseX(){
	
		 String CoordonnéeX;

		 System.out.println("Saisissez le nombre qui correspond à la ligne : ");
		 Scanner sc = new Scanner(System.in);
		 CoordonnéeX = sc.nextLine();

		 try {
		 int x = Integer.parseInt(CoordonnéeX);
		 
		 return x;
		 }catch(Exception e) {

			 System.out.println("Veuillez mettre un nombre");
			 return selectionnerCaseX();
		 }
	}
		 public int selectionnerCaseY(){

			  
			 String CoordonnéeY;
			 System.out.println("Veuillez saisir le nombre qui correspond à la colonne : ");
			 Scanner sc = new Scanner(System.in);
			 CoordonnéeY = sc.nextLine();

			 try {
				 int y = Integer.parseInt(CoordonnéeY);
				 
				 return y;
				 }catch(Exception e) {
					 System.out.println("Veuillez mettre un nombre");
					 return selectionnerCaseY();
				 }
			}
}
