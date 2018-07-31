package Animal;

/*
 * Bird Animal Parent class of Bird Animal
 */
public class BirdAnimal extends Animal {

public String category;
	
    public BirdAnimal(String category, String animalId) {
        super(animalId);
        this.category=category;
      }
}
