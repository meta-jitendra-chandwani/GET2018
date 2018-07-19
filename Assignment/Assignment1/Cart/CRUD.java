import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CRUD {
    Scanner sc = new Scanner(System.in);
    List < String > selected_item;
    List < Integer > selected_item_quantity;
    Store cart;
    Product product = new Product();
    HashMap < String, Integer > Product;

    void getProductDetails() {
        Product = product.getPeopleMap();
        product.setProduct(Product);
        cart = new Store(Product);

        selected_item = cart.getselected_item();
        selected_item_quantity = cart.getselected_item_quantity();

    }

    void Option() throws Exception {
        System.out
            .println("\n1. Add the item\n2. Update the Cart\n3. Display Cart Item\n4. Proceed to Bill");
        System.out.print("Enter your choice : ");
        int choose = sc.nextInt();

        switch (choose) {
            case 1:
                itemList(Product);
                break;
            case 2:
                updateCart(Product);
                break;
            case 3:
                displayItem(Product);
                break;
            case 4:
                cart.finalBill(Product);
                break;
            default:
                System.out.print("There is no such option.");
        }
    }

    void itemList(HashMap < String, Integer > map) throws Exception { //Display Item List
        System.out.print("\n\t\tItem\t\t\t\tPrice\n");
        map.keySet().forEach(key -> System.out.println("\t\t" + key + "\t\t\t\t" + map.get(key)));
        this.addToCart(map);
    }

    void addToCart(HashMap < String, Integer > map) throws Exception { //Item that you wants to add into cart
        System.out.print("\t\tChoose the Item to put into cart : ");
        String item_choose = sc.next();
        selected_item.add(item_choose);
        System.out.print("\t\tQuantity : ");
        int quantity = sc.nextInt();
        selected_item_quantity.add(quantity);
        System.out.print("Do you want to add more item into your cart(Y/N) : ");
        char reply = sc.next().charAt(0);
        if (reply == 'Y' || reply == 'y') {
            itemList(map);
        } else {
            Option();
        }
    }

    void displayItem(HashMap < String, Integer > map) throws Exception { //display the item in cart
        if (!selected_item.isEmpty()) {
            int i = 0;
            System.out.println("Item\t\t\tQuantity");
            int selected_item_size = selected_item.size();
            while (selected_item_size > 0) {
                System.out.println(selected_item.get(i) + "\t\t\t" +
                    selected_item_quantity.get(i));
                selected_item_size--;
                i++;
            }
            System.out.print("Do you want to checkout(Y/N) : ");
            char reply = sc.next().charAt(0);
            if (reply == 'Y' || reply == 'y') {
                cart.finalBill(map);
            } else {
                Option();
            }
        } else {
            cart.check(map);
        }
    }

    void updateCart(HashMap < String, Integer > map) throws Exception { //For update the cart item such as quantity and remove item
        if (!selected_item.isEmpty()) {
            System.out.println("1. Remove Item\n2. Change the quantity");
            System.out.print("Enter your choice : ");
            switch (sc.nextInt()) {
                case 1:
                    Remove(map);
                    break;
                case 2:
                    changeQuantity(map);
                    break;
                default:
                    System.out.print("There is no such option.");
            }
        } else {
            cart.check(map);
        }
    }

    void Remove(HashMap < String, Integer > map) throws Exception { //to remove item from cart
        System.out.print("Please enter item Product name to remove : ");
        String remove_item = sc.next();
        for (int i = 0; i < selected_item.size(); i++) {
            if (selected_item.get(i).equals(remove_item)) {
                selected_item.remove(i);
                selected_item_quantity.remove(i);
            } else {
                System.out.println("Sorry this item is not into your cart.");
                updateCart(Product);
            }
        }
        displayItem(map);
    }

    void changeQuantity(HashMap < String, Integer > map) throws Exception { //to  change the quantity of particular item
        System.out.print("Please enter item name to update : ");
        String update_item = sc.next();
        int index = 0;
        for (int i = 0; i < selected_item.size(); i++) {
            if (selected_item.get(i) == null ? update_item == null :
                selected_item.get(i).equals(update_item)) {
                index = i;
            }
        }
        System.out.print("Enter Quantity : ");
        selected_item_quantity.set(index, sc.nextInt());
        displayItem(map);
    }

    public static void main(String[] args) throws Exception {
        CRUD crud = new CRUD();
        crud.getProductDetails();
        crud.Option();
    }
}