package Zone;

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
    final int CAPACITY_ZONE = 2;
    final int CAGE_CAPACITY = 5;
    _ZoneEnum_ zone;
    List < Lion > lionInCage;
    List < Peacock > peacockInCage;
    List < Crocodile > crocodileInCage;

    Cage cageLion, cagePeacock, cageCrocodile;
    int lionCage=0,peacockCage=0,crocodileCage=0;

    public Zone(_ZoneEnum_ zone) {
        this.zone = zone;
    }

    boolean zoneCapacityValidation(_ZoneEnum_ zone) {
        boolean value = true;
        switch (zone) {
            case Zone1:
                if (lionCage == CAPACITY_ZONE) {
                    value = false;
                    System.out.println("No more cage add in zone 1");
                }
                break;
            case Zone2:
                if (peacockCage == CAPACITY_ZONE) {
                    value = false;
                    System.out.println("No more cage add in zone 2");
                }
                break;
            case Zone3:
                if (crocodileCage == CAPACITY_ZONE) {
                    value = false;
                    System.out.println("No more cage add in zone 3");
                }
                break;
        }
        return value;
    }

    /*
     * Add Cage in Zone - Zone contain number of zone
     */
    public void addCage() {
        try {
            if (_ZoneEnum_.Zone1.equals(zone)) {
                if (zoneCapacityValidation(zone)) {
                    cageLion = new Cage("Mammal  Cage" +
                        (lionCage + 1), "mammal", "Zone1");
                    lionInCage = cageLion.getMammalInCageList();
//                    lionCageList.add(cageLion);
                    System.out.println("\nCage " + (lionCage+1) +
                        " is added in Zone 1\n");
                }
                else{
                	System.out.println("Zone 4 is underconstruction");
                	System.exit(0);
                }
            } else if (_ZoneEnum_.Zone2.equals(zone)) {
                if (zoneCapacityValidation(zone)) {
                    cagePeacock = new Cage("Bird  Cage" +
                        (peacockCage + 1), "bird", "Zone2");
                    peacockInCage = cagePeacock.getBirdInCageList();
//                    peacockCageList.add(cagePeacock);
                    System.out.println("\nCage " + (peacockCage+1) +
                        " is added in Zone 2\n");
                }
            } else if (_ZoneEnum_.Zone3.equals(zone)) {
                if (zoneCapacityValidation(zone)) {
                    cageCrocodile = new Cage("Reptile  Cage" +
                        (crocodileCage + 1), "reptile",
                        "Zone3");
                    crocodileInCage = cageCrocodile.getReptileInCageList();
//                    crocodileCageList.add(cageCrocodile);
                    System.out.println("\nCage " + (crocodileCage+1) +
                        " is added in Zone 3\n");
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private boolean cageCapacityValidation(String category) {
        boolean value = true;
        switch (category) {
            case "mammal":
                if (lionInCage.size()%CAGE_CAPACITY==0 && lionInCage.size()!=0) {
                	lionCage++;
                    System.out.println("\nCage Capacity is full.\n");
                    addCage();
                    cageLion.addAnimalInCage();
                    value = false;
                }
                break;
            case "bird":
                if (peacockInCage.size()%CAGE_CAPACITY==0 && peacockInCage.size()!=0) {
                	peacockCage++;
                    System.out.println("\nCage Capacity is full.\n");
                    addCage();
                    cagePeacock.addAnimalInCage();
                    value = false;
                }
                break;
            case "reptile":
                if (crocodileInCage.size()%CAGE_CAPACITY==0 && crocodileInCage.size()!=0) {
                	crocodileCage++;
                    System.out.println("\nCage Capacity is full.\n");
                    addCage();
                    cageCrocodile.addAnimalInCage();
                    value = false;
                }
                break;
        }
        return value;
    }

    /*
     * Add animal in Zone
     * @param Category - distinguish on the basis of category - animal will be
     * add on Zone
     */
    public void addAnimalInZone(String category) {
        try {
            if (category == "mammal") {
                if (cageCapacityValidation(category)) {
                    cageLion.addAnimalInCage();
                }
            } else if (category == "bird") {
                if (cageCapacityValidation(category)) {
                    cagePeacock.addAnimalInCage();
                }
            } else if (category == "reptile") {
                if (cageCapacityValidation(category)) {
                    cageCrocodile.addAnimalInCage();
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

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