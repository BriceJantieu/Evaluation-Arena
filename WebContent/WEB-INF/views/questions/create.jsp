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
	<form action="create" method="post">
		Libellé de la question
		<input name="question" type="text"/>
		
		Matière
		<select name="matiere">
			<option selected value="0">Matière</option>
			<c:forEach var="matiere" items="${matieres}">
				<option value="${matiere.id}">${matiere.libelle}</option>
			</c:forEach>
		</select>
		
		Catégories
		<select name="categorie">
			<option selected value="0">Catégorie</option>
			<c:forEach var="categorie" items="${categories}">
				<option value="${categorie.id}">${categorie.name}</option>
			</c:forEach>
		</select>
		
		Réponses
		<input name="response1" type="text"/>
		<input name="rightResponse" value="1" type="radio"/>
		<input name="response2" type="text"/>
		<input name="rightResponse" value="2" type="radio"/>
		<input name="response3" type="text"/>
		<input name="rightResponse" value="3" type="radio"/>
		<input name="response4" type="text"/>
		<input name="rightResponse" value="4" type="radio"/>
		
		<input type="submit" value="GOGO"/>
		
	</form>

</body>
</html>