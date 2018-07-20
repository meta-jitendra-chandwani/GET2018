import java.util.Scanner;

public class AreaMain {
    private static Scanner input = new Scanner(System.in);

    public static void main(String arg[]) {
        double inputone, inputtwo;
        Area area = new Area();
        System.out.println("1. Area of Triangle\n2. Area of Rectangle\n3. Area of Square\n4. Area of Circle");
        System.out.print("Enter your choice : ");
        switch (input.nextInt()) {
            case 1:
                System.out.print("Enter Base : ");
                inputone = input.nextDouble();
                System.out.print("Enter Height : ");
                inputtwo = input.nextDouble();
                System.out.print("Area of Triangle : " + area.Triangle(inputone, inputtwo));
                break;
            case 2:
                System.out.print("Enter Length : ");
                inputone = input.nextDouble();
                System.out.print("Enter Breadth : ");
                inputtwo = input.nextDouble();
                System.out.print("Area of Reactangle : " + area.Rectangle(inputone, inputtwo));
                break;
            case 3:
                System.out.print("Enter Length : ");
                inputone = input.nextDouble();
                System.out.print("Area of Square : " + area.Square(inputone));
                break;
            case 4:
                System.out.print("Enter Radius : ");
                inputone = input.nextDouble();
                System.out.print("Area of Circle : " + area.Circle(inputone));
                break;
            default:
                System.out.print("No such option");
                break;
        }
    }
}