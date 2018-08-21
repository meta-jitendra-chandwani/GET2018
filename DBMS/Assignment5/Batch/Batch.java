import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Batch {
	public int numberOfRowUpdated;

	public void batchProcessing() {
		try (Connection conn = getConnection();
				PreparedStatement stmt = conn
						.prepareStatement(Query_Class.INSERT_QUERY);) {
			try {
				conn.setAutoCommit(false);
				System.out.println("The SQL query is: "
						+ Query_Class.INSERT_QUERY);

				stmt.setInt(1, 10113);
				stmt.setInt(2, 1011);
				stmt.addBatch();

				stmt.setInt(1, 10103);
				stmt.setInt(2, 1010);
				stmt.addBatch();

				stmt.setInt(1, 10093);
				stmt.setInt(2, 1009);
				stmt.addBatch();

				stmt.setInt(1, 10083);
				stmt.setInt(2, 1008);
				stmt.addBatch();

				stmt.setInt(1, 10073);
				stmt.setInt(2, 1007);
				stmt.addBatch();

				stmt.setInt(1, 10063);
				stmt.setInt(2, 1006);
				stmt.addBatch();

				int[] result = stmt.executeBatch();
				BatchPojo batchPojo = new BatchPojo(result.length);
				numberOfRowUpdated=batchPojo.getNumberOfRowUpdated();
				conn.commit();

			} catch (SQLException ex) {
				ex.printStackTrace();
				conn.rollback();
			}
		} catch (SQLException e) {
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