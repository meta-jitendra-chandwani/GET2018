package Zone;

import java.util.ArrayList;
import java.util.List;

import Animal.BirdAnimal;
import Animal.MammalAnimal;
import Animal.ReptileAnimal;
import Cage.Cage;

public class Zone {
	int CapacityZone = 2;
	int cageCapacity = 5;
	_ZoneEnum_ zone;
	List<MammalAnimal> mammalInCage ;
	List<BirdAnimal> birdInCage;
	List<ReptileAnimal> reptileInCage;
	public List<Cage> mammalCageList = new ArrayList<Cage>();
	public List<Cage> birdCageList = new ArrayList<Cage>();
	public List<Cage> reptileCageList = new ArrayList<Cage>();

	Cage cageMammals, cageBirds, cageReptiles;

	public Zone(_ZoneEnum_ zone) {
		this.zone = zone;
	}

	public void addCage() {

		if (_ZoneEnum_.Zone1.equals(zone)) {
			if (mammalCageList.size() == CapacityZone) {
				System.out.println("No more cage add in zone 1");
			} else {
				
				cageMammals = new Cage("Mammal  Cage" + (mammalCageList.size()+1), "mammal", "Zone1");
				mammalInCage = cageMammals.getMammalInCageList();
				mammalCageList.add(cageMammals);
				System.out.println("Cage "+mammalCageList.size()+" is added in Zone 1");
				
			}
		}

		else if (_ZoneEnum_.Zone2.equals(zone)) {
			if (birdCageList.size() == CapacityZone) {
				System.out.println("No more cage add in zone 2");
			} else {
				cageBirds = new Cage("Bird  Cage" + (birdCageList.size()+1), "bird", "Zone2");
				birdInCage = cageBirds.getBirdInCageList();
				birdCageList.add(cageBirds);
				System.out.println("Cage "+birdCageList.size()+" is added in Zone 2");
			}
		} else if (_ZoneEnum_.Zone3.equals(zone)) {
			if (reptileCageList.size() == CapacityZone) {
				System.out.println("No more cage add in zone 3");
			} else {
				cageReptiles = new Cage("Reptile  Cage" + (mammalCageList.size()+1), "reptile", "Zone3");
				reptileInCage = cageReptiles.getReptileInCageList();
				reptileCageList.add(cageReptiles);
				System.out.println("Cage "+reptileCageList.size()+" is added in Zone 3");
			}

		}

	}

	public void addAnimalInZone(String category){
		if(category=="mammal"){
			if (mammalInCage.size() == cageCapacity) {
				System.out.println("Cage Capacity is full.\n");
				addCage();
				cageMammals.addAnimalInCage();
			} else {		 
				cageMammals.addAnimalInCage();
			}
		}
		else if(category=="bird"){
			if (birdInCage.size() == cageCapacity) {
				System.out.println("Cage Capacity is full.\n");
				addCage();
				cageBirds.addAnimalInCage();
			} else {		 
				cageBirds.addAnimalInCage();
			}
		}
		else if(category=="reptile"){
			if (reptileInCage.size() == cageCapacity) {
				System.out.println("Cage Capacity is full.\n");
				addCage();
				cageReptiles.addAnimalInCage();
			} else {		 
				cageReptiles.addAnimalInCage();
			}
		}
	}


	public List<Cage> setMammalCageList() {
		return mammalCageList;
	}

	public List<Cage> setBirdCageList() {
		return birdCageList;
	}

	public List<Cage> setReptileCageList() {
		return reptileCageList;
	}

	boolean hasCanteen() {
		return false;
	}

	boolean hasPark() {
		return true;
	}

}