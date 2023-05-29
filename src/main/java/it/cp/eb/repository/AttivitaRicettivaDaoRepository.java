package it.cp.eb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.cp.eb.model.AttivitaRicettiva;

@Repository
public interface AttivitaRicettivaDaoRepository extends CrudRepository<AttivitaRicettiva, Long> {
	// Crud repository permette di aggiungere anche delle funzionalità custom!

	// funzionalità che va a verificare se esiste un indirizzo email
	public boolean existsByEmail(String email);

	// funzionalità che ricerca l'utente attraverso l'email
	public AttivitaRicettiva findByEmail(String email);



}