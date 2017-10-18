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
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
	<body>
		<section class="hero is-medium is-primary is-bold">
			<div class="hero-body">
	    		<div class="container">
	      			<h1 class="title is-1">
	       				Uppskriftir
	      			</h1>
	      			<h2 class="subtitle">
	        			Allt milli himins og jarðar
	      			</h2>
	    		</div>
	  		</div>
		</section>
			<nav class="navbar" role="navigation" aria-label="main navigation">
	  			<div class="container">
      				<div class="navbar-brand">
	    				<a class="navbar-item" href="/mealplan">Matarplön</a>
	    				<a class="navbar-item" href="/recipe">Uppskriftir</a>
	  				</div>
	  			</div>
			</nav>
		  	<div class="container">
			<h1 class="title"></h1>
			<c:forEach items="${recipeList}" var="recipe">
				<c:out value="${recipe.name}"/><br>
			</c:forEach><br>
		<form action="http://localhost:8080/recipe/recipeAdd">
    	<button class="button" type="submit">Bæta við uppskrift</button>
		</form>
	  </div>
	</body>
</html>