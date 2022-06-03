package plateauLogistique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Niveau3 extends Plateau  implements Serializable{
	public Niveau3() {
		super(9,7,3);
		id = 3;
		//on definit des bords du jeu
		Obstacle mur = new Obstacle();
		this.remplirCase(1,1,mur);
		this.remplirCase(2,1,mur);
		this.remplirCase(3,1,mur);
		this.remplirCase(4,1,mur);
		this.remplirCase(1,2,mur);
		this.remplirCase(2,2,mur);
		this.remplirCase(3,2,mur);
		this.remplirCase(4,2,mur);
		this.remplirCase(1,4,mur);
		this.remplirCase(1,6,mur);
		this.remplirCase(8,6,mur);
		this.remplirCase(9,6,mur);
		this.remplirCase(8,7,mur);
		this.remplirCase(9,7,mur);

		// on place les animaux
		Animal chien = new Animal("Dog");
		Animal chat = new Animal("Cat");
		Animal cochon = new Animal("Pig");
		this.remplirCase(1,3,cochon);
		this.remplirCase(1,5,chien);
		this.remplirCase(1,7,chat);

		// on place les cubes de couleurs
		Cube jaune1 = new Cube("yellow");
		this.remplirCase(6,1,jaune1);
		Cube jaune2 = new Cube("yellow");
		this.remplirCase(9,1,jaune2);
		Cube jaune3 = new Cube("yellow");
		this.remplirCase(8,2,jaune3);
		Cube jaune4 = new Cube("yellow");
		this.remplirCase(2,3,jaune4);
		Cube jaune5 = new Cube("yellow");
		this.remplirCase(3,3,jaune5);
		Cube jaune6 = new Cube("yellow");
		this.remplirCase(6,4,jaune6);
		Cube jaune7 = new Cube("yellow");
		this.remplirCase(7,4,jaune7);
		Cube jaune8 = new Cube("yellow");
		this.remplirCase(4,5,jaune8);
		Cube jaune9 = new Cube("yellow");
		this.remplirCase(5,5,jaune9);
		Cube jaune10 = new Cube("yellow");
		this.remplirCase(6,6,jaune10);
		Cube jaune11 = new Cube("yellow");
		this.remplirCase(7,6,jaune11);
		Cube jaune12 = new Cube("yellow");
		this.remplirCase(4,7,jaune12);
		Cube jaune13 = new Cube("yellow");
		this.remplirCase(5,7,jaune13);





		Cube vert1 = new Cube("green");
		this.remplirCase(5,1,vert1);
		Cube vert2 = new Cube("green");
		this.remplirCase(7,1,vert2);
		Cube vert3 = new Cube("green");
		this.remplirCase(7,2,vert3);
		Cube vert4 = new Cube("green");
		this.remplirCase(9,2,vert4);
		Cube vert5 = new Cube("green");
		this.remplirCase(6,3,vert5);
		Cube vert6 = new Cube("green");
		this.remplirCase(7,3,vert6);
		Cube vert7 = new Cube("green");
		this.remplirCase(4,4,vert7);
		Cube vert8 = new Cube("green");
		this.remplirCase(5,4,vert8);
		Cube vert9 = new Cube("green");
		this.remplirCase(8,4,vert9);
		Cube vert10 = new Cube("green");
		this.remplirCase(9,4,vert10);
		Cube vert11 = new Cube("green");
		this.remplirCase(2,5,vert11);
		Cube vert12 = new Cube("green");
		this.remplirCase(3,5,vert12);
		Cube vert13 = new Cube("green");
		this.remplirCase(6,5,vert13);
		Cube vert14 = new Cube("green");
		this.remplirCase(7,5,vert14);
		Cube vert15 = new Cube("green");
		this.remplirCase(2,7,vert15);
		Cube vert16 = new Cube("green");
		this.remplirCase(3,7,vert16);
		Cube vert17 = new Cube("green");
		this.remplirCase(6,7,vert17);
		Cube vert18 = new Cube("green");
		this.remplirCase(7,7,vert18);



		Cube rose1 = new Cube("pink");
		this.remplirCase(8,1,rose1);
		Cube rose2 = new Cube("pink");
		this.remplirCase(5,2,rose2);
		Cube rose3 = new Cube("pink");
		this.remplirCase(6,2,rose3);
		Cube rose4 = new Cube("pink");
		this.remplirCase(4,3,rose4);
		Cube rose5 = new Cube("pink");
		this.remplirCase(5,3,rose5);
		Cube rose6 = new Cube("pink");
		this.remplirCase(8,3,rose6);
		Cube rose7 = new Cube("pink");
		this.remplirCase(9,3,rose7);
		Cube rose8 = new Cube("pink");
		this.remplirCase(2,4,rose8);
		Cube rose9 = new Cube("pink");
		this.remplirCase(3,4,rose9);
		Cube rose10 = new Cube("pink");
		this.remplirCase(8,5,rose10);
		Cube rose11 = new Cube("pink");
		this.remplirCase(9,5,rose11);
		Cube rose12 = new Cube("pink");
		this.remplirCase(2,6,rose12);
		Cube rose13 = new Cube("pink");
		this.remplirCase(3,6,rose13);
		Cube rose14 = new Cube("pink");
		this.remplirCase(4,6,rose14);
		Cube rose15 = new Cube("pink");
		this.remplirCase(5,6,rose15);
	}

	@Override
	public void donneEtoile(int x) {
		if( x >= 4000) {
			setEtoile1(true);
		}if(x>= 13000) {
			setEtoile2(true);
		}if(x>= 24000) {
			setEtoile3(true);
		}
	}


}
;