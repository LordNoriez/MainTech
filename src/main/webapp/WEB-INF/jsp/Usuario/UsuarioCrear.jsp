<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Crear Usuario</title>
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
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
					
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
<!-- 			<p>Actividades -->
<!-- 		  <a href="/crearActividad">Crear</a> -->
<!-- 		  <a href="/actividad">Ver</a> -->
	<!-- 	  <a href="/crearCategoria">Crear Categor�a</a> -->
	<!-- 	  <a href="/categoria">Ver Categor�as</a> -->
	</div>
	<div class="container-fluid" id="main">
    
    <!--<div class="container" style="margin-top: 50px;">-->
		<!-- Login panel -->
		<div class="row">
			<div class=" col-md-12">		
				<div class="header clearfix">
			        <div class=" col-md-6">
			        	<h2 class="text-muted">MainTech</h2>						
				        <h4 class="text-muted">Crear Usuario</h4>
			        </div>
			    </div>
			</div>
		</div>
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
			
			<div class=" col-md-8"  >
				<spring:url value="/addUsuario" var="variableAdd" />
			
				<form:form method="post" modelAttribute="crearModelUsuario" action="${variableAdd}">
					<label>Nombre: </label>
					<form:input path="nombreUsuario" class="form-control" type="text" /> 
					<form:errors path="nombreUsuario" />
					<br>
					
					<label>Correo: </label>
					<form:input path="correoUsuario" class="form-control" type="email" /> 
					<form:errors path="correoUsuario" />
					<br>
					
					<label>Rol: </label>						        
					<form:select class="form-control" path="rol">
						<form:options items="${roles}" itemLabel="NombreRol" itemValue="idRol" />
					</form:select>
					<br>
					
					<label>�rea de Empresa: </label>						        
					<form:select class="form-control" path="rol">
						<form:options items="${areaEmpresas}" itemLabel="NombreAreaEmpresa" itemValue="idAreaEmpresa" />
					</form:select>
					<br>
					
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar</button>
				</form:form>
	        </div>
		</div>
	
		
	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Se Ingres� Correctamente</div>	
        

    <footer class="footer">
        <p> &copy; 2017 POFASA S.A.</p>
    </footer>

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
	</script>

</body>
</html>