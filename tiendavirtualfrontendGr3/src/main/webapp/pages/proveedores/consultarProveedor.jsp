<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
<%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="../../assets/css/usuarios.css">
<link rel="stylesheet" href="../../assets/css/proveedores.css">
<link rel="stylesheet" href="../../assets/css/tabla.css">
<link rel="stylesheet" href="../../assets/css/admin.css">
<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
<title>Clientes</title>
</head>
<body>       
	<c:set var="url" value="tiendavirtualfrontendGr3"></c:set>    	
	<c:import url="../../imports/sidebar.jsp"></c:import>
    <div class="crud-container">
        <div class="crud proveedores">
            <div class="users-form-container">
                <form class="form-agregar" action="/consultarProveedor" method="post">
                    <label class="label-form" for="nit"><i class="fas far fa-id-card"></i>NIT Proveedor</label>
                    <input class="input-form" id="nit" type="text" name="nit" autocomplete="off">
                    
                    <div class="button-container">
                        <input class="button-form" type="submit" value="Consultar">
                        <a href="/pages/proveedores/proveedores.jsp" class="button-form" >Volver</a>                        
                    </div>
                </form>
                 <c:choose>
               		<c:when test="${proveedor.nombre!=null}">
						<div id="main-container">
							<table>
								<thead id="cabecera">
									<tr>
										<th class="izquierda">NIT</th>
										<th>Ciudad</th>
										<th>Direccion</th>
										<th>Nombre</th>
										<th class="derecha">Telefono</th>	
									</tr>
								</thead>
								<tr>
									<td>${proveedor.nit}</td>
									<td>${proveedor.ciudad}</td>
									<td>${proveedor.direccion}</td>
									<td>${proveedor.nombre}</td>
									<td>${proveedor.telefono}</td>
								</tr>
							</table>
						</div>
               		</c:when>
               	</c:choose>	
            </div>
    	</div> 
	</div>
</body>
</html>