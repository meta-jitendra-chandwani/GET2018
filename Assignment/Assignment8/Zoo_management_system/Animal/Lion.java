package Animal;

/*
 * Lion Animal class
 */
public class Lion extends MammalAnimal {

	public String name;
	public int age;

	public Lion(String category, String name, int age, String animalId) {
		super(category, animalId);
		this.name = name;
		this.age = age;
	}

	String typeSound() {
		return "Roar";
	}
}
