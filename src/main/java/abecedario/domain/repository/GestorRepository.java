package abecedario.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import abecedario.domain.entity.Gestor;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, Long>{
	UserDetails findByEmail(String email);
}
