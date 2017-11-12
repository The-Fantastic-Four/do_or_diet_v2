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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<h3 class="title is-3">Leita að uppskrift</h3>
			<form method="POST" action="">
				<div class="field">
					<label class="label">Nafn á uppskrift:</label>
					<div class="control">
						<input class="input" type="text" name="recipeName"
							placeholder="Nafn uppskriftar">
					</div>
				</div>
				<div class="field">
					<div class="control">
						<button class="button is-primary" type="submit">Leita</button>
					</div>
				</div>
			</form>
		</div>
	</div>
  </jsp:body>
</t:genericpage>