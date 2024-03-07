<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
   <form action="regform" method="post">
     Name: <input type="text" name="name"/></br>
     Email: <input type="text" name="email"></br>
     Password: <input type="text" name="pass"/></br>
     Gender: <input type="radio" name="gender" value="Male">Male
             <input type="radio" name="gender" value="Female"/>Female</br>
     City: <select name="city">
            <option>Select City</option>
            <option>Delhi</option>
            <option>Mumbai</option>
            <option>Kolkata</option>
           </select></br>
           
     <input type="submit" value="Submit" />
   </form>
   <h1>Already have an account <a href="index.jsp">Login</a></h1>
</body>
</html>