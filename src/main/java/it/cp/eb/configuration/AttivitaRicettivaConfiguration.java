package it.cp.eb.configuration;

import java.util.Locale;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.cp.eb.enums.TipologiaAttivita;
import it.cp.eb.model.AttivitaRicettiva;

@Configuration
@PropertySource("classpath:application.properties")
public class AttivitaRicettivaConfiguration {

	@Bean("AttivitaRicettivaFakeBean")
	@Scope("prototype")
	public AttivitaRicettiva nuovaAttivitaRicettivaFake() {
		Faker fake = Faker.instance(new Locale("it-IT"));

		AttivitaRicettiva at = new AttivitaRicettiva();

		Random random = new Random();
		TipologiaAttivita randomTipologiaAttivita = TipologiaAttivita.values()[random
				.nextInt(TipologiaAttivita.values().length)];

		String imageUrl = "https://picsum.photos/1920/1080?random=" + fake.random().nextInt(10);

		// FAKE DESCRIZIONE
		String[] aggettivi = { "fantastica", "bellissima", "comoda", "deliziosa", "incantevole", "affascinante",
				"splendida", "lussuosa", "rilassante", "tranquilla" };
		String[] sostantivi = { "struttura", "casa", "attività" };
		String[] sinonimiStanze = { "stanze", "camere", };

		String descrizione = "Benvenuti nella nostra " + aggettivi[random.nextInt(aggettivi.length)] + " "
				+ sostantivi[random.nextInt(sostantivi.length)] + "! " + "Le nostre "
				+ sinonimiStanze[random.nextInt(sinonimiStanze.length)] + " "
				+ aggettivi[random.nextInt(aggettivi.length)] + " sono progettate per farti sentire "
				+ aggettivi[random.nextInt(aggettivi.length)] + " e " + aggettivi[random.nextInt(aggettivi.length)]
				+ ". " + "Amerai il nostro " + sostantivi[random.nextInt(sostantivi.length)] + " "
				+ aggettivi[random.nextInt(aggettivi.length)] + " e il nostro "
				+ sostantivi[random.nextInt(sostantivi.length)] + " staff "
				+ aggettivi[random.nextInt(aggettivi.length)] + ". " + "Vieni a vivere l'esperienza "
				+ aggettivi[random.nextInt(aggettivi.length)] + " " + sostantivi[random.nextInt(sostantivi.length)]
				+ " oggi!";

		at.setNome(fake.company().name());
		at.setCitta(fake.address().city());
		at.setIndirizzo(fake.address().streetAddress());
		at.setTipologiaAttivita(randomTipologiaAttivita);
		at.setEmail(fake.internet().emailAddress().toLowerCase());
		at.setTelefono(fake.phoneNumber().phoneNumber());
		at.setImmagine(imageUrl);
		at.setDescrizione(descrizione);
		at.setPrezzoMinimo(fake.number().numberBetween(50L, 500L));

		return at;
	}

	@Bean("AttivitaRicettivaCustomBean")
	@Scope("prototype")
	public AttivitaRicettiva nuovaAttivitaRicettivaCustom() {
		AttivitaRicettiva at = new AttivitaRicettiva();

		return new AttivitaRicettiva();
	}

}
