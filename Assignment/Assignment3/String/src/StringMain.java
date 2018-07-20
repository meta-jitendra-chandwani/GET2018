import java.util.Scanner;

public class StringMain {
    private static Scanner input = new Scanner(System.in);

	public static void main(String arg[]) {
        String stringone,stringtwo;
        Stringoperation string = new Stringoperation();
        System.out.println("1. Compare two strings\n2. Reverse of string\n3. Change Case\n4. Largest word");
        System.out.print("Enter your choice : ");
        switch (input.nextInt()) {
            case 1:
                System.out.print("Enter First String : ");
                stringone = input.next().trim();
                System.out.print("Enter Second String : ");
                stringtwo = input.next().trim();
                System.out.print(string.compare(stringone, stringtwo));
                break;
            case 2:
                System.out.print("Enter String : ");
                stringone = input.next().trim();
                System.out.print("Reverse of String : " + string.reverse(stringone));
                break;
            case 3:
                System.out.print("Enter String : ");
                stringone = input.next().trim();
                System.out.print("Result : " + string.changeCase(stringone));
                break;
            case 4:
                System.out.print("Enter String : ");
                input.nextLine();
                stringone = input.nextLine().trim();
                System.out.print("Longest word : " + string.longestWord(stringone));
                break;
            default:
                System.out.print("No such option");
                break;
        }
    }
}