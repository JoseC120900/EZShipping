package pe.edu.upc.ezshipping.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ezshipping.models.entities.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	Optional<Estado> findByNombre(String nombre) throws Exception;
}
