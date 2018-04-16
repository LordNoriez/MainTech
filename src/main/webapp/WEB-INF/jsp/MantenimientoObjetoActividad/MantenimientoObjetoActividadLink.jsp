<head>
    <title>Asignar Actividades al Mantenimiento</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Asignar Actividades al Mantenimiento</h4>
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
							
				<spring:url value="/LinkEvrything" var="variableAdd" />
				<form:form method="post" modelAttribute="crearModelMantenimiento" action="${variableAdd}">
					
					<label>Mantenimiento: </label>
					<form:select class= "form-control" path="mantenimientos">
						<form:option label="${groupMant.getNombreMantenimiento()}" value="${groupMant.getIdMantenimiento()}" />
					</form:select>	
					<br>
					
					<label>Equipo: </label>
					<form:select class= "form-control" path="idobjeto">
						<form:option label="${idobjeto.getDescripcionObjeto()}" value="${idobjeto.getIdObjeto()}" />
					</form:select>					
					<br>
					
					<label>Cantidad: </label>					
					<form:input type="number" path="cantidadMantenimiento" class="form-control" readonly="true"  />					
					<br>
					
					<label>Proveedor: </label>	
					<form:select class= "form-control" path="listIdProveedor">
						<form:option label="${proveedores.getNombreProveedor()}" value="${proveedores.getIdProveedor()}" />
					</form:select>				
					<br>
					        
    				<label>Actividades: </label>
					       <form:select name="Actividades" class="form-control" multiple="true" path="listIdActividades">
					          <c:forEach var="item" items="${ActividadesxObjeto}">
					            <option value="${item[1].toString()}">${item[0].toString()}</option>
					          </c:forEach>
					        </form:select>
					<br>
					
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Finalizar</button>
				</form:form>
	        </div>
		</div>
		
	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Se Ingres� Correctamente</div>
        
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>