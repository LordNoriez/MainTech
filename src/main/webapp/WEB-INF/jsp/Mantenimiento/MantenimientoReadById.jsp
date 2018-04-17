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
				
				<h4 class="text-muted">Información Mantenimiento</h4>
				
				<div>
				<div style="float:left;width:32%;border: 1px solid #cecccf;border-radius: 8px;margin-right: 1%;">
					<p style="font-size:10px; color: rgb(182,182,182);margin-bottom: 0px;margin-left:  5%;">Nombre</p><br>
					<label style="margin-bottom: 0%;margin-left:  5%;">${varMantenmiento.nombreMantenimiento}</label>
				</div>
				<div style="float:left;width:32%;border: 1px solid #cecccf;border-radius: 8px;margin-right: 1%;">
					<p style="font-size:10px; color: rgb(182,182,182);margin-bottom: 0px;margin-left:  5%;">Tipo Mantenimiento</p><br>
					<label style="margin-bottom: 0%;margin-left:  5%;">${varMantenmiento.objTipoMantenimiento.nombreTipoMantenimiento}</label>
				</div>
				<div style="float:left;width:32%;border: 1px solid #cecccf;border-radius: 8px;margin-right: 1%;">
					<p style="font-size:10px; color: rgb(182,182,182);margin-bottom: 0px;margin-left:  5%;">Fecha</p><br>
					<label style="margin-bottom: 0%;margin-left:  5%;">${varMantenmiento.fechaMantenimiento}</label>
				</div>
				</div>
				<br>
				
				<div>
				<div style="float:left;width:32%;border: 1px solid #cecccf;border-radius: 8px;margin-right: 1%;">
					<p style="font-size:10px; color: rgb(182,182,182);margin-bottom: 0px;margin-left:  5%;">Descripcion</p><br>
					<label style="margin-bottom: 0%;margin-left:  5%;">${varMantenmiento.descripcionMantenimiento}</label>
				</div>
				<div style="float:left;width:32%;border: 1px solid #cecccf;border-radius: 8px;margin-right: 1%;">
					<p style="font-size:10px; color: rgb(182,182,182);margin-bottom: 0px;margin-left:  5%;">Equipo</p><br>
					<label style="margin-bottom: 0%;margin-left:  5%;">${MantObjeto.descripcionObjeto}</label>
				</div>
				<div style="float:left;width:32%;border: 1px solid #cecccf;border-radius: 8px;margin-right: 1%;">
					<p style="font-size:10px; color: rgb(182,182,182);margin-bottom: 0px;margin-left:  5%;">Cantidad Mantenimiento Equipo</p><br>
					<label style="margin-bottom: 0%;margin-left:  5%;">${CantMante}</label>
				</div>
				</div>	
				
				<br>
				
				<div style="height: 10%;width: 100%;margin-top: 90px;">
				<h4 class="text-muted">Epps: </h4>
				
				<a class="btn-lg btn-primary pull-right" href="/mantenimientoEpp/${varMantenmiento.idMantenimiento}">Agregar</a>
				</div>
				<div style="width:100%">
				<table class="table table-striped table-hover">
				  <c:forEach items="${MantEpp}" var="MantEpps" varStatus="rowCounter">
				    <c:if test="${rowCounter.count % 3 == 1}">
				      <tr>
				    </c:if>
				    <td style = "border-left: 1px solid #ddd;">${MantEpps[1].toString()}</td>
				    <c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(values)}">
				      </tr>
				    </c:if>
				  </c:forEach >
				</table>
				</div>
				<div>
				<h4 class="text-muted">Actividades: </h4>
				
				<a class="btn-lg btn-primary pull-right" href="/LinkMantActividad/${varMantenmiento.idMantenimiento}">Agregar</a>
				</div>
				
				<div style="width:100%">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Proveedor</th>
						</tr>
					</thead>
    				<tbody id="myTable">
					
					<c:forEach var="Actividades" items="${ItemActividad}">
					    <tr>
							<td>${Actividades[1].toString()}</td>
							<td>${Actividades[2].toString()}</td>
						</tr>
					</c:forEach>
    				</tbody>
				</table>
				</div>
				<br>
				
				<h4 class="text-muted">Autorizado por: </h4>
				
				<table class="table table-striped table-hover">
				  <c:forEach items="${Autorizacion}" var="Autorizaciones" varStatus="rowCounter">
				    <c:if test="${rowCounter.count % 3 == 1}">
				      <tr>
				    </c:if>
				    <td style = "border-left: 1px solid #ddd;">${Autorizaciones[0].toString()} <br>
				    <p style = "font-size:10px; color: rgb(182,182,182);">${Autorizaciones[1].toString()}</p></td>
				    <c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(values)}">
				      </tr>
				    </c:if>
				  </c:forEach >
				</table>
				
				<h4 class="text-muted">Liberado por: </h4>
				
				<table class="table table-striped table-hover">
				  <c:forEach items="${Liberado}" var="Liberaciones" varStatus="rowCounter">
				    <c:if test="${rowCounter.count % 3 == 1}">
				      <tr>
				    </c:if>
				    <td style = "border-left: 1px solid #ddd;">${Liberaciones[0].toString()} <br>
				    <p style = "font-size:10px; color: rgb(182,182,182);">${Liberaciones[1].toString()}</p></td>
				    <c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(values)}">
				      </tr>
				    </c:if>
				  </c:forEach >
				</table>
				
			</div>

	</div>
	

	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>