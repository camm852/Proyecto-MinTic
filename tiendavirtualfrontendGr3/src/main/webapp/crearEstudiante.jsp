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
<title>Guardar Estudiantes</title>
</head>
<body>
<form action="/crearEstudiante" method="post">


<h1>Ingresar Estudiante</h1>
<label>id</label>
<input type="text" name="id" id="id" value="${estudiante.id }">
<div>
<label>correo institucional</label>
<input type="text" name="correoInstitucional" id="correoInstitucional" value="${estudiante.correoInstitucional} ">
<label>nombres</label>
<input type="text" name="nombres" id="nombres" value="${estudiante.nombres} ">
<label>apellidos</label>
<input type="text" name="apellidos" id="apellidos" value="${estudiante.apellidos} ">
<label>Telefono fijo</label>
<input type="text" name="telefonoFijo" id="telefonos" value="${estudiante.telefonoFijo} ">
<label>Celular</label>
<input type="text" name="telefonoCel" id="telefonoCel" value="${estudiante.telefonoCel} ">
<label>Correo personal</label>
<input type="text" name="correoPersonal" id="correoPersonal" value="${estudiante.correoPersonal} ">
<label>Programa academico</label>
<input type="text" name="programa" id="programa" value="${estudiante.programa} ">
<label>fecha nacimiento</label>
<input type="text" name="fechaNacimiento" id="fechaNacimiento" value="${estudiante.fechaNacimiento} ">
<input type="submit" value="Guardar">
</div>
</form>
<br><br>
<table>
<thead>
	<tr>
		<td>#</td>
		<td>correo institucional</td>
		<td>nombres</td>
		<td>apellidos</td>
		<td>Telefono Fijo</td>
		<td>Telefono Celular</td>
		<td>Correo Personal</td>
		<td>Programa</td>
		<td>Fecha Nacimiento</td>
	</tr>
</thead>
<tbody>
<c:forEach items="${estudiantes}" var="est">
<tr>
	<td>${est.id}</td>
	<td>${est.correoInstitucional}</td>
	<td>${est.nombres}</td>
	<td>${est.apellidos}</td>
	<td>${est.telefonoFijo}</td>
	<td>${est.telefonoCel}</td>
	<td>${est.correoPersonal}</td>
	<td>${est.programa}</td>
	<td>${est.fechaNacimiento}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>