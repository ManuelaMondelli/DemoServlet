<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee updated</title>
</head>
<body>
<h1>Recap Employee updated</h1>
<table cellspacing="1" cellpadding="10" align="center" border="1" >
      <tr>
     		<th><strong>Employee ID</strong></th>
      <td><c:out value="${dtoUpEmp.employeeId}"></c:out></td>
      </tr>
      
      <tr>
      		<th><strong>First name</strong></th>
      <td><c:out value="${dtoUpEmp.firstName}"></c:out></td>
      </tr>
      
      <tr>
            <th><strong>Last name</strong></th>
      <td><c:out value="${dtoUpEmp.lastName}"></c:out></td>
      </tr>
      
      <tr>
            <th><strong>Email</strong></th>
      <td><c:out value="${dtoUpEmp.email}"></c:out></td>
      </tr>
      
      <tr>
            <th><strong>Phone Number</strong></th>
      <td><c:out value="${dtoUpEmp.phoneNumber}"></c:out></td>
      </tr>
      
      <tr>
            <th><strong>Job ID</strong></th>
      <td><c:out value="${dtoUpEmp.jobId}"></c:out></td>
      </tr>
      
      <tr>
            <th><strong>Salary</strong></th>
      <td><c:out value="${dtoUpEmp.salary}"></c:out></td>
      </tr>
      
      <tr>
            <th><strong>Commission PCT</strong></th>
      <td><c:out value="${dtoUpEmp.commissionPct}"></c:out></td>
      </tr>
      
      <tr>
            <th><strong>Manager ID</strong></th>
      <td><c:out value="${dtoUpEmp.managerId}"></c:out></td>
      </tr>
      
      <tr>
            <th><strong>Department ID</strong></th>
      <td><c:out value="${dtoUpEmp.departmentId}"></c:out></td>
    </tr>
    
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