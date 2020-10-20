package pe.edu.upc.ezshipping.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ezshipping.models.entities.Reclamo;
import pe.edu.upc.ezshipping.models.repositories.ReclamoRepository;
import pe.edu.upc.ezshipping.services.ReclamoService;

@Service
public class ReclamoServiceImpl implements ReclamoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ReclamoRepository reclamoRepository;

	@Transactional
	@Override
	public Reclamo save(Reclamo entity) throws Exception {
		return reclamoRepository.save(entity);
	}

	@Transactional
	@Override
	public Reclamo update(Reclamo entity) throws Exception {
		return reclamoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		reclamoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Reclamo> findById(Integer id) throws Exception {
		return reclamoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Reclamo> findAll() throws Exception {
		return reclamoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Reclamo> findByDescripcion(String descripcion) throws Exception {
		return reclamoRepository.findByDescripcion(descripcion);
	}

}
