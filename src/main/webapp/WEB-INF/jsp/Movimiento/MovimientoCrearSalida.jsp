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
    <title>Salida de Equipos</title>
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
			        	<h2 class="text-muted">MainTech</h2>						
				        <h4 class="text-muted">Salida de Equipos</h4>
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
			
			<div class=" col-md-8"  >
				<spring:url value="/addMovimientoSalida" var="variableAdd" />
			
				<form:form name="FormSalidaMovimiento" method="POST" modelAttribute="crearModelMovimiento" action="${variableAdd}">	
				
					<label>Descripción: </label>
					<form:input path="DescripcionMovimiento" class="form-control" type="text" /> <!-- bind to user.name-->
					<form:errors path="DescripcionMovimiento" />
					<br>
					
					<label>Equipo: </label>						        
					<form:select id="ddlObjeto" name="ddlObjeto" class="form-control" path="objeto" >
						<form:option value="" label="--- Seleccionar ---" />
						<c:forEach var="obj" items="${objetos}">
							<form:option label="${obj[8].toString()}" value="${obj[2]}" />
						</c:forEach>
					</form:select>
					<br>
					
					<label>Límite Máx: </label>
					<input type="number" id="lmitmax" class="form-control" readonly/>
					<br>
					
					<label>Cantidad: </label>					
					<form:input type="number" path="CantidadMovimiento" class="form-control" step ="any" onkeyup="this.value = minmax(this.value, 0, 100)"/>					
					<br>
					
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar</button>
				</form:form>
	       </div>
		</div>
	
		
	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Se Ingresó Correctamente</div>	
        

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

       function dropCants(cant) {
           var districtId = objtoid.value;
         
           $('#ddl').empty(); // empty existing list
           for (i = 1; i <= cant; i++) { 
           	$('#ddl').append($('<option></option>').val(i.toString()).html(i.toString()));
           }
       }

   	$(function() {
   	  $("#ddlObjeto").on("change",function() {
   	    var period = this.value;
   	    $.ajax({
   	        type: 'POST',
   	        url: "/myPage",
   	        data: {
   	           item: period
   	        },
   	        success: function (html) {
   	        	
   	        	document.getElementById("lmitmax").value = parseInt(html);
   	        },
   	        error: function(e) {
   	            console.log("Error:" + e);
   	        }
   	    });
   	  }); 
   	});
   	
   	function minmax(value, min, max) 
   	{
   	    if(parseInt(value) < min || isNaN(parseInt(value))) 
   	        return 0; 
   	    else if(parseInt(value) > document.getElementById("lmitmax").value) 
   	        return document.getElementById("lmitmax").value; 
   	    else return value;
   	}
	</script>

</body>
</html>