import java.util.Scanner;

public class Crud {
    Utility util = new Utility();
    Scanner input = new Scanner(System.in);
    char reply;
    public Crud() {
        reply = 'n';
    }

    void addItem() throws Exception {
        do {
            util.addToCart();
            System.out.print("Do you want to add more item into your cart(Y/N) : ");
            reply = input.next().charAt(0);
        } while (reply == 'y' || reply == 'Y');
    }

    void removeItem() throws Exception {
        util.Remove();
    }

    void updateItem() throws Exception {
        util.updateCart();
    }

    void diplayItem() throws Exception {
        util.cartDisplay();
    }

    void proceedBill() throws Exception {
        util.billPrepared();
    }

}