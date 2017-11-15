<!--
	Show and edit a specific mealplan
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Viktor Alex Brynjarsson vab18@hi.is
	@author Fannar Þeyr Guðmundsson fthg2@hi.is
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<t:genericpage>
  <jsp:attribute name="header">
    <h1 class="title is-1">
      <c:out value="${recipe.name}" />
    </h1>
    <h2 class="subtitle">
      Uppskrift
    </h2>
  </jsp:attribute>
  <jsp:body>
  	<div class="columns">
  	  <div class="column">
		<h3 class="title is-3">Breyta uppskrift</h3>
		<form>
  	  	<table class="table table is-fullwidth is-striped is-hoverable">
  	  	  <thead>
  	  	  	<tr>
  	  	  	  <th>nr</th>	
  	  	  	  <th>Uppskrift</th>
  	  	  	  <th>Fjöldi manns</th>
  	  	  	  <th>Leiðbeiningar</th>
  	  	  	</tr>
  	  	  </thead>
  	  	  <tbody>
  	  	  	<tr>
  	  	  	  <td id="recipeId"><c:out value="${recipe.id}"/></td>
			  <td contenteditable="true" id="recipeName"><c:out value="${recipe.name}" /></td>
			  <td contenteditable="true" id="servings"><c:out value="${recipe.servings}" /></td>
		      <td contenteditable="true" id="directions"><c:out value="${recipe.directions}" /></td>
			</tr>
		  </tbody>
		 </table> 
		 <table class="table id=myTable table is-fullwidth is-striped is-hoverable">
		  <thead>
		  	<tr>
			  	<th>Hráefni</th>
				<th>Fjöldi</th>
		  		<th>Mælieining</th>
			</tr>
		  <thead>
		  <tbody>
			<tr>
				<c:forEach items="${recipe.ingredients}" var="IngrtQuantity" varStatus="loop">
		   		  <tr>
	 	   	   	 	 <td contenteditable="true" id="name${loop.index}"><c:out value="${IngrtQuantity.ingredient.name}" /></a></td>
	  	   			 <td contenteditable="true" id="quantity${loop.index}"><c:out value="${IngrtQuantity.quantity}" /></td>
	  	   	    	 <td contenteditable="true" id="measurement${loop.index}"><c:out value="${IngrtQuantity.measurement}" /></td>
	  	   	    	 <input type="hidden" id="number">
	  	  		  </tr>
			    </c:forEach>
			 </tr>
		  </tbody>	  	    		
		 </table>
	     <p class="control"><input type="button" class="button is-primary" value="Vista" onClick="saveChangedRecipe()" /></p>
		</form> 
	  </div>		  				  
    </div>
    <spring:url value="/resources/js/Addjs.js" var="mainJs" />
	<script src="${mainJs}"></script>
  </jsp:body>
</t:genericpage>