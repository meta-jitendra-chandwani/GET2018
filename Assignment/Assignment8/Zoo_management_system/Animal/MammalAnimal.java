/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo_management_system.Animal;

import java.util.ArrayList;
import java.util.List;
import zoo_management_system.*;
import zoo_management_system.Animal.Animal;

/**
 *
 * @author Jitendra
 */
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
