package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Validation.Validation;
import com.controller.Controller;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String fName = request.getParameter("f_name");
		String lName = request.getParameter("l_name");
		int age = Integer.parseInt(request.getParameter("age"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String parameter = request.getParameter("dob");
		Date date = null;
		try {
			date = new java.sql.Date(sdf.parse(parameter).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String contact_number = request.getParameter("contact_number");
		String mail = request.getParameter("email");
		String password = request.getParameter("psw");
		String repeatPassword = request.getParameter("psw-repeat");
		String organization = request.getParameter("select");

		PrintWriter out = response.getWriter();

		Controller controller = new Controller();

		Validation validation = new Validation();

		if (validation.nameValidation(fName)
				&& validation.nameValidation(lName)
				&& validation.ageValidation(age)
				&& validation.mailValidation(mail)
				&& validation.validatePassword(password, repeatPassword)
				&& validation.validateContact(contact_number)) {
			if (controller.insertion(fName, lName, age, date, contact_number,
					mail, password, organization)) {
				out.println("<html>");
				out.println("<h2 style=\"color:green;text-align:center;\">Employee Successfully Added !</h2>");
				out.println("</html>");
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("logInPage.html");
				requestDispatcher.include(request, response);
			}

		} else {
			response.sendRedirect("Error.html");
		}

	}

}
