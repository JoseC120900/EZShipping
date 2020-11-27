package pe.edu.upc.ezshipping.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ezshipping.models.entities.Cliente;
import pe.edu.upc.ezshipping.models.entities.Trabajador;
import pe.edu.upc.ezshipping.security.UsuarioDetails;
import pe.edu.upc.ezshipping.services.ClienteService;
import pe.edu.upc.ezshipping.services.TrabajadorService;
import pe.edu.upc.ezshipping.utils.Segmento;

@Controller
@RequestMapping("/perfil")
public class PerfilController {
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TrabajadorService trabajadorService;

	@GetMapping

	public String viewPerfil(Model model) {
		
		// Sentencias para obtener el Segmento y el Id del Segmento
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UsuarioDetails usuarioDetails = (UsuarioDetails) authentication.getPrincipal();

		try {
			if (usuarioDetails.getSegmento() == Segmento.CLIENTE) {
				Optional<Cliente> optional = clienteService.findById(usuarioDetails.getIdSegmento());
				if (optional.isPresent()) {
					model.addAttribute("cliente", optional.get());
				}
			} else if (usuarioDetails.getSegmento() == Segmento.TRABAJADOR) {
				Optional<Trabajador> optional = trabajadorService.findById(usuarioDetails.getIdSegmento());
				if (optional.isPresent()) {
					model.addAttribute("trabajador", optional.get());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "perfil/perfil";
	}
}
