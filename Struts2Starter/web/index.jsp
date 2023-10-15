<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="css/style.css">
<title>Login Page</title>
</head>
<body>

<div class=container>
<h2>Hey There welcome to my banking application</h2>
 	<form action="login" method="post">
 		<label>Username:</label>
        <input type="text" name="username"><br>
        <label>Password:</label>
        <input type="password" name="password"><br>
        <input id="btn" type="submit" value="Login">
        <a class="button" id="btn" href="CreateAcc.jsp">Create Account</a>
   </form>
</div>
</body>
</html>