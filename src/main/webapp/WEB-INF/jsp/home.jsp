<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Inicio</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/jumbotron-narrow.css">
    <link rel="stylesheet" type="text/css" href="/css/home.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery.growl.css"/>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="/js/jquery.growl.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
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

<div class="container">
    <div class="header clearfix">
        <nav>
            <ul class="nav nav-pills pull-right">
                <li class="active" ng-show="user" id="home"><a href="/google/login">Inicio</a></li>
                <li class="active" ng-show="!user" id="home"><a href="/google/login">Login</a></li>
                <li><a href="#" ng-click="logout()">Salir</a></li>
            </ul>
        </nav>
        <h3 class="text-muted">MainTech</h3>
    </div>
    
    <div class="container" style="margin-top: 50px;">
		<!-- Login panel -->
		
		<div class=" col-md-5">
			<div class="panel panel-default">
				<div class="panel-heading">
					
					<div class="jumbotron">						
						<img class="p-img" ng-show="user" alt="" ng-src="{{user.userAuthentication.details.picture}}">
						<h3 ng-show="!user">Hola!</h3>
						<h3 ng-show="user">Hola {{user.name}}</h3>				        
				    </div>				
				</div>
				<div class="panel-body" ng-show="user">
					<div class="col-md-12">Email: {{user.userAuthentication.details.email}}
						</div>					
				</div>
			</div>
			<!-- End Home Panel -->

		</div>
		<div class=" col-md-5">						
			<div class="panel panel-default">
				<div class="panel-heading">
					<h2 ng-show="user">Men�</h2>
				</div>
				
				<div class="panel-body">
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/reporte">Enviar Reporte de Costos</a>
					</div>					
				</div>
				<br>
				<div class="panel-body">
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/crearObjeto">Crear Objeto</a>
					</div>	
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/objeto">Ver Objetos</a>
					</div>					
				</div>
				<div class="panel-body">
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/crearMantenimiento">Crear Mantenimiento</a>
					</div>		
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/mantenimiento">Ver Mantenimientos</a>
					</div>					
				</div>
				<div class="panel-body">
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/crearTipoMantenimiento">Crear Tipo Mantenimiento</a>
					</div>		
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/tipoMantenimiento">Ver Tipo Mantenimientos</a>
					</div>					
				</div>
				<div class="panel-body">
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/crearAreaEmpresa">Crear Area Empresa</a>
					</div>		
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/areaEmpresa">Ver Area Empresa</a>
					</div>					
				</div>
				<div class="panel-body">
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/crearActividad">Crear Actividad</a>
					</div>		
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/actividad">Ver Actividad</a>
					</div>					
				</div>
				<div class="panel-body">
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/crearCategoria">Crear Categor�a</a>
					</div>		
					<div class="col-md-12">
						<a class="btn btn-default" ng-show="user" href="/categoria">Ver Categor�as</a>
					</div>					
				</div>
			</div>
			<!-- End Home Panel -->
		</div>
	</div>
    
    <div class="row marketing">
        <div class="col-lg-6">
            <h4>Subheading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

            <h4>Subheading</h4>
            <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet
                fermentum.</p>
        </div>

        <div class="col-lg-6">
            <h4>Subheading</h4>
            <p>Donec id elit non mi porta gravida at eget metus. Maecenas faucibus mollis interdum.</p>

            <h4>Subheading</h4>
            <p>Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Cras mattis consectetur purus sit amet
                fermentum.</p>
        </div>
    </div>

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
				// welcome message
				$.growl({title: "Bienvenido(a)", message: "POFASA S.A."});			   
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