<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
<%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.controller.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="Expires" content="0">
	<meta http-equiv="Last-Modified" content="0">
	<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
	<meta http-equiv="Pragma" content="no-cache">
	<link rel="stylesheet" href="../../assets/css/usuarios.css">
	<link rel="stylesheet" href="../../assets/css/admin.css">
	<link rel="stylesheet" href="../../assets/css/ventas.css">
	<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
	<title>Agregar Venta</title>
</head>
<body>
	<c:import url="../../imports/sidebar.jsp"></c:import>
	<div class="venta-container">
		<div class="informacion-cliente-container">
			<form  action="/consultarClienteVenta" method="post">
				<label for="cedulaCliente">Cedula</label>
				<input class="input-form" type="text" name="cedula" id="cedulaCliente"  value="${cliente.cedula}" autocomplete="off">
				<input class="input-form button-form" type="submit" value="Consultar">
				<label for="nombreCliente">Nombre</label>
				<input class="input-form" type="text" name="nombreCliente" id="nombreCliente" readonly value="${cliente.nombre}">
				<label for="telefonoCliente">Telefono</label>
				<input class="input-form" type="text" name="telefonoCliente" id="telefonoCliente" readonly value="${cliente.telefono}">
			</form>
		</div>
		<div class="crud-productos-container">
			<div class="tittles-container">
				<div class="tittle t-1">Cod.Producto</div>
				<div class="tittle t-2">Nombre Producto</div>
				<div class="tittle t-3">Cant</div>
				<div class="tittle t-4">Vlr. Total</div>
			</div>
			<div class="productos-container">
				<div class="crud-productos">
					<form action="" method="post">
						<input class="input-form" id="codigo-1" type="text" name="codigoProducto" autocomplete="off">
						<input class="input-form button-form" id="sumit-1" type="submit" value="Consultar">
						<input class="input-form" id="nombreProducto-1" type="text" readonly value="" autocomplete="off">
						<input class="input-form cantidadProducto" id="cantidad-1" type="text" autocomplete="off">
						<input class="input-form valorProducto" id="valor-1" type="text" autocomplete="off">
					</form>
				</div>
				<div class="crud-productos">
					<form action="" method="post">
						<input class="input-form" id="codigo-2" type="text" name="codigoProducto" autocomplete="off">
						<input class="input-form button-form" id="sumit-2" type="submit" value="Consultar">
						<input class="input-form" id="nombreProducto-2" type="text" readonly value="" autocomplete="off">
						<input class="input-form cantidadProducto" id="cantidad-2" type="text" autocomplete="off">
						<input class="input-form valorProducto" id="valor-2" type="text" autocomplete="off">
					</form>
				</div>
				<div class="crud-productos">
					<form action="" method="post">
						<input class="input-form" id="codigo-3" type="text" name="codigoProducto" autocomplete="off">
						<input class="input-form button-form" id="sumit-3" type="submit" value="Consultar">
						<input class="input-form" id="nombreProducto-3" type="text" readonly value="" autocomplete="off">
						<input class="input-form cantidadProducto" id="cantidad-3" type="text" autocomplete="off">
						<input class="input-form valorProducto" id="valor-3" type="text" autocomplete="off">
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>

		let sumit1=document.getElementById("sumit-1");
		let sumit2=document.getElementById("sumit-2");
		let sumit3=document.getElementById("sumit-3");

		let codigo1=document.getElementById("codigo-1");
		let codigo2=document.getElementById("codigo-2");
		let codigo3=document.getElementById("codigo-3");
		
		let productos=[
			{
				"codigo":"123",
				"iva":"2000",
				"nitproveedor":"123",
				"nombre":"tomate",
				"precio":"3000",
				"precioVenta":"5000"
			},
			{
				"codigo":"125",
				"iva":"2000",
				"nitproveedor":"153",
				"nombre":"papa",
				"precio":"3000",
				"precioVenta":"7000"
			},
			{
				"codigo":"126",
				"iva":"2000",
				"nitproveedor":"133",
				"nombre":"yuca",
				"precio":"3000",
				"precioVenta":"20000"
			}
		]

		

		sumit1.addEventListener("click",(e)=>{
			e.preventDefault();
			const codigo=codigo1.value
			let producto = productos.find(producto=>producto.codigo == codigo);
			if(producto!=null){
				document.getElementById("nombreProducto-1").value=producto.nombre;
			}else{

			}
		})

		sumit2.addEventListener("click",(e)=>{
			e.preventDefault();
			const codigo=codigo2.value
			let producto = productos.find(producto=>producto.codigo == codigo);
			if(producto!=null){
				document.getElementById("nombreProducto-2").value=producto.nombre;
			}else{

			}
		})

		sumit3.addEventListener("click",(e)=>{
			e.preventDefault();
			const codigo=codigo3.value
			let producto = productos.find(producto=>producto.codigo == codigo);
			if(producto!=null){
				document.getElementById("nombreProducto-3").value=producto.nombre;
			}else{

			}
		})

		function buscarProducto(nombre){
			return productos.find(producto=>producto.nombre==nombre)
		}

		setInterval(() => {
			let valor1=document.getElementById("cantidad-1");
			let valor2=document.getElementById("cantidad-2");
			let valor3=document.getElementById("cantidad-3");

			if(document.getElementById("nombreProducto-1").value.length!=0){
				valor1.removeAttribute("readonly");
				let producto=buscarProducto(document.getElementById("nombreProducto-1").value);
				document.getElementById("valor-1").value=valor1.value*producto.precioVenta;
				if(valor1.value<=0){
					valor1.value=1;
				}
			}else{
				valor1.setAttribute("readonly","");
			}
			
			if(document.getElementById("nombreProducto-2").value.length!=0){
				valor2.removeAttribute("readonly");
				let producto=buscarProducto(document.getElementById("nombreProducto-2").value);
				document.getElementById("valor-2").value=valor2.value*producto.precioVenta;
				if(valor2.value<=0){
					valor2.value=1;
				}
			}else{
				valor2.setAttribute("readonly","");
			}
			
			if(document.getElementById("nombreProducto-3").value.length!=0){
				valor3.removeAttribute("readonly");
				let producto=buscarProducto(document.getElementById("nombreProducto-3").value);
				document.getElementById("valor-3").value=valor3.value*producto.precioVenta;
				if(valor3.value<=0){
					valor3.value=1;
				}
			}else{
				valor3.setAttribute("readonly","");
			}

		}, 100);
	</script>
</body>
</html>