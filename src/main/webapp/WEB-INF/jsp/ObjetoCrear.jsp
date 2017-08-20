<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
 	<title>Crear Objeto</title>
	<c:url value="/css/main.css" var="jstlCss" />
	
	<link href="${jstlCss}" rel="stylesheet" />
</head>
<body>
	
	
	<div class="container">

  		<form method="post" action="/objeto">
  	          <table>
                <tr>
                    <td>Serial:</td>
                    <td><input id="SerialObjeto" name="SerialObjeto" type="text"/></td>
                </tr>
                <tr>
                    <td>Marca:</td>                    
                    <td><input id="MarcaObjeto" name="MarcaObjeto" type="text" /></td>
                </tr>
                <tr>
                    <td>Modelo:</td>            
                    <td><input id="ModeloObjeto" name="ModeloObjeto" type="text"/></td>
                </tr>
                <tr>
                    <td>Descripcion:</td> 
                    <td><input id="DescripcionObjeto" name="DescripcionObjeto" type="text" /></td>
                </tr>
                <tr>
                    <td>Longitud:</td>
                    <td><input id="LongitudObjeto" name="LongitudObjeto" type="number" /></td>
                </tr>
                <tr>
                    <td>Ancho:</td>
                    <td><input id="AnchoObjeto" name="AnchoObjeto" type="number" /></td>
                </tr>
                <tr>
                    <td>Altura:</td>
                    <td><input id="AlturaObjeto" name="AlturaObjeto" type="number" /></td>
                </tr>
                <tr>
                    <td>√Årea:</td>
                    <td><input id="AreaObjeto" name="AreaObjeto" type="number" /></td>
                </tr>
                <tr>
                    <td>Vida ⁄til:</td>   
                    <td><input id="VidaObjeto" name="VidaObjeto" type="number" /></td>
                </tr>
                <tr>
                    <td>Fecha ObtenciÛn:</td>
                    <td><input id="FechaObtencionObjeto" name="FechaObtencionObjeto" type="text" placeholder="yyyy/mm/dd"/></td>
                </tr>
                <tr>    
                    <td>CategorÌa:</td>
                	<td>            	
	                	<select name="categoria" id="categoria">
	                		<c:forEach var="categoria" items="${categories}">
						 		<option value ="${categoria.getIdCategoria()}">${categoria.getNombreCategoria()}</option>
						 	</c:forEach>
						</select>
					</td> 
                </tr>
                <tr>
                    <td><button type="submit">Crear Objeto</button></td>
                </tr>
            </table>
        </form>
	</div>
</body>
</html>