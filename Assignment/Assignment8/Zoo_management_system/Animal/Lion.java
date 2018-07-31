package Animal;

public class Lion extends MammalAnimal {

	public String name;
	public int age;

	public Lion(String Category, String Name, int Age, String animalId) {
		super(Category, animalId);
		this.name = Name;
		this.age = Age;
	}

	String typeSound() {
		return "Roar";
	}
}
