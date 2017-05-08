<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Viajes</title>
</head>
<body>
	<h2>Listar Viajes Abiertos</h2>	
	<a href="http://localhost:8080/MuberRESTful/rest/services/viajes/abiertos">Enviar</a>
	
	<h2>Crear nuevo viaje</h2>	
	<form action="http://localhost:8080/MuberRESTful/rest/services/viajes/nuevo" method="post">
		<p>
			<b>Origen:</b> <input type="text" name="origen">
		</p>
		<p>
			<b>Destino:</b> <input type="text" name="destino">
		</p>
		<p>
			<b>Conductor:</b> <input type="long" name="idConductor">
		</p>
		<p>
			<b>Costo Total:</b> <input type="float" name="costoTotal">
		</p>
		<p>
			<b>Cant max pasajeros:</b> <input type="number" name="maxPasajeros" min="1" max="4">
		</p>
		
		<p><input type="submit"></p> 
	</form>
	
	
</body>
</html>