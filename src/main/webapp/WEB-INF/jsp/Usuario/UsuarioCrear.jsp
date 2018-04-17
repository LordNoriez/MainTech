<head>
    <title>Crear Usuario</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Crear Usuario</h4>
		        </div>
		    </div>
		</div>
					
     <div id="mySidenav" class="sidenav">
		  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		  <a class="active" id="home" href="/google/login">Inicio</a>
	<!-- 	  <a href="/crearObjeto">Crear Objeto</a> -->
	<!-- 	  <a href="/objeto">Ver Objetos</a> -->
<!-- 			<p>Mantenimientos -->
<!-- 		  <a href="/crearMantenimiento">Crear</a> -->
<!-- 		  <a href="/mantenimiento">Ver</a> -->
<!-- 			<p>Tipos de Mantenimientos -->
<!-- 		  <a href="/crearTipoMantenimiento">Crear</a> -->
<!-- 		  <a href="/tipoMantenimiento">Ver</a> -->
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
<!-- 			<p>Actividades -->
<!-- 		  <a href="/crearActividad">Crear</a> -->
<!-- 		  <a href="/actividad">Ver</a> -->
	<!-- 	  <a href="/crearCategoria">Crear Categoría</a> -->
	<!-- 	  <a href="/categoria">Ver Categorías</a> -->
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
			
			<div class=" col-md-8"  >
				<spring:url value="/addUsuario" var="variableAdd" />
			
				<form:form method="post" modelAttribute="crearModelUsuario" action="${variableAdd}">
					<label>Nombre: </label>
					<form:input path="nombreUsuario" class="form-control" type="text" /> 
					<form:errors path="nombreUsuario" />
					<br>
					
					<label>Correo: </label>
					<form:input path="correoUsuario" class="form-control" type="email" /> 
					<form:errors path="correoUsuario" />
					<br>
					
					<label>Rol: </label>						        
					<form:select class="form-control" path="rol">
						<form:options items="${roles}" itemLabel="NombreRol" itemValue="idRol" />
					</form:select>
					<br>
					
					<label>Área de Empresa: </label>						        
					<form:select class="form-control" path="areaEmpresa">
						<form:options items="${areaEmpresas}" itemLabel="NombreAreaEmpresa" itemValue="idAreaEmpresa" />
					</form:select>
					<br>
					
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar</button>
				</form:form>
	        </div>
		</div>
	
		
	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Se Ingresó Correctamente</div>	
        
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>