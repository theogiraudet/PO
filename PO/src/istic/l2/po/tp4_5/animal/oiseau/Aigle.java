package istic.l2.po.tp4_5.animal.oiseau;

public class Aigle extends Oiseau {
	
	public Aigle(String name, int age) {
		this(name, age, null);
	}
	
	public Aigle(String name, int age, Aigle parent) {
		super(name, age, parent, "aigle", 14);
	}
}
