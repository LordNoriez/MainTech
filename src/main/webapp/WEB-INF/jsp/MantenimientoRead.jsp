<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<%-- <jsp:include page="../fragments/header.jsp" /> --%>

<body>

	<div class="container">

<%-- 		<c:if test="${not empty msg}"> --%>
<%-- 		    <div class="alert alert-${css} alert-dismissible" role="alert"> --%>
<!-- 			<button type="button" class="close" data-dismiss="alert" -->
<!--                                 aria-label="Close"> -->
<!-- 				<span aria-hidden="true">×</span> -->
<!-- 			</button> -->
<%-- 			<strong>${msg}</strong> --%>
<!-- 		    </div> -->
<%-- 		</c:if> --%>

		<h1>All Users</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Nombre</th>
					<th>Fecha</th>
				</tr>
			</thead>

			<c:forEach var="mantenimiento" items="${mantenimientos}">
			    <tr>
				<td>
					${mantenimiento.idMantenimiento}
				</td>
				<td>${mantenimiento.nombreMantenimiento}</td>
				<td>${mantenimiento.fechaMantenimiento}</td>

				<td>
				  <spring:url value="/users/${mantenimiento.idMantenimiento}" var="userUrl" />
				  <spring:url value="/mantenimientodelete/${mantenimiento.idMantenimiento}" var="deleteUrl" />
				  <spring:url value="/mantenimiento/${mantenimiento.idMantenimiento}" var="updateUrl" />

				  <button class="btn btn-info"
                                          onclick="location.href='${userUrl}'">Query</button>

				  <button class="btn btn-primary"
                                          onclick="location.href='${updateUrl}'">Update</button>
                                                                             
				  <button class="btn btn-danger"
<%--                                           onclick="this.disabled=true;post('${deleteUrl}')">Delete</button> --%>
                                          onclick="location.href='${deleteUrl}'">Delete</button>
                                </td>
			    </tr>
			</c:forEach>
		</table>

	</div>

<%-- 	<jsp:include page="../fragments/footer.jsp" /> --%>

</body>
</html>