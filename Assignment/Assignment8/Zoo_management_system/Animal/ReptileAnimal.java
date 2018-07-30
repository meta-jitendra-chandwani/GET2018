package Animal;


public class ReptileAnimal extends Animal {

    public ReptileAnimal(String Category, String Name, int Age) {
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
        return "ReptileAnimal";
    }
}
