<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<%-- <jsp:include page="../fragments/header.jsp" /> --%>

<!-- <div class="container"> -->

<%-- 	<c:if test="${not empty msg}"> --%>
<%-- 		<div class="alert alert-${css} alert-dismissible" role="alert"> --%>
<!-- 			<button type="button" class="close" data-dismiss="alert" -->
<!--                                 aria-label="Close"> -->
<!-- 				<span aria-hidden="true">×</span> -->
<!-- 			</button> -->
<%-- 			<strong>${msg}</strong> --%>
<!-- 		</div> -->
<%-- 	</c:if> --%>

	<h1>Actualizar Mantenimiento</h1>
	<br />
	<spring:url value="/updateMantenimiento/${varMantenmiento.idMantenimiento}" var="variableAdd" />

	<form:form method="PUT" modelAttribute="varMantenmiento" action="${variableAdd}">
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">
		${varMantenmiento.idMantenimiento}
		</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">
<%-- 		<input type="text" value = "${varMantenmiento.nombreMantenimiento}"> --%>
		<form:input type="text" path="NombreMantenimiento" value = "${varMantenmiento.nombreMantenimiento}"/>
		</div>
	</div>

<fmt:formatDate value="${varMantenmiento.fechaMantenimiento}" var="dateString" pattern="yyyy-MM-dd" />
	<div class="row">
		<label class="col-sm-2">fecha</label>
		<div class="col-sm-10">
<%-- 		<input type="date" value = '${dateString}'> --%>
		<form:input type="date" path="FechaMantenimiento" value = '${dateString}'/>
		</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">descripcion</label>
		<div class="col-sm-10">
		<form:input type="text" path="DescripcionMantenimiento" value = "${varMantenmiento.descripcionMantenimiento}"/>
		</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Frecuencia Mantenimiento</label>
		<div class="col-sm-10">
		<form:input type="text" path="FrecuenciaMantenimiento" value = "${varMantenmiento.frecuenciaMantenimiento}"/>
		</div>
	</div>

	<div class="row">
		<label class="col-sm-2">descripcion</label>
		<div class="col-sm-10">
		<form:checkbox path="isProgramadoMantenimiento" value = "${varMantenmiento.isProgramadoMantenimiento}"/>
		</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">objeto Mantenimiento</label>
		<div class="col-sm-10">
			<form:select path="objetoMantenimiento">
			    <c:forEach var="Itemobjetos" items="${Itemobjeto}">
			        <option value="${Itemobjetos.idObjeto}" ${Itemobjetos.idObjeto == varMantenmiento.objetoMantenimiento.idObjeto ? 'selected="selected"' : ''}>${Itemobjetos.marcaObjeto}</option>
			    </c:forEach>
			</form:select>
		</div>
	</div>
	
	<div class="row">
		<button type="submit" class="btn-lg btn-primary pull-right">ACTUALIZAR
        </button>
	</div>
	
	</form:form>

<%-- <jsp:include page="../fragments/footer.jsp" /> --%>

</body>
</html>