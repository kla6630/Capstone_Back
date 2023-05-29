package it.cp.eb.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cp.eb.auth.entity.ERole;
import it.cp.eb.auth.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
