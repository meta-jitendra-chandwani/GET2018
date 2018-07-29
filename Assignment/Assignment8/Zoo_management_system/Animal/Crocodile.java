/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zoo_management_system.Animal;

import zoo_management_system.Animal.ReptileAnimal;

/**
 *
 * @author Jitendra
 */
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
