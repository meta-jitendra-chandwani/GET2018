package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.DAO.JDBCConnection;
import com.DAO.Query;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("u_name");
		String password=request.getParameter("pwd");
		String Pass = null;
		Connection conn = JDBCConnection.getDatabaseConnection(
				"Metacube_Database", "root", "root");
		if(conn!=null){
			System.out.println("Connection In");
			PreparedStatement preparedStatement = null;
			ResultSet resultPass=null;
			try {
				preparedStatement = conn.prepareStatement(Query.SELECT_Pass);
				preparedStatement.setString(1, mail);
				resultPass=preparedStatement.executeQuery();
				while(resultPass.next()){
					Pass=resultPass.getString(1);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			if(Pass.equals(password)){
	            //get the old session and invalidate
	            HttpSession oldSession = request.getSession(false);
	            if (oldSession != null) {
	                oldSession.invalidate();
	            }
	            //generate a new session
	            HttpSession newSession = request.getSession(true);

	            //setting session to expiry in 5 mins
	            newSession.setMaxInactiveInterval(5*60);
	            newSession.setAttribute("email", mail);
	            Cookie cookie = new Cookie("email", mail);
	            response.addCookie(cookie);
	            response.sendRedirect("Question2.html");
	            	            
	        } else {
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("logInPage.html");
	            PrintWriter out = response.getWriter();
	            out.println("<font color=red>Either username or password is wrong.</font>");
	            rd.include(request, response);
	        }
			
			
			
			
			if(Pass.equals(password)){
				RequestDispatcher dispatch = request.getRequestDispatcher("Question2.html");
				dispatch.include(request, response);
			}else{
				System.out.println("Wrong Password");
			}
			
			
		}
	}
}