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
	<section class="hero is-medium is-primary is-bold">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title is-1">
	        Uppskriftir
	      </h1>
	      <h2 class="subtitle">
	        <c:out value="${recipe.name}" />
	      </h2>
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
	<section class="section">
	  <div class="container">
	  	<div class="columns">
	  	  <div class="column is-two-thirds">
			<h3 class="title is-3">Uppskrift</h3>
	  	  	<table class="table table is-fullwidth is-striped is-hoverable">
	  	  	  <thead>
	  	  	  	<tr>
	  	  	  	  <th>Uppskrift</th>
	  	  	  	  <th>Fjöldi manns</th>
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
	    </div>
	  </div>
	</section>
  </body>
</html>