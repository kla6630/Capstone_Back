//package it.cp.eb.runner;
//
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import it.cp.eb.model.AttivitaRicettiva;
//import it.cp.eb.service.AttivitaRicettivaService;
//
//@Component
//public class AttivitaRicettivaRunner implements ApplicationRunner {
//
//    @Autowired
//    AttivitaRicettivaService attivitaRicettivaService;
//
//    @Autowired
//    @Qualifier("AttivitaRicettivaFakeBean")
//    ObjectProvider<AttivitaRicettiva> attivitaRicettivaFakeBeanProvider;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("Applicazione Avviata");
//
//        // creazione Attivita Ricettive fake in DB:
//		for (int i = 0; i < 100; i++) {
//			attivitaRicettivaService.creaAttivitaRicettiva(attivitaRicettivaFakeBeanProvider.getObject());
//	       }
//    }
//}
//
