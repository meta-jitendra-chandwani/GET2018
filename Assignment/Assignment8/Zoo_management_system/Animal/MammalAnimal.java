package Animal;

public class MammalAnimal extends Animal {
//    String Category;
	
    public MammalAnimal(String Category, String Name, int Age) {
        super(Category, Name, Age);
    }

    String getName() {
        return this.Name;
    }

    @Override
    String getCategory() {
        return this.Category;
    }

    String Type() {
        return "MammalAnimal";
    }
}
