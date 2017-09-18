<!--Index page for recipes 
	Ragnheiður Ásta Karlsdóttir rak4@hi.is-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="is">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<head>
		<meta charset="utf-8">	
	    <title>Uppskriftir</title>
	</head>
	
	<body>
		<h1>Uppskriftir</h1>
		<c:forEach items="${recipeList}" var="recipe">
			<c:out value="${recipe.name}"/><br>
		</c:forEach>
	</body>
</html>