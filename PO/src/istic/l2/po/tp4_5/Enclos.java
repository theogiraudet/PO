package istic.l2.po.tp4_5;

import istic.l2.po.tp4_5.animal.Animal;

//Une version utilisant aussi la généricité est aussi disponible : EnclosGeneric
public class Enclos {

	private Animal[] enclos = new Animal[5];
	private int nbr = 0;
	private final String ANIMAL_TYPE;
	
	public Enclos(String animalType) {
		ANIMAL_TYPE = animalType;
	}

	public void addAnimal(Animal animal) {
		if(!animal.getSpecies().equals(ANIMAL_TYPE) && !animal.getFamily().equals(ANIMAL_TYPE)) 
			System.out.println("Vous ne pouvez pas mettre " + animal.getName() + " dans cet enclos !");
		else {
			if(1 + nbr >= enclos.length) 
				System.out.println("Vous avez ajouté plus d'animaux qu'il n'y a de places dans votre zoo !");
			else
				enclos[nbr++] = animal;
		}
	}
	
	public Animal[] getAnimals() {
		return enclos;
	}

	public String getAnimalType() {
		return ANIMAL_TYPE;
	}
	
}
