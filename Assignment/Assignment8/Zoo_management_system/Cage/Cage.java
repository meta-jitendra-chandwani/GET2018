/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo_management_system.Cage;

import java.util.ArrayList;
import java.util.List;
import zoo_management_system.Animal.Animal;
import zoo_management_system.Animal.BirdAnimal;
import zoo_management_system.Animal.MammalAnimal;
import zoo_management_system.Animal.ReptileAnimal;
import zoo_management_system._CageEnum_;

/**
 *
 * @author Jitendra
 */
public class Cage {

    String cageName;
    String cageType;
    String zoneName;
    int cageCapacity = 5;
    Animal animal;
    List<Animal> animalList;
    List<MammalAnimal> mammalAnimal;
    List<BirdAnimal> birdAnimal;
    List<ReptileAnimal> reptileAnimal;
    List<Cage> cageList;

    public Cage(String cageName, String cageType, String zoneName) {
        this.cageType = cageType;
        this.cageName = cageName;
        this.zoneName = zoneName;

    }

    public Cage() {
        animal = new Animal();
        animalList = animal.getAnimalsList();
        mammalAnimal = animal.getMammalAnimalsList();
        birdAnimal = animal.getBirdAnimalsList();
        reptileAnimal = animal.getReptileAnimalsList();

        cageList = new ArrayList<>();
        cageList.add(new Cage("Cage1", "Mammal","Zone1"));
        cageList.add(new Cage("Cage2", "Mammal","Zone1"));
        cageList.add(new Cage("Cage3", "Mammal","Zone1"));
        cageList.add(new Cage("Cage4", "Mammal","Zone1"));
        cageList.add(new Cage("Cage5", "Mammal","Zone1"));
        
        
        cageList.add(new Cage("Cage1", "Mammal","Zone2"));
        cageList.add(new Cage("Cage2", "Mammal","Zone2"));
        cageList.add(new Cage("Cage3", "Mammal","Zone2"));
        cageList.add(new Cage("Cage4", "Mammal","Zone2"));
        cageList.add(new Cage("Cage5", "Mammal","Zone2"));
        
        
        cageList.add(new Cage("Cage1", "Bird","Zone3"));
        cageList.add(new Cage("Cage2", "Bird","Zone3"));
        cageList.add(new Cage("Cage3", "Bird","Zone3"));
        cageList.add(new Cage("Cage4", "Bird","Zone3"));
        cageList.add(new Cage("Cage5", "Bird","Zone3"));
        
        
        cageList.add(new Cage("Cage1", "Reptile","Zone4"));
        cageList.add(new Cage("Cage2", "Reptile","Zone4"));
        cageList.add(new Cage("Cage3", "Reptile","Zone4"));
        cageList.add(new Cage("Cage4", "Reptile","Zone4"));
        cageList.add(new Cage("Cage5", "Reptile","Zone4"));

    }

    void putAnimalCage() {

    }

//    public Cage(){
//        
//    }
//    public List<MammalAnimal> getCageList(){
//        return mammalCage;
//    }
    void getInfo() {

    }

    void addAnimal(String Category, String Name, int Age) {

    }

    public static void main(String[] args) {
        Cage cage = new Cage();

        System.out.println(cage.mammalCage[0]);
    }
}
