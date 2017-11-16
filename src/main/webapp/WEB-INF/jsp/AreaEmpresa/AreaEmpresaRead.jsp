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

		<h1>Ver Categorķas</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
				</tr>
			</thead>

			<c:forEach var="areaEmpresas" items="${areaEmpresa}">
			    <tr>
				<td>
					${areaEmpresas.idAreaEmpresa}
				</td>
				<td>${areaEmpresas.nombreAreaEmpresa}</td>

				<td>
				  <spring:url value="/deleteAreaEmpresa/${areaEmpresas.idAreaEmpresa}" var="deleteUrl" />
				  <spring:url value="/areaEmpresa/${areaEmpresas.idAreaEmpresa}" var="updateUrl" />

				  <button class="btn btn-primary"
                                          onclick="location.href='${updateUrl}'">Update</button>
                                                                             
				  <button onclick="location.href='${deleteUrl}'; setTimeout(snackBarFunction(),5000);" class="btn btn-danger">Delete</button>
<%--                                           onclick="this.disabled=true;post('${deleteUrl}')">Delete</button> --%>
                                          
                                </td>
			    </tr>
			</c:forEach>
		</table>

	</div>
	
	<div id="snackbar">Categorķa Eliminada Correctamente</div>

<%-- 	<jsp:include page="../fragments/footer.jsp" /> --%>

</body>
</html>