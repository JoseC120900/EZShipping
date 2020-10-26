package pe.edu.upc.ezshipping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ezshipping.models.entities.Persona;
import pe.edu.upc.ezshipping.services.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<Persona> personas = personaService.findAll();
			model.addAttribute("personas", personas);
		} catch (Exception e) {	
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/personas/index";
	}
}
