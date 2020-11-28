package pe.edu.upc.ezshipping.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.ezshipping.models.entities.Envio;
import pe.edu.upc.ezshipping.models.entities.Paquete;
import pe.edu.upc.ezshipping.models.entities.Tarjeta;
import pe.edu.upc.ezshipping.models.entities.Trabajador;
import pe.edu.upc.ezshipping.services.EnvioService;
import pe.edu.upc.ezshipping.services.PaqueteService;
import pe.edu.upc.ezshipping.services.TarjetaService;
import pe.edu.upc.ezshipping.services.TrabajadorService;

@Controller
@RequestMapping("/envio")
@SessionAttributes("envio")
public class MainEnvioController {
	
	@Autowired
	private EnvioService envioService;
	
	@Autowired
	private TarjetaService tarjetaService;
	
	@Autowired
	private TrabajadorService trabajadorService;
	
	@Autowired
	private PaqueteService paqueteService;
		
	//para el main page
	@GetMapping("/new")
	public String nuevo(Model model) {	
		Envio envio = new Envio();
		envio.setMonto((float) 0);;
		
		ArrayList<Tarjeta> tarjetas = new ArrayList<Tarjeta>();
		ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
		Trabajador trabajadorAleatorio = new Trabajador();
		
		//Get tarjetas
		try {
			for (Tarjeta tar:tarjetaService.findAll()) {
				tarjetas.add(tar);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		
		if(tarjetas.isEmpty()) {
			return "/precios";
		}
		
		//Get trabajador aleatorio
		try {
			for (Trabajador tra:trabajadorService.findAll()) {
				trabajadores.add(tra);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		trabajadorAleatorio = trabajadores.get(0);		
		int random_number =  (int) (Math.random() * (999 - 100 + 1) + 100);		
		String new_code = "UPC2020"+ String.valueOf(random_number);
		envio.setCodigoRastreo(new_code);
		
		model.addAttribute("trabajador", trabajadorAleatorio);
		model.addAttribute("tarjetas", tarjetas);
		model.addAttribute("envio", envio);
		return "/generate-envio/nuevo";
	}
	
	//add packages of envio
	@PostMapping("/detail")
	public String detail(@Validated @ModelAttribute("envio") Envio envio, BindingResult result, Model model, SessionStatus status) {
		try {			
			envioService.save(envio);
			status.setComplete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		Paquete paquete = new Paquete();
		System.out.println(envio.getId());
		paquete.setEnvio(envio);
		
		model.addAttribute("paquete", paquete);	
		model.addAttribute("envio", envio);
		
		return "/generate-envio/packages";
	}
	
	@PostMapping("/detail/confirm")
	public String confirm(@Validated @ModelAttribute("paquete") Paquete paquete, BindingResult result, Model model, SessionStatus status) {
		try {
			paqueteService.save(paquete);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Optional<Envio> envio = envioService.findById(paquete.getEnvioId());
			envio.get().setMonto(paquete.getPrecioUnitario());
			envioService.update(envio.get());
			
			model.addAttribute("envio", envio);
			model.addAttribute("paquete", paquete);
			System.out.println(envio.get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return "/generate-envio/confirm";
	}
	
	@GetMapping("/back")
	public String back() {
		return "redirect:/";
	}


	
}
