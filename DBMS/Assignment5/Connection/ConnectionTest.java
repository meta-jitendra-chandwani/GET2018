import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ConnectionTest {

	private List<Connection_POJO> connectionList;
	private List<String> actualOrderIdList;
	private List<String> expectedOrderIdList;

	private List<String> actualOrderDateList;
	private List<String> expectedOrderDateList;

	private List<Double> actualOrderTotalList;
	private List<Double> expectedOrderTotalList;

	@Before
	public void initialize() {
		connectionList = ConnectionJDBC.getPojoList();
		actualOrderIdList = new ArrayList<String>();
		actualOrderIdList.add("Order01/3");
		actualOrderIdList.add("Order01/2");
		actualOrderIdList.add("Order01/4");

		actualOrderDateList = new ArrayList<String>();
		actualOrderDateList.add("2018-08-10");
		actualOrderDateList.add("2018-05-15");
		actualOrderDateList.add("2017-05-23");

		actualOrderTotalList = new ArrayList<Double>();
		actualOrderTotalList.add(3965.0);
		actualOrderTotalList.add(1299.0);
		actualOrderTotalList.add(799.0);

		expectedOrderTotalList = new ArrayList<Double>();
		for (int i = 0; i < connectionList.size(); i++) {
			expectedOrderTotalList.add(connectionList.get(0).getOrder_Total());
		}

		expectedOrderDateList = new ArrayList<String>();
		for (int i = 0; i < connectionList.size(); i++) {
			expectedOrderDateList.add(connectionList.get(0).getOrder_Date()
					.toString());
		}

		expectedOrderIdList = new ArrayList<String>();
		for (int i = 0; i < connectionList.size(); i++) {
			expectedOrderIdList.add(connectionList.get(0).getOrder_Id());
		}

	}

	@Test
	public void orderIdTestCase() {
		for (int i = 0; i < connectionList.size(); i++) {
			assertEquals(expectedOrderIdList.get(i), actualOrderIdList.get(i));
		}
	}

	@Test
	public void orderDateTestCase() {
		for (int i = 0; i < connectionList.size(); i++) {
			assertEquals(expectedOrderDateList.get(i),
					actualOrderDateList.get(i));
		}
	}

	@Test
	public void orderTotalTestCase() {
		for (int i = 0; i < connectionList.size(); i++) {
			assertEquals(expectedOrderTotalList.get(i),
					actualOrderTotalList.get(i));
		}
	}
}
