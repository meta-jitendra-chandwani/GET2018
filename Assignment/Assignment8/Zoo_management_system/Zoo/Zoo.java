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

public class Zoo {
	static List<Animal> animalList = new ArrayList<Animal>();
	static List<Lion> mammalAnimalList = new ArrayList<Lion>();
	static List<Peacock> birdAnimalList = new ArrayList<Peacock>();
	static List<Crocodile> reptileAnimalList = new ArrayList<Crocodile>();
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

			mammalAnimalList.add(new Lion(Category, Name, Age, animalId));
			animalList.add(new Lion(Category, Name, Age, animalId));
			mammalZone.addAnimalInZone("mammal");

		} else if (birdCageList.size() == 0 && "bird".equals(Category)) {

			birdZone = new Zone(_ZoneEnum_.Zone2);
			birdCageList = birdZone.setBirdCageList();
			zoneList.add(birdZone);
			System.out.println("\n====  Zone 2 is created for bird ===");
			birdZone.addCage();

			birdAnimalList.add(new Peacock(Category, Name, Age, animalId));
			animalList.add(new Peacock(Category, Name, Age, animalId));
			birdZone.addAnimalInZone("bird");

		}

		else if (reptileCageList.size() == 0 && "reptile".equals(Category)) {
			reptileZone = new Zone(_ZoneEnum_.Zone3);
			reptileCageList = reptileZone.setReptileCageList();
			zoneList.add(reptileZone);
			System.out.println("\n====  Zone 3 is created for reptile ===");
			reptileZone.addCage();

			reptileAnimalList.add(new Crocodile(Category, Name, Age, animalId));
			animalList.add(new Crocodile(Category, Name, Age, animalId));
			reptileZone.addAnimalInZone("reptile");

		} else {

			if ("mammal".equals(Category)) {
				mammalAnimalList.add(new Lion(Category, Name, Age, animalId));
				animalList.add(new Lion(Category, Name, Age, animalId));
				mammalZone.addAnimalInZone("mammal");
			}

			else if ("bird".equals(Category)) {
				birdAnimalList.add(new Peacock(Category, Name, Age, animalId));
				animalList.add(new Peacock(Category, Name, Age, animalId));
				birdZone.addAnimalInZone("bird");
			}

			else if ("reptile".equals(Category)) {
				reptileAnimalList.add(new Crocodile(Category, Name, Age,
						animalId));
				animalList.add(new Crocodile(Category, Name, Age, animalId));
				reptileZone.addAnimalInZone("reptile");
			}

		}

	}

	public static List<Lion> setMammalAnimalList() {
		return mammalAnimalList;
	}

	public static List<Crocodile> setReptileAnimalList() {
		return reptileAnimalList;
	}

	public static List<Peacock> setBirdAnimalList() {
		return birdAnimalList;
	}

	public static List<Animal> setAnimal() {

		return animalList;
	}

	void removeAnimal(String animalId) {
		for (int i = 0; i < animalList.size(); i++) {
            if ((animalList.get(i).animalId).equals(animalId)) {
            	System.out.println(animalList.get(i).animalId+" Is removed");
            	animalList.remove(i);
            }
        }
		
		for (int i = 0; i < mammalAnimalList.size(); i++) {
            if ((mammalAnimalList.get(i).animalId).equals(animalId)) {
            	System.out.println(mammalAnimalList.get(i).animalId+" mammal Is removed");
            	mammalAnimalList.remove(i);
            }
        }
		
		for (int i = 0; i < birdAnimalList.size(); i++) {
            if ((birdAnimalList.get(i).animalId).equals(animalId)) {
            	System.out.println(birdAnimalList.get(i).animalId+" bird Is removed");
            	birdAnimalList.remove(i);
            }
        }
		
		for (int i = 0; i < reptileAnimalList.size(); i++) {
            if ((reptileAnimalList.get(i).animalId).equals(animalId)) {
            	System.out.println(reptileAnimalList.get(i).animalId+" reptile Is removed");
            	reptileAnimalList.remove(i);
            }
        }
	}

	public static void main(String arg[]) {
		Zoo zoo = new Zoo();
		for(int i=1;i<=8;i++){
			zoo.addAnimal("mammal", "Lion", 10, "Mammal" + i);
			zoo.addAnimal("bird", "Peacock", 6, "Bird" + i);
			zoo.addAnimal("reptile", "Crocodile", 6, "Reptile" + i);
		}
		System.out.println("\n=====Animal List=====");
		for(int i=0;i<animalList.size();i++){
			System.out.println(animalList.get(i).animalId);
		}
		zoo.removeAnimal("Reptile2");
		System.out.println("\n=====Animal List=====");
		for(int i=0;i<animalList.size();i++){
			System.out.println(animalList.get(i).animalId);
		}
		System.out.println("\n=====Mammal Animal List=====");
		for(int i=0;i<reptileAnimalList.size();i++){
			System.out.println(reptileAnimalList.get(i).animalId);
		}

	}

}
