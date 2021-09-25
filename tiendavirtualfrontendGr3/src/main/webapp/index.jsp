<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="stylesheet" href="assets/fontawesome/css/all.css">
    <title>Login</title>
</head>
<body>
    <div class="form-container">
        <h2>Bienvenidos a la Tienda Genérica</h2>
        <form class="form" action="/login" method="post">
            <label class="label-form usuario-label" for="usuario"><i class="fas fa-user-tie"></i>Usuario</label>
            <input class="input-form" id="usuario" type="text" name="usuario" autocomplete="off">
            <label class="label-form" for="password"><i class="fas fa-lock"></i>Contraseña</label>
            <input class="input-form" id="password" type="password" name="password">
            <div class="button-container">
                <input type="submit" class="button-form" value="Entrar">
                <a class="button-form" href="#">Cancelar</a>
            </div>
        </form>
        <div class="incorrect-container">
            
        </div>
    </div>
</body>
</html>