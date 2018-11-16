package istic.l2.po.tp4_5.animal.cervide;

public class Cerf extends Cervide {
	
	public Cerf(String name, int age) {
		this(name, age, null);
	}
	
	public Cerf(String name, int age, Cerf parent) {
		super(name, age, parent, "cerf");
	}
}
