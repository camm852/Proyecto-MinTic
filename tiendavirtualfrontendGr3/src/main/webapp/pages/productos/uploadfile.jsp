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
<meta charset="ISO-8859-1">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<link rel="stylesheet" href="../../assets/css/tabla.css">
<link rel="stylesheet" href="../../assets/css/listado.css">
<link rel="stylesheet" href="../../assets/css/admin.css">
<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
<title>SubirArchivo</title>
</head>
<body>
	<c:import url="../../imports/sidebar.jsp"></c:import>
		<div class="table-productos-container">
			<div class="listado-container">
				<div class="form-productos">
					<form method="post" enctype="multipart/form-data"  action="/uploadCSVFile">
						<input type="file" name="file" accept=".csv" /> 
						<input type="submit" value="Cargar Archivo" />
					</form>
				</div>
				<div class="tittle-container">
					<h2 class="tittle">Listado de Productos</h2>
				</div>
				<div id="main-container">
					<table name="tablaListado">
						<thead id="cabecera">
							<tr>
								<th class="izquierda">Codigo</td>
								<th>Iva</td>
								<th>NitProveedor</td>
								<th>Nombre</td>
								<th>Precio-Compra</th>
								<th class="derecha">Precio-Venta</td>
								
							</tr>
						</thead>
						<tbody>
						<% 
							ProductoDAO prductos = new ProductoDAO();
							ArrayList<ProductoVO> producto = prductos.getListaProductos();
						%>	
						<% 
							for(ProductoVO dto : producto){ 
						%>
							<tr>
								<td><%= dto.getCodigo_producto() %></td>		
								<td><%= dto.getIvacompra() %></td>		
								<td><%= dto.getNitproveedor() %></td>		
								<td><%= dto.getNombre_producto() %></td>
								<td><%= dto.getPrecio_compra()%></td>
								<td><%= dto.getPrecio_venta() %></td>		
							</tr>
							<% } %>
						</tbody>
					</table>
				</div>
			</div>
		</div>
<div style="color: red">${errorCargaArchivo}</div>
<div style="color: blue">${cargaArchivo}</div>
</body>
</html>