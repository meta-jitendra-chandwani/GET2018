package Zoo;

import java.util.ArrayList;
import java.util.List;

import Zone.Zone;
import Zone._ZoneEnum_;
import Animal.Animal;
import Animal.BirdAnimal;
import Animal.MammalAnimal;
import Animal.ReptileAnimal;

public class Zoo {
	static List<Animal> animalList = new ArrayList<Animal>();
	static List<MammalAnimal> mammalAnimalList = new ArrayList<MammalAnimal>();
	static List<BirdAnimal> birdAnimalList = new ArrayList<BirdAnimal>();
	static List<ReptileAnimal> reptileAnimalList = new ArrayList<ReptileAnimal>();

	void addAnimal(String Category, String Name, int Age) {
		if ("mammal".equals(Category)) {
			mammalAnimalList.add(new MammalAnimal(Category, Name, Age));
			animalList.add(new MammalAnimal(Category, Name, Age));		
			new Zone(_ZoneEnum_.Zone1);
		} else if ("bird".equals(Category)) {
			birdAnimalList.add(new BirdAnimal(Category, Name, Age));
			animalList.add(new BirdAnimal(Category, Name, Age));		
			new Zone(_ZoneEnum_.Zone2);
		} else if ("reptile".equals(Category)) {
			reptileAnimalList.add(new ReptileAnimal(Category, Name, Age));
			animalList.add(new ReptileAnimal(Category, Name, Age));		
			new Zone(_ZoneEnum_.Zone3);
		}
		
	}

	public static List<MammalAnimal> setMammalAnimalList() {
		return mammalAnimalList;
	}

	public static List<ReptileAnimal> setReptileAnimalList() {
		return reptileAnimalList;
	}

	public static List<BirdAnimal> setBirdAnimalList() {
		return birdAnimalList;
	}

	public static List<Animal> setAnimal() {
		
		return animalList;
	}

	void removeAnimal(String Category, String Name) {
		// if ("mammal".equals(Category)) {
		// mammalAnimalList.remove();
		// } else if ("bird".equals(Category)) {
		// birdAnimalList.add(new BirdAnimal(Category, Name, Age));
		// } else if ("reptile".equals(Category)) {
		// reptileAnimalList.add(new ReptileAnimal(Category, Name, Age));
		// }
	}

	boolean moveZone(String animal, int currentZone, int movedZone) {
		// check compatibilty
		// availabilty of space
		return true;
	}

	boolean moveCage(String animal, _ZoneEnum_ currentZone,
			_ZoneEnum_ moveToZone) {
		// if(moveZone(animal, currentZone, movedZone))
		return true;
	}

	public static void main(String arg[]) {
		Zoo zoo = new Zoo();

		zoo.addAnimal("mammal", "Lion1", 10);
		zoo.addAnimal("mammal", "Lion2", 10);
		zoo.addAnimal("mammal", "Lion3", 10);
		zoo.addAnimal("mammal", "Lion4", 10);
		zoo.addAnimal("mammal", "Lion5", 6);

		zoo.addAnimal("reptile", "Croodile1", 5);
		zoo.addAnimal("reptile", "Croodile2", 5);
		zoo.addAnimal("reptile", "Croodile3", 5);
		zoo.addAnimal("reptile", "Croodile4", 5);
		zoo.addAnimal("reptile", "Croodile5", 5);
		
		for(int i=0;i<animalList.size();i++){
			System.out.println(animalList.get(i).Name);

		}
		
//		System.out.println(animalList.get(0).Category);

		// zoo.moveCage("mammal cage1", _ZoneEnum_.Zone1, _ZoneEnum_.Zone3);
	}

}
