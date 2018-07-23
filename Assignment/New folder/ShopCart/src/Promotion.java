
public enum Promotion {
	PromoCode("NEW15", "2018-07-15", "2018-08-15");
    String code;
	String startDate;
	String endDate;

    private Promotion(String code, String startDate, String endDate) {
        this.code = code;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
