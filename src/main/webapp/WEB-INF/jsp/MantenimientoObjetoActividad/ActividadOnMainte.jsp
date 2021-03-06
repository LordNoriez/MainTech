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
    <title>Actividades</title>
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
		  <p>Categor�as
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
				        <h4 class="text-muted">Actividades del mantenimiento: ${varMantenmiento.nombreMantenimiento}</h4>
			        </div>
			    </div>
			</div>
		</div>
<!-- 		<div class="row"> -->
<!-- 			<div class=" col-md-3"> -->
<!-- 				<div class="jumbotron">						 -->
<!-- 					<img class="p-img" alt="" src="{{user.userAuthentication.details.picture}}"> -->
<!-- 					<h5>{{user.userAuthentication.details.name}}</h5> -->
<!-- 					<h6>{{user.userAuthentication.details.email}}</h6>		 -->
<!-- 					<a href="/logout">Salir</a>		         -->
<!-- 			    </div>	 -->
			    
			    					
<!-- 				<button type="button" onclick="openNav()" class="btn btn-info btn-block">Men�</button>				 -->
				
<!-- 			</div> -->
				<div class=" col-md-8 table-responsive" style="width: 100%;">
				<form action="/mantActProvUpdated/${varMantenmiento.idMantenimiento}" method="post">
				<c:set var = "numtr" scope = "session" value = "${1}"/>
								
				<table class="table table-striped table-hover">
				<tbody id="TblActividades">
				  <c:forEach items="${ActividadesxMante}" var="Actividades" varStatus="rowCounter">
				  
				    <c:if test="${rowCounter.count % 3 == 1}">
				      <tr id="trid${numtr}">
				    </c:if>
				    <td style = "border-left: 1px solid #ddd;" onClick="deletecell(this,'trid${numtr}')">${Actividades[1].toString()}<br>
				    <p style = "font-size:10px; color: rgb(182,182,182);margin-bottom: 1%;">${Actividades[2].toString()}</p>
				    <p style = "font-size:10px; color: #0029ffa6;margin-bottom: 0%;">${Actividades[4].toString()}</p>
				    <input type="hidden"  name="foo" value="${Actividades[0].toString()}|${Actividades[3].toString()}|${Actividades[4].toString()}" ></td>
				    <c:if test="${rowCounter.count % 3 == 0||rowCounter.count == fn:length(values)}">
				      </tr>
				       <c:set var="numtr" value="${numtr + 1}"/>
				    </c:if>
				  </c:forEach >
				  </tbody>
				</table>
				
				
			
					<a class="btn btn-danger pull-left" href="/mantenimientobyId/${varMantenmiento.idMantenimiento}">Cancelar</a>
					<button type="submit" class="btn-lg btn-primary pull-right">Aceptar</button>
				
				</form>
				</div>
				<div class="alert alert-danger" id="form-errors"></div>

			
			<div class=" col-md-8 table-responsive" style="width: 100%;" >

				<div style="float:left;width:48%;border: 1px solid #cecccf;border-radius: 8px;margin-right: 1%;">
				<input class="form-control" id="myInput2" type="text" onkeyup="myFunction2()" placeholder="Buscar.. Proveedor">
				</div>
				<br>
				

				<label onclick="blabla()"> a�adir tabla </label>
				
				
				
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Proveedor</th>
						</tr>
					</thead>
    				<tbody id="myTableProveedor">
		
					<c:forEach var="AllProveedores" items="${AllProveedor}">
						
						<tr>
						    <td onclick="searchActividad(${AllProveedores.idProveedor})">${AllProveedores.nombreProveedor} </td>
						    <td onclick="searchActividad(${AllProveedores.idProveedor})" style="display:none;">
						    <span style="visibility:hidden">${AllProveedores.idProveedor} </span></td>
						
					    </tr>
					</c:forEach>
					</tbody>
				</table>
				
				<div style="float:left;width:48%;border: 1px solid #cecccf;border-radius: 8px;margin-right: 1%;">
				<input class="form-control" id="myInput" type="text" onkeyup="myFunction()" placeholder="Buscar.. Actividad">
				</div>
				
				<input class="form-control" id="myInput3" type="hidden" onkeyup="myFunction3()" placeholder="filtrar por proveedor id">
				
				
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Actividad</th>
							<th><span style="visibility:hidden">idproveedor</span></th>
							<th>Costo</th>
						</tr>
					</thead>
    				<tbody id="myTable">
		
<%-- 					<c:forEach var="AllActividades" items="${AllActividad}"> --%>
						
<!-- 						<tr> -->
						
