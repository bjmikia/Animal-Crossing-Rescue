package plateauLogistique;

import java.io.Serializable;
import java.util.Random;

@SuppressWarnings("serial")
public class Cube  extends Contenu implements Serializable{

	public Cube(String couleur) {
		super(couleur);
	}
	//Constructeur uniquement pour le niveau 5 pour choisir les cube aléatoirement
	public Cube() {
		super(getColor());
	}
	
	private static String getColor() {
		Random r = new Random();
		int j = r.nextInt(3);
		String color="";
		
		// j'utilise un switch et un Random pour choisir ente seulement 3 couleurs pour que le niveau reste faisable
		switch(j) { 
		
			case 0: color ="blue";
			break;
			
			case 1: color= "red";
			break;
			

			case 2 : color = "yellow";
			break;
			

			
		}
		
		
			return color;
	}


}
