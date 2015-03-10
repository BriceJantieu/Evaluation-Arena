<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../Menu/menu.jsp" %>
	<form action="promos.html" method="get">
		<select name="promo"
			onchange="submit()">
			<option id="0" value="0">Promos</option>
			<c:forEach var="promo" items="${promos}">
				<c:if test="${promo.id == selectedPromoId}">
					<option selected="selected" value="${promo.id}">${promo.libelle}</option>
				</c:if>
				
				<c:if test="${promo.id != selectedPromoId}">
					<option value="${promo.id}">${promo.libelle}</option>
				</c:if>
			</c:forEach>
		</select>
	</form>
	
	Elèves
	<table class="table table-strip">
		<tr>
			<td><strong>Prénom</strong></td>
			<td><strong>Nom</strong></td>
			<td><strong>Email</strong></td>
			<td><strong>Promo</strong>
		</tr>
		
		<c:forEach var="user" items="${users}" >
			<tr>
				<td> ${user.firstName} </td>
				<td> ${user.lastName} </td>
				<td> ${user.email} </td>
				<td> ${user.promo.libelle} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>