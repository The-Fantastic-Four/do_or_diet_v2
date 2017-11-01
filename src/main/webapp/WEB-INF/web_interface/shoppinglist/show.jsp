<!--
	Show an shopping list
	@author Viktor Alex Brynjarsson vab18@hi.is
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
        <table class="table table is-fullwidth is-striped is-hoverable">
          <!--thead>
          <tr>
            <th>&nbsp;</th>
            <th>Heiti</th>
            <th></th>
            <th>Máltíð</th>
          </tr>
          </thead-->
          <tbody>
            <c:forEach items="${shoppingList.getItems()}" var="item">
              <tr>
                <td><input type="checkbox"></td>
                <td><c:out value="${item.getItemName()}" /></td>
                <td><c:out value="${item.getAmount()}" /></td>
                <td><c:out value="${item.getMeasurement()}" /></td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
    </div>
  </jsp:body>
</t:genericpage>
