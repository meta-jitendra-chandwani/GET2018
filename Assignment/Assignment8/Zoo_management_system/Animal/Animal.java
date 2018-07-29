/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo_management_system.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jitendra
 */
public class Animal {

    public String Category;
    public String Name;
    public int Age;
    private List<Animal> animalList;
    private List<MammalAnimal> mammalAnimalList;
    private List<ReptileAnimal> reptileAnimalList;
    private List<BirdAnimal> birdAnimalList;

    public Animal() {
        animalList = new ArrayList<>();
        mammalAnimalList = new ArrayList<>();
        reptileAnimalList = new ArrayList<>();
        birdAnimalList = new ArrayList<>();
        MammalAnimal mammalAnimal;
        ReptileAnimal reptileAnimal;
        BirdAnimal birdAnimal;
        mammalAnimalList.add(new Lion("Mammal", "Lion1", 10));
        mammalAnimalList.add(new Lion("Mammal", "Lion2", 10));
        mammalAnimalList.add(new Lion("Mammal", "Lion3", 10));
        mammalAnimalList.add(new Lion("Mammal", "Lion4", 10));
        mammalAnimalList.add(new Lion("Mammal", "Lion5", 10));
        mammalAnimalList.add(new Lion("Mammal", "Lion6", 10));
        mammalAnimalList.add(new Lion("Mammal", "Lion7", 10));
        mammalAnimalList.add(new Lion("Mammal", "Lion8", 10));
        mammalAnimalList.add(new Lion("Mammal", "Lion9", 10));
        mammalAnimalList.add(new Lion("Mammal", "Lion10", 10));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile1", 5));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile2", 5));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile3", 5));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile4", 5));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile5", 5));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile6", 5));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile7", 5));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile8", 5));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile9", 5));
        reptileAnimalList.add(new Crocodile("Reptile", "Croodile10", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock1", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock2", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock3", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock4", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock5", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock6", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock7", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock8", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock9", 5));
        birdAnimalList.add(new BirdAnimal("Bird", "Peacock10", 5));
        animalList.addAll(mammalAnimalList);
        animalList.addAll(birdAnimalList);
        animalList.addAll(reptileAnimalList);

    }

    public List<Animal> getAnimalsList() {
        return animalList;
    }

    public List<ReptileAnimal> getReptileAnimalsList() {
        return reptileAnimalList;
    }

    public List<BirdAnimal> getBirdAnimalsList() {
        return birdAnimalList;
    }

    public List<MammalAnimal> getMammalAnimalsList() {
        return mammalAnimalList;
    }

    public Animal(String Category, String Name, int Age) {
        this.Category = Category;
        this.Name = Name;
        this.Age = Age;
    }

    void getInfo() {

    }

    String getCategory() {
        return "Animal";
    }

//    public static void main(String[] args) {
//        Animal animal = new Animal();
//        List<MammalAnimal> animalList = animal.getMammalAnimalsList();
//        System.out.println(animalList.get(4).Name);
////		System.out.println("Cat eats " + cat.getEats());
////		System.out.println("Cat has " + cat.getNoOfLegs() + " legs.");
////		System.out.println("Cat color is " + cat.getColor());
//    }
}
