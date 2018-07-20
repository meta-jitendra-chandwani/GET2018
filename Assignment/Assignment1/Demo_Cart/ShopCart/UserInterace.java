import java.util.Scanner;


public class UserInterface {
	private Scanner input=new Scanner(System.in);
	
	void Option() throws Exception {
        System.out.println("\n1. Add the item\n2. Update the Cart\n3. Display Cart Item\n4. Proceed to Bill");
        System.out.print("Enter your choice : ");
        int choose = input.nextInt();

        switch (choose) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.print("There is no such option.");
        }
    }
}