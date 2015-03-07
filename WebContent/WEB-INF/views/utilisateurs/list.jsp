<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<title>List of users</title>
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
 		<script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
	</head>
<body>
	<%@ include file="../Menu/menu.jsp" %>
	<div class="container">
	<form style="margin-bottom : 20px; margin-right : 50px;" class="form-inline pull-right" action="utilisateurs.html" method="get">
		<div class="form-group">
			<label>Select matter : </label>
			<select class="form-control" name="filter_role" onchange="submit()">
				<option selected value="${selectedRoleId}">Groupes Utilisateurs</option>
				<c:forEach var="role" items="${roleList}">
					<c:if test="${role.id == selectedRoleId}">
						<option selected="selected" value="${role.id} }">${role.libelle }</option>
					</c:if>
					<c:if test="${role.id != selectedRoleId }">
						<option value="${role.id}">${role.libelle}</option>
					</c:if>
				</c:forEach>
			</select>
		</div>
	</form>

	<table  class="table table-striped table-bordered">
				<tr>
					<th>ID</th>
					<th>nom</th>
					<th>email</th>
					<th>firstname</th>
					<th>lastname</th>
					<th>password</th>
					<th>birthdate</th>
					<th>Groupe utilisateur</th>
				</tr>
				<c:forEach var="utilisateur" items="${utilisateurs}" >
					<tr>
						<td> ${utilisateur.id} </td>
						<td> ${utilisateur.username} </td>
						<td> ${utilisateur.email} </td>
						<td> ${utilisateur.firstName} </td>
						<td> ${utilisateur.lastName} </td>
						<td> ${utilisateur.password} </td>
						<td> ${utilisateur.birthDate} </td>
						<td> ${utilisateur.role.libelle} </td>
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
        			<h4 class="modal-title" id="myModalLabel">Create question</h4>
      			</div>
      			<form action="users.html" method="post">
      				<div class="modal-body">
      					<label>Username</label>
						<input style="margin-bottom : 10px;" class="form-control" name="username" type="text"/>
      					<label>Email</label>
						<input style="margin-bottom : 10px;" class="form-control" name="email" type="text"/>
						<label>Password</label>
						<input style="margin-bottom : 10px;" class="form-control" name="password" type="text"/>
						<label>FirstName</label>
						<input style="margin-bottom : 10px;" class="form-control" name="firstname" type="text"/>
						<label>LastName</label>
						<input style="margin-bottom : 10px;" class="form-control" name="lastname" type="text"/>
						<label>Birthdate</label>
						<input style="margin-bottom : 10px;" class="form-control" name="birthdate" type="text" data-role="date"/>
		
		<select style="margin-bottom : 10px;" class="form-control" name="groupe">
			<option selected value="0">Groupe</option>
			<c:forEach var="role" items="${roleList}">
				<option value="${role.id}">${role.libelle}</option>
			</c:forEach>
		</select>
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