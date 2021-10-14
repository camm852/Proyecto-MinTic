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
<link rel="stylesheet" href="../../assets/css/tabla.css">
<link rel="stylesheet" href="../../assets/css/admin.css">
<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
<title>Usuario</title>
</head>
<body>          	
	<c:set var="url" value="tiendavirtualfrontendGr3"></c:set>
	<c:import url="../../imports/sidebar.jsp"></c:import>
    <div class="crud-container">
        <div class="crud users">
            <div class="users-form-container">
                <form class="form-agregar" action="/consultarUsuario" method="post">
                    <label class="label-form" for="cedula"><i class="fas far fa-id-card"></i>Cédula Usuario</label>
                    <input class="input-form" id="cedula" type="text" name="cedula" autocomplete="off">
                    <div class="button-container">
                        <input class="button-form" type="submit" value="Consultar"> 
                        <a href="/pages/usuarios/usuarios.jsp" class="button-form" >Volver</a>               
                    </div>
                </form>
               	<c:choose>
               		<c:when test="${usuario.nombre!=null}">
						<div id="main-container">
							<table>
								<thead id="cabecera">
									<tr>
										<th class="izquierda">Cedula</th>
										<th>Email</th>
										<th class="derecha">Nombre</th>	
									</tr>
								</thead>
								<tr>
									<td>${usuario.cedula}</td>
									<td>${usuario.email}</td>
									<td>${usuario.nombre}</td>
								</tr>
							</table>
						</div>
               		</c:when>
               	</c:choose>	
        	</div>
    	</div>
    </div> 
</body>
</html>