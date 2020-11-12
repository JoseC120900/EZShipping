package pe.edu.upc.ezshipping.services.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.ezshipping.models.entities.Envio;
import pe.edu.upc.ezshipping.models.repositories.EnvioRepository;
import pe.edu.upc.ezshipping.services.EnvioService;

@Service
public class EnvioServiceImpl implements EnvioService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private EnvioRepository pedidoRepository;

	@Transactional
	@Override
	public Envio save(Envio entity) throws Exception {
		return pedidoRepository.save(entity);
	}

	@Transactional
	@Override
	public Envio update(Envio entity) throws Exception {
		return pedidoRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		pedidoRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Envio> findById(Integer id) throws Exception {
		return pedidoRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Envio> findAll() throws Exception {
		return pedidoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Envio> findByDireccionOrigen(String direccionOrigen) throws Exception {
		return pedidoRepository.findByDireccionOrigen(direccionOrigen);

	}

	@Transactional(readOnly = true)
	@Override
	public List<Envio> findByDireccionDestino(String direccionDestino) throws Exception {
		return pedidoRepository.findByDireccionDestino(direccionDestino);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Envio> findByCodigoRastreo(String codigoRastreo) throws Exception {
		return pedidoRepository.findByCodigoRastreo(codigoRastreo);		
	}
}
