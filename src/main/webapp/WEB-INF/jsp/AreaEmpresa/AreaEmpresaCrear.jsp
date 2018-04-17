<head>
    <title>Crear �rea de Empresa</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Crear �rea de Empresa</h4>
		        </div>
		    </div>
		</div>
     <div id="mySidenav" class="sidenav">
		  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		  <a class="active" id="home" href="/google/login">Inicio</a>
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
		  <a href="/reporteRol">V�culo con Roles</a>
		  <a href="/crearReporteRol">V�cular con Roles</a>
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
			    
			    					
				<button type="button" onclick="openNav()" class="btn btn-info btn-block">Men�</button>				
					
			</div>					
			
			<div class=" col-md-8"  >
				<spring:url value="/addAreaEmpresa" var="variableAdd" />
			
				<form:form method="post" modelAttribute="crearModelAreaEmpresa" action="${variableAdd}">
					<label>Nombre: </label>
					<form:input path="NombreAreaEmpresa" class="form-control" type="text" /> <!-- bind to user.name-->
					<form:errors path="NombreAreaEmpresa" />
					<br>
					
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar</button>
				</form:form>
	        </div>
		</div>
	
		
	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Se Ingres� Correctamente</div>	
        
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>