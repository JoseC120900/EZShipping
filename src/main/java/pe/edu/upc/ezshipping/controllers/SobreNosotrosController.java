package pe.edu.upc.ezshipping.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/sobreNosotros")
@SessionAttributes("sobreNosotros")
public class SobreNosotrosController {

	@GetMapping
	public String index(Model model) {
		try {

		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/sobreNosotros/index";
	}
	
}
