<!--
	Log in page 
	@author Eiður Örn Gunnarsson eog26@hi.is
	@author Ragnheiður Ásta Karlsdóttir rak4@hi.is
	@date Oktober 2017
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
  <jsp:attribute name="header">
    <h1 class="title is-1">Do or diet</h1>
    <h2 class="subtitle">Ætlar þú að grennast eða drepast?</h2>
  </jsp:attribute>
  <jsp:body>
    <div class="columns is-centered">
      <div class="column is-narrow">
        <form th:action="@{/login}" method="post" >
          <h3 class="title is-3">Innskráning</h3>
          <div class="field">
            <label class="label" for="email">Netfang</label>
            <div class="control">
              <input class="input" name="email" type="text" placeholder="netfang">
            </div>
          </div>
          <div class="field">
            <label class="label" for="password">Lykilorð</label>
            <div class="control">
              <input class="input" name="password" type="password" placeholder="lykilorð">
            </div>
          </div>
          <div class="field is-grouped is-grouped-centered">
            <div class="control">
              <button class="button is-primary" type="submit">Innskráning</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </jsp:body>
</t:genericpage>
