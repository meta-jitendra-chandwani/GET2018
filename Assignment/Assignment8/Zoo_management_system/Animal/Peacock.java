package Animal;

/*
 * Peacock Animal class
 */
public class Peacock extends BirdAnimal {

	public String name;
	public int age;

	public Peacock(String category, String name, int age, String animalId) {
		super(category, animalId);
		this.name = name;
		this.age = age;
	}

    String typeSound() {
        return "Pea Pea";
    }
}