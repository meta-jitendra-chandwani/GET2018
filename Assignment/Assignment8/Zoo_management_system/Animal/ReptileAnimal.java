package Animal;

/*
 * Reptile Animal Parent class of Reptile Animal
 */
public class ReptileAnimal extends Animal {
	public String category;

	public ReptileAnimal(String category, String animalId) {
		super(animalId);
		this.category = category;
	}
}
