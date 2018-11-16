package istic.l2.po.tp4_5.animal.cervide;

public class Daim extends Cervide {
	
	public Daim(String name, int age) {
		this(name, age, null);
	}
	
	public Daim(String name, int age, Daim parent) {
		super(name, age, parent, "daim");
	}
}
