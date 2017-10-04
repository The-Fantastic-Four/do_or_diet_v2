<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">

<head>
	<title>Spring Security Tutorial</title>
	<link rel="stylesheet" type="text/css" th:href="@{/css/login.css}" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<a href="/registration">Registration</a>
	<div>
		<form th:action="@{/login}" method="POST" >
			<h3>Login</h3>		 
			<input type="text" id="email" name="email" placeholder="Email"/><br> 
			<input type="password" id="password" name="password" placeholder="Password"/><br> 
			<button name="Submit" value="Login" type="Submit" th:text="Login">Login</button>
		</form>
	</div>
</body>
</html>