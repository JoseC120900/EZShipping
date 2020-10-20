package pe.edu.upc.ezshipping.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.ezshipping.models.entities.EstadoEnvio;

@Repository
public interface EstadoEnvioRepository extends JpaRepository<EstadoEnvio, Integer> {

}
