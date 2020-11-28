package pe.edu.upc.ezshipping.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.ezshipping.models.entities.Reclamo;
import pe.edu.upc.ezshipping.services.ReclamoService;

@Controller
@RequestMapping("/reclamos")
@SessionAttributes("reclamo")
public class ReclamoController {

	@Autowired
	private ReclamoService reclamoService;

	@GetMapping
	public String index(Model model) {
		Reclamo reclamo = new Reclamo();
		try {
			List<Reclamo> reclamos = reclamoService.findAll();
			model.addAttribute("reclamos", reclamos);
			model.addAttribute("reclamo", reclamo);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/reclamos/index";
	}

	// /reclamos/save
	@PostMapping("save")
	public String save(@ModelAttribute("reclamo") Reclamo reclamo, SessionStatus status) {
		try {
			reclamo.setFechaReclamo(new Date()); //guarda la fecha de actual al ejecutar save()
			reclamoService.save(reclamo);
			status.setComplete();
			// System.out.println(reclamo.getFechaReclamo());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		// Devuelve la URL mapping
		return "/reclamos/reclamoRegistrado";
	}
}
