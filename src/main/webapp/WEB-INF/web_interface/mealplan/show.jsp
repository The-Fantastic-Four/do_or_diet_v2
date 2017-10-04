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
	    <title>Matarplön - Breytingar</title>
	</head>
	
	<body>
		<h3>Breyta matarplani</h3>
		<form method="POST" action="/mealplan/${mealPlan.id}/edit">
			<select name="recipeId">
			  <c:forEach items="${recipeList}" var="recipe">
					<option value="${recipe.id}">${recipe.name}</option>
			  </c:forEach>
			</select>
		    <select name="dateForRecipe">
			  <c:forEach items="${mealPlan.dates}" var="mDate">
		  		<fmt:formatDate value="${mDate}" var="dateValue" pattern="yyyy-MM-dd" />
		  		<fmt:formatDate value="${mDate}" var="dateString" pattern="dd.MM.yyyy" />
				<option value="${dateValue}">${dateString}</option>
			  </c:forEach>
			</select>
		    <input type="submit" value="í lagi"/> 
		</form>
		<hr>
		<h3>Already defined dates</h3>
		<c:forEach items="${mealPlan.items}" var="meals">
					<c:out value="${mealPlan.name} | ${meals.recipe.getName()} | ${meals.date.toString()} | ${meals.mealType}"/><br>
		</c:forEach>
		
	</body>
</html>