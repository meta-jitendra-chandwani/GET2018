import java.text.ParseException;



	interface Discounts {

		double setMinimumPrice(double amount, int promo_discount);

		int getMinimumPrice(double amount, String code) throws ParseException;

		public int getFixedDiscount(double SUM);

		public double setFixedDiscount(double SUM, int discount);

		boolean isPromotionApplicable(String code) throws ParseException;
	}

