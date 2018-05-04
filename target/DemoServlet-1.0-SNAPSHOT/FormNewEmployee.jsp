<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new employee</title>
</head>
<body>
<form action="addemployee" method="post">
<h1>Add Employee</h1>
            <fieldset>
            <table cellspacing="0" cellpadding="0">
            	<tr>
            		<td><label>Employee ID</label></td>
            		<td><input type="text" name="id" value=""></td>
            	</tr>
            	<tr>
            		<td><label>First Name</label></td>
            		<td><input type="text" name="firstName" value=""></td>
            	</tr>
            	<tr>
            		<td><label>Last Name</label></td>
            		<td><input type="text" name="lastName" value=""></td>
            	</tr>
            	<tr>
            		<td><label>E-mail</label></td>
            		<td><input type="text" name="email" value=""></td>
            	</tr>
            	<tr>
            		<td><label>Phone Number</label></td>
            		<td><input type="text" name="phoneNumber" value=""></td>
            	</tr>
            	<!-- <tr>
            		<td><label>Hire Date</label></td>
            		<td><input type="text" name="hireDate" value=""></td>
            	</tr>-->
            	<tr>
            		<td><label>Job ID</label></td>
            		<td><input type="text" name="jobId" value=""></td>
            	</tr>
            	<tr>
            		<td><label>Salary</label></td>
            		<td><input type="text" name="salary" value=""></td>
            	</tr>
            	<tr>
            		<td><label>Commission Pct</label></td>
            		<td><input type="text" name="commissionPct" value=""></td>
            	</tr>
            	<tr>
            		<td><label>Manager ID</label></td>
            		<td><input type="text" name="managerId" value=""></td>
            	</tr>
            	<tr>
            		<td><label>Department ID</label></td>
            		<td><input type="text" name="departmentId" value=""></td>
            	</tr>
            	<tr>
            		<td>&nbsp</td>
            	</tr>
            	<tr>
            		<td colspan="3"> <input type="submit" name="Save" ></td> 
            	</tr>
            </table> 
            </fieldset>
            	</form>
</body>
</html>
