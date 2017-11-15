<!--
	Page to add recipes
	@author Fannar Þeyr Guðmundsson fthg2@hi.is
	@date September 2017
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:genericpage>
  <jsp:attribute name="header">
    <h1 class="title is-1">
      Matarplön
    </h1>
    <h2 class="subtitle">
      Hvað verður í matinn og hvenær?
    </h2>
  </jsp:attribute>
  <jsp:body>
  	<div class="column">
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
	</div>
    <spring:url value="/resources/js/Addjs.js" var="mainJs" />
	<script src="${mainJs}"></script>
  </jsp:body>
</t:genericpage>
