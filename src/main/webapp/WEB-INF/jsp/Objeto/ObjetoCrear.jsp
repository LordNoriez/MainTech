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


 	<form:form method="POST" modelAttribute="crearModelObjeto" action="${variableAdd}" id="myForm"> 
		<br><h2>Marca: </h2>
		<form:input path="MarcaObjeto" type="text" /> 
		<form:errors path="MarcaObjeto" />
		
		<br><h2>Modelo: </h2>
		<form:input path="ModeloObjeto" type="text" /> 
		<form:errors path="ModeloObjeto" />
		
		<br><h2>Serial: </h2>
		<form:input path="SerialObjeto" type="text" /> 
		<form:errors path="SerialObjeto" />
		
		<br><h2>Categoria: </h2>
		<form:select path="categoria">
			<form:option value="" label="--- Select ---" />
			<form:options items="${categories}" itemLabel="NombreCategoria" itemValue="idCategoria" />
		</form:select>
		
		<br><h2>Objeto Padre: </h2>
		<form:select path="objetoPadre" onchange="document.getElementById('objtPadre').value = this.value;">
			<form:option value="" label="--- Select ---" itemValue=""/>
			<form:options items="${objects}" itemLabel="MarcaObjeto" itemValue="idObjeto" />
		</form:select>

		
<!-- 		<select id="objPadreInput" name="titleId" onchange="document.getElementById('objtPadre').value = this.value;"> -->
<!-- 		    <option value="NULL" label="--- Select ---" /> -->
<%-- 		    <c:forEach items="${objects}" var="objs"> --%>
<%-- 		            <option value="${objs.idObjeto}" selected>${objs.marcaObjeto}</option> --%>
<%-- 		    </c:forEach> --%>
<!-- 		</select> -->
		
<!--  used for take the id and then assign it to the Objeto -->
		<form:input type="hidden" path="objetoPadre" id = "objtPadre" /> 
		
		
		<br><h2>Fecha Creacion: </h2>
		<form:input path="FechaCreacionObjeto" type="date" /> 
		<form:errors path="FechaCreacionObjeto" />
		
		<br><h2>Fecha Obtencion: </h2>
		<form:input path="FechaObtencionObjeto" type="date" /> 
		<form:errors path="FechaObtencionObjeto" />
		
		<br><h2>Longitud: </h2>
		<form:input path="LongitudObjeto" type="text" /> 
		<form:errors path="LongitudObjeto" />
		
		<br><h2>Ancho: </h2>
		<form:input path="AnchoObjeto" type="text" /> 
		<form:errors path="AnchoObjeto" />
		
		<br><h2>Area: </h2>
		<form:input path="AreaObjeto" type="text" /> 
		<form:errors path="AreaObjeto" />

		<br><h2>Altura: </h2>
		<form:input path="AlturaObjeto" type="text" /> 
		<form:errors path="AlturaObjeto" />
		
		<br><h2>Vida: </h2>
		<form:input path="VidaObjeto" type="text" /> 
		<form:errors path="VidaObjeto" />	
		
		<br><h2>Descripcion: </h2>
		<form:input path="DescripcionObjeto" type="text" />
		<form:errors path="DescripcionObjeto" />

		<br>
		<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar
                             </button>
	</form:form>
	        <!-- The actual snackbar -->
        <div id="snackbar">Se Ingreso Correctamente</div>	
	</body>
</html>