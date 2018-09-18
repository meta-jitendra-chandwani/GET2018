import java.sql.*;

import com.mysql.jdbc.Statement;

/**
 * UpdateQuery - Simple JDBC Class used for update query
 * @author Jitendra Chandwani
 *
 */
public class UpdateQuery {
	public int numberOfRowUpdated;

	/**
	 * updateQuery - update query function
	 */
	public void updateQuery() {
		try (Connection conn = getConnection();
				Statement stmt = (Statement) conn.createStatement();) {
			try {
				stmt.execute(Query_Class.UPDATE_SAFE);
				int result = stmt.executeUpdate(Query_Class.UPDATE_QUERY);
				UpdatePojo updatePojo = new UpdatePojo(result);
				numberOfRowUpdated = updatePojo.getNumberOfRowUpdated();
			} catch (SQLException ex) {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}