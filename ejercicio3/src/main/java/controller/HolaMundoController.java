package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HolaMundoController {
	// Añadir proyecto al tomcat
	// Dentro de la vista Servers (perspectiva JEE)
	// Clic derecho sobre el servidor Apache Tomcat y
	// Add and Remove (agregar el proyecto)
	// Iniciar el tomcat (clic derecho Start Server)
	// En un navegador ejecutar:
	// http://localhost:8080/ejercicio3/holaMundo.do
	@RequestMapping("/holaMundo")
	public @ResponseBody String holaMundo() {
		return "Hola mundo";
	}
}
