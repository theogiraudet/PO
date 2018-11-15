package istic.l2.po.tp1;


/**
 * 
 * @author Théo
 *
 */
public class TP1 {
	
	//Changer cette valeur de 1 à 3 pour afficher le résultat de l'exercice en question
	final static int EXERCICE = 0;
	
	public static void main(String... args) {
		switch(EXERCICE) {
		case 1:
			initCompteMal(false);
			break;
		case 2:
			testBench2();
			System.out.println(indiceDe("bon", "bnjour, bonsoir"));
			break;
		case 3:
			drawPyramid();
			break;
		default:
			System.out.println("Veuillez choisir un exercice.");
		}
	}

	//Exercice 1
	public static int compteMal(int n) {
		int compteur = 0;
		for(int i = 0; i < n; i++)
			compteur += compteur + 1;
		return compteur;
	}
	
	private static int compteBien(int n) {
		int compteur = 0;
		for(int i = 0; i < n; i++) 
			compteur += i;
		return compteur;
	}
	
	/**Initialise et appelle les méthodes de l'exercice 1.<br/> 
	 * Cette fonction contient le contenu de la méthode <b>main</b> présentée dans le TP. 
	 * @param compteMal un boolean, si vrai, appelle la méthode qui compte mal, sinon appelle celle qui compte bien
	 */
	public static void initCompteMal(boolean compteMal) {
		int n = 5;
		int resultat = (compteMal) ? compteMal(n) : compteBien(n);
		System.out.println("La somme des " + n + " premiers entiers est " + resultat + " ?");
	}
	
	//Exercice 2
	public static boolean estPresentEn(int k, String s1, String s) {
		if(s1.length() + k >= s.length()) //Si s1 est plus grand que la sous-chaîne a testé, alors s ne peut contenir s1
			return false;
		for(int i = k; i < k + s1.length(); i++) //Parcours de s à partir de k puis comparaison caractère à caractère avec s1
				if(s1.charAt(i - k) != s.charAt(i))
					return false;
		return true;
		/*Alternative de code (première condition à garder) :
		 *s1.substring(i, i + s.length()).equals(s);*/
	}
	
	/**
	 * Question 3, voir {@link java.lang.String#charAt(int)}
	 */
	public static int indiceDe(String s1, String s) {
		for(int i = 0; i < s.length() - s1.length(); i++)
			if(estPresentEn(i, s1, s)) return i;
		return -1;
	}
	
	public static void testBench2() {
		boolean b = true;
		b &= estPresentEn(0, "bon", "bonjour bonsoir") == true;
		b &= estPresentEn(5, "bon", "bonjour bonsoir") == false;
		b &= estPresentEn(8, "bon", "bonjour bonsoir") == true;
		b &= estPresentEn(56, "bon", "bonjour bonsoir") == false;
		b &= indiceDe("bon", "bonjour bonsoir") == 0;
		b &= indiceDe("bon", "bnjour bonsoir") == 7;
		b &= indiceDe("bon", "bnjour bnsoir") == -1;
		b &= indiceDe("bon", "") == -1;
		System.out.println(b);
	}
	
	//Exercice 3
	public static void drawPyramid() {
		for(int i = 9; i > 0; i--)
			for(int j = i; j > 0; j--)
				StdDraw.circle(0.1 * (9 - i) + 0.1, 0.1 * (9 - j) + 0.1,  0.05);
	}
}
