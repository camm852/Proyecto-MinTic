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
<link rel="stylesheet" href="../../assets/css/usuarios.css">
<link rel="stylesheet" href="../../assets/css/admin.css">
<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
<title>Guardar Estudiantes</title>
</head>
<body>
<c:import url="../../imports/sidebar.jsp"></c:import>

<form name="consultaUusarioForm" action="/listarUsuarios" method="post">
</form>

<br><br>
<table name="tablaListado" style="text-align:center; margin:auto;">
<caption>Listado de usuarios</caption>
<thead>
	<tr>
		<td>#</td>
		<td>email</td>
		<td>nombre de usuario</td>
		<td>contraseña</td>
		<td>usuario</td>
		
	</tr>
</thead>
<tbody>
<c:forEach items="${usuarios}" var="usr">
<tr>
	<td>${usr.cedula}</td>
	<td>${usr.email}</td>
	<td>${usr.nombre}</td>
	<td>${usr.contrasena}</td>
	<td>${usr.rol}</td>
	
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>