<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<title>List of matter</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
 		<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
	</head>
	<body>
		<%@ include file="../Menu/menu.jsp" %>
		<div class="container">
			<h1>Matters</h1>
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
			<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  	Create
	</button>


	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">Create matter</h4>
      			</div>
      			<form action="matieres.html" method="post">
      				<div class="modal-body">
      					<div class="form-group">
    						<label>Libellé de la matière :</label>
							<input name="label" type="text"/>
						</div>
      				</div>
      				<div class="modal-footer">
        				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        				<button type="submit" class="btn btn-primary" >Save</button>
      				</div>
      			</form>
    		</div>
  		</div>
	</div>
</div>
	</body>
</html>