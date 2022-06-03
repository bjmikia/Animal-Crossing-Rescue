package plateauLogistique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Animal extends Contenu implements Serializable {

	public Animal(String type) {
		super(type);
	}
}
