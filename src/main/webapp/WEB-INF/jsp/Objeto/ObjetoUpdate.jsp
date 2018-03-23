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
    <title>Editar Equipo</title>
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
.sidenav {
    height: 100%; /* 100% Full-height */
    width: 0; /* 0 width - change this with JavaScript */
    position: fixed; /* Stay in place */
    z-index: 1; /* Stay on top */
    top: 0;
    left: 0;
    background-color: #111; /* Black*/
    overflow-x: hidden; /* Disable horizontal scroll */
    padding-top: 60px; /* Place content 60px from the top */
    transition: 0.5s; /* 0.5 second transition effect to slide in the sidenav */
}

/* The navigation menu links */
.sidenav a {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 20px;
    color: #818181;
    display: block;
    transition: 0.3s
}

/* The navigation menu titles */
.sidenav p {
    padding: 8px 8px 8px 32px;
    text-decoration: none;
    font-size: 25px;
    color: #818181;
    display: block;
    transition: 0.3s
}

/* When you mouse over the navigation links, change their color */
.sidenav a:hover, .offcanvas a:focus{
    color: #f1f1f1;
}

/* Position and style the close button (top right corner) */
.sidenav .closebtn {
    position: absolute;
    top: 0;
    right: 25px;
    font-size: 36px;
    margin-left: 50px;
}

/* Style page content - use this if you want to push the page content to the right when you open the side navigation */
#main {
    transition: margin-left .5s;
    padding: 20px;
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
				        <h4 class="text-muted">Editar Equipo</h4>
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
			
			<div class=" col-md-8">
				<h4 class="text-muted">Agregar Actividades: </h4>
		
				<a class="btn-lg btn-primary pull-left" href="/ObjetoActividad/${objeto.idObjeto}">Agregar</a>	
			</div>
			
			<div class=" col-md-8"  >
			
				<spring:url value="/updateObjeto/${objeto.idObjeto}" var="variableAdd" />
			
				<form:form method="PUT" modelAttribute="objeto" action="${variableAdd}">
					
					<label>Área de la Empresa: </label>						        
					<form:select class="form-control" path="AreaEmpresa">
						<form:option value="" label="--- Select ---" />
						<form:options items="${areas}" itemLabel="NombreAreaEmpresa" itemValue="idAreaEmpresa" />
					</form:select>
					<br>
					<div style="width:50%;">
					<label>Descripción:</label>
					<form:input type="text" class="form-control" path="DescripcionObjeto" value = "${objeto.descripcionObjeto}"/>
									
					<label>Marca:</label>
					<form:input type="text" class="form-control" path="MarcaObjeto" value = "${objeto.marcaObjeto}"/>	
					</div>
					<br>
				
					<label>Modelo:</label>
					<form:input type="text" class="form-control" path="ModeloObjeto" value = "${objeto.modeloObjeto}"/>
					<br>
				
					<label>Serial:</label>
					<form:input type="text" class="form-control" path="SerialObjeto" value = "${objeto.serialObjeto}"/>
					<br>	
							
					<label>Categoría:</label>
					<form:select class="form-control" path="categoria">
						<form:option value="" label="--- Select ---" />
						<form:options items="${categories}" itemLabel="NombreCategoria" itemValue="idCategoria" />
					</form:select>
					<br>	
					
					<label>Color: </label>						        
					<form:select class="form-control" path="color">
						<form:options items="${colores}" itemLabel="nombreColor" itemValue="idColor" />
					</form:select>
					<br>
					
					<label>Estructura: </label>						        
					<form:select class="form-control" path="estructura">
						<form:options items="${estructuras}" itemLabel="nombreEstructura" itemValue="idEstructura" />
					</form:select>
					<br>
										
					<label>Equipo Padre:</label>
					<form:select class="form-control" path="objetoPadre" onchange="document.getElementById('objtPadre').value = this.value;">
						<form:option value="" label="--- Select ---" itemValue=""/>
						<form:options items="${objects}" itemLabel="DescripcionObjeto" itemValue="idObjeto" />
					</form:select>
					<form:input type="hidden" path="objetoPadre" id = "objtPadre" /> 
					<br>	
			
					<fmt:formatDate value="${objeto.fechaCreacionObjeto}" var="dateString" pattern="yyyy-MM-dd" />
					<label>Creado El:</label>
					<form:input type="date" class="form-control" path="FechaCreacionObjeto" value = "${dateString}"/>
					<br>	
				
					<fmt:formatDate value="${objeto.fechaObtencionObjeto}" var="date2String" pattern="yyyy-MM-dd" />
					<label>Obtenido El:</label>
					<form:input type="date" class="form-control" path="FechaObtencionObjeto" value = "${date2String}"/>
					<br>	
					
					<label>Longitud: </label>
					<form:input path="LongitudObjeto" class="form-control"  type="number" value = "${objeto.longitudObjeto}"/>
					<br>
					
					<label>Ancho: </label>
					<form:input path="AnchoObjeto"  class="form-control" type="number" value = "${objeto.anchoObjeto}"/> 
					<br>
			
					<label>Altura: </label>
					<form:input path="AlturaObjeto"  class="form-control" type="number" value = "${objeto.alturaObjeto}"/> 
					<br>
					
					<label>Área: </label>
					<form:input path="AreaObjeto"  class="form-control" type="number" value = "${objeto.areaObjeto}"/> 
					<br>
					
					<label>Vida: </label>
					<form:input path="VidaObjeto"  class="form-control" type="number" value = "${objeto.vidaObjeto}"/> 
					<br>
					
					<a class="btn btn-danger pull-left" href="/objeto">Cancelar</a>
					<button type="submit" class="btn-lg btn-primary pull-right">Actualizar</button>
				
				</form:form>
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

</body>
</html>