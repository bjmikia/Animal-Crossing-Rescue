package plateauLogistique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Niveau1 extends Plateau implements Serializable {
	
	public Niveau1() {
		super(7,7,2);
		id = 1;
		// on definit les bords du jeu
		Obstacle mur = new Obstacle();
		this.remplirCase(1,1,mur);
		this.remplirCase(1,3,mur);
		this.remplirCase(1,4,mur);
		this.remplirCase(1,5,mur);
		this.remplirCase(1,7,mur);

		// on place les animaux

		Animal chien1 = new Animal("Dog");
		Animal chien2 = new Animal("Dog");
		this.remplirCase(1,2,chien1);
		this.remplirCase(1,6,chien2);

		//on place les cubes de couleurs
		Cube rose1 = new Cube("pink");
		this.remplirCase(2,1,rose1);
		Cube rose2 = new Cube("pink");
		this.remplirCase(3,1,rose2);
		Cube rose3 = new Cube("pink");
		this.remplirCase(6,1,rose3);
		Cube rose4 = new Cube("pink");
		this.remplirCase(7,1,rose4);
		Cube rose5 = new Cube("pink");
		this.remplirCase(2,2,rose5);
		Cube rose6 = new Cube("pink");
		this.remplirCase(3,2,rose6);
		Cube rose7 = new Cube("pink");
		this.remplirCase(6,5,rose7);
		Cube rose8 = new Cube("pink");
		this.remplirCase(7,5,rose8);
		Cube rose9 = new Cube("pink");
		this.remplirCase(6,6,rose9);
		Cube rose10 = new Cube("pink");
		this.remplirCase(7,6,rose10);


		Cube vert1 = new Cube("green");
		this.remplirCase(3,3,vert1);
		Cube vert2 = new Cube("green");
		this.remplirCase(4,3,vert2);
		Cube vert3 = new Cube("green");
		this.remplirCase(5,3,vert3);
		Cube vert4 = new Cube("green");
		this.remplirCase(3,4,vert4);
		Cube vert5 = new Cube("green");
		this.remplirCase(4,4,vert5);
		Cube vert6 = new Cube("green");
		this.remplirCase(5,4,vert6);
		Cube vert7 = new Cube("green");
		this.remplirCase(3,5,vert7);
		Cube vert8 = new Cube("green");
		this.remplirCase(4,5,vert8);
		Cube vert9 = new Cube("green");
		this.remplirCase(5,5,vert9);



		Cube jaune1 = new Cube("yellow");
		this.remplirCase(4,6,jaune1);
		Cube jaune2 = new Cube("yellow");
		this.remplirCase(5,6,jaune2);
		Cube jaune3 = new Cube("yellow");
		this.remplirCase(4,7,jaune3);
		Cube jaune4 = new Cube("yellow");
		this.remplirCase(5,7,jaune4);



		Cube rouge1 = new Cube("red");
		this.remplirCase(6,2,rouge1);
		Cube rouge2 = new Cube("red");
		this.remplirCase(7,2,rouge2);
		Cube rouge3 = new Cube("red");
		this.remplirCase(6,3,rouge3);
		Cube rouge4 = new Cube("red");
		this.remplirCase(7,3,rouge4);
		Cube rouge5 = new Cube("red");
		this.remplirCase(2,6,rouge5);
		Cube rouge6 = new Cube("red");
		this.remplirCase(3,6,rouge6);
		Cube rouge7 = new Cube("red");
		this.remplirCase(2,7,rouge7);
		Cube rouge8 = new Cube("red");
		this.remplirCase(3,7,rouge8);




		Cube bleu1 = new Cube("blue");
		this.remplirCase(4,1,bleu1);
		Cube bleu2 = new Cube("blue");
		this.remplirCase(5,1,bleu2);
		Cube bleu3 = new Cube("blue");
		this.remplirCase(4,2,bleu3);
		Cube bleu4 = new Cube("blue");
		this.remplirCase(5,2,bleu4);
		Cube bleu5 = new Cube("blue");
		this.remplirCase(2,3,bleu5);
		Cube bleu6 = new Cube("blue");
		this.remplirCase(2,4,bleu6);
		Cube bleu7 = new Cube("blue");
		this.remplirCase(6,4,bleu7);
		Cube bleu8 = new Cube("blue");
		this.remplirCase(7,4,bleu8);
		Cube bleu9 = new Cube("blue");
		this.remplirCase(2,5,bleu9);
		Cube bleu10 = new Cube("blue");
		this.remplirCase(6,7,bleu10);
		Cube bleu11 = new Cube("blue");
		this.remplirCase(7,7,bleu11);

	}

	@Override
	public void donneEtoile(int x) {
		if( x >= 2000) {
			setEtoile1(true);
		}if(x>= 13000) {
			setEtoile2(true);
		}if(x>= 22000) {
			setEtoile3(true);
		}
	}





}
