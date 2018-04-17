<head>
    <title>Error</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Error!</h4>
		        </div>
		    </div>
		</div>
	<div class="container-fluid">
    
		
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
						<h2>Men�</h2>
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
<!-- 							<a class="btn btn-default btn-block" ng-show="user" href="/categoria">Categor�as</a> -->
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
							<a class="btn btn-default btn-block" ng-show="user" href="/areaEmpresa">�reas de Empresa</a>
						</div>				
					</div>
				</div>				
			</div>
	    </div>
		
    
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>