<head>
    <title>Crear Proveedor</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Crear Proveedor</h4>
		        </div>
		    </div>
		</div>
					
     <div id="mySidenav" class="sidenav">
		  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		  <a class="active" id="home" href="/google/login">Inicio</a>
	<!-- 	  <a href="/crearObjeto">Crear Objeto</a> -->
	<!-- 	  <a href="/objeto">Ver Objetos</a> -->
			<p>Mantenimientos
		  <a href="/crearMantenimiento">Crear</a>
		  <a href="/mantenimiento">Ver</a>
			<p>Tipos de Mantenimientos
		  <a href="/crearTipoMantenimiento">Crear</a>
		  <a href="/tipoMantenimiento">Ver</a>
	<!-- 	  <a href="/crearAreaEmpresa">Crear Area Empresa</a> -->
	<!-- 	  <a href="/areaEmpresa">Ver Area Empresa</a> -->
			<p>Actividades
		  <a href="/crearActividad">Crear</a>
		  <a href="/actividad">Ver</a>
		  	<p>Proveedores
		  <a href="/crearProveedor">Crear</a>
		  <a href="/proveedor">Ver</a>
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
				<spring:url value="/proveedor" var="variableAdd" />
			
			 	<form:form method="POST" modelAttribute="crearModelProveedor" action="${variableAdd}" id="myForm"> 
					
					<label>Nombre Proveedor: </label>		
					<form:input path="NombreProveedor" class="form-control"  type="text" />
					<form:errors path="NombreProveedor" />
					<br>
					
					<label>Teléfono: </label>
					<form:input path="TelefonoProveedor" class="form-control"  type="tel" />
					<form:errors path="TelefonoProveedor" />
					<br>
										
					<label>Dirección: </label>
					<form:input path="DireccionProveedor" class="form-control" type="text" /> 
					<form:errors path="DireccionProveedor" />
					<br>
					
					<label>E-mail: </label>
					<form:input path="EmailProveedor"  class="form-control" type="email" /> 
					<form:errors path="EmailProveedor" />
					<br>
					
					<label>Fecha de Ingreso: </label>
					<form:input path="FechaIngresoProveedor"  id="theDate" class="form-control" type="date" /> 
					<form:errors path="FechaIngresoProveedor" />
					<br>
					
					<label>Tipo Proveedor: </label>						        
					<form:select class="form-control" path="objTipoMantenimiento">
						<form:options items="${tipos}" itemLabel="NombreTipoMantenimiento" itemValue="idTipoMantenimiento" />
					</form:select>
					<br>
					
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar
			                             </button>
				</form:form>
			</div>
		</div>
	
		
	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Se Ingresó Correctamente</div>	
        
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>