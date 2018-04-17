<head>
    <title>Ver Mantenimientos</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Ver Mantenimientos</h4>
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
			
			<div class=" col-md-8 table-responsive"  >
				<input class="form-control" id="myInput" type="text" placeholder="Buscar..">
				<br>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Tipo</th>
							<th>Equipo</th>
							<th>Fecha</th>
							<th>Proveedor</th>
							<th>Cantidad</th>
							<th>Costo</th>
							<th>Program?</th>
							<th>Frecuencia</th>
							<th>Aceptado?</th>
							<th>En Proceso?</th>
							<th>Terminado?</th>
<!-- 							<th>Objeto</th> -->
						</tr>
					</thead>
    				<tbody id="myTable">
					
					<c:forEach var="mantenimiento" items="${mantenimientos}">
					    <tr>
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">${mantenimiento[1].toString()}</td>
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">${mantenimiento[3].toString()}</td>		
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">${mantenimiento[6].toString()} ${mantenimiento[7].toString()}</td>				
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">${mantenimiento[4].toString()}</td>			
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">${mantenimiento[9].toString()}</td>		
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">${mantenimiento[16].toString()}</td>	
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">${mantenimiento[15]}</td>
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">	
								<c:choose>
								  <c:when test="${mantenimiento[10]==true}">
								    <input type="checkbox" checked >
								  </c:when>
								  <c:otherwise>
								    <input type="checkbox" >
								  </c:otherwise>
								</c:choose>
							</td>	
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">${mantenimiento[11]}</td>
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">							
								<c:choose>
								  <c:when test="${mantenimiento[12]==true}">
								    <input type="checkbox" checked onclick="javascript:location.href='/mantenimientoAceptado/${mantenimiento[0]}'">
								  </c:when>
								  <c:otherwise>
								    <input type="checkbox" onclick="javascript:location.href='/mantenimientoAceptado/${mantenimiento[0]}'">
								  </c:otherwise>
								</c:choose></td>	
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">
								<c:choose>
								  <c:when test="${mantenimiento[13]==true}">
								    <input type="checkbox" checked onclick="javascript:location.href='/mantenimientoProceso/${mantenimiento[0]}/${mantenimiento[5]}/${mantenimiento[16]}'">
								  </c:when>
								  <c:otherwise>
								    <input type="checkbox" onclick="javascript:location.href='/mantenimientoProceso/${mantenimiento[0]}/${mantenimiento[5]}/${mantenimiento[16]}'">
								  </c:otherwise>
								</c:choose></td>
							
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">	
								<c:choose>
								  <c:when test="${mantenimiento[14]==true}">
								    <input type="checkbox" checked onclick="javascript:location.href='/mantenimientoTerminado/${mantenimiento[0]}/${mantenimiento[5]}/${mantenimiento[16]}'">
								  </c:when>
								  <c:otherwise>
								    <input type="checkbox" onclick="javascript:location.href='/mantenimientoTerminado/${mantenimiento[0]}/${mantenimiento[5]}/${mantenimiento[16]}'">
								  </c:otherwise>
								</c:choose></td>
										
<%-- 							<td>${mantenimiento.objetoMantenimiento.getDescripcionObjeto()}</td> --%>
			
							<td onClick="document.location.href='/mantenimientobyId/${mantenimiento[0].toString()}';">
							  <spring:url value="/deleteMantenimiento/${mantenimiento[0].toString()}" var="deleteUrl" />
							  <spring:url value="/mantenimiento/${mantenimiento[0].toString()}" var="updateUrl" />
								
							  <button class="btn btn-primary"
			                                          onclick="location.href='${updateUrl}'">Update</button>
			                                                                             
<%-- 							  <button onclick="location.href='${deleteUrl}'; setTimeout(snackBarFunction(),5000);" class="btn btn-danger">Delete</button> --%>
			                </td>
					    </tr>
					</c:forEach>
    				</tbody>
				</table>
			</div>

	</div>
	
	<div id="snackbar" class="alert alert-danger">Mantenimiento Eliminado Correctamente</div>

	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>