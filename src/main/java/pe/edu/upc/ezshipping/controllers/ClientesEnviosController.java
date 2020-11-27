package pe.edu.upc.ezshipping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ezshipping.models.entities.Envio;
import pe.edu.upc.ezshipping.services.EnvioService;

@Controller
@RequestMapping("/clientesenvios")
public class ClientesEnviosController {
	@Autowired
	private EnvioService envioService;
	
	
	
	@GetMapping
	public String index(Model model) {
	try {
		List<Envio> envios =  envioService.findAll();
		model.addAttribute("envios", envios);
		model.addAttribute("count", envioService.count());
	}catch (Exception e) {	
		e.printStackTrace();
		System.err.println(e.getMessage());
	}		
		
		return "/clientesenvios/index";
	}

}
