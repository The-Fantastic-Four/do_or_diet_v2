<!--
	Registration page for new users
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
          	  <c:if test="${not empty successMessage}">
          	    <article class="message is-success">
				  <div class="message-body">
					<c:out value="${successMessage}" />
				  </div>
			    </article>
			  </c:if>
              <form autocomplete="off" action="#" th:action="/registration"
                  th:object="${user}" method="post" role="form">
                <h3 class="title is-3">Nýskráning</h3>
                <div class="field">
                    <label class="label" for="username">Hvað heitir þú?</label>
                    <div class="control">
                        <input class="input" name="username" type="text" placeholder="Nafn">
                    </div>
                </div>
                <div class="field">
                    <label class="label" for="email">Netfang</label>
                    <div class="control">
                        <input class="input" name="email" type="text" placeholder="Netfang">
                    </div>
                </div>
                <div class="field">
                    <label class="label" for="password">Lykilorð</label>
                    <div class="control">
                        <input class="input" name="password" type="password" placeholder="Mjög gott lykilorð">
                    </div>
                </div>
                <div class="field is-grouped is-grouped-centered">
                    <div class="control">
                        <button class="button is-primary" type="submit">Skrá notanda</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
  </jsp:body>
</t:genericpage>
