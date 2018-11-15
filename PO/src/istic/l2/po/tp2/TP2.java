package istic.l2.po.tp2;

import java.util.Arrays;


/**
 * @author Thomas, Théo
 * 
 * Ici nous proposons quelques alternatives plus complexes pour ceux que cela intéresse (manipulation de Flux)
 * Il en est de même pour le solveur : 
 * solve résout entièrement la grille 1 mais n'est pas capable de faire la grille 2 (je crois que c'est le style de résolution attendu lors de ce TP)
 * solve2 résout entièrement les deux grilles par backtracking, pour plus d'information, voir la JavaDoc de la méthode en question {@link #solve2(int[][])} et la page Wikipédia de BackTracking
 */
public class TP2 {

	static final int n = 3 ;		// taille des regions
	/*
	 * Terminologie
	 * 
	 * m est un plateau (de sudoku) si
	 * 	- m est un int [][] ne contenant que des entiers compris entre 0 et 9
	 * 	- m.length = n^2
	 *  - m[i].length = n^2 pour tous les i de 0 a n^2-1
	 *  
	 */
	
	/**
	 * TEST_GRID = 1 : test la grille 1
	 * TEST_GRID = 2 : test la grille 2
	 */
	private static final int TEST_GRID = 1;
	/**
	 * TEST_SOLVER = 1 : test la méthode solve
	 * TEST_SOLVER = 2 : test la méthode solve2
	 */
	private static final int TEST_SOLVER = 2;

	
	@SuppressWarnings("all")
	static void essais (String grille) {
		int[][] m = aPartirDe(grille);		
		System.out.println("Problème :\n\n" + enClair(m));
 		
		if(TEST_SOLVER == 1)
			solve(m);
		else if(TEST_SOLVER == 2)
			solve2(m);
		else {
			System.out.println("Aucune méthode de résolution sélectionnée !");
			return;
		}
		
		System.out.println("Il se peut que l'on ait avancé :\n\n" + enClair(m));
	} 	
	
	@SuppressWarnings("all")
	public static void main(String[] args) {
		String grille1 = 
			"040 001 006 \n" +
			"007 900 800 \n" +
			"190 086 074 \n" +
			"            \n" +
			"200 690 010 \n" +
			"030 405 090 \n" +
			"060 017 003 \n" +
			"            \n" +
			"910 750 042 \n" +
			"008 002 700 \n" +
			"400 300 080   " ;
		String grille2 = 
			"030 000 006 \n" +
			"000 702 300 \n" +
			"104 038 000 \n" +
			"            \n" +
			"300 020 810 \n" +
			"918 000 265 \n" +
			"062 050 007 \n" +
			"            \n" +
			"000 140 708 \n" +
			"001 209 000 \n" +
			"800 000 020   " ;
		
		if(TEST_GRID == 1)
			essais(grille1);
		else if(TEST_GRID == 2)
			essais(grille2);
		else System.out.println("Aucune grille sélectionnée !");
	}

	static String enClair (int [][] m) {
		String r = "" ;		
		for (int i = 0; i < n*n ; i++) {
			for (int j = 0; j < n*n ; j++) {
				r = r + m[i][j] + " " ;
				if (j%n == n-1) {r = r + "  ";}
			}
			if (i%n == n-1) {r = r + "\n";}
			r = r + "\n";
		}		
		r = r + " ";		
		return r;
	}
	
	static int [][] aPartirDe (String s) {
		int [][] m = new int [n*n][n*n] ;
		int k = 0 ;
		for (int i = 0; i < m.length ; i++)
			for (int j = 0; j < m[i].length ; j++) {
				while ("0123456789".indexOf(s.charAt(k))==-1) {k++;}
				m[i][j] = (int) s.charAt(k) - (int) '0';
				k++ ;
		}
		return m ;
	}	
	
	
	static boolean presentLigne (int [][] m, int v, int i) {
		for (int k = 0; k < (n * n); k++)
			if (v == m[i][k])
				return true;
		return false;
		//Autre façon :
		//return Arrays.stream(m[i]).filter(x -> x == v).findFirst().isPresent();
	}
	
	static boolean presentColonne (int [][] m, int v, int j) {
		//Conversion du tableau sous forme de flux que l'on filtre de façon à n'obtenir que la possible présence de la première occurrence de v trouvée.
		return Arrays.stream(m).filter(x -> x[j] == v).findFirst().isPresent();
		//Autre façon :
		/*
		 * for(int l = 0; l < (n * n); l++)
		*	if(v == m[l][j])
		*		return true;
		*return false ;
		*/
	}
	
	static boolean presentRegion  (int [][] m, int v, int i, int j) {
		int xRegion = i / n * n;
		int yRegion = j / n * n;
		for(int index1 = xRegion; index1 < xRegion + n; index1++)
			for(int index2 = yRegion; index2 < yRegion + n; index2++)
				if(m[index1][index2] == v)
					return true;
		return false;
	}
	
