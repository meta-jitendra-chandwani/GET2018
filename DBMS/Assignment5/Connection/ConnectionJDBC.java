import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * ConnectionJDBC - Simple JDBC Class used for select data from table
 * @author Jitendra Chandwani
 *
 */
public class ConnectionJDBC {
	static List<Connection_POJO> PojoList = new ArrayList<Connection_POJO>();

	public static void main(String[] args) {
		try (
				Connection conn = getConnection();
				PreparedStatement preparedStatement = conn.prepareStatement(Query_Class.SELECT_QUERY);
			) {
			
			preparedStatement.setString(1, "Shopper/01");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String Order_Id = resultSet.getString("Order_Id");
				Date Order_Date = resultSet.getDate("Order_Date");
				double Order_Total = resultSet.getDouble("Order_Total");
				
				Connection_POJO conPojo = new Connection_POJO(Order_Id,Order_Date, Order_Total);
				PojoList.add(conPojo);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * getPojoList - to get pojo list of connection
	 * @return - Pojo List of Connection
	 */
	public static List<Connection_POJO> getPojoList() {
		return PojoList;
	}

	/**
	 * getConnection - Establish Connection with Database
	 * @return connection
	 */
	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/StoreFront";
			conn = DriverManager.getConnection(url, "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(2);
		}
		return conn;
	}
}