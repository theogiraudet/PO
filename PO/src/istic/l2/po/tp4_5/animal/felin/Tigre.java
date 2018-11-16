package istic.l2.po.tp4_5.animal.felin;

public class Tigre extends Felin {
	
	public Tigre(String name, int age) {
		this(name, age, null);
	}
	
	public Tigre(String name, int age, Tigre parent) {
		super(name, age, parent, "tigre", 23);
	}
}
