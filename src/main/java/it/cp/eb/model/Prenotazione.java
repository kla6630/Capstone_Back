package it.cp.eb.model;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import it.cp.eb.auth.entity.User;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@NonNull
	private User user;
	
	@ManyToOne
	@NonNull
	private AttivitaRicettiva attivitaRicettiva;

	@NonNull
	private LocalDate dataPrenotata;
	
	private LocalDate dataPrenotazione;
	
}
