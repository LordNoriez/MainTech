<head>
    <title>Salida de Equipos</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Salida de Equipos</h4>
		        </div>
		    </div>
		</div>
					
     <div id="mySidenav" class="sidenav">
		  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		  <a class="active" id="home" href="/google/login">Inicio</a>
		  <p>Equipos
		  <a href="/crearObjeto">Crear</a>
		  <a href="/objeto">Ver</a>
		  <!--  <a href="/crearMantenimiento">Crear Mantenimiento</a>
		  <a href="/mantenimiento">Ver Mantenimientos</a>
		  <a href="/crearTipoMantenimiento">Crear Tipo Mantenimiento</a>
		  <a href="/tipoMantenimiento">Ver Tipo Mantenimientos</a>
		  <a href="/crearAreaEmpresa">Crear Area Empresa</a>
		  <a href="/areaEmpresa">Ver Area Empresa</a>
		  <a href="/crearActividad">Crear Actividad</a>
		  <a href="/actividad">Ver Actividad</a>-->
		  <p>Movimientos de Equipos
		  <a href="/crearMovimientoIngreso">Ingreso de Equipos</a>
		  <a href="/crearMovimientoSalida">Salida de Equipos</a>
		  <a href="/movimiento">Ver</a>
		  <p>Categorías
		  <a href="/crearCategoria">Crear</a>
		  <a href="/categoria">Ver</a>
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
				<spring:url value="/addMovimientoSalida" var="variableAdd" />
			
				<form:form name="FormSalidaMovimiento" method="POST" modelAttribute="crearModelMovimiento" action="${variableAdd}">	
				
					<label>Descripción: </label>
					<form:input path="DescripcionMovimiento" class="form-control" type="text" /> <!-- bind to user.name-->
					<form:errors path="DescripcionMovimiento" />
					<br>
					
					<label>Equipo: </label>						        
					<form:select id="ddlObjeto" name="ddlObjeto" class="form-control" path="objeto" >
						<form:option value="" label="--- Seleccionar ---" />
						<c:forEach var="obj" items="${objetos}">
							<form:option label="${obj[8].toString()}" value="${obj[2]}" />
						</c:forEach>
					</form:select>
					<br>
					
					<label>Límite Máx: </label>
					<input type="number" id="lmitmax" class="form-control" readonly/>
					<br>
					
					<label>Cantidad: </label>					
					<form:input type="number" path="CantidadMovimiento" class="form-control" step ="any" onkeyup="this.value = minmax(this.value, 0, 100)"/>					
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