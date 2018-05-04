<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deleted Employee</title>
</head>
<body>


<form action="allemployee">
<button onclick="employees()" type="hidden" id="allEmployees" name="allEmployees" value="">All Employees</button>
</form>

<br>

<form action="welcome.jsp">
<button onclick="home()" type="hidden" id="welcome" name="welcome" value="">Home Page</button>
</form>

<br>

<form action="index.jsp">
<button onclick="employees()" type="hidden" id="logout" name="logout" value="">Logout</button>
</form>


<!-- <button onclick="operation(page)" type="submit" name="Logout" value="Logout">Logout</button>
<button onclick="operation(page)" type="submit" name="Welcome" value="Welcome">Welcome</button>
<button onclick="operation(page)" type="submit" name="Employees" value="Employees">Employees</button>  -->
	
<fieldset>
<h2>Record deleted!</h2>
</fieldset>

<br>
<br>
</body>
</html>