package web.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Persona;
import service.PersonaService;
import web.form.PersonaForm;

@Controller
@RequestMapping("/persona*")
public class PersonaController {
	public static String RUTA_JSP = "/WEB-INF/jsp/persona/inicio.jsp";
	
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ModelMapper modelMapper;
	
	private void init(Model model) {
		model.addAttribute("personas", personaService.obtenerPersonas());
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String listar(Model model) {
		init(model);
		return RUTA_JSP;
	}

	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardar(PersonaForm personaForm, Model model) {
		List<String> errores = new ArrayList<>();
		
		if (personaForm.getNombre() == null || 
				personaForm.getNombre().trim().equals(""))
			errores.add("Nombre inválido");
		
		if (personaForm.getApellido() == null || 
				personaForm.getApellido().trim().equals(""))
			errores.add("Apellido inválido");

		if (errores.size() == 0) {
			try {
				Persona p = modelMapper.map(personaForm, Persona.class);
				
				if (p.getId() != null)
					personaService.modificarPersona(p);
				else
					personaService.agregarPersona(p);
			} catch (Exception e) {
				e.printStackTrace();
				errores.add("Error al guardar en BD");
			}
		}
		
		if (errores.size() == 0)
			return "redirect:/persona/inicio.do";
		else {
			init(model);
			model.addAttribute("errores", errores);
			model.addAttribute("personaForm", personaForm);
			return RUTA_JSP;
		}
	}
	
	@RequestMapping(value = "/eliminar", method = RequestMethod.GET)
	public String eliminar(@RequestParam Integer id, Model model) {
		List<String> errores = new ArrayList<>();
		
		try {
			personaService.eliminarPersona(id);
		} catch (Exception e) {
			e.printStackTrace();
			errores.add("Error al eliminar la persona de la BD");
		}
		
		if (errores.size() == 0) 
			return "redirect:/persona/inicio.do";
		else {
			init(model);
			model.addAttribute("errores", errores);
			return RUTA_JSP;
		}
	}

	@RequestMapping(value = "/mostrar", method = RequestMethod.GET)
	public String mostrar(@RequestParam Integer id, Model model) {
		List<String> errores = new ArrayList<>();
		
		try {
			Persona p = personaService.obtenerPersona(id);
			model.addAttribute(modelMapper.map(p, PersonaForm.class));
		} catch (Exception e) {
			e.printStackTrace();
			errores.add("Error al consultar persona de la BD");
		}
		
		if (errores.size() > 0) 
			model.addAttribute("errores", errores);

		init(model);
		return RUTA_JSP;
	}

}
