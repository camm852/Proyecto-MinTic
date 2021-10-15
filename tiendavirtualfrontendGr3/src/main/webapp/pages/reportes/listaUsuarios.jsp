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
	
	<form name="consultaUusarioForm" action="/listarUsuarios" method="post">
	</form>
	<div class="listado-container">
		<div class="tittle-container">
			<h2 class="tittle">Listado de usuarios</h2>
		</div>
		<div id="main-container">
			<table name="tablaListado">
				<thead id="cabecera">
					<tr>
						<th class="izquierda">cedula</td>
						<th>email</td>
						<th>nombre</td>
						<th class="derecha">Rol</td>
						
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${usuarios}" var="usr">
					<tr>
						<td>${usr.cedula}</td>
						<td>${usr.email}</td>
						<td>${usr.nombre}</td>
						<td>${usr.rol}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>