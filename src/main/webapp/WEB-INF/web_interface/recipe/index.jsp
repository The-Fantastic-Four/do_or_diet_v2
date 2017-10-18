<!--
	Shows a list of recipes 
	@author Ragnheiður Ásta Karlsdóttir rak4@hi.is
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="is">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<head>
		<meta charset="utf-8">	
	    <title>Uppskriftir</title>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	</head>
	
	<body>
	  <div class="container">
		<h1>Uppskriftir</h1>
		<c:forEach items="${recipeList}" var="recipe">
			<c:out value="${recipe.name}"/><br>
		</c:forEach>
		<br>
		<form action="http://localhost:8080/recipe/recipeAdd">
    	<button class="button" type="submit">Bæta við uppskrift</button>
		</form>
	  </div>
	</body>
</html>