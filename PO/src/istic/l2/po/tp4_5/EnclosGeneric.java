package istic.l2.po.tp4_5;

import istic.l2.po.tp4_5.animal.Animal;

//EnclosGeneric est un type générique n'acceptant pour type en paramètre que les classes héritantes de Animal
public class EnclosGeneric<T extends Animal> {

	private Animal[] enclos = new Animal[5];
	private int nbr = 0;
	
	@SafeVarargs
	public <E extends T> EnclosGeneric(E... animals) {
		addAnimal(animals);
	}

	@SuppressWarnings("unchecked")
	public <E extends T> void addAnimal(E... animals) {
		int nbrTemp = nbr;
		if(animals.length + nbr >= enclos.length) 
			System.out.println("Vous avez ajouté plus d'animaux qu'il n'y a de places dans votre zoo !");
		for(int i = nbrTemp; i < animals.length; i++) {
			enclos[i] = animals[i - nbrTemp];
			nbr++;
		}
	}
	
	@SuppressWarnings("unchecked")
	public <E extends T> E[] getAnimals() {
		return (E[]) enclos;
	}
	
}
