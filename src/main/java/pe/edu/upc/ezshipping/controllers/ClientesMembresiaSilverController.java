package pe.edu.upc.ezshipping.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.ezshipping.models.entities.TipoCliente;
import pe.edu.upc.ezshipping.services.TipoClienteService;

@Controller
@RequestMapping("/clientesmembresiasilver")
public class ClientesMembresiaSilverController {
    @Autowired
    private TipoClienteService tipoClienteService;




    private Integer id=2;
    @GetMapping
	public String index(Model model) {
    	
		try {
			Optional<TipoCliente> optional = tipoClienteService.findById(id);
			
			if(optional.isPresent()) {
				model.addAttribute("tipoClientes", optional.get());
				
			}
			else {
				return "";
			}
		}catch (Exception e) {	
			e.printStackTrace();
			System.err.println(e.getMessage());
		}		
			
			return "/clientesmembresiasilver/index";
		
    }

}