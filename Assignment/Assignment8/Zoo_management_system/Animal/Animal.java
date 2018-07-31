package Animal;

import java.util.List;

import Zoo.Zoo;

public class Animal {

	
	public String animalId;
	static List<Animal> animalList;
	static List<Lion> mammalAnimalList;
	static List<Crocodile> reptileAnimalList;
	static List<Peacock> birdAnimalList;

	public Animal() {
		animalList = Zoo.setAnimal();
		mammalAnimalList = Zoo.setMammalAnimalList();
		reptileAnimalList = Zoo.setReptileAnimalList();
		birdAnimalList = Zoo.setBirdAnimalList();

	}

	public Animal(String animalId) {
		this.animalId = animalId;
	}

}
