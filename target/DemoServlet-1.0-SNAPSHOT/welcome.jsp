<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="function.js" type="text/javascript"></script>
<title>Activities</title>
</head>
<body onload="welcome()">
<h3>Activities</h3>
<ul>
<li><a href="allemployee" target="_blank">Print all employees</a></li>
<br>
<li><a href="FormNewEmployee.jsp" target="_blank">Add new employee</a></li>
<br>
<li><a href="FormMail.jsp" target="_blank">Send e-mail</a></li>
<br>
</ul>

<form action="index.jsp">
<button onclick="index()" type="hidden" id="logout" name="logout" value="">Logout</button>
</form>


</body>
</html>