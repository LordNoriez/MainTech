<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
 	<title>Crear Objeto</title>

	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/Js/scripts.js" />"></script>
</head>
<body>
	
	
	<div>
<spring:url value="/objeto" var="varAdd" />

  		<form:form method="post" modelAttribute="crearModelObjeto" action="${varAdd}">
  	          <table>
                <tr>
                    <td>Serial:</td>
                    <form:input path="serialObjeto" type="text" /> <!-- bind to user.name-->
                </tr>
                <tr>
                    <td>Marca:</td>                    
                    <form:input path="marcaObjeto" type="text" /> <!-- bind to user.name-->
                </tr>
                <tr>
                    <td>Modelo:</td>            
                    <form:input path="modeloObjeto" type="text" /> <!-- bind to user.name-->
                </tr>
                <tr>
                    <td>Descripcion:</td> 
                    <form:input path="descripcionObjeto" type="text" /> <!-- bind to user.name-->
                </tr>
                <tr>
                    <td>Longitud:</td>
                    <form:input path="longitudObjeto" type="text" /> <!-- bind to user.name-->
                </tr>
                <tr>
                    <td>Ancho:</td>
                    <form:input path="anchoObjeto" type="text" /> <!-- bind to user.name-->
                </tr>
                <tr>
                    <td>Altura:</td>
                    <form:input path="alturaObjeto" type="text" /> <!-- bind to user.name-->
                </tr>
                <tr>
                    <td>Área:</td>
                    <form:input path="areaObjeto" type="text" /> <!-- bind to user.name-->
                </tr>
                <tr>
                    <td>Vida Útil:</td>   
                    <form:input path="vidaObjeto" type="text" /> <!-- bind to user.name-->
                </tr>
                <tr>
                    <td>Fecha Obtención:</td>
                    <form:input path="fechaObtencionObjeto" type="date" /> <!-- bind to user.name-->
                </tr>
                <tr>    
                    <td>Categoría:</td>
                	<td>            	
	                	<select name="categoria" id="categoria">
	                		<c:forEach var="categoria" items="${categories}">
						 		<option value ="${categoria.getIdCategoria()}">${categoria.getNombreCategoria()}</option>
						 	</c:forEach>
						</select>
					</td> 
                </tr>
                <tr>
                    		<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar
                             </button>
                </tr>
            </table>
        </form:form>
	</div>
</body>
</html>