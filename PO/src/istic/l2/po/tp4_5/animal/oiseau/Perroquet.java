package istic.l2.po.tp4_5.animal.oiseau;

public class Perroquet extends Oiseau {
	
	public Perroquet(String name, int age) {
		this(name, age, null);
	}
	
	public Perroquet(String name, int age, Perroquet parent) {
		super(name, age, parent, "perroquet", 45);
	}
}
