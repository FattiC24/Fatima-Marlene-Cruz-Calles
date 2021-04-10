<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenido</h1>
	<script type="text/javascript">
	$(document).ready(
			function(){
				$.post('ControllerMostrarInformacion',{
					
				}, function(response){
					let datos = JSON.parse(response);
				
					console.log(datos);
					var tabla = document.getElementById('tablaDatos');
					for (let item of datos){
						tabla.inner +=
						<tr>
						<td>${item.idUsuario}</td>
						<td>${item.Usuario}</td>
						<td>${item.Pass}</td>
						<td> <a href="ControllerMostrarInformacion?IdUsuario=${item.idUsuario}&Eliminar=btne" class="btn btn-danger">ELIMINAR</a>
						<a href = "add.jsp?Id=${item.idUsuario}&Usuario=${item.Usuario}&Pass=item.Pass" class="btn btn-warning">ACTUALIZAR</a>
								
					}]
				});
			});

</script>
</body>
</html>