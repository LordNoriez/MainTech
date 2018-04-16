<head>
    <title>Editar Equipo de Protección</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Editar Equipo de Protección</h4>
		        </div>
		    </div>
		</div>
						
     <div id="mySidenav" class="sidenav">
		  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		  <a class="active" id="home" href="/google/login">Inicio</a>
<!-- 		  <p>Objetos -->
<!-- 		  <a href="/crearObjeto">Crear</a> -->
<!-- 		  <a href="/objeto">Ver</a> -->
		  <!--  <a href="/crearMantenimiento">Crear Mantenimiento</a>
		  <a href="/mantenimiento">Ver Mantenimientos</a>
		  <a href="/crearTipoMantenimiento">Crear Tipo Mantenimiento</a>
		  <a href="/tipoMantenimiento">Ver Tipo Mantenimientos</a>-->
			<p>Usuarios
		  <a href="/crearUsuario">Crear</a>
		  <a href="/usuario">Ver</a>
			<p>Áreas de la Empresa
		  <a href="/crearAreaEmpresa">Crear</a>
		  <a href="/areaEmpresa">Ver</a>
			<p>Roles
		  <a href="/crearRol">Crear</a>
		  <a href="/rol">Ver</a>
			<p>Reportes
		  <a href="/reporte">Ver</a>
		  <a href="/reporteRol">Vículo con Roles</a>
		  <a href="/crearReporteRol">Vícular con Roles</a>
<!-- 		  <a href="/crearActividad">Crear Actividad</a> -->
<!-- 		  <a href="/actividad">Ver Actividad</a> -->
<!-- 		  <p>Categorías -->
<!-- 		  <a href="/crearCategoria">Crear</a> -->
<!-- 		  <a href="/categoria">Ver</a> -->
	</div>
	<div class="container-fluid" id="main">
    
    <!--<div class="container" style="margin-top: 50px;">-->
		<div class="row">
			<div class=" col-md-3">
				<div class="jumbotron">						
					<img class="p-img" alt="" src="{{user.userAuthentication.details.picture}}">
					<h5>{{user.userAuthentication.details.name}}</h5>
					<h6>{{user.userAuthentication.details.email}}</h6>		
					<a href="/logout">Salir</a>		        
			    </div>	
			    
			    					
				<button type="button" onclick="openNav()" class="btn btn-info btn-block">Menú</button>				
					
			</div>					
			
			<div class=" col-md-8" >

			
<%-- 				<form:form method="PUT" modelAttribute="Epps" action="${variableAdd}"> --%>
				<form action="/mantenimientoEppupdated/${varMantenmiento.idMantenimiento}" method="post">
					<h4 class="text-muted">Epps: </h4>
					
					<table class="table table-striped table-hover">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>:3</th>
							</tr>
						</thead>
	    				<tbody id="myTable">
						
						<c:forEach var="AllEppsObj" items="${AllEpps}">
							<c:set var="auxchecked" value="0"/>
						    <tr>
								<td>${AllEppsObj.nombreEpp}</td>
								
								<c:forEach var="ItemEpps" items="${ItemEpp}">									
								    <c:if test="${ItemEpps[0]==AllEppsObj.idEpp}">
								        <td><input type="checkbox" checked name="foo" value="${ItemEpps[0].toString()}" ></td>
								        <c:set var="auxchecked" value= "1"/>
								    </c:if>
							  	</c:forEach>
							  	<c:if test="${auxchecked == 0}">
								        <td><input type="checkbox" name="foo" value="${AllEppsObj.idEpp}" ></td>
							    </c:if>
							</tr>
						</c:forEach>
	    				</tbody>
					</table>
					<a class="btn-lg btn-primary pull-left" href="/mantenimientobyId/${varMantenmiento.idMantenimiento}">Cancelar</a>
					<button type="submit" class="btn-lg btn-primary pull-right">Aceptar</button>
				
				</form>
			</div>
		</div>
	
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>