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
	int cageCapacity = 5;
	Animal animal;
	List<Animal> animalList;
	List<MammalAnimal> mammalAnimalList;
	List<BirdAnimal> birdAnimalList;
	List<ReptileAnimal> reptileAnimalList;

	static List<MammalAnimal> mammalInCage=new ArrayList<MammalAnimal>();
	static List<BirdAnimal> birdInCage=new ArrayList<BirdAnimal>();
	static List<ReptileAnimal> reptileInCage=new ArrayList<ReptileAnimal>();

	public Cage(String cageName, String cageType, String zoneName) {
		this.cageType = cageType;
		this.cageName = cageName;
		this.zoneName = zoneName;

	}

	public Cage(String Category) {
		animalList = Zoo.setAnimal();
		mammalAnimalList = Zoo.setMammalAnimalList();
        reptileAnimalList = Zoo.setReptileAnimalList();
        birdAnimalList =Zoo.setBirdAnimalList();
		switch (Category) {
		case "mammal":
			int i=0;
			while(i<cageCapacity&&i<mammalAnimalList.size())
			{
				mammalInCage.add(i, mammalAnimalList.get(i));
//				System.out.println(cageMammalList.get(i).Name);
				i++;
			}
			break;
		case "reptile":
			int i1=0;
			while(i1<cageCapacity&&i1<reptileAnimalList.size())
			{
				reptileInCage.add(i1, reptileAnimalList.get(i1));
				i1++;
			}
			break;
		case "bird":
			int i11=0;
			while(i11<cageCapacity&&i11<birdAnimalList.size())
			{
				birdInCage.add(i11, birdAnimalList.get(i11));
				i11++;
			}
			break;
		}

	
		}
		
	

	public static List<MammalAnimal> getMammalInCageList(){
		return mammalInCage;
	}
	public static List<BirdAnimal> getBirdInCageList(){
		return birdInCage;
	}
	public static List<ReptileAnimal> getReptileInCageList(){
		return reptileInCage;
	}

	

	void putAnimalCage() {

	}

	// public Cage(){
	//
	// }
	// public List<MammalAnimal> getCageList(){
	// return mammalCage;
	// }
	void getInfo() {

	}

	void addAnimal(String Category, String Name, int Age) {

	}

}
