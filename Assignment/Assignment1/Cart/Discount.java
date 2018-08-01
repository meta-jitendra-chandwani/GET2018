import java.text.ParseException;



	interface Discount {

		double setMinimumPrice(double amount, int promo_discount);

		int getMinimumPrice(double amount, String code) throws ParseException;

		public int getFixedDiscount(String itemName) throws Exception;

		public double setFixedDiscount(String itemName, int discount) throws Exception;

		boolean isPromotionApplicable(String code) throws ParseException;
	}

