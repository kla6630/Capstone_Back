package it.cp.eb.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.cp.eb.model.AttivitaRicettiva;

public interface AttivitaRicettivaPageableRepository extends PagingAndSortingRepository<AttivitaRicettiva, Long> {

}
