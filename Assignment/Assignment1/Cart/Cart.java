import java.text.ParseException;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;



class Store implements Discounts {
    private Scanner sc = new Scanner(System.in);
    List < String > selected_item;
    CRUD crud = new CRUD();
    List < Integer > selected_item_quantity;

    Store(HashMap < String, Integer > map) {
        this.selected_item_quantity = new ArrayList < > ();
        this.selected_item = new ArrayList < > ();
    }

    public List < Integer > getselected_item_quantity() {//selected_item_quantity arraylist or the item quantity in cart that we have to used in CRUD 
        return selected_item_quantity;
    }

    public List < String > getselected_item() {			//selected_item arraylist or the item in cart that we have to used in CRUD 
        return selected_item;
    }

    enum PromotionEnum {				//promocode enum which contains promo code, start date and end date.

        PromoCode("NEW15", "2018-07-15", "2018-08-15");
        private String code, startDate, endDate;

        private PromotionEnum(String code, String startDate, String endDate) {
            this.code = code;
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }


    void check(HashMap < String, Integer > map) throws Exception {				//to check whether cart contain some item or not
        System.out.println("Sorry but there is no item in your cart to display");
        System.out.print("Do you want to add item into your cart(Y/N) : ");
        char reply = sc.next().charAt(0);
        if (reply == 'Y' || reply == 'y') {

            crud.itemList(map);
        } else {
            crud.Option();
        }
    }

    void finalBill(HashMap < String, Integer > map) throws Exception {	// to generate the bill
        if (selected_item.isEmpty()) {
            check(map);
        } else {
            int i = 0;
            int selected_item_size = selected_item.size();
            double SUM = 0.0;
            System.out.println("Item\tQuantity\tPrice\tTotal");
            while (selected_item_size > 0) {
                SUM += selected_item_quantity.get(i) *
                    map.get(selected_item.get(i));
                System.out.println(selected_item.get(i) + "\t" +
                    selected_item_quantity.get(i) + "\t\t" +
                    map.get(selected_item.get(i)) + "\t" +
                    selected_item_quantity.get(i) *
                    map.get(selected_item.get(i)));
                selected_item_size--;
                i++;
            }
            System.out.println("Total Amount : " + SUM);
            int Discount_percentage = getFixedDiscount(SUM);
            double amount = setFixedDiscount(SUM, Discount_percentage);
            System.out.println("Discount % : " + Discount_percentage);
            System.out.println("Total Amount after avail Discount: " + amount);
            System.out.println("Apply Promo code here : ");
            String promo_code = sc.next();
            int Discount_percentage_promo_code = 0;
            if (isPromotionApplicable(promo_code)) {
                Discount_percentage_promo_code = getMinimumPrice(amount, promo_code);
                if (Discount_percentage_promo_code == 0) {
                    System.out.print("Sorry but this promo code is apply due to minimum amount balance.");
                }
            } else {
                System.out.println("Sorry but this promo code is not valid.");
            }

            amount = setMinimumPrice(amount, Discount_percentage_promo_code);
            System.out.println("Here the final amount: " + amount);
        }
    }

    @Override
    public boolean isPromotionApplicable(String code) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now(); //System or Current Date
        if (dtf.format(now).compareTo(PromotionEnum.PromoCode.startDate) >= 0) { //check whether current date is valid or not
            if (dtf.format(now).compareTo(PromotionEnum.PromoCode.endDate) <= 0) { //if yes then check promo code enter by user
                if (code.equals(PromotionEnum.PromoCode.code)) {
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
    public int getFixedDiscount(double SUM) { //return fix discount on product bill
        int Discount_percentage = 0;
        if ((1000 < SUM) && (SUM < 5000)) {
            Discount_percentage = 5;
        } else if (SUM >= 5000) {
            Discount_percentage = 10;
        }
        return Discount_percentage;

    }

    @Override
    public double setFixedDiscount(double SUM, int discount) { //return amount after applying the fixed discount
        double sum = SUM;
        int Discount = discount;
        sum = sum * (100 - Discount) / 100;
        return sum;
    }
}