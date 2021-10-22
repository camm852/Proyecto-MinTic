<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.DAO.ProductoDAO"%>
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
				<label for="cedulaCliente">Cedula*</label>
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
				<div class="tittle t-1">Cod.Producto*</div>
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
				<div class="totales-container">
					<div class="formulario-envio">
						<form id="form-envio" action="/agregarVenta" method="post">
							<div class="envio">
								<input class="input-form button-form" id="enviarVenta" type="submit" value="Confirmar">
								<input type="text" name="cedula_cliente" value="${cliente.cedula}" id="cedulaCliente-envio" hidden>
								<input type="text" name="cedula_usuario" id="cedulaUsuario-envio" hidden>
							</div>
							<div class="labels-envio">
								<label for="">Total Iva</label>
								<label for="">Total Venta</label>
								<label for="">Total con Iva</label>
							</div>
							<div class="totales">
								<input class="input-form" type="text" name="ivaventa" id="ivaVenta" readonly>
								<input class="input-form" type="text" name="total_venta" id="totalVenta" readonly>							
								<input class="input-form" type="text" name="valor_venta" id="valorVenta" readonly>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="error-container">

		</div>
		
		<c:choose>
			<c:when test="${agrego != null}">
				<script type="text/javascript">
					alert("Venta realizada")
				</script>
			</c:when>
		</c:choose>	
		
	</div>
	<script>
		
		let enviarVenta=document.getElementById("enviarVenta")

		enviarVenta.addEventListener("click",(e)=>{
			if(document.getElementById("nombreCliente").value==0 || document.getElementById("valorVenta").value==0){
				e.preventDefault();
				console.log("hola")
				document.querySelector(".error-container").innerHTML="Por favor rellene los campos marcados con asterisco"
			}else{
				document.getElementById("cedulaUsuario-envio").value=100452050;
			}
		})

		let sumit1=document.getElementById("sumit-1");
		let sumit2=document.getElementById("sumit-2");
		let sumit3=document.getElementById("sumit-3");

		let codigo1=document.getElementById("codigo-1");
		let codigo2=document.getElementById("codigo-2");
		let codigo3=document.getElementById("codigo-3");
		
		<% ProductoDAO prductos = new ProductoDAO(); %>
		var productos = <%=prductos.listarProductos()%>

		// let productos=[
		// 	{
		// 		"codigo":"123",
		// 		"iva":"2000",
		// 		"nitproveedor":"123",
		// 		"nombre":"tomate",
		// 		"precio":"3000",
		// 		"precioVenta":"5000"
		// 	},
		// 	{
		// 		"codigo":"125",
		// 		"iva":"2000",
		// 		"nitproveedor":"153",
		// 		"nombre":"papa",
		// 		"precio":"3000",
		// 		"precioVenta":"7000"
		// 	},
		// 	{
		// 		"codigo":"126",
		// 		"iva":"2000",
		// 		"nitproveedor":"133",
		// 		"nombre":"yuca",
		// 		"precio":"3000",
		// 		"precioVenta":"20000"
		// 	}
		// ]

		

		sumit1.addEventListener("click",(e)=>{
			e.preventDefault();
			const codigo=codigo1.value
			let producto = productos.find(producto=>producto.codigo_producto == codigo);
			if(producto!=null){
				document.getElementById("nombreProducto-1").value=producto.nombre_producto;
			}else{

			}
		})

		sumit2.addEventListener("click",(e)=>{
			e.preventDefault();
			const codigo=codigo2.value
			let producto = productos.find(producto=>producto.codigo_producto == codigo);
			if(producto!=null){
				document.getElementById("nombreProducto-2").value=producto.nombre_producto;
			}else{

			}
		})

		sumit3.addEventListener("click",(e)=>{
			e.preventDefault();
			const codigo=codigo3.value
			let producto = productos.find(producto=>producto.codigo_producto == codigo);
			if(producto!=null){
				document.getElementById("nombreProducto-3").value=producto.nombre_producto;
			}else{

			}
		})

		function buscarProducto(nombre){
			return productos.find(producto=>producto.nombre_producto==nombre)
		}

		setInterval(() => {
			let valor1=document.getElementById("cantidad-1");
			let valor2=document.getElementById("cantidad-2");
			let valor3=document.getElementById("cantidad-3");

			if(document.getElementById("nombreProducto-1").value.length!=0){
				valor1.removeAttribute("readonly");
				let producto=buscarProducto(document.getElementById("nombreProducto-1").value);
				document.getElementById("valor-1").value=valor1.value*producto.precio_venta;
				
				if(valor1.value<=0){
					valor1.value=1;
				}
			}else{
				valor1.setAttribute("readonly","");
			}
			
			if(document.getElementById("nombreProducto-2").value.length!=0){
				valor2.removeAttribute("readonly");
				let producto=buscarProducto(document.getElementById("nombreProducto-2").value);
				document.getElementById("valor-2").value=valor2.value*producto.precio_venta;
				
				if(valor2.value<=0){
					valor2.value=1;
				}
			}else{
				valor2.setAttribute("readonly","");
			}
			
			if(document.getElementById("nombreProducto-3").value.length!=0){
				valor3.removeAttribute("readonly");
				let producto=buscarProducto(document.getElementById("nombreProducto-3").value);
				document.getElementById("valor-3").value=valor3.value*producto.precio_venta;
				
				if(valor3.value<=0){
					valor3.value=1;
				}
			}else{
				valor3.setAttribute("readonly","");
			}
			
			let iva1=0;
			let iva2=0;
			let iva3=0;

			var total1=0
			var total2=0
			var total3=0

			let producto1=buscarProducto(document.getElementById("nombreProducto-1").value)
			let producto2=buscarProducto(document.getElementById("nombreProducto-2").value)
			let producto3=buscarProducto(document.getElementById("nombreProducto-3").value)

			let ivaTotal=document.getElementById("ivaVenta").value
			let totalVenta=document.getElementById("totalVenta").value

			
			
				
			if(producto1!=0){
				iva1=valor1.value*producto1.ivacompra;
				total1=document.getElementById("valor-1").value
				total1=Number(total1);
				document.getElementById("ivaVenta").value=iva1
				document.getElementById("totalVenta").value=total1
				var total=Number(ivaTotal)+Number(totalVenta)
				document.getElementById("valorVenta").value=total
			}
			
			if(producto2!=0){
				iva2=valor2.value*producto2.ivacompra;
				total2=document.getElementById("valor-2").value
				total2=Number(total2)
				document.getElementById("ivaVenta").value=iva1+iva2
				document.getElementById("totalVenta").value=total1+total2
			}

			
			if(producto3!=0){
				iva3=valor3.value*producto3.ivacompra;
				total3=document.getElementById("valor-3").value
				total3=Number(total3);
				document.getElementById("ivaVenta").value=iva1+iva2+iva3
				document.getElementById("totalVenta").value=total1+total2+total3
			}


			
			
		}, 100);
	</script>
</body>
</html>