<!--
	Shows a list of meal plans and allows the user to add a new meal plan 
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Viktor Alex Brynjarsson vab18@hi.is
-->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="is">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<head>
		<meta charset="utf-8">	
	    <title>Matarplön</title>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
	<body>
	<section class="hero is-medium">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title is-1">
	        Matarplön
	      </h1>
	      <h2 class="subtitle">
	        Hvað verður í matinn og hvenær?
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
			<h3 class="title is-3">Matarplön</h3>
	  	  	<table class="table table is-fullwidth is-striped is-hoverable">
	  	  	  <thead>
	  	  	  	<tr>
	  	  	  	  <th>Heiti matarplans</th>
	  	  	  	  <th>Dagsetning frá</th>
	  	  	  	  <th>Dagsetning til</th>
	  	  	  	</tr>
	  	  	  </thead>
	  	  	  <tbody>
			  	<c:forEach items="${mealPlanList}" var="mPlan">
			  	  <tr>
			  	    <td><a href="/mealplan/${mPlan.id}"><c:out value="${mPlan.getName()}" /></a></td>
			  	    <td><c:out value="${mPlan.getDateFrom()}" /></td>
			  	    <td><c:out value="${mPlan.getDateTo()}" /></td>
			  	  </tr>
				</c:forEach>
			  </tbody>
			</table>
		  </div>
		  <div class="column">
			<h3 class="title is-3">Nýtt matarplan</h3>
			<form method="POST" action="">
			  <div class="field">
			    <label class="label" for="mName">Hvað á matarplanið að heita?</label>
			    <div class="control">
			      <input class="input" name="mName" type="text" placeholder="Heiti">
			    </div>
			  </div>
			  <div class="field">
			    <label class="label" for="fromDate">Tímabil frá</label>
			    <div class="control">
			      <input class="input" name="fromDate" type="text" placeholder="DD/MM/YYYY" />
			    </div>
			  </div>
			  <div class="field">
			    <label class="label" for="toDate">Tímabil til</label>
			    <div class="control">
			      <input class="input" name="toDate" type="text" placeholder="DD/MM/YYYY" />
			    </div>
			  </div>
			  <div class="field">
			    <div class="control">
			      <button class="button is-primary" type="submit">Skrá matarplan</button>
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