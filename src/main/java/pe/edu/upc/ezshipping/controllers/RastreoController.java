package pe.edu.upc.ezshipping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.ezshipping.models.entities.Envio;
import pe.edu.upc.ezshipping.services.EnvioService;

@Controller
@RequestMapping("/rastrear")
@SessionAttributes("{envioSearch, envio}")
public class RastreoController {
	
	@Autowired
	private EnvioService envioService;
	
	//Controller para la página de rastreo de un paquete 
	@GetMapping
	public String rastreo(Model model) {
		Envio envioSearch = new Envio();
		model.addAttribute("envioSearch", envioSearch);
		return "/search-envio/rastreo";
	}
	
	@PostMapping("search")
	public String search(@ModelAttribute("envioSearch") Envio envioSearch, Model model) {
		model.addAttribute("envioSearch", envioSearch);
		List<Envio> envios;
		try {
			envios = envioService.findByCodigoRastreo(envioSearch.getCodigoRastreo());		
			model.addAttribute("envios", envios);					
			
		} catch (Exception e) {		
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "search-envio/resultado-rastreo";
	}
}
