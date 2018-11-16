package istic.l2.po.tp4_5.animal.oiseau;

import istic.l2.po.tp4_5.animal.Animal;

public abstract class Oiseau extends Animal {
	
	private int nbParticipate = 0;
	
	protected Oiseau(String name, int age, String species, int longevity) {
		this(name, age, null, species, longevity);
	}
	
	
	protected Oiseau(String name, int age, Oiseau parent, String species, int longevity) {
		super(name, age, parent, species, "oiseau", longevity);
	}
	
	public String toString() {
		return super.toString() + "Il a participé à " + nbParticipate + " spectacle" + ((nbParticipate > 1) ? "s." : '.');
	}

	public int getNbParticipate() {
		return nbParticipate;
	}

	public void incrementNbParticipate() {
		nbParticipate++;
	}
	
	public static Oiseau trouverOiseauLeMoinsFatiguer(Animal[] z) {
		Oiseau b = null;
		for(Animal a : z)
			if(a instanceof Oiseau && (b == null || ((Oiseau) a).getNbParticipate() < b.getNbParticipate()))
				b = (Oiseau)a;
		return b;
	}
}