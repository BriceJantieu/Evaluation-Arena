<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<title>List of matter</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="../Menu/menu.jsp"%>
	<div class="container">
		<h1>Matières</h1>
		<table class="table table-striped table-bordered">
			<tr>
				<th>Nom</th>
				<th>Nombre de catégories</th>

			</tr>

			<c:forEach var="matiere" items="${matieres}">
				<tr>
					<td>${matiere.libelle}</td>
					<td>${matiere.getCategoryCount() }</td>
					<td>
						<c:if
							test="${matiere.getCategorieSet() == null || matiere.getCategorieSet().isEmpty()}">
							<button disabled="disabled" type="button" class="btn btn-default btn-group-sm"
								>
								<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
								Détail
							</button>
						</c:if>
						<c:if
							test="${matiere.getCategorieSet() != null && !matiere.getCategorieSet().isEmpty()}">
							<button type="button" class="btn btn-default btn-group-sm"
								data-toggle="modal" data-target="#details${matiere.id}">
								<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
								Détail
							</button>
							<div class="modal fade" id="details${matiere.id}" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">Liste des
												catégories</h4>
										</div>
										<table class="table table-striped table-bordered">
											<tr>
												<th>Nom</th>
											</tr>

											<c:forEach var="category"
												items="${matiere.getCategorieSet()}">
												<tr>
													<td>${category.name}</td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</div>
							</div>
						</c:if>
						</td>
				</tr>
			</c:forEach>
		</table>
		<button type="button" class="btn btn-primary btn-lg"
			data-toggle="modal" data-target="#myModal">Ajouter</button>


		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Ajout matière</h4>
					</div>
					<form action="matieres.html" method="post">
						<div class="modal-body">
							<label>Libellé de la matière :</label> <input
								class="form-control" name="label" type="text" />

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Fermer</button>
							<button type="submit" class="btn btn-primary">Enregistrer</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>