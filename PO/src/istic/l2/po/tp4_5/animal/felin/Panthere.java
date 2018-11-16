package istic.l2.po.tp4_5.animal.felin;

public class Panthere extends Felin {
	
	public Panthere(String name, int age) {
		this(name, age, null);
	}
	
	public Panthere(String name, int age, Panthere parent) {
		super(name, age, parent, "panthère", 15);
	}
}
