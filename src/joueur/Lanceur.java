package joueur;

import java.awt.EventQueue;
import java.io.Serializable;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import plateauLogistique.*;
import java.io.Serializable;
@SuppressWarnings("serial")
public class Lanceur implements Serializable{

    public static void main(String[] args) {
    	/*
    	 * On crée un Affichage (Vue),puis un jeu (Controleur) qui prend en parametre l'affichage.
    	 * Un affichage contient un champs jeu , on set donc ce champ avec le jeu que l'on vient de créer.
    	 * Enfin on affiche la fenêtre
    	 */
    	
        EventQueue.invokeLater(() -> {
       
        	Affichage frame = new Affichage();
        	Jeu jeu = new Jeu(frame);
        	frame.setJeu(jeu);
			frame.setVisible(true);

		});
  
    }
}
