package javaIPImai2019JeuMemory;

//vue

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Deque;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;



public class CarteApp extends FrameForDemoMaker {
	
	EtatMemoire etatMemoire = new EtatMemoire();

	private static final int COLUMN_COUNT = 6;
	private static final int ROW_COUNT = 4;
	private Jeu jeu =  new Jeu();
	private ImageIcon dosCarte = ResourceUtility.loadImage("images/dos.png");

	public CarteApp() throws IOException{
		super("Mémoire");
		setDefaultBounds(100,100,900,600);
	}

	@Override
	public void init(JFrame frame) {
		Container cp = frame.getContentPane();

		cp.setLayout(new GridLayout(ROW_COUNT, COLUMN_COUNT));
		
		 Deque<ImageIcon> pioche = jeu.creerPioche();// ma pioche est une Deque, je vais la vider.
		 //rappel, deque = une collection qui fait que quand je fais un pop je récupère l'objet en haut de la pile
		 // et je l'enlève de la pile, c'est une pioche.
	        while(!pioche.isEmpty()) {
				cp.add(createButton(pioche.pop()));
				//pioche.pop = "récupère une image dans la pioche".
				//on passe en paramètre l'image qu'on récupéré de la pioche.
	        }
		
	}
	
     //Créer la méthode createButton(...) dont le paramètre est la pioche afin que chaque bouton affiche la face visible d’une des figures de la pioche.
	public JComponent createButton(ImageIcon imageIcon) { //on veut créer un bouton et lui mettre l'image icone qui est dans la pioche
		
		
		/*Tout JComponent peut stocker des propriétés.

		Deux méthodes permettent de modifier et récupérer des valeurs, comme dans une HashMap.
		
		public void putClientProperty(String key, Object value)
		public Object getClientProperty(String key)
		 * 		
		 */
		
		
		/*
		 * Le JToggleButton possède un intérêt ici: on peut lui assigner une icône différente en fonction de son état.

			Les états qui nous intéressent ici sont:
			
			non sélectionné : carte de dos (c’est l’état par défaut du bouton);
			sélectionné : carte retournée et visible;
			désactivé : la carte et son double ont été trouvé
		 * 
		 * 
		 * */
		JToggleButton button1 = new JToggleButton(dosCarte);//Le JToggleButton possède un intérêt ici: 
		//on peut lui assigner une icône différente en fonction de son état.
		button1.setSelectedIcon(imageIcon);
		button1.setDisabledIcon(imageIcon);
		button1.setDisabledSelectedIcon(imageIcon);
		button1.putClientProperty ("carte",imageIcon.getDescription());
		
		
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			  public void actionPerformed(ActionEvent e) {
			    System.out.println(button1.getClientProperty("carte"));
			    etatMemoire.nouveauBoutonSelectionne(button1);
			  }
			
		});
		return button1;
	}

	public static void main(String[] args) throws IOException {
		CarteApp example = new CarteApp();
		SwingUtilities.invokeLater(example);
		
		
	}
}