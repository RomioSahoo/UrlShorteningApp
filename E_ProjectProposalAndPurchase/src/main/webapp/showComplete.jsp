<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Form</title>
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
			<h1>ADMIN</h1>
		</center>
		<hr>
		
		<h1>Questions And Answers..</h1>
		<br>
		<h2>Questions by Admin</h2>
		<form action="submitAnswer" method="post">	
		<table border="2" width="70%" cellpadding="2">
			<c:forEach var="s" items="${subu}">
				<tr>
					<td>${s.question1}</td>
				</tr>
				<tr>
					<td>${s.question2}</td>
				</tr>
				<tr>
					<td>${s.question3}</td>
				</tr>
			</c:forEach>
		</table><br><br><br>
		<h2>Answers by Vendor</h2>
		<table border="2" width="70%" cellpadding="2">
			<c:forEach var="v" items="${subj}">
				<tr>
					<td>${v.answer1}</td>
				</tr>
				<tr>
					<td>${v.answer2}</td>
				</tr>
				<tr>
					<td>${v.answer3}</td>
				</tr>
			</c:forEach>
		</table>
		
	</div>
	<div class="container">
	<a href="fileDownload" class="row">Download this data</a>
	</form>
	</div>
</body>
</html>