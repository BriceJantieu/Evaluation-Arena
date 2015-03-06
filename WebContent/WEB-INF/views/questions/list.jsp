<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../Menu/menu.jsp" %>
	<form action="questions.html" method="get">
		<select name="categorie"
			onchange="submit()">
			<option id="0" value="0">Catégories</option>
			<c:forEach var="categorie" items="${categories}">
				<c:if test="${categorie.id == selectedCategorieId}">
					<option selected="selected" value="${categorie.id}">${categorie.name}</option>
				</c:if>
				
				<c:if test="${categorie.id != selectedCategorieId}">
					<option value="${categorie.id}">${categorie.name}</option>
				</c:if>
			</c:forEach>
		</select>
	</form>

	<form action="questions.html" method="get">
		<select name="matiere"
			onchange="submit()">
			<option id="0" value="0">Matières</option>
			<c:forEach var="matiere" items="${matieres}">
				<c:if test="${matiere.id == selectedMatiereId}">
					<option selected="selected" value="${matiere.id}">${matiere.name}</option>
				</c:if>
				
				<c:if test="${matiere.id != selectedMatiereId}">
					<option value="${matiere.id}">${matiere.name}</option>
				</c:if>
			</c:forEach>
			<option selected value="0">Catégories</option>
			<c:forEach var="categorie" items="${categories}">
				<option value="${categorie.id}">${categorie.name}</option>
			</c:forEach>
		</select>
	</form>

	<table class="table table-strip">
		<tr>
			<td><strong>ID</strong></td>
			<td><strong>Nom</strong></td>
			<td><strong>Matière</strong></td>
			<td><strong>Catégorie</strong>
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
</body>
</html>