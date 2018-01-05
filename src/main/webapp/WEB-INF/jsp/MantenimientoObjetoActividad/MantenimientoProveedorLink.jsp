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
    <title>Crear Mantenimiento</title>
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
		<!-- Login panel -->
		<div class="row">
			<div class=" col-md-12">		
				<div class="header clearfix">
			        <div class=" col-md-6">
			        	<h2 class="text-muted">MainTech</h2>						
				        <h4 class="text-muted">Asignar Proveedor al Mantenimiento</h4>
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
							
				<spring:url value="/LinkMantActividad" var="variableAdd" />
				<form:form method="post" modelAttribute="crearModelMantenimiento" action="${variableAdd}">
					
					<label>Mantenimiento: </label>
					<form:select class= "form-control" path="mantenimientos">
						<form:option label="${groupMant.getNombreMantenimiento()}" value="${groupMant.getIdMantenimiento()}" />
					</form:select>	
					<br>
					
					<label>Equipo: </label>
					<form:select class= "form-control" path="idobjeto">
						<form:option label="${idobjeto.getDescripcionObjeto()}" value="${idobjeto.getIdObjeto()}" />
					</form:select>					
					<br>
					
					<label>Cantidad: </label>					
					<form:input type="number" path="cantidadMantenimiento" class="form-control" readonly="true" />					
					<br>
					
					<label>Proveedores: </label>
					       <form:select name="Proveedores" class="form-control" path="listIdProveedor">
					          <c:forEach var="item" items="${Proveedores}">
					            <option value="${item[1].toString()}">${item[0].toString()}</option>
					          </c:forEach>
					        </form:select>			
					<br>
					
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Siguiente</button>
				</form:form>
	        </div>
		</div>
		
	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Seleccione Actividades a Realizar</div>
        

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
	
	<script type="text/javascript">
	     function configureDropDownLists(ddl1,ddl2) {
	    var colours = ['Black', 'White', 'Blue'];
	    var shapes = ['Square', 'Circle', 'Triangle'];
	    var names = ['John', 'David', 'Sarah'];
	
	    switch (ddl1.value) {
	        case 'Colours':
	            ddl2.options.length = 0;
	            for (i = 0; i < colours.length; i++) {
	                createOption(ddl2, colours[i], colours[i]);
	            }
	            break;
	        case 'Shapes':
	            ddl2.options.length = 0; 
	        for (i = 0; i < shapes.length; i++) {
	            createOption(ddl2, shapes[i], shapes[i]);
	            }
	            break;
	        case 'Names':
	            ddl2.options.length = 0;
	            for (i = 0; i < names.length; i++) {
	                createOption(ddl2, names[i], names[i]);
	            }
	            break;
	            default:
	                ddl2.options.length = 0;
	            break;
	    }​

	}
	
	    function createOption(ddl, text, value) {
	        var opt = document.createElement('option');
	        opt.value = value;
	        opt.text = text;
	        ddl.options.add(opt);
	    }
	    
	    
	</script>
	
	<script type="text/javascript">
        function callMe(objtoid) {
            var districtId = objtoid.value;
          
            $.ajax({
                type: "POST",
                url: "someUrl",
                dataType: "json",
                data: {
                    varname1 : "varvalue1",
                    varname2 : "varvalue2"
                },
                success: function (data) {
                    $('#ddl2').empty(); // empty existing list
                    $('#ddl2').append('<option value="">Some Label</option>');
                    $.each(data, function (varvalue, vartext){
                        $('#ddl2').append($('<option></option>').val(varvalue).html(vartext));
                    });  
                }
            });
        }    
    </script> 

</body>
</html>