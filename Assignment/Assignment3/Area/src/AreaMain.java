import java.util.Scanner;

public class AreaMain {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String arg[]) {
        double input_one, input_two;
        Area area = new Area();
        System.out.println("1. Area of Triangle\n2. Area of Rectangle\n3. Area of Square\n4. Area of Circle");
        System.out.print("Enter your choice : ");
        switch (sc.nextInt()) {
            case 1:
                System.out.print("Enter Base : ");
                input_one = sc.nextDouble();
                System.out.print("Enter Height : ");
                input_two = sc.nextDouble();
                System.out.print("Area of Triangle : " + area.Triangle(input_one, input_two));
                break;
            case 2:
                System.out.print("Enter Length : ");
                input_one = sc.nextDouble();
                System.out.print("Enter Breadth : ");
                input_two = sc.nextDouble();
                System.out.print("Area of Reactangle : " + area.Rectangle(input_one, input_two));
                break;
            case 3:
                System.out.print("Enter Length : ");
                input_one = sc.nextDouble();
                System.out.print("Area of Square : " + area.Square(input_one));
                break;
            case 4:
                System.out.print("Enter Radius : ");
                input_one = sc.nextDouble();
                System.out.print("Area of Circle : " + area.Circle(input_one));
                break;
            default:
                System.out.print("No such option");
                break;
        }
    }
}