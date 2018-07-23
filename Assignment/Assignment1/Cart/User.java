import java.util.Scanner;

public class User {
    Crud crud = new Crud();
    Scanner input = new Scanner(System.in);
    char reply = crud.reply;
    void Option() throws Exception {
        System.out.println("\n1. Add the item\n2. Remove Item\n3. Update the Cart\n4. Display Cart Item\n5. Proceed to Bill");
        System.out.print("Enter your choice : ");

        int choose = input.nextInt();

        switch (choose) {
            case 1:
                crud.addItem();
                break;
            case 2:
                crud.removeItem();
                break;
            case 3:
                crud.updateItem();
                break;
            case 4:
                crud.diplayItem();
                break;
            case 5:
                crud.proceedBill();
                break;
            default:
                System.out.print("There is no such option.");
        }
        if (reply == 'n' || reply == 'N') {
            Option();
        }

    }

    public static void main(String[] args) throws Exception {
        User ui = new User();
        ui.Option();

    }
}