<!--Upphafssíða verkefnisins 
	Ragnheiður Ásta Karlsdóttir rak4@hi.is-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="is">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<head>
		<meta charset="utf-8">	
	    <title>Matarplön</title>
	</head>
	
	<body>
		<h1>Matarplön</h1>
		<c:forEach items="${mealPlanList}" var="mPlan">
			<a href="/mealplan/${mPlan.id}/edit"><c:out value="${mPlan.id} - ${mPlan.name}"/></a><br>
		</c:forEach>
		
		<hr>
		
		<h3>Nýtt matarplan</h3>
		<form method="POST" action="">
		    Hvað á matarplanið að heita? <input name="mName" type="text" placeholder="Nafn matarplans" /> 
		    <br><br>
		    Tímabil: 
		    <br>
		    Frá:<input name="fromDate" type="text" placeholder="DD/MM/YYYY" /> Til:<input name="toDate" type="text" placeholder="DD/MM/YYYY" />
		    <input type="submit" value="í lagi"/> 
		</form>
		
		<hr>
		
		<h3>Breyta matarplani</h3>
		<form method="POST" action="/mealplan/edit/">
		    Hvaða matarplani á að breyta?
		    <select name="mId">
			  <c:forEach items="${mealPlanList}" var="mPlan">
					<option value="${mPlan.id}">${mPlan.name}</option>
			  </c:forEach>
			</select>
		    <input type="submit" value="í lagi"/> 
		</form>
	</body>
</html>