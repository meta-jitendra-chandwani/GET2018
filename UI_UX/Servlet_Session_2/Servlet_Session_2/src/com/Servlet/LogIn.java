package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.JDBCConnection;
import com.DAO.Query;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("u_name");
		String password=request.getParameter("pwd");
		PrintWriter out = response.getWriter();

		Connection conn = JDBCConnection.getDatabaseConnection(
				"Metacube_Database", "root", "root");
		if(conn!=null){
			System.out.println("Connection In");
			PreparedStatement preparedStatement = null;
			ResultSet resultPass=null,resultMail=null;
			try {
				preparedStatement = conn.prepareStatement(Query.SELECT_Email);
				preparedStatement.setString(1, password);
				resultMail=preparedStatement.executeQuery();
				
				preparedStatement = conn.prepareStatement(Query.SELECT_Pass);
				preparedStatement.setString(1, mail);
				resultPass=preparedStatement.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(resultMail.equals(mail)&&resultPass.equals(password)){
				RequestDispatcher dispatch = request.getRequestDispatcher("Question2.html");
				dispatch.forward(request, response);
			}else{
				System.out.println("bc galat h");
			}
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
