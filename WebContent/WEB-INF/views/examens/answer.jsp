<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<title>Examen</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="../Menu/menu.jsp"%>
	<div class="container">
		<h1>${examen.name}</h1>
		<form method="post">
			<c:forEach var="question" items="${questions}">
				<div>
					<br />
					<div class="row">
						<label class="control-label input-group">
							${question.content}</label>

						<div class="btn-group">
							<c:forEach var="response" items="${question.reponseSet}">
								<input type="hidden" name="question${response.id}"
									value="${question.id}">
									
								<input type="radio"
									name="response${question.id}" value="${response.id}">
									${response.content}
								<br/>
							</c:forEach>
						</div>
					</div>
				</div>
			</c:forEach>
			
			
			<br />
			<input type="submit" value="Valider"/>
		</form>
	</div>
</body>
</html>