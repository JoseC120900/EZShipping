package pe.edu.upc.ezshipping.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.ezshipping.models.entities.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {
	Optional<Tarjeta> findByNumero(String nroTarjeta) throws Exception;
}
