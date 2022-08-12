<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Teacher Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
// get the students from the request object (sent by servlet)
	List<Teacher> theTeachers = 
			(List<Teacher>) request.getAttribute("TEACHER_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				
				<%
								for (Teacher tempTeacher : theTeachers) {
								%>
				
					<tr>
						<td> <%= tempTeacher.getFirstName() %> </td>
						<td> <%= tempTeacher.getLastName() %> </td>
						<td> <%= tempTeacher.getEmail() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








