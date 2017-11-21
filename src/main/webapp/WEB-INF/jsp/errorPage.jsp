<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Error</title>
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

    
	<div class="container-fluid">
    
    <!--<div class="container" style="margin-top: 50px;">-->
		<!-- Login panel -->
		<div class="row">
			<div class=" col-lg-12">		
				<div class="header clearfix">
			        <div class=" col-md-6">
			        	<h2 class="text-muted">MainTech</h2>	
				    </div>
			        <div class=" col-md-6">
			        	<nav>
			            	<ul class="nav nav-pills pull-right">
			                	<li class="active" ng-show="user" id="home"><a href="/google/login">Inicio</a></li>
			                	<li class="active" ng-show="!user" id="home"><a href="/google/login">Login</a></li>
			                	<li><a href="#" ng-show="user" ng-click="logout()">Salir</a></li>
			            	</ul>
			        	</nav>
			        </div>
			    </div>
			</div>
		</div>
		
		<div class="row">
			<div ng-show="!user" class=" col-md-12">	
				<div class="jumbotron">					
					<h3 >Hola! Bienvenido(a) Por favor identificate</h3>			        
			    </div>	
			 </div>
			<div ng-show="user" class=" col-md-3">	
				<div class="jumbotron">						
					<img class="p-img" ng-show="user" alt="" ng-src="{{user.userAuthentication.details.picture}}">					
					<h3 ng-show="user">Hola {{user.name}}</h3>
					<h4 ng-show="user">Email: {{user.userAuthentication.details.email}}</h4>				        
			    </div>	
			 </div>
			 
			<div ng-show="user" class=" col-md-8">						
				<div class="panel panel-default">
					<div class="panel-heading">
						<h2>Menú</h2>
					</div>
					
					<div class="panel-body">
						<div class="col-md-12">
							<a class="btn btn-default btn-block" ng-show="user" href="/reporte">Enviar Reporte de Costos</a>
						</div>	
						<br><br>
						<div class="col-md-12">
							<a class="btn btn-default btn-block" ng-show="user" href="/objeto">Objetos</a>
						</div>		
						<br>	<br>		
						<div class="col-md-12">
							<a class="btn btn-default btn-block" ng-show="user" href="/mantenimiento">Mantenimientos</a>
						</div>	
<!-- 						<br>	<br> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<a class="btn btn-default btn-block" ng-show="user" href="/tipoMantenimiento">Tipos de Mantenimiento</a> -->
<!-- 						</div>	 -->
						<br>	<br>
						<div class="col-md-12">
							<a class="btn btn-default btn-block" ng-show="user" href="/areaEmpresa">Áreas de Empresa</a>
						</div>	
						<br><br>
						<div class="col-md-12">
							<a class="btn btn-default btn-block" ng-show="user" href="/actividad">Actividades</a>
						</div>	
						<br><br>
						<div class="col-md-12">
							<a class="btn btn-default btn-block" ng-show="user" href="/categoria">Categorías</a>
						</div>					
					</div>
				</div>				
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
				$.growl({title: "Error!", message: "Por favor intente más tarde."});			   
			}).error(function(error) {
				$scope.resource = error;
				$.growl({title: "Error!", message: "Por favor intente más tarde."});	
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