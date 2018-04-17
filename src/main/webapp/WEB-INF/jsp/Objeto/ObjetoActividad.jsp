<head>
    <title>Equipo</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Equipo</h4>
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
			

			<div class=" col-md-8 table-responsive"  >
				<input class="form-control" id="myInput" type="text" placeholder="Buscar..">
				<br>
				<form action="/ObjetoActividadupdated/${varObjeto.idObjeto}" method="post">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Área</th>
						</tr>
					</thead>
    				<tbody id="myTable">
		
					<c:forEach var="allActvs" items="${allActv}">
						<c:set var="auxchecked" value="0"/>
						<tr>
					    <c:set var = "ob" scope = "session" value = "${allActvs}"/>
					    <c:if test="${empty ob}">
					    	<td> - </td>
						</c:if>
						<c:if test="${not empty ob}">
						    <td>${allActvs.nombreActividad} <br>
						</c:if>
						
						<c:forEach var="ItemActvs" items="${ItemActv}">									
						    <c:if test="${ItemActvs[1]==allActvs.idActividad}">
						        <td><input type="checkbox" checked name="foo" value="${ItemActvs[1].toString()}" ></td>
						        <c:set var="auxchecked" value= "1"/>
						    </c:if>
					  	</c:forEach>
					  	<c:if test="${auxchecked == 0}">
						        <td><input type="checkbox" name="foo" value="${allActvs.idActividad}" ></td>
					    </c:if>

					    </tr>
					</c:forEach>
					</tbody>
				</table>
					<a class="btn btn-danger pull-left" href="/objetoById/${varObjeto.idObjeto}">Cancelar</a>
					<button type="submit" class="btn-lg btn-primary pull-right">Aceptar</button>
				
				</form>
			</div>

	</div>
	
	<div id="snackbar" class="alert alert-danger">Equipo Eliminado Correctamente</div>

	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>