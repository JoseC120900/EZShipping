package pe.edu.upc.ezshipping.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ezshipping.models.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	// findBy, genera una sentencia JPQL que utiliza el operador =
	Optional<Cliente> findByDNI(String DNI) throws Exception;
}
