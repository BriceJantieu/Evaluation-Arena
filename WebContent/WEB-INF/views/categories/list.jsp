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
			<h1>Categories</h1>
			<form style="margin-bottom : 20px;" class="form-inline pull-right" action="categories.html" method="get">
				<div class="form-group">
    			<label>Select matter : </label>
					<select class="form-control" name="matiere" onchange="submit()">
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
				</div>
			</form>
			
			<table class="table table-striped table-bordered">
				<tr>
					<th>Name</th>
				</tr>
		
				<c:forEach var="category" items="${categories}" >
					<tr>
						<td> ${category.name} </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>