<%-- 						    <td>${AllActividades[1].toString()} </td> --%>
<%--						    <td><span style="visibility:hidden">${AllActividades[2].toString()}</span></td> --%>
<%-- 						    <td>${AllActividades[2].toString()}</td> --%>
<%-- 						    <td>${AllActividades[4].toString()} </td> --%>
						
<!-- 					    </tr> -->
<%-- 					</c:forEach> --%>
					</tbody>
				</table>
				
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

// 	$(document).ready(function(){
// 	  $("#myInput").on("keyup", function() {
// 	    var value = $(this).val().toLowerCase();
// 	    $("#myTable tr").filter(function() {
// 	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
// 	    });
// 	  });
// 	});
	
	
	function myFunction() {
		  // Declare variables 
		  var input, filter, table, tr, td, i;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");

		  // Loop through all table rows, and hide those who don't match the search query
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[0];
		    if (td) {
		      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
		    	  tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    } 
		  }
		}
	
	function myFunction2() {
		  // Declare variables 
		  var input, filter, table, tr, td, i;
		  input = document.getElementById("myInput2");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTableProveedor");
		  tr = table.getElementsByTagName("tr");

		  // Loop through all table rows, and hide those who don't match the search query
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[0];
		    if (td) {
		      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
		    	  tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    } 
		  }
		}

	function myFunction3() {
		  // Declare variables 
		  var input, filter, table, tr, td, i;
		  input = document.getElementById("myInput3");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");

		  // Loop through all table rows, and hide those who don't match the search query
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[1];
		    if (td) {
		      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
		    	  tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    } 
		  }
		}
		
	
    function D(lol) {
        document.getElementById('myInput3').value = lol;
        myFunction3();
     }
    
    function deletecell(elem,tridnum){

    		if ($('#TblActividades tr').children().length == 1) {
    		    document.getElementById("form-errors").innerHTML = "Debe estar Seleccionado al menos 1 actividad";
    		    
    		    var x = document.getElementById("form-errors")

        	    // Add the "show" class to DIV
        	    x.className = "show";

        	    // After 3 seconds, remove the show class from DIV
        	    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 2000);
    		}else {
        		var row = document.getElementById(tridnum);
        		for(i=0;i<row.children.length;i++) {
    	    		if(row.children[i]==elem) {
    	    		row.deleteCell(i);
    	
    	    		}
        		}
    		}
    		deleteIfTrEmpty();
    }
    
    function deleteIfTrEmpty(){
    	
    	$('#TblActividades tr').each(function() {
    		  if($(this).find('td').length == 0) {
    		   // empty tr
    		   // id of tr is available through this.id
    		   document.getElementById(this.id).remove();
    		  }
    		});
    }
    
    function ifTrHas1or2(){
    	var aux = 0;
    	$('#TblActividades tr').each(function() {
				aux = aux + 1;
    		});
    	
    	if (aux == 1){
    		
    		if($('#TblActividades tr').find('td').length == 1){
    			return 1;
    		}
    		if($('#TblActividades tr').find('td').length == 2){
    			return 2;
    		}
    	}
    }
    
    function lastTrId(){
    	var trids = [];
    	
    	$('#TblActividades tr').each(function() {
    		  
    		   // empty tr
    		   // id of tr is available through this.id
    		   var str = this.id;
    		   
    		   trids.push(str.substring(4));
    		});
    	
    	trids.sort(function(a, b){return a - b});
    	
    	return trids[trids.length - 1];
    	
    }
    
    
    function addActividad(idActividad,IdProveedor,IdCosto,DescProveedor,DescActividad){
    	
    	var auxTabla = parseInt(lastTrId());
    	var auxtr1or2 = ifTrHas1or2();
    	
    	var rows = $('#TblActividades tr').length
    	var colum = $('#TblActividades td').length

    	var isthere = itExist(idActividad + '|' + IdProveedor + '|' + IdCosto); 
    	
    	if(isthere == 0){
    		if(auxtr1or2 == 1 || auxtr1or2 == 2){    			
	    		$('#trid' + auxTabla).append('<td onClick="deletecell(this,\'trid' + auxTabla + '\')">' + DescActividad + '<p style = "font-size:10px; color: rgb(182,182,182);margin-bottom: 1%;">' + DescProveedor + '</p><p style = "font-size:10px; color: #0029ffa6;margin-bottom: 0%;">' + IdCosto + '</p><input type="hidden" name="foo" value="' + idActividad + '|' + IdProveedor + '|' + IdCosto + '"></td>')
    		}else{
		    	if (colum % 3 == 0) {
		        	auxTabla = auxTabla + 1 ;
		    		$('#TblActividades').append('<tr id=\"trid' + auxTabla + '\"><td onClick="deletecell(this,\'trid' + auxTabla + '\')">' + DescActividad + '<p style = "font-size:10px; color: rgb(182,182,182);margin-bottom: 1%;">' + DescProveedor + '</p><p style = "font-size:10px; color: #0029ffa6;margin-bottom: 0%;">' + IdCosto + '</p><input type="hidden" name="foo" value="' + idActividad + '|' + IdProveedor + '|' + IdCosto + '"></td></tr>');
		    	}else{
		    		//$('#trid' + auxTabla).append('<td onClick="deletecell(this,\'trid' + auxTabla + '\')"><input type="text" name="foo" value="' + idActividad + '"><input type="text" name="foo" value="' + IdProveedor + '"><input type="text" name="foo" value="' + IdCosto + '"></td>')
		    		$('#trid' + auxTabla).append('<td onClick="deletecell(this,\'trid' + auxTabla + '\')">' + DescActividad + '<p style = "font-size:10px; color: rgb(182,182,182);margin-bottom: 1%;">' + DescProveedor + '</p><p style = "font-size:10px; color: #0029ffa6;margin-bottom: 0%;">' + IdCosto + '</p><input type="hidden" name="foo" value="' + idActividad + '|' + IdProveedor + '|' + IdCosto + '"></td>')
		    	}
	    	}
    	}else{
    		document.getElementById("form-errors").innerHTML = "Ya consta en el listado de actividades";
    	    var x = document.getElementById("form-errors")
    	    x.className = "show";
    	    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 2000);
    	}
    }
    
    function borrartbl() {
    	var elmtTable = document.getElementById('myTable');
    	var tableRows = elmtTable.getElementsByTagName('tr');
    	var rowCount = tableRows.length;
	
    	
    	var tbody = $("#incidents tbody");

       	for (var x=rowCount-1; x>-1; x--) {
   	   		elmtTable.removeChild(tableRows[x]);
       	}	
    }
    
    function itExist(dataxCompar) {        
	     
    	 var aux = 0;
	     var table = document.getElementById('TblActividades');

	     var rowLength = table.rows.length;
	     
		 
	     for(var i=0; i<rowLength; i+=1){
	       var row = table.rows[i];

	       //your code goes here, looping over every row.
	       //cells are accessed as easy

	       var cellLength = row.cells.length;
	       for(var y=0; y<cellLength; y+=1){
	         var cell = row.cells[y];

	         //do something with every cell here
	         var iupdated = i + 1;
	         var data = $('#defaulttrid' + iupdated).find("td:eq(" + y + ") input[type='text']").val();
	         var data2 = $('#trid' + iupdated).find("td:eq(" + y + ") input[type='text']").val();
			if(dataxCompar == data){
				aux = aux + 1 ;
			}
			if(dataxCompar == data2){
				aux = aux + 1 ;
			}
	       }
	     }
	     return aux;
    }
    
    function searchActividad(idProveedor) {
        // set variables into javascript object which you need to send to spring controller
        // the variable name here should be same as it is in your java class UserDetails.java

        //var user = new String();
        //user = "hello"; // id of user to be deleted
        borrartbl();
        
        $.ajax({
            type : 'POST',
            url : '/actcostxprov',
            dataType : 'json',
            data : JSON.stringify(idProveedor),
            contentType : 'application/json',
            success : function(data) {
               //here in data variable, you will get list of all users sent from 
               // spring controller in json format, currently its object
               // iterate it and show users on page

               showUsers(data);
            },
            error : function() {
                alert('error');
            }
        });
    }

    function showUsers(data) {
        // and here you show users on page
        //following code just example

        
            for ( var i = 0, len = data.length; i < len; ++i) {
                var objeto = data[i];
                //$('#myTable').append("<tr><td>" + objeto[1].toString() + "</td><td><span style=\"visibility:hidden\">" + objeto[2].toString() + "</span></td><td>$" + objeto[4].toString() + "</td></tr>");
                $('#myTable').append("<tr><td onClick=\"addActividad(" + objeto[0].toString() + "," + objeto[2].toString() + "," + objeto[4].toString() + ",\'" + objeto[5].toString() + "\',\'" + objeto[1].toString() + "\')\">" + objeto[1].toString() + "</td><td><span style=\"visibility:hidden\">" + objeto[2].toString() + "</span></td><td>$" + objeto[4].toString() + "</td></tr>");
        }
    }
	</script>

</body>
</html>