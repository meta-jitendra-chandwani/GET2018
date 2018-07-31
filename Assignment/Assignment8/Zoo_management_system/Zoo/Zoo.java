package Zoo;

import java.util.ArrayList;
import java.util.List;

import Zone.Zone;
import Zone._ZoneEnum_;
import Animal.Animal;

import Animal.Crocodile;
import Animal.Lion;

import Animal.Peacock;

import Cage.Cage;

/*
 * Zone Class - is main class of zoo management system
 * Through which animal is add or removed from zoo.
 */
public class Zoo {
	static List<Animal> animalList = new ArrayList<Animal>();
	static List<Lion> lionAnimalList = new ArrayList<Lion>();
	static List<Peacock> peacockAnimalList = new ArrayList<Peacock>();
	static List<Crocodile> crocodileAnimalList = new ArrayList<Crocodile>();
	Zone lionZone, peacockZone, crocodileZone;
	List<Zone> zoneList = new ArrayList<Zone>();
	List<Cage> lionCageList = new ArrayList<Cage>();
	List<Cage> peacockCageList = new ArrayList<Cage>();
	List<Cage> crocodileCageList = new ArrayList<Cage>();

	/*
	 * Add animal - to add animal in zoo in their particular zone and cage.	
	 * @param category - category of animal such as Mammal, Bird or Reptile	
	 * @param name - name of animal
	 * @param age - age of animal
	 * @param animalId - unique animal id assigned to every animal
	 */
	void addAnimal(String category, String name, int age, String animalId) {
		if (lionCageList.size() == 0 && "mammal".equals(category)) {

			lionZone = new Zone(_ZoneEnum_.Zone1);
			lionCageList = lionZone.setLionCageList();
			zoneList.add(lionZone);
			System.out.println("\n====  Zone 1 is created for mammals ===");
			lionZone.addCage();

			lionAnimalList.add(new Lion(category, name, age, animalId));
			animalList.add(new Lion(category, name, age, animalId));
			lionZone.addAnimalInZone("mammal");

		} else if (peacockCageList.size() == 0 && "bird".equals(category)) {

			peacockZone = new Zone(_ZoneEnum_.Zone2);
			peacockCageList = peacockZone.setPeacockCageList();
			zoneList.add(peacockZone);
			System.out.println("\n====  Zone 2 is created for bird ===");
			peacockZone.addCage();

			peacockAnimalList.add(new Peacock(category, name, age, animalId));
			animalList.add(new Peacock(category, name, age, animalId));
			peacockZone.addAnimalInZone("bird");

		}

		else if (crocodileCageList.size() == 0 && "reptile".equals(category)) {
			crocodileZone = new Zone(_ZoneEnum_.Zone3);
			crocodileCageList = crocodileZone.setCrocodileCageList();
			zoneList.add(crocodileZone);
			System.out.println("\n====  Zone 3 is created for reptile ===");
			crocodileZone.addCage();

			crocodileAnimalList.add(new Crocodile(category, name, age, animalId));
			animalList.add(new Crocodile(category, name, age, animalId));
			crocodileZone.addAnimalInZone("reptile");

		} else {

			if ("mammal".equals(category)) {
				lionAnimalList.add(new Lion(category, name, age, animalId));
				animalList.add(new Lion(category, name, age, animalId));
				lionZone.addAnimalInZone("mammal");
			}

			else if ("bird".equals(category)) {
				peacockAnimalList.add(new Peacock(category, name, age, animalId));
				animalList.add(new Peacock(category, name, age, animalId));
				peacockZone.addAnimalInZone("bird");
			}

			else if ("reptile".equals(category)) {
				crocodileAnimalList.add(new Crocodile(category, name, age,
						animalId));
				animalList.add(new Crocodile(category, name, age, animalId));
				crocodileZone.addAnimalInZone("reptile");
			}

		}

	}

	/*
	 * List of Lion
	 * @return Lion animal list
	 */
	public static List<Lion> setMammalAnimalList() {
		return lionAnimalList;
	}

	/*
	 * List of Crocodile
	 * @return Crocodile animal list
	 */
	public static List<Crocodile> setReptileAnimalList() {
		return crocodileAnimalList;
	}

	/*
	 * List of Peacock
	 * @return Peacock animal list
	 */
	public static List<Peacock> setBirdAnimalList() {
		return peacockAnimalList;
	}

	/*
	 * List of all animal
	 * @return animal list - list of animals
	 */
	public static List<Animal> setAnimal() {
		return animalList;
	}


	/*
	 * Remove the reference of animal
	 * @param unique animalId
	 */
	void removeAnimal(String animalId) {
		for (int i = 0; i < animalList.size(); i++) {
			if ((animalList.get(i).animalId).equals(animalId)) {
				System.out.println(animalList.get(i).animalId + " Is removed");
				animalList.remove(i);
			}
		}

		for (int i = 0; i < lionAnimalList.size(); i++) {
			if ((lionAnimalList.get(i).animalId).equals(animalId)) {
				System.out.println(lionAnimalList.get(i).animalId
						+ " mammal Is removed");
				lionAnimalList.remove(i);
			}
		}

		for (int i = 0; i < peacockAnimalList.size(); i++) {
			if ((peacockAnimalList.get(i).animalId).equals(animalId)) {
				System.out.println(peacockAnimalList.get(i).animalId
						+ " bird Is removed");
				peacockAnimalList.remove(i);
			}
		}

		for (int i = 0; i < crocodileAnimalList.size(); i++) {
			if ((crocodileAnimalList.get(i).animalId).equals(animalId)) {
				System.out.println(crocodileAnimalList.get(i).animalId
						+ " reptile Is removed");
				crocodileAnimalList.remove(i);
			}
		}
	}

	public static void main(String arg[]) {
		Zoo zoo = new Zoo();
		for (int i = 1; i <= 8; i++) {
			zoo.addAnimal("mammal", "Lion", 10, "Mammal" + i);
			zoo.addAnimal("bird", "Peacock", 6, "Bird" + i);
			zoo.addAnimal("reptile", "Crocodile", 6, "Reptile" + i);
		}
		System.out.println("\n=====Animal List=====");
		for (int i = 0; i < animalList.size(); i++) {
			System.out.println(animalList.get(i).animalId);
		}
		zoo.removeAnimal("Reptile2");
		System.out.println("\n=====Animal List=====");
		for (int i = 0; i < animalList.size(); i++) {
			System.out.println(animalList.get(i).animalId);
		}
		System.out.println("\n=====Mammal Animal List=====");
		for (int i = 0; i < crocodileAnimalList.size(); i++) {
			System.out.println(crocodileAnimalList.get(i).animalId);
		}

	}

}
