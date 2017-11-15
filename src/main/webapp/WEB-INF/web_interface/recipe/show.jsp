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
  	  	<div class = "two-thirds column">
 			<table class="table table is-fullwidth is-striped is-hoverable">
  			  <thead>
  	  			<tr>
  	  			  <th>Uppskrift af</th>
  	  		 	  <th>Fjöldi skammta</th>
  	  			  <th>Leiðbeiningar</th>
  	  			</tr>
  	  		  </thead>
  	  		  <tbody>
  	  			<tr>
				  <td><c:out value="${recipe.name}" /></td>
				  <td><c:out value="${recipe.servings}" /></td>
			   	  <td><c:out value="${recipe.directions}" /></td>
				</tr>
			  </tbody>
			</table>
		  </div>
		  <div class = "one-third column">
		  	<table class="table table is-fullwidth is-striped is-hoverable">
		  		<thead>
				  	<tr>
					  	<th>Hráefni</th>
				  		<th>Fjöldi</th>
				  		<th>Mælieining</th>
					</tr>
				</thead>
		   	    <tbody>
					<c:forEach items="${recipe.ingredients}" var="IngrtQuantity">
		   			  <tr>
	 	   	   		 	 <td><c:out value="${IngrtQuantity.ingredient.name}" /></a></td>
	  	   				 <td><c:out value="${IngrtQuantity.quantity}" /></td>
	  	   		   	 	 <td><c:out value="${IngrtQuantity.measurement}" /></td>
	  	  			  </tr>
			    	 </c:forEach>
				</tbody>
			</table>
			<foot>
					<a href="/recipe/changeRecipe/${recipe.id}"><value="${recipe.name}">Breyta uppskrift<a/>
				</foot>	
	  	 </div>		 		  
    </div>
  </jsp:body>
</t:genericpage>