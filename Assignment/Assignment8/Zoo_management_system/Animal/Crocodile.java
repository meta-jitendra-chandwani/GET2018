package Animal;

public class Crocodile extends ReptileAnimal {

	public String name;
	public int age;

	public Crocodile(String Category, String Name, int Age, String animalId) {
		super(Category, animalId);
		this.name = Name;
		this.age = Age;
	}

    String typeSound() {
        return "Crock";
    }

}
