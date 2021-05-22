<%@page import="com.fatima.Dao.CLSArchivos"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%CLSArchivos archivos = new CLSArchivos();
	String nombreimagen= archivos.seleccionararchivos(); %>

<img alt="" src="Files/<%=nombreimagen%>">
<h1><%=nombreimagen%></h1>
<a href="Files/Guia 2 de Fisica.pdf">Abrir PDF</a>
</body>
</html>