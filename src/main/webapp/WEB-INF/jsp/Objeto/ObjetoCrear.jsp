<head>
    <title>Crear Equipo</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Crear Equipo</h4>
		        </div>
		    </div>
		</div>
					
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
				<spring:url value="/addObjeto" var="variableAdd" />
			
			 	<form:form method="POST" modelAttribute="crearModelObjeto" action="${variableAdd}" id="myForm"> 
					
					<label>Área de la Empresa: </label>						        
					<form:select class="form-control" path="AreaEmpresa">
						<form:option value="" label="--- Seleccionar ---" />
						<form:options items="${areas}" itemLabel="NombreAreaEmpresa" itemValue="idAreaEmpresa" />
					</form:select>
					<br>
					
					<label>Descripción: </label>
					<form:input path="DescripcionObjeto" class="form-control"  type="text" />
					<form:errors path="DescripcionObjeto" />
					<br>
										
					<label>Marca:</label>
					<form:input path="MarcaObjeto" class="form-control" type="text" /> 
					<form:errors path="MarcaObjeto" />
					<br>
					
					<label>Modelo: </label>
					<form:input path="ModeloObjeto"  class="form-control" type="text" /> 
					<form:errors path="ModeloObjeto" />
					<br>
					
					<label>Serial: </label>
					<form:input path="SerialObjeto"  class="form-control" type="text" /> 
					<form:errors path="SerialObjeto" />
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
										
					<label>Categoría: </label>						        
					<form:select class="form-control" path="categoria">
						<form:options items="${categories}" itemLabel="NombreCategoria" itemValue="idCategoria" />
					</form:select>
					<br>
					
					<label>Equipo Padre: </label>
					<form:select class="form-control" path="objetoPadre" onchange="document.getElementById('objtPadre').value = this.value;">
						<form:option value="" label="--- Select ---" itemValue=""/>
						<form:options items="${objects}" itemLabel="DescripcionObjeto" itemValue="idObjeto" />
					</form:select>
					<br>
			
			<!-- 		<select id="objPadreInput" name="titleId" onchange="document.getElementById('objtPadre').value = this.value;"> -->
			<!-- 		    <option value="NULL" label="--- Select ---" /> -->
			<%-- 		    <c:forEach items="${objects}" var="objs"> --%>
			<%-- 		            <option value="${objs.idObjeto}" selected>${objs.marcaObjeto}</option> --%>
			<%-- 		    </c:forEach> --%>
			<!-- 		</select> -->
					
			<!--  used for take the id and then assign it to the Objeto -->
					<form:input type="hidden" path="objetoPadre" id = "objtPadre" /> 
					
					
					<label>Creado El: </label>
					<form:input path="FechaCreacionObjeto"  class="form-control" type="date" /> 
					<form:errors path="FechaCreacionObjeto" />
					<br>
					
					<label>Obtenido El: </label>
					<form:input path="FechaObtencionObjeto" class="form-control"  type="date" /> 
					<form:errors path="FechaObtencionObjeto" />
					<br>
					
					<label>Longitud: </label>
					<form:input path="LongitudObjeto" class="form-control"  type="number" /> 
					<form:errors path="LongitudObjeto" />
					<br>
					
					<label>Ancho: </label>
					<form:input path="AnchoObjeto"  class="form-control" type="number" /> 
					<form:errors path="AnchoObjeto" />
					<br>
			
					<label>Altura: </label>
					<form:input path="AlturaObjeto"  class="form-control" type="number" /> 
					<form:errors path="AlturaObjeto" />
					<br>
					
					<label>Área: </label>
					<form:input path="AreaObjeto"  class="form-control" type="number" /> 
					<form:errors path="AreaObjeto" />
					<br>
					
					<label>Vida: </label>
					<form:input path="VidaObjeto"  class="form-control" type="number" /> 
					<form:errors path="VidaObjeto" />	
					<br>
					
			
					<br>
					<button onclick="snackBarFunction()" type="submit" class="btn-lg btn-primary pull-right">Ingresar
			                             </button>
				</form:form>
			</div>
		</div>
	
		
	        <!-- The actual snackbar -->
        <div id="snackbar" class="alert alert-success">Se Ingresó Correctamente</div>	
        
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>