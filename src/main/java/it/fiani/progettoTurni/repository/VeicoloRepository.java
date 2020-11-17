package it.fiani.progettoTurni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fiani.progettoTurni.entity.Veicolo;

@Repository
public interface VeicoloRepository extends CrudRepository<Veicolo, Long> {

}
