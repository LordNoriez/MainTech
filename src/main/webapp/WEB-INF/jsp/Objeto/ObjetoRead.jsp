<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<%-- <jsp:include page="../fragments/header.jsp" /> --%>
<head>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/Js/scripts.js" />"></script>
</head>
<body>

	<div class="container">

<%-- 		<c:if test="${not empty msg}"> --%>
<%-- 		    <div class="alert alert-${css} alert-dismissible" role="alert"> --%>
<!-- 			<button type="button" class="close" data-dismiss="alert" -->
<!--                                 aria-label="Close"> -->
<!-- 				<span aria-hidden="true">×</span> -->
<!-- 			</button> -->
<%-- 			<strong>${msg}</strong> --%>
<!-- 		    </div> -->
<%-- 		</c:if> --%>

		<h1>All Users</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>id Objeto</th>
					<th>marcaObjeto</th>
					<th>modeloObjeto</th>
					<th>fechaCreacionObjeto</th>
					<th>fechaObtencionObjeto</th>
					<th>Categoria</th>
					<th>descripcionObjeto</th>
				</tr>
			</thead>

			<c:forEach var="mantenimiento" items="${objetos}">
			    <tr>
				<td>${mantenimiento.idObjeto}</td>
				<td>${mantenimiento.marcaObjeto}</td>
				<td>${mantenimiento.modeloObjeto}</td>
				<td>${mantenimiento.fechaCreacionObjeto}</td>
				<td>${mantenimiento.fechaObtencionObjeto}</td>
				<td>${mantenimiento.categoria}</td>
				<td>${mantenimiento.descripcionObjeto}</td>
				<td>
				  <spring:url value="/objetodelete/${mantenimiento.idObjeto}" var="deleteUrl" />
				  <spring:url value="/objeto/${mantenimiento.idObjeto}" var="updateUrl" />

				  <button class="btn btn-primary"
                                          onclick="location.href='${updateUrl}'">Update</button>
                                                                             
				  <button onclick="location.href='${deleteUrl}'; setTimeout(snackBarFunction(),5000);" class="btn btn-danger">Delete</button>
<%--                                           onclick="this.disabled=true;post('${deleteUrl}')">Delete</button> --%>
                                          
                                </td>
			    </tr>
			</c:forEach>
		</table>

	</div>
	
	<div id="snackbar">Mantenimiento Eliminado Correctamente</div>

<%-- 	<jsp:include page="../fragments/footer.jsp" /> --%>

</body>
</html>