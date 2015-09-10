package rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Persona;
import rest.to.GetPersonasResponse;
import rest.to.PostPersonaRequest;
import rest.to.PutPersonaRequest;
import service.PersonaService;

@RestController
@RequestMapping("/personas*")
public class PersonaRestController {
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ModelMapper modelMapper;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody GetPersonasResponse obtenerPersonas() {
		Type listType = new TypeToken<List<GetPersonasResponse.Persona>>() {}.getType();
		List<GetPersonasResponse.Persona> personas = 
				modelMapper.map(personaService.obtenerPersonas(), listType);

		return new GetPersonasResponse(personas);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void eliminar(@PathVariable Integer id) {
		personaService.eliminarPersona(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void agregar(@RequestBody PostPersonaRequest request) {
		Persona p = modelMapper.map(request, Persona.class);
		personaService.agregarPersona(p);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void agregar(
			@PathVariable Integer id,
			@RequestBody PutPersonaRequest request) {
		Persona p = modelMapper.map(request, Persona.class);
		p.setId(id);
		personaService.modificarPersona(p);
	}
}





