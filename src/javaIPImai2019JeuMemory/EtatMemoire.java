package javaIPImai2019JeuMemory;
/*
 *  g�rer l��tat de l�application.

	C�est-�-dire:

	s�assurer que seules deux cartes sont retourn�es � la fois
	s�assurer que les doublons trouv�s restent visibles
 * 
 * 
 */



import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;



public class EtatMemoire {


	private List<JToggleButton> listeBoutonsSelectionnes = new ArrayList<>(); //attribut listeBoutonsSelectionnes:c�est la liste des boutons s�lectionn�s. 
	//La taille de cette liste donne le nombre de cartes actuellement retourn�es (hormis les doublons d�j� trouv�s)
	int nombreCoups = 0;
	int nombreDoublons = 0;
	//essai pour afficher une fen�tre si une paire est trouv�e:
	//Boolean verification = false;

	private void verifierNombreCartesRetournees() {
		if (listeBoutonsSelectionnes.size() >= 2) {
			for (JToggleButton jToggleButton : listeBoutonsSelectionnes) {
				jToggleButton.setSelected(false);
			}
			//vide la liste
			listeBoutonsSelectionnes.clear();
		}
	}
	private void verifierCartesIdentiques() {
		if (listeBoutonsSelectionnes.size() == 2) {
			nombreCoups++;
			System.out.println("coups n� "+ nombreCoups);
			if(listeBoutonsSelectionnes.get(0).getClientProperty("carte")
					.equals(listeBoutonsSelectionnes.get(1).getClientProperty("carte"))) {
				//Les deux cartes sont identiques:
				//on les d�sactive:
				for (JToggleButton jToggleButton : listeBoutonsSelectionnes) {
					jToggleButton.setEnabled(false);
				}
				//Et on vide la liste (pour �viter qu'elles ne soient
				//� nouveau retourn�es:
				listeBoutonsSelectionnes.clear();
				nombreDoublons ++;
				//essai pour afficher une fen�tre si une paire est trouv�e:
				Window fenetre = new Window();
				System.out.println(nombreDoublons);
				

			}
		}
		
		
		


	}

	public void nouveauBoutonSelectionne(JToggleButton button) {
		//On v�rifie si le bouton est d�j� dans la liste
		if(!listeBoutonsSelectionnes.contains(button)) {
			//Si deux boutons sont d�j� s�lectionn�s:
			verifierNombreCartesRetournees();

			//Maintenant que les autres boutons sont cach�s, 
			//stocke le nouveau dans la liste
			listeBoutonsSelectionnes.add(button);

			//Si deux boutons sont d�sormais pr�sents dans la liste, 
			//comparons-les
			verifierCartesIdentiques();
		}

		//il faut rajouter le nombre de coups jou�s depuis le d�but de la partie et le nombre de doublons trouv�s.
	}





}










