<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send e-mail</title>
</head>
<body>
<form action="ControllerSendEmail" method="post">
<h1>Contact Us</h1>
            <fieldset>
            <label>Object</label>
            <br>
            <input type="text" name="oggetto">
            <br>
            <label>E-mail</label>
            <br>
            <textarea rows="8" cols="88" name="messaggio" placeholder="Write a message"></textarea>
            <br>
            <input type="submit" name="send" value="send"/> 
            </fieldset>
</form>
</body>
</html>