import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner input=new Scanner(System.in);
	void inputParameter(String shape){
		switch (shape) {
		case _ShapeType_.REC:
			
			break;

		default:
			break;
		}
	}
	public static void main(String arg[]) {
		List<Integer> paramterOfShape = new ArrayList<Integer>(); 

		System.out.println("Enter Shape : ");
		String shape=input.next();
		System.out.println("Enter origin Points : ");
		float point1=input.nextFloat();
		float point2=input.nextFloat();
		Point pointOrigin=new Point(point1, point2);
		System.out.println("Enter Parameter (For Rectangle - parameters are length and breadth : ") ;
		paramterOfShape.add()
	}
}
