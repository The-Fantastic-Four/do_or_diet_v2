<!--
	Shows a list of shopping lists
	@author Viktor Alex Brynjarsson vab18@hi.is
	@date November 2017
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
  <jsp:attribute name="header">
	<h1 class="title is-1">
	  Innkaupalistar
	</h1>
	<h2 class="subtitle">
	  Ertu orðin þreytt(ur) á að gleyma mjólkinni?
	</h2>
  </jsp:attribute>
  <jsp:body>
  	<div class="columns">
  	  <div class="column">
		<h3 class="title is-3">Innkaupalistar</h3>
		<table class="table table is-fullwidth is-striped is-hoverable">
		  <thead>
			<tr>
			  <th>Númer lista</th>
			  <th>Heiti matarplans</th>
			</tr>
		  </thead>
		  <tbody>
			<c:forEach items="${shoppingLists}" var="shoppingList">
			  <tr>
				<td><a href="/shoppinglist/${shoppingList.id}"><c:out value="${shoppingList.getId()}" /></a></td>
				<td><a href="/mealplan/${shoppingList.mealPlan.id}"><c:out value="${shoppingList.mealPlan.getName()}" /></a></td>
			  </tr>
			</c:forEach>
		  </tbody>
		</table>
	  </div>
	</div>
  </jsp:body>
</t:genericpage>
