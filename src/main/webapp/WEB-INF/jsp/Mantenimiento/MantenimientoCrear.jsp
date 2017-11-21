<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
	
<!-- 	<link rel="stylesheet" type="text/css" href="css/style.css"> -->
	<link href="<c:url value="css/style.css" />" rel="stylesheet">
	<script src="<c:url value="js/scripts.js" />"></script>
</head>
	<body>
	<h1>Crear Mantenimiento</h1>
	<spring:url value="/addMantenimiento" var="variableAdd" />

	<form:form method="post" modelAttribute="crearModelMantenimiento" action="${variableAdd}">
		<h2>Nombre: </h2>
		<form:input path="NombreMantenimiento" type="text" /> <!-- bind to user.name-->
		<form:errors path="NombreMantenimiento" />
		
		<br><h2>Fecha: </h2>
		<form:input path="FechaMantenimiento" type="date" /> <!-- bind to user.name-->
		<form:errors path="FechaMantenimiento" />
		
		<br><h2>Descripción: </h2>
		<form:input path="DescripcionMantenimiento" type="text" /> <!-- bind to user.name-->
		<form:errors path="DescripcionMantenimiento" />
		
		<br><h2>Es programado?: </h2>
		<form:checkbox path="isProgramadoMantenimiento" value="true"/>
		<form:errors path="isProgramadoMantenimiento" />

		<br><h2>Frecuencia Mantenimiento: </h2>
		<form:input path="FrecuenciaMantenimiento" type="text" /> <!-- bind to user.name-->
		<form:errors path="FrecuenciaMantenimiento" />
		
		<br><h2>Objeto: </h2>
		<form:select path="objetoMantenimiento">
			<form:option value="" label="--- Select ---" />
			<form:options items="${Itemobjeto}" itemLabel="MarcaObjeto" itemValue="idObjeto" />
		</form:select>
		
		<br>
		
		<form:select multiple="true" path="actividad" items="${ItemActividad}" itemLabel="nombreActividad" itemValue="idActividad" />
		
		<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar
                             </button>
	</form:form>
	        <!-- The actual snackbar -->
        <div id="snackbar">Se Ingreso Correctamente</div>
	</body>
</html>