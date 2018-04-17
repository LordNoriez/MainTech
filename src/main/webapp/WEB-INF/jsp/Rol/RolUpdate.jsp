<head>
    <title>Editar Rol</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Editar Rol</h4>
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
				<spring:url value="/updateRol/${rol.idRol}" var="variableAdd" />
			
				<form:form method="PUT" modelAttribute="rol" action="${variableAdd}">
			
					<label>Nombre:</label>
					<form:input type="text" class="form-control" path="NombreRol" value = "${rol.nombreRol}"/>
					<br>
				
					<button type="submit" class="btn-lg btn-primary pull-right">Actualizar</button>
				
				</form:form>
			</div>
		</div>
	
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>