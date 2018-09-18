package Zoo;

/*
 * Zone Class - is main class of zoo management system
 * Through which animal is add or removed from zoo.
 */
public class Zoo {
	Utility util=new Utility();
    /*
     * Add animal - to add animal in zoo in their particular zone and cage.
     * @param category - category of animal such as Mammal, Bird or Reptile 
     * @param name - name of animal
     * @param age - age of animal
     * @param animalId - unique animal id assigned to every animal
     */
    public void addAnimal(String category, String name, int age, String animalId) {
    	util.addAnimal(category, name, age, animalId);
    }

    
    /*
     * Remove the reference of animal
     * @param unique animalId
     */
    void removeAnimal(String animalId) {
       util.removeAnimal(animalId);
    }

    public static void main(String arg[]) {
        Zoo zoo = new Zoo();
        for (int i = 1; i <= 12; i++) {
            zoo.addAnimal("mammal", "Lion" + i, 10, "Mammal"+i);
            zoo.addAnimal("bird", "Bird" + i, 10, "Bird"+i);
        }
    }
}