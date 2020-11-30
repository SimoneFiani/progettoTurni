package it.fiani.progettoTurni.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fiani.progettoTurni.entity.Dipendente;
import it.fiani.progettoTurni.repository.DipendenteRepository;

@Service
public class DipendenteService {

	DipendenteRepository dipendenteRepository;

	@Autowired
	public DipendenteService(DipendenteRepository dipendenteRepository) {
		this.dipendenteRepository = dipendenteRepository;
	}

	public List<Dipendente> mostraListaDipendenti() {

		return (List<Dipendente>) dipendenteRepository.findAll();
	}

}
