<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<<<<<<< HEAD
	<form action="create" method="get">
=======
	<%@ include file="../Menu/menu.jsp" %>
	<form action="create" method="post">
		Nom de l'examen
		<input name="name" type="text"/>
		
>>>>>>> 5009d053a1f7db5002af91600212ab976e469cca
		Matière
		<select name="matiere"
			onchange="submit()">
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
	</form>

	<form action="create" method="post">
		Nom de l'examen
		<input name="name" type="text"/>
		
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
		
		<input type="submit" value="GOGO"/>
		
	</form>
</body>
</html>