package Animal;

public class MammalAnimal extends Animal {

	public String category;
	
    public MammalAnimal(String Category, String animalId) {
        super(animalId);
        this.category=Category;
      }


}
