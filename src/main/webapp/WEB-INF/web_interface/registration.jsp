<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
	<title>Registration Form</title>
	<link rel="stylesheet" type="text/css" th:href="@{/css/registration.css}" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/login">Login</a>
	<form autocomplete="off" action="#" th:action="/registration"
		th:object="${user}" method="post" role="form">
		<h3>Registration</h3>
		<input type="text" name="username" placeholder="Name" /><br>
		<input type="text" name="email" placeholder="Email" /><br>
		<input type="password" name="password" placeholder="Password"/><br>

		<button type="submit">Register User</button>
		<span th:utext="${successMessage}"></span>
	</form>

</body>
</html>