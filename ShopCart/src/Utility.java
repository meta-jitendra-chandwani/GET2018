import java.util.List;
import java.util.Scanner;

public class Utility {
    private final Product product;
    List < Product > list;
    private final Cart cart;
    List < Cart > cartList;
    private final Scanner input = new Scanner(System.in);

    public Utility() {
        product = new Product();
        list = product.getProductList();
        cart = new Cart();
        cartList = cart.getCartList();
    }



    void addToCart() throws Exception { //Item that you wants to add into cart
        displayItem();
        System.out.print("\t\tChoose the Item to put into cart : ");
        String itemName = input.next();

        int itemPrice = findPrice(itemName);

        System.out.print("\t\tQuantity : ");
        int itemQuantity = input.nextInt();

        int itemDiscount = findDiscount(itemName);
        cartList.add(new Cart(itemName, itemPrice, itemQuantity, itemDiscount));
        
    }


    void updateCart() throws Exception { //For update the cart item such as quantity and remove item
    System.out.print("Please enter item name to update : ");
        String update_item = input.next();
        System.out.print("Enter Quantity : ");
        for (int i = 0; i < cartList.size(); i++) {
            if (cartList.get(i) == null ? update_item == null :
                (cartList.get(i).Name).equals(update_item)) {
                cartList.get(i).Quantity=input.nextInt();
            }
        }
        cartDisplay();
    }

    void Remove() throws Exception { //to remove item from cart
        boolean flag = true;

        System.out.print("Please enter item Product name to remove : ");
        String remove_item = input.next();
        for (int i = 0; i < cartList.size(); i++) {
            if ((cartList.get(i).Name).equals(remove_item)) {
                cartList.remove(i);
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Sorry this item is not into your cart.\nThe Item into your cart are :  ");
        }

        cartDisplay();

    }

   
    void billPrepared() throws Exception {
//         if (selecteditem.isEmpty()) {
//            check(map);
//        } else {
//            int i = 0;
//            int selecteditem_size = selecteditem.size();
//            double SUM = 0.0;
//            System.out.println("Item\tQuantity\tPrice\tTotal");
//            while (selecteditem_size > 0) {
//                SUM += selecteditemquantity.get(i) *
//                    map.get(selecteditem.get(i));
//                System.out.println(selecteditem.get(i) + "\t" +
//                    selecteditemquantity.get(i) + "\t\t" +
//                    map.get(selecteditem.get(i)) + "\t" +
//                    selecteditemquantity.get(i) *
//                    map.get(selecteditem.get(i)));
//                selecteditem_size--;
//                i++;
//            }
//            System.out.println("Total Amount : " + SUM);
//            int discountpercentage = getFixedDiscount(SUM);
//            double amount = setFixedDiscount(SUM, discountpercentage);
//            System.out.println("Discount % : " + discountpercentage);
//            System.out.println("Total Amount after avail Discount: " + amount);
//            System.out.println("Apply Promo code here : ");
//            String promo_code = sc.next();
//            int discountPercentagePromoCode = 0;
//            if (isPromotionApplicable(promo_code)) {
//                discountPercentagePromoCode = getMinimumPrice(amount, promo_code);
//                if (discountPercentagePromoCode == 0) {
//                    System.out.print("Sorry but this promo code is apply due to minimum amount balance.");
//                }
//            } else {
//                System.out.println("Sorry but this promo code is not valid.");
//            }
//
//            amount = setMinimumPrice(amount, discountPercentagePromoCode);
//            System.out.println("Here the final amount: " + amount);
//
//
    }

    int find(String Name) throws Exception {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (Name.equals(list.get(i).Name)) {
                index = i;
            }
        }
        if (index == -1) {
            System.err.println("No such Product");
        }
        return index;
    }

    int findPrice(String Name) throws Exception {
        int index = find(Name);
        return (list.get(index).Price);
    }

    int findDiscount(String Name) throws Exception {
        int index = find(Name);
        return (list.get(index).Discount);
    }

    void cartDisplay() throws Exception {
        System.out.println("Name\tPrice\tQuantity\tDisount(%)");
        for (int i = 0; i < cartList.size(); i++) {
            System.out.println(cartList.get(i).Name + "\t" + cartList.get(i).Price + "\t" + cartList.get(i).Quantity + "\t" + cartList.get(i).Discount);
        }
    }

    void displayItem() throws Exception {
        System.out.println("Name\tPrice\tDisount(%)");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).Name + "\t" + list.get(i).Price + "\t" + list.get(i).Discount);
        }
    }


}