<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../assets/css/usuarios.css">
<link rel="stylesheet" href="../assets/css/clientes.css">
<link rel="stylesheet" href="../assets/fontawesome/css/all.css">
<title>Clientes</title>
</head>
<body>          	
	<c:import url="../imports/sidebar.jsp"></c:import>
    <div class="crud-container">
        <div class="crud users">
            <div class="users-form-container clients-form-container">
                <form class="form" action="" method="post">
                    <label class="label-form" for="cedula"><i class="fas far fa-id-card"></i>Cédula</label>
                    <input class="input-form" id="cedula" type="text" name="cedulaGestor" autocomplete="off">
                    
                    <label class="label-form" for="telefono"><i class="fas fa-mobile"></i>Teléfono</label>
                    <input class="input-form" id="telefono"type="text" name="usuarioGestor" autocomplete="off">

                    <label class="label-form" for="nombre"><i class="fas fa-user-tag"></i>Nombre Completo</label>
                    <input class="input-form" id="nombre" type="text" name="nombreGestor" autocomplete="off">

                    <label class="label-form" for="direccion"><i class="fas fa-route"></i>Dirección</label>
                    <input class="input-form" id="direccion" type="text" name="passwordGestor">

                    <label class="label-form" for="correo"><i class="fas fa-at"></i>Correo Electrónico</label>
                    <input class="input-form" id="correo" type="email" name="emailGestor" autocomplete="off">
                    <div class="button-container">
                        <input class="button-form" type="submit" value="Agregar" onclick="form.action='';">                     
     					<input class="button-form" type="submit" value="Consultar" onclick="form.action='';">
     					<input class="button-form" type="submit" value="Actualizar" onclick="form.action='';">                     
     					<input class="button-form" type="submit" value="Eliminar" onclick="form.action='';">
                    </div>
                </form>
            </div>
    	</div> 
	</div>
</body>
</html>