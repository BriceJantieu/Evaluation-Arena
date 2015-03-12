<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<title>List of categories</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
 		<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file="../Menu/menu.jsp" %>
		
		<div class="container">
			<h1>Catégories</h1>
			<form style="margin-bottom : 20px;" class="form-inline pull-right" action="categories.html" method="get">
				<div class="form-group">
    			<label>Matière : </label>
					<select class="form-control" name="matiere" onchange="submit()">
						<option id="0" value="0">Toutes</option>
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
					<th>Nom</th>
					<th>Matière</th>
				</tr>
		
				<c:forEach var="category" items="${categories}" >
					<tr>
						<td> ${category.name} </td>
						<td> ${category.matiere.libelle} </td>
					</tr>
				</c:forEach>
			</table>
			<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  	Ajouter
	</button>


	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">Ajout catégorie</h4>
      			</div>
      			<form action="categories.html" method="post">
      				<div class="modal-body">
    					<label>Libellé de la categorie :</label>
						<input style="margin-bottom : 20px;" class="form-control" name="name" type="text"/>
						<div class="form-group">
							<select class="form-control" name="matiere">
								<option selected value="0">Matière</option>
								<c:forEach var="matiere" items="${matieres}">
									<option value="${matiere.id}">${matiere.libelle}</option>
								</c:forEach>
							</select>
						</div>
      				</div>
      				<div class="modal-footer">
        				<button type="button" class="btn btn-default" data-dismiss="modal">Fermer</button>
        				<button type="submit" class="btn btn-primary" >Enregistrer</button>
      				</div>
      			</form>
    		</div>
  		</div>
	</div>
</div>
	</body>
</html>