<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendor submit Questionnare</title>
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
			<h1>VENDOR</h1>
		</center>
		<hr>
		<h1>Questions..</h1>
		<br>
		<table border="2" width="70%" cellpadding="2">
			<c:forEach var="s" items="${sub}">
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
		</table>
		<form action="submitAnswer" method="post">	
		<table>
			<tr>
				<td><strong>Answer 1 :</strong></td>
				<td><textarea rows="3" cols="60" name="answer1" id="answer1"
						required></textarea></td>
			</tr>
			<tr>
				<td><strong>Answer 2 :</strong></td>
				<td><textarea rows="3" cols="60" name="answer2" id="answer2"
						required></textarea></td>
			</tr>
			<tr>
				<td><strong>Answer 3 :</strong></td>
				<td><textarea rows="3" cols="60" name="answer3" id="answer3"
						required></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="row" type="submit" value="Submit"></td>
			</tr>
		</table>
	</div>
	</form>
</body>
</html>