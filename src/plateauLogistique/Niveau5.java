package plateauLogistique;
import java.io.Serializable;
import java.util.Random;

public class Niveau5 extends Plateau implements Serializable {
	public Niveau5(){
		super(8,8,3);
		id = 5;
		ajouteAnimauxAlea(); // on commence par mettre les animaux avant les cubes pour ensuite remplir les cases vides avec des cubes.
		ajouteCubesAlea();
	}

	// AJouter aléatoirement des animaux uniquement sur la premiere ligne
	public void ajouteAnimauxAlea() {
		int i = 1;
		 Random r = new Random();
		 int num1 = 1 + r.nextInt(8);
		 int num2 = 1 + r.nextInt(8);
		 int num3 = 1 + r.nextInt(8);
		 Animal chien = new Animal("Dog");
		 Animal chat = new Animal("Cat");
		 Animal oiseau = new Animal("Bird");
		 // on met entre 1 et  3 animal/aux par niveau aléatoire
		 niveau[i][num1].remplirCase(chien);

		 if(niveau[i][num2].estVide()) {
			 niveau[i][num2].remplirCase(chat);

		 }if(niveau[i][num3].estVide()) {

		 this.niveau[i][num3].remplirCase(oiseau);
		 }
	}

	public void ajouteCubesAlea() {
		for(int i = 0; i < niveau.length;i++) {
			for(int j = 0; j < niveau[i].length ; j++) {
				if(niveau[i][j].getContent()== null) {
					Cube c = new Cube();
					niveau[i][j].remplirCase(c);

				}

			}
		}
	}

	@Override
	public void donneEtoile(int x) {
		if( x >= 5000) {
			setEtoile1(true);
		}if(x>= 23000) {
			setEtoile2(true);
		}if(x>= 30000) {
			setEtoile3(true);
		}
	}

}
