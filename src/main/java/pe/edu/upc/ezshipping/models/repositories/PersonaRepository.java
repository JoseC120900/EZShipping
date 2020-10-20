package pe.edu.upc.ezshipping.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.ezshipping.models.entities.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	// Se debe de implementa la Sentencia cuando se utiliza otro operador, utilizar el fetch
	//@Query("SELECT c FROM Cliente c WHERE UPPER(c.nombresApellidos) LIKE CONCAT('%',UPPER(:nombresApellidos),'%'")
	//List<Cliente> fetchByNombresApellidos(String nombresApellidos) throws Exception;
	Optional<Persona> findByEmail(String email) throws Exception;

}
