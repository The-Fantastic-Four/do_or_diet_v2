<!--
	Shows a list of meal plans and allows the user to add a new meal plan 
	@author Ragnheiður Ásta Karlsdóttir rak4@hi.is
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:genericpage>
  <jsp:attribute name="header">
    <h1 class="title is-1">
      Uppskriftir
    </h1>
    <h2 class="subtitle">
      Allt milli himins og jarðar
    </h2>
  </jsp:attribute>
  <jsp:body>
	<div class="columns">
		<div class="column">
			<sec:authorize access="isAuthenticated()">
				<h3 class="title is-3">Mínar uppskriftir</h3>
				<div class="content">
					<ul>
						<c:forEach items="${myRecipeList}" var="recipe">
							<li><a href="/recipe/${recipe.id}"><c:out
									value="${recipe.name}" /></a></li>
						</c:forEach>
					</ul>
				<a class="button is-primary" href="/recipe/recipeAdd">Bæta við
					uppskrift</a>
				</div>
			</sec:authorize>
			<h3 class="title is-3">Allar uppskriftir</h3>
			<div class="content">
				<ul>
					<c:forEach items="${recipeList}" var="recipe">
						<li><a href="/recipe/${recipe.id}"><c:out
									value="${recipe.name}" /></a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="column">
			<h3 class="title is-3">Leita að uppskrift</h3>
			<form method="POST" action="">
				<div class="field">
					<label class="label">Nafn á uppskrift:</label>
					<div class="control">
						<input class="input" type="text" name="recipeSearchName"
							placeholder="Nafn uppskriftar">
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
  </jsp:body>
</t:genericpage>