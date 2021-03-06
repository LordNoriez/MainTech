<head>
    <title>Ver Usuarios</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Ver Usuarios</h4>
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
			<p>�reas de la Empresa
		  <a href="/crearAreaEmpresa">Crear</a>
		  <a href="/areaEmpresa">Ver</a>
			<p>Roles
		  <a href="/crearRol">Crear</a>
		  <a href="/rol">Ver</a>
			<p>Reportes
		  <a href="/reporte">Ver</a>
		  <a href="/reporteRol">V�culo con Roles</a>
		  <a href="/crearReporteRol">V�cular con Roles</a>
<!-- 			<p>Actividades -->
<!-- 		  <a href="/crearActividad">Crear</a> -->
<!-- 		  <a href="/actividad">Ver</a> -->
	<!-- 	  <a href="/crearCategoria">Crear Categor�a</a> -->
	<!-- 	  <a href="/categoria">Ver Categor�as</a> -->
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
							<th>ID</th>
							<th>Nombre</th>
							<th>Correo</th>
							<th>Rol</th>
							<th>�rea de Empresa</th>
						</tr>
					</thead>
    				<tbody id="myTable">
		
					<c:forEach var="usuario" items="${usuarios}">
					    <tr>
						<td>${usuario.idUsuario}</td>
						<td>${usuario.nombreUsuario}</td>
						<td>${usuario.correoUsuario}</td>
						<td>${usuario.rol.getNombreRol()}</td>
						<td>${usuario.getAreaEmpresa().getNombreAreaEmpresa()}</td>
		
						<td>
						  <spring:url value="/deleteUsuario/${usuario.idUsuario}" var="deleteUrl" />
						  <spring:url value="/usuario/${usuario.idUsuario}" var="updateUrl" />
		
						  <button class="btn btn-primary"
		                                          onclick="location.href='${updateUrl}'">Update</button>
		                                                                             
						  <button onclick="location.href='${deleteUrl}'; setTimeout(snackBarFunction(),5000);" class="btn btn-danger">Delete</button>
		<%--                                           onclick="this.disabled=true;post('${deleteUrl}')">Delete</button> --%>
		                                          
		                  </td>
					    </tr>
					</c:forEach>
					</tbody>
				</table>
			</div>

	</div>
	
	<div id="snackbar" class="alert alert-danger">Usuario Eliminado Correctamente</div>

	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>

</body>