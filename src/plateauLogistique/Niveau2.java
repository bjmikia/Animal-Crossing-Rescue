package plateauLogistique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Niveau2 extends Plateau implements Serializable{
	public Niveau2() {
		super(8,5,5);
		id = 2;
		//on definit des bords du jeu
		Obstacle mur = new Obstacle();
		this.remplirCase(1,1,mur);
		this.remplirCase(1,5,mur);

		// on place les animaux
		
		Animal chien1 = new Animal("Dog");
		this.remplirCase(2,1,chien1);
		Animal chien2 = new Animal("Dog");
		this.remplirCase(2,3,chien2);
		Animal chien3 = new Animal("Dog");
		this.remplirCase(3,3,chien3);
		Animal chat1 = new Animal("Cat");
		this.remplirCase(1,3,chat1);
		Animal chat2 = new Animal("Cat");
		this.remplirCase(2,5,chat2);

		// on place les cubes de couleurs

		Cube jaune1 = new Cube("yellow");
		this.remplirCase(3,1,jaune1);
		Cube jaune2 = new Cube("yellow");
		this.remplirCase(4,1,jaune2);
		Cube jaune3 = new Cube("yellow");
		this.remplirCase(4,3,jaune3);
		Cube jaune4 = new Cube("yellow");
		this.remplirCase(5,3,jaune4);
		Cube jaune5 = new Cube("yellow");
		this.remplirCase(6,3,jaune5);
		Cube jaune6 = new Cube("yellow");
		this.remplirCase(7,3,jaune6);
		Cube jaune7 = new Cube("yellow");
		this.remplirCase(8,3,jaune7);
		Cube jaune8 = new Cube("yellow");
		this.remplirCase(3,5,jaune8);
		Cube jaune9 = new Cube("yellow");
		this.remplirCase(4,5,jaune9);



		Cube bleu1 = new Cube("blue");
		this.remplirCase(7,1,bleu1);
		Cube bleu2 = new Cube("blue");
		this.remplirCase(8,1,bleu2);
		Cube bleu3 = new Cube("blue");
		this.remplirCase(1,2,bleu3);
		Cube bleu4 = new Cube("blue");
		this.remplirCase(2,2,bleu4);
		Cube bleu5 = new Cube("blue");
		this.remplirCase(5,2,bleu5);
		Cube bleu6 = new Cube("blue");
		this.remplirCase(6,2,bleu6);
		Cube bleu7 = new Cube("blue");
		this.remplirCase(1,4,bleu7);
		Cube bleu8 = new Cube("blue");
		this.remplirCase(2,4,bleu8);
		Cube bleu9 = new Cube("blue");
		this.remplirCase(5,4,bleu9);
		Cube bleu10 = new Cube("blue");
		this.remplirCase(6,4,bleu10);
		Cube bleu11 = new Cube("blue");
		this.remplirCase(7,5,bleu11);
		Cube bleu12 = new Cube("blue");
		this.remplirCase(8,5,bleu12);






		Cube rouge1 = new Cube("red");
		this.remplirCase(5,1,rouge1);
		Cube rouge2 = new Cube("red");
		this.remplirCase(6,1,rouge2);
		Cube rouge3 = new Cube("red");
		this.remplirCase(3,2,rouge3);
		Cube rouge4 = new Cube("red");
		this.remplirCase(4,2,rouge4);
		Cube rouge5 = new Cube("red");
		this.remplirCase(7,2,rouge5);
		Cube rouge6 = new Cube("red");
		this.remplirCase(8,2,rouge6);
		Cube rouge7 = new Cube("red");
		this.remplirCase(3,4,rouge7);
		Cube rouge8 = new Cube("red");
		this.remplirCase(4,4,rouge8);
		Cube rouge9 = new Cube("red");
		this.remplirCase(7,4,rouge9);
		Cube rouge10 = new Cube("red");
		this.remplirCase(8,4,rouge10);
		Cube rouge11 = new Cube("red");
		this.remplirCase(5,5,rouge11);
		Cube rouge12 = new Cube("red");
		this.remplirCase(6,5,rouge12);

	}

	@Override
	public void donneEtoile(int x) {
		if( x >= 3000) {
			setEtoile1(true);
		}if(x>= 15000) {
			setEtoile2(true);
		}if(x>= 26000) {
			setEtoile3(true);
		}
	}
}
