<%@ page isELIgnored="false"%>
<html>
<head>
<title>Welcome</title>
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
	${msg}
	<div class="container">

		<center>
			<a href="viewCompleteProject" class="row"><h3>Proceed</h3></a><br>
		</center>
		<center>
			<a href="vendorLogin.jsp" class="row"><h3>Logout</h3></a><br>
		</center>
	</div>
</body>
</html>