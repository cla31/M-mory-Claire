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
		super("M�moire");
		setDefaultBounds(100,100,900,600);
	}

	@Override
	public void init(JFrame frame) {
		Container cp = frame.getContentPane();

		cp.setLayout(new GridLayout(ROW_COUNT, COLUMN_COUNT));
		
		 Deque<ImageIcon> pioche = jeu.creerPioche();// ma pioche est une Deque, je vais la vider.
		 //rappel, deque = une collection qui fait que quand je fais un pop je r�cup�re l'objet en haut de la pile
		 // et je l'enl�ve de la pile, c'est une pioche.
	        while(!pioche.isEmpty()) {
				cp.add(createButton(pioche.pop()));
				//pioche.pop = "r�cup�re une image dans la pioche".
				//on passe en param�tre l'image qu'on r�cup�r� de la pioche.
	        }
		
	}
	
     //Cr�er la m�thode createButton(...) dont le param�tre est la pioche afin que chaque bouton affiche la face visible d�une des figures de la pioche.
	public JComponent createButton(ImageIcon imageIcon) { //on veut cr�er un bouton et lui mettre l'image icone qui est dans la pioche
		
		
		/*Tout JComponent peut stocker des propri�t�s.

		Deux m�thodes permettent de modifier et r�cup�rer des valeurs, comme dans une HashMap.
		
		public void putClientProperty(String key, Object value)
		public Object getClientProperty(String key)
		 * 		
		 */
		
		
		/*
		 * Le JToggleButton poss�de un int�r�t ici: on peut lui assigner une ic�ne diff�rente en fonction de son �tat.

			Les �tats qui nous int�ressent ici sont:
			
			non s�lectionn� : carte de dos (c�est l��tat par d�faut du bouton);
			s�lectionn� : carte retourn�e et visible;
			d�sactiv� : la carte et son double ont �t� trouv�
		 * 
		 * 
		 * */
		JToggleButton button1 = new JToggleButton(dosCarte);//Le JToggleButton poss�de un int�r�t ici: 
		//on peut lui assigner une ic�ne diff�rente en fonction de son �tat.
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