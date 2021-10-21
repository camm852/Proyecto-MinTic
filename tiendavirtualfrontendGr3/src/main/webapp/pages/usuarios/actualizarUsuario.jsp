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
	<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
	<title>Usuario</title>
</head>
<body>          	
	<c:import url="../../imports/sidebar.jsp"></c:import>
    <div class="crud-container">
        <div class="crud users">
            <div class="users-form-container">
                <form class="form-agregar" action="/actualizarUsuario" method="post">
                    <label class="label-form" for="cedula"><i class="fas far fa-id-card"></i>Cédula</label>
                    <input class="input-form" id="cedula" type="text" name="cedula" autocomplete="off" value="${usuario.cedula}">
                    
                    <label class="label-form" for="usuario"><i class="fas fa-user-alt"></i>Usuario</label>
                    <input class="input-form" id="usuario" type="text" name="rol" autocomplete="off" value="${usuario.rol}">

                    <label class="label-form" for="nombre"><i class="fas fa-user-tag"></i>Nombre Completo</label>
                    <input class="input-form" id="nombre" type="text" name="nombre" autocomplete="off" value="${usuario.nombre}">

                    <label class="label-form" for="password"><i class="fas fa-lock"></i>Contraseña</label>
                    <input class="input-form" id="password" type="password" name="contrasena" value="${usuario.contrasena}">

                    <label class="label-form" for="correo"><i class="fas fa-at"></i>Correo Electrónico</label>
                    <input class="input-form" id="correo" type="email" name="email" autocomplete="off" value="${usuario.email}">
                    <div class="button-container">
                        <input class="button-form" type="submit" value="Actualizar"> 
                        <a href="/pages/usuarios/usuarios.jsp" class="button-form" >Volver</a>               
                    </div>
                </form>
            </div>
        </div> 
	</div>
</body>
</html>