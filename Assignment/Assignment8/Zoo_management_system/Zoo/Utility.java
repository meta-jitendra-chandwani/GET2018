package Zoo;

import java.util.ArrayList;
import java.util.List;

import Animal.Crocodile;
import Animal.Lion;
import Animal.Peacock;
import Zone.Zone;
import Zone._ZoneEnum_;

public class Utility {
	static List<Lion> lionAnimalList = new ArrayList<Lion>();
	static List<Peacock> peacockAnimalList = new ArrayList<Peacock>();
	static List<Crocodile> crocodileAnimalList = new ArrayList<Crocodile>();
	Zone lionZone, peacockZone, crocodileZone;
	List<Zone> zoneList = new ArrayList<Zone>();
	int lionCage = 0, peacockCage = 0, crocodileCage = 0;

	/*
	 * check whether name of animal is valid or not Name or Id of animal must be unique
	 * @param String name - name of animal
	 * @param String category - category of animal
	 * @param String animalId - animal id
	 * @return boolean value - true - if name and id is unique
	 * @return boolean value - false - if not
	 */
	private boolean animalNameAndIdValidation(String name, String category,
			String animalId) {
		boolean value = true;
		if (category.equals("mammal")) {
			for (Lion index : lionAnimalList) {
				if (index.name.equals(name) || index.animalId.equals(animalId)) {
					value = false;
					System.out
							.println("Name or id of mammal animal could not be same");
					break;
				}
			}
		} else if (category.equals("bird")) {
			for (Peacock index : peacockAnimalList) {
				if (index.name.equals(name) || index.animalId.equals(animalId)) {
					value = false;
					System.out
							.println("Name or id of bird animal could not be same");
					break;
				}
			}
		} else if (category.equals("reptile")) {
			for (Crocodile index : crocodileAnimalList) {
				if (index.name.equals(name) || index.animalId.equals(animalId)) {
					value = false;
					System.out
							.println("Name or id of reptile animal could not be same");
					break;
				}
			}
		}

		return value;
	}

	/*
	 * Add animal - to add animal in zoo in their particular zone and cage.
	 * @param category - category of animal such as Mammal, Bird or Reptile
	 * @param name - name of animal
	 * @param age - age of animal
	 * @param animalId - unique animal id assigned to every animal
	 */
	public void addAnimal(String category, String name, int age, String animalId) {

		try {
			if (animalNameAndIdValidation(name, category, animalId)) {
				if (lionCage == 0 && "mammal".equals(category)) {
					lionZone = new Zone(_ZoneEnum_.Zone1);
					lionCage++;
					zoneList.add(lionZone);
					System.out
							.println("\n====  Zone 1 is created for mammals ===");
					lionZone.addCage();

					lionAnimalList.add(new Lion(category, name, age, animalId));
					lionZone.addAnimalInZone("mammal");

				} else if (peacockCage == 0 && "bird".equals(category)) {
					peacockZone = new Zone(_ZoneEnum_.Zone2);
					peacockCage++;
					zoneList.add(peacockZone);
					System.out
							.println("\n====  Zone 2 is created for bird ===");
					peacockZone.addCage();

					peacockAnimalList.add(new Peacock(category, name, age,
							animalId));
					peacockZone.addAnimalInZone("bird");
				} else if (crocodileCage == 0 && "reptile".equals(category)) {
					crocodileZone = new Zone(_ZoneEnum_.Zone3);
					crocodileCage++;
					zoneList.add(crocodileZone);
					System.out
							.println("\n====  Zone 3 is created for reptile ===");
					crocodileZone.addCage();

					crocodileAnimalList.add(new Crocodile(category, name, age,
							animalId));
					crocodileZone.addAnimalInZone("reptile");

				} else {
					if ("mammal".equals(category)) {
						lionAnimalList.add(new Lion(category, name, age,
								animalId));
						lionZone.addAnimalInZone("mammal");
					} else if ("bird".equals(category)) {
						peacockAnimalList.add(new Peacock(category, name, age,
								animalId));
						peacockZone.addAnimalInZone("bird");
					} else if ("reptile".equals(category)) {
						crocodileAnimalList.add(new Crocodile(category, name,
								age, animalId));
						crocodileZone.addAnimalInZone("reptile");
					}

				}
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

	}
	
	 /*
     * Remove the reference of animal
     * @param unique animalId
     */
    void removeAnimal(String animalId) {
        for (int i = 0; i < lionAnimalList.size(); i++) {
            if ((lionAnimalList.get(i).animalId).equals(animalId)) {
                System.out.println(lionAnimalList.get(i).animalId +
                    " mammal Is removed");
                lionAnimalList.remove(i);
            }
        }

        for (int i = 0; i < peacockAnimalList.size(); i++) {
            if ((peacockAnimalList.get(i).animalId).equals(animalId)) {
                System.out.println(peacockAnimalList.get(i).animalId +
                    " bird Is removed");
                peacockAnimalList.remove(i);
            }
        }

        for (int i = 0; i < crocodileAnimalList.size(); i++) {
            if ((crocodileAnimalList.get(i).animalId).equals(animalId)) {
                System.out.println(crocodileAnimalList.get(i).animalId +
                    " reptile Is removed");
                crocodileAnimalList.remove(i);
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

}
