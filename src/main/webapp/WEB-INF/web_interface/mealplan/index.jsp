<!--
	Shows a list of meal plans and allows the user to add a new meal plan 
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Viktor Alex Brynjarsson vab18@hi.is
	@date September 2017
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
    <div class="columns">
      <div class="column is-two-thirds">
        <h3 class="title is-3">Matarplön</h3>
        <table class="table table is-fullwidth is-striped is-hoverable">
          <thead>
            <tr>
              <th>Heiti matarplans</th>
              <th>Dagsetning frá</th>
              <th>Dagsetning til</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${mealPlanList}" var="mPlan">
              <tr>
                <td><a href="/mealplan/${mPlan.id}"><c:out value="${mPlan.getName()}" /></a></td>
                <td><c:out value="${mPlan.getDateFrom().toString().substring(0,10)}" /></td>
                <td><c:out value="${mPlan.getDateTo().toString().substring(0,10)}" /></td>
                <td>
                  <a href="/mealplan/deleteMealPlan/${mPlan.id}">
                    <span class="button is-danger">x</span>
                  </a>
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <div class="column">
        <h3 class="title is-3">Nýtt matarplan</h3>
        <form:form method="POST" action="" modelAttribute="mealPlanForm">
          <div class="field">
            <form:label class="label" for="mName" path="name">Hvað á matarplanið að heita?</form:label>
            <div class="control">
              <form:input class="input" name="mName" path="name"
								type="text" placeholder="Heiti" />
              <form:errors path="name" />
            </div>
          </div>
          <div class="field">
            <form:label class="label" for="fromDate" path="fromDate">Tímabil frá</form:label>
            <div class="control">
              <form:input class="input" name="fromDate" path="fromDate"
								type="text" placeholder="DD/MM/YYYY" />
              <form:errors path="fromDate" />
            </div>
          </div>
          <div class="field">
            <form:label class="label" for="toDate" path="toDate">Tímabil til</form:label>
            <div class="control">
              <form:input class="input" name="toDate" path="toDate"
								type="text" placeholder="DD/MM/YYYY" />
              <form:errors path="toDate" />
            </div>
          </div>
          <div class="field">
            <div class="control">
              <button class="button is-primary" type="submit">Skrá matarplan</button>
            </div>
          </div>
        </form:form>
      </div>
    </div>
  </jsp:body>
</t:genericpage>
