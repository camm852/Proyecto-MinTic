<%@page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.ProductoDAO"%>
<%@page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.ClienteDAO"%>
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
<title>Listado Ventas</title>
</head>
<body>
	<c:import url="../../imports/sidebar.jsp"></c:import>
	
	<form name="consultaClienteForm" action="/listarVentas" method="post">
	</form>
	<div class="listado-container">
		<div class="tittle-container">
			<h2 class="tittle">Total de ventas por cliente</h2>
		</div>
		<div id="main-container">
			<table name="tablaListado">
				<thead id="cabecera">
					<tr>
						<th class="izquierda">Cedula</td>
						<th>Nombre</td>
						<th class="derecha">Total</td>
						
					</tr>
				</thead>
				<tbody>
				<c:set var="total" value="${0}" />	
				
			
				<c:forEach items="${ventas}" var="cli">
					<tr>
						<td>${cli.cedula_cliente}</td>
						<td>${cli.nombre_cliente}</td>
						<td>${cli.ventas_totales}</td>
						<c:set var="total" value="${total+cli.ventas_totales}" />	
					</tr>
				</c:forEach>
				</tbody>
			</table>
			
			<div class="total-container">
				<label for="">Total Ventas $</label>
				<input class="input-form" type="text"  readonly value="${total}">
			</div>
			
		</div>
	</div>
</body>

</html>