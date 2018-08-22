import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;
/**
 * Assignment - Simple JDBC Class to call Procedure 
 * @author Jitendra Chandwani
 *
 */
public class Assignment {
	static List<AssignmentPOJO> PojoList = new ArrayList<AssignmentPOJO>();

	/**
	 * procedureQuery - Execute Procedure that already exist
	 */
	public void procedureQuery() {
		try (Connection conn = getConnection();
				Statement stmt = (Statement) conn.createStatement();) {
			try {			
				
				ResultSet resultSet = stmt.executeQuery(Query_Class.QUERY);

				while (resultSet.next()) {
					String Parent = resultSet.getString("Category_Title");
					int numberOfChild = resultSet.getInt("count_Of_Child");
					
					AssignmentPOJO conPojo = new AssignmentPOJO(Parent, numberOfChild);
					PojoList.add(conPojo);
				}
			} catch (SQLException ex) {
				System.out.println("Exception");
				ex.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * getPojoList - to get pojo list of connection
	 * @return - Pojo List of Connection
	 */
	public static List<AssignmentPOJO> getPojoList() {
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