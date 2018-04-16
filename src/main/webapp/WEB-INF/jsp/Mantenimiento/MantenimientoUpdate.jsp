<head>
    <title>Editar Mantenimiento</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Editar Mantenimiento</h4>
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
				<spring:url value="/updateMantenimiento/${varMantenmiento.idMantenimiento}" var="variableAdd" />
			
				<form:form method="PUT" modelAttribute="varMantenmiento" action="${variableAdd}">
					
					<label>Nombre: </label>
					<form:input type="text" path="NombreMantenimiento" class="form-control" value = "${varMantenmiento.nombreMantenimiento}"/>					
					<br>
			
					<fmt:formatDate value="${varMantenmiento.fechaMantenimiento}" var="dateString" pattern="yyyy-MM-dd" />
					<label>Fecha: </label>
					<form:input type="date" path="FechaMantenimiento" class="form-control" value = '${dateString}'/>					
					<br>
				
					<label>Descripción: </label>
					<form:input type="text" path="DescripcionMantenimiento" class="form-control" value = "${varMantenmiento.descripcionMantenimiento}"/>					
					<br>
					
					<label>Tipo de Mantenimiento: </label>						        
					<form:select class="form-control" path="objTipoMantenimiento">
						<form:option value="" label="--- Select ---" />
						<form:options items="${tipos}" itemLabel="NombreTipoMantenimiento" itemValue="idTipoMantenimiento" />
					</form:select>
					<br>
					
					<label class="col-md-2">Programado?</label>
					<div class="col-md-2 ">
						<form:checkbox path="isProgramadoMantenimiento" class="form-control" value="${varMantenmiento.isProgramadoMantenimiento}"/>						
					</div>
					<br>
					<br>
					<br>
				
					<label>Frecuencia de Mantenimiento (horas): </label>
					<form:input path="FrecuenciaMantenimiento" class="form-control" type="number" value="${varMantenmiento.frecuenciaMantenimiento}"/>					
					<br>
					
					<label>Objeto: </label>
					<form:select class="form-control" path="objetoMantenimiento">
					    <c:forEach var="Itemobjetos" items="${Itemobjeto}">
					        <option value="${Itemobjetos.idObjeto}" ${Itemobjetos.idObjeto == varMantenmiento.objetoMantenimiento.idObjeto ? 'selected="selected"' : ''}>${Itemobjetos.descripcionObjeto}</option>
					    </c:forEach>
					</form:select>					
					<br>		
					
					<form:select multiple="true" path="actividad" items="${ItemActividad}" itemLabel="nombreActividad" itemValue="idActividad" />
					<br>				
				
					<button type="submit" class="btn-lg btn-primary pull-right">Actualizar</button>
				
				</form:form>
			</div>
		</div>
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>