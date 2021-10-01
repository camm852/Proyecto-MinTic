<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
            <div class="selects">
                <a href="/<c:out value="${url}"></c:out>/pages/proveedores/agregarProveedor.jsp" class="select-crud"><p><i class="fas fa-user-plus"></i><br>Agregar<br>Proveedor</p></a>
                <a href="/<c:out value="${url}"></c:out>/pages/proveedores/actualizarProveedor.jsp" class="select-crud"><p><i class="fas fa-user-cog"></i><br>Actualizar Proveedor</p></a>
                <a href="/<c:out value="${url}"></c:out>/pages/proveedores/consultarProveedor.jsp" class="select-crud"><p><i class="fas fa-search"></i><br>Consultar Proveedor</p></a>
                <a href="/<c:out value="${url}"></c:out>/pages/proveedores/eliminarProveedor.jsp" class="select-crud"><p><i class="fas fa-user-minus"></i><br></b>Eliminar<br>Proveedor</p></a>
            </div>
    	</div> 
	</div>
</body>
</html>