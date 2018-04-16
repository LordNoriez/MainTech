<head>
    <title>Crear Mantenimiento</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Crear Mantenimiento</h4>
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
				<spring:url value="/addMantenimiento" var="variableAdd" />
			
				<form:form method="post" modelAttribute="crearModelMantenimiento" action="${variableAdd}">
					
					<label>Nombre: </label>
					<form:input path="NombreMantenimiento" class="form-control" type="text" /> <!-- bind to user.name-->
					<form:errors path="NombreMantenimiento" />
					<br>
					
					<label>Fecha: </label>
					<form:input path="FechaMantenimiento" class="form-control" type="date" /> 
					<form:errors path="FechaMantenimiento" />
					<br>
					
					<label>Descripción: </label>
					<form:input path="DescripcionMantenimiento" class="form-control" type="text" /> <!-- bind to user.name-->
					<form:errors path="DescripcionMantenimiento" />
					<br>
					
					<label>Tipo de Mantenimiento: </label>						        
					<form:select class="form-control" path="objTipoMantenimiento">
						<form:options items="${tipos}" itemLabel="NombreTipoMantenimiento" itemValue="idTipoMantenimiento" />
					</form:select>
					<br>
					
					<label class="col-md-2">Programado?</label>
					<div class="col-md-2 ">
						<form:checkbox path="isProgramadoMantenimiento" class="form-control" value="true"/>
						<form:errors path="isProgramadoMantenimiento" />	
					</div>
					<br>
					<br>
					<br>
					
					<label>Frecuencia de Mantenimiento (horas): </label>
					<form:input path="FrecuenciaMantenimiento" class="form-control" type="number" value="0"/>
					<form:errors path="FrecuenciaMantenimiento" />
					<br>
					
<!-- 					<label>Objeto: </label> -->
<%-- 					<form:select class="form-control" path="objetoMantenimiento"> --%>
<%-- 						<form:option value="" label="--- Select ---" /> --%>
<%-- 						<form:options items="${Itemobjeto}" itemLabel="DescripcionObjeto" itemValue="idObjeto" /> --%>
<%-- 					</form:select>				 --%>
						
<!-- 					<br> -->
					
<%-- 					<form:select multiple="true" path="actividad" items="${ItemActividad}" itemLabel="nombreActividad" itemValue="idActividad" /> --%>
					
					<br>
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Siguiente</button>
			                             
				</form:form>
	        </div>
		</div>

	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Seleccione Equipo</div>	
        
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>