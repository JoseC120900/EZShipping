package pe.edu.upc.ezshipping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/terminosplata")
public class TerminosPlataController {
	
	@GetMapping
	public String index(Model model) {
		
		return "/terminosplata/index";
	}
}