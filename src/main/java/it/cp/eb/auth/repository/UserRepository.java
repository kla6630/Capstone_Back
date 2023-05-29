package it.cp.eb.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.cp.eb.auth.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
