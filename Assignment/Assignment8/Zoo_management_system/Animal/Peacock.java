/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animal;

/**
 *
 * @author Jitendra
 */
public class Peacock extends BirdAnimal {

    public Peacock(String Category, String Name, int Age) {
        super(Category, Name, Age);
    }

    @Override
    String Type() {
        return "Peacock";
    }

    String typeSound() {
        return "Pea Pea";
    }
}
