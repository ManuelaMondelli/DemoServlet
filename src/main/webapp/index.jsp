<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Style.css" rel="stylesheet" type="text/css">
<title>index page</title>
</head>
<body class="bodyStyle">
<form action="login" method="post" class="formStyle">
			<h1  class="h1Style">Login</h1>
            <fieldset class="fieldsetStyle">
            <table cellspacing="0" cellpadding="0">
            	<tr>
            		<td><label class="userStyle">Username</label></td>
            		<td><input id="name" type="text" name="username" value="" class="input1Style"></td>
            	</tr>
            	<tr>
            		<td><label class="passStyle">Password</label></td>
            		<td><input type="password" name="password" value="" class="input2Style"></td>
            	</tr>
            	<tr>
            		<td>&nbsp</td>
            	</tr>
            	<tr>
            		<td colspan="2"><input type="submit" name="login" class="buttonStyle"></td> 
            	</tr>
            </table>
                
            </fieldset>
        </form>
        
        
        
</body>
</html>