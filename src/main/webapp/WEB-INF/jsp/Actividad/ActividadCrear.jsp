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
	<h1>Crear Actividad</h1>
	<spring:url value="/addActividad" var="variableAdd" />

	<form:form method="post" modelAttribute="crearModelActividad" action="${variableAdd}">
		<br><h2>Nombre Actividad: </h2>
		<form:input path="NombreActividad" type="text" /> <!-- bind to user.name-->
		<form:errors path="NombreActividad" />
		
		<br><h2>Costo Actividad: </h2>
		<form:input path="CostoActividad" type="text" /> <!-- bind to user.name-->
		<form:errors path="CostoActividad" />
		
		<br><h2>Descripcion Actividad: </h2>
		<form:input path="DescripcionActividad" type="text" /> <!-- bind to user.name-->
		<form:errors path="DescripcionActividad" />
		
		<br>
		<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar
                             </button>
	</form:form>
	        <!-- The actual snackbar -->
        <div id="snackbar">Se Ingresó Correctamente</div>
	</body>
</html>