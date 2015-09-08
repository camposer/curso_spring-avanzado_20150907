<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Personas</title>
	<style>
		h1 {
			text-align: center;
		}
		
		.tabla-centrada {
			margin-left: auto;
			margin-right: auto;
		}
		
		.tabla-datos th {
			background-color: gray;
		}
		
		.tabla-datos tr:nth-child(odd) td {
			background-color: lightgray;
		}
		
		.tabla-datos tr:nth-child(odd) td {
			background-color: darkgray;
		}
		
		.tabla-datos a {
			color: black;
		}
		
		#tabla-form tr:last-child td {
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Personas</h1>
	<form>
		<table id="tabla-form" class="tabla-centrada">
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre"></td>
			</tr>
			<tr>
				<td>Apellido</td>
				<td><input type="text" name="apellido"></td>
			</tr>
			<tr>
				<td>Fecha de nacimiento</td>
				<td><input type="text" name="fechaNacimiento"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Guardar">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<table class="tabla-centrada tabla-datos">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Fecha de nacimiento</th>
				<th>Mostrar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>xxx</td>
				<td>xxx</td>
				<td>xxx</td>
				<td><a href="#">mostrar</a></td>
				<td><a href="#">eliminar</a></td>
			</tr>		
			<tr>
				<td>2</td>
				<td>xxx</td>
				<td>xxx</td>
				<td>xxx</td>
				<td><a href="#">mostrar</a></td>
				<td><a href="#">eliminar</a></td>
			</tr>		
			<tr>
				<td>3</td>
				<td>xxx</td>
				<td>xxx</td>
				<td>xxx</td>
				<td><a href="#">mostrar</a></td>
				<td><a href="#">eliminar</a></td>
			</tr>		
		</tbody>
	</table>

</body>
</html>