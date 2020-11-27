package pe.edu.upc.ezshipping.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.ezshipping.models.entities.Estado;
import pe.edu.upc.ezshipping.models.repositories.EstadoRepository;
import pe.edu.upc.ezshipping.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EstadoRepository estadoRepository;

	@Transactional
	@Override
	public Estado save(Estado entity) throws Exception {
		return estadoRepository.save(entity);
	}

	@Transactional
	@Override
	public Estado update(Estado entity) throws Exception {
		return estadoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		estadoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Estado> findById(Integer id) throws Exception {
		return estadoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Estado> findAll() throws Exception {
		return estadoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Estado> findByNombre(String nombre) throws Exception {
		return estadoRepository.findByNombre(nombre);
	}

	@Transactional
	@Override
	public long count() throws Exception {
		return estadoRepository.count();
	}
}
