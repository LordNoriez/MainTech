<head>
    <title>Editar Equipo</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Editar Equipo</h4>
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
			
			<div class=" col-md-8">
				<h4 class="text-muted">Agregar Actividades: </h4>
		
				<a class="btn-lg btn-primary pull-left" href="/ObjetoActividad/${objeto.idObjeto}">Agregar</a>	
			</div>
			
			<div class=" col-md-8"  >
			
				<spring:url value="/updateObjeto/${objeto.idObjeto}" var="variableAdd" />
			
				<form:form method="PUT" modelAttribute="objeto" action="${variableAdd}">
					
					<div>
					<div style="float:left;width:50%;">
					<label>Descripción:</label>
					<form:input type="text" class="form-control" path="DescripcionObjeto" value = "${objeto.descripcionObjeto}"/>
					</div>
					<div style="float:left;width:50%;">			
					<label>Marca:</label>
					<form:input type="text" class="form-control" path="MarcaObjeto" value = "${objeto.marcaObjeto}"/>	
					</div>
					</div>
					<br>
					
					<div>
					<div style="float:left;width:50%;">
					<label>Modelo:</label>
					<form:input type="text" class="form-control" path="ModeloObjeto" value = "${objeto.modeloObjeto}"/>
					</div>
					<div style="float:left;width:50%;">	
					<label>Serial:</label>
					<form:input type="text" class="form-control" path="SerialObjeto" value = "${objeto.serialObjeto}"/>
					</div>
					</div>
					<br>	
					
					<div>
					<div style="float:left;width:50%;">		
					<label>Categoría:</label>
					<form:select class="form-control" path="categoria">
						<form:option value="" label="--- Select ---" />
						<form:options items="${categories}" itemLabel="NombreCategoria" itemValue="idCategoria" />
					</form:select>
					</div>
					<div style="float:left;width:50%;">	
					<label>Color: </label>						        
					<form:select class="form-control" path="color">
						<form:options items="${colores}" itemLabel="nombreColor" itemValue="idColor" />
					</form:select>
					</div>
					</div>
					<br>
					
					<div>
					<div style="float:left;width:50%;">	
					<label>Estructura: </label>						        
					<form:select class="form-control" path="estructura">
						<form:options items="${estructuras}" itemLabel="nombreEstructura" itemValue="idEstructura" />
					</form:select>
					</div>
					<div style="float:left;width:50%;">				
					<label>Equipo Padre:</label>
					<form:select class="form-control" path="objetoPadre" onchange="document.getElementById('objtPadre').value = this.value;">
						<form:option value="" label="--- Select ---" itemValue=""/>
						<form:options items="${objects}" itemLabel="DescripcionObjeto" itemValue="idObjeto" />
					</form:select>
					<form:input type="hidden" path="objetoPadre" id = "objtPadre" /> 
					</div>
					</div>
					<br>	
			
					<div>
					<div style="float:left;width:33.3%;">	
					<fmt:formatDate value="${objeto.fechaCreacionObjeto}" var="dateString" pattern="yyyy-MM-dd" />
					<label>Creado El:</label>
					<form:input type="date" class="form-control" path="FechaCreacionObjeto" value = "${dateString}"/>
					</div>
					<div style="float:left;width:33.3%;">		
					<fmt:formatDate value="${objeto.fechaObtencionObjeto}" var="date2String" pattern="yyyy-MM-dd" />
					<label>Obtenido El:</label>
					<form:input type="date" class="form-control" path="FechaObtencionObjeto" value = "${date2String}"/>
					</div>
					<div style="float:left;width:33.3%;">
					<label>Vida: </label>
					<form:input path="VidaObjeto"  class="form-control" type="number" value = "${objeto.vidaObjeto}"/> 
					</div>					
					</div>
					<br>
					
					<div>
					<div style="float:left;width:25%;">	
					<label>Longitud: </label>
					<form:input path="LongitudObjeto" class="form-control"  type="number" value = "${objeto.longitudObjeto}"/>
					</div>
					<div style="float:left;width:25%;">
					<label>Ancho: </label>
					<form:input path="AnchoObjeto"  class="form-control" type="number" value = "${objeto.anchoObjeto}"/> 
					</div>
					<div style="float:left;width:25%;">
					<label>Altura: </label>
					<form:input path="AlturaObjeto"  class="form-control" type="number" value = "${objeto.alturaObjeto}"/> 
					</div>
					<div style="float:left;width:25%;">
					<label>Área: </label>
					<form:input path="AreaObjeto"  class="form-control" type="number" value = "${objeto.areaObjeto}"/> 
					</div></div>
					<br>
					
					<a class="btn btn-danger pull-left" href="/objeto">Cancelar</a>
					<button type="submit" class="btn-lg btn-primary pull-right">Actualizar</button>
				
				</form:form>
			</div>
				
			
		</div>
	
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>