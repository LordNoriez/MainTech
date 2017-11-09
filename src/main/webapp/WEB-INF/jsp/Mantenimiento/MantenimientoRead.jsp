<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<%-- <jsp:include page="../fragments/header.jsp" /> --%>
<head>
	<link href="<c:url value="css/style.css" />" rel="stylesheet">
	<script src="<c:url value="js/scripts.js" />"></script>
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

		<h1>Ver Mantenimientos</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Fecha</th>
					<th>Es Programado ?</th>
					<th>Frecuencia</th>
					<th>Objeto</th>
				</tr>
			</thead>

			<c:forEach var="mantenimiento" items="${mantenimientos}">
			    <tr>
				<td>${mantenimiento.idMantenimiento}</td>
				<td>${mantenimiento.nombreMantenimiento}</td>
				<td>${mantenimiento.fechaMantenimiento}</td>
				<td>${mantenimiento.isProgramadoMantenimiento}</td>
				<td>${mantenimiento.frecuenciaMantenimiento}</td>
				<td>${mantenimiento.objetoMantenimiento.getDescripcionObjeto()}</td>

				<td>
				  <spring:url value="/deleteMantenimiento/${mantenimiento.idMantenimiento}" var="deleteUrl" />
				  <spring:url value="/mantenimiento/${mantenimiento.idMantenimiento}" var="updateUrl" />

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