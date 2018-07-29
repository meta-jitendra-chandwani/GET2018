package zoo_management_system.Animal;

import java.util.ArrayList;
import java.util.List;

public class Lion extends MammalAnimal {

    private static List<Lion> lionList;

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
