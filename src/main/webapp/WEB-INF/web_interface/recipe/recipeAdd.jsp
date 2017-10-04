<!--
	Síða til að bæta við uppskriftum
	Fannar Þeyr Guðmundsson fthg2@hi.is  
-->

<%@page import="is.hi.hbv.do_or_diet.model.Recipe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="is">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
	<head>
		<meta charset="utf-8">	
	    <title>New recipes</title>
	    <spring:url value="/resources/js/Addjs.js" var="mainJs" />
 		<script src="${mainJs}"></script>
	</head>
	
	<body>
		<h1>Nýjar uppskriftir</h1>
  	
  	<!-- Hérna er hnappur sem nýtir javascript til að leyfa að skrá fleiri hráefni fyrir nýja uppskrift -->
  	<div id="recipe">			
		<title>items="${recipeList}" var="recipe"></title> 	
	 		<form method="POST" action="" id="recipeForm" >
		 		Nafn á uppskrift: <input type="text" name="name" id="recipeName">
		 		<br>
		 		skammtastærð fyrir: <input type="int" name="name" id="servings">
		 		<br>
	      		<textarea rows="15" cols="50" name="directions" id="directions"> Hvernig á að matreiða uppskriftina?</textarea>
	      		<br>
	      		<input type="button" value="Bæta við hráefni" onClick="addInput('ingredientDiv')" />
	      		<input type="button" value="í lagi" onClick="saveRecipe()" /> 
      	      
    		</form>
    		
    		<div id ="ingredientDiv">
    		
    		</div>
    		
 	 </div>
 	 
 	 
 	 <!-- div>
 	 	<%
 	 		Recipe recipe = new Recipe();
 	 		recipe.setName("kartoflur");
 	 	%>
 	 	
 	 	<input type="text" value="<%= recipe.getName()%>"></input>
 	 	
 	 </div-->
	</body>
</html>
