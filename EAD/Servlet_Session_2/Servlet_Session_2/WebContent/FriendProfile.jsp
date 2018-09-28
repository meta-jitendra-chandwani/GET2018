<!DOCTYPE html>
<%@page import="com.controller.Controller"%>
<%@page import="com.model.UserEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.model.UserEntity"%>
<html>
<title>Profile</title>
<head>
<link rel="Stylesheet" href="CSS/Question1.css">
<script src="js/script.js" type="text/javascript"></script>
</head>
<header>
	<div id="headerAlign">
		<span class="image"> 
		</span> <span class="link"> <a href="InvalidateSession">Logout</a>
		</span>
	</div>
</header>
<body>
	<jsp:useBean id="userFacade" class="com.controller.Controller" />
	<%
		String email = session.getAttribute("email").toString();
		Controller controller = new Controller();

		UserEntity user = controller.selectUser(email);
		String name = request.getParameter("firstName") + " "
				+ request.getParameter("lastName");
		String friendEmail = request.getParameter("email");
		String contact = request.getParameter("contact");
		String dob = request.getParameter("dob");
	%>
	<div align="right">
		<table>
			<tr>
				<td><strong>HI
						<%=user.getFirstName().toUpperCase()%> !
				</strong> 
					</td>
			</tr>
		</table>
	</div>

	<div align="center" id="profileDetailsDIV" style="display: block;">
		<h2><%=name.toUpperCase() + "'s"%>
			PROFILE
		</h2>
		<form>
			<table>
				<tr>
					<td>Date Of Birth</td>
					<td><%=dob%></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><%=friendEmail%></td>
				</tr>
				<tr>
					<td>Contact</td>
					<td><%=user.getContact_number()%></td>
				</tr>
			</table>
		</form>
	</div>
	<hr />
	<div align="center">&copy; Copyright 2018-19 | All Rights
		reserved. | Metacube Training</div>
</body>
</html>