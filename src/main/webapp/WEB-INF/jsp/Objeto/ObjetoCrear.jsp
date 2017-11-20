<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
	
<!-- 	<link rel="stylesheet" type="text/css" href="css/style.css"> -->
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/jumbotron-narrow.css">
    <link rel="stylesheet" type="text/css" href="/css/home.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery.growl.css"/>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="/js/jquery.growl.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="<c:url value="css/style.css" />" rel="stylesheet">
	<script src="<c:url value="js/scripts.js" />"></script>
</head>

<style>
[ng\:cloak], [ng-cloak], .ng-cloak {
	display: none !important;
}

.margin-top-5 {
	margin-top: 10px;
}

.p-img {
	height: 50px;
	width: 50px;
	border-radius: 50%;
}
</style>

	<body>
	
	<div class="container">
		<div class="row">
			<div class=" col-lg-12">		
				<div class="header clearfix">
			        <div class=" col-md-6"><h2 class="text-muted">MainTech</h2></div>
			        <div class=" col-md-6">
				        <nav>
				            <ul class="nav nav-pills pull-right">
				            	<li> <h4 class="text-muted">Crear Objeto         </h4></li>				            	
				                <li class="active" id="home"><a href="/google/login">Inicio</a></li>			                
				                <li><a href="#" onclick="logout()">Salir</a></li>
				            </ul>
				        </nav>
					</div>
			    </div>
			</div>
		</div>
		
		<div class="row">
			<div class=" col-md-4">
				<div class="jumbotron">						
					<img class="p-img" alt="" src="{{user.userAuthentication.details.picture}}">
					<h5>Hola ${usu}</h5>
					<h6>Email: {{user.userAuthentication.details.email}}</h6>				        
			    </div>	
			    
			    					
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2>Menú</h2>
					</div>
					
					<div class="panel-body">
						<div class="col-sm-4">
							<a class="btn btn-default" href="/reporte">Enviar Reporte de Costos</a>
						</div>	
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/crearObjeto">Crear Objeto</a>
						</div>	
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/objeto">Ver Objetos</a>
						</div>		
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/crearMantenimiento">Crear Mantenimiento</a>
						</div>		
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/mantenimiento">Ver Mantenimientos</a>
						</div>	
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/crearTipoMantenimiento">Crear Tipo Mantenimiento</a>
						</div>		
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/tipoMantenimiento">Ver Tipo Mantenimientos</a>
						</div>	
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default"  href="/crearAreaEmpresa">Crear Area Empresa</a>
						</div>		
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default"  href="/areaEmpresa">Ver Area Empresa</a>
						</div>	
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/crearActividad">Crear Actividad</a>
						</div>		
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/actividad">Ver Actividad</a>
						</div>	
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/crearCategoria">Crear Categoría</a>
						</div>		
						<br><br>
						<div class="col-sm-4">
							<a class="btn btn-default" href="/categoria">Ver Categorías</a>
						</div>					
					</div>
				</div>
			</div>
			
			<div class=" col-md-6">
				<spring:url value="/objeto" var="variableAdd" />
			
			 	<form:form method="POST" modelAttribute="crearModelObjeto" action="${variableAdd}" id="myForm"> 
					<br><h2>Marca: </h2>
					<form:input path="MarcaObjeto" type="text" /> 
					<form:errors path="MarcaObjeto" />
					
					<br><h2>Modelo: </h2>
					<form:input path="ModeloObjeto" type="text" /> 
					<form:errors path="ModeloObjeto" />
					
					<br><h2>Serial: </h2>
					<form:input path="SerialObjeto" type="text" /> 
					<form:errors path="SerialObjeto" />
					
					<br><h2>Categoria: </h2>
					<form:select path="categoria">
						<form:option value="" label="--- Select ---" />
						<form:options items="${categories}" itemLabel="NombreCategoria" itemValue="idCategoria" />
					</form:select>
					
					<br><h2>Objeto Padre: </h2>
					<form:select path="objetoPadre" onchange="document.getElementById('objtPadre').value = this.value;">
						<form:option value="" label="--- Select ---" itemValue=""/>
						<form:options items="${objects}" itemLabel="DescripcionObjeto" itemValue="idObjeto" />
					</form:select>
			
			<!-- 		<select id="objPadreInput" name="titleId" onchange="document.getElementById('objtPadre').value = this.value;"> -->
			<!-- 		    <option value="NULL" label="--- Select ---" /> -->
			<%-- 		    <c:forEach items="${objects}" var="objs"> --%>
			<%-- 		            <option value="${objs.idObjeto}" selected>${objs.marcaObjeto}</option> --%>
			<%-- 		    </c:forEach> --%>
			<!-- 		</select> -->
					
			<!--  used for take the id and then assign it to the Objeto -->
					<form:input type="hidden" path="objetoPadre" id = "objtPadre" /> 
					
					
					<br><h2>Fecha Creacion: </h2>
					<form:input path="FechaCreacionObjeto" type="date" /> 
					<form:errors path="FechaCreacionObjeto" />
					
					<br><h2>Fecha Obtencion: </h2>
					<form:input path="FechaObtencionObjeto" type="date" /> 
					<form:errors path="FechaObtencionObjeto" />
					
					<br><h2>Longitud: </h2>
					<form:input path="LongitudObjeto" type="text" /> 
					<form:errors path="LongitudObjeto" />
					
					<br><h2>Ancho: </h2>
					<form:input path="AnchoObjeto" type="text" /> 
					<form:errors path="AnchoObjeto" />
					
					<br><h2>Area: </h2>
					<form:input path="AreaObjeto" type="text" /> 
					<form:errors path="AreaObjeto" />
			
					<br><h2>Altura: </h2>
					<form:input path="AlturaObjeto" type="text" /> 
					<form:errors path="AlturaObjeto" />
					
					<br><h2>Vida: </h2>
					<form:input path="VidaObjeto" type="text" /> 
					<form:errors path="VidaObjeto" />	
					
					<br><h2>Descripcion: </h2>
					<form:input path="DescripcionObjeto" type="text" />
					<form:errors path="DescripcionObjeto" />
			
					<br>
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar
			                             </button>
				</form:form>
			</div>
		</div>
	</div>
		
	        <!-- The actual snackbar -->
        <div id="snackbar">Se Ingreso Correctamente</div>	
        
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
					// welcome message
					$.growl({title: "Bienvenido(a)", message: "POFASA S.A."});			   
				}).error(function(error) {
					$scope.resource = error;
					$.growl({title: "No logeado", message: "POFASA S.A."});
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
		</script>
	</body>
</html>