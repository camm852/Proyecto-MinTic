<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="co.edu.unbosque.tiendafrontend.vo.*" %>
<%@ page import="co.edu.unbosque.tiendafrontend.controller.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="clienteServlet" method="get">
<input type="submit" value="Buscar">
<%if(request.getAttribute("listaClientes")!= null){
	ArrayList<ClienteVO> listaEstudiantes = (ArrayList<ClienteVO>)request.getAttribute("listaClientes");
	%>
	<table class="table table-striped">
	<th>
		
		<td scope="col">Nombres</td>
		<td scope="col">Email</td>
		<td scope="col">Direccion</td>
		<td scope="col">Telefono</td>
		
	</th>
	<% 
		for(ClienteVO dto : listaEstudiantes){ 
	%>
	<tr>
		<td></td>
		<td><%= dto.getNombre_cliente() %></td>		
		<td><%= dto.getEmail_cliente() %></td>		
		<td><%= dto.getDireccion_cliente() %></td>		
		<td><%= dto.getTelefono_cliente() %></td>			
			
	</tr>
<% 
		}
		} %>
</form>

</body>
</html>