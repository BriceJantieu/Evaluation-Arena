<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/EvaluationArena/Ressource/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<title>List of promos</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
 <script src="/EvaluationArena/Ressource/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../Menu/menu.jsp" %>
	<div class="container">
 	<H1>Students</H1>	
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
	<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  	Create
	</button>


	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  		<div class="modal-dialog">
    		<div class="modal-content">
      			<div class="modal-header">
        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title" id="myModalLabel">Create promos</h4>
      			</div>
      			<form action="promos.html" method="post">
      				<div class="modal-body">
    						<label>Libellé de la promo :</label>
							<input  class="form-control" name="label" type="text"/>
						
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