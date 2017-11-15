<!--
	Show and edit a specific mealplan
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Viktor Alex Brynjarsson vab18@hi.is
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
	  	  	<div class = "is-half column content">
				<h2 class="title" id="recipeName"><c:out value="${recipe.name}" /></h2>
				<p class="has-text-weight-bold" id="servings">Fjöldi skammta: <c:out value="${recipe.servings}" /></p>
				<div id="directions"><c:out value="${recipe.directions}" /></div>
		  	</div>
		  	<div class = "is-half column">
		  	<table class="table table is-fullwidth is-striped is-hoverable">
		  		<thead>
				  	<tr>
				  		<th class="has-text-right">Fjöldi</th>
				  		<th>Mælieining</th>
					  	<th>Hráefni</th>
					</tr>
				</thead>
		   	    <tbody>
					<c:forEach items="${recipe.ingredients}" var="IngrtQuantity">
		   			  <tr>
	 	  			  	<td class="has-text-right" id="quantity"><c:out value="${IngrtQuantity.quantity}" /></td>
	  	   		   	 	<td id="measurement"><c:out value="${IngrtQuantity.measurement}" /></td>
	 	   	   		 	<td id="name"><c:out value="${IngrtQuantity.ingredient.name}" /></a></td>
	  	  			  </tr>
			    	</c:forEach>
				</tbody>
			</table>
				<a class="button is-primary" href="/recipe/${recipe.id}/own">Bæta í mínar uppskriftir</a>
				<a class="button is-primary is-outlined" href="/recipe/changeRecipe/${recipe.id}"><value="${recipe.name}">Breyta uppskrift<a/>	
	  	 </div>		 		  
    </div>
  </jsp:body>
</t:genericpage>