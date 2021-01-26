<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add new project</title>
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
	</div>
	<h1>Add New Project</h1>  
       <form method="post" action="save">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><input type="text"  name="projectName" required/></td>  
         </tr>    
         <tr>    
          <td>Duration :</td>    
          <td><input type="text"  name="duration" required/></td>  
         </tr>   
         <tr>    
          <td>Budget :</td>    
          <td><input type="number"  name="budget" required/></td>  
         </tr>   
         <tr> 
         <tr>    
          <td>Skills :</td>    
          <td><input type="text"  name="skills" required/></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form>    
	<div class="container">
		<center>
			<a href="adminlogged.jsp" class="row"><h3>Go Back</h3></a><br>
		</center>
		<center>
			<a href="adminLogin.jsp" class="row"><h3>Logout</h3></a><br>
		</center>
	</div>
</body>
</html>