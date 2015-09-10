package rest.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import rest.to.GetPersonasResponse;
import service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaRestController {
	@Autowired
	private PersonaService personaService;
	@Autowired
	private ModelMapper modelMapper;
	
	@RequestMapping(value="", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody GetPersonasResponse obtenerPersonas() {
		GetPersonasResponse response = new GetPersonasResponse();
		
		try {
			Type listType = new TypeToken<List<GetPersonasResponse.Persona>>() {}.getType();
			List<GetPersonasResponse.Persona> personas =
					modelMapper.map(personaService.obtenerPersonas(), listType);
			
			response.setData(personas);
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(GetPersonasResponse.Status.ERROR);
			response.setData(e.getMessage());
		}
		
		return response;
	}
}
