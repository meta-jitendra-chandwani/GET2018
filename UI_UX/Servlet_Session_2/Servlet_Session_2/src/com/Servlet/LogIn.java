package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.JDBCConnection;
import com.DAO.Query;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("u_name");
		String password = request.getParameter("pwd");
		String Pass = null;

		Connection conn = JDBCConnection.getDatabaseConnection(
				"Metacube_Database", "root", "root");

		if (conn != null) {
			System.out.println("Connection In");
			PreparedStatement preparedStatement = null;
			ResultSet resultPass = null;

			try {
				preparedStatement = conn
						.prepareStatement(Query.SELECT_PASSWORD);
				preparedStatement.setString(1, mail);
				resultPass = preparedStatement.executeQuery();
				while (resultPass.next()) {
					Pass = resultPass.getString(1);
				}
			} catch (Exception e) {
				e.getStackTrace();
			}

			if (Pass.equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", mail);
				response.sendRedirect("Main.jsp");


			} else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("logInPage.html");
				PrintWriter out = response.getWriter();
				out.println("<font color=red>Either username or password is wrong.</font>");
				rd.include(request, response);
			}

		}
	}
}
