<!--
	Log in page 
	@author Ei�ur �rn Gunnarsson eog26@hi.is
	@author Ragnhei�ur �sta Karlsd�ttir rak4@hi.is
-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">

<head>
	<title>Innskr�ning</title>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css" type="text/css">
	    <link rel="stylesheet" href="/resources/css/styles.css" type="text/css" />
	</head>
	
  <body>
	<section class="hero is-medium">
	  <div class="hero-body">
	    <div class="container">
	      <h1 class="title is-1">Do or diet</h1>
	      <h2 class="subtitle">�tlar �� a� grennast e�a drepast?</h2>
   		</div>
  	  </div>
	  <nav class="navbar" role="navigation" aria-label="main navigation">
		<div class="container">
	      <div class="navbar-menu">
	        <div class="navbar-start">
		      <a class="navbar-item" href="/mealplan">Matarpl�n</a>
		      <a class="navbar-item" href="/recipe">Uppskriftir</a>
		    </div>
		    <div class="navbar-end">
		      <a class="navbar-item" href="/login">Innskr�ning</a>
		      <a class="navbar-item" href="/registration">N�skr�ning</a>
		    </div>
		  </div>
		</div>
	  </nav>
	</section>
	<section class="section">
  	  <div class="container">
  	    <div class="columns is-centered">
  	      <div class="column is-narrow">
		<form th:action="@{/login}" method="POST" >
			<h3 class="title is-3">Innskr�ning</h3>
			  <div class="field">
			    <label class="label" for="email">Netfang</label>
			    <div class="control">
			      <input class="input" name="email" type="text" placeholder="Netfang">
			    </div>
			  </div>
			  <div class="field">
			    <label class="label" for="password">Lykilor�</label>
			    <div class="control">
			      <input class="input" name="password" type="password" placeholder="Lykilor�">
			    </div>
			  </div>
			  <div class="field is-grouped is-grouped-centered">
			    <div class="control">
			      <button class="button is-primary" type="submit">Innskr�ning</button>
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