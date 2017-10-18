<!--
	Registration page for new users
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Ragnheiður Ásta Karlsdóttir rak4@hi.is
-->
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
	<title>Nýskráning</title>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
  <body>
	<section class="hero is-medium">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title is-1">Do or diet</h1>
	      <h2 class="subtitle">Ætlar þú að grennast eða drepast?</h2>
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
  	    <div class="columns is-centered">
  	      <div class="column is-narrow">
		<form autocomplete="off" action="#" th:action="/registration"
			th:object="${user}" method="post" role="form">
			<h3 class="title is-3">Nýskráning</h3>
			  <div class="field">
			    <label class="label" for="username">Hvað heitir þú?</label>
			    <div class="control">
			      <input class="input" name="username" type="text" placeholder="Nafn">
			    </div>
			  </div>
			  <div class="field">
			    <label class="label" for="email">Netfang</label>
			    <div class="control">
			      <input class="input" name="email" type="text" placeholder="Netfang">
			    </div>
			  </div>
			  <div class="field">
			    <label class="label" for="password">Lykilorð</label>
			    <div class="control">
			      <input class="input" name="password" type="password" placeholder="Mjög gott lykilorð">
			    </div>
			  </div>
			  <div class="field is-grouped is-grouped-centered">
			    <div class="control">
			      <button class="button is-primary" type="submit">Skrá notanda</button>
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