package istic.l2.po.tp4_5.animal.felin;

public class Lion extends Felin {
	
	public Lion(String name, int age) {
		this(name, age, null);
	}
	
	public Lion(String name, int age, Lion parent) {
		super(name, age, parent, "lion", 12);
	}
}
