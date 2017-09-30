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

	<h1>Actualizar Objeto</h1>
	<br />
	<spring:url value="/updateObjeto/${objeto.idObjeto}" var="variableAdd" />

	<form:form method="PUT" modelAttribute="objeto" action="${variableAdd}">
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">
		${objeto.idObjeto}
		</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Marca Objeto</label>
		<div class="col-sm-10">
<%-- 		<input type="text" value = "${user.nombreMantenimiento}"> --%>
		<form:input type="text" path="MarcaObjeto" value = "${objeto.marcaObjeto}"/>
		</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Modelo Objeto</label>
		<div class="col-sm-10">
<%-- 		<input type="text" value = "${user.nombreMantenimiento}"> --%>
		<form:input type="text" path="DescripcionObjeto" value = "${objeto.modeloObjeto}"/>
		</div>
	</div>
	
	<div class="row">
		<label class="col-sm-2">Serial Objeto</label>
		<div class="col-sm-10">
<%-- 		<input type="text" value = "${user.nombreMantenimiento}"> --%>
		<form:input type="text" path="SerialObjeto" value = "${objeto.serialObjeto}"/>
		</div>
	</div>

<fmt:formatDate value="${objeto.fechaCreacionObjeto}" var="dateString" pattern="yyyy-MM-dd" />
	<div class="row">
		<label class="col-sm-2">FechaCreacionObjeto</label>
		<div class="col-sm-10">
<%-- 		<input type="date" value = '${dateString}'> --%>
		<form:input type="date" path="FechaCreacionObjeto" value = '${dateString}'/>
		</div>
	</div>
	
<fmt:formatDate value="${objeto.fechaObtencionObjeto}" var="date2String" pattern="yyyy-MM-dd" />
	<div class="row">
		<label class="col-sm-2">FechaObtencionObjeto</label>
		<div class="col-sm-10">
<%-- 		<input type="date" value = '${dateString}'> --%>
		<form:input type="date" path="FechaObtencionObjeto" value = '${date2String}'/>
		</div>
	</div>

	<div class="row">
		<label class="col-sm-2">descripcion</label>
		<div class="col-sm-10">
		<form:input type="text" path="DescripcionObjeto" value = "${objeto.descripcionObjeto}"/>
		</div>
	</div>
	
	
	<br><h2>Objeto Padre: </h2>
	<form:select path="objetoPadre" onchange="document.getElementById('objtPadre').value = this.value;">
		<form:option value="" label="--- Select ---" itemValue=""/>
		<form:options items="${objects}" itemLabel="MarcaObjeto" itemValue="idObjeto" />
	</form:select>
			
	<br><h2>Categoria: </h2>
	<form:select path="categoria">
		<form:option value="" label="--- Select ---" />
		<form:options items="${categories}" itemLabel="NombreCategoria" itemValue="idCategoria" />
	</form:select>
	
	<div class="row">
		<button type="submit" class="btn-lg btn-primary pull-right">ACTUALIZAR
        </button>
	</div>
	
	</form:form>

<%-- <jsp:include page="../fragments/footer.jsp" /> --%>

</body>
</html>