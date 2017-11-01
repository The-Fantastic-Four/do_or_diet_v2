<!--
	Show and edit a specific mealplan
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Viktor Alex Brynjarsson vab18@hi.is
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
  <jsp:attribute name="header">
    <h1 class="title is-1">
      <c:out value="${mealPlan.name}" />
    </h1>
    <h2 class="subtitle">
      Matarplan
    </h2>
  </jsp:attribute>
  <jsp:body>
    <div class="columns">
      <div class="column is-two-thirds">
        <h3 class="title is-3">Máltíðir</h3>
        <table class="table table is-fullwidth is-striped is-hoverable">
          <thead>
            <tr>
              <th>Uppskrift</th>
              <th>Dagsetning</th>
              <th>Máltíð</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${mealPlan.items}" var="items">
              <tr>
                <td><a href="/recipe/${items.recipe.id}"><c:out value="${items.recipe.getName()}" /></a></td>
                <td><c:out value="${items.date}" /></td>
                <td><c:out value="${items.mealType.displayName}" /></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="column">
        <h3 class="title is-3">Bæta við máltíð</h3>
        <form method="POST" action="/mealplan/${mealPlan.id}/edit">
          <div class="field">
            <label class="label">Uppskrift</label>
            <div class="control">
              <div class="select">
                <select name="recipeId">
                  <c:forEach items="${recipeList}" var="recipe">
                    <option value="${recipe.id}">${recipe.name}</option>
                  </c:forEach>
                </select>
              </div>
            </div>
          </div>
          <div class="field">
            <label class="label">Dagsetning uppskriftar</label>
            <div class="control">
              <div class="select">
                <select name="dateForRecipe">
                  <c:forEach items="${mealPlan.dates}" var="mDate">
                    <fmt:formatDate value="${mDate}" var="dateValue" pattern="yyyy-MM-dd" />
                    <fmt:formatDate value="${mDate}" var="dateString" pattern="dd.MM.yyyy" />
                    <option value="${dateValue}">${dateString}</option>
                  </c:forEach>
                </select>
              </div>
            </div>
          </div>
          <div class="field">
            <div class="control">
              <button class="button is-primary" type="submit">Bæta við</button>
            </div>
          </div>
        </form>
        <h3 class="title is-3">Útbúa innkaupalista</h3>
        <div class="field">
          <div class="control">
            <a href="/shoppinglist/createFromMealPlan/${mealPlan.id}" class="button is-primary">Útbúa</a>
          </div>
        </div>
      </div>
    </div>
  </jsp:body>
</t:genericpage>
