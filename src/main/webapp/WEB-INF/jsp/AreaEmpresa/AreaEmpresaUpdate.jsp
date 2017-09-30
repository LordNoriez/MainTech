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

	<h1>Area Empresa</h1>
	<br />
	<spring:url value="/AreaEmpresaupdate/${ModelAreaEmpresa.idAreaEmpresa}" var="variableAdd" />

	<form:form method="PUT" modelAttribute="ModelAreaEmpresa" action="${variableAdd}">
	<div class="row">
		<label class="col-sm-2">ID</label>
		<div class="col-sm-10">
		${ModelAreaEmpresa.idAreaEmpresa}
		</div>
	</div>

	<div class="row">
		<label class="col-sm-2">Name</label>
		<div class="col-sm-10">
<%-- 		<input type="text" value = "${user.nombreMantenimiento}"> --%>
		<form:input type="text" path="NombreAreaEmpresa" value = "${ModelAreaEmpresa.nombreAreaEmpresa}"/>
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