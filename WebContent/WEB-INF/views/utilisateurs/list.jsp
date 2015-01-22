<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Utilisateurs Preview</title>
</head>
<body>

<form action="utilisateurs.html" method="get">
	<select name="filter_role"
	onchange="submit()">
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
</form>

<table class="table table-strip">
				<tr>
					<td><strong>ID</strong></td>
					<td><strong>nom</strong></td>
					<td><strong>email</strong></td>
					<td><strong>firstname</strong></td>
					<td><strong>lastname</strong></td>
					<td><strong>password</strong></td>
					<td><strong>birthdate</strong></td>
					<td><strong>Groupe utilisateur</strong></td>
					<td></td>
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
</body>
</html>