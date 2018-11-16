package istic.l2.po.tp4_5.animal.cervide;

import istic.l2.po.tp4_5.animal.Animal;

public abstract class Cervide extends Animal {
	
	protected Cervide(String name, int age, String species) {
		this(name, age, null, species);
	}
	
	protected Cervide(String name, int age, Animal parent, String species) {
		super(name, age, parent, species, "cervidé", 20);
	}
}
