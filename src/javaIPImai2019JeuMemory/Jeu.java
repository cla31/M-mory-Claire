package javaIPImai2019JeuMemory;
//cette classe a la responsabilité de charger les images et de générer une pioche aléatoire.


import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Jeu {
	private ImageIcon[][] figures = loadImages();//on stocke les images dans un attribut figures
	//on place ces images dans un tableau à 2 dimensions.
	//initialisation de l'attribut avec l'appel de la méthode qui va retourner son résultat (images).

	public Jeu() throws IOException {}


	public ImageIcon[][] loadImages() throws IOException {//méthode loadImages qui permet de charger les images.
		int rows = 4;
		int cols = 3;
		ImageIcon[][] images = ResourceUtility.splitImageIcon( // méthode qui charge les images
				//comme la méthode est static on peut l'appeler dans une autre classe, pas besoin d'en hériter 
				//(héritage sert à compléter une méthode entre autres)
				ResourceUtility.loadBufferedImage("images/butterfly2.png")
				, rows, cols);
		int index=0;
		for (int i = 0; i<rows;i++) {
			for (int j=0;j<cols; j++) {
				images[i][j].setDescription("c"+index++); // pour comparer les images 2 à 2, on leur assigne
				//une description (: c1, c2, c3 etc.) pour pouvoir les différencier facilement.

			}


		}
		return images;


	}
	
	//implémentationde créer pioche= elle permet de remplir une collection de cartes non ordonnées
	//et de renvoyer une instance de la sous-classse/sous-interface de collection (dans ce code c'est cartes).

	public Deque<ImageIcon> creerPioche(){ //on crée une pioche en prenant des figures disponibles, les unes après les autres
		//en les mettant dans une collection et ensuite en renvoyant une référence à cette collection.
		LinkedList<ImageIcon> cartes = new LinkedList <>();
		int rows = figures.length;
		int cols = figures[0].length;

		for (int i = 0; i<rows;i++) {
			for (int j=0;j<cols; j++) {
				cartes.add(figures [i][j]);
				cartes.add(figures [i][j]);
			}
		}

		Collections.shuffle(cartes); //méthode qui permet de mélanger toutes les cartes
		return cartes;



	}



	//c'est dans cette classe qu'on crée la collection
}



