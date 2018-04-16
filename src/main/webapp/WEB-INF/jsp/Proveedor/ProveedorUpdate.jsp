<head>
    <title>Editar Proveedor</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Editar Proveedor</h4>
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
				<spring:url value="/updateProveedor/${proveedor.idProveedor}" var="variableAdd" />
			
				<form:form method="PUT" modelAttribute="proveedor" action="${variableAdd}">
					
					<label>Nombre Proveedor: </label>
					<form:input type="text" class="form-control" path="NombreProveedor" value = "${proveedor.nombreProveedor}"/>
					<br>
					
					<label>Teléfono: </label>
					<form:input type="tel" class="form-control" path="TelefonoProveedor" value = "${proveedor.telefonoProveedor}"/>
					<br>
										
					<label>Dirección: </label>
					<form:input type="text" class="form-control" path="DireccionProveedor" value = "${proveedor.direccionProveedor}"/>					
					<br>
					
					<label>E-mail: </label>
					<form:input type="email" class="form-control" path="EmailProveedor" value = "${proveedor.emailProveedor}"/>
					<br>
					
					<fmt:formatDate value="${proveedor.fechaIngresoProveedor}" var="dateString" pattern="yyyy-MM-dd" />
					<label>Fecha de Ingreso: </label>
					<form:input type="date" class="form-control" path="FechaIngresoProveedor" value = "${dateString}"/>
					<br>
					
					<label>Tipo Proveedor: </label>
					<form:select class="form-control" path="objTipoMantenimiento">
					    <c:forEach var="tipomantenimientos" items="${tipomantenimiento}">
					        <option value="${tipomantenimientos.idTipoMantenimiento}" ${tipomantenimientos.idTipoMantenimiento == proveedor.objTipoMantenimiento.idTipoMantenimiento ? 'selected="selected"' : ''}>${tipomantenimientos.nombreTipoMantenimiento}</option>
					    </c:forEach>
					</form:select>					
					<br>	
					
					<button type="submit" class="btn-lg btn-primary pull-right">Actualizar</button>
				
				</form:form>
			</div>
		</div>
	
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>