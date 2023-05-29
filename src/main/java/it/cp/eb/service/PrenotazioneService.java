//package it.cp.eb.service;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import it.cp.eb.auth.entity.User;
//import it.cp.eb.model.Prenotazione;
//import it.cp.eb.repository.PrenotazioneRepository;
//
//@Service
//public class PrenotazioneService {
//
//    private final PrenotazioneRepository prenotazioneRepository;
//
//    @Autowired
//    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
//        this.prenotazioneRepository = prenotazioneRepository;
//    }
//
//    public List<Prenotazione> trovaTutteLePrenotazioni() {
//        return (List<Prenotazione>) prenotazioneRepository.findAll();
//    }
//
//    public Prenotazione getPrenotazione(Long id) {
//        return prenotazioneRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Prenotazione non trovata: " + id));
//    }
//
//    public Prenotazione creaPrenotazione(Prenotazione prenotazione) {
//        return prenotazioneRepository.save(prenotazione);
//    }
//
//    public String cancellaPrenotazione(Long id) {
//        prenotazioneRepository.deleteById(id);
//        return "Prenotazione cancellata con successo";
//    }
//
////    public Prenotazione modificaPrenotazione(Long id, Prenotazione prenotazione) {
////        Prenotazione prenotazione = getPrenotazione(id);
////        prenotazione.setSomeProperty(prenotazione.getSomeProperty());
////        // Set other properties as needed
////        return prenotazioneRepository.save(prenotazione);
////    }
//}
