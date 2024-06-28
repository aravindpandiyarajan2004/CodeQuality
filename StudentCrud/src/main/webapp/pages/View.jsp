<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.find{
border: 2px solid red; 
height: 100%; 
box-sizing: border-box; 
padding: 1rem; 
text-align: center; 
color: green; 
border-radius: 5px;



}




</style>
</head>
<body>
	<center>
	<div class="find">
		<form action="Find" method="post">
			<h1>Find Student</h1>
			ID : <select name="sid">
				<option selected>Select ID</option>
				<c:forEach items="${IdList}" var="id">
					<option value="${id}">${id}</option>
				</c:forEach>
			</select> <br>
			<br>
			<input type="Submit" value="Find" name="button">
		</form>
		
		<form action="Updation" method="post" >
		<center>

<br>
ID:
	
	<input type="number" name="sid" placeholder="ID" value=${Stud.getId()}><br><br>
	  	Name         :
	    <input type="text" name="sname" placeholder="Student Name" value=${Stud.getSname()} ><br><br>
	    <br>
	    City  :
	    <input type="text" name="scity" placeholder="Student City" value=${Stud.getScity()} ><br>
	   
	    
</center>
		
		
		</form>
		</div>
		<%
		String result = (String) request.getAttribute("Action");

		if (result != null) {

			if (result.equals("Success")) {
				out.print("<h3><font color=green>Updation Operation is Successfully Done</font></h3>");
			} else {
				out.print("<h3><font color=red>Updation Operation is Failure</font></h3>");
			}

		}
		%>

	</center>
</body>
</html>