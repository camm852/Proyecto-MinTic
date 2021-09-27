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
<title>Guardar Usuarios</title>
</head>
<body>
<form action="/crearUsuario" method="post">


<h1>Ingresar Usuario</h1>
<label>cedula</label>
<input type="text" name=cedula id="cedula" value="${usuario.cedula}">
<div>
<label>email</label>
<input type="text" name="email" id="email" value="${usuario.email} ">
<label>nombre de usuario</label>
<input type="text" name="nombre" id="nombre" value="${usuario.nombre} ">
<label>contraseña</label>
<input type="text" name="contrasena" id="contrasena" value="${usuario.contrasena} ">
<label>usuario</label>
<input type="text" name="rol" id="rol" value="${usuario.rol} ">
<input type="submit" value="Guardar">
</div>
</form>
<br><br>
<table>
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