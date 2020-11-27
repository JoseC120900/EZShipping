package pe.edu.upc.ezshipping.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ezshipping.models.entities.Persona;
import pe.edu.upc.ezshipping.models.repositories.PersonaRepository;
import pe.edu.upc.ezshipping.services.PersonaService;

@Service
public class PesonaServiceImpl implements PersonaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PersonaRepository personaRepository;

	@Transactional
	@Override
	public Persona save(Persona entity) throws Exception {
		return personaRepository.save(entity);
	}

	@Transactional
	@Override
	public Persona update(Persona entity) throws Exception {
		return personaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		personaRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Persona> findById(Integer id) throws Exception {
		return personaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Persona> findAll() throws Exception {
		return personaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Persona> findByEmail(String email) throws Exception {
		return personaRepository.findByEmail(email);

	}
	
	@Transactional
	@Override
	public long count() throws Exception {
		return personaRepository.count();
	}

}
