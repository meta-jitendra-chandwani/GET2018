/**
 * Program - Program course details
 * @author Jitendra Chandwani
 *
 */
public class Program {
    private String name;
    private int capacity;

    /**
     * getCapacity - Capacity of program
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * getName - Name of program
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setCapacity - set capacity of program
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * setName - set setName of program
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
