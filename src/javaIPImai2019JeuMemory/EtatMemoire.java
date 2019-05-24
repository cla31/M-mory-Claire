package javaIPImai2019JeuMemory;
/*
 *  gérer l’état de l’application.

	C’est-à-dire:
	
	s’assurer que seules deux cartes sont retournées à la fois
	s’assurer que les doublons trouvés restent visibles
 * 
 * 
 */


import java.util.ArrayList;
import java.util.List;

import javax.swing.JToggleButton;

public class EtatMemoire {

    private List<JToggleButton> listeBoutonsSelectionnes = new ArrayList<>(); //attribut listeBoutonsSelectionnes:c’est la liste des boutons sélectionnés. 
    //La taille de cette liste donne le nombre de cartes actuellement retournées (hormis les doublons déjà trouvés)

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
            if(listeBoutonsSelectionnes.get(0).getClientProperty("carte")
                    .equals(listeBoutonsSelectionnes.get(1).getClientProperty("carte"))) {
                //Les deux cartes sont identiques:
                //on les désactive:
                for (JToggleButton jToggleButton : listeBoutonsSelectionnes) {
                    jToggleButton.setEnabled(false);
                }
                //Et on vide la liste (pour éviter qu'elles ne soient
                //à nouveau retournées:
                listeBoutonsSelectionnes.clear();
            }
        }
    }

    public void nouveauBoutonSelectionne(JToggleButton button) {
        //On vérifie si le bouton est déjà dans la liste
        if(!listeBoutonsSelectionnes.contains(button)) {
            //Si deux boutons sont déjà sélectionnés:
            verifierNombreCartesRetournees();
    
            //Maintenant que les autres boutons sont cachés, 
            //stocke le nouveau dans la liste
            listeBoutonsSelectionnes.add(button);
    
            //Si deux boutons sont désormais présents dans la liste, 
            //comparons-les
            verifierCartesIdentiques();
        }
        
        //il faut rajouter le nombre de coups joués depuis le début de la partie et le nombre de doublons trouvés.
    }
    
    
}
	

	


