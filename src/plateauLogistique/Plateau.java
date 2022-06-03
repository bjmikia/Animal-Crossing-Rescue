package plateauLogistique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Plateau  implements Etoile, Serializable {
	 Case[][] niveau;
	private int longueur,largeur;
	private  int animaux;
	private int point = 0;
	protected int id;
	private int compteurAnimal = 0;
	private boolean etoile1 = false;
	private boolean etoile2 = false;
	private boolean etoile3 = false;



	public Plateau(int longueur, int largeur,int ani) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.animaux = ani;

		this.niveau = new Case[longueur+2][largeur+2];
		for(int i = 0; i < niveau.length;i++) {
			for(int j = 0; j < niveau[i].length ; j++) {
				niveau[i][j]=new Case();
			}
		}

	}

	public void remplirCase(int x ,int y, Contenu c) {
		niveau[x][y].remplirCase(c);
	}

	public int getId(){
		return id ;
	}

	 public int getPoint() {
		 return point;
	 }
	 public int getAnimaux() {
		 return animaux;
	 }


	public int getCpmtAnimal(){
		 return compteurAnimal;
	 }

	public int getLongueur() {
		return longueur;
	}

	
	public int getLargeur() {
		return largeur;
	}

	public boolean getEtoile1() {
		return etoile1;
	}
	
	public void setEtoile1(Boolean e) {
		etoile1 = e;
	}
	public boolean getEtoile2() {
		return etoile2;
	}
	public void setEtoile2(Boolean e) {
		etoile2 = e;
	}
	
	public boolean getEtoile3() {
		return etoile3;
	}
	
	public void setEtoile3(Boolean e) {
		etoile3 = e;
	}
	
	
	//Pour la partie terminal
	public void affichePlateau() {
		System.out.println();
		 System.out.println("\t"+"**************************");
		 System.out.println("\t"+"        Niveau "+id+"    ");
		
		 System.out.println("\t"+"**************************");
		 System.out.println();
		
		
		
		System.out.println("Score: "+point );
		System.out.println("Animaux sauvés: "+compteurAnimal );
		System.out.println("------------------" );
		for(int i = 1; i < niveau.length-1; i++) {
			System.out.print("|" +" ");
			for(int j = 1; j < niveau[i].length-1; j++) {
				if(niveau[i][j].estVide()) {
					System.out.print("       ");
				}else {
				System.out.print(" / "+niveau[i][j].toString()+" / ");
				}
				System.out.print(" ");
			}
			System.out.print("|" +" ");
			System.out.println();
		}
	}


	
	/**
	 * On évalue les cases autour de la case selectionnée pour savoir si elles sont de la même couleur.
	 * On les mets en instance de suppression si ce n'est pas déjà le cas.
	 * @param x
	 * @param y
	 */
	public void selectionCubeCouleur( int x, int y) {

		try{

		 if(niveau[x][y].getContent()instanceof Animal || niveau[x][y].getContent()instanceof Obstacle) {
			 return;
		 }

		 niveau[x][y].getContent().setVaEtreSupprimé(true);

		 if((x<niveau.length-2) && !niveau[x+1][y].estVide()&& niveau[x][y].getContent().getName().equals(niveau[x+1][y].getContent().getName()) &&
				 niveau[x+1][y].getContent().getVaEtreSupprimé() == false  ) {
			 selectionCubeCouleur(x+1,y);

		 } if((x>0)&& !niveau[x-1][y].estVide() && niveau[x][y].getContent().getName().equals(niveau[x-1][y].getContent().getName())&&
				 niveau[x-1][y].getContent().getVaEtreSupprimé() == false  ) {
			 selectionCubeCouleur(x-1,y);

		 } if( (y>0 )&& !niveau[x][y-1].estVide()  &&niveau[x][y].getContent().getName().equals(niveau[x][y-1].getContent().getName())
				 && niveau[x][y-1].getContent().getVaEtreSupprimé() == false ) {
			 selectionCubeCouleur(x,y-1);


		} if((y<niveau.length-2) &&!niveau[x][y+1].estVide() && niveau[x][y].getContent().getName().equals(niveau[x][y+1].getContent().getName())
				&& niveau[x][y+1].getContent().getVaEtreSupprimé() == false ) {
			selectionCubeCouleur(x,y+1);

		}
		}catch(NullPointerException e){
			System.out.println("Veuillez choisir un cube !");
		}

 }

	public  void botMeilleurCoup() {
		int compt = 0;
		int x = 1;
		int y = 1;
		
		for(int i = 1; i < niveau.length-1; i++) {
			for(int j = 1; j < niveau[i].length-1; j++) {
				
				if(niveau[i][j].getContent() instanceof Obstacle)continue;
				int tmp = 0;
				
				if((i<niveau.length-2) && !niveau[i+1][j].estVide()&& niveau[i][j].getContent().getName().equals(niveau[i+1][j].getContent().getName()) ) {
					tmp += 1;
				
				}if((i>0)&& !niveau[i-1][j].estVide() && niveau[i][j].getContent().getName().equals(niveau[i-1][j].getContent().getName()) ) {
					 tmp +=1;
				
				} if((j>0 )&& !niveau[i][j-1].estVide() && niveau[i][j].getContent().getName().equals(niveau[i][j-1].getContent().getName()) ) {
						tmp +=1;

				} if((j<niveau.length-2) &&!niveau[i][j+1].estVide() && niveau[i][j].getContent().getName().equals(niveau[i][j+1].getContent().getName()) ) {
					tmp +=1;
				}
				
				if(compt <= tmp) {
					compt = tmp;
					
					x = i;
					y = j;
				}
				
			}
			
		}
		selectionCubeCouleur(x,y);
	}
	

	 public void comptePoints() {
		 int compteur = 0;
		 int a = 0;
		 int b = 0;
		 for(int i = 1; i<niveau.length-1; i++) {
			 for(int j = 1; j<niveau[i].length-1; j++) {
				 if( !niveau[i][j].estVide() && niveau[i][j].getContent().getVaEtreSupprimé() == true) {
					 a = i;
					 b =j ;
					 compteur++;
				 }
			 }
		 }
		 if(compteur ==1) {
			 niveau[a][b].getContent().setVaEtreSupprimé(false);
			 return;
		 }

		 point +=(compteur*compteur)*10;

	 }



	 public void supprimerCubeCouleur() {
		 for(int i = 1; i<niveau.length-1; i++) {
			 for(int j = 1; j<niveau[i].length-1; j++) {
				 if(!niveau[i][j].estVide() && niveau[i][j].getContent().getVaEtreSupprimé() == true) {
					 niveau[i][j].viderCase();
				 }
			 }
		 }
	 }
	 /**
	  * cette fonction permet d'abaisser un cube ou un animal si la case du dessous
	  * est vide.Si l'objet est sur la dernière case de plateau on ne fait rien.
	  * Si la case d'en dessous est vide et que la case qui contient l'objet n'est pas vide ,
	  * on remplit la case du dessous avec cet objet. On répete cette opération autant de fois que possible.
	  *
	  * @param x
	  * @param y
	  */
	 private void abaisseContenu(int x, int y) {

		 if(x==niveau.length-2 || niveau[x][y].getContent()instanceof Obstacle)return;
		 if(niveau[x+1][y].estVide() && !niveau[x][y].estVide()) {
			 niveau[x+1][y].remplirCase(niveau[x][y].getContent()) ;
			 niveau[x][y].viderCase();

			 abaisseContenu(x+1,y);
		 }

	 }


	  //Pour chaque case du plateau on applique abaisseContenu
	 public void abaisseContenu() {
		 for(int i = niveau.length-2; i>=1; i--) {
			 for(int j=niveau[i].length-2 ;j>=1; j--) {
				 abaisseContenu(i,j);
			 }

		 }
	 }

	 /**
	  * Cette fonction déplace le contenu des cases vers la gauche si la gauche est vide .
	  * On regarde si la colonne de gauche est vide ou bien s'il est possible de déplacer de cube 
	  * vers la gauche .
	  *Elle ne s'applique pas à la colonne la plus à gauche et ne fait rien lorsqu'elle tombe sur un
	  *obstacle .
	  *@param x
	  *@param y
	  */


	 public void deplaceGauche(int x,int y) {
         if(y==1)return;
             int compteur = 0;
            for(int i = 1; i< niveau.length-1;i++){
                if(!niveau[i][y-1].estVide() && !(niveau[i][y-1].getContent()instanceof Obstacle)){
                    compteur++;
                }
            }
            if(compteur == 0){
            	int j = firstRempli(y);
            	if(niveau[j][y-1].getContent()instanceof Obstacle)return;
                for(int i = niveau.length-2; i>=1; i--){
                    if(niveau[i][y].getContent()instanceof Obstacle)continue;
                        if(!niveau[i][y].estVide()&& !(niveau[i][y-1].getContent()instanceof Obstacle)){
                        	niveau[i][y-1].remplirCase(niveau[i][y].getContent()) ;
                            niveau[i][y].viderCase();
                            abaisseContenu(i,y-1);
                        }
                }

                deplaceGauche(x,y-1);
			}

     }

	/*
	 * Permet de récupérer l'indice du cube au sommet d'une colonne 
	 */
	 private int firstRempli( int y) {
		 for(int i =1; i<=niveau.length-1;i++){
             if(niveau[i][y].getContent() instanceof Cube||niveau[i][y].getContent() instanceof Animal){
            	 return i;
             }
		 }
		 return 1;
	 }
	 

	 /**
	   * Cette fonction permet  d'appliquer deplaceGauche à toutes les cases du plateau.
	   * On appelle la fonction sur les cases de la dernière ligne.
	   */
	 public void deplaceGauche() {
		 int i = niveau.length-2;
		  for(int j = 2; j<niveau[i].length-1;j++) {
			  deplaceGauche(i,j);
		  }

	 }

	//Permet  de savoir si un animal se trouve sur la dernière ligne
	 public boolean animalSauve() {

		int i = niveau.length-2;

		 for( int j= 1; j<niveau[i].length-1; j++) {
			 if (!niveau[i][j].estVide() && niveau[i][j].getContent()instanceof Animal) {
				niveau[i][j].getContent().setVaEtreSupprimé(true);
				compteurAnimal += 1;
				point +=10000;
				return true;

			}
		}
		return false;
	 }

	 public boolean partieGagne() {
		 return (compteurAnimal == animaux);
	 }

	public void donneEtoile(int i){}

	 public void afficheEtoile() {
			String etoiles ="";
			if(etoile1) {
				etoiles = etoiles + "★";
			}if(etoile2) {
				etoiles = etoiles + "★";
			}if(etoile3) {
				etoiles = etoiles + "★";
			}
			System.out.println(etoiles);
		}

	
}
