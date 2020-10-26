package pe.edu.upc.ezshipping.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ezshipping.models.entities.Tarjeta;
import pe.edu.upc.ezshipping.models.repositories.TarjetaRepository;
import pe.edu.upc.ezshipping.services.TarjetaService;

@Service
public class TarjetaServiceImpl implements TarjetaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private TarjetaRepository tarjetaRepository;

	@Transactional
	@Override
	public Tarjeta save(Tarjeta entity) throws Exception {
		return tarjetaRepository.save(entity);
	}

	@Transactional
	@Override
	public Tarjeta update(Tarjeta entity) throws Exception {
		return tarjetaRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		tarjetaRepository.deleteById(id);

	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Tarjeta> findById(Integer id) throws Exception {
		return tarjetaRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Tarjeta> findAll() throws Exception {
		return tarjetaRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Tarjeta> findByNroTarjeta(String nroTarjeta) throws Exception {
		return tarjetaRepository.findByNroTarjeta(nroTarjeta);
	}

}
