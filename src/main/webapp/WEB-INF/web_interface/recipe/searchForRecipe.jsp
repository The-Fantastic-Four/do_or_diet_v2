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
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
	<body>
	<section class="hero is-medium">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title is-1">
	        <c:out value="Leit af" />
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
	  <div class="container">
	  	<div class="columns">
	  	  <div class="column is-two-thirds">
			<h3 class="title is-3">Leita af uppskrift</h3>
	  	  	<form method="POST" action="">
	 			<div class="field">
 					<label class="label">Nafn á uppskrift:</label>
 					<div class="control">
  						<input class="input" type="text" name="recipeName" placeholder="Nafn uppskriftar">
 					</div>
				</div>
				<div class="field">
				    <div class="control">
				      <button class="button is-primary" type="submit">Leita</button>
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