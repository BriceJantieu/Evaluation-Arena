<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create New User</title>
</head>
<body>
	<%@ include file="../Menu/menu.jsp" %>
	<form action="create" method="post">
		Username
		<input name="username" type="text"/>
		
		Email
		<input name="email" type="text"/>
		
		Password
		<input name="password" type="text"/>
		
		FirstName
		<input name="firstname" type="text"/>
		
		LastName
		<input name="lastname" type="text"/>
		
		Birthdate
		<input name="birthdate" type="text" data-role="date"/>
		
		Groupe
		<select name="groupe">
			<option selected value="0">Groupe</option>
			<c:forEach var="groupe" items="${groupes}">
				<option value="${groupe.id}">${groupe.libelle}</option>
			</c:forEach>
		</select>
		
		<input type="submit" value="Create User"/>
		
	</form>

</body>
</html>