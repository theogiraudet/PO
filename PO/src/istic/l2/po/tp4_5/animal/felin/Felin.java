package istic.l2.po.tp4_5.animal.felin;

import istic.l2.po.tp4_5.animal.Animal;

public abstract class Felin extends Animal {
	
	protected Felin(String name, int age, String species, int longevity) {
		this(name, age, null, species, longevity);
	}
	
	protected Felin(String name, int age, Animal parent, String species, int longevity) {
		super(name, age, parent, species, "félin", longevity);
	}
}