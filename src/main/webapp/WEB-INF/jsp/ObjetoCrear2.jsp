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
	<h1>Crear Objeto</h1>
	<spring:url value="/objeto" var="variableAdd" />

	<form:form method="post" modelAttribute="crearModelObjeto" action="${variableAdd}">
		<form:input path="MarcaObjeto" type="text" /> 
		<form:errors path="MarcaObjeto" />
		
		<form:input path="ModeloObjeto" type="text" /> 
		<form:errors path="ModeloObjeto" />

		<form:input path="SerialObjeto" type="text" /> 
		<form:errors path="SerialObjeto" />
		
		<form:select path="categoria">
			<form:option value="NONE" label="--- Select ---" />
			<form:options items="${categories}" />
		</form:select>

		<form:input path="FechaCreacionObjeto" type="date" /> 
		<form:errors path="FechaCreacionObjeto" />

		<form:input path="FechaObtencionObjeto" type="date" /> 
		<form:errors path="FechaObtencionObjeto" />

		<form:input path="LongitudObjeto" type="text" /> 
		<form:errors path="LongitudObjeto" />

		<form:input path="AnchoObjeto" type="text" /> 
		<form:errors path="AnchoObjeto" />

		<form:input path="AreaObjeto" type="text" /> 
		<form:errors path="AreaObjeto" />

		<form:input path="AlturaObjeto" type="text" /> 
		<form:errors path="AlturaObjeto" />

		<form:input path="VidaObjeto" type="text" /> 
		<form:errors path="VidaObjeto" />	
		
		<form:input path="DescripcionObjeto" type="text" />
		<form:errors path="DescripcionObjeto" />

		<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar
                             </button>
	</form:form>
	        <!-- The actual snackbar -->
        <div id="snackbar">Se Ingreso Correctamente</div>
	</body>
</html>