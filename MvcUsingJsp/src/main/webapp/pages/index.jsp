<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>
		<a href="/new">Create new Employee</a>
		<br><br>
		<table border="1" cellpadding="10">
			<tr>
				<th>Employee ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Skill</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.empId}</td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.skill}</td>
					<td>
					<a href="edit/${emp.empId}">Edit</a> 
					<a href="delete/${emp.empId}">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>