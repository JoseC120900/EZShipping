package pe.edu.upc.ezshipping.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.ezshipping.models.entities.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer> {
}
