package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;
import com.DAO.Query;
import com.POJO.Connection_POJO;

/**
 * Servlet implementation class Update_Employee
 */
public class Update_Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public List<Connection_POJO> pojoList = new ArrayList<Connection_POJO>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		PrintWriter out = response.getWriter();

		Connection conn = JDBCConnection.getDatabaseConnection("Employee",
				"root", "root");
		if (conn != null) {
			System.out.println("Connection In");
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn
						.prepareStatement(Query.SELECT_EPMLOYEE_BY_EMAIL);
				preparedStatement.setString(1, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				out.println("<html>");
				out.println("<body>");
				out.println("<form action='Update_To_DB'>");

				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()){
					String First_Name = resultSet.getString(1);
					String Last_Name = resultSet.getString(2);
					int age = resultSet.getInt(3);
					String Email = resultSet.getString(4);
				
				out.println("<table border=1 align='center' style='padding-left: 270px'>");
				out.println("<tr style='padding:5px'>" + "<td><label><b>"
						+ "First Name" + "</b></label></td>"
						+ "<td><input type='text' name='f_name' value="
						+ First_Name + "><b>" + "</tr>");

				out.println("<tr style='padding:5px'>" + "<td><label><b>"
						+ "Last Name" + "</b></label></td>"
						+ "<td><input type='text' name='l_name' value="
						+ Last_Name + "><b>" + "</tr>");

				out.println("<tr style='padding:5px'>" + "<td><label><b>"
						+ "Age" + "</b></label></td>"
						+ "<td><input type='text' name='age'  value=" + age
						+ "><b>" + "</tr>");

				out.println("<tr style='padding:5px'>"
						+ "<td><label><b>"
						+ "Email"
						+ "</b></label></td>"
						+ "<td><input readonly type='text' name='email'  value="
						+ Email + "><b>" + "</tr>");

				out.println("<tr style='padding:5px'>" + "<td>"
						+ "<input type='submit' value='Update'>" + "</td>"
						+ "</tr>");
				out.println("</table>");
				}
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
				conn.close();
			}

			catch (SQLException e) {
				System.out.println("Exception occur");
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("Database Connectivity Error!!");
		}
	}
}