package plateauLogistique;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Obstacle extends Contenu implements Serializable{

	public Obstacle() {
		super("§");
	}
	
	
	@Override
	public String toString() {
		return this.getName();
	}
}
