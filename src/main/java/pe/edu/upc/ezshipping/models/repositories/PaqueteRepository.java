package pe.edu.upc.ezshipping.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ezshipping.models.entities.Paquete;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {
	Optional<Paquete> findByDescripcion(String descripcion) throws Exception;
}
