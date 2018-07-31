package Zone;

import java.util.ArrayList;
import java.util.List;

import Animal.Crocodile;
import Animal.Lion;
import Animal.Peacock;
import Cage.Cage;

/*
 * Zone - contain number of cage.
 * Each Zone is classify into 3 categories.
 * Zone1 -  Mammal Zone, Zone2 - Bird Zone, Zone3 - Reptile Zone
 */
public class Zone {
	int capacityZone = 2;
	int cageCapacity = 5;
	_ZoneEnum_ zone;
	List<Lion> lionInCage ;
	List<Peacock> peacockInCage;
	List<Crocodile> crocodileInCage;
	public List<Cage> lionCageList = new ArrayList<Cage>();
	public List<Cage> peacockCageList = new ArrayList<Cage>();
	public List<Cage> crocodileCageList = new ArrayList<Cage>();

	Cage cageLion, cagePeacock, cageCrocodile;

	public Zone(_ZoneEnum_ zone) {
		this.zone = zone;
	}

	/*
	 * Add Cage in Zone - Zone contain number of zone
	 */
	public void addCage() {

		if (_ZoneEnum_.Zone1.equals(zone)) {
			if (lionCageList.size() == capacityZone) {
				System.out.println("No more cage add in zone 1");
			} else {
				
				cageLion = new Cage("Mammal  Cage" + (lionCageList.size()+1), "mammal", "Zone1");
				lionInCage = cageLion.getMammalInCageList();
				lionCageList.add(cageLion);
				System.out.println("\nCage "+lionCageList.size()+" is added in Zone 1\n");
				
			}
		}

		else if (_ZoneEnum_.Zone2.equals(zone)) {
			if (peacockCageList.size() == capacityZone) {
				System.out.println("No more cage add in zone 2");
			} else {
				cagePeacock = new Cage("Bird  Cage" + (peacockCageList.size()+1), "bird", "Zone2");
				peacockInCage = cagePeacock.getBirdInCageList();
				peacockCageList.add(cagePeacock);
				System.out.println("\nCage "+peacockCageList.size()+" is added in Zone 2\n");
			}
		} else if (_ZoneEnum_.Zone3.equals(zone)) {
			if (crocodileCageList.size() == capacityZone) {
				System.out.println("No more cage add in zone 3");
			} else {
				cageCrocodile = new Cage("Reptile  Cage" + (crocodileCageList.size()+1), "reptile", "Zone3");
				crocodileInCage = cageCrocodile.getReptileInCageList();
				crocodileCageList.add(cageCrocodile);
				System.out.println("\nCage "+crocodileCageList.size()+" is added in Zone 3\n");
			}
		}
	}

	/*
	 * Add animal in Zone 
	 * @param Category - distinguish on the basis of category - animal will be add on Zone
	 */
	public void addAnimalInZone(String category){
		if(category=="mammal"){
			if (lionInCage.size() == cageCapacity) {
				System.out.println("\nCage Capacity is full.\n");
				addCage();
				cageLion.addAnimalInCage();
			} else {		 
				cageLion.addAnimalInCage();
			}
		}
		else if(category=="bird"){
			if (peacockInCage.size() == cageCapacity) {
				System.out.println("\nCage Capacity is full.\n");
				addCage();
				cagePeacock.addAnimalInCage();
			} else {		 
				cagePeacock.addAnimalInCage();
			}
		}
		else if(category=="reptile"){
			if (crocodileInCage.size() == cageCapacity) {
				System.out.println("\nCage Capacity is full.\n");
				addCage();
				cageCrocodile.addAnimalInCage();
			} else {		 
				cageCrocodile.addAnimalInCage();
			}
		}
	}

	/*
	 * Cage list which contain mammal in it.
	 * @return List of Mammal Cage
	 */
	public List<Cage> setLionCageList() {
		return lionCageList;
	}

	/*
	 * Cage list which contain Bird in it.
	 * @return List of Bird Cage
	 */
	public List<Cage> setPeacockCageList() {
		return peacockCageList;
	}

	/*
	 * Cage list which contain Reptile in it.
	 * @return List of Reptile Cage
	 */
	public List<Cage> setCrocodileCageList() {
		return crocodileCageList;
	}

	/*
	 * To check canteen is here or not
	 */
	boolean hasCanteen() {
		return false;
	}

	/*
	 * To check park is here or not
	 */
	boolean hasPark() {
		return true;
	}
}