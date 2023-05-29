//package it.cp.eb.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import it.cp.eb.model.Prenotazione;
//import it.cp.eb.service.PrenotazioneService;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/prenotazioni")
//public class PrenotazioneController {
//
//    private final PrenotazioneService prenotazioneService;
//
//    @Autowired
//    public PrenotazioneController(PrenotazioneService prenotazioneService) {
//        this.prenotazioneService = prenotazioneService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Prenotazione>> trovaTutteLePrenotazioni() {
//        List<Prenotazione> prenotazioni = prenotazioneService.trovaTutteLePrenotazioni();
//        return ResponseEntity.ok(prenotazioni);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Prenotazione> trovaPrenotazione(@PathVariable Long id) {
//        Prenotazione prenotazione = prenotazioneService.getPrenotazione(id);
//        return ResponseEntity.ok(prenotazione);
//    }
//
//    @PostMapping
//    public ResponseEntity<Prenotazione> creaPrenotazione(@RequestBody Prenotazione prenotazione) {
//        Prenotazione createdPrenotazione = prenotazioneService.creaPrenotazione(prenotazione);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdPrenotazione);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> cancellaPrenotazione(@PathVariable Long id) {
//        String message = prenotazioneService.cancellaPrenotazione(id);
//        return ResponseEntity.ok(message);
//    }
//
////    @PutMapping("/{id}")
////    public ResponseEntity<Prenotazione> modificaPrenotazione(
////            @PathVariable Long id, @RequestBody Prenotazione prenotazione) {
////        Prenotazione updatedPrenotazione = prenotazioneService.modificaPrenotazione(id, prenotazione);
////        return ResponseEntity.ok(updatedPrenotazione);
////    }
//}
