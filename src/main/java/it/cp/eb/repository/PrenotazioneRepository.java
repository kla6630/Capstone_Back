//package it.cp.eb.repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.stereotype.Repository;
//
//import it.cp.eb.model.Prenotazione;
//import it.cp.eb.auth.entity.User;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//@Repository
//public interface PrenotazioneRepository extends PagingAndSortingRepository<Prenotazione, Long> {
//
//	List<Prenotazione> findAllByUserAndDataPrenotata(User user, LocalDate dataPrenotata);
//
//	Page<Prenotazione> findByUser(User user, Pageable pageable);
//
//	Page<Prenotazione> findByDataPrenotata(LocalDate dataPrenotata, Pageable pageable);
//	
//	List<Prenotazione> findAll(User user);
//}
