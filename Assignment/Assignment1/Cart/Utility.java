import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Utility implements Discount {
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

    void addToCart() throws Exception { // Item that you wants to add into cart
        displayItem();
        System.out.print("\t\tChoose the Item to put into cart : ");
        String itemName = input.next();

        int itemPrice = findPrice(itemName);

        System.out.print("\t\tQuantity : ");
        int itemQuantity = input.nextInt();

        int itemDiscount = findDiscount(itemName);
        cartList.add(new Cart(itemName, itemPrice, itemQuantity, itemDiscount));

    }

    void updateCart() throws Exception { // For update the cart item such as
        if (!isEmpty()) { // quantity and remove item
            boolean flag = true;

            System.out.print("Please enter item name to update : ");
            String update_item = input.next();
            System.out.print("Enter Quantity : ");
            for (int i = 0; i < cartList.size(); i++) {
                if (cartList.get(i) == null ? update_item == null : (cartList
                        .get(i).Name).equals(update_item)) {
                    cartList.get(i).Quantity = input.nextInt();
                    flag = false;
                }
            }
            if (flag) {
                System.out
                    .println("Sorry this item is not into your cart.\nThe Item into your cart are :  ");
            }
            cartDisplay();
        }
    }

    boolean isEmpty() throws Exception {
        if (cartList.size() == 0) {
            System.out
                .println("The cart is empty. Please add item into the cart.");
            return true;
        } else {
            return false;
        }
    }

    void Remove() throws Exception { // to remove item from cart
        if (!isEmpty()) {
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
                System.out
                    .println("Sorry this item is not into your cart.\nThe Item into your cart are :  ");
            }

            cartDisplay();
        }

    }

    void billPrepared() throws Exception {
        if (!isEmpty()) {
            int i = 0;
            int cartSize = cartList.size();
            double SUM = 0.0;
            System.out.println("Item\tPrice\tQuantity\tDiscount\tTotal");
            while (cartSize > 0) {
            	int discountPercentage = getFixedDiscount(cartList.get(i).Name);
               SUM+= setFixedDiscount(cartList.get(i).Name,discountPercentage);
                 
                System.out.println(cartList.get(i).Name + "\t" + cartList.get(i).Price + "\t" + cartList.get(i).Quantity + "\t\t" + cartList.get(i).Discount + "\t\t" + cartList.get(i).Price * cartList.get(i).Quantity * (100 - cartList.get(i).Discount) / 100);
                cartSize--;
                i++;
            }
           
            System.out.println("Total Amount after avail Discount: " + SUM);
            System.out.println("Apply Promo code here : ");
            String promo_code = input.next();
            int discountPercentagePromoCode = 0;
            if (isPromotionApplicable(promo_code)) {
                discountPercentagePromoCode = getMinimumPrice(SUM, promo_code);
                if (discountPercentagePromoCode == 0) {
                    System.out.print("Sorry but this promo code will not apply due to minimum amount balance.");
                }
            } else {
                System.out.println("Sorry but this promo code is not valid.");
            }

            SUM = setMinimumPrice(SUM, discountPercentagePromoCode);
            System.out.println("Here the final amount: " + SUM);
        }


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
    
    int findCart(String Name) throws Exception {
        int index = -1;
        for (int i = 0; i < cartList.size(); i++) {
            if (Name.equals(cartList.get(i).Name)) {
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
        if (!isEmpty()) {
            System.out.println("\nName\tPrice\tQuantity\tDisount(%)");
            for (int i = 0; i < cartList.size(); i++) {
                System.out.println(cartList.get(i).Name + "\t" +
                    cartList.get(i).Price + "\t" + cartList.get(i).Quantity +
                    "\t\t" + cartList.get(i).Discount);
            }
        }
    }

    void displayItem() throws Exception {
        System.out.println("\nName\tPrice\tDisount(%)");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).Name + "\t" + list.get(i).Price +
                "\t" + list.get(i).Discount);
        }
    }

    @Override
    public boolean isPromotionApplicable(String code) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now(); //System or Current Date
        if (dtf.format(now).compareTo(Promotion.PromoCode.startDate) >= 0) { //check whether current date is valid or not
            if (dtf.format(now).compareTo(Promotion.PromoCode.endDate) <= 0) { //if yes then check promo code enter by user
                if (code.equals(Promotion.PromoCode.code)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public int getMinimumPrice(double amount, String code) //return discount avail on promo code
    throws ParseException {
        double Amount = amount;
        int Discount_percentage_promo_code = 0;
        if (Amount > 10000) {
            Discount_percentage_promo_code = 5;
            return Discount_percentage_promo_code;
        } else {
            return Discount_percentage_promo_code;
        }
    }

    @Override
    public double setMinimumPrice(double amount, int promo_discount) { //return amount after apply promo code discount
        double Amount = amount;
        int Promo_Discount = promo_discount;
        Amount = Amount * (100 - Promo_Discount) / 100;
        return Amount;
    }

    @Override
    public int getFixedDiscount(String itemName) throws Exception { //return fix discount on product bill
        int index=findCart(itemName);
        return cartList.get(index).Discount;
    }

    @Override
    public double setFixedDiscount(String itemName, int discount) throws Exception { //return amount after applying the fixed discount
    	 int i=findCart(itemName);
    	double SUM = cartList.get(i).Price * cartList.get(i).Quantity * (100 - cartList.get(i).Discount) / 100;
    	return SUM;
    }

}