package pe.edu.upc.ezshipping.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	private Integer idc = 1;

	@GetMapping
	public String index(Model model) {

		try {
			Optional<Persona> optional = personaService.findById(idc);
			if (optional.isPresent()) {
				model.addAttribute("persona", optional.get());
			} else {
				return "";
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			Optional<Cliente> optional = clienteService.findById(idc);
			if (optional.isPresent()) {
				model.addAttribute("cliente", optional.get());
			} else {
				return "";
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			List<Envio> envios = envioService.findAll();
			List<Envio> buscados = new ArrayList<>();
			List<Envio> buscados2 = new ArrayList<>();
			List<Envio> buscados3 = new ArrayList<>();
			List<Envio> ultimos = new ArrayList<>();
			// Calendar c1 = Calendar.getInstance();
			// List<EstadoEnvio> uEstado= new ArrayList<EstadoEnvio>();

			// Date fechaEstado;

			for (int indice = 0; indice < envios.size(); indice++) {
				if (envios.get(indice).getClienteId() == idc) {

					buscados2.add(envios.get(indice));
					buscados.add(envios.get(indice));
				}

			}

			for (int i = 0; i < 2; i++) {
				int mayor = 0;
				int pos = 0;
				for (int indice = 0; indice < buscados2.size(); indice++) {
					if (buscados2.get(indice).getId() > mayor) {
						mayor = buscados2.get(indice).getId();
						pos = indice;
					}

				}
				ultimos.add(buscados2.get(pos));
				buscados2.remove(pos);
			}

			for (int indice = 0; indice < buscados2.size(); indice++) {
				buscados3.add(buscados2.get(indice));

			}

			// imagenes

			for (int indice = 0; indice < ultimos.size(); indice++) {

				if (ultimos.get(indice).getEstadoEnvios().get(ultimos.get(indice).getEstadoEnvios().size() - 1)
						.getEstado().getId() == 1) {
					ultimos.get(indice).setUrlImagen("/images/estados/cola.jpg");
				}

				else if (ultimos.get(indice).getEstadoEnvios().get(ultimos.get(indice).getEstadoEnvios().size() - 1)
						.getEstado().getId() == 2) {
					ultimos.get(indice).setUrlImagen("/images/estados/enviado.jpg");
				}

				else {
					ultimos.get(indice).setUrlImagen("/images/estados/recibido.jpg");

				}
			}

			for (int indice = 0; indice < buscados3.size(); indice++) {

				if (buscados3.get(indice).getEstadoEnvios().get(buscados3.get(indice).getEstadoEnvios().size() - 1)
						.getEstado().getId() == 1) {
					buscados3.get(indice).setUrlImagen("/images/estados/cola.jpg");
				}

				else if (buscados3.get(indice).getEstadoEnvios().get(buscados3.get(indice).getEstadoEnvios().size() - 1)
						.getEstado().getId() == 2) {
					buscados3.get(indice).setUrlImagen("/images/estados/enviado.jpg");
				}

				else {
					buscados3.get(indice).setUrlImagen("/images/estados/recibido.jpg");

				}
			}

			model.addAttribute("ultimos", ultimos);
			model.addAttribute("envios", buscados3);
			// model.addAttribute("estadoEnvios2", uEstado);
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
		List<Paquete> lPaquete = new ArrayList<Paquete>();
		List<EstadoEnvio> uEstado = new ArrayList<EstadoEnvio>();
		try {
			optional = envioService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("envio", optional.get());
				optional2 = tarjetaService.findById(optional.get().getTarjetaId());
				model.addAttribute("tarjeta", optional2.get());

				for (int indice = 0; indice < optional.get().getEstadoEnvios().size(); indice++) {
					uEstado.add(optional.get().getEstadoEnvios().get(indice));

				}
				model.addAttribute("estadoEnvios", uEstado);
				/*
				 * for(int indice = 0; indice<uEstado.size();indice++) { optional3 =
				 * estadoService.findById(uEstado.get(indice).getEstado().getId());
				 * model.addAttribute("estado", optional3.get()); }
				 */
				for (int indice = 0; indice < optional.get().getPaquetes().size(); indice++) {
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
	public String viewCourier(@PathVariable("id") Integer id, Model model) {
		Optional<Trabajador> optional;
		Optional<Persona> optional2;
		List<Envio> enviosCourierCliente = new ArrayList<Envio>();
		String nombreApellido;
		Integer totalEnvios = 0;

		try {

			optional = trabajadorService.findById(id);
			optional2 = personaService.findById(optional.get().getPersonaId());
			List<Envio> envios = envioService.findAll();

			for (int indice = 0; indice < envios.size(); indice++) {
				if (envios.get(indice).getTrabajadorId() == id) {

					totalEnvios++;

					if (envios.get(indice).getClienteId() == idc) {
						enviosCourierCliente.add(envios.get(indice));
					}
				}

			}

			for (int indice = 0; indice < enviosCourierCliente.size(); indice++) {

				if (enviosCourierCliente.get(indice).getEstadoEnvios()
						.get(enviosCourierCliente.get(indice).getEstadoEnvios().size() - 1).getEstado().getId() == 1) {
					enviosCourierCliente.get(indice).setUrlImagen("/images/estados/cola.jpg");
				}

				else if (enviosCourierCliente.get(indice).getEstadoEnvios()
						.get(enviosCourierCliente.get(indice).getEstadoEnvios().size() - 1).getEstado().getId() == 2) {
					enviosCourierCliente.get(indice).setUrlImagen("/images/estados/enviado.jpg");
				}

				else {
					enviosCourierCliente.get(indice).setUrlImagen("/images/estados/recibido.jpg");

				}
			}

			nombreApellido = optional2.get().getNombre() + " " + optional2.get().getApellido();

			model.addAttribute("persona", optional2.get());
			model.addAttribute("courier", optional.get());
			model.addAttribute("envios", enviosCourierCliente);
			model.addAttribute("nombreApellidos", nombreApellido);
			model.addAttribute("totalEnvios", totalEnvios);

			return "lista_envios/viewCourier";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/lista_envios/view";
	}

}
