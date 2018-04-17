<head>
    <title>Inicio</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>

    
	<div class="container-fluid">
    
    <!--<div class="container" style="margin-top: 50px;">-->
		<!-- Login panel -->		
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
						<h1 style="color: #6f6e6c;">Menú</h1>
					</div>
					
					<div class="panel-body">
<!-- 						<div class="col-md-12"> -->
<!-- 							<a class="btn btn-default btn-block" ng-show="user" href="/reporte">Enviar Reporte de Costos</a> -->
<!-- 						</div>	 -->
<!-- 						<br><br> -->
						<div class="col-md-4">
							<a class="btn btn-default btn-block" ng-show="user" href="/objeto">Equipos</a>
						</div>		
<!-- 						<br>	<br>	 -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<a class="btn btn-default btn-block" ng-show="user" href="/categoria">Categorías</a> -->
<!-- 						</div>		 -->
<!-- 						<br>	<br>	 -->
						<div class="col-md-4">
							<a class="btn btn-default btn-block" ng-show="user" href="/mantenimiento">Mantenimientos</a>
						</div>	
<!-- 						<br>	<br> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<a class="btn btn-default btn-block" ng-show="user" href="/tipoMantenimiento">Tipos de Mantenimiento</a> -->
<!-- 						</div>	 -->
<!-- 						<br>	<br> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<a class="btn btn-default btn-block" ng-show="user" href="/actividad">Actividades</a> -->
<!-- 						</div>	 -->
<!-- 						<br><br> -->
						<div class="col-md-4">
							<a class="btn btn-default btn-block" ng-show="user" href="/areaEmpresa">Empresa</a>
						</div>				
					</div>
				</div>				
			</div>
	    </div>
	    
        <div class="row marketing">
        <div class="col-lg-6">
            <h4>Misión</h4>
            <p>Producir la mejor carne de aves del Ecuador, contando con colaboradores motivados a la excelencia, con alta tecnología y eficiencia, para la satisfacción de nuestros clientes y en armonía con la naturaleza</p>
        </div>
		<div class="col-lg-6">            
            <h4>Visión</h4>
            <p>Ser la empresa LÍDER de producción y comercialización de carne de aves en el mercado ecuatoriano, rentable y sostenible en el tiempo.</p>
        </div>
    </div>

	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>
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
				$.growl({title: "Bienvenido(a) " + user.name, message: "POFASA S.A."});			   
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
