package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/persona*")
public class PersonaController {
	public static String RUTA_JSP = "/WEB-INF/jsp/persona/inicio.jsp";
	
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String listar() {
		return RUTA_JSP;
	}
}
