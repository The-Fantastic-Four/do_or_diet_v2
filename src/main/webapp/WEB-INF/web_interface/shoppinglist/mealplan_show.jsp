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
	    <title>Innkaupalisti</title>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
	<body>
	<section class="hero is-medium">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title is-1">
	        Matarplan
	      </h1>
	      <h2 class="subtitle">
	        <c:out value="${mealPlan.name}" />
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
	  <div class="container">
	  	<div class="columns">
	  	  <div class="column is-two-thirds">
			<h3 class="title is-3">Máltíðir</h3>
	  	  	<table class="table table is-fullwidth is-striped is-hoverable">
	  	  	  <thead>
	  	  	  	<tr>
	  	  	  	  <th>Uppskrift</th>
	  	  	  	  <th>Dagsetning</th>
	  	  	  	  <th>Máltíð</th>
	  	  	  	</tr>
	  	  	  </thead>
	  	  	  <tbody>
				<c:forEach items="${mealPlan.items}" var="items">
				  <tr>
				    <td><a href="/recipe/${items.recipe.id}"><c:out value="${items.recipe.getName()}" /></a></td>
				    <td><c:out value="${items.date}" /></td>
				    <td><c:out value="${items.mealType.displayName}" /></td>
				  </tr>
				</c:forEach>
			  </tbody>
			</table>
		  </div>
		  <div class="column">
			<h3 class="title is-3">Bæta við máltíð</h3>
			<form method="POST" action="/mealplan/${mealPlan.id}/edit">
			  <div class="field">
			    <label class="label">Uppskrift</label>
				  <div class="control">
				    <div class="select">
					  <select name="recipeId">
						<c:forEach items="${recipeList}" var="recipe">
						  <option value="${recipe.id}">${recipe.name}</option>
						</c:forEach>
					  </select>
					</div>
				  </div>
				</div>
			  <div class="field">
				<label class="label">Dagsetning uppskriftar</label>
				  <div class="control">
				    <div class="select">
					  <select name="dateForRecipe">
						<c:forEach items="${mealPlan.dates}" var="mDate">
					  	  <fmt:formatDate value="${mDate}" var="dateValue" pattern="yyyy-MM-dd" />
					  	  <fmt:formatDate value="${mDate}" var="dateString" pattern="dd.MM.yyyy" />
						  <option value="${dateValue}">${dateString}</option>
						</c:forEach>
					  </select>
				    </div>
				  </div>
				</div>
			  <div class="field">
		  	    <div class="control">
		    	  <button class="button is-primary" type="submit">Bæta við</button>
		        </div>
			  </div>
		    </form>
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