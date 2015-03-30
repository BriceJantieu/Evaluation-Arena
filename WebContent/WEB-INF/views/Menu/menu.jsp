
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/EvaluationArena/Ressource/css/styles.css">
<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="/EvaluationArena/Ressource/js/script.js"></script>
<div id='cssmenu'>
<ul>
   <li><a href='/EvaluationArena/home'>Accueil</a></li>
   <c:if test="${userRole != null && userRole.equals('student')}">
   	<li><a href='/EvaluationArena/examens'>Mes notes</a></li>
   </c:if>
   <c:if test="${userRole != null && userRole.equals('admin')}">
   	<li><a href='/EvaluationArena/promos'>Promos</a></li>
   	<li><a href='/EvaluationArena/users'>Utilisateurs</a></li>
   </c:if>
   
   <c:if test="${userRole != null && !userRole.equals('student')}">
   <li><a>Examens</a>
      <ul>
   			<li><a href='/EvaluationArena/examens'>Liste</a></li>
   			<li><a href='/EvaluationArena/examens/create'>Création</a></li>
   		</ul>
   </li>
   <li><a href='/EvaluationArena/categories'>Catégories</a></li>
   <li><a href='/EvaluationArena/matieres'>Matières</a></li>
   <li><a href='/EvaluationArena/questions'>Questions</a></li>
   </c:if>
   
   <li><a href='/EvaluationArena/logout.html'>Déconnexion</a></li>
   
</ul>
</div>