package pe.edu.upc.ezshipping.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ezshipping.models.entities.Cliente;
import pe.edu.upc.ezshipping.models.entities.TipoCliente;
import pe.edu.upc.ezshipping.security.UsuarioDetails;
import pe.edu.upc.ezshipping.services.ClienteService;
import pe.edu.upc.ezshipping.services.TipoClienteService;

@Controller
@RequestMapping("/membresias")
public class TipoClientesController {
	@Autowired
	private TipoClienteService tipoClienteService;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public String index(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();
		
		try {
			Optional<Cliente> optional = clienteService.findById(usuarioDetails.getIdSegmento());
			if(optional.isPresent()) {
				model.addAttribute("cliente", optional.get());
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		try {
			List<TipoCliente> tipoClientes = tipoClienteService.findAll();
			model.addAttribute("tipoClientes", tipoClientes);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/tipoClientes/index";
	}

	@GetMapping("view-{nombre}")
	public String view(@PathVariable("nombre") String nombre, Model model) {
		try {
			Optional<TipoCliente> optional = tipoClienteService.findByNombre(nombre);
			if (optional.isPresent()) {
				model.addAttribute("tipoCliente", optional.get());
				return "tipoClientes/view";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tipoClientes";
	}

}
