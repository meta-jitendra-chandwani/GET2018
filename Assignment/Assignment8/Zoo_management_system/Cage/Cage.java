package Cage;

import java.util.ArrayList;
import java.util.List;

import Zoo.Utility;
import Animal.Crocodile;
import Animal.Lion;
import Animal.Peacock;

public class Cage {

    public String cageName;
    public String cageType;
    public String zoneName;
    static int cageCapacity = 5;
    List < Lion > lionAnimalList;
    List < Peacock > peacockAnimalList;
    List < Crocodile > crocodileAnimalList;

    static List < Lion > lionInCage = new ArrayList < Lion > ();
    static List < Peacock > peacockInCage = new ArrayList < Peacock > ();
    static List < Crocodile > crocodileInCage = new ArrayList < Crocodile > ();

    public Cage(String cageName, String cageType, String zoneName) {
        this.cageType = cageType;
        this.cageName = cageName;
        this.zoneName = zoneName;
    }

    /*
     * Add animal in cage
     */
    public void addAnimalInCage() {
    	
        lionAnimalList = Utility.setMammalAnimalList();
        crocodileAnimalList = Utility.setReptileAnimalList();
        peacockAnimalList = Utility.setBirdAnimalList();
        try {
            switch (cageType) {
                case "mammal":
                    lionInCage.add(lionAnimalList.size() - 1, lionAnimalList.get(lionAnimalList.size() - 1));
                    System.out.println(lionAnimalList.get(lionAnimalList.size() - 1).animalId +
                        " is added in Cage");
                    break;
                case "reptile":
                    crocodileInCage.add(crocodileAnimalList.size() - 1, crocodileAnimalList.get(crocodileAnimalList.size() - 1));
                    System.out.println(crocodileAnimalList.get(crocodileAnimalList.size() - 1).animalId +
                        " is added in Cage");

                    break;
                case "bird":
                    peacockInCage.add(peacockAnimalList.size() - 1, peacockAnimalList.get(peacockAnimalList.size() - 1));
                    System.out.println(peacockInCage.get(peacockAnimalList.size() - 1).animalId +
                        " is added in Cage");
                    break;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    /*
     * List of Lion animal in cage
     * @return list of Lion animal in cage
     */
    public List < Lion > getMammalInCageList() {
        return lionInCage;
    }

    /*
     * List of Peacock animal in cage
     * @return list of Peacock animal in cage
     */
    public List < Peacock > getBirdInCageList() {
        return peacockInCage;
    }

    /*
     * List of Crocodile animal in cage
     * @return list of Crocodile animal in cage
     */
    public List < Crocodile > getReptileInCageList() {
        return crocodileInCage;
    }
}