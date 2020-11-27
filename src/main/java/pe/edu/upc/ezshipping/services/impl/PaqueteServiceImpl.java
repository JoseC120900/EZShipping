package pe.edu.upc.ezshipping.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ezshipping.models.entities.Paquete;
import pe.edu.upc.ezshipping.models.repositories.PaqueteRepository;
import pe.edu.upc.ezshipping.services.PaqueteService;

@Service
public class PaqueteServiceImpl implements PaqueteService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PaqueteRepository paqueteRepository;

	@Transactional
	@Override
	public Paquete save(Paquete entity) throws Exception {
		return paqueteRepository.save(entity);
	}

	@Transactional
	@Override
	public Paquete update(Paquete entity) throws Exception {
		return paqueteRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		paqueteRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Paquete> findById(Integer id) throws Exception {
		return paqueteRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Paquete> findAll() throws Exception {
		return paqueteRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Paquete> findByDescripcion(String descripcion) throws Exception {
		return paqueteRepository.findByDescripcion(descripcion);
	}
	
	@Transactional
	@Override
	public long count() throws Exception {
		return paqueteRepository.count();
	}
}
