<!--
	Show and edit a specific mealplan
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Viktor Alex Brynjarsson vab18@hi.is
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="is">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<head>
		<meta charset="utf-8">	
	    <title>Uppskriftir</title>
	    <script src="${mainJs}"></script>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
	<body>
	<section class="hero is-medium">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title is-1">
	        <c:out value="${recipe.name}" />
	      </h1>
	      <h2 class="subtitle">
	        Uppskrift
	      </h2>
	    </div>
	  </div>
	  <nav class="navbar" role="navigation" aria-label="main navigation">
		<div class="container">
	      <div class="navbar-menu">
	        <div class="navbar-start">
		      <a class="navbar-item" href="/mealplan">Matarplön</a>
		      <a class="navbar-item" href="/recipe">Uppskriftir</a>
		    </div>
		    <div class="navbar-end">
		      <a class="navbar-item" href="/login">Innskráning</a>
		      <a class="navbar-item" href="/registration">Nýskráning</a>
		    </div>
		  </div>
		</div>
	  </nav>
	</section>
	<section class="section">
	  <h3 class="title is-3">Uppskrift</h3>
	  <div class="container">
	  	<div class="columns">
	  	  	<div class = "two-thirds column">
	 			<table class="table table is-fullwidth is-striped is-hoverable">
	  			  <thead>
	  	  			<tr>
	  	  			  <th>Uppskrift af</th>
	  	  		 	  <th>Fjöldi skammta</th>
	  	  			  <th>Leiðbeiningar</th>
	  	  			</tr>
	  	  		  </thead>
	  	  		  <tbody>
	  	  			<tr>
					  <td><c:out value="${recipe.name}" /></td>
					  <td><c:out value="${recipe.servings}" /></td>
				   	  <td><c:out value="${recipe.directions}" /></td>
					</tr>
				  </tbody>
				</table>
			  </div>
			  <div class = "one-third column">
			  	<form action="" th:action="@{/changeRecipe}" th:object="${recipe}" method="post">
			  		<button name="changeRecipe" type="submit">Breyta uppskrift</button>
		  		</form>
			  	<table class="table table is-fullwidth is-striped is-hoverable">
			  		<thead>
					  	<tr>
						  	<th>Hráefni</th>
					  		<th>Fjöldi</th>
					  		<th>Mælieining</th>
						</tr>
					</thead>
			   	    <tbody>
						<c:forEach items="${recipe.ingredients}" var="IngrtQuantity">
			   			  <tr>
		 	   	   		 	 <td><c:out value="${IngrtQuantity.ingredient.name}" /></a></td>
		  	   				 <td><c:out value="${IngrtQuantity.quantity}" /></td>
		  	   		   	 	 <td><c:out value="${IngrtQuantity.measurement}" /></td>
		  	  			  </tr>
				    	 </c:forEach>
					</tbody>
				</table>	
		  	 </div>		 		  
	    </div>
	  </div>
	</section>
	<footer class="footer">
	  <div class="container">
	    <div class="content has-text-centered">
	      <p>
	        <strong>Do or Diet &copy;</strong> by <a href="https://github.com/The-Fantastic-Four">Team 10</a>.
	      </p>
	    </div>
	  </div>
	</footer>
  </body>
</html>