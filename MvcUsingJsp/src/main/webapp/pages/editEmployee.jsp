<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Edit Employee</h1>
		<form:form method="post" action="/editSave">
			<table>
				<tr>
					<td>Employee Id:</td>
					<td><form:input path="empId" /></td>
				</tr>
				<tr>
					<td>First Name :</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Skill</td>
					<td><form:input path="skill" /></td>
				</tr>
				<tr>
				<td><input type="submit" value="save"/></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>