package it.fiani.progettoTurni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fiani.progettoTurni.entity.Dipendente;

@Repository
public interface DipendenteRepository extends CrudRepository<Dipendente, Long> {

}
