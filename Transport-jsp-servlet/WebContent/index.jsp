<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="css/login.css" rel="stylesheet">
</head>
<body>

<form action="/Transport-jsp-servlet/login" method="post">
	<div class="mainContainer">
		<div class="loginImg">
			<img src="resources/login.png" alt="img" class="img">
		</div>
		<label><b>Username</b></label>
		<input type="text" placeholder="Enter Username" name="uName" required>
		<label><b>Password</b></label>
		<input type="password" placeholder="Enter Password" name="uPassword" required>
		<div class=loginButton>
			<button type ="submit">Login</button>
		</div>
		
	</div>
</form>
</body>
</html>