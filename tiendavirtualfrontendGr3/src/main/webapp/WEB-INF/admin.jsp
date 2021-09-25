<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
                <a class="a-container" id="users-a" href="#">
                    <i class="fas fa-users"></i>
                    <span class="links_name">Usuarios</span>
                </a>
            </li>
            <li class="li-container">
                <a class="a-container" id="clients-a" href="#">
                    <i class="fas fa-user-tie"></i>
                    <span class="links_name">Clientes</span>
                </a>
            </li>
            <li>
                <a class="a-container" href="#">
                    <i class="fas fa-truck"></i>
                    <span class="links_name">Proveedores</span>
                </a>
            </li>
            <li class="li-container">
                <a class="a-container" href="#">
                    <i class="fas fa-shopping-bag"></i>
                    <span class="links_name">Productos</span>
                </a>
            </li>
            <li class="li-container">
                <a class="a-container" href="#">
                    <i class="fas fa-coins"></i>
                    <span class="links_name">Ventas</span>
                </a>
            </li>
            <li class="li-container">
                <a class="a-container" href="#">
                    <i class="fas fa-address-book"></i>
                    <span class="links_name">Reportes</span>
                </a>
            </li>
        </ul>
        <div class="logout">
            <i id="log-out" class="fas fa-sign-out-alt"></i>
        </div>
    </div>
    

                        	
                        	
    <div class="crud-container">
        <div class="crud users">
            <div class="users-form-container">
                <form class="form" action="GestorUsuariosServlet" method="post">
                    <label class="label-form" for="cedula"><i class="fas far fa-id-card"></i>Cedula</label>
                    <input class="input-form" id="cedula" type="text" name="cedulaGestor" autocomplete="off">
                    
                    <label class="label-form" for="usuario"><i class="fas fa-user-alt"></i>Usuario</label>
                    <input class="input-form" id="usuario" type="text" name="usuarioGestor" autocomplete="off">

                    <label class="label-form" for="nombre"><i class="fas fa-user-tag"></i>Nombre Completo</label>
                    <input class="input-form" id="nombre" type="text" name="nombreGestor" autocomplete="off">

                    <label class="label-form" for="password"><i class="fas fa-lock"></i>Contraseña</label>
                    <input class="input-form" id="password" type="text" name="passwordGestor">

                    <label class="label-form" for="correo"><i class="fas fa-at"></i>Correo Electrónico</label>
                    <input class="input-form" id="correo" type="email" name="emailGestor" autocomplete="off">
                    <div class="button-container">
                   
                        <input class="button-form" type="submit" value="Agregar" onclick="form.action='GestorUsuariosServlet';">                     
     					<input class="button-form" type="submit" value="Consultar" onclick="form.action='consultarUsuarioServlet';">
     					<input class="button-form" type="submit" value="Actualizar" onclick="form.action='ActualizarUsuarioServlet';">                     
     					<input class="button-form" type="submit" value="Eliminar" onclick="form.action='EliminarUsuarioServlet';">
                        
                    </div>
                </form>
                

            </div>
        </div>
        <div class="crud clients">
            <h2>feliz</h2>
        </div>
    </div>




    <script>
        //los a del sidebar
        let enitys=document.querySelectorAll(".crud")

        //cada li del sidebar
        let usuarios=document.querySelector("#users-a");
        let clientes=document.querySelector("#clients-a");
        
        //entidades
        let users=document.querySelector(".users");
        let clients=document.querySelector(".clients")


        usuarios.addEventListener("click",()=>{
            users.classList.add("active")
            removeClass(users)
        })
        clientes.addEventListener("click",()=>{
            clients.classList.add("active")
            removeClass(clients)
        })

        function removeClass(excep){
            enitys.forEach(element => {
                if(!element.isEqualNode(excep)){
                    element.classList.remove("active")
                }
            });
        }        


    </script>
</body>
</html>