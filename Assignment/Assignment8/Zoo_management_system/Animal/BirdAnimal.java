/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo_management_system.Animal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jitendra
 */
public class BirdAnimal extends Animal {

    private static List<Object> birdAnimalList;

    public BirdAnimal(String Category, String Name, int Age) {
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
        return "BirdAnimal";
    }
}
