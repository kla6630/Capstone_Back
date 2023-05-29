package it.cp.eb.runner;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.cp.eb.model.AttivitaRicettiva;
import it.cp.eb.service.AttivitaRicettivaService;
import it.cp.eb.auth.entity.User;
import it.cp.eb.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Component
public class Runner implements ApplicationRunner {

	@Autowired
	UserService userService;

	@Autowired
	@Qualifier("UserAdminBean")
	ObjectProvider<User> userAdminBeanProvider;

	@Autowired
	@Qualifier("UserFakeBean")
	ObjectProvider<User> userFakeBeanProvider;

	@Autowired
	AttivitaRicettivaService attivitaRicettivaService;

	@Autowired
	@Qualifier("AttivitaRicettivaFakeBean")
	ObjectProvider<AttivitaRicettiva> attivitaRicettivaFakeBeanProvider;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Applicazione Avviata");

//// creazione Attivita Ricettive fake in DB:
		for (int i = 0; i < 100; i++) {
			attivitaRicettivaService.creaAttivitaRicettiva(attivitaRicettivaFakeBeanProvider.getObject());
		}

////creazione user (utente) admin in DB:

//		userService.creaUser(userAdminBeanProvider.getObject());

////	creazione user (utente) fake in DB:
		for (int i = 0; i < 20; i++) {
			userService.creaUser(userFakeBeanProvider.getObject());
		}
	}

}
