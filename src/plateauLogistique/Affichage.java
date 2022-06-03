package plateauLogistique;
import joueur.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.Serializable;
@SuppressWarnings("serial")
public class Affichage extends JFrame implements Serializable{

		transient private JPanel selectionNiveau;
		transient private JPanel accueil;
		transient private JPanel pageNiveau;
		transient private JPanel finNiveau;
		transient private JPanel niveauPanel;
		transient private JPanel finDePartie;
		JLabel score = new JLabel();
		JLabel animauxSauve = new JLabel();
		private Joueur j1 = new Joueur();
		private Plateau p1 ;
		private Jeu jeu ;
		transient ScheduledExecutorService robot;
		boolean isLaunched = false;
			///////////////////////////////////////// CONSTRUCTEUR D'AFFICHAGE ///////////////////////////////////////////////

		public Affichage() {


			//Configuration de la fenêtre

			this.setResizable(false);
			setTitle("Project");
			getContentPane().setBackground(Color.WHITE);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1079, 700);
			setLocationRelativeTo(null); //permet d'afficher la page au centre de l'ecran au lancement

			//Configuration de l'accueil
			accueil= new JPanelWithBackground("icon/FondDecran.jpg");
			getContentPane().add(accueil);
			accueil.setLayout(null);

			JButton btnNewButton_1 = new JButton("Nouvelle partie");

		    btnNewButton_1.setBackground(new Color(51, 255, 102));
			btnNewButton_1.setBounds(449, 291, 173, 61);
			accueil.add(btnNewButton_1);

			JButton btnNewButton_2 = new JButton("Continuer une partie ");
			File f = new File("jeu.ser");
			if(f.exists()) {
				btnNewButton_2.setEnabled(true);
			}else {
				btnNewButton_2.setEnabled(false);
			}
			btnNewButton_2.setBackground(new Color(51, 255, 102));
			btnNewButton_2.setBounds(449, 401, 173, 61);
			accueil.add(btnNewButton_2);

			JButton btnNewButton_3 = new JButton("Quitter");

			btnNewButton_3.setBackground(new Color(240, 100, 102));
			btnNewButton_3.setBounds(449, 514, 173, 61);
			accueil.add(btnNewButton_3);

			JLabel lblNewLabel = new JLabel("Animal Crossing Rescue");
			lblNewLabel.setFont(new Font("DejaVu Serif", Font.BOLD, 52));
			lblNewLabel.setBounds(200, 12, 1000, 145);
			accueil.add(lblNewLabel);

			/*
			 * On envoie au controleur l'information qu'un bouton à été cliqué.
			 * Le contrôleur va traiter cette information.
			 */

