package pe.edu.upc.ezshipping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.ezshipping.models.entities.Tarjeta;
import pe.edu.upc.ezshipping.services.TarjetaService;

@Controller
@RequestMapping("/tarjetas")
@SessionAttributes("tarjeta")
public class TarjetasController {
	@Autowired
	private TarjetaService tarjetaService;
	
	@GetMapping
	public String index(Model model) {
		Tarjeta tarjeta = new Tarjeta();
		try {
			model.addAttribute("tarjeta", tarjeta);
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/tarjetas/index";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("tarjeta") Tarjeta tarjeta, SessionStatus status) {
		try {
			tarjetaService.save(tarjeta);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tarjetas";
	}
}
