package Animal;

import java.util.ArrayList;
import java.util.List;

import Zoo.Zoo;

public class Animal {

	public String Category;
	public String Name;
	public int Age;
	static List<Animal> animalList;
	static List<MammalAnimal> mammalAnimalList;
	static List<ReptileAnimal> reptileAnimalList;
	static List<BirdAnimal> birdAnimalList;

	public Animal() {
		animalList = Zoo.setAnimal();
		mammalAnimalList = Zoo.setMammalAnimalList();
		reptileAnimalList = Zoo.setReptileAnimalList();
		birdAnimalList = Zoo.setBirdAnimalList();
		// System.out.println("mammal in animal : ");
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion1", 10));
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion2", 10));
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion3", 10));
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion4", 10));
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion5", 10));
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion6", 10));
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion7", 10));
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion8", 10));
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion9", 10));
		// mammalAnimalList.add(new MammalAnimal("mammal", "Lion10", 10));

		// reptileAnimalList.add(new Crocodile("reptile", "Croodile1", 5));
		// reptileAnimalList.add(new Crocodile("reptile", "Croodile2", 5));
		// reptileAnimalList.add(new Crocodile("reptile", "Croodile3", 5));
		// reptileAnimalList.add(new Crocodile("reptile", "Croodile4", 5));
		// reptileAnimalList.add(new Crocodile("reptile", "Croodile5", 5));
		// reptileAnimalList.add(new Crocodile("Reptile", "Croodile6", 5));
		// reptileAnimalList.add(new Crocodile("Reptile", "Croodile7", 5));
		// reptileAnimalList.add(new Crocodile("Reptile", "Croodile8", 5));
		// reptileAnimalList.add(new Crocodile("Reptile", "Croodile9", 5));
		// reptileAnimalList.add(new Crocodile("Reptile", "Croodile10", 5));
		//
		//
		// birdAnimalList.add(new BirdAnimal("bird", "Peacock1", 5));
		// birdAnimalList.add(new BirdAnimal("bird", "Peacock2", 5));
		// birdAnimalList.add(new BirdAnimal("bird", "Peacock3", 5));
		// birdAnimalList.add(new BirdAnimal("Bird", "Peacock4", 5));
		// birdAnimalList.add(new BirdAnimal("Bird", "Peacock5", 5));
		// birdAnimalList.add(new BirdAnimal("Bird", "Peacock6", 5));
		// birdAnimalList.add(new BirdAnimal("Bird", "Peacock7", 5));
		// birdAnimalList.add(new BirdAnimal("Bird", "Peacock8", 5));
		// birdAnimalList.add(new BirdAnimal("Bird", "Peacock9", 5));
		// birdAnimalList.add(new BirdAnimal("Bird", "Peacock10", 5));
		// animalList.addAll(mammalAnimalList);
		// animalList.addAll(birdAnimalList);
		// animalList.addAll(reptileAnimalList);

	}

	// public List<Animal> getAnimalsList() {
	// return animalList;
	// }
	//
	// public List<ReptileAnimal> getReptileAnimalsList() {
	// return reptileAnimalList;
	// }
	//
	// public List<BirdAnimal> getBirdAnimalsList() {
	// return birdAnimalList;
	// }
	//
	// public List<MammalAnimal> getMammalAnimalsList() {
	// return mammalAnimalList;
	// }

	public Animal(String Category, String Name, int Age) {
		this.Category = Category;
		this.Name = Name;
		this.Age = Age;
	}

	void getInfo() {

	}

	String getCategory() {
		return "Animal";
	}

	// public static void main(String[] args) {
	// Animal animal = new Animal();
	// List<MammalAnimal> animalList = animal.getMammalAnimalsList();
	// System.out.println(animalList.get(4).Name);
	// // System.out.println("Cat eats " + cat.getEats());
	// // System.out.println("Cat has " + cat.getNoOfLegs() + " legs.");
	// // System.out.println("Cat color is " + cat.getColor());
	// }
}
