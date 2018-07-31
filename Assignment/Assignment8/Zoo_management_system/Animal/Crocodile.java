package Animal;

public class Crocodile extends ReptileAnimal {

    public Crocodile(String Category, String Name, int Age) {
        super(Category, Name, Age);
    }

    String typeSound() {
        return "Crock";
    }

}
