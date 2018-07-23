import java.text.ParseException;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;



class Store implements Discounts {
    private Scanner sc = new Scanner(System.in);
    List < String > selecteditem;
    CRUD crud = new CRUD();
    List < Integer > selecteditemquantity;

    Store(HashMap < String, Integer > map) {
        this.selecteditemquantity = new ArrayList < > ();
        this.selecteditem = new ArrayList < > ();
    }

    public List < Integer > getselecteditemquantity() {//selecteditemquantity arraylist or the item quantity in cart that we have to used in CRUD 
        return selecteditemquantity;
    }

    public List < String > getselecteditem() {			//selecteditem arraylist or the item in cart that we have to used in CRUD 
        return selecteditem;
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
        if (selecteditem.isEmpty()) {
            check(map);
        } else {
            int i = 0;
            int selecteditem_size = selecteditem.size();
            double SUM = 0.0;
            System.out.println("Item\tQuantity\tPrice\tTotal");
            while (selecteditem_size > 0) {
                SUM += selecteditemquantity.get(i) *
                    map.get(selecteditem.get(i));
                System.out.println(selecteditem.get(i) + "\t" +
                    selecteditemquantity.get(i) + "\t\t" +
                    map.get(selecteditem.get(i)) + "\t" +
                    selecteditemquantity.get(i) *
                    map.get(selecteditem.get(i)));
                selecteditem_size--;
                i++;
            }
            System.out.println("Total Amount : " + SUM);
            int discountpercentage = getFixedDiscount(SUM);
            double amount = setFixedDiscount(SUM, discountpercentage);
            System.out.println("Discount % : " + discountpercentage);
            System.out.println("Total Amount after avail Discount: " + amount);
            System.out.println("Apply Promo code here : ");
            String promo_code = sc.next();
            int discountPercentagePromoCode = 0;
            if (isPromotionApplicable(promo_code)) {
                discountPercentagePromoCode = getMinimumPrice(amount, promo_code);
                if (discountPercentagePromoCode == 0) {
                    System.out.print("Sorry but this promo code is apply due to minimum amount balance.");
                }
            } else {
                System.out.println("Sorry but this promo code is not valid.");
            }

            amount = setMinimumPrice(amount, discountPercentagePromoCode);
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
        int discountPercentagePromoCode = 0;
        if (Amount > 10000) {
            discountPercentagePromoCode = 5;
            return discountPercentagePromoCode;
        } else {
            return discountPercentagePromoCode;
        }
    }

    @Override
    public double setMinimumPrice(double amount, int promoDiscount) { //return amount after apply promo code discount
        double Amount = amount;
        int promoDiscount = promoDiscount;
        Amount = Amount * (100 - promoDiscount) / 100;
        return Amount;
    }

    @Override
    public int getFixedDiscount(double SUM) { //return fix discount on product bill
        int discountpercentage = 0;
        if ((1000 < SUM) && (SUM < 5000)) {
            discountpercentage = 5;
        } else if (SUM >= 5000) {
            discountpercentage = 10;
        }
        return discountpercentage;

    }

    @Override
    public double setFixedDiscount(double sum, int discount) { //return amount after applying the fixed discount
        double sum = SUM;
        int Discount = discount;
        sum = sum * (100 - Discount) / 100;
        return sum;
    }
}