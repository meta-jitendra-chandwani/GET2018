package Animal;

import java.util.List;

/*
 * Animal Parent class
 */
public class Animal {	
	public String animalId;
	static List<Lion> mammalAnimalList;
	static List<Crocodile> reptileAnimalList;
	static List<Peacock> birdAnimalList;

	public Animal(String animalId) {
		this.animalId = animalId;
	}

}
