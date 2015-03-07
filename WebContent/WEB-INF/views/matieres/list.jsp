<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<title>List of matter</title>
 		<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file="../Menu/menu.jsp" %>
		<div class="container">
			<h1>Matter</h1>
			<table  class="table table-striped table-bordered">
				<tr>
					<th>Name</th>
				</tr>
		
				<c:forEach var="matiere" items="${matieres}" >
					<tr>
						<td> ${matiere.libelle} </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>