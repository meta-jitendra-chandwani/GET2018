<%@page import="com.model.UserEntity"%>
<%@page import="com.controller.Controller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/Question1.css" />
<script type="text/javascript" src="JS/validation.js"></script>
<%
	String email = session.getAttribute("email").toString();
	Controller controller = new Controller();
	String UserName = controller.selectUserName(email);
	UserEntity user = controller.selectUser(email);
%>
<title>Insert title here</title>
</head>

<header>
<div id="headerAlign">

	<a href='#' onclick="showForm()"> <img id="image"
		onclick="showForm()" src="ImageServlet?email=<%=email%>">
	</a>
	<form id=hideForm method="POST" action="UploadServlet"
		enctype="multipart/form-data">
		<input type="file" name="file" id="file" /> <input type="hidden"
			name="email" value=<%=email%>> <input type="hidden"
			value="C:\Users\User23\Desktop\photo upload" name="destination" /> <input
			type="submit" value="Upload" name="upload" id="upload" />
	</form>
	<div id="homeSignUp"><%=UserName%></div>
	<div class="link">
		<a href="InvalidateSession">Logout</a>
	</div>
</div>

</header>
<body>

	<div>
		<table id="table_header">
			<tr>
				<td><img src="Image/html.png" height="50"></td>
				<td align="right"><a id="anchor" href="UserFriends.jsp"
					target="_blank">Friends</a> <a id="anchor"
					href="https://www.google.com/" target="_blank">About</a> <a
					id="anchor" href="https://www.google.com/" target="_blank">Product</a>
					<a id="anchor" href="https://www.google.com/" target="_blank">Gallery</a>
					<a id="anchor" href="https://www.google.com/" target="_blank">Contact</a>
				</td>
			</tr>
		</table>
		<hr>


	</div>
	<div id="padding">
		<p>
		<div id="userProfileDIV">

			<div align="center" id="profileDetailsDIV" style="display: block;">
				<h2>Profile Details</h2>
				<form>
					<table>
						<tr>
							<td>Name</td>
							<td><%=user.getFirstName() + " " + user.getLastName()%></td>
						</tr>
						<tr>
							<td>Date Of Birth</td>
							<td><%=user.getDate()%></td>
						</tr>
						<tr>
							<td>Age</td>
							<td><%=user.getAge()%></td>
						</tr>
						<tr>
							<td>Organization</td>
							<td><%=user.getOrganisation()%></td>
						</tr>
						<tr>
							<td>Contact</td>
							<td><%=user.getContact_number()%></td>
						</tr>
						<tr>
							<td><input type="button" value="Edit Profile"
								onclick="toggleProfileDetailUpdateDIV()"></td>
						</tr>
					</table>
				</form>
			</div>

			<div align="center" id="updateProfileDetailsDIV"
				style="display: none;">
				<h2>Update Profile Details</h2>
				<form action="UpdateUserDetails">
					<table>
						<tr>
							<td>First Name</td>
							<td><input type="text" value=<%=user.getFirstName()%>
								name="firstName" id="firstName" required></td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td><input type="text" value=<%=user.getLastName()%>
								name="lastName" id="lastName" required></td>
						</tr>
						<tr>
							<td>Age</td>
							<td><input type="text" value=<%=user.getAge()%> name="age"
								id="age" required></td>
						</tr>
						<tr>
							<td>Date Of Birth</td>
							<td><input type="date" value=<%=user.getDate()%> name="dob"
								id="dob" required></td>
						</tr>
						<tr>
							<td>Mobile</td>
							<td><input type="text" value=<%=user.getContact_number()%>
								name="contact" id="contact" required></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><input type="email" value=<%=user.getMailId()%>
								name="email" id="email" readonly="readonly"></td>
						</tr>
						<tr>
							<td>Organization</td>
							<td><select name="organization">
									<option value="Metacube">Metacube</option>
									<option value="Google">Google</option>
									<option value="Amazon">Amazon</option>
									<option value="Facebook">Facebook</option>
									<option value="Apple">Apple</option>
							</select></td>
						</tr>
						<tr>
							<td><input type="submit" value="Update"></td>
							<td><input type="button" value="Cancel"
								onclick="toggleProfileDetailUpdateDIV()"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<hr />
		<div align="center">&copy; Copyright 2018-19 | All Rights
			reserved. | Metacube Training</div>
		</p>
	</div>
</body>
</html>