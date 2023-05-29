package it.cp.eb.auth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cp.eb.auth.entity.User;
import it.cp.eb.auth.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public List<User> trovaTuttiGliUser() {
		return (List<User>) repo.findAll();
	}

	public User getUser(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("L'utente non esiste");
		}
		return repo.findById(id).get();
	}

	public User creaUser(User user) {
		if (repo.existsByEmail(user.getEmail())) {
			throw new EntityExistsException("L'indirizzo email è già registrato nei nostri sistemi");
		} else {
			repo.save(user);
		}
		return user;
	}

	public String cancellaUser(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("L'utente non esiste");
		}
		repo.deleteById(id);
		return "L'Utente è stato rimosso";
	}

	public User modificaUser(User user) {
		if (!repo.existsById(user.getId())) {
			throw new EntityExistsException("L'Attivita ricettiva non esiste");
		}
		repo.save(user);
		return user;
	}

}
