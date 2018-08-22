import java.sql.*;

import com.mysql.jdbc.Statement;
/**
 * Assignment - Simple JDBC Class to call Procedure 
 * @author Jitendra Chandwani
 *
 */
public class Assignment {
	public int numberOfRowUpdated;

	/**
	 * procedureQuery - Execute Procedure that already exist
	 */
	public void procedureQuery() {
		try (Connection conn = getConnection();
				Statement stmt = (Statement) conn.createStatement();) {
			try {			
				int result = stmt.executeUpdate(Query_Class.CALL_PROCEDURE);
				AssignmentPOJO assignmentPOJO = new AssignmentPOJO(result);
				numberOfRowUpdated = assignmentPOJO.getNumberOfRowUpdated();
			} catch (SQLException ex) {
				System.out.println("Exception");
				ex.printStackTrace();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
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