package Zoo;

import java.util.ArrayList;
import java.util.List;

import Zone.Zone;
import Zone._ZoneEnum_;
import Animal.Animal;
import Animal.BirdAnimal;
import Animal.MammalAnimal;
import Animal.ReptileAnimal;
import Cage.Cage;

public class Zoo {
	static List<Animal> animalList = new ArrayList<Animal>();
	static List<MammalAnimal> mammalAnimalList = new ArrayList<MammalAnimal>();
	static List<BirdAnimal> birdAnimalList = new ArrayList<BirdAnimal>();
	static List<ReptileAnimal> reptileAnimalList = new ArrayList<ReptileAnimal>();
	Zone mammalZone, birdZone, reptileZone;
	List<Zone> zoneList = new ArrayList<Zone>();
	List<Cage> mammalCageList = new ArrayList<Cage>();
	List<Cage> birdCageList = new ArrayList<Cage>();
	List<Cage> reptileCageList = new ArrayList<Cage>();

	void addAnimal(String Category, String Name, int Age, String animalId) {
		if (mammalCageList.size() == 0 && "mammal".equals(Category)) {

			mammalZone = new Zone(_ZoneEnum_.Zone1);
			mammalCageList = mammalZone.setMammalCageList();
			zoneList.add(mammalZone);
			System.out.println("\n====  Zone 1 is created for mammals ===");
			mammalZone.addCage();

			mammalAnimalList
					.add(new MammalAnimal(Category, Name, Age, animalId));
			animalList.add(new MammalAnimal(Category, Name, Age, animalId));
			mammalZone.addAnimalInZone("mammal");

		} else if (birdCageList.size() == 0 && "bird".equals(Category)) {

			birdZone = new Zone(_ZoneEnum_.Zone2);
			birdCageList = birdZone.setBirdCageList();
			zoneList.add(birdZone);
			System.out.println("\n====  Zone 2 is created for bird ===");
			birdZone.addCage();

			birdAnimalList.add(new BirdAnimal(Category, Name, Age, animalId));
			animalList.add(new BirdAnimal(Category, Name, Age, animalId));
			birdZone.addAnimalInZone("bird");

		}

		else if (reptileCageList.size() == 0 && "reptile".equals(Category)) {
			reptileZone = new Zone(_ZoneEnum_.Zone3);
			reptileCageList = reptileZone.setReptileCageList();
			zoneList.add(reptileZone);
			System.out.println("\n====  Zone 3 is created for reptile ===");
			reptileZone.addCage();

			reptileAnimalList.add(new ReptileAnimal(Category, Name, Age,
					animalId));
			animalList.add(new ReptileAnimal(Category, Name, Age, animalId));
			reptileZone.addAnimalInZone("reptile");

		} else {

			if ("mammal".equals(Category)) {
				mammalAnimalList.add(new MammalAnimal(Category, Name, Age,
						animalId));
				animalList.add(new MammalAnimal(Category, Name, Age, animalId));
				mammalZone.addAnimalInZone("mammal");
			}

			else if ("bird".equals(Category)) {
				birdAnimalList
						.add(new BirdAnimal(Category, Name, Age, animalId));
				animalList.add(new BirdAnimal(Category, Name, Age, animalId));
				birdZone.addAnimalInZone("bird");
			}

			else if ("reptile".equals(Category)) {
				reptileAnimalList.add(new ReptileAnimal(Category, Name, Age,
						animalId));
				animalList
						.add(new ReptileAnimal(Category, Name, Age, animalId));
				reptileZone.addAnimalInZone("reptile");
			}

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

	void removeAnimal(String animalId) {
//		animalList.remove(animalList.get(animalId);
		
	}

	public static void main(String arg[]) {
		Zoo zoo = new Zoo();
		int id=0;
		zoo.addAnimal("mammal", "Lion1", 10,"Mammal"+(++id));
		zoo.addAnimal("mammal", "Lion2", 10,"Mammal"+(++id));
		zoo.addAnimal("mammal", "Lion3", 10,"Mammal"+(++id));
		zoo.addAnimal("mammal", "Lion4", 10,"Mammal"+(++id));
		zoo.addAnimal("mammal", "Lion5", 6,"Mammal"+(++id));
		zoo.addAnimal("mammal", "Lion6", 10,"Mammal"+(++id));
		zoo.addAnimal("mammal", "Lion7", 6,"Mammal"+(++id));
		zoo.addAnimal("mammal", "Lion8", 10,"Mammal"+(++id));

		zoo.addAnimal("reptile", "Crocodile1", 6,"Reptile"+(++id));
		zoo.addAnimal("reptile", "Crocodile2", 10,"Reptile"+(++id));
		zoo.addAnimal("reptile", "Crocodile3", 6,"Reptile"+(++id));
		zoo.addAnimal("reptile", "Crocodile4", 10,"Reptile"+(++id));
		zoo.addAnimal("reptile", "Crocodile5", 6,"Reptile"+(++id));
		zoo.addAnimal("reptile", "Crocodile6", 6,"Reptile"+(++id));
		zoo.addAnimal("reptile", "Crocodile7", 10,"Reptile"+(++id));
		zoo.addAnimal("reptile", "Crocodile8", 6,"Reptile"+(++id));

		zoo.addAnimal("bird", "Peacock1", 6,"Bird"+(++id));
		zoo.addAnimal("bird", "Peacock2", 10,"Bird"+(++id));
		zoo.addAnimal("bird", "Peacock3", 6,"Bird"+(++id));
		zoo.addAnimal("bird", "Peacock4", 10,"Bird"+(++id));
		zoo.addAnimal("bird", "Peacock5", 6,"Bird"+(++id));
		zoo.addAnimal("bird", "Peacock6", 6,"Bird"+(++id));
		zoo.addAnimal("bird", "Peacock7", 10,"Bird"+(++id));
		zoo.addAnimal("bird", "Peacock8", 6,"Bird"+(++id));

	}

}