	static boolean [] lesPossiblesEn (int [][] m, int i, int j) {
		boolean[] possibilities = new boolean[n * n + 1]; // + 1 pour ne pas oublier 0
		for(int index = 1; index < possibilities.length; index++)
			possibilities[index] = !(presentLigne(m, index, i) || presentColonne(m, index, j) || presentRegion(m, index, i, j));
		return possibilities;
	}
	
	static String enClair (boolean[] t) {
		String r = "{" ;
		for (int i = 1; i < t.length; i++) {
			if (t[i]) {r = r + i + ", " ; }
		}
		if (r.length() != 1) r = r.substring(0, r.length()-2); //String.substring de paramètre int a, b permet d'obtenir la sous-chaîne du String comprise entre [a; b[ 
		return r + "}" ;
	}
	
	static int toutSeul (int [][] m, int i, int j) {
		boolean[] possibilities = lesPossiblesEn(m, i, j);
		int v = -1;
		for(int index = 0; index < possibilities.length; index++) {
			if(v == -1 &&  possibilities[index])
				v = index;
			else if(possibilities[index])
				return -1;
		}
		return v;
	}
	
	/**
	 * Résout partiellement la grille passée en paramètre jusqu'à ce que plus aucune case vide n'ait qu'une seule valeur possible.
	 * @param grid une matrice représentant une grille de sudoku valide.
	 */
	public static void solve(int[][] grid) {
		boolean hasModified = false;
		do {
			hasModified = false;
			for(int i = 0; i < n * n; i++) {
				for(int j = 0; j < n * n; j++) {
					if(grid[i][j] == 0) {
						int value = toutSeul(grid, i, j);
						grid[i][j] = (value != -1) ? value : grid[i][j];
						if(value != -1) hasModified = true;
					}
				}
			}
		} while(hasModified);
	}
	
	/**
	 * @param m une matrice représentant une grille de sudoku valide.
	 * @param x la position en X où débutera la résolution. x doit être compris en 0 et N²-1. 
	 * @param y la position en Y où débutera la résolution. y doit être compris en 0 et N²-1.
	 * @return si une seule valeur est possible à cette position, la dite valeur.
	 * 		   <br/>si plusieurs valeurs sont possibles à cette position, -1.
	 * 		   <br/>si aucune valeur n'est possible à cette position, 0.
	 */
	static int canSetOneValue(int [][] m, int x, int y) {
		boolean[] possibilities = lesPossiblesEn(m, x, y);
		int v = -1;
		for(int index = 0; index < possibilities.length; index++) {
			if(v == -1 &&  possibilities[index])
				v = index;
			else if(possibilities[index])
				return -1;
		}
		return (v == -1) ? 0 : v;
	}
	
	/**Résout la grille de sudoku en se basant entièrement sur du backtracking.
	 * @param m une matrice réprésentant une grille de sudoku valide.
	 * @return vrai si le sudoku est résolu.
	 * Cette fonction est la plus optimisée proposée mais n'utilise que peu les fonctions réalisées lors du TP.
	 */
	public static boolean solve2(int[][] m) {
		for(int x = 0; x < n * n; x++)
			for(int y = 0; y < n * n; y++)
				if(m[x][y] == 0) {
					boolean[] possibilities = lesPossiblesEn(m, x, y);
					for(int i = 1; i < possibilities.length; i++)
						if(possibilities[i]) {
							m[x][y] = i;
							if(!solve2(m)) //Si solve3 renvoit false, c'est que la grille est incohérente avec la valeur de m[x][y] trouvée, donc on vide la case afin de trouver une nouvelle valeur possible
								m[x][y] = 0;
							else 
								return true; //Sinon la grille était cohérente
						}
					return false; //Grille incohérente
				}
		return true; //Grille cohérente avec la valeur de m[x][y] trouvée
	}
		
	//TODO Question 5
	/*
	 * Il suffirait de modifier seulement deux lignes de tout le programme afin de modifier la taille de la grille :
	   - La ligne 13 afin d'y modifier la taille des régions : static final int n = 3 ;
	   - La ligne 43 afin d'y ajouter les nouveaux caractères
	   Le problème de cela étant que la grille ne soit pas une grille de caractères mais d'entiers, il faudrait donc y insérer 
	   dans "0123456789" les caractères que l'on souhaite, et saisir dans la grille 
	   le code décimal de ce dernier (relatif à la table ASCII) - 48 (position de '0' dans la table).
	   L'autre solution serait d'en faire un tableau de char et ainsi de remplacer tout les "int" relatif à un élément du tableau
	   par "char" dans tout le code. 
	 */
	
	
}
