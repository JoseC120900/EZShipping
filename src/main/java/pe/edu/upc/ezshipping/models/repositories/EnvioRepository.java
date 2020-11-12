package pe.edu.upc.ezshipping.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ezshipping.models.entities.Envio;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Integer> {
	List<Envio> findByDireccionOrigen(String direccionOrigen) throws Exception;

	List<Envio> findByDireccionDestino(String direccionDestino) throws Exception;
	
	List<Envio> findByCodigoRastreo(String codigoRastreo) throws Exception;
}
