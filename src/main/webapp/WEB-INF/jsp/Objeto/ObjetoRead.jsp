<head>
    <title>Ver Equipos</title>
    <%@ include file="/WEB-INF/jsp/Master/Head.jsp" %>
</head>
<body ng-app="MainTech" ng-controller="AppCtrl" ng-cloak>
    
		<div class=" col-md-12">		
			<div class="header clearfix">
		        <div class=" col-md-6">
		        <h4 class="text-muted">Ver Equipos</h4>
		        </div>
		    </div>
		</div>

    <%@ include file="/WEB-INF/jsp/Master/Menu.jsp" %>
	
	<div class="container-fluid" id="main">
    
    <!--<div class="container" style="margin-top: 50px;">-->
		<!-- Login panel -->
		
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
				<div class="form-horizontal">
					<div class="input-group">
					  <span class="input-group-btn">
				    <button class="w3-button w3-teal" onclick="location.href = '/crearObjeto'">+</button>
					  </span>
				      <input class="form-control" id="myInput" type="text" placeholder="Buscar..">
					</div>
				</div>
				<br>
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Descripción</th>
							<th>Marca</th>
							<th>Modelo</th>
							<th>Stock</th>
							<th>En Mantenimiento</th>
							<th>Categoría</th>
							<th>Padre</th>
						</tr>
					</thead>
    				<tbody id="myTable"> 
		
					<c:forEach var="objeto" items="${objetos}">
					    <tr>
						
					    <c:set var = "ob" scope = "session" value = "${objeto[8].toString()}"/>
					    <c:if test="${empty ob}">
					    	<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';"> - </td>
						</c:if>
						<c:if test="${not empty ob}">
						    <td onClick="document.location.href='/objetoById/${objeto[2].toString()}';">${objeto[8].toString()}</td>
						</c:if>
						
					    <c:set var = "ob" scope = "session" value = "${objeto[3].toString()}"/>
					    <c:if test="${empty ob}">
					    	<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';"> - </td>
						</c:if>
						<c:if test="${not empty ob}">
						    <td onClick="document.location.href='/objetoById/${objeto[2].toString()}';">${objeto[3].toString()}</td>
						</c:if>
						
					    <c:set var = "ob" scope = "session" value = "${objeto[4].toString()}"/>
					    <c:if test="${empty ob}">
					    	<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';"> - </td>
						</c:if>
						<c:if test="${not empty ob}">
							<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';">${objeto[4].toString()}</td>
						</c:if>
						
					    <c:set var = "ob" scope = "session" value = "${objeto[0].toString()}"/>
					    <c:if test="${empty ob}">
					    	<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';"> - </td>
						</c:if>
						<c:if test="${not empty ob}">
						    <td onClick="document.location.href='/objetoById/${objeto[2].toString()}';">${objeto[0].toString()}</td>
						</c:if>
						
					    <c:set var = "ob" scope = "session" value = "${objeto[1].toString()}"/>
					    <c:if test="${empty ob}">
					    	<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';"> - </td>
						</c:if>
						<c:if test="${not empty ob}">
						    <td onClick="document.location.href='/objetoById/${objeto[2].toString()}';">${objeto[1].toString()}</td>
						</c:if>
						
					    <c:set var = "ob" scope = "session" value = "${objeto[11].toString()}"/>
					    <c:if test="${empty ob}">
					    	<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';"> - </td>
						</c:if>
						<c:if test="${not empty ob}">
							<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';">${objeto[11].toString()}</td>
						</c:if>
						
					    <c:set var = "ob" scope = "session" value = "${objeto[12].toString()}"/>
					    <c:if test="${empty ob}">
					    	<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';"> - </td>
						</c:if>
						<c:if test="${not empty ob}">
							<td onClick="document.location.href='/objetoById/${objeto[2].toString()}';">${objeto[13].toString()}</td>
						</c:if>
<!-- 						<td> -->
<%-- 						  <spring:url value="/deleteObjeto/${objeto[2]}" var="deleteUrl" /> --%>
<%-- 						  <spring:url value="/objeto/${objeto[2]}" var="updateUrl" /> --%>
		
<!-- 						  <button class="btn btn-primary" -->
<%-- 		                                          onclick="location.href='${updateUrl}'">Update</button> --%>
		                                                                             
<%-- 						  <button onclick="location.href='${deleteUrl}'; setTimeout(snackBarFunction(),5000);" class="btn btn-danger">Delete</button> --%>
<%-- 		                                          onclick="this.disabled=true;post('${deleteUrl}')">Delete</button> --%>
		                                          
<!-- 		                                </td> -->
					    </tr>
					</c:forEach>
					</tbody>
				</table>
			</div>

	</div>
	
	<div id="snackbar" class="alert alert-danger">Equipo Eliminado Correctamente</div>
	
	
	<%@ include file="/WEB-INF/jsp/Master/Footer.jsp" %>
</div>
</body>