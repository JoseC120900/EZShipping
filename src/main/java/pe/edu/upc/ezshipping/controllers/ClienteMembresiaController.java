package pe.edu.upc.ezshipping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ezshipping.models.entities.Cliente;
import pe.edu.upc.ezshipping.services.ClienteService;
@Controller
@RequestMapping("/clientemembresia")
public class ClienteMembresiaController {
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<Cliente> clientes = clienteService.findAll();
			model.addAttribute("clientes", clientes);
		} catch (Exception e) {	
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/clientemembresia/index";
	}
}