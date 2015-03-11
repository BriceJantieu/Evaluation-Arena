<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<title>List of questions</title>
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
 		<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file="../Menu/menu.jsp" %>
		<div class="container">
		<h1>Questions</h1>
			<div class="form-group">
				
				<c:if test="${selectedMatiereId != null && !selectedMatiereId.equals('0')}">
					<form style="margin-bottom : 20px;" class="form-inline pull-right" action="questions.html" method="get">
						<div class="form-group">
							<label>Catégorie : </label>
							<select class="form-control" name="categorie" onchange="submit()">
								<option id="0" value="0">Toutes</option>
								<c:forEach var="categorie" items="${categories}">
									<c:if test="${categorie.id == selectedCategorieId}">
										<option selected="selected" value="${categorie.id}">${categorie.name}</option>
									</c:if>
					
									<c:if test="${categorie.id != selectedCategorieId}">
										<option value="${categorie.id}">${categorie.name}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</form>
				</c:if>
				
				<form style="margin-bottom : 20px; margin-right : 50px;" class="form-inline pull-right" action="questions.html" method="get">
					<div class="form-group">
						<label>Matières : </label>
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
			</div>

	

	<table  class="table table-striped table-bordered">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Matière</th>
			<th>Catégorie</th>
		</tr>
		<c:forEach var="question" items="${questions}" >
			<tr>
				<td> ${question.id} </td>
				<td> ${question.content} </td>
				<td> ${question.categorie.matiere.libelle} </td>
				<td> ${question.categorie.name} </td>
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
        			<h4 class="modal-title" id="myModalLabel">Ajout Question</h4>
      			</div>
      			
   				<div class="modal-body">
   					<form action="questions.html" method="get">
						<select style="margin-bottom : 20px;" class="form-control" name="matiere"
							onchange="submit()">
							<option selected value="0">Matière</option>
							<c:forEach var="matiere" items="${matieres}">
								<option value="${matiere.id}">${matiere.libelle}</option>
							</c:forEach>
						</select>
					</form>
					
      				<form action="questions.html" method="post">
      					<label>Libellé de la question : </label>
							
							<input class="form-control" style="margin-bottom : 20px;" name="question" type="text"/>
		
							<c:if test="${selectedMatiereId != null && !selectedMatiereId.equals('0')}">
								<select style="margin-bottom : 20px;" class="form-control" name="categorie">
									<option selected value="0">Catégorie</option>
									<c:forEach var="categorie" items="${categories}">
										<option value="${categorie.id}">${categorie.name}</option>
									</c:forEach>
								</select>
							</c:if>
		
							<label style="margin-bottom : 10px;">Réponses :</label>
   					 		<div style="margin-bottom : 5px;" class="input-group">
      							<span class="input-group-addon">
        							<input name="rightResponse" type="radio" placeholder="réponse 1" aria-label="reponse 1">
      							</span>
      							<input name="response1" type="text" class="form-control" aria-label="...">
    						</div>
    						<div style="margin-bottom : 5px;" class="input-group">
   								<span class="input-group-addon">
        							<input name="rightResponse" type="radio" aria-label="...">
      							</span>
      							<input name="response2" type="text" class="form-control" aria-label="...">
    						</div>
    						<div style="margin-bottom : 5px;" class="input-group">
      							<span class="input-group-addon">
        							<input name="rightResponse" type="radio" aria-label="...">
      							</span>
      							<input name="response3" type="text" class="form-control" aria-label="...">
    						</div>
    						<div style="margin-bottom : 5px;" class="input-group">
      							<span class="input-group-addon">
       								<input name="rightResponse" type="radio" aria-label="...">
      							</span>
    							<input name="response4" type="text" class="form-control" aria-label="...">
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
</div>
</body>
</html>