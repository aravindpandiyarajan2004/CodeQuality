<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Student</title>
<style>
.insert{


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
<form action="Insertion" method="post" ModelAttribute="bean">
<div class="insert">
<center>
<h1 id="head1">Insert Student Details</h1>
	  	Name         :
	    <input type="text" name="sname" class="in" required><br>
	    <br>City  :
	    <input type="text" name="scity" class="in" required><br>
	   
	    <br><input type="Submit" value="Insert" name="button">
</center>
</div>

</form>

<%
String result = (String) request.getAttribute("Action");

if(result!=null){
	 
if(result.equals("Success")){
	 out.print("<h3><font color=green>Insertion Operation is Successfully Done</font></h3>");
}
else{
	 out.print("<h3><font color=red>Insertion Operation is Failure</font></h3></div>");
}

}




%>

</body>
</html>