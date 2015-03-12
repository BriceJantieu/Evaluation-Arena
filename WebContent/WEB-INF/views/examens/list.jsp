<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<title>Create examen</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="../Menu/menu.jsp"%>
	<div class="container">
		<H1>Liste de vos examens passés</H1>
		<table class="table table-striped table-bordered">
				<tr>
					<th>Nom</th>
					<th>Matiere</th>
					<th>Note</th>
				</tr>
		
				<c:forEach var="examen" items="${examens}" >
					<tr>
						<td> ${examen.examen.name} </td>
						<td> ${examen.examen.matiere.libelle} </td>
					</tr>
				</c:forEach>
			</table>
	
	</div>
</body>
</html>