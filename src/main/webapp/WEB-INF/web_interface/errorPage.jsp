<!--
	Index page for the site 
	@author Viktor Alex Brynjarsson vab18@hi.is
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
  <jsp:attribute name="header">
     <h1 class="title is-1">Villa kom upp</h1>
     <h2 class="subtitle">Eitthvað hefur farið úrskeðis</h2>
  </jsp:attribute>
  <jsp:body>
	<h3 class="title is-3">Eftirfarandi villa kom upp:</h3>
	<div class="content">
	  <h3 class="has-text-weight-semibold"><c:out value="${attrs.status} ${attrs.error}"/></h3>
	  <p><c:out value="${attrs.message}"/></p>
	</div>
  </jsp:body>
</t:genericpage>