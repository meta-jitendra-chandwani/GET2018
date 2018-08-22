import java.sql.Date;

/**
 * Connection POJO - For set and get the value of Order_Id, Order_Date and Order_Total
 * @author Jitendra Chandwani
 *
 */
public class Connection_POJO {
	private String Order_Id;
	private Date Order_Date;
	private Double Order_Total;

	public Connection_POJO(String order_Id, Date order_Date, Double order_Total) {
		Order_Total = order_Total;
		Order_Id = order_Id;
		Order_Date = order_Date;
	}

	/**
	 * getOrder_Total - get order total price
	 * @return order total price
	 */
	public Double getOrder_Total() {
		return Order_Total;
	}

	/**
	 * getOrder_Id - get order id
	 * @return order id
	 */
	public String getOrder_Id() {
		return Order_Id;
	}

	/**
	 * getOrder_Date - get order date
	 * @return order date
	 */
	public Date getOrder_Date() {
		return Order_Date;
	}

}
