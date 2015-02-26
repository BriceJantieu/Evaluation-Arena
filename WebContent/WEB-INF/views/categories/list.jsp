<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="categories.html" method="get">
		<select name="matiere"
			onchange="submit()">
			<option id="0" value="0">Matieres</option>
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
	
	Catégories
	<table class="table table-strip">
		<tr>
			<td><strong>Nom</strong></td>
		</tr>
		
		<c:forEach var="category" items="${categories}" >
			<tr>
				<td> ${category.name} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>