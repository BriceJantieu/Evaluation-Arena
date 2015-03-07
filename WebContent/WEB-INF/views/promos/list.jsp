<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>List of promos</title>
</head>
 <script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../Menu/menu.jsp" %>
	<div class="container">
 	<H1>Elèves</H1>	
	<form style="margin-bottom : 20px;" class="form-inline pull-right" action="promos.html" method="get">
		<div class="form-group">
    		<label>Select promo : </label>
    		<select class="form-control" name="promo"
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
 		 </div>
		
	</form>
	
	
	<table  class="table table-striped table-bordered">
        	<tr>
            	<th>Prénom</th>
            	<th>Nom</th>
            	<th>Email</th>
            	<th>Promo</th>
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
	</div>
	
</body>
</html>