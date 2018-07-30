package Animal;

public class Crocodile extends ReptileAnimal {

    public Crocodile(String Category, String Name, int Age) {
        super(Category, Name, Age);
    }

    @Override
    String Type() {
        return "Crocodile";
    }

    String typeSound() {
        return "Crock";
    }

}
