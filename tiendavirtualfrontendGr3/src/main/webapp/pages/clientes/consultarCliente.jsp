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
<link rel="stylesheet" href="../../assets/css/clientes.css">
<link rel="stylesheet" href="../../assets/css/tabla.css">
<link rel="stylesheet" href="../../assets/css/admin.css">
<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
<title>Clientes</title>
</head>
<body>     
	<c:set var="url" value="tiendavirtualfrontendGr3"></c:set>         	
	<c:import url="../../imports/sidebar.jsp"></c:import>
    <div class="crud-container">
        <div class="crud clients">
            <div class="users-form-container clients-form-container">
                <form class="form-agregar" action="/consultarCliente" method="post">
                    <label class="label-form" for="cedula"><i class="fas far fa-id-card"></i>Cédula Cliente</label>
                    <input class="input-form" id="cedula" type="text" name="cedula" autocomplete="off" >
                    
                    <div class="button-container">
                        <input class="button-form" type="submit" value="Consultar" >
                        <a href="/pages/clientes/clientes.jsp" class="button-form">Volver</a>                     
                    </div>
                </form>
                <c:choose>
               		<c:when test="${cliente.nombre!=null}">
						<div id="main-container">
							<table>
								<thead id="cabecera">
									<tr>
										<th class="izquierda">Cedula</th>
										<th>Direccion</th>
										<th>Email</th>
										<th>Nombre</th>
										<th class="derecha">Telefono</th>	
									</tr>
								</thead>
								<tr>
									<td>${cliente.cedula}</td>
									<td>${cliente.direccion}</td>
									<td>${cliente.email}</td>
									<td>${cliente.nombre}</td>
									<td>${cliente.telefono}</td>
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