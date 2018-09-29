<!DOCTYPE html>
<%@page import="com.controller.Controller"%>
<%@page import="com.model.UserEntity"%>
<%@page import="java.util.List"%>
<%@page import="com.model.UserEntity"%>
<html>
	<title>
		Profile	
	</title>
	<head>
		<link rel="Stylesheet" href="css/style.css">
		<script src="js/script.js" type="text/javascript"></script>
	</head>
	<header>
		<div  id="headerAlign">
			<span class="link">
				<a href="InvalidateSession">Logout</a>
			</span>
		</div>
	</header>
	<body>	
		<jsp:useBean id="userFacade" class="com.controller.Controller"/>
		<%
			String email = session.getAttribute("email").toString();
		Controller controller=new Controller();
			UserEntity user = controller.selectUser(email);
			List<UserEntity> friendList =controller.getFriendListOfUser(email,user.getOrganisation());
		%>
		<div align="right">
			<table>
				<tr>
					<td>
						<strong>HI <%=user.getFirstName().toUpperCase() %> !</strong>
						<div id="uploadProfilePictureButton" style="display:none;">
							<form action="UpdateProfilePicture">
								<input type="file" name="profilePicture" value="upload picture" accept="image/jpeg, image/jpg, image/png">
								<button onclick="submit()">Upload</button>
							</form>
						</div>
					</td>
				</tr>
			</table>
		</div>
		
		<div align="center" id="profileDetailsDIV" style="display:block;">
			<h2><%=user.getFirstName()+"'s" %> Friends</h2>
			<table>
			<%
				for(UserEntity friend : friendList) {
			%>
			<form action="FriendProfile.jsp">
					<tr>
						<td><input type="hidden" value=<%=friend.getFirstName() %> name="firstName" id="firstName" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getLastName() %> name="lastName" id="lastName" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getAge() %> name="age" id="age" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getDate() %> name="dob" id="dob" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getContact_number()  %> name="contact" id="contact" required></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getMailId() %> name="email" id="email" readonly="readonly"></td>
					</tr>
					<tr>
						<td><input type="hidden" value=<%=friend.getOrganisation() %> name="organization" id="organization" readonly="readonly"></td>
					</tr>
					<tr>
						
						<td><%=friend.getFirstName()+" "+friend.getLastName()%></td>
						<td><input type="submit" value="View Profile"></td>
					</tr>
			</form>
			<%
				}
			%>
			</table>
		</div>
		<hr/>
		<div align="center">
			&copy; Copyright 2018-19 | All Rights reserved. | Metacube Training
		</div>
	</body>
</html>