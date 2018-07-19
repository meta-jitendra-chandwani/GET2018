import java.util.ArrayList;
import java.util.List;

public class Marksheet {
    List < Integer > student_marks=new ArrayList<Integer>();
    public Marksheet(List < Integer > student_marks) {
        this.student_marks=student_marks;
    }

    /*
     * average marks of students
     * @return average sum of marks
     */
    double averageMarks() throws ArithmeticException{
        int sum = 0;
        for (int i = 0; i < student_marks.size(); i++) {
            sum += student_marks.get(i);
        }
        return (double)sum / student_marks.size();
    }

    /*
     * maximum of marks from students marks
     * @return maximum marks
     */
    int maximumMarks() throws ArithmeticException{
        int maximum_marks = student_marks.get(0);
        for (int i = 1; i < student_marks.size(); i++) {
            if (maximum_marks < student_marks.get(i)) {
                maximum_marks = student_marks.get(i);
            }
        }
        return maximum_marks;
    }

    /*
     * minimum of marks from students marks
     * @return minimum marks
     */
    int minimumMarks() throws ArithmeticException{
        int minimum_marks = student_marks.get(0);
        for (int i = 1; i < student_marks.size(); i++) {
            if (minimum_marks > student_marks.get(i)) {
                minimum_marks = student_marks.get(i);
            }
        }
        return minimum_marks;
    }

    /*
     * percentage of student pass, passing grade >=40
     * @return percentage of student pass
     */
    double passPercentage() throws ArithmeticException{
        int count = 0;
        for (int i = 0; i < student_marks.size(); i++) {
            if (student_marks.get(i) >= 40) {
                count++;
            }
        }
        return   (double) count / student_marks.size() * 100;
    }
}