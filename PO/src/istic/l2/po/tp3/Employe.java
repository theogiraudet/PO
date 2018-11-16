package istic.l2.po.tp3;

/**
 * Une classe abstraite ne sert que pour l'héritage, elle ne peut donc être intanciée. Elle permet entre autre de définir
 * des attributs et des membres généraux qui n'auront donc pas à être implémentée (ou qui seront obligatoirement implémentée dans le cas d'une méthode abstraite)
 * par les classes filles.
 * Toutes les instances des classes héritantes d'une classe peuvent être regroupée dans une liste (ou un tableau...) typé par la classe mère. 
 * @author Théo
 */
public abstract class Employe {
	
	private String name;
	protected double fixedSum;
	
	public Employe(String name) {
		//Appel du second constructeur
		this(name, 0);
	}
	
	public Employe(String name, int fixedSum) {
		/*Le this est obligatoire s'il y a ambiguïté sur les noms de variables, en effet, 
	 	 *une variable locale et un attribut peuvent avoir le même nom (contrairement à deux locales), Java prendra donc par défaut pour "name"
		 *la variable la plus locale.
	     *Afin de distinguer l'attribut de la locale, on préfixe le nom de "this." (signifiant donc l'attribut de cette instance).*/
		this.name = name;
		this.fixedSum = fixedSum;
	}
	
	public String getName() {
		return name;
	}
	
	public double getFixedSum() {
		return fixedSum;
	}
	
	public abstract double getSalary();
	
	public String toString() {
		return name + " gagne " + getSalary() + "€";
	}
}
