package it.cp.eb.auth.configuration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Value;

import it.cp.eb.auth.entity.User;

@Configuration
public class UserConfiguration {

	@Value("${user.admin.username}")
	private String adminUsername;
	@Value("${user.admin.nome}")
	private String adminNome;
	@Value("${user.admin.cognome}")
	private String adminCognome;
	@Value("${user.admin.dataDiNascita}")
	private String adminDataDiNascita;
	@Value("${user.admin.indirizzo}")
	private String adminIndirizzo;
	@Value("${user.admin.email}")
	private String adminEmail;
	@Value("${user.admin.numeroDiTelefono}")
	private String adminNumeroDiTelefono;
	@Value("${user.admin.numeroDocumento}")
	private String adminNumeroDocumento;
	@Value("${user.admin.password}")
	private String adminPassword;

	@Bean("UserAdminBean")
	@Scope("singleton")
	public User nuovoUserAdmin() {
	    User a = new User();
		a.setNome(adminNome);
		a.setCognome(adminCognome);
		a.setDataDiNascita(adminDataDiNascita);
		a.setIndirizzo(adminIndirizzo);
		a.setEmail(adminEmail.toLowerCase());
		a.setNumeroDiTelefono(adminNumeroDiTelefono);
		a.setNumeroDocumento(adminNumeroDocumento);
		a.setPassword(adminPassword);
		a.setUsername(adminUsername);
		return a;
	}


	@Bean("UserFakeBean")
	@Scope("prototype")
	public User nuovoUserFake() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		User u = new User();
		// Random random = new Random();

		// FAKE DATA DI NASCITA
		long minBirthDate = -946771200000L; // 01-01-1900 in millisecondi
		long maxBirthDate = System.currentTimeMillis(); // Data attuale in millisecondi
		Date birthDate = new Date(fake.number().numberBetween(minBirthDate, maxBirthDate));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = sdf.format(birthDate);

		// FAKE DOCUMENTO
		String[] tipoDocumento = { "Carta d'Identità", "Passaporto", "Patente" };
		String tipoDocumentoCasuale = tipoDocumento[fake.random().nextInt(tipoDocumento.length)];
		String lettereCasuali = fake.regexify("[A-Z]{2}");
		String numeroCasuale = fake.numerify("##########");

		String fakeDocumento = tipoDocumentoCasuale + " n°: " + lettereCasuali + numeroCasuale;

		u.setNome(fake.name().firstName());
		u.setCognome(fake.name().lastName());
		u.setDataDiNascita(formattedDate);
		u.setIndirizzo(fake.address().streetAddress());
		u.setEmail((u.getNome() + "." + u.getCognome() + (fake.number().numberBetween(0, 99)) + "@fakemail.com")
				.toLowerCase());
		u.setNumeroDiTelefono(fake.phoneNumber().phoneNumber());
		u.setNumeroDocumento(fakeDocumento);
		u.setPassword((fake.internet().password(6, 10, true, true)));
		u.setUsername(u.getEmail());
		return u;
	}

	@Bean("UserCustomBean")
	@Scope("prototype")
	public User nuovoUtenteCustom() {
		return new User();
	}

}
