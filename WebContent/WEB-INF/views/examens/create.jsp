<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<title>Create examen</title>
 		<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
	</head>
<body>
	<%@ include file="../Menu/menu.jsp" %>
<!--<div class="container">
	<form action="create" method="post">
		Nom de l'examen
		<input name="name" type="text"/>
		Matière
		<select name="matiere"
			onchange="submit()">
	
 <div class="col-md-offset-4 col-md-8 row">
  <h2>Create examen</h2>
  <form class="form-horizontal" action="create" method="post" role="form">
    <div class="form-group">
      <label class="control-label col-md-3" for="email">Name of examen :</label>
      <div class="col-md-3">
        <input type="text" class="form-control" name="name" placeholder="Enter name">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-md-3" for="pwd">Matter :</label>
      <div class="col-md-3">          
        <select class="form-control" name="matiere">
			<option selected value="0">Matière</option>
			<c:forEach var="matiere" items="${matieres}">
				<c:if test="${matiere.id == selectedMatiereId}">
					<option selected="selected" value="${matiere.id}">${matiere.libelle}</option>
				</c:if>
				
				<c:if test="${matiere.id != selectedMatiereId}">
					<option value="${matiere.id}">${matiere.libelle}</option>
				</c:if>
			</c:forEach>
		</select>
		</div>
		</div>
	</form> -->
	<form action="create" method="post">
		Nom de l'examen
		<input name="name" type="text"/>
		
		Matière
		<select name="matieres">
			<c:forEach var="matiere" items="${matieres}">
				<c:if test="${matiere.id == selectedMatiereId}">
					<option selected="selected" value="${matiere.id}">${matiere.libelle}</option>
				</c:if>
	
				<c:if test="${matiere.id != selectedMatiereId}">
					<option value="${matiere.id}">${matiere.libelle}</option>
				</c:if>
			</c:forEach>
		</select>
		
		<br/>
		Questions
		<select multiple name="questions">
			<c:forEach var="question" items="${questions}">
				<option value="${question.id}">${question.content}</option>
			</c:forEach>
		</select>
		
		<br/>
		Promos
		<select multiple name="promos">
			<c:forEach var="promo" items="${promos}">
				<option value="${promo.id}">${promo.libelle}</option>
			</c:forEach>
		</select>
    <div class="form-group">        
      <div class="">
        <button type="submit" class="col-md-3 btn btn-primary">Save</button>
      </div>
    </div>
  </form>
</body>
</html>