package Animal;

/*
 * Mammal Animal Parent class of Mammal Animal
 */
public class MammalAnimal extends Animal {

	public String category;

	public MammalAnimal(String category, String animalId) {
		super(animalId);
		this.category = category;
	}
}