<head>
    <title>Editar Actividad</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
    
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Editar Actividad</h4>
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
				<spring:url value="/updateActividad/${actividad.idActividad}" var="variableAdd" />
			
				<form:form method="PUT" modelAttribute="actividad" action="${variableAdd}">
				
					<label>Nombre: </label>
					<form:input type="text" path="NombreActividad" class="form-control" value = "${actividad.nombreActividad}"/>					
					<br>

					<label>Descripción: </label>
					<form:input type="text" path="DescripcionActividad" class="form-control" value = "${actividad.descripcionActividad}"/>					
					<br>
				
					<button type="submit" class="btn-lg btn-primary pull-right">Actualizar</button>				
				
				</form:form>
			<div style="margin-top: 10%;">
			<div style="Margin-left:  52%">
			<label>Costo</label>
			</div>
			    <div style="width:  49%;float: left;">
				<select name="database1"  class="form-control">
				  <c:forEach items="${Proveedores}" var="Proveedoritem">
				    <option value="${Proveedoritem.idProveedor}">
				        ${Proveedoritem.nombreProveedor}
				    </option>
				  </c:forEach>
				</select>
				
				<input type="text" class="form-control"/>	
				
				</div>
			 	<div style="width: 49%;float: right;height: 100px;overflow:auto;">		  
				<table class="table table-striped table-hover">
    				<tbody id="myTableCost">
		
					<c:forEach var="Costos" items="${AllCostos}">
					    <tr>
							<td>${Costos[0].toString()}</td>
					    </tr>
					</c:forEach>
					</tbody>
				</table>
				</div>						
			</div>
			
			<div class=" col-md-8" style="width: 100%;padding-left: 0%;padding-right: 0%;">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Proveedor</th>
							<th>Costo ($)</th>
						</tr>
					</thead>
    				<tbody id="myTable">
		
					<c:forEach var="actividades" items="${ProvedorxCosto}">
					    <tr>
							<td>${actividades[2].toString()}</td>
							<td>${actividades[3].toString()}</td>
					    </tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			</div>
		</div>
	
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script type="text/javascript">
		var app = angular.module('MainTech', []);
	
		app.config([ '$httpProvider', function($httpProvider) {
			$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
		} ]);
		app.controller('AppCtrl', function($http, $scope) {
	
		// method for getting user details
		var getUser = function() {
			$http.get('/user').success(function(user) {
				$scope.user = user;
				console.log('Logged User : ', user);		   
			}).error(function(error) {
				$scope.resource = error;
			});
		};
		getUser();
	    
		// method for logout
		$scope.logout = function() {
			$http.post('/logout').success(function(res) {
				$scope.user = null;
			}).error(function(error) {
				console.log("Logout error : ", error);
			});
		};
	});

		function openNav() {
		    document.getElementById("mySidenav").style.width = "250px";
		    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
		}

		/* Set the width of the side navigation to 0 and the left margin of the page content to 0, and the background color of body to white */
		function closeNav() {
		    document.getElementById("mySidenav").style.width = "0";
		    document.body.style.backgroundColor = "white";
		}
	</script>

	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>

</body>