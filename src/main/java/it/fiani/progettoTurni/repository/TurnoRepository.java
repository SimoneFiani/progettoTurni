package it.fiani.progettoTurni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fiani.progettoTurni.entity.Turno;

@Repository
public interface TurnoRepository extends CrudRepository<Turno, Long> {

}
