package istic.l2.po.tp4_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import istic.l2.po.tp4_5.animal.Animal;
import istic.l2.po.tp4_5.animal.oiseau.Oiseau;

public class Zoo {

	private Animal[] zoo;
	private String name;
	private int nbAnimal = 0;
	
	public Animal[] getZoo() {
		return zoo;
	}
	/*Animal... signifie que le constructeur prend un tableau d'animaux. La différence avec Animal[] est que
	 * le tableau peut être spécifié en énumérant simplement les instances à y ajouter, exemple :
	 * new Zoo("Zoo", 10 instance1, instance2, instance3, instance4);
	 */
	public Zoo(String name, int size, Animal... animals) {
		this.setName(name);
		zoo = new Animal[size];
		ajouterAnimal(this, animals);
	}

	public int getNbAnimal() {
		return nbAnimal;
	}

	public void setNbAnimal(int nbAnimal) {
		this.nbAnimal = nbAnimal;
	}
	
	public void ajouterAnimal(Zoo z, Animal... animals) {
		int nb = z.nbAnimal;
		if(animals.length + nb > z.zoo.length) throw new ArrayIndexOutOfBoundsException("Vous avez ajouté plus d'animaux qu'il n'y a de places dans votre zoo !");
		for(int i = nb; i < nb + animals.length; i++) {
			if(animals[i - nb] != null) {
				z.zoo[i] = animals[i - nb];
				z.nbAnimal++;
			}
		}
	}
	
	public void supprimerAnimal(Zoo z, Animal... animals) {
		ArrayList<Animal> list = new ArrayList<>(Arrays.asList(z.zoo));
		list.removeAll(new ArrayList<>(Arrays.asList(animals)));
		z.zoo = list.toArray(new Animal[z.zoo.length]);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		String desc = name + " possède " + getNbAnimal() + " animaux sur " + zoo.length + " :\n";
		for(int i = 0; i < nbAnimal; i++)
			desc += zoo[i].toString() + '\n';
		return desc;
	}
	
	public Animal doyen() {
		Animal older = zoo[0];
		for(int i = 1; i < nbAnimal; i++)
			if(zoo[i].getAge() > older.getAge()) older = zoo[i];
		return older;
	}
	
	public int ageMoyen() {
		int sum = 0;
		for(int i = 0; i < nbAnimal; i++)
			sum += zoo[i].getAge();
		return sum / nbAnimal;
	}
	
	//Une autre alternative utilisant une liste est disponible sous cette méthode.
	public Animal[] enfants() {
		Animal[] children = new Animal[nbAnimal];
		int count = 0;
		for(int i = 0; i < nbAnimal; i++)
			if(zoo[i].getAge() <= 25 * zoo[i].getLongevity() / 100)
				children[count++] = zoo[i];
		return Arrays.copyOf(children, count);
	}
	/*
	public ArrayList<Animal> enfants() {
		ArrayList<Animal> array = new ArrayList<>();
		for(int i = 0; i < nbAnimal; i++)
			if(zoo[i].getAge() <= 25 * zoo[i].getLongevity() / 100)
				array.add(zoo[i]);
		return array;
	}*/
	
	public void creerSpectacle() {
		Oiseau b = Oiseau.trouverOiseauLeMoinsFatiguer(zoo);
		b.incrementNbParticipate();
		System.out.println(b.getName() + " participera au spectacle.");
	}
	
	//Une version faite avec une HashMap est présenté plus bas
	public String getSpeciesMostRepresented() {
		String[][] table = new String[9][2];
		for(int i = 0; i < nbAnimal; i++)
			for(int j = 0; j < table.length; j++) {
				if(zoo[i].getSpecies().equals(table[j][0])) {
					table[j][1] = Integer.toString(Integer.valueOf(table[j][1]) + 1);
					break;
				} else if(table[j][0] == null) {
					table[j][0] = zoo[i].getSpecies();
					table[j][1] = "1";
					break;
				}
			}
		String name = "";
		int count = 0;
		for(String[] s : table)
			if(Integer.valueOf(s[1]) > count) {
				count = Integer.valueOf(s[1]);
				name = s[0];
			}
		return name;
	}
	
	/*public String getSpeciesMostRepresented() {
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < nbAnimal; i++)
			map.put(zoo[i].getSpecies(), map.getOrDefault(zoo[i].getSpecies(), 0) + 1);
		return getBiggest(map);
	}*/
	
	//Une version faite avec une HashMap est présenté plus bas
	public String getFamilyMostRepresented() {
		String[][] table = new String[3][2];
		for(int i = 0; i < nbAnimal; i++)
			for(int j = 0; j < table.length; j++) {
				if(zoo[i].getFamily().equals(table[j][0])) {
					table[j][1] = Integer.toString(Integer.valueOf(table[j][1]) + 1);
					break;
				} else if(table[j][0] == null) {
					table[j][0] = zoo[i].getFamily();
					table[j][1] = "1";
					break;
				}
			}
		String name = "";
		int count = 0;
		for(String[] s : table)
			if(Integer.valueOf(s[1]) > count) {
				count = Integer.valueOf(s[1]);
				name = s[0];
			}
		return name;
	}
	
	/*
	public String getFamilyMostRepresented(Zoo z) {
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < z.nbAnimal; i++)
			map.put(zoo[i].getFamily(), map.getOrDefault(zoo[i].getFamily(), 0) + 1);
		return getBiggest(map);
	}*/
	
	/**
	 * @param map une HashMap
	 * @return la clé ayant la plus grande valeur de la Map
	 * Ne sert que pour getFamilyMostRepresented et getSpeciesMostRepresented fonctionnant par une HashMap
	 */
	@SuppressWarnings("unused")
	private String getBiggest(HashMap<String, Integer> map) {
		String name = "";
		int value = 0;
		for(Entry<String, Integer> entry : map.entrySet())
			if(value < entry.getValue()) {
				name = entry.getKey();
				value = entry.getValue();
			}
		return name;
	}
}
