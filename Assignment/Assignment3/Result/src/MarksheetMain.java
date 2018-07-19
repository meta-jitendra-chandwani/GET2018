import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MarksheetMain {
    private static Scanner sc = new Scanner(System.in);
    static List<Integer> student_marks=new ArrayList<Integer>();
    
	public static void main(String arg[]) {
		System.out.print("Enter number of student : ");
		int number_of_student=sc.nextInt();
		System.out.println("Enter Students Marks : ");

		for(int i=0;i<number_of_student;i++){
			System.out.print("Student "+(i+1)+" : " );
			student_marks.add(i,sc.nextInt());			
		}
		Marksheet marksheet=new Marksheet(student_marks);
		System.out.println("1. Average of all grade\n2. Maximum of all grades\n3. Minimum of all grades\n4. % of students passed");
        System.out.print("Enter your choice : ");
        switch (sc.nextInt()) {
        case 1:
            System.out.printf("Average sum of grade : %.2f",marksheet.averageMarks());
            break;
        case 2:
            System.out.print("Maximum : " + marksheet.maximumMarks());
            break;
        case 3:
            System.out.print("Minimum : " + marksheet.minimumMarks());
            break;
        case 4:
            System.out.printf("Percentage of students pass : %.2f",marksheet.passPercentage());
            break;
        default:
            System.out.print("No such option");
            break;
    }
	}
}
