<head>
    <title>Ver Categor�as</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Ver Categor�as</h4>
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
		  <p>Categor�as
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
			    
			    					
				<button type="button" onclick="openNav()" class="btn btn-info btn-block">Men�</button>				
					
			</div>
			

			<div class=" col-md-8 table-responsive"  >
				<input class="form-control" id="myInput" type="text" placeholder="Buscar..">
				<br>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Descripci�n</th>
						</tr>
					</thead>
    				<tbody id="myTable">
		
					<c:forEach var="categoria" items="${categorias}">
					    <tr>
							<td>${categoria.nombreCategoria}</td>
							<td>${categoria.descripcionCategoria}</td>
			
							<td>
							  <spring:url value="/deleteCategoria/${categoria.idCategoria}" var="deleteUrl" />				  
							  <spring:url value="/categoria/${categoria.idCategoria}" var="updateUrl" />
			
							  <button class="btn btn-primary"
			                                          onclick="location.href='${updateUrl}'">Update</button>
			                                                                             
							  <button onclick="location.href='${deleteUrl}'; setTimeout(snackBarFunction(),5000);" class="btn btn-danger">Delete</button>     
			                </td>
					    </tr>
					</c:forEach>
					</tbody>
				</table>
			</div>

	</div>
	
	<div id="snackbar" class="alert alert-danger">Categor�a Eliminada Correctamente</div>

	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>