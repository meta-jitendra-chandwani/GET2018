/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animal;

public class BirdAnimal extends Animal {

public String category;
	
    public BirdAnimal(String Category, String animalId) {
        super(animalId);
        this.category=Category;
      }
}
