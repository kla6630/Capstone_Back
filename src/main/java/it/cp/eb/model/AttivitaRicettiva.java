package it.cp.eb.model;

import it.cp.eb.enums.TipologiaAttivita;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attivita_ricettive")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AttivitaRicettiva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String citta;

	@Column(nullable = false)
	private String indirizzo;
	
	@Column(columnDefinition = "TEXT", nullable=false)
	private String descrizione;
	
	@Column
	(nullable=false)
	private Long prezzoMinimo;

	@Enumerated(EnumType.STRING)
	private TipologiaAttivita tipologiaAttivita;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(name = "numero_di_telefono", nullable = false)
	private String telefono;

	@Column(nullable = false)
	private String immagine;

}
