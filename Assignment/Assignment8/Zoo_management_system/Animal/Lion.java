package Animal;



public class Lion extends MammalAnimal {


    Lion(String Category, String Name, int Age) {
        super(Category, Name, Age);
    }

    @Override
    String Type() {
        return "Lion";
    }

    String typeSound() {
        return "Roar";
    }
}
