package joueur;
import plateauLogistique.*;
public class LanceurTer {

	public static void main(String[] args) {
		
		Plateau p1 = new Niveau1();
        Plateau p2 = new Niveau2();
        Plateau p3 = new Niveau3();
        Plateau p4 = new Niveau4();
        Joueur j1 = new Joueur();
        
         System.out.println("\t"+"***************************");
		 System.out.println("\t"+"* Animal Crossing Rescue  *");
		 System.out.println("\t"+"*                         *");
		 System.out.println("\t"+"***************************");
		 System.out.println();
		 
        boolean partie = j1.veutJouer();
         if(partie) {
        	  
                Jeu jeu1 = new Jeu(j1, p1);
                jeu1.partie();
                
                j1.setNom(j1.demanderNom());
                j1.dialogue();
                System.out.println();
      		
                Jeu jeu2 = new Jeu(j1, p2);
                
                jeu2.partie();
                Jeu jeu3 = new Jeu(j1, p3);
                jeu3.partie();
          	
  
                Jeu jeu4 = new Jeu(j1, p4);
                jeu4.partie();
               
                j1.dialogue2();
        }
               
        j1.finish();

	}

}
