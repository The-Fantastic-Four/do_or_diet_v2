<!--
	Index page for the site 
	@author Viktor Alex Brynjarsson vab18@hi.is
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="is">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<head>
		<meta charset="utf-8">	
		<meta http-equiv="Refresh" content="6;url=/">
	    <title>Do or Diet</title>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
  <body>
	<section class="hero is-medium">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title is-1">Villa kom upp</h1>
	      <h2 class="subtitle">Eitthvað hefur farið úrskeðis</h2>
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
        <h3 class="title is-3">Eftirfarandi er villan sem kom upp:</h3>
        <div class="content">
          <h3 class="has-text-weight-semibold"><c:out value="${attrs.status} ${attrs.error}"/></h3>
          <p><c:out value="${attrs.message}"/></p>
          <p>Það mun vera áframsent þig á heimasíðuna eftir skamma stund, annars getur þú farið þangað með þessum <a href="/"> hlekk</a>.</p>
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