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
    <title>Ver Equipos</title>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/css/jumbotron-narrow.css">
    <link rel="stylesheet" type="text/css" href="/css/home.css">
    <link rel="stylesheet" type="text/css" href="/css/jquery.growl.css"/>
    <script src="http://code.jquery.com/jquery.js"></script>
    <script src="/js/jquery.growl.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">
	<script src="<c:url value="/js/scripts.js" />" type="text/javascript"></script>
    
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
		<!-- Login panel -->
		<div class="row">
			<div class=" col-md-12">		
				<div class="header clearfix">
			        <div class=" col-md-6">
				        <h4 class="text-muted">Equipo</h4>
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
					<a class="btn-lg btn-primary pull-left" href="/objetoById/${varObjeto.idObjeto}">Cancelar</a>
					<button type="submit" class="btn-lg btn-primary pull-right">Aceptar</button>
				
				</form>
			</div>

	</div>
	
	<div id="snackbar" class="alert alert-danger">Equipo Eliminado Correctamente</div>

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

	$(document).ready(function(){
	  $("#myInput").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#myTable tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
	</script>

</body>
</html>