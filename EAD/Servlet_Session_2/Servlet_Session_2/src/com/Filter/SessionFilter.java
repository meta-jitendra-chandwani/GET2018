package com.Filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionFilter implements javax.servlet.Filter{

	/**
	 * destroy() -  destroy filter
	 */
	@Override
	public void destroy() {
	}

	/**
	 * doFilter -  check whether session is active or not
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		if(null == session.getAttribute("email")) {
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<h2 style=\"color:red;text-align:center;\">User is not logged in !</h2>");
			out.println("</html>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("logInPage.html");
			requestDispatcher.include(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}