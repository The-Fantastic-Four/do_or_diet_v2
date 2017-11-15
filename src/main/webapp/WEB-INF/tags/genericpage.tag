<!--
	Base for all pages
	@author Viktor Alex Brynjarsson vab18@hi.is
-->
<%@tag description="Generic template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="is">

	<head>
		<meta charset="utf-8">	
	    <title>Do or Diet!</title>
	    <link rel="stylesheet" href="http://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/bulma_custom.css" type="text/css">
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
		  <button class="button navbar-burger" data-target="navMenu">
		    <span></span>
		    <span></span>
		    <span></span>
		  </button>
	      <div id="navMenu" class="navbar-menu">
	        <div class="navbar-start">
		      <a class="navbar-item" href="/mealplan">Matarplön</a>
		      <a class="navbar-item" href="/recipe">Uppskriftir</a>
		      <a class="navbar-item" href="/shoppinglist">Innkaupalistar</a>
		    </div>
		    <div class="navbar-end">
	          <sec:authorize access="isAuthenticated()">
	            <a class="navbar-item" href="/logout">Útskráning</a>
	          </sec:authorize>
	          <sec:authorize access="!isAuthenticated()">
		      <a class="navbar-item" href="/login">Innskráning</a>
		      <a class="navbar-item" href="/registration">Nýskráning</a>
	          </sec:authorize>
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
	<script>
		document.addEventListener('DOMContentLoaded', function () {

		  // Get all "navbar-burger" elements
		  var $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

		  // Check if there are any navbar burgers
		  if ($navbarBurgers.length > 0) {

		    // Add a click event on each of them
		    $navbarBurgers.forEach(function ($el) {
		      $el.addEventListener('click', function () {

		        // Get the target from the "data-target" attribute
		        var target = $el.dataset.target;
		        var $target = document.getElementById(target);

		        // Toggle the class on both the "navbar-burger" and the "navbar-menu"
		        $el.classList.toggle('is-active');
		        $target.classList.toggle('is-active');

		      });
		    });
		  }

		});
	</script>
  </body>
</html>
