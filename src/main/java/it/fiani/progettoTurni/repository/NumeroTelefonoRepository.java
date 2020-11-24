package it.fiani.progettoTurni.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.fiani.progettoTurni.entity.NumeroDiTelefono;

@Repository
public interface NumeroTelefonoRepository extends CrudRepository<NumeroDiTelefono, Long> {

}
