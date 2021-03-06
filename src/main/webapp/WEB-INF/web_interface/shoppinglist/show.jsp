<!--
	Show an shopping list
	@author Viktor Alex Brynjarsson vab18@hi.is
	@date November 1
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
  <jsp:attribute name="header">
    <h1 class="title is-1">
      Innkaupalisti
    </h1>
    <h2 class="subtitle">
      <c:out value="${shoppingList.getMealPlan().getName()}" />
    </h2>
  </jsp:attribute>
  <jsp:body>
    <div class="columns">
      <div class="column">
        <h3 class="title is-3">Innkaup</h3>
        <table class="table table is-striped is-hoverable">
          <thead>
          <tr>
            <th>&nbsp;</th>
            <th class="has-text-right">Magn</th>
            <th>Mælieining</th>
            <th>Heiti</th>
          </tr>
          </thead>
          <tbody>
            <c:forEach items="${shoppingList.getItems()}" var="item">
              <tr>
                <td>
                	<form action="/shoppinglist/${shoppingList.getId()}/${item.getId()}/toggleItemChecked" method="POST">
                		<c:choose>
						    <c:when test="${item.isChecked()}">
                				<button type="submit" class="button"><i class="ion-android-checkbox-outline"></i></button>
						    </c:when>    
						    <c:otherwise>
                				<button type="submit" class="button"><i class="ion-android-checkbox-outline-blank"></i></button>
						    </c:otherwise>
						</c:choose>
                	</form>
                </td>
                <td class="has-text-right"><c:out value="${item.getAmount()}" /></td>
                <td><c:out value="${item.getMeasurement()}" /></td>
                <td><c:out value="${item.getItemName()}" /></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </jsp:body>
</t:genericpage>
