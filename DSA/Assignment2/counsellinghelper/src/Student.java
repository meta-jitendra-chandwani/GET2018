import java.util.ArrayList;

/**
 * Student - Student details
 * @author Jitendra Chandwani
 *
 */
public class Student {
    String name;
    ArrayList<String> interestedProgram = new ArrayList<>();

    /**
     * getInterestedProgram - Interested Program List
     * @return interestedProgram
     */
    public ArrayList<String> getInterestedProgram() {
        return interestedProgram;
    }

    /**
     * getName - Student Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setName - set Student Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setInterestedProgram - set Interested Program
     * @param program
     */
    public void setInterestedProgram(String program) {
        interestedProgram.add(program);
    }
}
