<head>
    <title>Editar Actividad</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Editar Actividad</h4>
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
				
				<form:form method="post" modelAttribute="crearProveedorActividadProveedor" action="/addActividadProveedor">
					
					<label>Actividad: </label>					        
					<form:select class="form-control" path="actividad">
						<form:option value="${actividad.idActividad}" label="${actividad.nombreActividad}" />				
					</form:select>
					<br>
					
<!-- 					<label>Nombre: </label> -->
<%-- 					<input type="text" class="form-control" readonly value = "${actividad.nombreActividad}"/>					 --%>
<!-- 					<br> -->
	
					<label>Descripción: </label>
					<input type="text" class="form-control" readonly value = "${actividad.descripcionActividad}"/>					
					<br>						
					
					<label>Costo ($): </label>				        
					<form:select class="form-control" path="costo">
						<form:option value="${costo.idCosto}" label="${costo.costo}" />						
					</form:select>				
					<br>	
									
					<fmt:formatDate value="${costo.fechaInicioCosto}" var="dateString" pattern="yyyy-MM-dd" />
					<label>Fecha de Inicio: </label>
					<input class="form-control" type="date" readonly value = "${dateString}" /> <!-- bind to user.name-->
					<br>
					
					<label>Proveedor: </label>						        
					<form:select class="form-control" path="proveedor">
						<form:options items="${proveedores}" itemLabel="NombreProveedor" itemValue="idProveedor" />
					</form:select>
					<br>
					
					<br>
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Agregar Proveedor</button>
				</form:form>
	        </div>
		</div>
		
	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Se Ingresó Correctamente</div>	
        
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>