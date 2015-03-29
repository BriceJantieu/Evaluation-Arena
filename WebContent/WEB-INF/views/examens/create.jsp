<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<title>Création examen</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {
		var $question = $('#questions1'), count = 1;
		var $promo = $('#promo1'), count = 1;

		$('#addquestion').click(function(e) {
			e.preventDefault();
			var idname = 'questions' + (++count);
			$question.parent().append($question.clone().attr({
				id : idname,
				name : idname
			}));
		});

		$('#addpromo').click(function(e) {
			e.preventDefault();
			var idname = 'promo' + (++count);
			$promo.parent().append($promo.clone().attr({
				id : idname,
				name : idname
			}));
		});

	});
</script>
</head>
<body>
	<%@ include file="../Menu/menu.jsp"%>
	<div class="container">
		<div class="col-xs-4 col-xs-offset-4">
			<H1 style="text-align: center; margin-bottom: 50px;">Création examen</H1>
			<form style="margin-bottom: 50px;" action="" method="GET">
				<select class="form-control" name="matiere" onchange="submit()">
					<option selected value="0">Matière</option>
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
			<c:if
				test="${selectedMatiereId != null && !selectedMatiereId.equals('0')}">
				<form action="" method="POST">
					<label style="margin-bottom: 5px;">Nom de l'examen</label> <input
						style="margin-bottom: 20px;" class="form-control" name="name"
						type="text" /> <label style="margin-bottom: 5px;">Questions</label>
					<div style="margin-bottom: 5px;" id="questions">
						<select style="margin-bottom: 10px;" class="form-control"
							name="questions1" id="questions1">
							<option id="0" value="0">Select question</option>
							<c:forEach var="question" items="${questions}">
								<option value="${question.id}">${question.content}</option>
							</c:forEach>
						</select>
					</div>
					<a style="margin-bottom: 20px;" id="addquestion" href="#">Ajout question</a> 
						<br/>
						<label style="margin-bottom: 5px;margin-top:20px;">Promos</label>
					<div style="margin-bottom: 5px;" id="promos">
						<select style="margin-bottom: 10px;" class="form-control"
							name="promo1" id="promo1">
							<option id="0" value="0">Select promo</option>
							<c:forEach var="promo" items="${promos}">
								<option value="${promo.id}">${promo.libelle}</option>
							</c:forEach>
						</select>
					</div>
					
					<a style="margin-bottom: 20px;" id="addpromo" href="#">Ajout promo</a>
					
					<div style="margin-bottom: 5px;" id="promos">
						<br/>
						<label style="margin-bottom: 5px;margin-top:20px;">Date de fin</label>
						<br/>
						<input style="margin-bottom: 10px;" class="form-control" type="date" name="date"/>
					</div>
		
					<div class="form-group" style="margin-top: 20px;">
						<div class="">
							<button type="submit" class="col-md-4 btn btn-primary">Ajouter</button>
						</div>
					</div>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>