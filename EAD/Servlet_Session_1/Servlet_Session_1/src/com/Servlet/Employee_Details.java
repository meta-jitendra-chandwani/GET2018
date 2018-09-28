package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Employee_Details
 */
public class Employee_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Connection_POJO> pojoList = new ArrayList<Connection_POJO>();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection conn = JDBCConnection.getDatabaseConnection("Employee",
				"root", "root");
		if (conn != null) {
			System.out.println("Connection In");
			Statement preparedStatement = null;
			try {
				preparedStatement = (Statement) conn.createStatement();
				ResultSet resultSet = preparedStatement.executeQuery(Query.SELECT_ALL_EMPLOYEE);
				out.println("<html>");
				out.println("<body>");
				out.println("<table border=1 align='center'>");
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
						+ "<td><label><b>"
						+ "Update"
						+ "</b></label></td>"
						+ "</tr>");
				while (resultSet.next()) {
					String First_Name = resultSet.getString(1);
					String Last_Name = resultSet.getString(2);
					int age = resultSet.getInt(3);
					String Email = resultSet.getString(4);
					
						out.println("<form action='Update_Employee'>");
						out.println("<tr>"
								+ "<td>"
								+ First_Name
								+ "</td>"
								+"<td>"
								+ Last_Name
								+ "</td>"
								+"<td>"
								+ age
								+ "</td>"
								+"<td>"
								+ Email
								+ "</td>"
								+ "<td>"
								+"<input name='id' type='hidden' value='"+Email+"'>"
								+ "<input type='submit' value='Edit'>"								
								+ "</td>"
								+ "</tr>");
						out.println("</form>");
					}
					out.println("</table>");					
					out.println("</body>");
					out.println("</html>");
					conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("Database Connectivity Error!!");
		}
	}
	@Override
	public void destroy() {
		super.destroy();
	}
}