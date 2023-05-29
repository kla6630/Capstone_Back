package it.cp.eb.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.cp.eb.enums.TipologiaAttivita;
import it.cp.eb.model.AttivitaRicettiva;
import it.cp.eb.service.AttivitaRicettivaService;

//@CrossOrigin
@RestController // per creare delle API
@RequestMapping("attivitaricettive")
public class AttivitaRicettivaController {

	@Autowired
	AttivitaRicettivaService attivitaRicettivaService;

	// Metodo per trovare tutte le attivita ricettive

	@GetMapping
	public ResponseEntity<?> trovaTutteLeAttivitaRicettive() {
		return new ResponseEntity<List<AttivitaRicettiva>>(attivitaRicettivaService.trovaTutteLeAttivitaRicettive(),
				HttpStatus.OK);
	}

	// Metodo per trovare singola attivita ricettiva tramite id
	@GetMapping("/id/{id}")
	public ResponseEntity<?> trovaAttivitaRicettiva(@PathVariable Long id) {
		return new ResponseEntity<AttivitaRicettiva>(attivitaRicettivaService.getAttivitaRicettiva(id), HttpStatus.OK);
	}

	// Metodo per trovare tutte le attivita ricettive tramite tipologia (enum)

	@GetMapping("/tipologia/{tipologiaAttivita}")
	public ResponseEntity<List<AttivitaRicettiva>> trovaTutteLeAttivitaRicettive(
			@PathVariable String tipologiaAttivita) {
		List<AttivitaRicettiva> attivitaRicettive = attivitaRicettivaService.trovaTutteLeAttivitaRicettive();
		if (tipologiaAttivita != null) {
			try {
				TipologiaAttivita enumTipologiaAttivita = TipologiaAttivita.valueOf(tipologiaAttivita.toUpperCase());
				attivitaRicettive = attivitaRicettive.stream()
						.filter(a -> a.getTipologiaAttivita() == enumTipologiaAttivita).collect(Collectors.toList());
			} catch (IllegalArgumentException e) {

			}
		}
		return ResponseEntity.ok(attivitaRicettive);
	}

	// Metodo per creare una nuova attivitita ricettiva

	@PostMapping
	public ResponseEntity<?> creaAttivitaRicettiva(@RequestBody AttivitaRicettiva attivitaRicettiva) {
		return new ResponseEntity<AttivitaRicettiva>(attivitaRicettivaService.creaAttivitaRicettiva(attivitaRicettiva),
				HttpStatus.CREATED);
	}

	// Metodo per cancellare un'attivita ricettiva tramite id

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> cancellaAttivitaRicettiva(@PathVariable Long id) {
		return new ResponseEntity<String>(attivitaRicettivaService.cancellaAttivitaRicettiva(id), HttpStatus.OK);
	}

	// Metodo per modificare un'attivita ricettiva tramite id

//	@PutMapping("/{id}")
//	public ResponseEntity<?> modificaAttivitaRicettiva(@RequestBody AttivitaRicettiva attivitaRicettiva) {
//		return new ResponseEntity<AttivitaRicettiva>(attivitaRicettivaService.modificaAttivitaRicettiva(attivitaRicettiva), HttpStatus.CREATED);
//	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> modificaAttivitaRicettiva(@PathVariable Long id, @RequestBody AttivitaRicettiva attivitaRicettiva) {
	    // Logic to update AttivitaRicettiva with the given ID using the data in attivitaRicettiva
	    AttivitaRicettiva savedAttivitaRicettiva = attivitaRicettivaService.modificaAttivitaRicettiva(attivitaRicettiva);
	    return new ResponseEntity<AttivitaRicettiva>(savedAttivitaRicettiva, HttpStatus.OK);
	}

}
