package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;
import com.DAO.Query;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = request.getParameter("f_name");
		String lName = request.getParameter("l_name");
		int age=Integer.parseInt(request.getParameter("age"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String parameter = request.getParameter("dob");
		String contact_number=request.getParameter("contact_number");
		String mail=request.getParameter("email");
		String password=request.getParameter("psw");
		String organization=request.getParameter("select");
		
		PrintWriter out = response.getWriter();

		Connection conn = JDBCConnection.getDatabaseConnection(
				"Metacube_Database", "root", "root");
		if(conn!=null){
			System.out.println("Connection In");
			PreparedStatement preparedStatement = null;
			try {
				preparedStatement = conn.prepareStatement(Query.INSERT);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				preparedStatement.setString(1, fName);
				preparedStatement.setString(2, lName);
				preparedStatement.setInt(3, age);
				preparedStatement.setDate(4, new java.sql.Date(sdf.parse(parameter).getTime()) );
				preparedStatement.setString(5, contact_number);
				preparedStatement.setString(6, mail);
				preparedStatement.setString(7, password);
				preparedStatement.setString(8, organization);

				int result = preparedStatement.executeUpdate();
				if (result > 0) {
					out.println("<html>");
					out.println("<h2 style=\"color:green;text-align:center;\">Employee Successfully Added !</h2>");
					out.println("</html>");

					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("logInPage.html");
					requestDispatcher.include(request, response);
				} else {
					response.sendRedirect("Error.html");
				}
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			}
		}else{
			response.sendRedirect("Database Connectivity Error!!");
		}
		
	}
	

}
