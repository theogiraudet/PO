package istic.l2.po.tp4_5.animal.oiseau;

public class Faucon extends Oiseau {
	
	public Faucon(String name, int age) {
		this(name, age, null);
	}
	
	public Faucon(String name, int age, Faucon parent) {
		super(name, age, parent, "faucon", 13);
	}
}
