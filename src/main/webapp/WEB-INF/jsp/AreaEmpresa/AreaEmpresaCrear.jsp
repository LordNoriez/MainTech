<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
	
<!-- 	<link rel="stylesheet" type="text/css" href="css/style.css"> -->
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/Js/scripts.js" />"></script>
</head>
	<body>
	<h1>Crear Area Empresa</h1>
	<spring:url value="/addAreaEmpresa" var="variableAdd" />

	<form:form method="post" modelAttribute="crearModelAreaEmpresa" action="${variableAdd}">
		<br><h2>Nombre �rea Empresa: </h2>
		<form:input path="NombreAreaEmpresa" type="text" /> <!-- bind to user.name-->
		<form:errors path="NombreAreaEmpresa" />
		
		<br>
		<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar
                             </button>
	</form:form>
	        <!-- The actual snackbar -->
        <div id="snackbar">Se Ingres� Correctamente</div>
	</body>
</html>