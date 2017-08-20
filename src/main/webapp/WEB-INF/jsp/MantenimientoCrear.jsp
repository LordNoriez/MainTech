<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
	<body>
	<spring:url value="/addMantenimiento" var="variableAdd" />

	<form:form method="post" modelAttribute="crearModelMantenimiento" action="${variableAdd}">
		<form:input path="NombreMantenimiento" type="text" /> <!-- bind to user.name-->
		<form:errors path="NombreMantenimiento" />
		
		<form:input path="FechaMantenimiento" type="text" /> <!-- bind to user.name-->
		<form:errors path="FechaMantenimiento" />
		
		<form:input path="DescripcionMantenimiento" type="text" /> <!-- bind to user.name-->
		<form:errors path="DescripcionMantenimiento" />

		<button type="submit" class="btn-lg btn-primary pull-right">Ingresar
                             </button>
	</form:form>
	
	</body>
</html>