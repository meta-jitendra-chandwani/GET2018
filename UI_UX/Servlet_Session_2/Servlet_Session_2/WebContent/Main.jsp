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
<%
	String email = session.getAttribute("email").toString();
	Controller controller = new Controller();
	String UserName = controller.selectUserName(email);
%>
<title>Insert title here</title>
</head>

<header>
<div id="headerAlign">

	<img id="image" src="ImageServlet?email=<%=email%>">
	<form id="hidden_form" method="POST" action="UploadServlet" enctype="multipart/form-data">
		<input type="file" name="myimage">
		<input type="submit"		name="submit_image" value="Upload">
	</form>
	<div id="homeSignUp"><%=UserName%></div>
	<a href="../HTML_Session_1/signUpForm.html" target="_blank">SignUp/Login</a>
</div>

</header>
<body>

	<div>
		<table id="table_header">
			<tr>
				<td><img src="Image/html.png" height="50"></td>
				<td align="right"><a id="anchor" href="https://www.google.com/"
					target="_blank">Home</a> <a id="anchor"
					href="https://www.google.com/" target="_blank">About</a> <a
					id="anchor" href="https://www.google.com/" target="_blank">Product</a>
					<a id="anchor" href="https://www.google.com/" target="_blank">Gallery</a>
					<a id="anchor" href="https://www.google.com/" target="_blank">Contact</a>
				</td>
			</tr>
		</table>
		<hr>
		<div id="padding">
			<img src="Image/htmldo.jpg" id="image_contact"> <br />
		</div>

	</div>
	<div id="padding">
		<h2>What we work ?</h2>
		<p>
			HTML markup consists of several key components, including those
			called tags (and their attributes), character-based data types,
			character references and entity references. HTML tags most commonly
			come in pairs like , although some represent empty elements and so
			are unpaired, for example . The first tag in such a pair is the start
			tag, and the second is the end tag (they are also called opening tags
			and closing tags). Another important component is the HTML document
			type declaration, which triggers standards mode rendering. The
			following is an example of the classic "Hello, World!" program: The
			text between and describes the web page, and the text between and is
			the visible page content. The markup text This is a title defines the
			browser page title. The Document Type Declaration
			<!DOCTYPE html>
			is for HTML5. If a declaration is not included, various browsers will
			revert to "quirks mode" for rendering.
		</p>
		<p>
			HTML markup consists of several key components, including those
			called tags (and their attributes), character-based data types,
			character references and entity references. HTML tags most commonly
			come in pairs like , although some represent empty elements and so
			are unpaired, for example . The first tag in such a pair is the start
			tag, and the second is the end tag (they are also called opening tags
			and closing tags). Another important component is the HTML document
			type declaration, which triggers standards mode rendering. The
			following is an example of the classic "Hello, World!" program: The
			text between and describes the web page, and the text between and is
			the visible page content. The markup text This is a title defines the
			browser page title. The Document Type Declaration
			<!DOCTYPE html>
			is for HTML5. If a declaration is not included, various browsers will
			revert to "quirks mode" for rendering.
		</p>
		<h2>What it work ?</h2>
		<table style="width: 100%">
			<tr>
				<td><img src="Image/html.png" id="image_table">
					<h4 id="center">Name 1</h4>
					<div id="center">
						The Document Type Declaration
						<!DOCTYPE html>
						is for HTML5. If a declaration is not included, various browsers
						will revert to "quirks mode" for rendering. The Document Type
						Declaration
						<!DOCTYPE html>
						is for HTML5. If a declaration is not included, various browsers
						will revert to "quirks mode" for rendering. The Document Type
						Declaration
						<!DOCTYPE html>
						is for HTML5. If a declaration is not included, various browsers
						will revert to "quirks mode" for rendering.
					</div></td>
				<td><img src="Image/html.png" id="image_table">
					<h4 id="center">Name 2</h4>
					<div id="center">
						The Document Type Declaration
						<!DOCTYPE html>
						is for HTML5. If a declaration is not included, various browsers
						will revert to "quirks mode" for rendering. The Document Type
						Declaration
						<!DOCTYPE html>
						is for HTML5. If a declaration is not included, various browsers
						will revert to "quirks mode" for rendering. The Document Type
						Declaration
						<!DOCTYPE html>
						is for HTML5. If a declaration is not included, various browsers
						will revert to "quirks mode" for rendering.
					</div></td>
				<td><img src="Image/html.png" id="image_table">
					<h4 id="center">Name 3</h4>
					<div id="center">
						The Document Type Declaration
						<!DOCTYPE html>
						is for HTML5. If a declaration is not included, various browsers
						will revert to "quirks mode" for rendering. The Document Type
						Declaration
						<!DOCTYPE html>
						is for HTML5. If a declaration is not included, various browsers
						will revert to "quirks mode" for rendering. The Document Type
						Declaration
						<!DOCTYPE html>
						is for HTML5. If a declaration is not included, various browsers
						will revert to "quirks mode" for rendering.
					</div></td>
			</tr>
		</table>
	</div>
</body>
</html>