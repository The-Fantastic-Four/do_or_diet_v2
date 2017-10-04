<!--
	Registration page for new users
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Ragnheiður Ásta Karlsdóttir rak4@hi.is
-->
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
	<title>Nýskráning</title>
</head>
<body>
	<a href="/login">Innskráning</a>
	<form autocomplete="off" action="#" th:action="/registration"
		th:object="${user}" method="post" role="form">
		<h3>Nýskráning</h3>
		<input type="text" name="username" placeholder="Nafn" /><br>
		<input type="text" name="email" placeholder="Email" /><br>
		<input type="password" name="password" placeholder="Password"/><br>

		<button type="submit">Skrá notanda</button>
	</form>
</body>
</html>