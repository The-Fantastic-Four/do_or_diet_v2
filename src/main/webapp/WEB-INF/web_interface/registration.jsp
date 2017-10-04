<!--
	Registration page for new users
	@author Ei�ur �rn Gunnarsson eog26@hi.is
	@author Ragnhei�ur �sta Karlsd�ttir rak4@hi.is
-->
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
	<title>N�skr�ning</title>
</head>
<body>
	<a href="/login">Innskr�ning</a>
	<form autocomplete="off" action="#" th:action="/registration"
		th:object="${user}" method="post" role="form">
		<h3>N�skr�ning</h3>
		<input type="text" name="username" placeholder="Nafn" /><br>
		<input type="text" name="email" placeholder="Email" /><br>
		<input type="password" name="password" placeholder="Password"/><br>

		<button type="submit">Skr� notanda</button>
	</form>
</body>
</html>