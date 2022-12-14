<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Teacher Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Student -->
			
			<input type="button" value="Add Teacher" 
				   onclick="window.location.href='add-teacher-form.html'; return false;"
				   class="add-teacher-button"
			/>
			
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempTeacher" items="${LISTA_PROFESORES}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="TeacherControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="teacherId" value="${tempTeacher.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="TeacherControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="teacherId" value="${tempTeacher.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempTeacher.firstName} </td>
						<td> ${tempTeacher.lastName} </td>
						<td> ${tempTeacher.email} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this teacher?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








