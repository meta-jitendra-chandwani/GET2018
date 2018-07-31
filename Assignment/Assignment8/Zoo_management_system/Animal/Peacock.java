/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animal;

public class Peacock extends BirdAnimal {

	public String name;
	public int age;

	public Peacock(String Category, String Name, int Age, String animalId) {
		super(Category, animalId);
		this.name = Name;
		this.age = Age;
	}

    String typeSound() {
        return "Pea Pea";
    }
}
