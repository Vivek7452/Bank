<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<div class=container>
<h1>Welcome to OpenText </h1>
	<form action="CreateAcc" method="post">
	    NAME: <br><input type="text" name="name"><br>
        USERNAME: <input type="text" name="username"><br>
        PASSWORD: <input type="password" name="password"><br>
        MOBILE NUMBER: <input type="number" name="number"><br>
        <input id="btn" type="submit" value="Submit">
   </form>
</div>   
</body>
</html>