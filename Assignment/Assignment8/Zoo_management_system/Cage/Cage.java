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
import Animal.BirdAnimal;
import Animal.MammalAnimal;
import Animal.ReptileAnimal;

public class Cage {

	public String cageName;
	public String cageType;
	public String zoneName;
	static int cageCapacity = 5;
	Animal animal;
	List<Animal> animalList;
	List<MammalAnimal> mammalAnimalList;
	List<BirdAnimal> birdAnimalList;
	List<ReptileAnimal> reptileAnimalList;

	static List<MammalAnimal> mammalInCage = new ArrayList<MammalAnimal>();
	static List<BirdAnimal> birdInCage = new ArrayList<BirdAnimal>();
	static List<ReptileAnimal> reptileInCage = new ArrayList<ReptileAnimal>();

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

	public List<MammalAnimal> getMammalInCageList() {
		return mammalInCage;
	}

	public List<BirdAnimal> getBirdInCageList() {
		return birdInCage;
	}

	public List<ReptileAnimal> getReptileInCageList() {
		return reptileInCage;
	}

	void putAnimalCage() {

	}

}