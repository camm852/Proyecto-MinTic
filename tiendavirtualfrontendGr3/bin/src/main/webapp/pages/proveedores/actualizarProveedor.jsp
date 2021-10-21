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
<link rel="stylesheet" href="../../assets/css/proveedores.css">
<link rel="stylesheet" href="../../assets/css/admin.css">
<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
<title>Clientes</title>
</head>
<body>       
	<c:set var="url" value="tiendavirtualfrontendGr3"></c:set>    	
	<c:import url="../../imports/sidebar.jsp"></c:import>
    <div class="crud-container">
        <div class="crud proveedores">
            <div class="users-form-container">
                <form class="form-agregar" action="/actualizarProveedor" method="post">
                    <label class="label-form" for="nit"><i class="fas far fa-id-card"></i>NIT</label>
                    <input class="input-form" id="nit" type="text" name="nit" autocomplete="off" value="${proveedor.nit}">
                    
                    <label class="label-form" for="telefono"><i class="fas fa-mobile"></i>Teléfono</label>
                    <input class="input-form" id="telefono"type="text" name="telefono" autocomplete="off" value="${proveedor.telefono}">

                    <label class="label-form" for="nombre"><i class="fas fa-user-tag"></i>Nombre Proveedor</label>
                    <input class="input-form" id="nombre" type="text" name="nombre" autocomplete="off" value="${proveedor.nombre}">
                    
                    <label class="label-form" for="ciudad"><i class="fas fa-city"></i>Ciudad</label>
                    <input class="input-form" id="ciudad" type="text" name="ciudad" autocomplete="off" value="${proveedor.ciudad}">

                    <label class="label-form" for="direccion"><i class="fas fa-route"></i>Dirección</label>
                    <input class="input-form" id="direccion" type="text" name="direccion" value="${proveedor.direccion}">

                    
                    <div class="button-container">
                        <input class="button-form" type="submit" value="Actualizar">
                        <a href="/pages/proveedores/proveedores.jsp" class="button-form" >Volver</a>                        
                    </div>
                </form>
            </div>
    	</div> 
	</div>
</body>
</html>