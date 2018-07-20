import java.util.Scanner;


public class User {
	private Scanner input=new Scanner(System.in);
	Crud crud=new Crud();
	Checkout checkout=new Checkout();
	void Option() throws Exception {
        System.out.println("\n1. Add the item\n2. Remove Item\n3. Update the Cart\n4. Display Cart Item\n5. Proceed to Bill");
        System.out.print("Enter your choice : ");
        int choose = input.nextInt();

        switch (choose) {
            case 1:crud.addItem();
                break;
            case 2:crud.removeItem();
                break;
            case 3:crud.updateItem();
                break;
            case 4:crud.diplayItem();
                break;
            case 5:checkout.finalBill();
            	break;
            default:
                System.out.print("There is no such option.");
        }
    }
}