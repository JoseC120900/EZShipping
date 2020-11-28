package pe.edu.upc.ezshipping.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.ezshipping.models.entities.TipoCliente;
import pe.edu.upc.ezshipping.services.TipoClienteService;

@Controller
@RequestMapping("/precios")
public class PrecioController {
	
	@Autowired
	private TipoClienteService tipoclienteService;
	
	@GetMapping
	public String index(Model model) { //Metodo para cargar la página
		//new
		//distrito.setProvincia("Lima"); //Se pueden colocar valores por defecto 
		
		try {
			List<TipoCliente> tipos = tipoclienteService.findAll();
			model.addAttribute("tipos", tipos);				
		} catch (Exception e) {	
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		//Devuelve el nombre del archivo html
		return "/precios/index";
	}
	
	@GetMapping("search-{id}")
	public String search(@PathVariable("id") Integer id, Model model) { //indica la variable que está ingresando
		try {
			Optional<TipoCliente> optional = tipoclienteService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("tipoCliente", optional.get());
				return "precios/search";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/precios";
	}

}
