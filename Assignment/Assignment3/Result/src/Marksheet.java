import java.util.ArrayList;
import java.util.List;

/*
 * class Marksheet compute various operation on student grades
 * such as average,maximum,minimum and passing percentage
 */
public class Marksheet {
    List < Integer > studentmarks=new ArrayList<Integer>();
    public Marksheet(List < Integer > studentmarks) {
        this.studentmarks=studentmarks;
    }

    /*
     * average marks of students
     * @return average sum of marks
     */
    double averageMarks() throws ArithmeticException{
        int sum = 0;
        for (int i = 0; i < studentmarks.size(); i++) {
            sum += studentmarks.get(i);
        }
        return (double)sum / studentmarks.size();
    }

    /*
     * maximum of marks from students marks
     * @return maximum marks
     */
    int maximumMarks() throws ArithmeticException{
        int maximummarks = studentmarks.get(0);
        for (int i = 1; i < studentmarks.size(); i++) {
            if (maximummarks < studentmarks.get(i)) {
                maximummarks = studentmarks.get(i);
            }
        }
        return maximummarks;
    }

    /*
     * minimum of marks from students marks
     * @return minimum marks
     */
    int minimumMarks() throws ArithmeticException{
        int minimummarks = studentmarks.get(0);
        for (int i = 1; i < studentmarks.size(); i++) {
            if (minimummarks > studentmarks.get(i)) {
                minimummarks = studentmarks.get(i);
            }
        }
        return minimummarks;
    }

    /*
     * percentage of student pass, passing grade >=40
     * @return percentage of student pass
     */
    double passPercentage() throws ArithmeticException{
        int count = 0;
        for (int i = 0; i < studentmarks.size(); i++) {
            if (studentmarks.get(i) >= 40) {
                count++;
            }
        }
        return   (double) count / studentmarks.size() * 100;
    }
}