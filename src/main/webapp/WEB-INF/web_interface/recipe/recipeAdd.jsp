<!--
	Síða til að bæta við uppskriftum
	Fannar Þeyr Guðmundsson fthg2@hi.is  
-->

<%@page import="is.hi.hbv.do_or_diet.model.Recipe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="is">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
	<head>
		<meta charset="utf-8">	
	    <title>Nýjar uppskriftir</title>
	    <spring:url value="/resources/js/Addjs.js" var="mainJs" />
 		<script src="${mainJs}"></script>
 		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
	<body>
		<section class="hero is-medium">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title is-1">Nýjar uppskriftir</h1>
	      <h2 class="subtitle">Hvað sem þú getur látið þér detta í hug</h2>
   		</div>
  	  </div>
	  <nav class="navbar" role="navigation" aria-label="main navigation">
		<div class="container">
	      <div class="navbar-brand">
		    <a class="navbar-item" href="/mealplan">Matarplön</a>
		    <a class="navbar-item" href="/recipe">Uppskriftir</a>
		  </div>
		</div>
	  </nav>
	</section>
  	
  	<!-- Hérna er hnappur sem nýtir javascript til að leyfa að skrá fleiri hráefni fyrir nýja uppskrift -->
  	<section class="section">
  		<div class="container">
		  	<div id="recipe">
		 		<form method="POST" action="" id="recipeForm" >
		 			<div class="field">
		 					<label class="label">Nafn á uppskrift:</label>
		 					<div class="control">
		  						<input class="input" type="text" id="recipeName" value="" placeholder="Lasagna">
		  						<input type="hidden" id="recipeId" value="">
		 					</div>
					</div>
					<div class="field">
		 					<label class="label">Skammtastærð:</label>
		 					<div class="control">
		  						<input class="input" type="text" id="servings" placeholder="Gefur til kynna fjölda skammta">
		 					</div>
					</div>
					<div class="field">
		 					<label class="label">Hvernig á að matreiða uppskriftina?</label>
		 					<div class="control">
		   					<textarea class="textarea" id="directions" placeholder="Vinsamlega skrifið leiðbeiningar hér"></textarea>
		 					</div>
					</div>
					<div class="field is-grouped">
		      			<p class="control"><input type="button" class="button" value="Bæta við hráefni" onClick="addInput('ingredientDiv')" /></p>
		      			<p class="control"><input type="button" class="button" value="Fjarlægja hráefni" onClick="removeInput('ingredientDiv')" /></p>
		      			<p class="control"><input type="button" class="button is-primary" value="Vista" onClick="saveRecipe()" /></p>
		      		</div>
		   		</form>
		   		<div id ="ingredientDiv">
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
