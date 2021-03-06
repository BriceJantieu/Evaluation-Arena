<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<title>List of promos</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="../Menu/menu.jsp"%>
	<div class="container">

		<h1>Promos</h1>

		<table class="table table-striped table-bordered">
			<tr>
				<th>Nom</th>
				<th>Nombre d'élèves</th>
			</tr>

			<c:forEach var="promo" items="${promos}">
				<tr>
					<td>${promo.getLibelle()}</td>
					<td>${promo.getUtilisateurCount()}</td>
					<td>
					<c:if
							test="${promo.getUtilisateurSet() == null || promo.getUtilisateurSet().isEmpty()}">
							<button disabled="disabled" type="button" class="btn btn-default btn-group-sm"
								>
								<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
								Détail
							</button>
						</c:if>
					<c:if
							test="${promo.getUtilisateurSet() != null && !promo.getUtilisateurSet().isEmpty() }">
							<button type="button" class="btn btn-default btn-group-sm"
								data-toggle="modal" data-target="#details${promo.id}">
								<span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span>
								Détail
							</button>


							<div class="modal fade" id="details${promo.id}" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">Liste des
												élèves</h4>
										</div>
										<table class="table table-striped table-bordered">
											<tr>
												<th>Nom</th>
												<th>Prénom</th>
											</tr>

											<c:forEach var="student" items="${promo.getUtilisateurSet()}">
												<tr>
													<td>${student.lastName}</td>
													<td>${student.firstName}</td>
												</tr>
											</c:forEach>
										</table>
									</div>
								</div>
							</div>
						</c:if></td>
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
						<h4 class="modal-title" id="myModalLabel">Ajout Promo</h4>
					</div>
					<form action="promos.html" method="post">
						<div class="modal-body">
							<label>Libellé de la promo :</label> <input class="form-control"
								name="label" type="text" />

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