<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>employee</title>
</head>
<body>
<form action="updateEmployee" method="post">
<h1>Employee</h1>
            <fieldset>
            <table cellspacing="0" cellpadding="0">
            	<tr>
            		<td><label>Employee ID</label></td>
            		<td><input readonly="readonly" name="id" value="${dto.employeeId}"></td>
            	</tr>
            	<tr>
            		<td><label>First Name</label></td>
            		<td><input type="text" name="firstName" value="${dto.firstName}"></td>
            	</tr>
            	<tr>
            		<td><label>Last Name</label></td>
            		<td><input type="text" name="lastName" value="${dto.lastName}"></td>
            	</tr>
            	<tr>
            		<td><label>E-mail</label></td>
            		<td><input type="text" name="email" value="${dto.email}"></td>
            	</tr>
            	<tr>
            		<td><label>Phone Number</label></td>
            		<td><input type="text" name="phoneNumber" value="${dto.phoneNumber}"></td>
            	</tr>
            	<!-- <tr>
            		<td><label>Hire Date</label></td>
            		<td><input type="text" name="hireDate" value=""></td>
            	</tr>-->
            	<tr>
            		<td><label>Job ID</label></td>
            		<td><input type="text" name="jobId" value="${dto.jobId}"></td>
            	</tr>
            	<tr>
            		<td><label>Salary</label></td>
            		<td><input type="text" name="salary" value="${dto.salary}"></td>
            	</tr>
            	<tr>
            		<td><label>Commission Pct</label></td>
            		<td><input type="text" name="commissionPct" value="${dto.commissionPct}"></td>
            	</tr>
            	<tr>
            		<td><label>Manager ID</label></td>
            		<td><input type="text" name="managerId" value="${dto.managerId}"></td>
            	</tr>
            	<tr>
            		<td><label>Department ID</label></td>
            		<td><input type="text" name="departmentId" value="${dto.departmentId}"></td>
            	</tr>
            	<tr>
            		<td>&nbsp</td>
            	</tr>
            	<tr>
            		<td colspan="3"> <input type="submit" name="Save"></td> 
            	</tr>
            </table> 
            </fieldset>
            	</form>
            	
<form action="allemployee">
<button onclick="employees()" type="hidden" id="allEmployees" name="allEmployees" value="">All Employees</button>

<br>

<form action="welcome.jsp">
<button onclick="home()" type="hidden" id="welcome" name="welcome" value="">Home Page</button>
</form>

<br>

<form action="index.jsp">
<button onclick="index()" type="hidden" id="logout" name="logout" value="">Logout</button>
</form>            	
            	
</body>
</html>
