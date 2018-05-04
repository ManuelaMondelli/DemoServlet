<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Style.css" rel="stylesheet" type="text/css">
<script src="function.js" type="text/javascript"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="tableExport.js"></script>
<script type="text/javascript" src="jquery.base64.js"></script>
<title>All Employees</title>
</head>
<body>
	
<form action="FormNewEmployee.jsp">
<button onclick="newemp()" type="hidden" id="new" name="new" value="">New Employee</button>
</form>

<br>
	
<form action="welcome.jsp">
<button onclick="home()" type="hidden" id="welcome" name="welcome" value="">Home Page</button>
</form>

<br>

<form action="index.jsp">
<button onclick="employees()" type="hidden" id="logout" name="logout" value="">Logout</button>
</form>

<br>

<form action="Download">
<button onclick="download()" type="hidden" id="download" name="download" value="">Download</button>
</form>

<br>

<form action="employee" method="post">	
<h1>List of employees</h1>
	
	<input type="hidden" id="hidden_field_operation" name="hidden_field_operation" value=""/>
	<input type="hidden" id="selectedrow" name="selectedrow" value=""/> 
		
		<table id="allEmployees" cellspacing="1" cellpadding="10" align="center" border="1" >
		<thead>
		    <tr>
			  <th><strong>Employee ID</strong></th>
		      <th><strong>First Name</strong></th>
		      <th><strong>Last Name</strong></th>
		      <th><strong>Email</strong></th>
		      <th><strong>Phone Number</strong></th>
		      <th><strong>Job ID</strong></th>
		      <th><strong>Manager ID</strong></th>
		      <th><strong>Department ID</strong></th>
		     
		      <th><strong>Update</strong></th>
		      <th><strong>Delete</strong></th>
		    </tr>
		  <thead>
		  <tbody>
		<c:forEach var="imp" items="${sessionScope.listEmployee}" varStatus="indexl">
						<tr>
							<td><input name="empID" type="hidden" value="${imp.employeeId}"></td>
							<td><c:out value="${imp.firstName}"></c:out></td>
							<td><c:out value="${imp.lastName}"></c:out></td> 
							<td><c:out value="${imp.email}"></c:out></td> 
							<td><c:out value="${imp.phoneNumber}"></c:out></td>
							<td><c:out value="${imp.jobId}"></c:out></td>
							<td><c:out value="${imp.managerId}"></c:out></td>
							<td><c:out value="${imp.departmentId}"></c:out></td>
							
							<td><button onclick="modifyUpdate(${imp.employeeId})" type="submit" name="Update" value="Update" title="Update">Update</button>
							<td><button onclick="modifyDelete(${imp.employeeId})" type="submit" name="Delete" value="Delete" title="Delete">Delete</button>
							<td><button onClick ="$('#allEmployees').tableExport({type:'excel',escape:'false'});">Export to Excel</button>
						</tr>	
		</c:forEach>
		</tbody>
		</table>

</form>
</body>
</html>