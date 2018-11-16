package istic.l2.po.tp4_5.animal.cervide;

public class Elan extends Cervide {
	
	public Elan(String name, int age) {
		this(name, age, null);
	}
	
	public Elan(String name, int age, Elan parent) {
		super(name, age, parent, "élan");
	}
}
