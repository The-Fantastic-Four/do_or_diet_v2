<!--
	Base for all pages
	@author Viktor Alex Brynjarsson vab18@hi.is
-->
<%@tag description="Generic template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<!--%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %-->
<!DOCTYPE html>
<html lang="is">

	<head>
		<meta charset="utf-8">	
	    <title>Do or Diet!</title>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
	<body>
	<section class="hero is-medium">
	  <div class="hero-body">
	    <div class="container">
	      <jsp:invoke fragment="header" />
	    </div>
	  </div>
	  <nav class="navbar" role="navigation" aria-label="main navigation">
		<div class="container">
	      <div class="navbar-menu">
	        <div class="navbar-start">
		      <a class="navbar-item" href="/mealplan">Matarplön</a>
		      <a class="navbar-item" href="/recipe">Uppskriftir</a>
		      <a class="navbar-item" href="/shoppinglist">Innkaupalistar</a>
		    </div>
		    <div class="navbar-end">
          <!-- sec:authorize access="isAuthenticated()">
            <a class="navbar-item" href="#">Loggaður inn</a>
          </sec:authorize-->
		      <a class="navbar-item" href="/login">Innskráning</a>
		      <a class="navbar-item" href="/registration">Nýskráning</a>
		    </div>
		  </div>
		</div>
	  </nav>
	</section>
	<section class="section">
	  <div class="container">
		<jsp:doBody />
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
