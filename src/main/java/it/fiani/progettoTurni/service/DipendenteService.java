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

	public void salvaDipendente(Dipendente dipendente) {
		dipendenteRepository.save(dipendente);
	}

	public Dipendente prelevaDipendente(Long idDipendente) {
		return dipendenteRepository.findById(idDipendente).get();
	}

	public void cancellaDipendente(Long idDipendente) {
		dipendenteRepository.deleteById(idDipendente);
	}

	public void modificaDipendente(Dipendente dipendente) {
		dipendenteRepository.save(dipendente);
	}

}
