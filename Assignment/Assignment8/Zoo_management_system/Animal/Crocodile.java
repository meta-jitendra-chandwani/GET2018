package Animal;

/*
 * Crocodile Animal class
 */
public class Crocodile extends ReptileAnimal {

	public String name;
	public int age;

	public Crocodile(String category, String name, int age, String animalId) {
		super(category, animalId);
		this.name = name;
		this.age = age;
	}

    String typeSound() {
        return "Crock";
    }

}
