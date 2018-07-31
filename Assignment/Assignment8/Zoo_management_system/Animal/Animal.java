package Animal;

import java.util.List;

import Zoo.Zoo;

public class Animal {

	public String category;
	public String name;
	public int age;
	public String animalId;
	static List<Animal> animalList;
	static List<MammalAnimal> mammalAnimalList;
	static List<ReptileAnimal> reptileAnimalList;
	static List<BirdAnimal> birdAnimalList;

	public Animal() {
		animalList = Zoo.setAnimal();
		mammalAnimalList = Zoo.setMammalAnimalList();
		reptileAnimalList = Zoo.setReptileAnimalList();
		birdAnimalList = Zoo.setBirdAnimalList();

	}

	public Animal(String category, String name, int age, String animalId) {
		this.category = category;
		this.name = name;
		this.age = age;
		this.animalId = animalId;
	}

}
