import java.sql.*;

import com.mysql.jdbc.Statement;

public class UpdateQuery {
	public int numberOfRowUpdated;

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