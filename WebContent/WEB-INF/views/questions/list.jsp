<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="questions.html" method="get">
	<select name="matiere"
	onchange="submit()">
		<option selected value="0">Matière</option>
		<c:forEach var="matiere" items="${matieres}">
			<option value="${matiere.id}">${matiere.name}</option>
		</c:forEach>
	</select>
</form>

<table class="table table-strip">
				<tr>
					<td><strong>ID</strong></td>
					<td><strong>nom</strong></td>
					<td><strong>matière</strong></td>
					<td></td>
				</tr>
				<c:forEach var="question" items="${questions}" >
					<tr>
						<td> ${question.id} </td>
						<td> ${question.content} </td>
						<td> ${question.matiere.name} </td>
					</tr>
				</c:forEach>
			</table>
</body>
</html>