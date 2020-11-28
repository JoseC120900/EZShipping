package pe.edu.upc.ezshipping.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.ezshipping.models.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
