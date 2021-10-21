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
	<c:set var="url" value="tiendavirtualfrontendGr3"></c:set>
	<c:import url="../../imports/sidebar.jsp"></c:import>
    <div class="crud-container">
        <div class="crud users">
            <div class="users-form-container">
                <form class="form-agregar" action="/consultarClienteVentas" method="post">
                    <label class="label-form" for="cedula"><i class="fas far fa-id-card"></i>Cédula</label>
                    <input class="input-form" id="cedula" type="text" name="cedula" autocomplete="off" ">
                    
	                   
 
                    <div class="button-container">
                        <input class="button-form" type="submit" value="Consultar"  onclick="location.reload()"> 
                        <a href="/pages/usuarios/usuarios.jsp" class="button-form" >Volver</a>               
                    </div>
                    
                </form>
                  <c:choose>
	               		<c:when test="${cliente.nombre!=null}">
	               				<label class="label-form" for="nombre">Cliente: ${cliente.nombre} </label>
	               		</c:when>
	               		</c:choose>	
	               		
	               		<label class="label-form" for="nombre">Clientes: ${cliente.nombre} </label>
                
                <form class="form-agregar" action="/consultarUsuarioVentas" method="post">
                    <label class="label-form" for="cedula"><i class="fas far fa-id-card"></i>Cédula</label>
                    <input class="input-form" id="cedula" type="text" name="cedula" autocomplete="off" ">
                    
	                     <c:choose>
	               		<c:when test="${usuario.nombre!=null}">
	               				<label class="label-form" for="nombre">Usuario: ${usuario.nombre} </label>
	               		</c:when>
	               		</c:choose>
 
                    <div class="button-container">
                        <input class="button-form" type="submit" value="Consultar"  onclick="location.reload()"> 
                        <a href="/pages/usuarios/usuarios.jsp" class="button-form" >Volver</a>               
                    </div>
                    
                </form>
                
                <div class="incorrect-container">
            <c:choose>
			<c:when test="${cliente.nombre == null}">
				<p>${error}</p>
			</c:when>
			</c:choose>	
        </div>
        
            </div>
        </div> 
	</div>
</body>
</html>