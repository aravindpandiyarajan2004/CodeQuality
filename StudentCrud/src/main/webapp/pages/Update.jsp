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
.update{
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
<div class="update">
	<center>
		<form action="Fetch" method="post">
			<h1>Update Student</h1>
			ID : <select name="sid">
				<option selected>Select ID</option>
				<c:forEach items="${IdList}" var="sid">
					<option value="${sid}">${sid}</option>
				</c:forEach>
			</select> <br>
			<br>
			<input type="Submit" value="Fetch" name="button">
		</form>
		
		<form action="Updation" method="post" >
		<center>

<br>
	
	<input type="hidden" name="sid" placeholder="ID" value=${Stud.getSid()} ><br>
	  	Name         :
	    <input type="text" required name="sname" placeholder="Student Name" value=${Stud.getSname()} ><br>
	    <br>
	    City  :
	    <input type="text" required name="scity" placeholder="Student City" value=${Stud.getScity()}  ><br>
	   
	    <br><input type="Submit" value="Update" name="button">
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