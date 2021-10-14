<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title></title>
<link rel="stylesheet" href="../assets/css/admin.css">
<link rel="stylesheet" href="../assets/fontawesome/css/all.css">
</head>
<body>
	<div class="sidebar">
        <div class="logo_content">
            <div class="logo">
                <i class="fas fa-shopping-cart"></i>
                <div class="logo_name">Tienda Generica</div>
            </div>
        </div>
        <ul class="nav_list">
            <li class="li-container">
                <a class="a-container" id="users-a" href="/pages/usuarios/usuarios.jsp">
                    <i class="fas fa-users"></i>
                    <span class="links_name">Usuarios</span>
                </a>
            </li>
            <li class="li-container">
                <a class="a-container" id="clients-a" href="/pages/clientes/clientes.jsp">
                    <i class="fas fa-user-tie"></i>
                    <span class="links_name">Clientes</span>
                </a>
            </li>
            <li>
                <a class="a-container" id="proveedores-a" href="/pages/proveedores/proveedores.jsp">
                    <i class="fas fa-truck"></i>
                    <span class="links_name">Proveedores</span>
                </a>
            </li>
            <li class="li-container">
                <a class="a-container" id="productos-a" href="#">
                    <i class="fas fa-shopping-bag"></i>
                    <span class="links_name">Productos</span>
                </a>
            </li>
            <li class="li-container">
                <a class="a-container" id="ventas-a" href="#">
                    <i class="fas fa-coins"></i>
                    <span class="links_name">Ventas</span>
                </a>
            </li>
            <li class="li-container">
                <a class="a-container" id="reportes-a" href="/pages/reportes/consultas.jsp">
                    <i class="fas fa-address-book"></i>
                    <span class="links_name">Reportes</span>
                </a>
            </li>
        </ul>
        <div class="logout">
        	<a  href="/"><i id="log-out" class="fas fa-sign-out-alt"></i></a>
        </div>
    </div>
</body>
</html>