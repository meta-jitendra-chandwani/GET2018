/**
 * @author Jitendra Chandwani
 * AllocatedPrograms - Allocate Program to student
 */
public class AllocatedPrograms {
    String studentName;
    String selectedProgram;

    /**
     * AllocatedPrograms - Initialize the value of studentName and selectedProgram
     * @param studentName
     * @param selectedProgram
     */
    public AllocatedPrograms(String studentName, String selectedProgram) {
        this.studentName = studentName;
        this.selectedProgram = selectedProgram;
    }

    /**
     * getSelectedProgram
     * @return selected program
     */
    public String getSelectedProgram() {
        return selectedProgram;
    }

    /**
     * getStudentName
     * @return student name
     */
    public String getStudentName() {
        return studentName;
    }   
}