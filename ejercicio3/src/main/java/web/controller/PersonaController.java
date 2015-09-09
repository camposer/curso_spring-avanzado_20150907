package web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
				String fechaNacimiento = personaForm.getFechaNacimiento();
				personaForm.setFechaNacimiento(null);
				
				Persona p = modelMapper.map(personaForm, Persona.class);
				p.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(fechaNacimiento));
				
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
}
