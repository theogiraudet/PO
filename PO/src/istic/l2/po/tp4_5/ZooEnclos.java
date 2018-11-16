package istic.l2.po.tp4_5;

import istic.l2.po.tp4_5.animal.Animal;

//Une version utilisant la généricité est aussi disponible : ZooEnclosGeneric
public class ZooEnclos {

	Zoo z;
	private Enclos[] enclos;
	int nbr = 0;
	
	public ZooEnclos(String name, int size) {
		z = new Zoo(name, size * 5);
		enclos = new Enclos[size];
	}
	
	public void addEnclos(Enclos... enclos) {
		if(enclos.length + nbr > this.enclos.length) 
			System.out.println("Vous avez ajouté plus d'enclos qu'il n'y a de places dans votre zoo !");
		for(int i = nbr; i < this.enclos.length; i++) {
			this.enclos[i] = enclos[i - nbr];
			nbr++;
		}
		for(Enclos en : enclos)
				z.ajouterAnimal(z, en.getAnimals());
	}
	
	public String getName() {
		return z.getName();
	}
	
	public void setName(String name) {
		z.setName(name);
	}
	
	public int getNbAnimal() {
		return z.getNbAnimal();
	}
	
	public Animal getOlder() {
		return z.doyen();
	}
	
	public int getMoyAge() {
		return z.ageMoyen();
	}
	
	public Animal[] getChildren() {
		return z.enfants();
	}
	
	public void createSpectacle() {
		z.creerSpectacle();
	}
	
	public String getSpeciesMostRepresented() {
		return z.getSpeciesMostRepresented();
	}
	
	public String getFamillyMostRepresented() {
		return z.getFamilyMostRepresented();
	}	
	
	public String toString() {
		return z.toString();
	}
}
