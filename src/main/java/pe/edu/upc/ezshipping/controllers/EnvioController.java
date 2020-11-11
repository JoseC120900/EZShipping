package pe.edu.upc.ezshipping.controllers;



import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.ezshipping.models.entities.Cliente;
import pe.edu.upc.ezshipping.models.entities.Envio;
import pe.edu.upc.ezshipping.models.entities.Estado;
import pe.edu.upc.ezshipping.models.entities.EstadoEnvio;
import pe.edu.upc.ezshipping.models.entities.Paquete;
import pe.edu.upc.ezshipping.models.entities.Persona;
import pe.edu.upc.ezshipping.models.entities.Tarjeta;
import pe.edu.upc.ezshipping.models.entities.Trabajador;
import pe.edu.upc.ezshipping.services.ClienteService;
import pe.edu.upc.ezshipping.services.EnvioService;
import pe.edu.upc.ezshipping.services.EstadoService;
import pe.edu.upc.ezshipping.services.PaqueteService;
import pe.edu.upc.ezshipping.services.PersonaService;
import pe.edu.upc.ezshipping.services.TarjetaService;
import pe.edu.upc.ezshipping.services.TrabajadorService;

@Controller
@RequestMapping("/lista_envios")
@SessionAttributes("cliente")
public class EnvioController {

	@Autowired
	private EnvioService envioService;
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private TarjetaService tarjetaService;
	
	private EstadoService estadoService;
	
	@Autowired
	private PaqueteService paqueteService;
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	private Integer id=2;
	@GetMapping
	public String index(Model model) {
		
		
		
		try {
			Optional <Persona> optional = personaService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("persona", optional.get());
			}
			else {
				return "";
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Optional <Cliente> optional = clienteService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("cliente", optional.get());
			}
			else {
				return "";
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			List<Envio> envios = envioService.findAll();
			List<Envio> buscados=new ArrayList<>();
			List<Envio> buscados2=new ArrayList<>();
			List<Envio> ultimos=new ArrayList<>();
			Calendar c1 = Calendar.getInstance();
			
			
			for(int indice = 0; indice<envios.size();indice++) {
				if(envios.get(indice).getClienteId() == id) {
					buscados.add(envios.get(indice));
					buscados2.add(envios.get(indice));
				}
					
			}
			
			
			for(int i=0;i<2;i++) {
				int mayor=0;
			for(int indice=0; indice<buscados2.size();indice++) {
				if(buscados2.get(indice).getId()>mayor) {
					mayor=indice;
				}
				
			}
			ultimos.add(buscados2.get(mayor));
			buscados2.remove(mayor);
			}
			
			/*
			for(int indice=0;indice<buscados.size();indice++) {
				for(int indice2=0;indice2<buscados.get(indice).getEstadoEnvios().size();indice2++) {
				if(buscados.get(indice).getEstadoEnvios().get(indice2).getFechaEstadoPedido().after(c1.get(Calendar.MONTH))) {
				
				}
				}
			}
			*/
			model.addAttribute("ultimos", ultimos);
			model.addAttribute("envios", buscados);
		}
			
		
		 catch (Exception e) {	
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/lista_envios/index";
	}
	
	@GetMapping("view-{id}")
	public String view(@PathVariable("id") Integer id, Model model) {
		Optional<Envio> optional;
		Optional<Tarjeta> optional2;
		List<Paquete> lPaquete=new ArrayList<Paquete>();
		List<EstadoEnvio> uEstado= new ArrayList<EstadoEnvio>();
		try {
			optional = envioService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("envio", optional.get());
				optional2 = tarjetaService.findById(optional.get().getTarjetaId());
				model.addAttribute("tarjeta", optional2.get());
				
				for(int indice = 0; indice<optional.get().getEstadoEnvios().size();indice++) {
					uEstado.add(optional.get().getEstadoEnvios().get(indice));
					
					}
				model.addAttribute("estadoEnvios", uEstado);
			/*	for(int indice = 0; indice<uEstado.size();indice++) {
						optional3 = estadoService.findById(uEstado.get(indice).getEstado().getId());
						model.addAttribute("estado", optional3.get());		
					}
				*/
				for(int indice = 0; indice<optional.get().getPaquetes().size();indice++) {
					lPaquete.add(optional.get().getPaquetes().get(indice));
					}
				model.addAttribute("paquetes", lPaquete);
				
				
				
				return "lista_envios/view";
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "redirect:/lista_envios";
	
		
	}
	
	@GetMapping("viewCourier-{id}")
	public String viewCourier(@PathVariable("id") Integer id, Model model)
	{
		Optional<Trabajador> optional;
		Optional<Persona> optional2;
		
		try {
			
			optional = trabajadorService.findById(id);
			optional2 = personaService.findById(optional.get().getPersonaId());
			model.addAttribute("persona", optional2.get());
			model.addAttribute("courier", optional.get());
			
			return "lista_envios/viewCourier";
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "redirect:/lista_envios/view";
	}
	
}
