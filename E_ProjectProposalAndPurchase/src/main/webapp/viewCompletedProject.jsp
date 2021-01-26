<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of projects</title>
<style>
.heading {
	padding: 50px;
	text-align: center;
	background: #003399;
	border: 5px solid black;
	color: white;
	font-size: 20px;
}

.row {
	width: 20%;
	padding: 12px;
	text-align: center;
	margin: 10px 0;
	display: inline-block;
	line-height: 20px;
	text-decoration: none;
	background-color: #3B5998;
	color: white;
	font-size: 20px;
}

.container {
	padding: 16px;
	background-color: white;
}

.button {
	background-color: #3B5998;
	font-size: 15px;
	color: white;
	padding: 10px 10px;
	margin: 15px 0;
	cursor: pointer;
	width: 100%;
}
</style>
</head>
<body>
	<div class="heading">
		<h1>
			<b>Project Proposal And Purchase</b>
		</h1>
	</div>
	<div class="container">
		<center>
			<h1>Vendor</h1>
		</center>
		<hr>
	</div>
	<h1>List Of Projects</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Project Name</th>
			<th>Duration of Completion</th>
			<th>Project Budget</th>
			<th>Project Skills</th>
			<th></th>

		</tr>
		<c:forEach var="p" items="${proj}">
			<tr>
				<td>${p.projectName}</td>
				<td>${p.duration}</td>
				<td>${p.budget}</td>
				<td>${p.skills}</td>
				<td><a
					href="/E_ProjectProposalAndPurchase/purchase/${p.budget}">Buy
						now</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<div class="container">
	
		<center>
			<a href="welcomevendor.jsp" class="row"><h3>Go Back</h3></a><br>
		</center>
		<center>
			<a href="vendorLogin.jsp" class="row"><h3>Logout</h3></a><br>
		</center>
	</div>
</body>
</html>