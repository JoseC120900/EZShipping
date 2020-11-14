package pe.edu.upc.ezshipping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filtrarFecha")
public class FiltrarFechaController {
	
	@GetMapping
	public String index(Model model) {
		return "/filtrarFecha/index";
	}
}
