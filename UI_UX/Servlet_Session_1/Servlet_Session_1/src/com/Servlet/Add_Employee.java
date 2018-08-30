package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;
import com.DAO.Query;

/**
 * Servlet implementation class Add_Employee
 */
public class Add_Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("f_name");
		String lastName = request.getParameter("l_name");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");

		PrintWriter out = response.getWriter();

		Connection conn = JDBCConnection.getDatabaseConnection(
				"Employee", "root", "root");
		if(conn!=null){
			System.out.println("Connection In");
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn.prepareStatement(Query.INSERT);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				preparedStatement.setString(1, firstName);
				preparedStatement.setString(2, lastName);
				preparedStatement.setInt(3, age);
				preparedStatement.setString(4, email);

				int result = preparedStatement.executeUpdate();
				if (result > 0) {
					out.println("<html>");
					out.println("<h2 style=\"color:green;text-align:center;\">Employee Successfully Added !</h2>");
					out.println("</html>");

					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("index.html");
					requestDispatcher.include(request, response);
				} else {
					response.sendRedirect("Error.html");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else{
			response.sendRedirect("Database Connectivity Error!!");
		}
		
	}
}
