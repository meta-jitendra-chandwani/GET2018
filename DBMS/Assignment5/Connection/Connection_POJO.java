import java.sql.Date;

public class Connection_POJO {
	private String Order_Id;
	private Date Order_Date;
	private Double Order_Total;

	public Connection_POJO(String order_Id, Date order_Date, Double order_Total) {
		Order_Total = order_Total;
		Order_Id = order_Id;
		Order_Date = order_Date;
	}

	public Double getOrder_Total() {
		return Order_Total;
	}

	public String getOrder_Id() {
		return Order_Id;
	}

	public Date getOrder_Date() {
		return Order_Date;
	}

}
