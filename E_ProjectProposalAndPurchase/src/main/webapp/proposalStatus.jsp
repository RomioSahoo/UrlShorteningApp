<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
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

h1 {
	color: black;
}

#h21 {
	color: red;
}

#h22 {
	color: green;
}

a {
	color: black;
	font-size: 22px;
}
</style>
<meta charset="ISO-8859-1">
<title>Proposal Status</title>
</head>
<body>
	<div class="heading">
		<h1>
			<b>Project Proposal And Purchase</b>
		</h1>
	</div>
	<div class="container">
		<center>
			<h1>USER</h1>
		</center>

		<c:forEach var="m" items="${p_list}">

			<c:choose>
				<c:when test="${ empty m.status }">
					<h2 id="h21">User ${m.email}, Your proposal is Rejected</h2>
				</c:when>
				<c:otherwise>
					<h2 id="h22">User ${m.email}, Your proposal is ${m.status}</h2>
					<center><a href="editStatusForm/${m.skills }" class="row">Update Project Status</a></center>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<center><a href="/E_ProjectProposalAndPurchase/userLogin.jsp" class="row">Logout</a></center>
	</div>
</body>
</html>