			btnNewButton_1.addActionListener (( click ) -> { jeu.selectionNiveau(); });
			btnNewButton_2.addActionListener (( click ) -> { jeu.continuerLaPartie(); });
			btnNewButton_3.addActionListener((click)-> {jeu.confirmationQuitter();});

		}



			///////////////////////////////////////// METHODES D'AFFICHAGE ///////////////////////////////////////////////




	public void setPlateau(Plateau p) {
		p1 = p;
	}

	public void setJeu(Jeu j ) {
		jeu = j;
	}

	public Joueur getJoueur() {
		return j1;
	}

	// Permet de creér le panel interne contenant le plateau
	private void placementCube() {
		for( int i =1; i< p1.niveau.length-1; i++) {
			for(int j = 1; j< p1.niveau[i].length-1; j++) {
				if(p1.niveau[i][j].getContent().getName().equals("§")) {
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/mur.jpeg")));
				}if(p1.niveau[i][j].getContent().getName().equals("Cat")) {
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/TomNook.jpeg")));
				}if(p1.niveau[i][j].getContent().getName().equals("Dog")){
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/bea.jpeg")));
				}if(p1.niveau[i][j].getContent().getName().equals( "Bird")){
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/julie.jpeg")));
				}if(p1.niveau[i][j].getContent().getName().equals( "Pig")){
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/pansy.jpeg")));
				}if(p1.niveau[i][j].getContent().getName().equals( "pink")) {
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/CubeRose.jpg")));
				}if(p1.niveau[i][j].getContent().getName().equals( "green")) {
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/CubeVert.jpg")));

				}if(p1.niveau[i][j].getContent().getName().equals("red")) {
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/CubeRouge.jpeg")));

				}if(p1.niveau[i][j].getContent().getName().equals( "yellow")) {
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/CubeJaune.jpg")));

				}if(p1.niveau[i][j].getContent().getName().equals( "blue")) {
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/CubeBleu.jpg")));

				}
				if(p1.niveau[i][j].getContent().getName().equals("vide")) {
					pageNiveau.add(new Cube(i, j, new ImageIcon("icon/CubeVide.jpg")));

				}
			}

		}
	}



	//Affiche le score courant
	public JLabel getScore() {
		score.setText("Score:"+p1.getPoint());
		score.setFont(new Font("DejaVu Serif", Font.BOLD, 22));
		score.setBounds(10,100,250,100);
		return score;

	}

	//Affiche le nombre d'animaux sauvés pour le plateau courant
	public JLabel getAnimaux() {
		animauxSauve.setText("Animaux sauvés:"+p1.getCpmtAnimal()+"/"+p1.getAnimaux());
		animauxSauve.setFont(new Font("DejaVu Serif", Font.BOLD, 22));
		animauxSauve.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		animauxSauve.setBounds(10,130,250,100);
		return animauxSauve;
	}

	
	//Retourne le panel avec les boutons pour la sélection des niveaux
	//Ce panel sera utilisé dans la fonction miseAjour
	public JPanel getSelectionNiveau() {

		selectionNiveau = new JPanelWithBackground("icon/FondDecran.jpg");

		selectionNiveau.setBorder(new EmptyBorder(5, 5, 5, 5));



		//Configuration du label et  des boutons dans selection niveau

		selectionNiveau.setLayout(null);

		JButton niveau1 = new JButton("Niveau 1");
		niveau1.setBounds(449, 149, 173, 61);
		niveau1.setBackground(new Color(51, 255, 102));
		selectionNiveau.add(niveau1);

		JButton niveau2 = new JButton("Niveau 2");
		if(!(jeu.getNiveau1().partieGagne())) {
		niveau2.setEnabled(false);
		}
		niveau2.setBackground(new Color(51, 255, 102));
		niveau2.setBounds(449, 261, 173, 61);
		selectionNiveau.add(niveau2);

		JButton niveau3 = new JButton("Niveau 3");
		try{

			if(!(jeu.getNiveau2().partieGagne())) {
			niveau3.setEnabled(false);
			}
		}catch(Exception e) {
			niveau3.setEnabled(false);
		}
		niveau3.setBackground(new Color(51, 255, 102));
		niveau3.setBounds(449, 371, 173, 61);
		selectionNiveau.add(niveau3);

		JButton niveau4 = new JButton("Niveau 4");
		try{
			if(!(jeu.getNiveau3().partieGagne())) {
			niveau4.setEnabled(false);
			}
		}catch(Exception e) {
			niveau4.setEnabled(false);
		}
		niveau4.setBackground(new Color(51, 255, 102));
		niveau4.setBounds(449, 484, 173, 61);
		selectionNiveau.add(niveau4);
		
		JButton nivAlea = new JButton("Niveau Aléatoire");
		nivAlea.setBounds(449, 588 , 173, 61);
		nivAlea.setBackground(new Color(51, 255, 102));
		selectionNiveau.add(nivAlea);

		JButton quitter = new JButton("Quitter");
		quitter.setBackground(new Color(240, 100, 102));
		quitter.setBounds(100,100, 173, 61);
		selectionNiveau.add(quitter);

		JLabel lblNewLabel = new JLabel("Niveaux");
		lblNewLabel.setFont(new Font("DejaVu Serif", Font.BOLD, 52));
		lblNewLabel.setBounds(424, 12, 386, 145);
		selectionNiveau.add(lblNewLabel);

		niveau1.addActionListener((click)-> {jeu.lancerNiveau1();});
		niveau2.addActionListener (( click ) -> { jeu.lancerNiveau2(); });
		niveau3.addActionListener (( click ) -> { jeu.lancerNiveau3(); });
		niveau4.addActionListener((click)-> {jeu.lancerNiveau4();});
		nivAlea.addActionListener((click)-> {jeu.lancerNiveau5();});
		quitter.addActionListener((click)-> {jeu.confirmationQuitter();});

		return selectionNiveau;
	}

	public void quitterJeu() {
		int reply = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter le jeu ?", "Confirmation", JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {

		    System.exit(0);


		}
	}


	// Permet de créer un panel adapté à la taille du plateau courant
	public JPanel getNiveau() {
		pageNiveau = new JPanel();
		pageNiveau.setBorder(new EmptyBorder(5, 5, 5, 5));
		pageNiveau.setLayout(new GridLayout(p1.getLongueur(), p1.getLargeur()));
		pageNiveau.setBounds(280, 150, 500, 500);
		pageNiveau.setBackground(Color.white);
		placementCube();
		return pageNiveau;
	}


	// Retoune le panel de fin de niveau
	public JPanel getFinNiveau(Plateau p1) {
		if(isLaunched) {
		robot.shutdown();// permet d'arrêter le robot
		isLaunched = false;
		}
		finNiveau =  new JPanelWithBackground("icon/FondDecran.jpg");
		 finNiveau.setBorder(new EmptyBorder(5, 5, 5, 5));
		 finNiveau.setLayout(null);
		finNiveau.setBounds(280, 150, 500, 500);
		 finNiveau.setBackground(Color.white);

		 JLabel finLabel = new JLabel("Niveau reussi !");
			finLabel.setFont(new Font("DejaVu Serif", Font.BOLD, 52));
			finLabel.setBounds(304, 12, 686, 145);
			finNiveau.add(finLabel);

			JLabel finLabel2 = new JLabel("Score:");
			finLabel2.setFont(new Font("DejaVu Serif", Font.BOLD, 52));
			finLabel2.setBounds(440, 90, 486, 145);
			finNiveau.add(finLabel2);

			JLabel finLabel3 = new JLabel(""+p1.getPoint());
			finLabel3.setFont(new Font("DejaVu Serif", Font.BOLD, 52));
			finLabel3.setBounds(440, 160, 586, 145);
			finNiveau.add(finLabel3);

			if(p1.getEtoile1()) {
				JLabel etoile = new JLabel(new ImageIcon("icon/etoile.png"));
				etoile.setBounds(300,300 , 128 , 128 );
				finNiveau.add(etoile);
			}else {
				JLabel etoileGrise = new JLabel(new ImageIcon("icon/etoileGrise.png"));
				etoileGrise.setBounds(300,300 , 128 , 128 );
				finNiveau.add(etoileGrise);
			}

			if(p1.getEtoile2()) {
				JLabel etoile = new JLabel(new ImageIcon("icon/etoile.png"));
				etoile.setBounds(450,300, 128 , 128 );
				finNiveau.add(etoile);

			}else {
				JLabel etoileGrise = new JLabel(new ImageIcon("icon/etoileGrise.png"));
				etoileGrise.setBounds(450,300 , 128 , 128 );
				finNiveau.add(etoileGrise);
			}

			if(p1.getEtoile3()) {
				JLabel etoile = new JLabel(new ImageIcon("icon/etoile.png"));
				etoile.setBounds(600 ,300, 128 , 128 );
				finNiveau.add(etoile);

				}else {
					JLabel etoileGrise = new JLabel(new ImageIcon("icon/etoileGrise.png"));
					etoileGrise.setBounds(600,300 , 128 , 128 );
					finNiveau.add(etoileGrise);
				}

			JButton suivant = new JButton("Suivant");
			suivant.setBounds(449, 480, 173, 61);
			suivant.setFont(new Font("DejaVu Serif",Font.ITALIC, 30));
			suivant.setBackground(new Color(51, 255, 102));
			finNiveau.add(suivant);



		 suivant.addActionListener((click)-> {
			 try {
				 if(jeu.getNiveau4().partieGagne()) {
					 miseAjour(getFinDePartie(p1));
				 }
			 }catch(Exception e) {
				 jeu.selectionNiveau();
			 }

			 });



		 return finNiveau;
	 }


	//Retourne le panel de fin de partie
	public JPanel getFinDePartie(Plateau p1) {

		finDePartie =  new JPanelWithBackground("icon/FondDecran.jpg");
		finDePartie.setBorder(new EmptyBorder(5, 5, 5, 5));
		finDePartie.setLayout(null);
		finDePartie.setBounds(280, 150, 500, 500);
		finDePartie.setBackground(Color.white);

		 JLabel finLabel = new JLabel("Vous avez terminé le jeu, BRAVO !");
		finLabel.setFont(new Font("DejaVu Serif", Font.BOLD, 50));
		finLabel.setBounds(50, 12, 1000, 145);
		finDePartie.add(finLabel);

		JLabel finLabel2 = new JLabel("Score Final:");
		finLabel2.setFont(new Font("DejaVu Serif", Font.BOLD, 30));
		finLabel2.setBounds(300, 90, 486, 145);
		finDePartie.add(finLabel2);

		JLabel finLabel3 = new JLabel(Integer.toString(jeu.getNiveau1().getPoint() + jeu.getNiveau2().getPoint() +
						   jeu.getNiveau3().getPoint() + jeu.getNiveau4().getPoint()));
		finLabel3.setFont(new Font("DejaVu Serif", Font.BOLD, 52));
		finLabel3.setBounds(550, 90, 586, 145);
		finDePartie.add(finLabel3);


		JLabel finLabel4 = new JLabel(" Vous pouvez faire une nouvelle partie en quittant ou bien recommencer les niveaux ! ");
		finLabel4.setFont(new Font("DejaVu Serif", Font.BOLD, 20));
		finLabel4.setBounds(50, 250,1000, 155);
		finDePartie.add(finLabel4);

		JButton suivant = new JButton("Retour aux niveaux");
		suivant.setBounds(325, 480, 400, 61);
		suivant.setFont(new Font("DejaVu Serif",Font.ITALIC, 30));
		suivant.setBackground(new Color(51, 255, 102));
		finDePartie.add(suivant);



	 suivant.addActionListener((click)-> { jeu.selectionNiveau();});

		 return finDePartie;
	 }

	
	 public void quitterPartie() {
		 	int reply = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter le niveau ?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
			    jeu.selectionNiveau();
			}
		}

	// Permet de mettre à jour la fenêtre en fonction de la page à afficher
	public void miseAjour(JPanel p) {
	 getContentPane().removeAll();
	 getContentPane().setLayout(null);
	 setContentPane(p);
	 revalidate();
	 repaint();

 }




	// Permet de mettre à jour la fenêtre en fonction du niveau à afficher
	public void  miseAjour() {
	 getContentPane().removeAll();
	 getContentPane().setLayout(null);
	 niveauPanel = new JPanelWithBackground("icon/FondDecran.jpg");
	 niveauPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	 niveauPanel.setLayout(null);
	 JButton aide = new JButton("aide");
	 JButton retourNiveau = new JButton("quitter");
	 JButton bot = new JButton("bot");
	 aide.setBackground(new Color(20, 220, 190));
	 aide.setBounds(820,150, 173, 61);
	 retourNiveau.setBackground(new Color(240, 100, 102));
	 retourNiveau.setBounds(820,310, 173, 61);
	 bot.setBackground(new Color(20, 220, 190));
	 bot.setBounds(820,230, 173, 61);

	 niveauPanel.add(aide);
	 niveauPanel.add(bot);
	 niveauPanel.add(retourNiveau);
	 

	 aide.addActionListener((click)-> {jeu.meilleurCoup();
	 									mettreajour();});
	 retourNiveau.addActionListener((click)-> { quitterPartie();});
	 bot.addActionListener((click)-> { affichePartieBot();});

	 niveauPanel.add(getScore());
	 niveauPanel.add(getAnimaux());
	 niveauPanel.add(getNiveau());
	 setContentPane(niveauPanel);
	 revalidate();
	 repaint();
 }



 //on met à jour l'affichage du plateau apres chaque coup
 public void mettreajour() {
		pageNiveau.removeAll();
		placementCube();
		score.setText("Score:"+p1.getPoint());
		animauxSauve.setText("Animaux sauvés:"+p1.getCpmtAnimal()+"/"+p1.getAnimaux());
		if(p1.partieGagne()) {
			miseAjour(getFinNiveau(p1));
		}
			revalidate();
			repaint();
	}




 //Cette  fonction permet d'affchier tout les coups effectués par le robot
 public void affichePartieBot() {

	 robot =  Executors.newSingleThreadScheduledExecutor();
	 isLaunched = true;

		final Runnable task = new Runnable() {
		  @Override
		  public void run() {
		      jeu.botPartie();
			  mettreajour();
			  try {
				  TimeUnit.MILLISECONDS.sleep(600);

			  } catch (InterruptedException e) {
				  e.printStackTrace();
			  }

		  }
		 };

		     robot.scheduleAtFixedRate(task, 1, 10, TimeUnit.MILLISECONDS);

	 }

	///////////////////////////////////////////// CLASSES INTERNES D'AFFICHAGE /////////////////////////////////////////////////

 
 	//Cette classe permet de créer un cube qui est un JPanel  avec un image passée en paramètre 
	private class Cube extends JPanel implements MouseInputListener,Serializable{



		ImageIcon image;
		 Image imagepaint;

		int x,y;
		Cube(int x, int y, ImageIcon image){
			this.x = x;
			this.y = y;
			this.image = image;
			if(image == null) System.out.println("Null");
			this.imagepaint = image.getImage();
			setBackground(Color.white);
	        this.addMouseListener(this);
	        this.addMouseMotionListener(this);

		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics  g2= (Graphics2D)g;
			g2.drawImage(imagepaint, 0, 0,imagepaint.getWidth(null), imagepaint.getHeight(null), this);
			repaint();
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {

				jeu.partie(x,y);
				mettreajour();
				revalidate();
				repaint();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}



   //Permet de créer un panel avec une image de fond
	private  class JPanelWithBackground extends JPanel implements Serializable {

		transient private BufferedImage backgroundImage;
		  ImageIcon imic;

		  public JPanelWithBackground(String fileName)  {

			   imic = new ImageIcon(fileName);
		       backgroundImage= new BufferedImage(imic.getIconWidth(),imic.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
		       Graphics2D gg = backgroundImage.createGraphics();
		       gg.drawImage(imic.getImage(),0,0,imic.getImageObserver());

		  }

		  @Override
		  public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    g.drawImage(backgroundImage, 0 , 0 , this.getWidth() , this.getHeight(), this);
		  }
		}



}
