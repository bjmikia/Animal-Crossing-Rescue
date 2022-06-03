package plateauLogistique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Case implements Serializable{
	 private boolean estVide;
	 private  Contenu content;

	 /** Le constructeur de Case ne prend en paramètre que le boolean
	  * estVide car l'objet contenu dans la case est initialisé au moment
	  * de l'initialisation du plateau entier
	  *
	  *
	  */
	public Case() {
		estVide = true;

	}

	public Contenu getContent() {
		return content;
	}

	public boolean estVide() {
		return estVide;
	}

	public void setEstVide(boolean b) {
		estVide = b;
	}


	public void remplirCase(Contenu c) {

			content = c;

		estVide = false;
	}


	public void viderCase() {
		this.content = new Contenu("vide");
		estVide = true;
	}



	@Override
	public String toString() {
		return (estVide ?"-":content.toString());
	}
}
