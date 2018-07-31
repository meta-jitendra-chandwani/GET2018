/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cage;

import java.util.ArrayList;
import java.util.List;

import Zoo.Zoo;
import Animal.Animal;
import Animal.Crocodile;
import Animal.Lion;
import Animal.Peacock;

public class Cage {

	public String cageName;
	public String cageType;
	public String zoneName;
	static int cageCapacity = 5;
	Animal animal;
	List<Animal> animalList;
	List<Lion> mammalAnimalList;
	List<Peacock> birdAnimalList;
	List<Crocodile> reptileAnimalList;

	static List<Lion> mammalInCage = new ArrayList<Lion>();
	static List<Peacock> birdInCage = new ArrayList<Peacock>();
	static List<Crocodile> reptileInCage = new ArrayList<Crocodile>();

	public Cage(String cageName, String cageType, String zoneName) {
		this.cageType = cageType;
		this.cageName = cageName;
		this.zoneName = zoneName;

	}
	
	public void addAnimalInCage(){
		animalList = Zoo.setAnimal();
		mammalAnimalList = Zoo.setMammalAnimalList();
		reptileAnimalList = Zoo.setReptileAnimalList();
		birdAnimalList = Zoo.setBirdAnimalList();
		switch (cageType) {
		case "mammal":			
				mammalInCage.add(mammalAnimalList.size()-1,mammalAnimalList.get(mammalAnimalList.size()-1));
				System.out.println(mammalAnimalList.get(mammalAnimalList.size()-1).animalId
						+ " is added in Cage");
			break;
		case "reptile":
				reptileInCage.add(reptileAnimalList.size()-1, reptileAnimalList.get(reptileAnimalList.size()-1));
				System.out.println(reptileAnimalList.get(reptileAnimalList.size()-1).animalId
						+ " is added in Cage");
		
			break;
		case "bird":
				birdInCage.add(birdAnimalList.size()-1, birdAnimalList.get(birdAnimalList.size()-1));
				System.out.println(birdInCage.get(birdAnimalList.size()-1).animalId
						+ " is added in Cage");
			break;
		}

	}

	public List<Lion> getMammalInCageList() {
		return mammalInCage;
	}

	public List<Peacock> getBirdInCageList() {
		return birdInCage;
	}

	public List<Crocodile> getReptileInCageList() {
		return reptileInCage;
	}

	void putAnimalCage() {

	}

}