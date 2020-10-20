package pe.edu.upc.ezshipping.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.ezshipping.models.entities.ClienteTarjeta;

public interface ClienteTarjetaRepository extends JpaRepository<ClienteTarjeta, Integer> {
	
}
