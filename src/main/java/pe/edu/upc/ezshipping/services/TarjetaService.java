package pe.edu.upc.ezshipping.services;

import java.util.Optional;

import pe.edu.upc.ezshipping.models.entities.Tarjeta;

public interface TarjetaService extends CrudService<Tarjeta, Integer> {
	Optional<Tarjeta> findByNroTarjeta(String nroTarjeta) throws Exception;
}
