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
	Matières
	<table class="table table-strip">
		<tr>
			<td><strong>Nom</strong></td>
		</tr>
		
		<c:forEach var="matiere" items="${matieres}" >
			<tr>
				<td> ${matiere.libelle} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>