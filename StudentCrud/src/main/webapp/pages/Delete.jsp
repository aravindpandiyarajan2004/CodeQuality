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
.delete{
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
<div class="delete">
	<center>
		<form action="Deletion" method="post">
			<h1>Delete Student by ID</h1>
			ID : <select name="sid">
				<option selected>Select ID</option>
				<c:forEach items="${IdList}" var="id">
					<option value="${id}">${id}</option>
				</c:forEach>
			</select> <br>
			<br>
			<input type="Submit" value="Delete" name="button">
		</form>
		<form action="DeletionByName" method="post">
			<h1>Delete Student by Name</h1>
			ID : <select name="sname">
				<option selected>Select Name</option>
				<c:forEach items="${NameList}" var="name">
					<option value="${name}">${name}</option>
				</c:forEach>
			</select> <br>
			<br>
			<input type="Submit" value="Delete" name="button">
		</form>
		</div>
		<%
		String result = (String) request.getAttribute("Action");

		if (result != null) {

			if (result.equals("Success")) {
				out.print("<h3><font color=green>Deletion Operation is Successfully Done</font></h3>");
			} else {
				out.print("<h3><font color=red>Deletion Operation is Failure</font></h3>");
			}

		}
		%>

	</center>
</body>
</html>