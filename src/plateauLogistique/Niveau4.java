package plateauLogistique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Niveau4  extends Plateau implements Serializable{
	public Niveau4() {
		super(8,8,4);
		id = 4;
		//on definit des bords du jeu
		Obstacle mur = new Obstacle();
		this.remplirCase(1,1,mur);
		this.remplirCase(2,1,mur);
		this.remplirCase(3,1,mur);
		this.remplirCase(4,1,mur);
		this.remplirCase(1,2,mur);
		this.remplirCase(2,2,mur);
		this.remplirCase(3,2,mur);
		this.remplirCase(1,3,mur);
		this.remplirCase(2,3,mur);
		this.remplirCase(1,4,mur);
		this.remplirCase(8,5,mur);
		this.remplirCase(8,6,mur);
		this.remplirCase(7,6,mur);
		this.remplirCase(8,7,mur);
		this.remplirCase(7,7,mur);
		this.remplirCase(6,7,mur);
		this.remplirCase(8,8,mur);
		this.remplirCase(7,8,mur);
		this.remplirCase(6,8,mur);
		this.remplirCase(5,8,mur);

		// on place les animaux
		Animal chien1 = new Animal("Dog");
		Animal chien2 = new Animal("Dog");
		Animal chat = new Animal("Cat");
		Animal cochon = new Animal("Pig");
		this.remplirCase(1,5,cochon);
		this.remplirCase(1,6,chien1);
		this.remplirCase(1,7,chien2);
		this.remplirCase(1,8,chat);

		// on place les cubes de couleurs
		Cube vert1 = new Cube("green");
		this.remplirCase(6,1,vert1);
		Cube vert2 = new Cube("green");
		this.remplirCase(5,2,vert2);
		Cube vert3 = new Cube("green");
		this.remplirCase(6,2,vert3);
		Cube vert4 = new Cube("green");
		this.remplirCase(5,4,vert4);
		Cube vert5 = new Cube("green");
		this.remplirCase(6,4,vert5);
		Cube vert6 = new Cube("green");
		this.remplirCase(4,5,vert6);
		Cube vert7 = new Cube("green");
		this.remplirCase(5,5,vert7);
		Cube vert8 = new Cube("green");
		this.remplirCase(2,6,vert8);
		Cube vert9 = new Cube("green");
		this.remplirCase(3,6,vert9);
		Cube vert10 = new Cube("green");
		this.remplirCase(4,7,vert10);
		Cube vert11 = new Cube("green");
		this.remplirCase(5,7,vert11);
		Cube vert12 = new Cube("green");
		this.remplirCase(4,8,vert12);



		Cube rouge1 = new Cube("red");
		this.remplirCase(5,1,rouge1);
		Cube rouge2 = new Cube("red");
		this.remplirCase(7,1,rouge2);
		Cube rouge3 = new Cube("red");
		this.remplirCase(7,2,rouge3);
		Cube rouge4 = new Cube("red");
		this.remplirCase(8,2,rouge4);
		Cube rouge5 = new Cube("red");
		this.remplirCase(5,3,rouge5);
		Cube rouge6 = new Cube("red");
		this.remplirCase(6,3,rouge6);
		Cube rouge7 = new Cube("red");
		this.remplirCase(3,4,rouge7);
		Cube rouge8 = new Cube("red");
		this.remplirCase(4,4,rouge8);
		Cube rouge9 = new Cube("red");
		this.remplirCase(7,4,rouge9);
		Cube rouge10 = new Cube("red");
		this.remplirCase(8,4,rouge10);
		Cube rouge11 = new Cube("red");
		this.remplirCase(4,6,rouge11);
		Cube rouge12 = new Cube("red");
		this.remplirCase(5,6,rouge12);
		Cube rouge13 = new Cube("red");
		this.remplirCase(6,6,rouge13);
		Cube rouge14 = new Cube("red");
		this.remplirCase(2,8,rouge14);
		Cube rouge15 = new Cube("red");
		this.remplirCase(3,8,rouge15);

		Cube rose1 = new Cube("pink");
		this.remplirCase(8,1,rose1);
		Cube rose2 = new Cube("pink");
		this.remplirCase(4,2,rose2);
		Cube rose3 = new Cube("pink");
		this.remplirCase(3,3,rose3);
		Cube rose4 = new Cube("pink");
		this.remplirCase(4,3,rose4);
		Cube rose5 = new Cube("pink");
		this.remplirCase(7,3,rose5);
		Cube rose6 = new Cube("pink");
		this.remplirCase(8,3,rose6);
		Cube rose7 = new Cube("pink");
		this.remplirCase(2,4,rose7);
		Cube rose8 = new Cube("pink");
		this.remplirCase(2,5,rose8);
		Cube rose9 = new Cube("pink");
		this.remplirCase(3,5,rose9);
		Cube rose10 = new Cube("pink");
		this.remplirCase(6,5,rose10);
		Cube rose11 = new Cube("pink");
		this.remplirCase(7,5,rose11);
		Cube rose12 = new Cube("pink");
		this.remplirCase(2,7,rose12);
		Cube rose13 = new Cube("pink");
		this.remplirCase(3,7,rose13);
	}


	@Override
	public void donneEtoile(int x) {
		if( x >= 5000) {
			setEtoile1(true);
		}if(x>= 15000) {
			setEtoile2(true);
		}if(x>= 24000) {
			setEtoile3(true);
		}
	}

}
