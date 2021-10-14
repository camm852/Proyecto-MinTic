<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
            <div class="selects">
                <a href="/listarUsuarios" class="select-crud select-actualizar"><p><i class="fas fa-user-plus"></i><br>Listado de usuarios</p></a>
				<a href="/pages/usuarios/actualizarUsuario.jsp" class="select-crud select-actualizar"><p><i class="fas fa-user-cog"></i><br>Listado de clientes</p></a>
				<a href="/pages/usuarios/consultarUsuario.jsp" class="select-crud select-actualizar"><p><i class="fas fa-search"></i><br>Ventas por cliente</p></a>
            </div>
        </div> 
	</div>
</body>
</html>