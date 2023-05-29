package it.cp.eb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.cp.eb.model.AttivitaRicettiva;
import it.cp.eb.repository.AttivitaRicettivaDaoRepository;
import it.cp.eb.repository.AttivitaRicettivaPageableRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AttivitaRicettivaService {

	@Autowired
	AttivitaRicettivaDaoRepository repo;
	@Autowired
	AttivitaRicettivaPageableRepository repoPageable;

	public List<AttivitaRicettiva> trovaTutteLeAttivitaRicettive() {
		return (List<AttivitaRicettiva>) repo.findAll();
	}

	public AttivitaRicettiva getAttivitaRicettiva(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("L'attività ricettiva non esiste");
		}
		return repo.findById(id).get();
	}

	public AttivitaRicettiva creaAttivitaRicettiva(AttivitaRicettiva attivitaRicettiva) {
		if (repo.existsByEmail(attivitaRicettiva.getEmail())) {
			throw new EntityExistsException("L'indirizzo email è già registrato nei nostri sistemi");
		} else {
			repo.save(attivitaRicettiva);
		}
		return attivitaRicettiva;
	}

	public String cancellaAttivitaRicettiva(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("L'attivita non esiste");
		}
		repo.deleteById(id);
		return "L'Attivita Ricettiva è stata Cancellata";
	}

	public AttivitaRicettiva modificaAttivitaRicettiva(AttivitaRicettiva attivitaRicettiva) {
		if (!repo.existsById(attivitaRicettiva.getId())) {
			throw new EntityExistsException("L'Attivita ricettiva non esiste");
		}
		repo.save(attivitaRicettiva);
		return attivitaRicettiva;
	}

}
