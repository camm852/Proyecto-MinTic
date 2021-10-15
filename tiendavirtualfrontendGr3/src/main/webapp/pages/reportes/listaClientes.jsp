<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
<%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller.*" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="ISO-8859-1">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="../../assets/css/tabla.css">
<link rel="stylesheet" href="../../assets/css/listado.css">
<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
<title>Listado Usuario</title>
</head>
<body>
	<c:import url="../../imports/sidebar.jsp"></c:import>
	
	<form name="consultaClienteForm" action="/listarClientes" method="post">
	</form>
	<div class="listado-container">
		<div class="tittle-container">
			<h2 class="tittle">Listado de clientes</h2>
		</div>
		<div id="main-container">
			<table name="tablaListado">
				<thead id="cabecera">
					<tr>
						<th class="izquierda">cedula</td>
						<th>direccion</td>
						<th>email</td>
						<th>Nombre</td>
						<th class="derecha">Telefono</td>
						
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${clientes}" var="cli">
					<tr>
						<td>${cli.cedula}</td>
						<td>${cli.direccion}</td>
						<td>${cli.email}</td>
						<td>${cli.nombre}</td>
						<td>${cli.telefono}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>