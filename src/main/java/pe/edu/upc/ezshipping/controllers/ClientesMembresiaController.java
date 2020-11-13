package pe.edu.upc.ezshipping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import pe.edu.upc.ezshipping.models.entities.TipoCliente;
import pe.edu.upc.ezshipping.services.TipoClienteService;

@Controller
@RequestMapping("/clientesmembresia")
public class ClientesMembresiaController {
    @Autowired
    private TipoClienteService tipoClienteService;

    @GetMapping
	public String index(Model model) {
		try {
			List<TipoCliente> tipoClientes = tipoClienteService.findAll();
			model.addAttribute("tipoClientes", tipoClientes);
		} catch (Exception e) {	
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/clientesmembresia/index";
	}

}
