package pe.edu.upc.ezshipping.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ezshipping.models.entities.Trabajador;
import pe.edu.upc.ezshipping.models.repositories.TrabajadorRepository;
import pe.edu.upc.ezshipping.services.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TrabajadorRepository trabajadorRepository;

	@Transactional
	@Override
	public Trabajador save(Trabajador entity) throws Exception {
		return trabajadorRepository.save(entity);
	}

	@Transactional
	@Override
	public Trabajador update(Trabajador entity) throws Exception {
		return trabajadorRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		trabajadorRepository.deleteById(id);

	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Trabajador> findById(Integer id) throws Exception {
		return trabajadorRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Trabajador> findAll() throws Exception {
		return trabajadorRepository.findAll();
	}
}
