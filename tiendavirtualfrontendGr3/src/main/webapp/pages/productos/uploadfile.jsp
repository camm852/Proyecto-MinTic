<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ page import="co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SubirArchivo</title>
</head>
<body>
<form method="post" enctype="multipart/form-data"
  action="/uploadCSVFile">
    <input type="file" name="file" accept=".csv" /> 
    <input type="submit" value="Cargar Archivo" />
</form>
<div style="color: red">${errorCargaArchivo}</div>
<div style="color: blue">${cargaArchivo}</div>
</body>
</html>