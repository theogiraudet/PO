package istic.l2.po.tp4_5.animal;

public abstract class Animal {
	
	private String name;
	private int age;
	private int longevity;
	private String species;
	private String family;
	private Animal parent;
	
	
	protected Animal(String name, int age, String species, String family, int longevity) {
		this(name, age, null, species, family, age);
	}
	
	protected Animal(String name, int age, Animal parent, String species, String family, int longevity) {
		this.species = species;
		this.parent = parent;
		this.longevity = longevity;
		this.name = name;
		this.family = family;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void incrementAge(int age) {
		age++;
	}
	
	public String toString() {
		return name + " est un " + getSpecies() + " (" + getFamily() + ") de " + age + " an" + ((age > 1) ? 's' : "") + ". " + ((getParent() != null) ? getParent().getName() + " est l'un de ses parents." : "");
	}
	
	public int getLongevity() {
		return longevity;
	}
	
	public String getSpecies() {
		return species;
	}
	
	public String getFamily() {
		return family;
	}
	
	public Animal getParent() {
		return parent;
	}
}