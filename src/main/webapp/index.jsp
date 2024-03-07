<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>login</h1>
   <form action="loginForm" method="post">
    <input type="text" placeholder="Enter Email" name="email"/>
    <input type="text" placeholder="Enter Password" name="pass"/>
    <input type="submit" value="submit"/>
   </form>
   <h3>New user? <a href="register.jsp">Register</a></h3>
</body> 
</html>