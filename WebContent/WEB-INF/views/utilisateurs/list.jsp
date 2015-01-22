<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="utilisateurs.html" method="get">
	<select name="groupe"
	onchange="submit()">
		<option selected value="0">Groupes Utilisateurs</option>
		<c:forEach var="categorie" items="${groupes}">
			<option value="${groupe.id}">${groupe.name}</option>
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
						<td> ${utilisateur.firstname} </td>
						<td> ${utilisateur.lastname} </td>
						<td> ${utilisateur.password} </td>
						<td> ${utilisateur.birthdate} </td>
						<td> ${utilisateur.role.name} </td>
					</tr>
				</c:forEach>
			</table>
</body>
</html>