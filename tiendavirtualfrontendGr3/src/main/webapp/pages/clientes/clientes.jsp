<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../assets/css/usuarios.css">
<link rel="stylesheet" href="../../assets/css/clientes.css">
<link rel="stylesheet" href="../../assets/css/admin.css">
<link rel="stylesheet" href="../../assets/fontawesome/css/all.css">
<title>Clientes</title>
</head>
<body> 
	<c:set var="url" value="tiendavirtualfrontendGr3"></c:set>         	
	<c:import url="../../imports/sidebar.jsp"></c:import>
    <div class="crud-container">
        <div class="crud clients">
            <div class="selects">
                <a href="/<c:out value="${url}"></c:out>/pages/clientes/agregarCliente.jsp" class="select-crud"><p><i class="fas fa-user-plus"></i><br>Agregar Cliente</p></a>
                <a href="/<c:out value="${url}"></c:out>/pages/clientes/actualizarCliente.jsp" class="select-crud"><p><i class="fas fa-user-cog"></i><br>Actualizar Cliente</p></a>
                <a href="/<c:out value="${url}"></c:out>/pages/clientes/consultarCliente.jsp" class="select-crud"><p><i class="fas fa-search"></i><br>Consultar Cliente</p></a>
                <a href="/<c:out value="${url}"></c:out>/pages/clientes/eliminarCliente.jsp" class="select-crud"><p><i class="fas fa-user-minus"></i><br></b>Eliminar Cliente</p></a>
            </div>
    	</div> 
	</div>
</body>
</html>