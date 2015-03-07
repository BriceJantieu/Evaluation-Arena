<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<title>List of questions</title>
 		<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file="../Menu/menu.jsp" %>
		<div class="container">
		<h1>Questions</h1>
			<div class="form-group">
				<form style="margin-bottom : 20px;" class="form-inline pull-right" action="questions.html" method="get">
					<div class="form-group">
						<label>Select category : </label>
						<select name="categorie" onchange="submit()">
							<option id="0" value="0">all categories</option>
							<c:forEach var="categorie" items="${categories}">
								<c:if test="${categorie.id == selectedCategorieId}">
									<option selected="selected" value="${categorie.id}">${categorie.name}</option>
								</c:if>
				
								<c:if test="${categorie.id != selectedCategorieId}">
									<option value="${categorie.id}">${categorie.name}</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</form>
				
				<form style="margin-bottom : 20px; margin-right : 50px;" class="form-inline pull-right" action="questions.html" method="get">
					<div class="form-group">
						<label>Select matter : </label>
							<select name="matiere" onchange="submit()">
								<option id="0" value="0">All matter</option>
								<c:forEach var="matiere" items="${matieres}">
									<c:if test="${matiere.id == selectedMatiereId}">
										<option selected="selected" value="${matiere.id}">${matiere.name}</option>
									</c:if>
				
									<c:if test="${matiere.id != selectedMatiereId}">
										<option value="${matiere.id}">${matiere.name}</option>
									</c:if>
								</c:forEach>
							</select>
					</div>
				</form>
			</div>

	

	<table  class="table table-striped table-bordered">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Matter</th>
			<th>Category</th>
		</tr>
		<c:forEach var="question" items="${questions}" >
			<tr>
				<td> ${question.id} </td>
				<td> ${question.content} </td>
				<td> ${question.categorie.name} </td>
				<td> ${question.categorie.matiere.libelle} </td>
			</tr>
		</c:forEach>
	</table>	
		</div>
</body>
</html>