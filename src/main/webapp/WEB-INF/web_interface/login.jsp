<!--
	Log in page 
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Ragnheiður Ásta Karlsdóttir rak4@hi.is
-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">

<head>
	<title>Innskráning</title>
</head>

<body>
	<a href="/registration">Nýskráning</a>
	<div>
		<form th:action="@{/login}" method="POST" >
			<h3>Skrá inn</h3>		 
			<input type="text" id="email" name="email" placeholder="Email"/><br> 
			<input type="password" id="password" name="password" placeholder="Password"/><br> 
			<button name="Submit" value="Login" type="Submit" th:text="Login">Login</button>
		</form>
	</div>
</body>
</html>