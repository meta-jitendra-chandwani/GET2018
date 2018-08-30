package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;
import com.DAO.Query;
import com.POJO.Connection_POJO;

/**
 * Servlet implementation class Search_Employee
 */
public class Search_Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Connection_POJO> pojoList = new ArrayList<Connection_POJO>();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("f_name");
		String lastName = request.getParameter("l_name");

		PrintWriter out = response.getWriter();

		Connection conn = JDBCConnection.getDatabaseConnection("Employee",
				"root", "root");
		if (conn != null) {
			System.out.println("Connection In");
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn
						.prepareStatement(Query.SELECT_EPMLOYEE);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				preparedStatement.setString(1, firstName);
				preparedStatement.setString(2, lastName);

				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					String First_Name = resultSet.getString(1);
					String Last_Name = resultSet.getString(2);
					int age = resultSet.getInt(3);
					String Email = resultSet.getString(4);

					Connection_POJO conPojo = new Connection_POJO(First_Name,
							Last_Name, age, Email);
					pojoList.add(conPojo);
				}
				if (pojoList.size() > 0) {
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("index.html");
					requestDispatcher.include(request, response);
					out.println("<html>");
					out.println("<body>");
					out.println("<table align='center' style='padding-left: 270px'>");
					out.println("<tr>"
							+ "<td><label><b>"
							+ "First Name"
							+ "</b></label></td>"
							+ "<td><label><b>"
							+ "Last Name"
							+ "</b></label></td>"
							+ "<td><label><b>"
							+ "Age"
							+ "</b></label></td>"
							+ "<td><label><b>"
							+ "Email"
							+ "</b></label></td>"
							+ "</tr>");

					for (Connection_POJO value : pojoList) {
						out.println("<tr>"
								+ "<td><label><b>"
								+ value.getFirstName()
								+ "</b></label></td>"
								+"<td><label><b>"
								+ value.getLastName()
								+ "</b></label></td>"
								+"<td><label><b>"
								+ value.getAge()
								+ "</b></label></td>"
								+"<td><label><b>"
								+ value.getEmail()
								+ "</b></label></td>"
								+ "</tr>");
					}
					out.println("</table>");
					out.println("</body>");
					out.println("</html>");
				} else {
					response.sendRedirect("Error.html");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("Database Connectivity Error!!");
		}
	}

}
