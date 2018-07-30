/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animal;

public class BirdAnimal extends Animal {

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
