import java.util.Scanner;

public class StringMain {
    private static Scanner sc = new Scanner(System.in);

	public static void main(String arg[]) {
        String string_one,string_two;
        Stringoperation string = new Stringoperation();
        System.out.println("1. Compare two strings\n2. Reverse of string\n3. Change Case\n4. Largest word");
        System.out.print("Enter your choice : ");
        switch (sc.nextInt()) {
            case 1:
                System.out.print("Enter First String : ");
                string_one = sc.next().trim();
                System.out.print("Enter Second String : ");
                string_two = sc.next().trim();
                System.out.print(string.compare(string_one, string_two));
                break;
            case 2:
                System.out.print("Enter String : ");
                string_one = sc.next().trim();
                System.out.print("Reverse of String : " + string.reverse(string_one));
                break;
            case 3:
                System.out.print("Enter String : ");
                string_one = sc.next().trim();
                System.out.print("Result : " + string.changeCase(string_one));
                break;
            case 4:
                System.out.print("Enter String : ");
                sc.nextLine();
                string_one = sc.nextLine().trim();
                System.out.print("Longest word : " + string.longestWord(string_one));
                break;
            default:
                System.out.print("No such option");
                break;
        }
    }
}