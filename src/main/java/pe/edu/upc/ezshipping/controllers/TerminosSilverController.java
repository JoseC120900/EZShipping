package pe.edu.upc.ezshipping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/terminossilver")
public class TerminosSilverController {
	
	@GetMapping
	public String index(Model model) {
		
		return "/terminossilver/index";
	}
}