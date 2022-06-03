package plateauLogistique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contenu implements Serializable{
	/**
	 * Cette classe est la classe parent des classes Animal et Cube
	 * car ces dernières ont presque le même comportement de base
	 *
	 */
		private  String name;
		
		private boolean vaEtreSupprimé; // pour qu'ils soient supprimé apres etre selectionné


		public Contenu(String n) {
			name = n;
			
			vaEtreSupprimé =false;

		}
		
		@Override
		public String toString() {
			return name.substring(0,1);
		}

		public String getName() {
			return name;
		}

		public void setName(String s) {
			name = s;
		}

		public boolean getVaEtreSupprimé() {
			return vaEtreSupprimé;
		}

		public void setVaEtreSupprimé(boolean s) {
			vaEtreSupprimé = s;
		}
}
