package Animal;



public class Lion extends MammalAnimal {


    Lion(String Category, String Name, int Age) {
        super(Category, Name, Age);
    }

    String typeSound() {
        return "Roar";
    }
}
